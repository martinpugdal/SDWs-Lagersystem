package gui;

import application.controller.Controller;
import gui.scene.SceneManager;
import gui.scene.SceneType;
import gui.setting.XScene;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI extends Application {

    private final Controller controller = Controller.getController();
    private Stage stage;
    private SceneManager sceneManager;

    @Override
    public void init() {
        controller.initStorage();
        sceneManager = new SceneManager(this);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
//        stage.setFullScreen(true);
        stage.setWidth(getScreenWidth());
        stage.setHeight(getScreenHeight());
        switchScene(sceneManager.getScene(SceneType.FORSIDE));
        stage.show();
    }

    public Controller getController() {
        return controller;
    }

    public double getScreenWidth() {
        double w = 1920;
        double primaryW = Screen.getPrimary().getBounds().getWidth();
        if (primaryW < w) {
            w = primaryW;
        }
        return w;
    }

    public double getScreenHeight() {
        double h = 1080;
        double primaryH = Screen.getPrimary().getBounds().getHeight();
        if (primaryH < h) {
            h = primaryH;
        }
        return h;
    }

    public void switchScene(XScene scene) {
        scene.update();
//        boolean isFullScreen = stage.isFullScreen();
        stage.setScene(scene);
//        stage.setFullScreen(isFullScreen);
        stage.setTitle(scene.getTitle() != null ? scene.getTitle() : sceneManager.getScene(SceneType.FORSIDE).getTitle());
        if (scene.getIcon() != null) {
            if (stage.getIcons().isEmpty()) {
                stage.getIcons().add(scene.getIcon().getImageView().getImage());
            } else {
                stage.getIcons().set(0, scene.getIcon().getImageView().getImage());
            }
        }
    }

    public void switchScene(SceneType sceneType) {
        switchScene(sceneManager.getScene(sceneType));
    }

    public XScene getScene(SceneType sceneType) {
        return sceneManager.getScene(sceneType);
    }

    public void gåTilForside() {
        switchScene(sceneManager.getScene(SceneType.FORSIDE));
    }

    public Alert alert(String title, String headerText, String contentText, Alert.AlertType alertType) {
        return sceneManager.alert(title, headerText, contentText, alertType);
    }
}
