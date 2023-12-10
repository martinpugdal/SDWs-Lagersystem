package gui.scene.scenes.whiskyflaske;

import application.model.flaske.Whiskyflaske;
import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RedigerWhiskyflaskeScene extends XScene {
    public RedigerWhiskyflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 22: Rediger whiskyflaske

        Label label129 = new Label("Rediger whiskyflaske");
        label129.setTranslateX(0);
        label129.setTranslateY(150);
        label129.setFont(XStyle.XXL_FONT);
        label129.setTextFill(Color.BLACK);

        Label label130 = new Label("Nummer");
        label130.setTranslateX(0);
        label130.setTranslateY(150);
        label130.setFont(XStyle.M_FONT);
        label130.setTextFill(Color.BLACK);

        Label label131 = new Label("Navn");
        label131.setTranslateX(0);
        label131.setTranslateY(150);
        label131.setFont(XStyle.M_FONT);
        label131.setTextFill(Color.BLACK);

        Label label132 = new Label("Volumen");
        label132.setTranslateX(0);
        label132.setTranslateY(150);
        label132.setFont(XStyle.M_FONT);
        label132.setTextFill(Color.BLACK);

        TextField textField83 = new TextField();
        textField83.setMaxWidth(100);
        Tooltip tooltip159 = new Tooltip();
        tooltip159.setText("Indtast nummeret på whiskyflasken her");
        textField83.setTooltip(tooltip159);
        textField83.setCursor(Cursor.TEXT);

        TextField textField84 = new TextField();
        textField84.setMaxWidth(100);
        Tooltip tooltip160 = new Tooltip();
        tooltip160.setText("Indtast navnet på whiskyflasken her");
        textField84.setTooltip(tooltip160);
        textField84.setCursor(Cursor.TEXT);

        TextField textField85 = new TextField();
        textField85.setMaxWidth(100);
        Tooltip tooltip161 = new Tooltip();
        tooltip161.setText("Indtast antal liter her");
        textField85.setTooltip(tooltip161);
        textField85.setCursor(Cursor.TEXT);

        ImageView imageView21 = XIcon.WHISKYFLASKE.getImageView();
        imageView21.setFitHeight(100);
        imageView21.setFitWidth(100);
        imageView21.setTranslateX(10);
        imageView21.setTranslateY(-10);
        getLayout().getChildren().add(imageView21);

        Button button77 = new Button("Rediger whiskyflaske");
        button77.setTranslateX(-150);
        button77.setTranslateY(-280);
        button77.setPrefSize(250,45);
        button77.setOnAction(e -> getGUI().switchScene(this));
        button77.setFont(XStyle.M_FONT);
        button77.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button77.setCursor(Cursor.HAND);
        Tooltip tooltip162 = new Tooltip("Tryk her for at redigere whiskyflasken");
        button77.setTooltip(tooltip162);

        Button button78 = new Button();
        button78.setTranslateX(-150);
        button78.setTranslateY(-280);
        button78.setPrefSize(250,45);
        button78.setOnAction(e -> getGUI().switchScene(this));
        button78.setFont(XStyle.M_FONT);
        button78.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button78.setCursor(Cursor.HAND);
        Tooltip tooltip163 = new Tooltip("Tryk her for at annullere");
        button78.setTooltip(tooltip163);

        Button button79 = new Button("Gå tilbage til forside");
        button79.setTranslateX(-150);
        button79.setTranslateY(-280);
        button79.setPrefSize(250,45);
        button79.setOnAction(e -> getGUI().gåTilForside());
        button79.setFont(XStyle.M_FONT);
        button79.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button79.setCursor(Cursor.HAND);
        Tooltip tooltip164 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button79.setTooltip(tooltip164);

        getLayout().getChildren().addAll(label129, label130, label131, label132, textField83, textField84, textField85, button77, button78, button79);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public XIcon getIcon() {
        return null;
    }

    public void setSelectedWhiskyflaske(Whiskyflaske selectedItem) {
    }
}
