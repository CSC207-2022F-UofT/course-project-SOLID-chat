package stage;

import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageController {
    private static final Logger logger = LoggerFactory.getLogger(StageController.class);
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();;

    public void addStage(String name, Stage stage) {
        stages.put(name, stage);
    }

    public void addPrimaryStage(Stage primaryStage) {
        this.addStage("primaryStage", primaryStage);
    }

    public Stage getPrimaryStage() {
        return stages.get("primaryStage");
    }

    public Stage getStage(String name) {
        return stages.get(name);
    }



    public boolean loadStage(String name, String resourse, boolean isModality, StageStyle... styles) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(resourse));
            // FXMLLoader loader = new
            // FXMLLoader(getClass().getResource(resourse));
            Parent root;
            root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            if (isModality) {
                stage.initModality(Modality.APPLICATION_MODAL);
            }


            ControlledStage controlledStage = (ControlledStage) loader.getController();
            controlledStage.setStageController(this);
            controlledStage.setStageName(name);
            for (StageStyle style : styles) {
                stage.initStyle(style);
            }

            logger.debug("{} is creating..", name);

            this.addStage(name, stage);

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unloadStage(String name) {
        if (stages.remove(name) == null) {
            logger.debug("{} is not existing!", name);
            return false;
        } else {
            logger.debug("{} is destroying..", name);
            return true;
        }
    }

    public boolean showStage(String name) {
        this.getStage(name).show();
        logger.debug("{} is showing..", name);
        return true;
    }

    public boolean showStage(String show, String close) {
        closeStage(close);
        this.getStage(show).show();
        logger.debug("{} is showing..", show);
        return true;
    }

    public boolean closeStage(String name) {
        getStage(name).close();
        logger.debug("{} is closing..", name);
        return true;
    }

    public boolean isShowingStage(String name) {
        if (getStage(name).isShowing()) {
            return true;
        } else {
            return false;
        }
    }

}
