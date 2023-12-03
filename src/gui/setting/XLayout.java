package gui.setting;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class XLayout extends VBox {

    public XLayout() {
        super();
        setAlignment(Pos.CENTER);
        setStyle(XStyle.PRIMARY_COLOR_STYLE);
    }

    public XLayout(Pos pos, String style) {
        super();
        setAlignment(pos);
        setStyle(style);
    }
}
