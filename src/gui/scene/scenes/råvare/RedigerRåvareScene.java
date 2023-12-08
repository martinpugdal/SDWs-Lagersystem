package gui.scene.scenes.råvare;

import application.model.Råvare;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class RedigerRåvareScene extends XScene {

    private Råvare selectedRåvare;
    private TextField textField17, textField18, textField19, textField20, textField21;

    public RedigerRåvareScene(GUI gui) {
        super(gui);
    }

    public void setSelectedRåvare(Råvare råvare) {
        selectedRåvare = råvare;
    }

    @Override
    public void initLayout() {
        //Skærmbillede 10: Rediger råvare

        Label label47 = new Label("Rediger råvare");
        label47.setTranslateX(0);
        label47.setTranslateY(150);
        label47.setFont(new Font("Arial", 36));
        label47.setTextFill(Color.BLACK);

        Label label48 = new Label("Navn");
        label48.setTranslateX(0);
        label48.setTranslateY(150);
        label48.setFont(new Font("Arial", 16));
        label48.setTextFill(Color.BLACK);

        Label label49 = new Label("Antal");
        label49.setTranslateX(0);
        label49.setTranslateY(150);
        label49.setFont(new Font("Arial", 16));
        label49.setTextFill(Color.BLACK);

        Label label50 = new Label("Liter");
        label50.setTranslateX(0);
        label50.setTranslateY(150);
        label50.setFont(new Font("Arial", 16));
        label50.setTextFill(Color.BLACK);

        Label label51 = new Label("Kilogram");
        label51.setTranslateX(0);
        label51.setTranslateY(150);
        label51.setFont(new Font("Arial", 16));
        label51.setTextFill(Color.BLACK);

        Label label52 = new Label("Bruges til");
        label52.setTranslateX(0);
        label52.setTranslateY(150);
        label52.setFont(new Font("Arial", 16));
        label52.setTextFill(Color.BLACK);

        textField17 = new TextField();
        textField17.setMaxWidth(100);
        Tooltip tooltip53 = new Tooltip();
        tooltip53.setText("Indtast navn på råvaren her");
        textField17.setTooltip(tooltip53);
        textField17.setCursor(Cursor.TEXT);

        textField18 = new TextField();
        textField18.setMaxWidth(100);
        Tooltip tooltip54 = new Tooltip();
        tooltip54.setText("Indtast antallet af råvaren her");
        textField18.setTooltip(tooltip54);
        textField18.setCursor(Cursor.TEXT);

        textField19 = new TextField();
        textField19.setMaxWidth(100);
        Tooltip tooltip55 = new Tooltip();
        tooltip55.setText("Indtast antal liter her");
        textField19.setTooltip(tooltip55);
        textField19.setCursor(Cursor.TEXT);

        textField20 = new TextField();
        textField20.setMaxWidth(100);
        Tooltip tooltip56 = new Tooltip();
        tooltip56.setText("Indtast antal kilo her");
        textField20.setTooltip(tooltip56);
        textField20.setCursor(Cursor.TEXT);

        textField21 = new TextField();
        textField21.setMaxWidth(100);
        Tooltip tooltip57 = new Tooltip();
        tooltip57.setText("Indtast numrene på hvilke produkter råvaren anvendes til (adskil med komma hvis flere)");
        textField21.setTooltip(tooltip57);
        textField21.setCursor(Cursor.TEXT);

        Button button37 = new Button("Rediger råvare");
        button37.setTranslateX(-150);
        button37.setTranslateY(-280);
        button37.setPrefSize(250, 45);
        button37.setOnAction(e -> redigerRåvare());
        button37.setFont(new Font("Arial", 16));
        button37.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button37.setCursor(Cursor.HAND);
        Tooltip tooltip58 = new Tooltip("Tryk her for at opdatere råvaren");
        button37.setTooltip(tooltip58);

        Button button38 = new Button("Tilbage til råvareoversigten");
        button38.setTranslateX(-150);
        button38.setTranslateY(-280);
        button38.setPrefSize(250, 45);
        button38.setOnAction(e -> getGUI().switchScene(SceneType.RÅVARE));
        button38.setFont(new Font("Arial", 16));
        button38.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button38.setCursor(Cursor.HAND);
        Tooltip tooltip59 = new Tooltip("Tryk her for at annullere og vende tilbage til oversigten");
        button38.setTooltip(tooltip59);

        Button button39 = new Button("Gå tilbage til forside");
        button39.setTranslateX(-150);
        button39.setTranslateY(-280);
        button39.setPrefSize(250, 45);
        button39.setOnAction(e -> getGUI().gåTilForside());
        button39.setFont(new Font("Arial", 16));
        button39.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button39.setCursor(Cursor.HAND);
        Tooltip tooltip60 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button39.setTooltip(tooltip60);

        getLayout().getChildren().addAll(label47, label48, label49, label50, label51, label52, textField17, textField18, textField19, textField20, textField21, button37, button38, button39);
    }

    @Override
    public void update() {
        textField17.setText(selectedRåvare.getType());
        textField18.setText(String.valueOf(selectedRåvare.getAntal()));
        textField19.setText(String.valueOf(selectedRåvare.getLiter()));
        textField20.setText(String.valueOf(selectedRåvare.getKilogram()));
        textField21.setText(selectedRåvare.getBrugesTilString());
    }

    private void redigerRåvare() {
        String type = textField17.getText();
        String antal = textField18.getText();
        String liter = textField19.getText();
        String kilo = textField20.getText();
        String brugesTil = textField21.getText();
        if (type.isEmpty() || antal.isEmpty() || liter.isEmpty() || kilo.isEmpty() || brugesTil.isEmpty()) {
            Alert alert = getGUI().alert("Fejl", "Udfyld alle felter", "Alle felter skal udfyldes", Alert.AlertType.ERROR);
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
        double literDouble;
        try {
            literDouble = Double.parseDouble(liter);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Liter skal være et tal", "Liter skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        double kiloDouble;
        try {
            kiloDouble = Double.parseDouble(kilo);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Kilogram skal være et tal", "Kilogram skal skrive som et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        String[] brugesTilNumre = brugesTil.split(",");
        int[] flaskeNumre = new int[brugesTilNumre.length];
        for (int i = 0; i < brugesTilNumre.length; i++) {
            try {
                flaskeNumre[i] = Integer.parseInt(brugesTilNumre[i]);
            } catch (NumberFormatException e) {
                Alert alert = getGUI().alert("Fejl", "Nummer skal være et tal", "Nummer skal skrive som et tal", Alert.AlertType.ERROR);
                alert.showAndWait();
                return;
            }
        }
        try {
            getGUI().getController().updateRåvare(selectedRåvare, type, antalInt, literDouble, kiloDouble, flaskeNumre);
            getGUI().switchScene(SceneType.RÅVARE);
        } catch (IllegalArgumentException e) {
            Alert alert = getGUI().alert("Fejl", e.getMessage(), e.getMessage(), Alert.AlertType.ERROR);
            alert.showAndWait();
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