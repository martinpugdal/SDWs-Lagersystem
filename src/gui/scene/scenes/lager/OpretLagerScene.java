package gui.scene.scenes.lager;

import application.model.Lager;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public class OpretLagerScene extends XScene {
    public OpretLagerScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 18: Opret lager

        Label label109 = new Label("Opret lager");
        label109.setTranslateX(0);
        label109.setTranslateY(150);
        label109.setFont(new Font("Arial", 36));
        label109.setTextFill(Color.BLACK);

        Label label111 = new Label("Nummer");
        label111.setTranslateX(0);
        label111.setTranslateY(150);
        label111.setFont(new Font("Arial",16));
        label111.setTextFill(Color.BLACK);

        Label label112 = new Label("Adresse");
        label112.setTranslateX(0);
        label112.setTranslateY(150);
        label112.setFont(new Font("Arial", 16));
        label112.setTextFill(Color.BLACK);

        Label label113 = new Label("Postnummer");
        label113.setTranslateX(0);
        label113.setTranslateY(150);
        label113.setFont(new Font("Arial", 16));
        label113.setTextFill(Color.BLACK);

        Label label114 = new Label("By");
        label114.setTranslateX(0);
        label114.setTranslateY(150);
        label114.setFont(new Font("Arial", 16));
        label114.setTextFill(Color.BLACK);

        Label label115 = new Label("Kvadratmeter");
        label115.setTranslateX(0);
        label115.setTranslateY(150);
        label115.setFont(new Font("Arial", 16));
        label115.setTextFill(Color.BLACK);

        TextField textField69 = new TextField();
        textField69.setMaxWidth(100);
        Tooltip tooltip131 = new Tooltip();
        tooltip131.setText("Indtast nummeret for lageret her");
        textField69.setTooltip(tooltip131);
        textField69.setCursor(Cursor.TEXT);

        TextField textField70 = new TextField();
        textField70.setMaxWidth(100);
        Tooltip tooltip133 = new Tooltip();
        tooltip133.setText("Indtast adressen på lageret her");
        textField70.setTooltip(tooltip133);
        textField70.setCursor(Cursor.TEXT);

        TextField textField71 = new TextField();
        textField71.setMaxWidth(100);
        Tooltip tooltip134 = new Tooltip();
        tooltip134.setText("Indtast postnummeret for lageret her");
        textField71.setTooltip(tooltip134);
        textField71.setCursor(Cursor.TEXT);

        TextField textField72 = new TextField();
        textField72.setMaxWidth(100);
        Tooltip tooltip135 = new Tooltip();
        tooltip135.setText("Indtast by her");
        textField72.setTooltip(tooltip135);
        textField72.setCursor(Cursor.TEXT);

        TextField textField73 = new TextField();
        textField73.setMaxWidth(100);
        Tooltip tooltip136 = new Tooltip();
        tooltip136.setText("Indtast størrelsen på lageret i kvadratmeter her");
        textField73.setTooltip(tooltip136);
        textField73.setCursor(Cursor.TEXT);

        ImageView imageView17 = XIcon.LAGER.getImageView();
        imageView17.setFitHeight(100);
        imageView17.setFitWidth(100);
        imageView17.setTranslateX(10);
        imageView17.setTranslateY(-10);
        getLayout().getChildren().add(imageView17);

        Button button64 = new Button("Opret lager");
        button64.setTranslateX(-150);
        button64.setTranslateY(-280);
        button64.setPrefSize(100, 100);
        button64.setOnAction(e -> opretLager(textField69.getText(), textField70.getText(), textField71.getText(), textField72.getText(), textField73.getText()));
        button64.setFont(new Font("Arial", 16));
        button64.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at oprette");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(-150);
        button65.setTranslateY(-280);
        button65.setPrefSize(100, 100);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.LAGER));
        button65.setFont(new Font("Arial", 16));
        button65.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button65.setCursor(Cursor.HAND);
        Tooltip tooltip138 = new Tooltip("Tryk her for at annullere");
        button65.setTooltip(tooltip138);

        Button button66 = new Button("Gå tilbage til forside");
        button66.setTranslateX(-150);
        button66.setTranslateY(-280);
        button66.setPrefSize(100, 100);
        button66.setOnAction(e -> getGUI().gåTilForside());
        button66.setFont(new Font("Arial", 16));
        button66.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button66.setCursor(Cursor.HAND);
        Tooltip tooltip139 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button66.setTooltip(tooltip139);

        getLayout().getChildren().addAll(label109, label111, label112, label113, label114, label115, textField69, textField70, textField71, textField72, textField73, button64, button65, button66);
    }

    private void opretLager(String nummer, String adresse, String postnummer, String by, String kvadratmeter) {
        if (nummer.isEmpty() || adresse.isEmpty() || postnummer.isEmpty() || by.isEmpty() || kvadratmeter.isEmpty()) {
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
        double kvadratmeterDouble;
        try {
            kvadratmeterDouble = Double.parseDouble(kvadratmeter);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Kvadratmeter skal være et tal", "Kvadratmeter skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        String adresseFormat = adresse + ", " + postnummer + " " + by;
        Lager lager = getGUI().getController().createLager(nummerInt, adresseFormat, kvadratmeterDouble);
        if (lager == null) {
            Alert alert = getGUI().alert("Fejl", "Lageret kunne ikke oprettes", "Lageret kunne ikke oprettes", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        getGUI().switchScene(SceneType.LAGER);
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
