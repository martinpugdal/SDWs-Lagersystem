package gui.scene.scenes.plastictank;

import application.model.Drikkelse;
import application.model.Hylde;
import application.model.Opbevaring;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class OpretPlastictankScene extends XScene {

    private TextField textField69, textField70, textFieldPlacering, textField74;
    private CheckBox checkBox1;
    private ComboBox<String> placering1;

    public OpretPlastictankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Opret Plastictank");
        label109.setTranslateX(0);
        label109.setTranslateY(-10);
        label109.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.FAD.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.LEFT);

        Button button64 = new Button("Opret plastictank");
        button64.setTranslateX(-325);
        button64.setTranslateY(translateY + 45);
        button64.setPrefSize(250, 45);
        button64.setOnAction(e -> opretFad());
        button64.setFont(XStyle.M_FONT);
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at oprette");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(0);
        button65.setTranslateY(translateY);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.PLASTICTANK));
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

        Label label112 = new Label("Type");
        label112.setAlignment(Pos.BASELINE_RIGHT);
        label112.setPrefSize(200, 1);
        label112.setFont(new Font("Arial", 16));

        Label label114 = new Label("Intakt");
        label114.setAlignment(Pos.BASELINE_RIGHT);
        label114.setPrefSize(200, 1);
        label114.setFont(new Font("Arial", 16));

        Label label117 = new Label("Placering");
        label117.setAlignment(Pos.BASELINE_RIGHT);
        label117.setPrefSize(200, 1);
        label117.setFont(new Font("Arial", 16));

        Label label118 = new Label("Antal liter");
        label118.setAlignment(Pos.BASELINE_RIGHT);
        label118.setPrefSize(200, 1);
        label118.setFont(new Font("Arial", 16));

        textField69 = new TextField();
        textField69.setMaxWidth(200);
        Tooltip tooltip131 = new Tooltip();
        tooltip131.setText("Indtast nummeret på plastictanken her");
        textField69.setTooltip(tooltip131);
        textField69.setCursor(Cursor.TEXT);

        textField70 = new TextField();
        textField70.setMaxWidth(200);
        Tooltip tooltip133 = new Tooltip();
        tooltip133.setText("Indtast type for plastictanken her");
        textField70.setTooltip(tooltip133);
        textField70.setCursor(Cursor.TEXT);

        checkBox1 = new CheckBox();
        checkBox1.setMaxWidth(200);
        Tooltip tooltip135 = new Tooltip();
        tooltip135.setText("Aktivere hvis plastictanken er intakt");
        checkBox1.setTooltip(tooltip135);
        checkBox1.setCursor(Cursor.TEXT);

        textFieldPlacering = new TextField();
        textFieldPlacering.setMaxWidth(200);
        Tooltip tooltip18 = new Tooltip();
        tooltip18.setText("Indtast hvor plastictanken står her");
        textFieldPlacering.setTooltip(tooltip18);
        textFieldPlacering.setCursor(Cursor.TEXT);
        placering1 = new ComboBox<>();
        placering1.setMaxWidth(200);
        Tooltip tooltip2 = new Tooltip();
        tooltip2.setText("Vælg placeringen af plastictanken her");
        placering1.setTooltip(tooltip2);
        placering1.setCursor(Cursor.TEXT);

        textField74 = new TextField();
        textField74.setMaxWidth(200);
        Tooltip tooltip3 = new Tooltip();
        tooltip139.setText("Indtast antal liter på plastictanken her");
        textField74.setTooltip(tooltip3);
        textField74.setCursor(Cursor.TEXT);

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

        HBox hBox22 = new HBox();
        hBox22.setPrefSize(250, 45);
        hBox22.setSpacing(5);
        hBox22.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox22.setTranslateY(-90);
        hBox22.getChildren().addAll(label114, checkBox1);

        HBox hBox25 = new HBox();
        hBox25.setPrefSize(250, 45);
        hBox25.setSpacing(5);
        hBox25.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox25.setTranslateY(-90);
        hBox25.getChildren().addAll(label117, textFieldPlacering, placering1);

        HBox hBox26 = new HBox();
        hBox26.setPrefSize(250, 45);
        hBox26.setSpacing(5);
        hBox26.setTranslateX(getGUI().getScreenHeight() * 0.5 + 125);
        hBox26.setTranslateY(-90);
        hBox26.getChildren().addAll(label118, textField74);


        getLayout().getChildren().addAll(label109, button64, button65, button66, hBox19, hBox20, hBox22, hBox25, hBox26);
    }

    @Override
    public void update() {
        textField69.setText("");
        textField70.setText("");
        textField74.setText("");
        textFieldPlacering.setText("");
        checkBox1.setSelected(false);
        placering1.setValue(null);
        List<String> placeringer = new ArrayList<>();
        for (Hylde hylde : getGUI().getController().getHylder())  {
            if (hylde == null || hylde.erOptaget() || !hylde.getReol().getAfdeling().getDrikkelse().equals(Drikkelse.GIN)) {
                continue;
            }
            placeringer.add(hylde.getPlacering());
        }
        FilteredList<String> filteredItems = new FilteredList<>(FXCollections.observableArrayList(placeringer));
        textFieldPlacering.textProperty().addListener((obs, oldValue, newValue) -> {
            final String selected = placering1.getSelectionModel().getSelectedItem();
            if (selected == null || !selected.equals(textFieldPlacering.getText())) {
                filteredItems.setPredicate(item -> {
                    if (item == null || item.isEmpty()) {
                        return false;
                    } else {
                        return item.toLowerCase().contains(newValue.toLowerCase());
                    }
                });
            }
        });
        placering1.setItems(filteredItems);
        placering1.valueProperty().addListener((obs, oldValue, newValue) -> {
            final String selected = placering1.getSelectionModel().getSelectedItem() == null ? "" : placering1.getSelectionModel().getSelectedItem();
            textFieldPlacering.setText(selected);
        });
    }

    private void opretFad() {
        String nummer = textField69.getText();
        String type = textField70.getText();
        boolean intakt = checkBox1.isSelected();
        String antalLiter = textField74.getText();
        String hylde = placering1.getValue();
        if (nummer.isEmpty() || type.isEmpty() || antalLiter.isEmpty()) {
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
        double antalLiterDouble;
        try {
            antalLiterDouble = Double.parseDouble(antalLiter);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Antal liter skal være et tal", "Antal liter skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        Hylde hyldeObjekt = null;
        if (hylde != null && !hylde.isEmpty()) {
            for (Hylde loopHylde : getGUI().getController().getHylder()) {
                if (loopHylde.getPlacering().equals(hylde)) {
                    hyldeObjekt = loopHylde;
                    break;
                }
            }
            if (hyldeObjekt == null) {
                getGUI().alert("Fejl", "Hylde findes ikke", "Hylde findes ikke", Alert.AlertType.ERROR).showAndWait();
                return;
            }
        }
        try {
            Opbevaring plastictank = getGUI().getController().createPlastictank(type, nummerInt, antalLiterDouble, intakt);
            if (hyldeObjekt != null) {
                getGUI().getController().addOpbevaringToHylde(plastictank, hyldeObjekt);
            }
            getGUI().switchScene(SceneType.PLASTICTANK);
        } catch (IllegalArgumentException e) {
            Alert alert = getGUI().alert("Fejl", "Plastictanken kunne ikke oprettes", e.getMessage(), Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    @Override
    public String getTitle() {
        return "Opret fad";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.FAD;
    }
}
