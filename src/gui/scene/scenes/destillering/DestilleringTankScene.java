package gui.scene.scenes.destillering;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DestilleringTankScene extends XScene {
    public DestilleringTankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 6: Tilføj/fjern destillering til/fra tank

        Label label28 = new Label("Tilføj/fjern destillering til/fra tank");
        label28.setTranslateX(0);
        label28.setTranslateY(150);
        label28.setFont(new Font("Arial", 36));
        label28.setTextFill(Color.BLACK);

        Label label29 = new Label("Omhæld fra tank til tank her");
        label29.setTranslateX(0);
        label29.setTranslateY(150);
        label29.setFont(new Font("Arial", 16));
        label29.setTextFill(Color.BLACK);

        Label label30 = new Label("Fra tank:");
        label30.setTranslateX(0);
        label30.setTranslateY(150);
        label30.setFont(new Font("Arial", 16));
        label30.setTextFill(Color.BLACK);

        Label label31 = new Label("Til tank:");
        label31.setTranslateX(0);
        label31.setTranslateY(150);
        label31.setFont(new Font("Arial", 16));
        label31.setTextFill(Color.BLACK);

        Label label32 = new Label("Antal liter der skal flyttes");
        label32.setTranslateX(0);
        label32.setTranslateY(150);
        label32.setFont(new Font("Calibri", 12));
        label32.setTextFill(Color.BLACK);

        TextField textField10 = new TextField();
        textField10.setMaxWidth(100);
        Tooltip tooltip33 = new Tooltip();
        tooltip33.setText("Indtast antal liter her");
        textField10.setTooltip(tooltip33);
        textField10.setCursor(Cursor.TEXT);

        ListView listView4 = new ListView<>();
        listView4.setTranslateX(20);
        listView4.setTranslateY(20);
        listView4.setPrefSize(200, 200);

        ListView listView5 = new ListView<>();
        listView5.setTranslateX(20);
        listView5.setTranslateY(20);
        listView5.setPrefSize(200, 200);

        ImageView imageView5 = XIcon.ALKOHOL.getImageView();
        imageView5.setFitHeight(100);
        imageView5.setFitWidth(100);
        imageView5.setTranslateX(10);
        imageView5.setTranslateY(-10);
        getLayout().getChildren().add(imageView5);

        Button button24 = new Button("Flyt destillering");
        button24.setTranslateX(-150);
        button24.setTranslateY(-280);
        button24.setPrefSize(250, 45);
        button24.setOnAction(e -> getGUI().switchScene(this)); //TODO:
        button24.setFont(new Font("Arial", 16));
        button24.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button24.setCursor(Cursor.HAND);
        Tooltip tooltip34 = new Tooltip("Tryk her for at flytte destilleringsvæsken");
        button24.setTooltip(tooltip34);

        Button button25 = new Button("Annuller");
        button25.setTranslateX(-150);
        button25.setTranslateY(-280);
        button25.setPrefSize(250, 45);
        button25.setOnAction(e -> getGUI().switchScene(this)); //TODO:
        button25.setFont(new Font("Arial", 16));
        button25.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button25.setCursor(Cursor.HAND);
        Tooltip tooltip35 = new Tooltip("Tryk her for at annullere");
        button25.setTooltip(tooltip35);

        Button button26 = new Button("Gå til forside");
        button26.setTranslateX(-150);
        button26.setTranslateY(-280);
        button26.setPrefSize(250, 45);
        button26.setOnAction(e -> getGUI().gåTilForside());
        button26.setFont(new Font("Arial", 16));
        button26.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button26.setCursor(Cursor.HAND);
        Tooltip tooltip36 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button26.setTooltip(tooltip36);

        getLayout().getChildren().addAll(label28, label29, label30, label31, label32, textField10, listView4, listView5, button24, button25, button26);
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
