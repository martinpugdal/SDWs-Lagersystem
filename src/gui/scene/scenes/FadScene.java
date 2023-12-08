package gui.scene.scenes;

import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FadScene extends XScene {
    public FadScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 11: Fade

        Label label53 = new Label("Fade");
        label53.setTranslateX(0);
        label53.setTranslateY(150);
        label53.setFont(XStyle.XXL_FONT);
        label53.setTextFill(Color.BLACK);

        Label label54 = new Label("Her ses en oversigt over fade");
        label54.setTranslateX(0);
        label54.setTranslateY(150);
        label54.setFont(XStyle.M_FONT);
        label54.setTextFill(Color.BLACK);

        ListView listView10 = new ListView<>();
        listView10.setTranslateX(20);
        listView10.setTranslateY(20);
        listView10.setPrefSize(200,200);

        ImageView imageView10 = XIcon.FAD.getImageView();
        imageView10.setFitHeight(100);
        imageView10.setFitWidth(100);
        imageView10.setTranslateX(10);
        imageView10.setTranslateY(-10);
        getLayout().getChildren().add(imageView10);

        Button button40 = new Button("Opret fad");
        button40.setTranslateX(-150);
        button40.setTranslateY(-280);
        button40.setPrefSize(250,45);
        button40.setOnAction(e -> getGUI().switchScene(SceneType.OPRETFAD));
        button40.setFont(XStyle.M_FONT);
        button40.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button40.setCursor(Cursor.HAND);
        Tooltip tooltip61 = new Tooltip("Tryk her for at oprette et nyt fad");
        button40.setTooltip(tooltip61);

        Button button41 = new Button("Rediger fad");
        button41.setTranslateX(-150);
        button41.setTranslateY(-280);
        button41.setPrefSize(250,45);
        button41.setOnAction(e -> getGUI().switchScene(SceneType.REDIGERFAD));
        button41.setFont(XStyle.M_FONT);
        button41.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button41.setCursor(Cursor.HAND);
        Tooltip tooltip62 = new Tooltip("Tryk her for at redigere et fad");
        button41.setTooltip(tooltip62);

        Button button42 = new Button("Slet fad");
        button42.setTranslateX(-150);
        button42.setTranslateY(-280);
        button42.setPrefSize(250,45);
        button42.setFont(XStyle.M_FONT);
        button42.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button42.setCursor(Cursor.HAND);
        Tooltip tooltip63 = new Tooltip("Tryk her for at slette et fad");
        button42.setTooltip(tooltip63);

        Button button43 = new Button("Gå tilbage til forside");
        button43.setTranslateX(-150);
        button43.setTranslateY(-280);
        button43.setPrefSize(250,45);
        button43.setOnAction(e -> getGUI().gåTilForside());
        button43.setFont(XStyle.M_FONT);
        button43.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button43.setCursor(Cursor.HAND);
        Tooltip tooltip64 = new Tooltip("Tryk her for at gå til forsiden");
        button43.setTooltip(tooltip64);

        getLayout().getChildren().addAll(label53, label54, listView10, button40, button41, button42, button43);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public XIcon getIcon() {
        return null;
    }
}
