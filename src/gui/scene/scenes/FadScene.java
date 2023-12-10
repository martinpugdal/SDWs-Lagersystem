package gui.scene.scenes;

import application.model.opbevaring.Fad;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.fad.RedigerFadScene;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.time.LocalDate;

public class FadScene extends XScene {

    private TableView<Fad> fadTableView;

    public FadScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Fad");
        label107.setTranslateX(-550);
        label107.setTranslateY(10);
        label107.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.FAD.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button60 = new Button("Opret Fad");
        button60.setTranslateX(-550 + (buttonWidth + 20));
        button60.setTranslateY(-buttonHeight);
        button60.setPrefSize(buttonWidth, buttonHeight);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETFAD));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette et fad");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger fad");
        button61.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button61.setTranslateY(-buttonHeight * 2);
        button61.setPrefSize(buttonWidth, buttonHeight);
        button61.setOnAction(e -> redigerFad());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere et fad");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet fad");
        button62.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button62.setTranslateY(-buttonHeight * 3);
        button62.setPrefSize(buttonWidth, buttonHeight);
        button62.setOnAction(e -> sletFad());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette et fad");
        button62.setTooltip(tooltip129);

        Button button63 = new Button("Gå tilbage til forside");
        button63.setTranslateX(-550 + (buttonWidth + 20) * 4);
        button63.setTranslateY(-buttonHeight * 4);
        button63.setPrefSize(buttonWidth, buttonHeight);
        button63.setOnAction(e -> getGUI().gåTilForside());
        button63.setFont(new Font("Arial", 16));
        button63.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button63.setCursor(Cursor.HAND);
        Tooltip tooltip130 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button63.setTooltip(tooltip130);

        Label label108 = new Label("Her ses en oversigt over fade");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        fadTableView = new TableView<>();
        fadTableView.setPlaceholder(new Label("Der er ingen fade"));
        fadTableView.setEditable(false);
        fadTableView.setPrefSize(200, 450);
        fadTableView.setTranslateX(0);
        fadTableView.setTranslateY(-30);
        fadTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(fadTableView, new Insets(0, 20, 0, 20));
        TableColumn<Fad, Integer> nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        fadTableView.getColumns().add(nummerC);
        TableColumn<Fad, String> typeC = new TableColumn<>("Type");
        typeC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getType()));
        fadTableView.getColumns().add(typeC);
        TableColumn<Fad, Integer> gangeBrugtC = new TableColumn<>("Gange brugt");
        gangeBrugtC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getGangeBrugt()));
        fadTableView.getColumns().add(gangeBrugtC);
        TableColumn<Fad, String> intaktC = new TableColumn<>("Intakt");
        intaktC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().isIntakt() ? "Ja" : "Nej"));
        fadTableView.getColumns().add(intaktC);
        TableColumn<Fad, String> volumenC = new TableColumn<>("Volumen");
        volumenC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen() + " L"));
        fadTableView.getColumns().add(volumenC);
        TableColumn<Fad, String> tomC = new TableColumn<>("Tom");
        tomC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().isTom() ? "Ja" : "Nej"));
        fadTableView.getColumns().add(tomC);
        TableColumn<Fad, String> placeringC = new TableColumn<>("Placering");
        placeringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        fadTableView.getColumns().add(placeringC);
        TableColumn<Fad, LocalDate> påfyldningsdatoC = new TableColumn<>("Påfyldningsdato");
        påfyldningsdatoC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning() != null ? cellData.getValue().getPåfyldning().getDato() : null));
        fadTableView.getColumns().add(påfyldningsdatoC);
        TableColumn<Fad, String> destilleringC = new TableColumn<>("Destillering");
        destilleringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning() != null ? cellData.getValue().getPåfyldning().getDestillering().toString() : null));
        fadTableView.getColumns().add(destilleringC);
        TableColumn<Fad, Double> påfyldtLiterC = new TableColumn<>("Påfyldt liter");
        påfyldtLiterC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning() != null ? cellData.getValue().getPåfyldning().getLiter() : null));
        fadTableView.getColumns().add(påfyldtLiterC);
        for (TableColumn<Fad, ?> column : fadTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button60, button61, button62, button63, label108, fadTableView);
    }

    private void redigerFad() {
        if (fadTableView.getSelectionModel().getSelectedItem() != null) {
            ((RedigerFadScene) getGUI().getScene(SceneType.REDIGERFAD)).setSelectedFad(fadTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERFAD);
        } else {
            getGUI().alert("Ingen fad valgt", "Du har ikke valgt et fad", "Vælg et fad fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletFad() {
        if (fadTableView.getSelectionModel().getSelectedItem() != null) {
            Fad fad = fadTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet fad", "Er du sikker på at du vil slette fadet?", "Du er ved at slette fadet " + fad + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteOpbevaring(fad);
                update();
            }
        } else {
            getGUI().alert("Ingen fad valgt", "Du har ikke valgt et fad", "Vælg et fad fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerFadScene) getGUI().getScene(SceneType.REDIGERFAD)).setSelectedFad(null);
        fadTableView.getItems().clear();
        fadTableView.getItems().addAll(getGUI().getController().getFade());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Fad";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.FAD;
    }
}
