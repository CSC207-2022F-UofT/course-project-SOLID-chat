package client;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import emoji.Emoji;
import emoji.EmojiHandle;
import emoji.EmojiDisplay;
import stage.ControlledStage;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class EmojiSelectorController extends ControlledStage implements Initializable {
    @FXML
    private ScrollPane showScrollPane;
    @FXML
    private FlowPane showFlowPane;
    @FXML
    private TextField searchTextField;
    @FXML
    private ScrollPane searchScrollPane;
    @FXML
    private FlowPane searchFlowPane;

    // EmojiSelectorController对象
    private static EmojiSelectorController instance;

    private ChatController chatController = ChatController.getInstance();

    public EmojiSelectorController() {
        instance = this;
    }

    public static EmojiSelectorController getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIcon("images/icon_emoji.png");
        showScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        showFlowPane.setHgap(5);
        showFlowPane.setVgap(5);
        searchScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        searchFlowPane.setHgap(5);
        searchFlowPane.setVgap(5);
        searchTextField.textProperty().addListener(x -> {
            String text = searchTextField.getText();
            if (text.isEmpty() || text.length() < 2) {
                searchFlowPane.getChildren().clear();
                searchScrollPane.setVisible(false);
                showScrollPane.setVisible(true);
            } else {
                showScrollPane.setVisible(false);
                searchScrollPane.setVisible(true);
                List<Emoji> results = EmojiHandle.getInstance().search(text);
                searchFlowPane.getChildren().clear();
                results.forEach(emoji -> searchFlowPane.getChildren().add(addEmojiNodeListener(emoji)));
            }
        });
        init();
    }

    @FXML public void closeImgViewPressedAction() {
        closeLocalStage();
    }

    private void init() {
        Platform.runLater(() -> {
            showFlowPane.getChildren().clear();
            EmojiHandle.getInstance().getEmojiMap().values()
                    .forEach(emoji -> showFlowPane.getChildren().add(addEmojiNodeListener(emoji)));
            showScrollPane.requestFocus();
        });
    }


    private Node addEmojiNodeListener(Emoji emoji) {
        Node stackPane = EmojiDisplay.createEmojiNode(emoji, 32, 3);
        if (stackPane instanceof StackPane) {
            stackPane.setCursor(Cursor.HAND);
            ScaleTransition st = new ScaleTransition(Duration.millis(90), stackPane);
            Tooltip tooltip = new Tooltip(emoji.getShortname());
            Tooltip.install(stackPane, tooltip);
            stackPane.setOnMouseEntered(e -> {
                // stackPane.setStyle("-fx-background-color: #a6a6a6;
                // -fx-background-radius: 3;");
                stackPane.setEffect(new DropShadow());
                st.setToX(1.2);
                st.setToY(1.2);
                st.playFromStart();
                if (searchTextField.getText().isEmpty())
                    searchTextField.setPromptText(emoji.getShortname());
            });
            stackPane.setOnMouseExited(e -> {
                // stackPane.setStyle("");
                stackPane.setEffect(null);
                st.setToX(1.);
                st.setToY(1.);
                st.playFromStart();
            });
            stackPane.setOnMouseClicked(e -> {
                String shortname = emoji.getShortname();
                chatController.getMessageBoxTextArea().appendText(shortname);
                if (getLocalStage().isShowing()) {
                    closeLocalStage();
                }
            });
        }
        return stackPane;
    }
