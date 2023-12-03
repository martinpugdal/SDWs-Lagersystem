package gui.setting;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public enum XIcon {

    ALKOHOL("Alkohol.png"),
    DESTILLERING("Destilleri.png"),
    ENEBÆR("Enebær.png"),
    FAD("Fad.png"),
    GINFLASKE("Ginflaske.png"),
    KORIANDERFRØ("Korianderfrø.png"),
    LAGER("Lager.png"),
    PLASTIK_TANK("Plastic tank.png"),
    TILBAGE("Back.png"),
    WHISKYFLASKE("Whiskyflaske.png");

    private final ImageView imageView;

    XIcon(String filename) {
        this.imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/gui/asset/" + filename))));
    }

    public ImageView getImageView() {
        return imageView;
    }
}
