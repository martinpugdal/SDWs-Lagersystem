package gui.scene.scenes;

import application.model.Afdeling;
import application.model.Lager;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.lager.RedigerLagerScene;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.beans.property.*;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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

        Label label107 = new Label("Lagre");
        label107.setTranslateX(0);
        label107.setTranslateY(150);
        label107.setFont(new Font("Arial", 36));
        label107.setTextFill(Color.BLACK);

        Label label108 = new Label("Her ses en oversigt over lagre");
        label108.setTranslateX(0);
        label108.setTranslateY(150);
        label108.setFont(new Font("Arial", 16));
        label108.setTextFill(Color.BLACK);

        lagerTableView = new TableView<>();
            lagerTableView.setEditable(false);
            TableColumn<Lager, Integer> lagerNRColumn = new TableColumn<>("Nummer");
            lagerNRColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
            TableColumn<Lager, String> lagerAdresseColumn = new TableColumn<>("Adresse");
            lagerAdresseColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdresse()));
            TableColumn<Lager, Double> lagerKVMColumn = new TableColumn<>("Kvadratmeter (m²)");
            lagerKVMColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getStørrelse()));
            TableColumn<Lager, List<Afdeling>> lagerAfdelingColumn = new TableColumn<>("Afdelinger");
            lagerAfdelingColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAfdelinger()));
            lagerTableView.getColumns().add(lagerNRColumn);
            lagerTableView.getColumns().add(lagerAdresseColumn);
            lagerTableView.getColumns().add(lagerKVMColumn);
            lagerTableView.getColumns().add(lagerAfdelingColumn);
            lagerTableView.setPlaceholder(new Label("Der er ingen lagre"));
            lagerTableView.getItems().addAll(getGUI().getController().getLagere());
        lagerTableView.setTranslateX(20);
        lagerTableView.setTranslateY(20);
        lagerTableView.setPrefSize(200, 200);

        ImageView imageView16 = XIcon.LAGER.getImageView();
        imageView16.setFitHeight(100);
        imageView16.setFitWidth(100);
        imageView16.setTranslateX(10);
        imageView16.setTranslateY(-10);
        getLayout().getChildren().add(imageView16);

        Button button60 = new Button("Opret lager");
        button60.setTranslateX(-150);
        button60.setTranslateY(-280);
        button60.setPrefSize(250, 45);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETLAGER));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette et lager");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger lager");
        button61.setTranslateX(-150);
        button61.setTranslateY(-280);
        button61.setPrefSize(250, 45);
        button61.setOnAction(e -> redigerLager());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere et lager");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet lager");
        button62.setTranslateX(-150);
        button62.setTranslateY(-280);
        button62.setPrefSize(250, 45);
        button62.setOnAction(e -> sletLager());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette et lager");
        button62.setTooltip(tooltip129);

        Button button63 = new Button("Gå tilbage til forside");
        button63.setTranslateX(-150);
        button63.setTranslateY(-280);
        button63.setPrefSize(250, 45);
        button63.setOnAction(e -> getGUI().gåTilForside());
        button63.setFont(new Font("Arial", 16));
        button63.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button63.setCursor(Cursor.HAND);
        Tooltip tooltip130 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button63.setTooltip(tooltip130);

        getLayout().getChildren().addAll(label107, label108, lagerTableView, button60, button61, button62, button63);

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
            Alert confirmation = getGUI().alert("Slet lager", "Er du sikker på at du vil slette lageret?", "Du er ved at slette lageret " + lager.getAdresse() + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
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
        return null;
    }

    @Override
    public XIcon getIcon() {
        return null;
    }
}
