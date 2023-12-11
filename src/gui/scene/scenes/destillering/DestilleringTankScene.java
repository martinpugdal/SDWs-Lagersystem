package gui.scene.scenes.destillering;

import application.model.Påfyldning;
import application.model.opbevaring.Plastictank;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DestilleringTankScene extends XScene {

    private TableView<Plastictank> fraTankTableView, tilTankTableView;
    private TextField textFieldAntalLiter;

    public DestilleringTankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Tilføj/fjern destillering til/fra tank");
        label109.setTranslateX(0);
        label109.setTranslateY(30);
        label109.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.ALKOHOL.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateY(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.TOP);

        Button button64 = new Button("Flyt destillering");
        button64.setTranslateX(-325);
        button64.setTranslateY(translateY + 180);
        button64.setPrefSize(250, 45);
        button64.setOnAction(e -> flytDestillering());
        button64.setFont(XStyle.M_FONT);
        button64.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button64.setCursor(Cursor.HAND);
        Tooltip tooltip137 = new Tooltip("Tryk her for at oprette");
        button64.setTooltip(tooltip137);

        Button button65 = new Button("Annuller");
        button65.setTranslateX(0);
        button65.setTranslateY(translateY + 180 - 39);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERING));
        button65.setFont(XStyle.M_FONT);
        button65.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button65.setCursor(Cursor.HAND);
        Tooltip tooltip138 = new Tooltip("Tryk her for at annullere");
        button65.setTooltip(tooltip138);

        Button button66 = new Button("Gå tilbage til forside");
        button66.setTranslateX(325);
        button66.setTranslateY(translateY + 180 - 77);
        button66.setPrefSize(250, 45);
        button66.setOnAction(e -> getGUI().gåTilForside());
        button66.setFont(XStyle.M_FONT);
        button66.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button66.setCursor(Cursor.HAND);
        Tooltip tooltip139 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button66.setTooltip(tooltip139);

        Label label108 = new Label("Her kan du flytte destillering fra en tank til en anden tank.");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        fraTankTableView = new TableView<>();
        fraTankTableView.setPlaceholder(new Label("Der er ingen plastic tanke"));
        fraTankTableView.setEditable(false);
        fraTankTableView.setPrefSize(200, 200);
        fraTankTableView.setMaxWidth(500);
        fraTankTableView.setTranslateX(-400);
        fraTankTableView.setTranslateY(0);
        fraTankTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(fraTankTableView, new Insets(0, 0, 0, 20));
        TableColumn<Plastictank, Integer> nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        fraTankTableView.getColumns().add(nummerC);
        TableColumn<Plastictank, String> typeC = new TableColumn<>("Type");
        typeC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNavn()));
        fraTankTableView.getColumns().add(typeC);
        TableColumn<Plastictank, Double> volumenC = new TableColumn<>("Volumen (L)");
        volumenC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        fraTankTableView.getColumns().add(volumenC);
        TableColumn<Plastictank, Double> literC = new TableColumn<>("Påfyldt liter");
        literC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning().getLiter()));
        fraTankTableView.getColumns().add(literC);
        TableColumn<Plastictank, Påfyldning> påfyldningC = new TableColumn<>("Påfyldning");
        påfyldningC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning()));
        fraTankTableView.getColumns().add(påfyldningC);
        TableColumn<Plastictank, String> placeringC = new TableColumn<>("Placering");
        placeringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        fraTankTableView.getColumns().add(placeringC);
        for (TableColumn<Plastictank, ?> column : fraTankTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        tilTankTableView = new TableView<>();
        tilTankTableView.setPlaceholder(new Label("Der er ingen fade"));
        tilTankTableView.setEditable(false);
        tilTankTableView.setPrefSize(200, 200);
        tilTankTableView.setMaxWidth(500);
        tilTankTableView.setTranslateX(400);
        tilTankTableView.setTranslateY(-200);
        tilTankTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(tilTankTableView, new Insets(0, 20, 0, 0));
        nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        tilTankTableView.getColumns().add(nummerC);
        typeC = new TableColumn<>("Type");
        typeC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNavn()));
        tilTankTableView.getColumns().add(typeC);
        volumenC = new TableColumn<>("Volumen (L)");
        volumenC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        tilTankTableView.getColumns().add(volumenC);
        placeringC = new TableColumn<>("Placering");
        placeringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        tilTankTableView.getColumns().add(placeringC);
        for (TableColumn<Plastictank, ?> column : tilTankTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        Label label110 = new Label("Fra plastic tank");
        label110.setPrefSize(-1, 20);
        label110.setTranslateX(-575);
        label110.setTranslateY(10);
        label110.setFont(XStyle.M_FONT);

        Label label111 = new Label("Til plastic tank");
        label111.setPrefSize(-1, 20);
        label111.setTranslateX(200);
        label111.setTranslateY(-10);
        label111.setFont(XStyle.M_FONT);


        Label label112 = new Label("Antal liter");
        label112.setTranslateX(0);
        label112.setFont(XStyle.M_FONT);

        textFieldAntalLiter = new TextField();
        textFieldAntalLiter.setPromptText("Antal liter");
        textFieldAntalLiter.setMaxWidth(150);
        textFieldAntalLiter.setFont(XStyle.M_FONT);
        textFieldAntalLiter.setCursor(Cursor.HAND);
        Tooltip tooltip140 = new Tooltip("Indtast antal liter");
        textFieldAntalLiter.setTooltip(tooltip140);

        VBox vBox1 = new VBox();
        vBox1.setTranslateX(-getGUI().getScreenHeight() * 0.5 + 360);
        vBox1.setTranslateY(-350);
        vBox1.setPrefSize(250, 45);
        vBox1.setMaxSize(250, 45);
        vBox1.setMinSize(250, 45);
        vBox1.setSpacing(5);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(label112, textFieldAntalLiter);

        getLayout().getChildren().addAll(label109, button64, button65, button66, label108, label110, label111, fraTankTableView, tilTankTableView, vBox1);
    }

    @Override
    public void update() {
        fraTankTableView.getItems().clear();
        for (Plastictank fad : getGUI().getController().getPlastictanke()) {
            if (fad.getPåfyldning() != null) {
                fraTankTableView.getItems().add(fad);
            }
        }
        tilTankTableView.getItems().clear();
        for (Plastictank fad : getGUI().getController().getPlastictanke()) {
            if (fad.getPåfyldning() == null && fad.isIntakt() && fad.isTom()) {
                tilTankTableView.getItems().add(fad);
            }
        }
        textFieldAntalLiter.setText("");
    }

    private void flytDestillering() {
        //TODO:
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public XIcon getIcon() {
        return XIcon.ALKOHOL;
    }
}
