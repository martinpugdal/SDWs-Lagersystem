package gui.scene.scenes.destillering;

import application.model.opbevaring.Fad;
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

public class DestilleringFadScene extends XScene {

    private TableView<Fad> fraFadTableView, tilFadTableView;
    private TextField textFieldAntalLiter;

    public DestilleringFadScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        Label label109 = new Label("Tilføj/fjern destillering til/fra fad");
        label109.setTranslateX(0);
        label109.setTranslateY(-100);
        label109.setFont(XStyle.XXL_FONT);
        ImageView lagerIcon = XIcon.ALKOHOL.getImageView();
        lagerIcon.setPreserveRatio(true);
        lagerIcon.setFitHeight(label109.getFont().getSize() * 2);
        lagerIcon.setFitWidth(label109.getFont().getSize() * 2);
        lagerIcon.setTranslateX(-5); // skubber ikonet mere til venstre for teksten
        label109.setGraphic(lagerIcon);
        label109.setContentDisplay(ContentDisplay.LEFT);

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
        button65.setTranslateY(translateY + 180 - 45);
        button65.setPrefSize(250, 45);
        button65.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERING));
        button65.setFont(XStyle.M_FONT);
        button65.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button65.setCursor(Cursor.HAND);
        Tooltip tooltip138 = new Tooltip("Tryk her for at annullere");
        button65.setTooltip(tooltip138);

        Button button66 = new Button("Gå tilbage til forside");
        button66.setTranslateX(325);
        button66.setTranslateY(translateY + 180 - 90);
        button66.setPrefSize(250, 45);
        button66.setOnAction(e -> getGUI().gåTilForside());
        button66.setFont(XStyle.M_FONT);
        button66.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button66.setCursor(Cursor.HAND);
        Tooltip tooltip139 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button66.setTooltip(tooltip139);

        Label label108 = new Label("Her kan du flytte destillering fra et fad til et andet fad.");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);
        label108.setTextFill(Color.BLACK);

        fraFadTableView = new TableView<>();
        fraFadTableView.setPlaceholder(new Label("Der er ingen fade"));
        fraFadTableView.setEditable(false);
        fraFadTableView.setPrefSize(200, 200);
        fraFadTableView.setMaxWidth(500);
        fraFadTableView.setTranslateX(-400);
        fraFadTableView.setTranslateY(0);
        fraFadTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(fraFadTableView, new Insets(0, 0, 0, 20));
        TableColumn<Fad, Integer> nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        fraFadTableView.getColumns().add(nummerC);
        TableColumn<Fad, String> typeC = new TableColumn<>("Type");
        typeC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getType()));
        fraFadTableView.getColumns().add(typeC);
        TableColumn<Fad, Double> volumenC = new TableColumn<>("Volumen (L)");
        volumenC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        fraFadTableView.getColumns().add(volumenC);
        TableColumn<Fad, Double> literC = new TableColumn<>("Påfyldt liter");
        literC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPåfyldning().getLiter()));
        fraFadTableView.getColumns().add(literC);
        TableColumn<Fad, String> placeringC = new TableColumn<>("Placering");
        placeringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        fraFadTableView.getColumns().add(placeringC);

        tilFadTableView = new TableView<>();
        tilFadTableView.setPlaceholder(new Label("Der er ingen fade"));
        tilFadTableView.setEditable(false);
        tilFadTableView.setPrefSize(200, 200);
        tilFadTableView.setMaxWidth(500);
        tilFadTableView.setTranslateX(400);
        tilFadTableView.setTranslateY(-200);
        tilFadTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(tilFadTableView, new Insets(0, 20, 0, 0));
        nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        tilFadTableView.getColumns().add(nummerC);
        typeC = new TableColumn<>("Type");
        typeC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getType()));
        tilFadTableView.getColumns().add(typeC);
        volumenC = new TableColumn<>("Volumen (L)");
        volumenC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        tilFadTableView.getColumns().add(volumenC);
        placeringC = new TableColumn<>("Placering");
        placeringC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        tilFadTableView.getColumns().add(placeringC);

        Label label110 = new Label("Fra fad");
        label110.setTranslateX(-350);
        label110.setTranslateY(0);
        label110.setFont(XStyle.M_FONT);

        Label label111 = new Label("Til fad");
        label111.setPrefSize(100, 1);
        label111.setTranslateX(350);
        label111.setTranslateY(-400);
        label111.setFont(XStyle.M_FONT);


        Label label112 = new Label("Antal liter");
        label112.setFont(XStyle.M_FONT);

        textFieldAntalLiter = new TextField();
        textFieldAntalLiter.setPromptText("Antal liter");
        textFieldAntalLiter.setMaxWidth(150);
        textFieldAntalLiter.setFont(XStyle.M_FONT);
        textFieldAntalLiter.setCursor(Cursor.HAND);
        Tooltip tooltip140 = new Tooltip("Indtast antal liter");
        textFieldAntalLiter.setTooltip(tooltip140);

        VBox vBox1 = new VBox();
        vBox1.setTranslateX(getGUI().getScreenHeight() * 0.5 + 250);
        vBox1.setTranslateY(-100);
        vBox1.setPrefSize(250, 45);
        vBox1.setSpacing(5);
        vBox1.getChildren().addAll(label112, textFieldAntalLiter);

        getLayout().getChildren().addAll(label109, button64, button65, button66, label108, label110, label111, fraFadTableView, tilFadTableView, vBox1);
    }

    @Override
    public void update() {
        fraFadTableView.getItems().clear();
        for (Fad fad : getGUI().getController().getFade()) {
            if (fad.getPåfyldning() != null) {
                fraFadTableView.getItems().add(fad);
            }
        }
        tilFadTableView.getItems().clear();
        for (Fad fad : getGUI().getController().getFade()) {
            if (fad.getPåfyldning() == null && fad.isIntakt() && !fad.isTom() && fad.getGangeBrugt() < 3) {
                tilFadTableView.getItems().add(fad);
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
