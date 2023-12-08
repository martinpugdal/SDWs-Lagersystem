package gui.scene.scenes;

import application.model.Lager;
import application.model.Råvare;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.råvare.RedigerRåvareScene;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class RåvareScene extends XScene {

    private TableView<Råvare> råvareTableView;

    public RåvareScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 8: Råvarer

        Label label39 = new Label("Råvarer");
        label39.setTranslateX(0);
        label39.setTranslateY(150);
        label39.setFont(XStyle.XXL_FONT);
        label39.setTextFill(Color.BLACK);

        Label label40 = new Label("Her ses den nuværende beholdning");
        label40.setTranslateX(0);
        label40.setTranslateY(150);
        label40.setFont(XStyle.M_FONT);
        label40.setTextFill(Color.BLACK);

        råvareTableView = new TableView<>();
        råvareTableView.setEditable(false);
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
        råvareTableView.setPlaceholder(new Label("Der er ingen råvarer"));
        råvareTableView.setTranslateX(20);
        råvareTableView.setTranslateY(20);
        råvareTableView.setPrefSize(200, 100);

        Button button30 = new Button("Opret råvare");
        button30.setTranslateX(-150);
        button30.setTranslateY(-280);
        button30.setPrefSize(250, 45);
        button30.setOnAction(e -> getGUI().switchScene(SceneType.OPRETRÅVARE));
        button30.setFont(XStyle.M_FONT);
        button30.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button30.setCursor(Cursor.HAND);
        Tooltip tooltip41 = new Tooltip("Tryk her for at oprette en råvare");
        button30.setTooltip(tooltip41);

        Button button31 = new Button("Rediger råvare");
        button31.setTranslateX(-150);
        button31.setTranslateY(-280);
        button31.setPrefSize(250, 45);
        button31.setOnAction(e -> redigerRåvare());
        button31.setFont(XStyle.M_FONT);
        button31.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button31.setCursor(Cursor.HAND);
        Tooltip tooltip42 = new Tooltip("Tryk her for at opdatere en råvare");
        button31.setTooltip(tooltip42);

        Button button32 = new Button("Slet råvare");
        button32.setTranslateX(-150);
        button32.setTranslateY(-280);
        button32.setPrefSize(250, 45);
        button32.setOnAction(e -> sletRåvare());
        button32.setFont(XStyle.M_FONT);
        button32.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button32.setCursor(Cursor.HAND);
        Tooltip tooltip43 = new Tooltip("Tryk her for at slette en råvare");
        button32.setTooltip(tooltip43);

        Button button33 = new Button("Gå tilbage til forside");
        button33.setTranslateX(-150);
        button33.setTranslateY(-280);
        button33.setPrefSize(250, 45);
        button33.setOnAction(e -> getGUI().gåTilForside());
        button33.setFont(XStyle.M_FONT);
        button33.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button33.setCursor(Cursor.HAND);
        Tooltip tooltip44 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button33.setTooltip(tooltip44);

        getLayout().getChildren().addAll(label39, label40, råvareTableView, button30, button31, button32, button33);
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
