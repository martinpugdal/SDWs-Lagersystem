package gui.scene.scenes.fad;

import application.model.Destillering;
import application.model.Opbevaring;
import application.model.Påfyldning;
import application.model.opbevaring.Fad;
import gui.GUI;
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

public class PåfyldningerFadScene extends XScene {

    private Fad selectedFad;
    private TableView<Påfyldning> fadTableView;

    public PåfyldningerFadScene(GUI gui) {
        super(gui);
    }

    public void setSelectedFad(Fad selectedFad) {
        this.selectedFad = selectedFad;
    }

    @Override
    public void initLayout() {
        Label label107 = new Label("Se påfyldninger af fadet");
        label107.setTranslateX(0);
        label107.setTranslateY(-10);
        label107.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.FAD.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label107.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label107.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label107.setGraphic(lagerIcon);
        label107.setContentDisplay(ContentDisplay.LEFT);

        double buttonWidth = 250;
        double buttonHeight = 45;

        Button button63 = new Button("Gå tilbage til forside");
        button63.setTranslateX(0);
        button63.setTranslateY(550);
        button63.setPrefSize(buttonWidth, buttonHeight);
        button63.setOnAction(e -> getGUI().gåTilForside());
        button63.setFont(new Font("Arial", 16));
        button63.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button63.setCursor(Cursor.HAND);
        Tooltip tooltip130 = new Tooltip("Tryk her for at gå tilbage til forsiden");
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
        if (selectedFad.getPåfyldning() != null) {
            fadTableView.getItems().add(selectedFad.getPåfyldning());
        }
        fadTableView.getItems().addAll(selectedFad.getTidligerePåfyldninger());
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Fad";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.FAD;
    }
}
