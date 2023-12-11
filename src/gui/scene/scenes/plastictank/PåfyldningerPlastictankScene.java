package gui.scene.scenes.plastictank;

import application.model.Destillering;
import application.model.Opbevaring;
import application.model.Påfyldning;
import application.model.opbevaring.Fad;
import application.model.opbevaring.Plastictank;
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

import java.time.LocalDate;
import java.util.List;

public class PåfyldningerPlastictankScene extends XScene {

    private Plastictank selectedPlastictank;
    private TableView<Påfyldning> fadTableView;

    public PåfyldningerPlastictankScene(GUI gui) {
        super(gui);
    }

    public void setSelectedPlastictank(Plastictank selectedPlastictank) {
        this.selectedPlastictank = selectedPlastictank;
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Se påfyldninger af plastictank");
        label107.setTranslateX(0);
        label107.setTranslateY(-10);
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

        Button button63 = new Button("Gå tilbage til plastictank oversigt");
        button63.setTranslateX(0);
        button63.setTranslateY(500);
        button63.setMaxWidth(300);
        button63.setPrefSize(buttonWidth, buttonHeight);
        button63.setOnAction(e -> getGUI().switchScene(SceneType.PLASTICTANK));
        button63.setFont(new Font("Arial", 16));
        button63.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button63.setCursor(Cursor.HAND);
        Tooltip tooltip130 = new Tooltip("Tryk her for at gå tilbage til plastictank oversigten");
        button63.setTooltip(tooltip130);

        Label label108 = new Label("Her ses en oversigt over påfyldninger");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        fadTableView = new TableView<>();
        fadTableView.setPlaceholder(new Label("Der er ingen påfyldninger"));
        fadTableView.setEditable(false);
        fadTableView.setPrefSize(200, 450);
        fadTableView.setTranslateX(0);
        fadTableView.setTranslateY(-30);
        fadTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(fadTableView, new Insets(0, 20, 0, 20));
        TableColumn<Påfyldning, Destillering> destilleringC = new TableColumn<>("Destillering");
        destilleringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDestillering()));
        fadTableView.getColumns().add(destilleringC);
        TableColumn<Påfyldning, Double> literC = new TableColumn<>("Liter påfyldt");
        literC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLiter()));
        fadTableView.getColumns().add(literC);
        TableColumn<Påfyldning, List<Opbevaring>> opbevaringerC = new TableColumn<>("Påfyldte opbevaringer");
        opbevaringerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getOpbevaringer()));
        fadTableView.getColumns().add(opbevaringerC);
        TableColumn<Påfyldning, LocalDate> påfyldningsDatoC = new TableColumn<>("Påfyldningsdato");
        påfyldningsDatoC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldningsDato()));
        fadTableView.getColumns().add(påfyldningsDatoC);
        TableColumn<Påfyldning, LocalDate> tomtDatoC = new TableColumn<>("Tømmingsdato");
        tomtDatoC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTomtDato() == null ? null : cellData.getValue().getTomtDato()));
        fadTableView.getColumns().add(tomtDatoC);
        for (TableColumn<Påfyldning, ?> column : fadTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }


        getLayout().getChildren().addAll(label107, button63, label108, fadTableView);
    }

    @Override
    public void update() {
        fadTableView.getItems().clear();
        if (selectedPlastictank.getPåfyldning() != null) {
            fadTableView.getItems().add(selectedPlastictank.getPåfyldning());
        }
        fadTableView.getItems().addAll(selectedPlastictank.getTidligerePåfyldninger());
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
