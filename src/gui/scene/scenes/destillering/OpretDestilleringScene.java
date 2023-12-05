package gui.scene.scenes.destillering;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OpretDestilleringScene extends XScene {


    public OpretDestilleringScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 3: Opret destillering

        Label label11 = new Label("Opret destillering");
        label11.setTranslateX(0);
        label11.setTranslateY(150);
        label11.setFont(new Font("Arial", 36));
        label11.setTextFill(Color.BLACK);

        Label label12 = new Label("Her kan der oprettes destilleringsvæsker");
        label12.setTranslateX(0);
        label12.setTranslateY(150);
        label12.setFont(new Font("Arial", 16));
        label12.setTextFill(Color.BLACK);

        Label label13 = new Label("Nummer");
        label13.setTranslateX(0);
        label13.setTranslateY(150);
        label13.setFont(new Font("Arial", 16));
        label13.setTextFill(Color.BLACK);

        Label label14 = new Label("Navn");
        label14.setTranslateX(0);
        label14.setTranslateY(150);
        label14.setFont(new Font("Arial", 16));
        label14.setTextFill(Color.BLACK);

        Label label15 = new Label("Antal liter");
        label15.setTranslateX(0);
        label15.setTranslateY(150);
        label15.setFont(new Font("Arial", 16));
        label15.setTextFill(Color.BLACK);

        Label label16 = new Label("Alkoholprocent");
        label16.setTranslateX(0);
        label16.setTranslateY(150);
        label16.setFont(new Font("Arial", 16));
        label16.setTextFill(Color.BLACK);

        TextField textField1 = new TextField();
        textField1.setMaxWidth(100);
        Tooltip tooltip15 = new Tooltip();
        tooltip15.setText("Indtast nummer på destilleringsvæsken her");
        textField1.setTooltip(tooltip15);
        textField1.setCursor(Cursor.TEXT);

        TextField textField2 = new TextField();
        textField2.setMaxWidth(100);
        Tooltip tooltip16 = new Tooltip();
        tooltip16.setText("Indtast navnet på destilleringsvæsken her");
        textField2.setTooltip(tooltip16);
        textField2.setCursor(Cursor.TEXT);

        TextField textField3 = new TextField();
        textField3.setMaxWidth(100);
        Tooltip tooltip17 = new Tooltip();
        tooltip17.setText("Indtast antallet af liter her");
        textField3.setTooltip(tooltip17);
        textField3.setCursor(Cursor.TEXT);

        TextField textField4 = new TextField();
        textField4.setMaxWidth(100);
        Tooltip tooltip18 = new Tooltip();
        tooltip18.setText("Indtast alkoholprocenten her");
        textField4.setTooltip(tooltip18);
        textField4.setCursor(Cursor.TEXT);

        ImageView imageView2 = XIcon.ALKOHOL.getImageView();
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);
        imageView2.setTranslateX(10);
        imageView2.setTranslateY(-10);
        getLayout().getChildren().add(imageView2);

        Button button15 = new Button("Opret destillering");
        button15.setTranslateX(-150);
        button15.setTranslateY(-280);
        button15.setPrefSize(250, 45);
        button15.setOnAction(e -> getGUI().switchScene(this)); //TODO:
        button15.setFont(new Font("Arial", 16));
        button15.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button15.setCursor(Cursor.HAND);
        Tooltip tooltip19 = new Tooltip("Tryk her for at oprette destilleringsvæsken");
        button15.setTooltip(tooltip19);

        Button button16 = new Button();
        button16.setTranslateX(-150);
        button16.setTranslateY(-280);
        button16.setPrefSize(250, 45);
        button16.setOnAction(e -> getGUI().switchScene(this)); //TODO:
        button16.setFont(new Font("Arial", 16));
        button16.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button16.setCursor(Cursor.HAND);
        Tooltip tooltip20 = new Tooltip("Tryk her for at annullere");
        button16.setTooltip(tooltip20);

        Button button17 = new Button();
        button17.setTranslateX(-150);
        button17.setTranslateY(-280);
        button17.setPrefSize(250, 45);
        button17.setOnAction(e -> getGUI().gåTilForside());
        button17.setFont(new Font("Arial", 16));
        button17.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button17.setCursor(Cursor.HAND);
        Tooltip tooltip21 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button17.setTooltip(tooltip21);

        getLayout().getChildren().addAll(label11, label12, label13, label14, label15, label16, textField1, textField2, textField3, textField4, button15, button16, button17);
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
