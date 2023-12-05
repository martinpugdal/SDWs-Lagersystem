package gui.scene.scenes;

import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GinflaskeScene extends XScene {
    public GinflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 23: Ginflasker

        Label label133 = new Label("Ginflasker");
        label133.setTranslateX(0);
        label133.setTranslateY(150);
        label133.setFont(new Font("Arial",36));
        label133.setTextFill(Color.BLACK);

        Label label134 = new Label("Her ses en oversigt over ginflasker i systemet");
        label134.setTranslateX(0);
        label134.setTranslateY(150);
        label134.setFont(new Font("Calibri",16));
        label134.setTextFill(Color.BLACK);

        ListView listView14 = new ListView<>();
        listView14.setTranslateX(20);
        listView14.setTranslateY(20);
        listView14.setPrefSize(200,200);

        ImageView imageView22 = XIcon.GINFLASKE.getImageView();
        imageView22.setFitHeight(100);
        imageView22.setFitWidth(100);
        imageView22.setTranslateX(10);
        imageView22.setTranslateY(-10);
        getLayout().getChildren().add(imageView22);

        Button button80 = new Button("Opret flaske");
        button80.setTranslateX(-150);
        button80.setTranslateY(-280);
        button80.setPrefSize(250,45);
        button80.setOnAction(e -> getGUI().switchScene(SceneType.OPRETGINFLASKE));
        button80.setFont(new Font("Arial",16));
        button80.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button80.setCursor(Cursor.HAND);
        Tooltip tooltip165 = new Tooltip("Tryk her for at oprette en ginflaske");
        button80.setTooltip(tooltip165);

        Button button81 = new Button("Rediger flaske");
        button81.setTranslateX(-150);
        button81.setTranslateY(-280);
        button81.setPrefSize(250,45);
        button81.setOnAction(e -> getGUI().switchScene(SceneType.REDIGERGINFLASKE));
        button81.setFont(new Font("Arial",16));
        button81.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button81.setCursor(Cursor.HAND);
        Tooltip tooltip166 = new Tooltip("Tryk her for at redigere en ginflaske");
        button81.setTooltip(tooltip166);

        Button button82 = new Button("Slet flaske");
        button82.setTranslateX(-150);
        button82.setTranslateY(-280);
        button82.setPrefSize(250,45);
        button82.setFont(new Font("Arial",16));
        button82.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button82.setCursor(Cursor.HAND);
        Tooltip tooltip167 = new Tooltip("Tryk her for at slette en ginflaske");
        button82.setTooltip(tooltip167);

        Button button83 = new Button("Gå tilbage til forside");
        button83.setTranslateX(-150);
        button83.setTranslateY(-280);
        button83.setPrefSize(250,45);
        button83.setOnAction(e -> getGUI().gåTilForside());
        button83.setFont(new Font("Arial",16));
        button83.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button83.setCursor(Cursor.HAND);
        Tooltip tooltip168 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button83.setTooltip(tooltip168);

        getLayout().getChildren().addAll(label133, label134, listView14, button80, button81, button82, button83);

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
