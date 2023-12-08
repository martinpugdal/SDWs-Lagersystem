package gui.scene.scenes;

import application.model.Destillering;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class DestilleringScene extends XScene {

    private TableView<Destillering> destilleringTableView;

    public DestilleringScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 2: Destillering
        Label label9 = new Label("Destillering");
        label9.setTranslateX(0);
        label9.setTranslateY(150);
        label9.setFont(XStyle.XL_FONT);
        label9.setTextFill(Color.BLACK);

        Label label10 = new Label("Her kan der oprettes væsker som så kan fordeles på fade, tanke samt flasker");
        label10.setTranslateX(0);
        label10.setTranslateY(150);
        label10.setFont(XStyle.M_FONT);
        label10.setTextFill(Color.BLACK);

        destilleringTableView = new TableView<>();
        destilleringTableView.setEditable(false);
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
        destilleringTableView.setPlaceholder(new Label("Der er ingen destilleringer"));
        destilleringTableView.getItems().addAll(getGUI().getController().getDestilleringer());
        destilleringTableView.setTranslateX(20);
        destilleringTableView.setTranslateY(20);
        destilleringTableView.setPrefSize(200, 200);
        destilleringTableView.getItems().addAll(getGUI().getController().getDestilleringer());

        Button button8 = new Button("Opret destillering");
        button8.setTranslateX(-150);
        button8.setTranslateY(-280);
        button8.setPrefSize(250, 45);
        button8.setOnAction(e -> getGUI().gåTilForside());
        button8.setFont(XStyle.M_FONT);
        button8.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button8.setCursor(Cursor.HAND);
        Tooltip tooltip8 = new Tooltip("Tryk her for at oprette destilleringsvæske");
        button8.setTooltip(tooltip8);

        Button button9 = new Button("Rediger destillering");
        button9.setTranslateX(-150);
        button9.setTranslateY(-280);
        button9.setPrefSize(250, 45);
        button9.setOnAction(e -> getGUI().gåTilForside());
        button9.setFont(XStyle.M_FONT);
        button9.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button9.setCursor(Cursor.HAND);
        Tooltip tooltip9 = new Tooltip("Tryk her for at redigere destilleringsvæske");
        button9.setTooltip(tooltip9);

        Button button10 = new Button("Slet destillering");
        button10.setTranslateX(-150);
        button10.setTranslateY(-280);
        button10.setPrefSize(250, 45);
        button10.setFont(XStyle.M_FONT);
        button10.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button10.setCursor(Cursor.HAND);
        Tooltip tooltip10 = new Tooltip("Tryk her for at slette destilleringsvæsken fra systemet");
        button10.setTooltip(tooltip10);

        Button button11 = new Button("Overfør destillering (fad)");
        button11.setTranslateX(-150);
        button11.setTranslateY(-280);
        button11.setPrefSize(250, 45);
        button11.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERINGFAD));
        button11.setFont(XStyle.M_FONT);
        button11.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button11.setCursor(Cursor.HAND);
        Tooltip tooltip11 = new Tooltip("Tryk her for at tilføje/fjerne destilleringsvæske til/fra et fad");
        button11.setTooltip(tooltip11);

        Button button12 = new Button("Overfør destillering (tank)");
        button12.setTranslateX(-150);
        button12.setTranslateY(-280);
        button12.setPrefSize(250, 45);
        button12.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERINGTANK));
        button12.setFont(XStyle.M_FONT);
        button12.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button12.setCursor(Cursor.HAND);
        Tooltip tooltip12 = new Tooltip("Tryk her for at tilføje/fjerne destilleringsvæske til/fra en plastictank");
        button12.setTooltip(tooltip12);

        Button button14 = new Button("Gå tilbage til forside");
        button14.setTranslateX(-150);
        button14.setTranslateY(-280);
        button14.setPrefSize(250, 45);
        button14.setOnAction(e -> getGUI().gåTilForside());
        button14.setFont(XStyle.M_FONT);
        button14.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button14.setCursor(Cursor.HAND);
        Tooltip tooltip14 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button14.setTooltip(tooltip14);

        getLayout().getChildren().addAll(label9, label10, destilleringTableView, button8, button9, button10, button11, button12, button14);
    }

    @Override
    public void update() {
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
