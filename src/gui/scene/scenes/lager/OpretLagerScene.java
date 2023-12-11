package gui.scene.scenes.lager;

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

public class OpretLagerScene extends XScene {

    private TextField textField69, textField70, textField71, textField72, textField73;

    public OpretLagerScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Opret lager");
        label109.setTranslateX(0);
        label109.setTranslateY(-70);
        label109.setFont(new Font("Arial", 36));
        label109.setTextFill(Color.BLACK);
        ImageView lagerIcon = XIcon.LAGER.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.LEFT);

        Button button64 = new Button("Opret lager");
        button64.setTranslateX(-325);
        button64.setTranslateY(translateY + 45);
        button64.setPrefSize(250, 45);
        button64.setOnAction(e -> opretLager());
        button64.setFont(new Font("Arial", 16));
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at oprette");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(0);
        button65.setTranslateY(translateY);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.LAGER));
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

        Label label111 = new Label("Nummer");
        label111.setPrefSize(100, 1);
        label111.setFont(XStyle.M_FONT);

        Label label112 = new Label("Adresse");
        label112.setPrefSize(100, 1);
        label112.setFont(new Font("Arial", 16));

        Label label113 = new Label("Postnummer");
        label113.setPrefSize(100, 1);
        label113.setFont(new Font("Arial", 16));

        Label label114 = new Label("By");
        label114.setPrefSize(100, 1);
        label114.setFont(new Font("Arial", 16));

        Label label115 = new Label("Kvadratmeter");
        label115.setPrefSize(100, 1);
        label115.setFont(new Font("Arial", 16));

        textField69 = new TextField();
        textField69.setMaxWidth(100);
        Tooltip tooltip131 = new Tooltip();
        tooltip131.setText("Indtast nummeret for lageret her");
        textField69.setTooltip(tooltip131);
        textField69.setCursor(Cursor.TEXT);

        textField70 = new TextField();
        textField70.setMaxWidth(100);
        Tooltip tooltip133 = new Tooltip();
        tooltip133.setText("Indtast adressen på lageret her");
        textField70.setTooltip(tooltip133);
        textField70.setCursor(Cursor.TEXT);

        textField71 = new TextField();
        textField71.setMaxWidth(100);
        Tooltip tooltip134 = new Tooltip();
        tooltip134.setText("Indtast postnummeret for lageret her");
        textField71.setTooltip(tooltip134);
        textField71.setCursor(Cursor.TEXT);

        textField72 = new TextField();
        textField72.setMaxWidth(100);
        Tooltip tooltip135 = new Tooltip();
        tooltip135.setText("Indtast by her");
        textField72.setTooltip(tooltip135);
        textField72.setCursor(Cursor.TEXT);

        textField73 = new TextField();
        textField73.setPromptText("m²");
        textField73.setMaxWidth(100);
        Tooltip tooltip136 = new Tooltip();
        tooltip136.setText("Indtast størrelsen på lageret i kvadratmeter her");
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

    private void opretLager() {
        String nummer = textField69.getText();
        String adresse = textField70.getText();
        String postnummer = textField71.getText();
        String by = textField72.getText();
        String kvadratmeter = textField73.getText();
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
        String adresseFormat = adresse + ", " + postnummer + ", " + by;
        try {
            getGUI().getController().createLager(nummerInt, adresseFormat, kvadratmeterDouble);
            getGUI().switchScene(SceneType.LAGER);
        } catch (IllegalArgumentException e) {
            Alert alert = getGUI().alert("Fejl", "Lageret kunne ikke oprettes", e.getMessage(), Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    public void update() {
        textField69.setText("");
        textField70.setText("");
        textField71.setText("");
        textField72.setText("");
        textField73.setText("");
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
