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

public class WhiskyflaskeScene extends XScene {
    public WhiskyflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 20: Whiskyflasker

        Label label123 = new Label("Whiskyflasker");
        label123.setTranslateX(0);
        label123.setTranslateY(150);
        label123.setFont(XStyle.XXL_FONT);
        label123.setTextFill(Color.BLACK);

        Label label124 = new Label("Her ses en oversigt over whiskyflasker registreret i systemet");
        label124.setTranslateX(0);
        label124.setTranslateY(150);
        label124.setFont(XStyle.M_FONT);
        label124.setTextFill(Color.BLACK);

        ListView listView13 = new ListView<>();
        listView13.setTranslateX(20);
        listView13.setTranslateY(20);
        listView13.setPrefSize(200,200);

        ImageView imageView19 = XIcon.WHISKYFLASKE.getImageView();
        imageView19.setFitHeight(100);
        imageView19.setFitWidth(100);
        imageView19.setTranslateX(10);
        imageView19.setTranslateY(-10);
        getLayout().getChildren().add(imageView19);

        Button button70 = new Button("Opret flaske");
        button70.setTranslateX(-150);
        button70.setTranslateY(-280);
        button70.setPrefSize(250,45);
        button70.setOnAction(e -> getGUI().switchScene(SceneType.OPRETWHISKYFLASKE));
        button70.setFont(XStyle.M_FONT);
        button70.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button70.setCursor(Cursor.HAND);
        Tooltip tooltip149 = new Tooltip("Tryk her for at oprette en whiskyflaske");
        button70.setTooltip(tooltip149);

        Button button71 = new Button("Rediger flaske");
        button71.setTranslateX(-150);
        button71.setTranslateY(-280);
        button71.setPrefSize(250,45);
        button71.setOnAction(e -> getGUI().switchScene(SceneType.REDIGERWHISKYFLASKE));
        button71.setFont(XStyle.M_FONT);
        button71.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button71.setCursor(Cursor.HAND);
        Tooltip tooltip150 = new Tooltip("Tryk her for at redigere en whiskyflaske");
        button71.setTooltip(tooltip150);

        Button button72 = new Button("Slet flaske");
        button72.setTranslateX(-150);
        button72.setTranslateY(-280);
        button72.setPrefSize(250,45);
        button72.setFont(XStyle.M_FONT);
        button72.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button72.setCursor(Cursor.HAND);
        Tooltip tooltip151 = new Tooltip("Tryk her for at slette en whiskyflaske");
        button72.setTooltip(tooltip151);

        Button button73 = new Button("Gå tilbage til forside");
        button73.setTranslateX(-150);
        button73.setTranslateY(-280);
        button73.setPrefSize(250,45);
        button73.setOnAction(e -> getGUI().gåTilForside());
        button73.setFont(XStyle.M_FONT);
        button73.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button73.setCursor(Cursor.HAND);
        Tooltip tooltip152 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button73.setTooltip(tooltip152);

        getLayout().getChildren().addAll(label123, label124, listView13, button70, button71, button72, button73);

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
