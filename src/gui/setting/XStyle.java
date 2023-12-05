package gui.setting;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class XStyle {

    public static final String PRIMARY_COLOR_STYLE = "-fx-background-color: moccasin";

    public static final Color PRIMARY_TEXT_COLOR = Color.BLACK;

    public static final String PRIMARY_BUTTON_STYLE = "-fx-background-color: black; -fx-text-fill: white;";

    public static final Font XXL_FONT = new Font("Calibri", 36);
    public static final Font XL_FONT = new Font("Calibri", 28);
    public static final Font L_FONT = new Font("Calibri", 20);
    public static final Font M_FONT = new Font("Calibri", 12);
    public static final Font S_FONT = new Font("Calibri", 10);

    public static void resize(ImageView imageView, double width, double height, boolean preserveRatio) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(preserveRatio);
    }

    public static void resize(ImageView imageView, double size) {
        resize(imageView, size, size, true);
    }
}
