package gui.scene.scenes;

import application.model.Afdeling;
import application.model.Lager;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.lager.RedigerLagerScene;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class LagerScene extends XScene {

    private TableView<Lager> lagerTableView;

    public LagerScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 17: Lagre
        Label label107 = new Label("Lager");
        label107.setTranslateX(-550);
        label107.setTranslateY(-100);
        label107.setFont(new Font("Arial", 36));
        label107.setTextFill(Color.BLACK);
        ImageView lagerIcon = XIcon.LAGER.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button60 = new Button("Opret lager");
        button60.setTranslateX(-550 + (buttonWidth + 20));
        button60.setTranslateY(-110 - buttonHeight);
        button60.setPrefSize(buttonWidth, buttonHeight);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETLAGER));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette et lager");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger lager");
        button61.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button61.setTranslateY(-110 - buttonHeight * 2);
        button61.setPrefSize(buttonWidth, buttonHeight);
        button61.setOnAction(e -> redigerLager());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere et lager");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet lager");
        button62.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button62.setTranslateY(-110 - buttonHeight * 3);
        button62.setPrefSize(buttonWidth, buttonHeight);
        button62.setOnAction(e -> sletLager());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette et lager");
        button62.setTooltip(tooltip129);

        Button button63 = new Button("Gå tilbage til forside");
        button63.setTranslateX(-550 + (buttonWidth + 20) * 4);
        button63.setTranslateY(-110 - buttonHeight * 4);
        button63.setPrefSize(buttonWidth, buttonHeight);
        button63.setOnAction(e -> getGUI().gåTilForside());
        button63.setFont(new Font("Arial", 16));
        button63.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button63.setCursor(Cursor.HAND);
        Tooltip tooltip130 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button63.setTooltip(tooltip130);

        Label label108 = new Label("Her ses en oversigt over lagre");
        label108.setTranslateX(0);
        label108.setTranslateY(-200);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        lagerTableView = new TableView<>();
        lagerTableView.setPlaceholder(new Label("Der er ingen lagre"));
        lagerTableView.setEditable(false);
        lagerTableView.setPrefSize(200, 200);
        lagerTableView.setTranslateX(0);
        lagerTableView.setTranslateY(-175);
        lagerTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(lagerTableView, new Insets(0, 20, 0, 20));
        TableColumn<Lager, Integer> lagerNRColumn = new TableColumn<>("Nummer");
        lagerNRColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        TableColumn<Lager, String> lagerAdresseColumn = new TableColumn<>("Adresse");
        lagerAdresseColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdresse()));
        TableColumn<Lager, String> lagerPostNrColumn = new TableColumn<>("Postnummer");
        lagerPostNrColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPostnummer()));
        TableColumn<Lager, String> lagerByColumn = new TableColumn<>("By");
        lagerByColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBy()));
        TableColumn<Lager, Double> lagerKVMColumn = new TableColumn<>("Kvadratmeter (m²)");
        lagerKVMColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getStørrelse()));
        TableColumn<Lager, List<Afdeling>> lagerAfdelingColumn = new TableColumn<>("Afdelinger");
        lagerAfdelingColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAfdelinger()));
        lagerTableView.getColumns().add(lagerNRColumn);
        lagerTableView.getColumns().add(lagerAdresseColumn);
        lagerTableView.getColumns().add(lagerPostNrColumn);
        lagerTableView.getColumns().add(lagerByColumn);
        lagerTableView.getColumns().add(lagerKVMColumn);
        lagerTableView.getColumns().add(lagerAfdelingColumn);
        for (TableColumn<Lager, ?> column : lagerTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button60, button61, button62, button63, label108, lagerTableView);
    }

    private void redigerLager() {
        if (lagerTableView.getSelectionModel().getSelectedItem() != null) {
            ((RedigerLagerScene) getGUI().getScene(SceneType.REDIGERLAGER)).setSelectedLager(lagerTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERLAGER);
        } else {
            getGUI().alert("Ingen lager valgt", "Du har ikke valgt et lager", "Vælg et lager fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletLager() {
        if (lagerTableView.getSelectionModel().getSelectedItem() != null) {
            Lager lager = lagerTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet lager", "Er du sikker på at du vil slette lageret?", "Du er ved at slette lageret " + lager.getFuldeAdresse() + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteLager(lager);
                update();
            }
        } else {
            getGUI().alert("Ingen lager valgt", "Du har ikke valgt et lager", "Vælg et lager fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerLagerScene) getGUI().getScene(SceneType.REDIGERLAGER)).setSelectedLager(null);
        lagerTableView.getItems().clear();
        lagerTableView.getItems().addAll(getGUI().getController().getLagere());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Lager";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.LAGER;
    }
}
