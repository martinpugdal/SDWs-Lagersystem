package gui.scene.scenes.destillering;

import application.model.Destillering;
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
import javafx.scene.text.Font;

public class RedigerDestilleringScene extends XScene {

    private Destillering selectedDestillering;
    private TextField textField69, textField70, textField71, textField72;

    public RedigerDestilleringScene(GUI gui) {
        super(gui);
    }

    public void setSelectedDestillering(Destillering destillering) {
        selectedDestillering = destillering;
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Rediger destillering");
        label109.setTranslateX(0);
        label109.setTranslateY(-10);
        label109.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.DESTILLERING.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.LEFT);

        Button button64 = new Button("Rediger destillering");
        button64.setTranslateX(-325);
        button64.setTranslateY(translateY + 45);
        button64.setPrefSize(250, 45);
        button64.setOnAction(e -> redigerDestillering());
        button64.setFont(XStyle.M_FONT);
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at redigere");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(0);
        button65.setTranslateY(translateY);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERING));
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
        label112.setFont(new Font("Arial", 16));

        Label label113 = new Label("Antal liter");
        label113.setAlignment(Pos.BASELINE_RIGHT);
        label113.setPrefSize(200, 1);
        label113.setFont(new Font("Arial", 16));

        Label label114 = new Label("Alkoholprocent");
        label114.setAlignment(Pos.BASELINE_RIGHT);
        label114.setPrefSize(200, 1);
        label114.setFont(new Font("Arial", 16));

        textField69 = new TextField();
        textField69.setMaxWidth(200);
        Tooltip tooltip131 = new Tooltip();
        tooltip131.setText("Indtast nummeret på fadet her");
        textField69.setTooltip(tooltip131);
        textField69.setCursor(Cursor.TEXT);

        textField70 = new TextField();
        textField70.setMaxWidth(200);
        Tooltip tooltip133 = new Tooltip();
        tooltip133.setText("Indtast type for fadet her");
        textField70.setTooltip(tooltip133);
        textField70.setCursor(Cursor.TEXT);

        textField71 = new TextField();
        textField71.setMaxWidth(200);
        Tooltip tooltip134 = new Tooltip();
        tooltip134.setText("Indtast antal gange fadet er brugt her");
        textField71.setTooltip(tooltip134);
        textField71.setCursor(Cursor.TEXT);

        textField72 = new TextField();
        textField72.setMaxWidth(200);
        Tooltip tooltip3 = new Tooltip();
        tooltip139.setText("Indtast antal liter på fadet her");
        textField72.setTooltip(tooltip3);
        textField72.setCursor(Cursor.TEXT);

        HBox hBox19 = new HBox();
        hBox19.setPrefSize(250, 45);
        hBox19.setSpacing(5);
        hBox19.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox19.setTranslateY(-90);
        hBox19.getChildren().addAll(label111, textField69);

        HBox hBox20 = new HBox();
        hBox20.setPrefSize(250, 45);
        hBox20.setSpacing(5);
        hBox20.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox20.setTranslateY(-90);
        hBox20.getChildren().addAll(label112, textField70);

        HBox hBox21 = new HBox();
        hBox21.setPrefSize(250, 45);
        hBox21.setSpacing(5);
        hBox21.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox21.setTranslateY(-90);
        hBox21.getChildren().addAll(label113, textField71);

        HBox hBox26 = new HBox();
        hBox26.setPrefSize(250, 45);
        hBox26.setSpacing(5);
        hBox26.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox26.setTranslateY(-90);
        hBox26.getChildren().addAll(label114, textField72);


        getLayout().getChildren().addAll(label109, button64, button65, button66, hBox19, hBox20, hBox21, hBox26);
    }

    public void redigerDestillering() {
        String nummer = textField69.getText();
        String navn = textField70.getText();
        String antalLiter = textField71.getText();
        String alkoholprocent = textField72.getText();
        if (nummer.isEmpty() || navn.isEmpty() || antalLiter.isEmpty() || alkoholprocent.isEmpty()) {
            getGUI().alert("Fejl", "Alle felter skal udfyldes", "Alle felter skal udfyldes", Alert.AlertType.ERROR).showAndWait();
            return;
        }
        int nummerInt;
        try {
            nummerInt = Integer.parseInt(nummer);
        } catch (NumberFormatException e) {
            getGUI().alert("Fejl", "Nummeret skal være et tal", "Nummeret skal være et tal", Alert.AlertType.ERROR).showAndWait();
            return;
        }
        double antalLiterDouble;
        try {
            antalLiterDouble = Double.parseDouble(antalLiter);
        } catch (NumberFormatException e) {
            getGUI().alert("Fejl", "Antal liter skal være et tal", "Antal liter skal være et tal", Alert.AlertType.ERROR).showAndWait();
            return;
        }
        double alkoholprocentDouble;
        try {
            alkoholprocentDouble = Double.parseDouble(alkoholprocent);
        } catch (NumberFormatException e) {
            getGUI().alert("Fejl", "Alkoholprocent skal være et tal", "Alkoholprocent skal være et tal", Alert.AlertType.ERROR).showAndWait();
            return;
        }
        try {
            getGUI().getController().updateDestillering(selectedDestillering, navn, nummerInt, antalLiterDouble, alkoholprocentDouble);
            getGUI().switchScene(SceneType.DESTILLERING);
        } catch (IllegalArgumentException e) {
            getGUI().alert("Fejl", "Destillering kunne ikke redigeres", e.getMessage(), Alert.AlertType.ERROR).showAndWait();
        }
    }

    @Override
    public void update() {
        textField69.setText(selectedDestillering.getNummer() + "");
        textField70.setText(selectedDestillering.getNavn());
        textField71.setText(selectedDestillering.getLiter() + "");
        textField72.setText(selectedDestillering.getAlkoholprocent() + "");
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Rediger destillering";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.DESTILLERING;
    }
}
