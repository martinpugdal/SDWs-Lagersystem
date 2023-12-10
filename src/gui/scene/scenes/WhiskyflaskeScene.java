package gui.scene.scenes;

import application.model.flaske.Whiskyflaske;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.whiskyflaske.RedigerWhiskyflaskeScene;
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

public class WhiskyflaskeScene extends XScene {

    private TableView<Whiskyflaske> whiskyflaskeTableView;

    public WhiskyflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Whiskyflaske");
        label107.setTranslateX(-550);
        label107.setTranslateY(10);
        label107.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.WHISKYFLASKE.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button60 = new Button("Opret whiskyflaske");
        button60.setTranslateX(-550 + (buttonWidth + 20));
        button60.setTranslateY(- buttonHeight);
        button60.setPrefSize(buttonWidth, buttonHeight);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETWHISKYFLASKE));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette en ny whiskyflaske");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger whiskyflaske");
        button61.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button61.setTranslateY(-buttonHeight * 2);
        button61.setPrefSize(buttonWidth, buttonHeight);
        button61.setOnAction(e -> redigerwhiskyflaske());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere en whiskyflaske");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet whiskyflaske");
        button62.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button62.setTranslateY(-buttonHeight * 3);
        button62.setPrefSize(buttonWidth, buttonHeight);
        button62.setOnAction(e -> sletWhiskyflaske());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette en whiskyflaske");
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

        Label label108 = new Label("Her ses en oversigt over alle whiskyflasker");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        whiskyflaskeTableView = new TableView<>();
        whiskyflaskeTableView.setPlaceholder(new Label("Der er ingen whiskyflasker"));
        whiskyflaskeTableView.setEditable(false);
        whiskyflaskeTableView.setPrefSize(200, 450);
        whiskyflaskeTableView.setTranslateX(0);
        whiskyflaskeTableView.setTranslateY(-30);
        whiskyflaskeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(whiskyflaskeTableView, new Insets(0, 20, 0, 20));
        TableColumn<Whiskyflaske, Integer> nrC = new TableColumn<>("Nummer");
        nrC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        TableColumn<Whiskyflaske, String> navnC = new TableColumn<>("Navn");
        navnC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNavn()));
        TableColumn<Whiskyflaske, Double> alkoholprocentC = new TableColumn<>("Alkoholprocent");
        alkoholprocentC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAlkoholprocent()));
        TableColumn<Whiskyflaske, Integer> antalFlaskerC = new TableColumn<>("Antal flasker");
        antalFlaskerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAntal()));
        whiskyflaskeTableView.getColumns().add(nrC);
        whiskyflaskeTableView.getColumns().add(navnC);
        whiskyflaskeTableView.getColumns().add(alkoholprocentC);
        whiskyflaskeTableView.getColumns().add(antalFlaskerC);
        for (TableColumn<Whiskyflaske, ?> column : whiskyflaskeTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button60, button61, button62, button63, label108, whiskyflaskeTableView);
    }

    private void redigerwhiskyflaske() {
        if (whiskyflaskeTableView.getSelectionModel().getSelectedItem() != null) {
            ((RedigerWhiskyflaskeScene) getGUI().getScene(SceneType.REDIGERWHISKYFLASKE)).setSelectedWhiskyflaske(whiskyflaskeTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERWHISKYFLASKE);
        } else {
            getGUI().alert("Ingen whiskyflaske valgt", "Du har ikke valgt en whiskyflaske", "Vælg en whiskyflaske fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletWhiskyflaske() {
        if (whiskyflaskeTableView.getSelectionModel().getSelectedItem() != null) {
            Whiskyflaske whiskyflaske = whiskyflaskeTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet whiskyflaske", "Er du sikker på at du vil slette whiskyflasken?", "Du er ved at slette whiskyflasken " + whiskyflaske + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteFlaske(whiskyflaske);
                update();
            }
        } else {
            getGUI().alert("Ingen whiskyflaske valgt", "Du har ikke valgt en whiskyflaske", "Vælg en whiskyflaske fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerWhiskyflaskeScene) getGUI().getScene(SceneType.REDIGERWHISKYFLASKE)).setSelectedWhiskyflaske(null);
        whiskyflaskeTableView.getItems().clear();
        whiskyflaskeTableView.getItems().addAll(getGUI().getController().getWhiskyflasker());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Whiskyflaske";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.WHISKYFLASKE;
    }
}
