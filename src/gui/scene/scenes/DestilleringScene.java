package gui.scene.scenes;

import application.model.Destillering;
import application.model.Opbevaring;
import application.model.opbevaring.Fad;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.destillering.RedigerDestilleringScene;
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
import javafx.scene.text.Font;

import java.util.List;

public class DestilleringScene extends XScene {

    private TableView<Destillering> destilleringTableView;

    public DestilleringScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Destillering");
        label107.setTranslateX(-550);
        label107.setTranslateY(10);
        label107.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.DESTILLERING.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button60 = new Button("Opret destillering");
        button60.setTranslateX(-550 + buttonWidth + 20);
        button60.setTranslateY(-buttonHeight + 10);
        button60.setPrefSize(buttonWidth, buttonHeight);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETDESTILLERING));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette en destillering");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger destillering");
        button61.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button61.setTranslateY(-buttonHeight - 24);
        button61.setPrefSize(buttonWidth, buttonHeight);
        button61.setOnAction(e -> redigerDestillering());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere en destillering");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet destillering");
        button62.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button62.setTranslateY(-buttonHeight - 57);
        button62.setPrefSize(buttonWidth, buttonHeight);
        button62.setOnAction(e -> sletDestillering());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette en destillering");
        button62.setTooltip(tooltip129);

        Button button65 = new Button("Gå tilbage til forside");
        button65.setTranslateX(-550 + (buttonWidth + 20) * 4);
        button65.setTranslateY(-buttonHeight - 90);
        button65.setPrefSize(buttonWidth, buttonHeight);
        button65.setOnAction(e -> getGUI().gåTilForside());
        button65.setFont(new Font("Arial", 16));
        button65.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button65.setCursor(Cursor.HAND);
        Tooltip tooltip132 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button65.setTooltip(tooltip132);

        Button button63 = new Button("Overfør destillering (fad)");
        button63.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button63.setTranslateY(-buttonHeight - 70);
        button63.setPrefSize(buttonWidth, buttonHeight);
        button63.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERINGFAD));
        button63.setFont(new Font("Arial", 16));
        button63.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button63.setCursor(Cursor.HAND);
        Tooltip tooltip130 = new Tooltip("Tryk her for at tilføje/fjerne destilleringsvæske til/fra et fad");
        button63.setTooltip(tooltip130);

        Button button64 = new Button("Overfør destillering (tank)");
        button64.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button64.setTranslateY(-buttonHeight - 104);
        button64.setPrefSize(buttonWidth, buttonHeight);
        button64.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERINGTANK));
        button64.setFont(new Font("Arial", 16));
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip131 = new Tooltip("Tryk her for at tilføje/fjerne destilleringsvæske til/fra en plastictank");
        button64.setTooltip(tooltip131);


        Label label10 = new Label("Her kan der oprettes væsker som så kan fordeles på fade og tanke");
        label10.setTranslateX(0);
        label10.setTranslateY(-50);
        label10.setFont(XStyle.M_FONT);

        destilleringTableView = new TableView<>();
        destilleringTableView.setPlaceholder(new Label("Der er ingen destilleringer"));
        destilleringTableView.setEditable(false);
        destilleringTableView.setEditable(false);
        destilleringTableView.setPrefSize(200, 450);
        destilleringTableView.setTranslateX(0);
        destilleringTableView.setTranslateY(-30);
        destilleringTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(destilleringTableView, new Insets(0, 20, 0, 20));

        TableColumn<Destillering, Integer> destilleringNummerColumn = new TableColumn<>("Nummer");
        destilleringNummerColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        destilleringTableView.getColumns().add(destilleringNummerColumn);
        TableColumn<Destillering, String> destilleringNavnColumn = new TableColumn<>("Navn");
        destilleringNavnColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNavn()));
        destilleringTableView.getColumns().add(destilleringNavnColumn);
        TableColumn<Destillering, Double> destilleringLiterColumn = new TableColumn<>("Antal liter");
        destilleringLiterColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLiter()));
        destilleringTableView.getColumns().add(destilleringLiterColumn);
        TableColumn<Destillering, Double> destilleringAlkoholProcent = new TableColumn<>("Alkoholprocent");
        destilleringAlkoholProcent.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAlkoholprocent()));
        destilleringTableView.getColumns().add(destilleringAlkoholProcent);
        TableColumn<Destillering, List<Opbevaring>> destilleringOpbevaringC = new TableColumn<>("Påfyldninger");
        destilleringOpbevaringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning() != null ? cellData.getValue().getPåfyldning().getOpbevaringer() : null));
        destilleringTableView.getColumns().add(destilleringOpbevaringC);
        destilleringTableView.getItems().addAll(getGUI().getController().getDestilleringer());
        for (TableColumn<Destillering, ?> column : destilleringTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button60, button61, button62, button65, button63, button64, label10, destilleringTableView);
    }

    private void redigerDestillering() {
        if (destilleringTableView.getSelectionModel().getSelectedItem() != null) {
            RedigerDestilleringScene scene = (RedigerDestilleringScene) getGUI().getScene(SceneType.REDIGERDESTILLERING);
            scene.setSelectedDestillering(destilleringTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(scene);
        } else {
            getGUI().alert("Ingen destillering valgt", "Du har ikke valgt en destillering", "Vælg en destillering fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletDestillering() {
        if (destilleringTableView.getSelectionModel().getSelectedItem() != null) {
            Destillering destillering = destilleringTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet destillering", "Er du sikker på at du vil slette destilleringen?", "Du er ved at slette destilleringen " + destillering + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteDestillering(destillering);
                update();
            }
        } else {
            getGUI().alert("Ingen destillering valgt", "Du har ikke valgt en destillering", "Vælg en destillering fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerDestilleringScene) getGUI().getScene(SceneType.REDIGERDESTILLERING)).setSelectedDestillering(null);
        destilleringTableView.getItems().clear();
        destilleringTableView.getItems().addAll(getGUI().getController().getDestilleringer());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Destillering";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.DESTILLERING;
    }
}
