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

public class RedigerLagerScene extends XScene {

    private Lager selectedLager;

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
        label116.setFont(new Font("Arial",36));
        label116.setTextFill(Color.BLACK);

        Label label117 = new Label("Nummer");
        label117.setTranslateX(0);
        label117.setTranslateY(150);
        label117.setFont(new Font("Arial",16));
        label117.setTextFill(Color.BLACK);

        Label label119 = new Label("Adresse");
        label119.setTranslateX(0);
        label119.setTranslateY(150);
        label119.setFont(new Font("Arial",16));
        label119.setTextFill(Color.BLACK);

        Label label120 = new Label("Postnummer");
        label120.setTranslateX(0);
        label120.setTranslateY(150);
        label120.setFont(new Font("Arial",16));
        label120.setTextFill(Color.BLACK);

        Label label121 = new Label("By");
        label121.setTranslateX(0);
        label121.setTranslateY(150);
        label121.setFont(new Font("Arial",16));
        label121.setTextFill(Color.BLACK);

        Label label122 = new Label("Kvadratmeter");
        label122.setTranslateX(0);
        label122.setTranslateY(150);
        label122.setFont(new Font("Arial",16));
        label122.setTextFill(Color.BLACK);

        TextField textField74 = new TextField();
        textField74.setMaxWidth(100);
        Tooltip tooltip140 = new Tooltip();
        tooltip140.setText("Indtast nummeret for lageret her");
        textField74.setTooltip(tooltip140);
        textField74.setCursor(Cursor.TEXT);

        TextField textField76 = new TextField(selectedLager != null ? selectedLager.getAdresse().split(",")[0].trim() : "");
        textField76.setMaxWidth(100);
        Tooltip tooltip142 = new Tooltip();
        tooltip142.setText("Indtast adressen på lageret her");
        textField76.setTooltip(tooltip142);
        textField76.setCursor(Cursor.TEXT);

        TextField textField77 = new TextField(selectedLager != null ? selectedLager.getAdresse().split(",")[1].trim() : "");
        textField77.setMaxWidth(100);
        Tooltip tooltip143 = new Tooltip();
        tooltip143.setText("Indtast postnummeret for lageret her");
        textField77.setTooltip(tooltip143);
        textField77.setCursor(Cursor.TEXT);

        TextField textField78 = new TextField(selectedLager != null ? selectedLager.getAdresse().split(",")[2].trim() : "");
        textField78.setMaxWidth(100);
        Tooltip tooltip144 = new Tooltip();
        tooltip144.setText("Indtast by her");
        textField78.setTooltip(tooltip144);
        textField78.setCursor(Cursor.TEXT);

        TextField textField79 = new TextField(selectedLager != null ? String.valueOf(selectedLager.getStørrelse()) : "");
        textField79.setMaxWidth(100);
        Tooltip tooltip145 = new Tooltip();
        tooltip145.setText("Indtast størrelsen på lageret i kvadratmeter her");
        textField79.setTooltip(tooltip145);
        textField79.setCursor(Cursor.TEXT);

        ImageView imageView18 = XIcon.LAGER.getImageView();
        imageView18.setFitHeight(100);
        imageView18.setFitWidth(100);
        imageView18.setTranslateX(10);
        imageView18.setTranslateY(-10);
        getLayout().getChildren().add(imageView18);

        Button button67 = new Button("Rediger lager");
        button67.setTranslateX(-150);
        button67.setTranslateY(-280);
        button67.setPrefSize(250,45);
        button67.setOnAction(e -> redigerLager(textField74.getText(), textField76.getText(), textField77.getText(), textField78.getText(), textField79.getText()));
        button67.setFont(new Font("Arial",16));
        button67.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button67.setCursor(Cursor.HAND);
        Tooltip tooltip146 = new Tooltip("Tryk her for at redigere lageret");
        button67.setTooltip(tooltip146);

        Button button68 = new Button("Annuller");
        button68.setTranslateX(-150);
        button68.setTranslateY(-280);
        button68.setPrefSize(250,45);
        button68.setOnAction(e -> getGUI().switchScene(SceneType.LAGER));
        button68.setFont(new Font("Arial",16));
        button68.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button68.setCursor(Cursor.HAND);
        Tooltip tooltip147 = new Tooltip("Tryk her for at annullere");
        button68.setTooltip(tooltip147);

        Button button69 = new Button("Gå tilbage til forside");
        button69.setTranslateX(-150);
        button69.setTranslateY(-280);
        button69.setPrefSize(250,45);
        button69.setOnAction(e -> getGUI().gåTilForside());
        button69.setFont(new Font("Arial",16));
        button69.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button69.setCursor(Cursor.HAND);
        Tooltip tooltip148 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button69.setTooltip(tooltip148);

        getLayout().getChildren().addAll(label116, label117, label119, label120, label121, label122, textField74, textField76, textField77, textField78, textField79, button67, button68, button69);
    }

    private void redigerLager(String nummer, String adresse, String postnummer, String by, String kvadratmeter) {
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
