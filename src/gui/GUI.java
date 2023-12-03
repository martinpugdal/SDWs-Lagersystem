package gui;

import application.controller.Controller;
import gui.scene.ForsideScene;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI extends Application {

    private final Controller controller = Controller.getController();
    private Stage stage;
    private XScene nuværendeScene, forsideScene = new ForsideScene(this);

    @Override
    public void init() {
        controller.initStorage();
        nuværendeScene = forsideScene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
//        stage.setFullScreen(true);
        stage.setWidth(getScreenWidth());
        stage.setHeight(getScreenHeight());
        switchScene(nuværendeScene);
        stage.show();
    }

    private double getScreenWidth() {
        return Screen.getPrimary().getBounds().getWidth() * 0.85;
    }

    private double getScreenHeight() {
        return Screen.getPrimary().getBounds().getHeight() * 0.85;
    }

    public Scene getNuværendeScene() {
        return nuværendeScene;
    }

    public Scene getForsideScene() {
        return forsideScene;
    }

    public void switchScene(XScene scene) {
        stage.setScene(scene);
        stage.setTitle(scene.getTitle());
        if (!stage.getIcons().isEmpty()) {
            stage.getIcons().clear();
        }
        if (scene.getIcon() != null) {
            stage.getIcons().add(scene.getIcon().getImageView().getImage());
        } else {
            stage.getIcons().add(XIcon.LAGER.getImageView().getImage());
        }
    }

    public void gåTilForside() {
        switchScene(forsideScene);
    }
}
