package gui.scene;

import gui.Gui;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ForsideScene extends Scene {

    public ForsideScene(Gui gui, Parent parent) {
        super(parent, gui.getScreenWidth(), gui.getScreenHeight());
    }
}
