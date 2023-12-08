package gui.scene.scenes.lager;

import application.model.Lager;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RedigerLagerScene extends XScene {

    private Lager selectedLager;
    private TextField textField74, textField76, textField77, textField78, textField79;

    public RedigerLagerScene(GUI gui) {
        super(gui);
    }

    public void setSelectedLager(Lager lager) {
        selectedLager = lager;
    }

    @Override
    public void initLayout() {
        //Skærmbillede 19: Rediger lager

        Label label116 = new Label("Rediger lager");
        label116.setTranslateX(0);
        label116.setTranslateY(150);
        label116.setFont(XStyle.XXL_FONT);
        label116.setTextFill(Color.BLACK);

        Label label117 = new Label("Nummer");
        label117.setTranslateX(0);
        label117.setTranslateY(150);
        label117.setFont(XStyle.M_FONT);
        label117.setTextFill(Color.BLACK);

        Label label119 = new Label("Adresse");
        label119.setTranslateX(0);
        label119.setTranslateY(150);
        label119.setFont(XStyle.M_FONT);
        label119.setTextFill(Color.BLACK);

        Label label120 = new Label("Postnummer");
        label120.setTranslateX(0);
        label120.setTranslateY(150);
        label120.setFont(XStyle.M_FONT);
        label120.setTextFill(Color.BLACK);

        Label label121 = new Label("By");
        label121.setTranslateX(0);
        label121.setTranslateY(150);
        label121.setFont(XStyle.M_FONT);
        label121.setTextFill(Color.BLACK);

        Label label122 = new Label("Kvadratmeter");
        label122.setTranslateX(0);
        label122.setTranslateY(150);
        label122.setFont(XStyle.M_FONT);
        label122.setTextFill(Color.BLACK);

        textField74 = new TextField();
        textField74.setMaxWidth(100);
        Tooltip tooltip140 = new Tooltip();
        tooltip140.setText("Indtast nummeret for lageret her");
        textField74.setTooltip(tooltip140);
        textField74.setCursor(Cursor.TEXT);

        textField76 = new TextField();
        textField76.setMaxWidth(100);
        Tooltip tooltip142 = new Tooltip();
        tooltip142.setText("Indtast adressen på lageret her");
        textField76.setTooltip(tooltip142);
        textField76.setCursor(Cursor.TEXT);

        textField77 = new TextField();
        textField77.setMaxWidth(100);
        Tooltip tooltip143 = new Tooltip();
        tooltip143.setText("Indtast postnummeret for lageret her");
        textField77.setTooltip(tooltip143);
        textField77.setCursor(Cursor.TEXT);

        textField78 = new TextField();
        textField78.setMaxWidth(100);
        Tooltip tooltip144 = new Tooltip();
        tooltip144.setText("Indtast by her");
        textField78.setTooltip(tooltip144);
        textField78.setCursor(Cursor.TEXT);

        textField79 = new TextField();
        textField79.setMaxWidth(100);
        Tooltip tooltip145 = new Tooltip();
        tooltip145.setText("Indtast størrelsen på lageret i kvadratmeter her");
        textField79.setTooltip(tooltip145);
        textField79.setCursor(Cursor.TEXT);

        Button button67 = new Button("Rediger lager");
        button67.setTranslateX(-150);
        button67.setTranslateY(-280);
        button67.setPrefSize(250,45);
        button67.setOnAction(e -> redigerLager());
        button67.setFont(XStyle.M_FONT);
        button67.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button67.setCursor(Cursor.HAND);
        Tooltip tooltip146 = new Tooltip("Tryk her for at redigere lageret");
        button67.setTooltip(tooltip146);

        Button button68 = new Button("Annuller");
        button68.setTranslateX(-150);
        button68.setTranslateY(-280);
        button68.setPrefSize(250,45);
        button68.setOnAction(e -> getGUI().switchScene(SceneType.LAGER));
        button68.setFont(XStyle.M_FONT);
        button68.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button68.setCursor(Cursor.HAND);
        Tooltip tooltip147 = new Tooltip("Tryk her for at annullere");
        button68.setTooltip(tooltip147);

        Button button69 = new Button("Gå tilbage til forside");
        button69.setTranslateX(-150);
        button69.setTranslateY(-280);
        button69.setPrefSize(250,45);
        button69.setOnAction(e -> getGUI().gåTilForside());
        button69.setFont(XStyle.M_FONT);
        button69.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button69.setCursor(Cursor.HAND);
        Tooltip tooltip148 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button69.setTooltip(tooltip148);

        getLayout().getChildren().addAll(label116, label117, label119, label120, label121, label122, textField74, textField76, textField77, textField78, textField79, button67, button68, button69);
    }

    @Override
    public void update() {
        textField74.setText(String.valueOf(selectedLager.getNummer()));
        textField76.setText(selectedLager.getAdresse());
        textField77.setText(selectedLager.getPostnummer());
        textField78.setText(selectedLager.getBy());
        textField79.setText(String.valueOf(selectedLager.getStørrelse()));
    }

    private void redigerLager() {
        String nummer = textField74.getText();
        String adresse = textField76.getText();
        String postnummer = textField77.getText();
        String by = textField78.getText();
        String kvadratmeter = textField79.getText();
        if (nummer.isEmpty() || adresse.isEmpty() || postnummer.isEmpty() || by.isEmpty() || kvadratmeter.isEmpty()) {
            Alert alert = getGUI().alert("Fejl", "Alle felter skal udfyldes", "Alle felter skal udfyldes", Alert.AlertType.ERROR);
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
        if (getGUI().getController().checkLagerExists(adresseFormat) || getGUI().getController().checkLagerExists(nummerInt)) {
            Alert alert = getGUI().alert("Fejl", "Lageret findes allerede", "Lageret findes allerede", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        getGUI().getController().updateLager(selectedLager, nummerInt, adresseFormat, kvadratmeterDouble);
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
