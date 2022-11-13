package stage;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControlledStage {
    private StageController myController;
    //StageID
    private String myStageUIID;


    public void setStageController(StageController stageController){
        this.myController = stageController;
    }

    public void setStageName(String stageUIID){
        this.myStageUIID = stageUIID;
    }

    public Stage getLocalStage(){
        return myController.getStage(myStageUIID);
    }


    public Stage getStage(String stage){
        return myController.getStage(stage);
    }

    public void changeStage(String stage) {
        Platform.runLater(() ->{
            myController.showStage(stage, myStageUIID);
        });
    }

    public void openStage(String stage) {
        Platform.runLater(() ->{
            myController.showStage(stage);
        });

    }

    public void closeStage(String stage) {
        Platform.runLater(() ->{
            myController.closeStage(stage);
        });
    }


    public void closeLocalStage(){
        Platform.runLater(() ->{
            myController.closeStage(myStageUIID);
        });
    }



    public void setStagePos(String stage, double X, double Y) {
        myController.getStage(stage).setX(X);
        myController.getStage(stage).setY(Y);
    }

    public void setIcon(String path){
        Platform.runLater(() ->{
            myController.getStage(myStageUIID).getIcons().add(new Image(path));
        });
    }


}

