package gui.setting;

import gui.GUI;
import javafx.scene.Scene;

public abstract class XScene extends Scene {

    private final GUI gui;

    public XScene(GUI gui) {
        super(new XLayout());
        this.gui = gui;
        initLayout();
    }

    public abstract void initLayout();

    public XLayout getLayout() {
        return (XLayout) getRoot();
    }

    public void update() {
    }

    public GUI getGUI() {
        return gui;
    }

    public abstract String getTitle();

    public abstract XIcon getIcon();
}
