package gui.window;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DefaultWindow extends Stage {

    public DefaultWindow() {
        this.initStyle(StageStyle.DECORATED);
        this.initModality(Modality.WINDOW_MODAL);
    }
}
