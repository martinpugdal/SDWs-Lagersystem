package gui.setting;

import gui.GUI;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class XScene extends Scene {

    private final GUI gui;

    public XScene(Parent parent, GUI gui) {
        super(parent);
        this.gui = gui;
    }

    public GUI getGUI() {
        return gui;
    }

    public abstract String getTitle();

    public abstract XIcon getIcon();
}
