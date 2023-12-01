package gui.window;

import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ForsideWindow extends Stage {

    public ForsideWindow() {
        this.initStyle(StageStyle.DECORATED);
        this.initModality(Modality.WINDOW_MODAL);
    }
}
