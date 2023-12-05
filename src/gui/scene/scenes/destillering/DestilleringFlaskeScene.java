package gui.scene.scenes.destillering;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DestilleringFlaskeScene extends XScene {

    public DestilleringFlaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 7: Tilføj destillering til flaske

        Label label33 = new Label("Tilføj destillering til flaske");
        label33.setTranslateX(0);
        label33.setTranslateY(150);
        label33.setFont(new Font("Arial",36));
        label33.setTextFill(Color.BLACK);

        Label label34 = new Label("Hæld fra fad eller tank til flaske her");
        label34.setTranslateX(0);
        label34.setTranslateY(150);
        label34.setFont(new Font("Arial",16));
        label34.setTextFill(Color.BLACK);

        Label label35 = new Label("Fra fad:");
        label35.setTranslateX(0);
        label35.setTranslateY(150);
        label35.setFont(new Font("Arial",16));
        label35.setTextFill(Color.BLACK);

        Label label36 = new Label("Fra tank:");
        label36.setTranslateX(0);
        label36.setTranslateY(150);
        label36.setFont(new Font("Arial",16));
        label36.setTextFill(Color.BLACK);

        Label label37 = new Label("Til flaske:");
        label37.setTranslateX(0);
        label37.setTranslateY(150);
        label37.setFont(new Font("Arial",16));
        label37.setTextFill(Color.BLACK);

        Label label38 = new Label("Antal liter der skal flyttes");
        label38.setTranslateX(0);
        label38.setTranslateY(150);
        label38.setFont(new Font("Arial",16));
        label38.setTextFill(Color.BLACK);

        TextField textField11 = new TextField();
        textField11.setMaxWidth(100);
        Tooltip tooltip37 = new Tooltip();
        tooltip37.setText("Indtast antal liter her");
        textField11.setTooltip(tooltip37);
        textField11.setCursor(Cursor.TEXT);

        ListView listView6 = new ListView<>();
        listView6.setTranslateX(20);
        listView6.setTranslateY(20);
        listView6.setPrefSize(200,200);

        ListView listView7 = new ListView<>();
        listView7.setTranslateX(20);
        listView7.setTranslateY(20);
        listView7.setPrefSize(200,200);

        ListView listView8 = new ListView<>();
        listView8.setTranslateX(20);
        listView8.setTranslateY(20);
        listView8.setPrefSize(200,200);

        ImageView imageView6 = XIcon.ALKOHOL.getImageView();
        imageView6.setFitHeight(100);
        imageView6.setFitWidth(100);
        imageView6.setTranslateX(10);
        imageView6.setTranslateY(-10);
        getLayout().getChildren().add(imageView6);

        Button button27 = new Button("Flyt destillering");
        button27.setTranslateX(-150);
        button27.setTranslateY(-280);
        button27.setPrefSize(250,45);
        button27.setOnAction(e -> getGUI().switchScene(this));
        button27.setFont(new Font("Arial",16));
        button27.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button27.setCursor(Cursor.HAND);
        Tooltip tooltip38 = new Tooltip("Tryk her for at flytte destilleringsvæsken");
        button27.setTooltip(tooltip38);

        Button button28 = new Button("Annuller");
        button28.setTranslateX(-150);
        button28.setTranslateY(-280);
        button28.setPrefSize(250,45);
        button28.setOnAction(e -> getGUI().switchScene(this));
        button28.setFont(new Font("Arial",16));
        button28.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button28.setCursor(Cursor.HAND);
        Tooltip tooltip39 = new Tooltip("Tryk her for at annullere");
        button28.setTooltip(tooltip39);

        Button button29 = new Button("Gå tilbage til forside");
        button29.setTranslateX(-150);
        button29.setTranslateY(-280);
        button29.setPrefSize(250,45);
        button29.setOnAction(e -> getGUI().gåTilForside());
        button29.setFont(new Font("Arial",16));
        button29.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button29.setCursor(Cursor.HAND);
        Tooltip tooltip40 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button29.setTooltip(tooltip40);

        getLayout().getChildren().addAll(label33, label34, label35, label36, label37, label38, textField11, listView6, listView7, listView8, button27, button28, button29);

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
