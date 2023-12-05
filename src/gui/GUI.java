package gui;

import application.controller.Controller;
import gui.scene.SceneManager;
import gui.scene.SceneType;
import gui.scene.scenes.ForsideScene;
import gui.setting.XScene;
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI extends Application {

    private final Controller controller = Controller.getController();
    private Stage stage;
    private XScene nuværendeScene;
    private final SceneManager sceneManager = new SceneManager(this);

    @Override
    public void init() {
        controller.initStorage();
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

    private double getScreenWidth() {
        return Screen.getPrimary().getBounds().getWidth() * 0.85;
    }

    private double getScreenHeight() {
        return Screen.getPrimary().getBounds().getHeight() * 0.85;
    }

    public void switchScene(XScene scene) {
        nuværendeScene = scene;
        stage.setScene(scene);
        stage.setTitle(scene.getTitle() != null ? scene.getTitle() : sceneManager.getScene(SceneType.FORSIDE).getTitle());
        if (scene.getIcon() != null) {
            if (stage.getIcons().isEmpty()) {
                stage.getIcons().add(scene.getIcon().getImageView().getImage());
            } else {
                stage.getIcons().set(0, scene.getIcon().getImageView().getImage() );
            }
        }
    }

    public void switchScene(SceneType sceneType) {
        switchScene(sceneManager.getScene(sceneType));
    }

    public void gåTilForside() {
        switchScene(sceneManager.getScene(SceneType.FORSIDE));
    }
}
