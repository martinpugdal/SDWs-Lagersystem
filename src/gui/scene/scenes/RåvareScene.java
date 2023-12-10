package gui.scene.scenes;

import application.model.Råvare;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.råvare.RedigerRåvareScene;
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

public class RåvareScene extends XScene {

    private TableView<Råvare> råvareTableView;

    public RåvareScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 8: Råvarer
        Label label107 = new Label("Råvarer");
        label107.setTranslateX(-550);
        label107.setTranslateY(10);
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

        Button button30 = new Button("Opret råvare");
        button30.setTranslateX(-550 + (buttonWidth + 20));
        button30.setTranslateY(-buttonHeight);
        button30.setPrefSize(buttonWidth, buttonHeight);
        button30.setOnAction(e -> getGUI().switchScene(SceneType.OPRETRÅVARE));
        button30.setFont(XStyle.M_FONT);
        button30.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button30.setCursor(Cursor.HAND);
        Tooltip tooltip41 = new Tooltip("Tryk her for at oprette en råvare");
        button30.setTooltip(tooltip41);

        Button button31 = new Button("Rediger råvare");
        button31.setTranslateX(-550 + (buttonWidth + 20) * 2);
        button31.setTranslateY(-buttonHeight * 2);
        button31.setPrefSize(buttonWidth, buttonHeight);
        button31.setOnAction(e -> redigerRåvare());
        button31.setFont(new Font("Arial", 16));
        button31.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button31.setCursor(Cursor.HAND);
        Tooltip tooltip42 = new Tooltip("Tryk her for at opdatere en råvare");
        button31.setTooltip(tooltip42);

        Button button32 = new Button("Slet råvare");
        button32.setTranslateX(-550 + (buttonWidth + 20) * 3);
        button32.setTranslateY(-buttonHeight * 3);
        button32.setPrefSize(buttonWidth, buttonHeight);
        button32.setOnAction(e -> sletRåvare());
        button32.setFont(XStyle.M_FONT);
        button32.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button32.setCursor(Cursor.HAND);
        Tooltip tooltip43 = new Tooltip("Tryk her for at slette en råvare");
        button32.setTooltip(tooltip43);

        Button button33 = new Button("Gå tilbage til forside");
        button33.setTranslateX(-550 + (buttonWidth + 20) * 4);
        button33.setTranslateY(-buttonHeight * 4);
        button33.setPrefSize(buttonWidth, buttonHeight);
        button33.setOnAction(e -> getGUI().gåTilForside());
        button33.setFont(XStyle.M_FONT);
        button33.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button33.setCursor(Cursor.HAND);
        Tooltip tooltip44 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button33.setTooltip(tooltip44);

        Label label40 = new Label("Her ses den nuværende beholdning");
        label40.setTranslateX(0);
        label40.setTranslateY(150);
        label40.setFont(XStyle.M_FONT);
        label40.setTextFill(Color.BLACK);

        råvareTableView = new TableView<>();
        råvareTableView.setPlaceholder(new Label("Der er ingen råvarer"));
        råvareTableView.setEditable(false);
        råvareTableView.setPrefSize(200, 450);
        råvareTableView.setTranslateX(0);
        råvareTableView.setTranslateY(-30);
        råvareTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(råvareTableView, new Insets(0, 20, 0, 20));
        TableColumn<Råvare, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        TableColumn<Råvare, Double> antalCol = new TableColumn<>("Antal");
        antalCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAntal()));
        TableColumn<Råvare, Double> literCol = new TableColumn<>("Liter");
        literCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLiter()));
        TableColumn<Råvare, Double> kilogramCol = new TableColumn<>("Kilogram");
        kilogramCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getKilogram()));
        TableColumn<Råvare, String> flaskerCol = new TableColumn<>("Flasker (nr.)");
        flaskerCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBrugesTilString()));
        råvareTableView.getColumns().add(kilogramCol);
        råvareTableView.getColumns().add(typeCol);
        råvareTableView.getColumns().add(antalCol);
        råvareTableView.getColumns().add(literCol);
        råvareTableView.getColumns().add(flaskerCol);
        for (TableColumn<Råvare, ?> column : råvareTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        getLayout().getChildren().addAll(label107, button30, button31, button32, button33, label40, råvareTableView);
    }

    private void redigerRåvare() {
        if (råvareTableView.getSelectionModel().getSelectedItem() != null) {
            ((RedigerRåvareScene) getGUI().getScene(SceneType.REDIGERRÅVARE)).setSelectedRåvare(råvareTableView.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERRÅVARE);
        } else {
            getGUI().alert("Ingen råvare valgt", "Du har ikke valgt en råvare du vil redigere", "Vælg en råvare fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    private void sletRåvare() {
        if (råvareTableView.getSelectionModel().getSelectedItem() != null) {
            Råvare råvare = råvareTableView.getSelectionModel().getSelectedItem();
            Alert confirmation = getGUI().alert("Slet råvare", "Er du sikker på at du vil slette råvaren?", "Du er ved at slette råvaren " + råvare.getType() + ".\nDenne handling kan ikke fortrydes.", Alert.AlertType.CONFIRMATION);
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                getGUI().getController().deleteRåvare(råvare);
                update();
            }
        } else {
            getGUI().alert("Ingen råvare valgt", "Du har ikke valgt en råvare du vil slette", "Vælg en råvare fra tabellen og prøv igen", Alert.AlertType.WARNING).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerRåvareScene) getGUI().getScene(SceneType.REDIGERRÅVARE)).setSelectedRåvare(null);
        råvareTableView.getItems().clear();
        råvareTableView.getItems().addAll(getGUI().getController().getRåvarer());
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
