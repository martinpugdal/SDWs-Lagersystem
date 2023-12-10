package gui.scene.scenes.ginflaske;

import application.model.Drikkelse;
import application.model.flaske.Ginflaske;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class RedigerGinflaskeScene extends XScene {

    private TextField textField1, textField2, textField3, textField4;
    private Ginflaske selectedGinflaske;

    public RedigerGinflaskeScene(GUI gui) {
        super(gui);
    }

    public void setSelectedGinflaske(Ginflaske selectedItem) {
        this.selectedGinflaske = selectedItem;
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Rediger ginflaske");
        label109.setTranslateX(0);
        label109.setTranslateY(-10);
        label109.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.GINFLASKE.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.LEFT);

        Button button64 = new Button("Rediger ginflaske");
        button64.setTranslateX(-325);
        button64.setTranslateY(translateY + 45);
        button64.setPrefSize(250, 45);
        button64.setOnAction(e -> redigerGinflaske());
        button64.setFont(XStyle.M_FONT);
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at redigere");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(0);
        button65.setTranslateY(translateY);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.GINFLASKE));
        button65.setFont(XStyle.M_FONT);
        button65.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button65.setCursor(Cursor.HAND);
        Tooltip tooltip138 = new Tooltip("Tryk her for at annullere");
        button65.setTooltip(tooltip138);

        Button button66 = new Button("Gå tilbage til forside");
        button66.setTranslateX(325);
        button66.setTranslateY(translateY - 45);
        button66.setPrefSize(250, 45);
        button66.setOnAction(e -> getGUI().gåTilForside());
        button66.setFont(XStyle.M_FONT);
        button66.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button66.setCursor(Cursor.HAND);
        Tooltip tooltip139 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button66.setTooltip(tooltip139);

        Label label111 = new Label("Nummer");
        label111.setAlignment(Pos.BASELINE_RIGHT);
        label111.setPrefSize(200, 1);
        label111.setFont(XStyle.M_FONT);

        Label label112 = new Label("Navn");
        label112.setAlignment(Pos.BASELINE_RIGHT);
        label112.setPrefSize(200, 1);
        label112.setFont(XStyle.M_FONT);

        Label label113 = new Label("Alkoholprocent");
        label113.setAlignment(Pos.BASELINE_RIGHT);
        label113.setPrefSize(200, 1);
        label113.setFont(XStyle.M_FONT);

        Label label114 = new Label("Antal flasker");
        label114.setAlignment(Pos.BASELINE_RIGHT);
        label114.setPrefSize(200, 1);
        label114.setFont(XStyle.M_FONT);

        textField1 = new TextField();
        textField1.setMaxWidth(200);
        Tooltip tooltip1 = new Tooltip();
        tooltip1.setText("Indtast nummeret på ginflasken her");
        textField1.setTooltip(tooltip1);
        textField1.setCursor(Cursor.TEXT);

        textField2 = new TextField();
        textField2.setMaxWidth(200);
        Tooltip tooltip2 = new Tooltip();
        tooltip2.setText("Indtast navnet på ginflasken her");
        textField2.setTooltip(tooltip2);
        textField2.setCursor(Cursor.TEXT);

        textField3 = new TextField();
        textField3.setMaxWidth(200);
        Tooltip tooltip3 = new Tooltip();
        tooltip3.setText("Indtast alkoholprocenten på ginflasken her");
        textField3.setTooltip(tooltip3);
        textField3.setCursor(Cursor.TEXT);

        textField4 = new TextField();
        textField4.setMaxWidth(200);
        Tooltip tooltip4 = new Tooltip();
        tooltip4.setText("Indtast antallet af flasker her");
        textField4.setTooltip(tooltip4);
        textField4.setCursor(Cursor.TEXT);

        HBox hBox1 = new HBox();
        hBox1.setPrefSize(250, 45);
        hBox1.setSpacing(5);
        hBox1.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox1.setTranslateY(-90);
        hBox1.getChildren().addAll(label111, textField1);

        HBox hBox2 = new HBox();
        hBox2.setPrefSize(250, 45);
        hBox2.setSpacing(5);
        hBox2.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox2.setTranslateY(-90);
        hBox2.getChildren().addAll(label112, textField2);

        HBox hBox3 = new HBox();
        hBox3.setPrefSize(250, 45);
        hBox3.setSpacing(5);
        hBox3.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox3.setTranslateY(-90);
        hBox3.getChildren().addAll(label113, textField3);

        HBox hBox4 = new HBox();
        hBox4.setPrefSize(250, 45);
        hBox4.setSpacing(5);
        hBox4.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox4.setTranslateY(-90);
        hBox4.getChildren().addAll(label114, textField4);


        getLayout().getChildren().addAll(label109, button64, button65, button66, hBox1, hBox2, hBox3, hBox4);

    }

    private void redigerGinflaske() {
        String nummer = textField1.getText();
        String navn = textField2.getText();
        String volumen = textField3.getText();
        String antal = textField4.getText();

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
            getGUI().getController().updateFlaske(selectedGinflaske, nummerInt, navn, volumenDouble, antalInt);
            getGUI().switchScene(SceneType.GINFLASKE);
        } catch (IllegalArgumentException e) {
            Alert alert = getGUI().alert("Fejl", "Nummeret er allerede i brug", "Nummeret er allerede i brug", Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    @Override
    public void update() {
        textField1.setText(selectedGinflaske.getNummer() + "");
        textField2.setText(selectedGinflaske.getNavn());
        textField3.setText(selectedGinflaske.getAlkoholprocent() + "");
        textField4.setText(selectedGinflaske.getAntal() + "");
    }

    @Override
    public String getTitle() {
        return "Rediger ginflaske";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.GINFLASKE;
    }
}
