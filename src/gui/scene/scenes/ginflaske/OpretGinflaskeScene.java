package gui.scene.scenes.ginflaske;

import application.model.Drikkelse;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OpretGinflaskeScene extends XScene {

    public OpretGinflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 24: Opret ginflaske

        Label label135 = new Label("Opret ginflaske");
        label135.setTranslateX(0);
        label135.setTranslateY(150);
        label135.setFont(new Font("Arial", 36));
        label135.setTextFill(Color.BLACK);

        Label label136 = new Label("Nummer");
        label136.setTranslateX(0);
        label136.setTranslateY(150);
        label136.setFont(new Font("Arial", 16));
        label136.setTextFill(Color.BLACK);

        Label label137 = new Label("Navn");
        label137.setTranslateX(0);
        label137.setTranslateY(150);
        label137.setFont(new Font("Arial", 16));
        label137.setTextFill(Color.BLACK);

        Label label138 = new Label("Volumen");
        label138.setTranslateX(0);
        label138.setTranslateY(150);
        label138.setFont(new Font("Arial", 16));
        label138.setTextFill(Color.BLACK);

        Label label139 = new Label("Antal");
        label139.setTranslateX(0);
        label139.setTranslateY(150);
        label139.setFont(new Font("Arial", 16));
        label139.setTextFill(Color.BLACK);

        TextField textField86 = new TextField();
        textField86.setMaxWidth(100);
        Tooltip tooltip169 = new Tooltip();
        tooltip169.setText("Indtast nummeret på ginflasken her");
        textField86.setTooltip(tooltip169);
        textField86.setCursor(Cursor.TEXT);

        TextField textField87 = new TextField();
        textField87.setMaxWidth(100);
        Tooltip tooltip170 = new Tooltip();
        tooltip170.setText("Indtast navnet på ginflasken her");
        textField87.setTooltip(tooltip170);
        textField87.setCursor(Cursor.TEXT);

        TextField textField88 = new TextField();
        textField88.setMaxWidth(100);
        Tooltip tooltip171 = new Tooltip();
        tooltip171.setText("Indtast antal liter her");
        textField88.setTooltip(tooltip171);
        textField88.setCursor(Cursor.TEXT);

        TextField textField89 = new TextField();
        textField89.setMaxWidth(100);
        Tooltip tooltip172 = new Tooltip();
        tooltip172.setText("Indtast antal ginflasker her");
        textField89.setTooltip(tooltip172);
        textField89.setCursor(Cursor.TEXT);

        ImageView imageView23 = XIcon.GINFLASKE.getImageView();
        imageView23.setFitHeight(100);
        imageView23.setFitWidth(100);
        imageView23.setTranslateX(10);
        imageView23.setTranslateY(-10);
        getLayout().getChildren().add(imageView23);

        Button button84 = new Button("Opret ginflaske");
        button84.setTranslateX(-150);
        button84.setTranslateY(-280);
        button84.setPrefSize(250, 45);
        button84.setOnAction(e -> opretGinflaske(textField86.getText(), textField87.getText(), textField88.getText(), textField89.getText()));
        button84.setFont(new Font("Arial", 16));
        button84.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button84.setCursor(Cursor.HAND);
        Tooltip tooltip173 = new Tooltip("Tryk her for at oprette ginflaske");
        button84.setTooltip(tooltip173);

        Button button85 = new Button("Annuller");
        button85.setTranslateX(-150);
        button85.setTranslateY(-280);
        button85.setPrefSize(250, 45);
        button85.setOnAction(e -> getGUI().switchScene(SceneType.GINFLASKE));
        button85.setFont(new Font("Arial", 16));
        button85.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button85.setCursor(Cursor.HAND);
        Tooltip tooltip174 = new Tooltip("Tryk her for at annullere");
        button85.setTooltip(tooltip174);

        Button button86 = new Button("Gå tilbage til forside");
        button86.setTranslateX(-150);
        button86.setTranslateY(-280);
        button86.setPrefSize(250, 45);
        button86.setOnAction(e -> getGUI().gåTilForside());
        button86.setFont(new Font("Arial", 16));
        button86.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button86.setCursor(Cursor.HAND);
        Tooltip tooltip175 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button86.setTooltip(tooltip175);

        getLayout().getChildren().addAll(label135, label136, label137, label138, label139, textField86, textField87, textField88, textField89, button84, button85, button86);

    }

    private void opretGinflaske(String nummer, String navn, String volumen, String antal) {
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
            getGUI().getController().createFlaske(Drikkelse.GIN, nummerInt, navn, volumenDouble, antalInt);
        } catch (IllegalArgumentException e) {
            Alert alert = getGUI().alert("Fejl", "Nummeret er allerede i brug", "Nummeret er allerede i brug", Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public XIcon getIcon() {
        return XIcon.GINFLASKE;
    }
}
