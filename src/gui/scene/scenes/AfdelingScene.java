package gui.scene.scenes;

import application.model.Afdeling;
import application.model.Lager;
import gui.GUI;
import gui.scene.SceneType;
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

public class AfdelingScene extends XScene {

    private TableView<Afdeling> afdelingTableView;

    public AfdelingScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Afdelinger");
        label107.setTranslateX(-550);
        label107.setTranslateY(10);
        label107.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.HJEM.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button60 = new Button("Opret Afdeling");
        button60.setTranslateX(-550 + (buttonWidth + 20));
        button60.setTranslateY(-buttonHeight);
        button60.setPrefSize(buttonWidth, buttonHeight);
        button60.setOnAction(e -> getGUI().switchScene(SceneType.OPRETLAGER));
        button60.setFont(new Font("Arial", 16));
        button60.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button60.setCursor(Cursor.HAND);
        Tooltip tooltip127 = new Tooltip("Tryk her for at oprette en afdeling");
        button60.setTooltip(tooltip127);

        Button button61 = new Button("Rediger afdeing");
        button61.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button61.setTranslateY(-buttonHeight * 2);
        button61.setPrefSize(buttonWidth, buttonHeight);
        button61.setOnAction(e -> redigerLager());
        button61.setFont(new Font("Arial", 16));
        button61.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button61.setCursor(Cursor.HAND);
        Tooltip tooltip128 = new Tooltip("Tryk her for at redigere en afdeling");
        button61.setTooltip(tooltip128);

        Button button62 = new Button("Slet afdeling");
        button62.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button62.setTranslateY(-buttonHeight * 3);
        button62.setPrefSize(buttonWidth, buttonHeight);
        button62.setOnAction(e -> sletLager());
        button62.setFont(new Font("Arial", 16));
        button62.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button62.setCursor(Cursor.HAND);
        Tooltip tooltip129 = new Tooltip("Tryk her for at slette en afdeling");
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

        Label label108 = new Label("Her ses en oversigt over afdelinger");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        afdelingTableView = new TableView<>();
        afdelingTableView.setPlaceholder(new Label("Der er ingen afdelinger"));
        afdelingTableView.setEditable(false);
        afdelingTableView.setPrefSize(200, 450);
        afdelingTableView.setTranslateX(0);
        afdelingTableView.setTranslateY(-30);
        afdelingTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(afdelingTableView, new Insets(0, 20, 0, 20));
        TableColumn<Afdeling, Lager> lagerC = new TableColumn<>("Lager");
        lagerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLager()));
        afdelingTableView.getColumns().add(lagerC);
        TableColumn<Afdeling, Integer> nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        afdelingTableView.getColumns().add(nummerC);
        TableColumn<Afdeling, String> drikkelseC = new TableColumn<>("Drikkelse");
        drikkelseC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDrikkelse().toString().substring(0, 1).toUpperCase() + cellData.getValue().getDrikkelse().toString().substring(1).toLowerCase()));
        afdelingTableView.getColumns().add(drikkelseC);
        TableColumn<Afdeling, String> reolerC = new TableColumn<>("Reoler");
        reolerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(String.valueOf(cellData.getValue().getReoler())));
        afdelingTableView.getColumns().add(reolerC);
        for (TableColumn<Afdeling, ?> column : afdelingTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button60, button61, button62, button63, label108, afdelingTableView);
    }

    private void redigerLager() {
        if (afdelingTableView.getSelectionModel().getSelectedItem() != null) {
//            ((RedigerLagerScene) getGUI().getScene(SceneType.REDIGERAFDELING)).setSelectedLager(afdelingTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERAFDELING);
        } else {
            getGUI().alert("Ingen lager valgt", "Du har ikke valgt et lager", "Vælg et lager fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletLager() {
        if (afdelingTableView.getSelectionModel().getSelectedItem() != null) {
            Afdeling afdeling = afdelingTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet afdeling", "Er du sikker på at du vil slette afdelingen?", "Du er ved at slette afdelingen " + afdeling + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteAfdeling(afdeling);
                update();
            }
        } else {
            getGUI().alert("Ingen afdeling valgt", "Du har ikke valgt en afdeling", "Vælg en afdeling fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
//        ((RedigerLagerScene) getGUI().getScene(SceneType.REDIGERAFDELING)).setSelectedLager(null);
        afdelingTableView.getItems().clear();
        afdelingTableView.getItems().addAll(getGUI().getController().getAfdelinger());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Afdeling";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.HJEM;
    }
}
