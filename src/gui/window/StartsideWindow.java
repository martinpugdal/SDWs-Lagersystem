package gui.window;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartsideWindow extends Stage {


    public StartsideWindow() {
        this.initStyle(StageStyle.DECORATED);
        this.initModality(Modality.WINDOW_MODAL);
    }
}
