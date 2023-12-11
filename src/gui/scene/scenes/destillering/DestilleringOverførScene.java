package gui.scene.scenes.destillering;

import application.model.Destillering;
import application.model.Opbevaring;
import application.model.opbevaring.Fad;
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

public class DestilleringOverførScene extends XScene {
    private TableView<Destillering> fraDestilleringableView;
    private TableView<Fad> tilFadTableView;
    private TableView<Plastictank> tilPlastictankTableView;
    private TextField textFieldAntalLiter;
    private Label label111, label108, label109;
    private ToggleGroup group;

    public DestilleringOverførScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        double translateY = getGUI().getScreenWidth() * 0.275;

        label109 = new Label("Overfør destillering til fad");
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

        label108 = new Label("Her kan du overføre destillering fra en destillering til et andet fad.");
        label108.setTranslateX(0);
        label108.setTranslateY(-50);
        label108.setFont(XStyle.M_FONT);

        fraDestilleringableView = new TableView<>();
        fraDestilleringableView.setPlaceholder(new Label("Der er ingen destilleringer"));
        fraDestilleringableView.setEditable(false);
        fraDestilleringableView.setPrefSize(200, 200);
        fraDestilleringableView.setMaxWidth(500);
        fraDestilleringableView.setTranslateX(-400);
        fraDestilleringableView.setTranslateY(0);
        fraDestilleringableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(fraDestilleringableView, new Insets(0, 0, 0, 20));
        TableColumn<Destillering, Integer> nummerC = new TableColumn<>("Nummer");
        nummerC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        fraDestilleringableView.getColumns().add(nummerC);
        TableColumn<Destillering, String> navnC = new TableColumn<>("Navn");
        navnC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNavn()));
        fraDestilleringableView.getColumns().add(navnC);
        TableColumn<Destillering, Double> literC = new TableColumn<>("Liter");
        literC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLiter()));
        fraDestilleringableView.getColumns().add(literC);
        TableColumn<Destillering, Double> alkoholprocentC = new TableColumn<>("Alkoholprocent");
        alkoholprocentC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAlkoholprocent()));
        fraDestilleringableView.getColumns().add(alkoholprocentC);
        for (TableColumn<Destillering, ?> column : fraDestilleringableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        tilFadTableView = new TableView<>();
        tilFadTableView.setPlaceholder(new Label("Der er ingen fade"));
        tilFadTableView.setEditable(false);
        tilFadTableView.setPrefSize(200, 200);
        tilFadTableView.setMaxWidth(500);
        tilFadTableView.setTranslateX(400);
        tilFadTableView.setTranslateY(-200);
        tilFadTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(tilFadTableView, new Insets(0, 20, 0, 0));
        TableColumn<Fad, Integer> nummerC1 = new TableColumn<>("Nummer");
        nummerC1.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        tilFadTableView.getColumns().add(nummerC1);
        TableColumn<Fad, String> typeC1 = new TableColumn<>("Navn");
        typeC1.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getType()));
        tilFadTableView.getColumns().add(typeC1);
        TableColumn<Fad, Double> volumenC1 = new TableColumn<>("Volumen (L)");
        volumenC1.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        tilFadTableView.getColumns().add(volumenC1);
        TableColumn<Fad, String> placeringC1 = new TableColumn<>("Placering");
        placeringC1.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        tilFadTableView.getColumns().add(placeringC1);
        for (TableColumn<Fad, ?> column : tilFadTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        tilPlastictankTableView = new TableView<>();
        tilPlastictankTableView.setPlaceholder(new Label("Der er ingen plastictanke"));
        tilPlastictankTableView.setEditable(false);
        tilPlastictankTableView.setPrefSize(200, 200);
        tilPlastictankTableView.setMaxWidth(500);
        tilPlastictankTableView.setTranslateX(400);
        tilPlastictankTableView.setTranslateY(-200);
        tilPlastictankTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(tilPlastictankTableView, new Insets(0, 20, 0, 0));
        TableColumn<Plastictank, Integer> nummerC2 = new TableColumn<>("Nummer");
        nummerC2.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNummer()));
        tilPlastictankTableView.getColumns().add(nummerC2);
        TableColumn<Plastictank, String> navnC2 = new TableColumn<>("Navn");
        navnC2.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNavn()));
        tilPlastictankTableView.getColumns().add(navnC2);
        TableColumn<Plastictank, Double> volumenC2 = new TableColumn<>("Volumen (L)");
        volumenC2.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        tilPlastictankTableView.getColumns().add(volumenC2);
        TableColumn<Plastictank, String> placeringC2 = new TableColumn<>("Placering");
        placeringC2.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHylde() != null ? cellData.getValue().getHylde().getPlacering() : null));
        tilPlastictankTableView.getColumns().add(placeringC2);
        for (TableColumn<Plastictank, ?> column : tilPlastictankTableView.getColumns()) {
            column.setStyle("-fx-alignment: CENTER;");
        }

        Label label110 = new Label("Fra destillering");
        label110.setPrefSize(100, 20);
        label110.setMaxWidth(150);
        label110.setTranslateX(-575);
        label110.setTranslateY(10);
        label110.setFont(XStyle.M_FONT);

        label111 = new Label("Til fad");
        label111.setPrefSize(100, 20);
        label111.setMaxWidth(150);
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

        group = new ToggleGroup();
        ToggleButton toggleButton = new ToggleButton("Fad");
        toggleButton.setMaxWidth(75);
        toggleButton.setToggleGroup(group);
        toggleButton.setSelected(true);
        ToggleButton toggleButton1 = new ToggleButton("Plastictank");
        toggleButton1.setMaxWidth(75);
        toggleButton1.setToggleGroup(group);

        VBox vBox1 = new VBox();
        vBox1.setTranslateX(-getGUI().getScreenHeight() * 0.5 + 360);
        vBox1.setTranslateY(-350);
        vBox1.setPrefSize(250, 45);
        vBox1.setMaxSize(250, 45);
        vBox1.setMinSize(250, 45);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(5);
        vBox1.getChildren().addAll(label112, textFieldAntalLiter, toggleButton, toggleButton1);

        getLayout().getChildren().addAll(label109, button64, button65, button66, label108, label110, label111, fraDestilleringableView, tilFadTableView, vBox1);
    }

    @Override
    public void update() {
        fraDestilleringableView.getItems().clear();
        for (Destillering destillering : getGUI().getController().getDestilleringer()) {
            if (destillering.getLiter() > 0) {
                fraDestilleringableView.getItems().add(destillering);
            }
        }
        tilFadTableView.getItems().clear();
        tilPlastictankTableView.getItems().clear();
        for (Fad fad : getGUI().getController().getFade()) {
            if (fad.getPåfyldning() == null && fad.isIntakt() && fad.getGangeBrugt() < 3) {
                tilFadTableView.getItems().add(fad);
            }
        }
        for (Plastictank plastictank : getGUI().getController().getPlastictanke()) {
            if (plastictank.getPåfyldning() == null && plastictank.isIntakt()) {
                tilPlastictankTableView.getItems().add(plastictank);
            }
        }
        textFieldAntalLiter.setText("");
        group.selectedToggleProperty().addListener(
                event -> {
                    if (group.getToggles().get(0).isSelected()) {
                        getLayout().getChildren().set(8, tilFadTableView);
                        label109.setText("Overfør destillering til fad");
                        label108.setText("Her kan du overføre destillering fra en destillering til et andet fad.");
                        label111.setText("Til fad");
                    } else if (group.getToggles().get(1).isSelected()) {
                        getLayout().getChildren().set(8, tilPlastictankTableView);
                        label109.setText("Overfør destillering til plastictank");
                        label108.setText("Her kan du overføre destillering fra en destillering til en plastictank.");
                        label111.setText("Til plastictank");
                    }
                }
        );
    }

    private void flytDestillering() {
        Destillering fraDestillering = fraDestilleringableView.getSelectionModel().getSelectedItem();
        Opbevaring tilOpbevaring = group.getToggles().get(0).isSelected() ? tilFadTableView.getSelectionModel().getSelectedItem() : tilPlastictankTableView.getSelectionModel().getSelectedItem();
        if (fraDestillering != null && tilOpbevaring != null) {
            double antalLiter;
            try {
                antalLiter = Double.parseDouble(textFieldAntalLiter.getText());
            } catch (NumberFormatException e) {
                getGUI().alert("Ugyldigt antal liter", "Du har ikke indtastet et gyldigt antal liter", "Indtast et gyldigt antal liter og prøv igen", Alert.AlertType.WARNING).showAndWait();
                return;
            }
            try {
                getGUI().getController().createPåfyldning(tilOpbevaring, fraDestillering, antalLiter);
                update();
            } catch (IllegalArgumentException e) {
                getGUI().alert("Fejl opskete", "Destillering kunne ikke overføres", e.getMessage(), Alert.AlertType.ERROR).showAndWait();
            }
        }
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
