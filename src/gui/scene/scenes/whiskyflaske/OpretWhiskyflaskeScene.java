package gui.scene.scenes.whiskyflaske;

import application.model.Drikkelse;
import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OpretWhiskyflaskeScene extends XScene {
    public OpretWhiskyflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 21: Opret whiskyflaske

        Label label125 = new Label("Opret whiskyflaske");
        label125.setTranslateX(0);
        label125.setTranslateY(150);
        label125.setFont(XStyle.XXL_FONT);
        label125.setTextFill(Color.BLACK);

        Label label126 = new Label("Nummer");
        label126.setTranslateX(0);
        label126.setTranslateY(150);
        label126.setFont(XStyle.M_FONT);
        label126.setTextFill(Color.BLACK);

        Label label127 = new Label("Navn");
        label127.setTranslateX(0);
        label127.setTranslateY(150);
        label127.setFont(XStyle.M_FONT);
        label127.setTextFill(Color.BLACK);

        Label label128 = new Label("Volumen");
        label128.setTranslateX(0);
        label128.setTranslateY(150);
        label128.setFont(XStyle.M_FONT);
        label128.setTextFill(Color.BLACK);

        TextField textField80 = new TextField();
        textField80.setMaxWidth(100);
        Tooltip tooltip153 = new Tooltip();
        tooltip153.setText("Indtast nummeret på whiskyflasken her");
        textField80.setTooltip(tooltip153);
        textField80.setCursor(Cursor.TEXT);

        TextField textField81 = new TextField();
        textField81.setMaxWidth(100);
        Tooltip tooltip154 = new Tooltip();
        tooltip154.setText("Indtast navnet på flasken her");
        textField81.setTooltip(tooltip154);
        textField81.setCursor(Cursor.TEXT);

        TextField textField82 = new TextField();
        textField82.setMaxWidth(100);
        Tooltip tooltip155 = new Tooltip();
        tooltip155.setText("Indtast antal liter her");
        textField82.setTooltip(tooltip155);
        textField82.setCursor(Cursor.TEXT);

        ImageView imageView20 = XIcon.WHISKYFLASKE.getImageView();
        imageView20.setFitHeight(100);
        imageView20.setFitWidth(100);
        imageView20.setTranslateX(10);
        imageView20.setTranslateY(-10);
        getLayout().getChildren().add(imageView20);

        Button button74 = new Button("Opret whiskyflaske");
        button74.setTranslateX(-150);
        button74.setTranslateY(-280);
        button74.setPrefSize(250,45);
        button74.setOnAction(e -> opretWhiskyFlaske(textField80.getText(), textField81.getText(), textField82.getText(), textField82.getText()));
        button74.setFont(XStyle.M_FONT);
        button74.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button74.setCursor(Cursor.HAND);
        Tooltip tooltip156 = new Tooltip("Tryk her for at oprette whiskyflasken");
        button74.setTooltip(tooltip156);

        Button button75 = new Button("Annuller");
        button75.setTranslateX(-150);
        button75.setTranslateY(-280);
        button75.setPrefSize(250,45);
        button75.setOnAction(e -> getGUI().switchScene(this));
        button75.setFont(XStyle.M_FONT);
        button75.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button75.setCursor(Cursor.HAND);
        Tooltip tooltip157 = new Tooltip("Tryk her for at annullere");
        button75.setTooltip(tooltip157);

        Button button76 = new Button("Gå tilbage til forside");
        button76.setTranslateX(-150);
        button76.setTranslateY(-280);
        button76.setPrefSize(250,45);
        button76.setOnAction(e -> getGUI().gåTilForside());
        button76.setFont(XStyle.M_FONT);
        button76.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button76.setCursor(Cursor.HAND);
        Tooltip tooltip158 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button76.setTooltip(tooltip158);

        getLayout().getChildren().addAll(label125, label126, label127, label128, textField80, textField81, textField82, button74, button75, button76);
    }

    private void opretWhiskyFlaske(String nummer, String navn, String volumen, String antal) {
        if (nummer.isEmpty() || navn.isEmpty() || volumen.isEmpty() || antal.isEmpty()) {
            Alert alert = getGUI().alert("Fejl", "Udfyld alle felter", "Alle felter skal udfyldes", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        int nummerInt;
        try {
            nummerInt = Integer.parseInt(nummer);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Nummer skal være et tal", "Nummer skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        double volumenDouble;
        try {
            volumenDouble = Double.parseDouble(volumen);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Volumen skal være et tal", "Volumen skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        int antalInt;
        try {
            antalInt = Integer.parseInt(antal);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Antal skal være et tal", "Antal skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        try {
            getGUI().getController().createFlaske(Drikkelse.WHISKY, nummerInt, navn, volumenDouble, antalInt);
        } catch (IllegalArgumentException e) {
            Alert alert = getGUI().alert("Fejl", "Nummeret er allerede i brug", "Nummeret er allerede i brug", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
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
