package gui.scene.scenes.afdeling;

import application.model.Afdeling;
import application.model.Drikkelse;
import application.model.Lager;
import application.model.ReolType;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class OpretAfdelingScene extends XScene {
    private TextField textField69, textField71, textField72, textField73, textField74;
    private ComboBox<Drikkelse> drikkelseComboBox;
    private ComboBox<String> lagerComboBox;

    public OpretAfdelingScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Opret Afdeling");
        label109.setTranslateX(0);
        label109.setTranslateY(-70);
        label109.setFont(new Font("Arial", 36));
        label109.setTextFill(Color.BLACK);
        ImageView lagerIcon = XIcon.HJEM.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.LEFT);

        Button button64 = new Button("Opret afdeling");
        button64.setTranslateX(-325);
        button64.setTranslateY(translateY + 45);
        button64.setPrefSize(250, 45);
        button64.setOnAction(e -> opretAfdeling());
        button64.setFont(new Font("Arial", 16));
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at oprette");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(0);
        button65.setTranslateY(translateY);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.AFDELING));
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
        label111.setAlignment(Pos.BASELINE_RIGHT);
        label111.setFont(XStyle.M_FONT);

        Label label112 = new Label("Drikkelse");
        label112.setPrefSize(100, 1);
        label112.setAlignment(Pos.BASELINE_RIGHT);
        label112.setFont(XStyle.M_FONT);

        Label label113 = new Label("Lager");
        label113.setPrefSize(100, 1);
        label113.setAlignment(Pos.BASELINE_RIGHT);
        label113.setFont(XStyle.M_FONT);

        Label label114 = new Label("Antal reoler");
        label114.setPrefSize(100, 1);
        label114.setTranslateX(20);
        label114.setAlignment(Pos.BASELINE_RIGHT);
        label114.setFont(XStyle.M_FONT);

        Label label115 = new Label(ReolType.LILLE.toString());
        label115.setPrefSize(100, 1);
        label115.setAlignment(Pos.BASELINE_RIGHT);
        label115.setFont(XStyle.M_FONT);

        Label label116 = new Label(ReolType.MELLEM.toString());
        label116.setPrefSize(100, 1);
        label116.setAlignment(Pos.BASELINE_RIGHT);
        label116.setFont(XStyle.M_FONT);

        Label label117 = new Label(ReolType.STOR.toString());
        label117.setPrefSize(100, 1);
        label117.setAlignment(Pos.BASELINE_RIGHT);
        label117.setFont(XStyle.M_FONT);

        textField69 = new TextField();
        textField69.setMaxWidth(100);
        Tooltip tooltip131 = new Tooltip();
        tooltip131.setText("Indtast nummeret for afdelingen her");
        textField69.setTooltip(tooltip131);
        textField69.setCursor(Cursor.TEXT);

        drikkelseComboBox = new ComboBox<>();
        drikkelseComboBox.setMaxWidth(100);
        Tooltip tooltip133 = new Tooltip();
        tooltip133.setText("Vælg drikkelse for afdelingen her");
        drikkelseComboBox.setTooltip(tooltip133);
        drikkelseComboBox.setCursor(Cursor.TEXT);

        textField71 = new TextField();
        textField71.setMaxWidth(100);
        Tooltip tooltip134 = new Tooltip();
        tooltip134.setText("Indtast lageret for afdelingen her");
        textField71.setTooltip(tooltip134);
        textField71.setCursor(Cursor.TEXT);

        lagerComboBox = new ComboBox<>();
        lagerComboBox.setMaxWidth(100);
        Tooltip tooltip132 = new Tooltip();
        tooltip132.setText("Vælg lageret for afdelingen her");
        lagerComboBox.setTooltip(tooltip132);
        lagerComboBox.setCursor(Cursor.TEXT);

        textField72 = new TextField();
        textField72.setMaxWidth(100);
        Tooltip tooltip135 = new Tooltip();
        tooltip135.setText("Indtast antallet af små reoler for afdelingen her");
        textField72.setTooltip(tooltip135);
        textField72.setCursor(Cursor.TEXT);

        textField73 = new TextField();
        textField73.setMaxWidth(100);
        Tooltip tooltip136 = new Tooltip();
        tooltip136.setText("Indtast antallet af mellem reoler for afdelingen her");
        textField73.setTooltip(tooltip136);
        textField73.setCursor(Cursor.TEXT);

        textField74 = new TextField();
        textField74.setMaxWidth(100);
        Tooltip tooltip140 = new Tooltip();
        tooltip137.setText("Indtast antallet af store reoler for afdelingen her");
        textField74.setTooltip(tooltip140);
        textField74.setCursor(Cursor.TEXT);

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
        hBox20.getChildren().addAll(label112, drikkelseComboBox);

        HBox hBox21 = new HBox();
        hBox21.setPrefSize(250, 45);
        hBox21.setSpacing(5);
        hBox21.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox21.setTranslateY(-90);
        hBox21.getChildren().addAll(label113, textField71, lagerComboBox);

        HBox hBox22 = new HBox();
        hBox22.setPrefSize(250, 45);
        hBox22.setSpacing(5);
        hBox22.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox22.setTranslateY(-90);
        hBox22.getChildren().addAll(label114);

        HBox hBox23 = new HBox();
        hBox23.setPrefSize(250, 45);
        hBox23.setSpacing(5);
        hBox23.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox23.setTranslateY(-90);
        hBox23.getChildren().addAll(label115, textField72);

        HBox hBox24 = new HBox();
        hBox24.setPrefSize(250, 45);
        hBox24.setSpacing(5);
        hBox24.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox24.setTranslateY(-90);
        hBox24.getChildren().addAll(label116, textField73);

        HBox hBox25 = new HBox();
        hBox25.setPrefSize(250, 45);
        hBox25.setSpacing(5);
        hBox25.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        hBox25.setTranslateY(-90);
        hBox25.getChildren().addAll(label117, textField74);


        getLayout().getChildren().addAll(label109, button64, button65, button66, hBox19, hBox20, hBox21, hBox22, hBox23, hBox24, hBox25);
    }

    private void opretAfdeling() {
        String nummer = textField69.getText();
        Drikkelse drikkelse = drikkelseComboBox.getValue();
        String lager = textField71.getText();
        String antalSmåReoler = textField72.getText();
        String antalMellemReoler = textField73.getText();
        String antalStoreReoler = textField74.getText();
        if (nummer.isEmpty() || drikkelse == null || lager.isEmpty()) {
            Alert alert = getGUI().alert("Fejl", "Afdelingen kunne ikke oprettes", "Udfyld venligst alle felter", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        int nummerInt;
        try {
            nummerInt = Integer.parseInt(nummer);
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Afdelingen kunne ikke oprettes", "Nummeret skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        Lager lagerObjekt = null;
        for (Lager lager1 : getGUI().getController().getLagere()) {
            String lagerString = "L" + lager1.getNummer() + " " + lager1;
            if (lagerString.equalsIgnoreCase(lager)) {
                lagerObjekt = lager1;
                break;
            }
        }
        if (lagerObjekt == null) {
            Alert alert = getGUI().alert("Fejl", "Afdelingen kunne ikke oprettes", "Lageret findes ikke", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }

        int antalSmåReolerInt = 0, antalMellemReolerInt = 0, antalStoreReolerInt = 0;
        try {
            if (!antalSmåReoler.isEmpty()) {
                antalSmåReolerInt = Integer.parseInt(antalSmåReoler);
            }
            if (!antalMellemReoler.isEmpty()) {
                antalMellemReolerInt = Integer.parseInt(antalMellemReoler);
            }
            if (!antalStoreReoler.isEmpty()) {
                antalStoreReolerInt = Integer.parseInt(antalStoreReoler);
            }
        } catch (NumberFormatException e) {
            Alert alert = getGUI().alert("Fejl", "Afdelingen kunne ikke oprettes", "Antallet af reoler skal være et tal", Alert.AlertType.ERROR);
            alert.showAndWait();
            return;
        }
        try {
            Afdeling afdeling = getGUI().getController().createAfdeling(lagerObjekt, drikkelse, nummerInt);
            for (int i = 0; i < antalSmåReolerInt; i++) {
                getGUI().getController().createReol(afdeling, ReolType.STOR);
            }
            for (int i = 0; i < antalMellemReolerInt; i++) {
                getGUI().getController().createReol(afdeling, ReolType.MELLEM);
            }
            for (int i = 0; i < antalStoreReolerInt; i++) {
                getGUI().getController().createReol(afdeling, ReolType.STOR);
            }
            getGUI().switchScene(SceneType.AFDELING);
        } catch (IllegalArgumentException e) {
            Alert alert = getGUI().alert("Fejl", "Afdelingen kunne ikke oprettes", e.getMessage(), Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    @Override
    public void update() {
        textField69.setText("");
        textField71.setText("");
        textField72.setText("");
        textField73.setText("");
        textField74.setText("");
        drikkelseComboBox.setValue(null);
        for (Drikkelse drikkelse : Drikkelse.values()) {
            drikkelseComboBox.getItems().add(drikkelse);
        }
        lagerComboBox.setValue(null);
        List<String> lagere = new ArrayList<>();
        for (Lager lager : getGUI().getController().getLagere()) {
            lagere.add("L" + lager.getNummer() + " " + lager);
        }
        FilteredList<String> filteredItems = new FilteredList<>(FXCollections.observableArrayList(lagere));
        textField71.textProperty().addListener((obs, oldValue, newValue) -> {
            final String selected = lagerComboBox.getSelectionModel().getSelectedItem();
            if (selected == null || !selected.equals(textField71.getText())) {
                filteredItems.setPredicate(item -> {
                    if (item == null || item.isEmpty()) {
                        return false;
                    } else {
                        return item.toLowerCase().contains(newValue.toLowerCase());
                    }
                });
            }
        });
        lagerComboBox.setItems(filteredItems);
        lagerComboBox.valueProperty().addListener((obs, oldValue, newValue) -> {
            final String selected = lagerComboBox.getSelectionModel().getSelectedItem() == null ? "" : lagerComboBox.getSelectionModel().getSelectedItem();
            textField71.setText(selected);
        });
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