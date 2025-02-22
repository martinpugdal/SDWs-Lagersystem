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
    PLASTIKTANK("Plastic tank.png"),
    SALLWHISKY("SWD.png"),
    AFDELING("Afdeling.png"),
    WHISKYFLASKE("Whiskyflaske.png");

    private final ImageView imageView;

    XIcon(String filename) {
        this.imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/gui/asset/" + filename))));
    }

    public ImageView getImageView() {
        return new ImageView(imageView.getImage());
    }
}
