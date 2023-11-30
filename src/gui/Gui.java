package gui;

import application.controller.Controller;
import gui.window.StartsideWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Gui extends Application {

    private final StartsideWindow startsideWindow = new StartsideWindow();
    private final Controller controller = Controller.getController();

    @Override
    public void init() {
        controller.initStorage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        startsideWindow.show();
    }
}
