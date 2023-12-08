package gui.scene.scenes.destillering;

import application.model.Destillering;
import application.model.opbevaring.Plastictank;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DestilleringTankScene extends XScene {
    public DestilleringTankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 6: Tilføj/fjern destillering til/fra tank

        Label label28 = new Label("Tilføj/fjern destillering til/fra tank");
        label28.setTranslateX(0);
        label28.setTranslateY(150);
        label28.setFont(new Font("Arial", 36));
        label28.setTextFill(Color.BLACK);

        Label label29 = new Label("Omhæld fra tank til tank her");
        label29.setTranslateX(0);
        label29.setTranslateY(150);
        label29.setFont(XStyle.M_FONT);
        label29.setTextFill(Color.BLACK);

        Label label30 = new Label("Fra tank:");
        label30.setTranslateX(0);
        label30.setTranslateY(150);
        label30.setFont(XStyle.M_FONT);
        label30.setTextFill(Color.BLACK);

        Label label31 = new Label("Til tank:");
        label31.setTranslateX(0);
        label31.setTranslateY(150);
        label31.setFont(XStyle.M_FONT);
        label31.setTextFill(Color.BLACK);

        Label label32 = new Label("Antal liter der skal flyttes");
        label32.setTranslateX(0);
        label32.setTranslateY(150);
        label32.setFont(new Font("Calibri", 12));
        label32.setTextFill(Color.BLACK);

        TextField textField10 = new TextField();
        textField10.setMaxWidth(100);
        Tooltip tooltip33 = new Tooltip();
        tooltip33.setText("Indtast antal liter her");
        textField10.setTooltip(tooltip33);
        textField10.setCursor(Cursor.TEXT);

        ListView<Destillering> listView4 = new ListView<>();
        listView4.setTranslateX(20);
        listView4.setTranslateY(20);
        listView4.setPrefSize(200, 200);
        listView4.getItems().addAll(getGUI().getController().getDestilleringer());

        ListView<Plastictank> listView5 = new ListView<>();
        listView5.setTranslateX(20);
        listView5.setTranslateY(20);
        listView5.setPrefSize(200, 200);
        listView5.getItems().addAll(getGUI().getController().getPlastictanke());

        ImageView imageView5 = XIcon.ALKOHOL.getImageView();
        imageView5.setFitHeight(100);
        imageView5.setFitWidth(100);
        imageView5.setTranslateX(10);
        imageView5.setTranslateY(-10);
        getLayout().getChildren().add(imageView5);

        Button button24 = new Button("Flyt destillering");
        button24.setTranslateX(-150);
        button24.setTranslateY(-280);
        button24.setPrefSize(250, 45);
        button24.setOnAction(e -> flytDestillering(listView4.getSelectionModel().getSelectedItem(), listView5.getSelectionModel().getSelectedItems(), textField10.getText()));
        button24.setFont(XStyle.M_FONT);
        button24.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button24.setCursor(Cursor.HAND);
        Tooltip tooltip34 = new Tooltip("Tryk her for at flytte destilleringsvæsken");
        button24.setTooltip(tooltip34);

        Button button25 = new Button("Annuller");
        button25.setTranslateX(-150);
        button25.setTranslateY(-280);
        button25.setPrefSize(250, 45);
        button25.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERING));
        button25.setFont(XStyle.M_FONT);
        button25.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button25.setCursor(Cursor.HAND);
        Tooltip tooltip35 = new Tooltip("Tryk her for at annullere");
        button25.setTooltip(tooltip35);

        Button button26 = new Button("Gå til forside");
        button26.setTranslateX(-150);
        button26.setTranslateY(-280);
        button26.setPrefSize(250, 45);
        button26.setOnAction(e -> getGUI().gåTilForside());
        button26.setFont(XStyle.M_FONT);
        button26.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button26.setCursor(Cursor.HAND);
        Tooltip tooltip36 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button26.setTooltip(tooltip36);

        getLayout().getChildren().addAll(label28, label29, label30, label31, label32, textField10, listView4, listView5, button24, button25, button26);
    }

    private void flytDestillering(Destillering selectedItem, ObservableList<Plastictank> selectedItems, String antalLiter) {
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
