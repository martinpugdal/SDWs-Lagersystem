package gui;

import application.controller.Controller;
import gui.scene.ForsideScene;
import gui.window.ForsideWindow;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Gui extends Application {

    private final ForsideWindow forsideWindow = new ForsideWindow();
    private Controller controller;

    @Override
    public void init() {
        controller = Controller.getController();
    }

    @Override
    public void start(Stage stage) throws Exception {
        forsideWindow.show();
        forsideWindow.setFullScreen(true);
        forsideWindow.setScene(new ForsideScene(this, new VBox()));
    }

    public double getScreenWidth() {
        return Screen.getPrimary().getBounds().getWidth() * 0.85;
    }

    public double getScreenHeight() {
        return Screen.getPrimary().getBounds().getHeight() * 0.85;
    }
}
