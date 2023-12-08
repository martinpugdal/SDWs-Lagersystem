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

public class PlastictankScene extends XScene {
    public PlastictankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 14: Plastictanke

        Label label81 = new Label("Plastictanke");
        label81.setTranslateX(0);
        label81.setTranslateY(150);
        label81.setFont(XStyle.XXL_FONT);
        label81.setTextFill(Color.BLACK);

        Label label82 = new Label("Her ses en oversigt over plastictanke");
        label82.setTranslateX(0);
        label82.setTranslateY(150);
        label82.setFont(XStyle.M_FONT);
        label82.setTextFill(Color.BLACK);

        ListView listView11 = new ListView<>();
        listView11.setTranslateX(20);
        listView11.setTranslateY(20);
        listView11.setPrefSize(200,200);

        ImageView imageView13 = XIcon.PLASTIKTANK.getImageView();
        imageView13.setFitHeight(100);
        imageView13.setFitWidth(100);
        imageView13.setTranslateX(10);
        imageView13.setTranslateY(-10);
        getLayout().getChildren().add(imageView13);

        Button button50 = new Button("Opret plastictank");
        button50.setTranslateX(-150);
        button50.setTranslateY(-280);
        button50.setPrefSize(250,45);
        button50.setOnAction(e -> getGUI().switchScene(SceneType.OPRETPLASTICTANK));
        button50.setFont(XStyle.M_FONT);
        button50.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button50.setCursor(Cursor.HAND);
        Tooltip tooltip95 = new Tooltip("Tryk her for at oprette en plastictank");
        button50.setTooltip(tooltip95);

        Button button51 = new Button("Rediger plastictank");
        button51.setTranslateX(-150);
        button51.setTranslateY(-280);
        button51.setPrefSize(250,45);
        button51.setOnAction(e -> getGUI().switchScene(SceneType.REDIGERPLASTICTANK));
        button51.setFont(XStyle.M_FONT);
        button51.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button51.setCursor(Cursor.HAND);
        Tooltip tooltip96 = new Tooltip("Tryk her for at redigere en plastictank");
        button51.setTooltip(tooltip96);

        Button button52 = new Button("Slet plastictank");
        button52.setTranslateX(-150);
        button52.setTranslateY(-280);
        button52.setPrefSize(250,45);
        button52.setFont(XStyle.M_FONT);
        button52.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button52.setCursor(Cursor.HAND);
        Tooltip tooltip97 = new Tooltip("Tryk her for at en plastictank");
        button52.setTooltip(tooltip97);

        Button button53 = new Button("Gå tilbage til forside");
        button53.setTranslateX(-150);
        button53.setTranslateY(-280);
        button53.setPrefSize(250,45);
        button53.setOnAction(e -> getGUI().gåTilForside());
        button53.setFont(XStyle.M_FONT);
        button53.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button53.setCursor(Cursor.HAND);
        Tooltip tooltip98 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button53.setTooltip(tooltip98);

        getLayout().getChildren().addAll(label81, label82, listView11, button50, button51, button52, button53);
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
