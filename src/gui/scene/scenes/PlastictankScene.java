package gui.scene.scenes;

import application.model.opbevaring.Plastictank;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.plastictank.RedigerPlastictankScene;
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

public class PlastictankScene extends XScene {

    private TableView<Plastictank> plastictankTableView;

    public PlastictankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Plastic tank");
        label107.setTranslateX(-550);
        label107.setTranslateY(10);
        label107.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.PLASTIKTANK.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button60 = new Button("Opret Plastic tank");
        button60.setTranslateX(-550 + (buttonWidth + 20));
        button60.setTranslateY(-buttonHeight);
        button60.setPrefSize(buttonWidth, buttonHeight);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETPLASTICTANK));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette en plastic tank");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger Plastic tank");
        button61.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button61.setTranslateY(-buttonHeight * 2);
        button61.setPrefSize(buttonWidth, buttonHeight);
        button61.setOnAction(e -> redigerPlastictank());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere en plastic tank");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet Plastic tank");
        button62.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button62.setTranslateY(-buttonHeight * 3);
        button62.setPrefSize(buttonWidth, buttonHeight);
        button62.setOnAction(e -> sletPlastictank());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette en plastic tank");
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

        Label label108 = new Label("Her ses en oversigt over plastic tanke");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        plastictankTableView = new TableView<>();
        plastictankTableView.setPlaceholder(new Label("Der er ingen plastictank"));
        plastictankTableView.setEditable(false);
        plastictankTableView.setPrefSize(200, 450);
        plastictankTableView.setTranslateX(0);
        plastictankTableView.setTranslateY(-30);
        plastictankTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(plastictankTableView, new Insets(0, 20, 0, 20));
        TableColumn<Plastictank, Integer> nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        plastictankTableView.getColumns().add(nummerC);
        TableColumn<Plastictank, String> navnC = new TableColumn<>("Navn");
        navnC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNavn()));
        plastictankTableView.getColumns().add(navnC);
        TableColumn<Plastictank, Integer> årgangC = new TableColumn<>("Årgang");
        årgangC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getÅrgang() == -1 ? null : cellData.getValue().getÅrgang()));
        plastictankTableView.getColumns().add(årgangC);
        TableColumn<Plastictank, String> intaktC = new TableColumn<>("Intakt");
        intaktC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().isIntakt() ? "Ja" : "Nej"));
        plastictankTableView.getColumns().add(intaktC);
        TableColumn<Plastictank, Double> volumenC = new TableColumn<>("Volumen (L)");
        volumenC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        plastictankTableView.getColumns().add(volumenC);
        TableColumn<Plastictank, String> tomC = new TableColumn<>("Tom");
        tomC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().isTom() ? "Ja" : "Nej"));
        plastictankTableView.getColumns().add(tomC);
        TableColumn<Plastictank, String> placeringC = new TableColumn<>("Placering");
        placeringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        plastictankTableView.getColumns().add(placeringC);
        TableColumn<Plastictank, LocalDate> påfyldningsdatoC = new TableColumn<>("Påfyldningsdato");
        påfyldningsdatoC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning() != null ? cellData.getValue().getPåfyldning().getDato() : null));
        plastictankTableView.getColumns().add(påfyldningsdatoC);
        TableColumn<Plastictank, String> destilleringC = new TableColumn<>("Destillering");
        destilleringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning() != null ? cellData.getValue().getPåfyldning().getDestillering().toString() : null));
        plastictankTableView.getColumns().add(destilleringC);
        TableColumn<Plastictank, Double> påfyldtLiterC = new TableColumn<>("Påfyldt liter");
        påfyldtLiterC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning() != null ? cellData.getValue().getPåfyldning().getLiter() : null));
        plastictankTableView.getColumns().add(påfyldtLiterC);
        for (TableColumn<Plastictank, ?> column : plastictankTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button60, button61, button62, button63, label108, plastictankTableView);
    }

    private void redigerPlastictank() {
        if (plastictankTableView.getSelectionModel().getSelectedItem() != null) {
            ((RedigerPlastictankScene) getGUI().getScene(SceneType.REDIGERPLASTICTANK)).setSelectedPlastictank(plastictankTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERPLASTICTANK);
        } else {
            getGUI().alert("Ingen plastictank valgt", "Du har ikke valgt en plastictank", "Vælg em plastictank fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletPlastictank() {
        if (plastictankTableView.getSelectionModel().getSelectedItem() != null) {
            Plastictank plastictank = plastictankTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet plastictank", "Er du sikker på at du vil slette plastictanken?", "Du er ved at slette plastictanken " + plastictank + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteOpbevaring(plastictank);
                update();
            }
        } else {
            getGUI().alert("Ingen plastictank valgt", "Du har ikke valgt en plastictank", "Vælg en plastictank fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerPlastictankScene) getGUI().getScene(SceneType.REDIGERPLASTICTANK)).setSelectedPlastictank(null);
        plastictankTableView.getItems().clear();
        plastictankTableView.getItems().addAll(getGUI().getController().getPlastictanke());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Plastictank";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.PLASTIKTANK;
    }
}
