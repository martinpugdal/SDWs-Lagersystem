package gui.scene.scenes;

import application.model.Afdeling;
import application.model.Lager;
import application.model.flaske.Ginflaske;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.ginflaske.RedigerGinflaskeScene;
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

public class GinflaskeScene extends XScene {

    private TableView<Ginflaske> ginflaskeTableView;

    public GinflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Ginflaske");
        label107.setTranslateX(-550);
        label107.setTranslateY(10);
        label107.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.GINFLASKE.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button60 = new Button("Opret ginflaske");
        button60.setTranslateX(-550 + (buttonWidth + 20));
        button60.setTranslateY(- buttonHeight);
        button60.setPrefSize(buttonWidth, buttonHeight);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETGINFLASKE));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette en ny ginflaske");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger ginflaske");
        button61.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button61.setTranslateY(-buttonHeight * 2);
        button61.setPrefSize(buttonWidth, buttonHeight);
        button61.setOnAction(e -> redigerGinflaske());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere en ginflaske");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet ginflaske");
        button62.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button62.setTranslateY(-buttonHeight * 3);
        button62.setPrefSize(buttonWidth, buttonHeight);
        button62.setOnAction(e -> sletGinflaske());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette en ginflaske");
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

        Label label108 = new Label("Her ses en oversigt over alle ginflasker");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        ginflaskeTableView = new TableView<>();
        ginflaskeTableView.setPlaceholder(new Label("Der er ingen ginflasker"));
        ginflaskeTableView.setEditable(false);
        ginflaskeTableView.setPrefSize(200, 450);
        ginflaskeTableView.setTranslateX(0);
        ginflaskeTableView.setTranslateY(-30);
        ginflaskeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(ginflaskeTableView, new Insets(0, 20, 0, 20));
        TableColumn<Ginflaske, Integer> nrC = new TableColumn<>("Nummer");
        nrC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        TableColumn<Ginflaske, String> navnC = new TableColumn<>("Navn");
        navnC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNavn()));
        TableColumn<Ginflaske, Double> alkoholprocentC = new TableColumn<>("Alkoholprocent");
        alkoholprocentC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAlkoholprocent()));
        TableColumn<Ginflaske, Integer> antalFlaskerC = new TableColumn<>("Antal flasker");
        antalFlaskerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAntal()));
        ginflaskeTableView.getColumns().add(nrC);
        ginflaskeTableView.getColumns().add(navnC);
        ginflaskeTableView.getColumns().add(alkoholprocentC);
        ginflaskeTableView.getColumns().add(antalFlaskerC);
        for (TableColumn<Ginflaske, ?> column : ginflaskeTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button60, button61, button62, button63, label108, ginflaskeTableView);
    }

    private void redigerGinflaske() {
        if (ginflaskeTableView.getSelectionModel().getSelectedItem() != null) {
            ((RedigerGinflaskeScene) getGUI().getScene(SceneType.REDIGERGINFLASKE)).setSelectedGinflaske(ginflaskeTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERGINFLASKE);
        } else {
            getGUI().alert("Ingen ginflaske valgt", "Du har ikke valgt en ginflaske", "Vælg en ginflaske fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletGinflaske() {
        if (ginflaskeTableView.getSelectionModel().getSelectedItem() != null) {
            Ginflaske ginflaske = ginflaskeTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet ginflaske", "Er du sikker på at du vil slette ginflasken?", "Du er ved at slette ginflasken " + ginflaske + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteFlaske(ginflaske);
                update();
            }
        } else {
            getGUI().alert("Ingen ginflaske valgt", "Du har ikke valgt en ginflaske", "Vælg en ginflaske fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerGinflaskeScene) getGUI().getScene(SceneType.REDIGERGINFLASKE)).setSelectedGinflaske(null);
        ginflaskeTableView.getItems().clear();
        ginflaskeTableView.getItems().addAll(getGUI().getController().getGinflasker());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Ginflaske";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.GINFLASKE;
    }
}
