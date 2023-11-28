package gui;

import gui.window.StartsideWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Gui extends Application {

    private final StartsideWindow startsideWindow = new StartsideWindow();

    @Override
    public void start(Stage stage) throws Exception {
        startsideWindow.show();
    }
}
