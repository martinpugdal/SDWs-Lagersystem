package gui.scene.scenes.råvare;

import application.model.Råvare;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class RedigerRåvareScene extends XScene {

    private Råvare selectedRåvare;
    private TextField textField69, textField70, textField71, textField72, textField73;

    public RedigerRåvareScene(GUI gui) {
        super(gui);
    }

    public void setSelectedRåvare(Råvare råvare) {
        selectedRåvare = råvare;
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Rediger råvare");
        label109.setTranslateX(0);
        label109.setTranslateY(-70);
        label109.setFont(new Font("Arial", 36));
        label109.setTextFill(Color.BLACK);
        ImageView lagerIcon = XIcon.ENEBÆR.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.LEFT);

        Button button64 = new Button("Rediger råvare");
        button64.setTranslateX(-325);
        button64.setTranslateY(translateY + 45);
        button64.setPrefSize(250, 45);
        button64.setOnAction(e -> redigerRåvare());
        button64.setFont(new Font("Arial", 16));
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at redigere");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(0);
        button65.setTranslateY(translateY);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.RÅVARE));
        button65.setFont(new Font("Arial", 16));
        button65.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button65.setCursor(Cursor.HAND);
        Tooltip tooltip138 = new Tooltip("Tryk her for at annullere");
        button65.setTooltip(tooltip138);

        Button button66 = new Button("Gå tilbage til forside");
        button66.setTranslateX(325);
        button66.setTranslateY(translateY - 45);
        button66.setPrefSize(250, 45);
        button66.setOnAction(e -> getGUI().gåTilForside());
        button66.setFont(new Font("Arial", 16));
        button66.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button66.setCursor(Cursor.HAND);
        Tooltip tooltip139 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button66.setTooltip(tooltip139);

        Label label111 = new Label("Type");
        label111.setPrefSize(100, 1);
        label111.setFont(XStyle.M_FONT);

        Label label112 = new Label("Antal");
        label112.setPrefSize(100, 1);
        label112.setFont(new Font("Arial", 16));

        Label label113 = new Label("Liter");
        label113.setPrefSize(100, 1);
        label113.setFont(new Font("Arial", 16));

        Label label114 = new Label("Kilogram");
        label114.setPrefSize(100, 1);
        label114.setFont(new Font("Arial", 16));

        Label label115 = new Label("Bruges til");
        label115.setPrefSize(100, 1);
        label115.setFont(new Font("Arial", 16));

        textField69 = new TextField();
        textField69.setMaxWidth(100);
        Tooltip tooltip131 = new Tooltip();
        tooltip131.setText("Indtast type på råvare her");
        textField69.setTooltip(tooltip131);
        textField69.setCursor(Cursor.TEXT);

        textField70 = new TextField();
        textField70.setMaxWidth(100);
        Tooltip tooltip133 = new Tooltip();
        tooltip133.setText("Indtast antallet af råvare her");
        textField70.setTooltip(tooltip133);
        textField70.setCursor(Cursor.TEXT);

        textField71 = new TextField();
        textField71.setMaxWidth(100);
        Tooltip tooltip134 = new Tooltip();
        tooltip134.setText("Indtast antal liter her");
        textField71.setTooltip(tooltip134);
        textField71.setCursor(Cursor.TEXT);

        textField72 = new TextField();
        textField72.setMaxWidth(100);
        Tooltip tooltip135 = new Tooltip();
        tooltip135.setText("Indtast antal kilo her");
        textField72.setTooltip(tooltip135);
        textField72.setCursor(Cursor.TEXT);

        textField73 = new TextField();
        textField73.setMaxWidth(100);
        Tooltip tooltip136 = new Tooltip();
        tooltip136.setText("Indtast hvilke produkter råvaren bruges til her (adskil med komma hvis flere)");
        textField73.setTooltip(tooltip136);
        textField73.setCursor(Cursor.TEXT);

        HBox hBox19 = new HBox();
        hBox19.setPrefSize(250, 45);
        hBox19.setSpacing(5);
        hBox19.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox19.setTranslateY(-90);
        hBox19.getChildren().addAll(label111, textField69);

        HBox hBox20 = new HBox();
        hBox20.setPrefSize(250, 45);
        hBox20.setSpacing(5);
        hBox20.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox20.setTranslateY(-90);
        hBox20.getChildren().addAll(label112, textField70);

        HBox hBox21 = new HBox();
        hBox21.setPrefSize(250, 45);
        hBox21.setSpacing(5);
        hBox21.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox21.setTranslateY(-90);
        hBox21.getChildren().addAll(label113, textField71);

        HBox hBox22 = new HBox();
        hBox22.setPrefSize(250, 45);
        hBox22.setSpacing(5);
        hBox22.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox22.setTranslateY(-90);
        hBox22.getChildren().addAll(label114, textField72);

        HBox hBox23 = new HBox();
        hBox23.setPrefSize(250, 45);
        hBox23.setSpacing(5);
        hBox23.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox23.setTranslateY(-90);
        hBox23.getChildren().addAll(label115, textField73);


        getLayout().getChildren().addAll(label109, button64, button65, button66, hBox19, hBox20, hBox21, hBox22, hBox23);
    }

    @Override
    public void update() {
        textField69.setText(selectedRåvare.getType());
        textField70.setText(String.valueOf(selectedRåvare.getAntal()));
        textField71.setText(String.valueOf(selectedRåvare.getLiter()));
        textField72.setText(String.valueOf(selectedRåvare.getKilogram()));
        textField73.setText(selectedRåvare.getBrugesTilString());
    }

    private void redigerRåvare() {
        String type = textField69.getText();
        String antal = textField70.getText();
        String liter = textField71.getText();
        String kilo = textField72.getText();
        String brugesTil = textField73.getText();
        if (type.isEmpty() || antal.isEmpty() || liter.isEmpty() || kilo.isEmpty()) {
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