package gui.scene.scenes;

import application.model.Lager;
import application.model.flaske.Ginflaske;
import gui.GUI;
import gui.scene.SceneType;
import gui.scene.scenes.ginflaske.RedigerGinflaskeScene;
import gui.scene.scenes.lager.RedigerLagerScene;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GinflaskeScene extends XScene {

    private ListView<Ginflaske> listView14;

    public GinflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 23: Ginflasker

        Label label133 = new Label("Ginflasker");
        label133.setTranslateX(0);
        label133.setTranslateY(150);
        label133.setFont(XStyle.XXL_FONT);
        label133.setTextFill(Color.BLACK);

        Label label134 = new Label("Her ses en oversigt over ginflasker i systemet");
        label134.setTranslateX(0);
        label134.setTranslateY(150);
        label134.setFont(new Font("Calibri",16));
        label134.setTextFill(Color.BLACK);

        listView14 = new ListView<>();
        listView14.setTranslateX(20);
        listView14.setTranslateY(20);
        listView14.setPrefSize(200,200);

        Button button80 = new Button("Opret flaske");
        button80.setTranslateX(-150);
        button80.setTranslateY(-280);
        button80.setPrefSize(250,45);
        button80.setOnAction(e -> getGUI().switchScene(SceneType.OPRETGINFLASKE));
        button80.setFont(XStyle.M_FONT);
        button80.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button80.setCursor(Cursor.HAND);
        Tooltip tooltip165 = new Tooltip("Tryk her for at oprette en ginflaske");
        button80.setTooltip(tooltip165);

        Button button81 = new Button("Rediger flaske");
        button81.setTranslateX(-150);
        button81.setTranslateY(-280);
        button81.setPrefSize(250,45);
        button81.setOnAction(e -> redigerFlaske());
        button81.setFont(XStyle.M_FONT);
        button81.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button81.setCursor(Cursor.HAND);
        Tooltip tooltip166 = new Tooltip("Tryk her for at redigere en ginflaske");
        button81.setTooltip(tooltip166);

        Button button82 = new Button("Slet flaske");
        button82.setTranslateX(-150);
        button82.setTranslateY(-280);
        button82.setPrefSize(250,45);
        button82.setFont(XStyle.M_FONT);
        button82.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button82.setCursor(Cursor.HAND);
        Tooltip tooltip167 = new Tooltip("Tryk her for at slette en ginflaske");
        button82.setTooltip(tooltip167);

        Button button83 = new Button("Gå tilbage til forside");
        button83.setTranslateX(-150);
        button83.setTranslateY(-280);
        button83.setPrefSize(250,45);
        button83.setOnAction(e -> getGUI().gåTilForside());
        button83.setFont(XStyle.M_FONT);
        button83.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button83.setCursor(Cursor.HAND);
        Tooltip tooltip168 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button83.setTooltip(tooltip168);

        getLayout().getChildren().addAll(label133, label134, listView14, button80, button81, button82, button83);

    }

    private void redigerFlaske() {
        if (listView14.getSelectionModel().getSelectedItem() != null) {
            ((RedigerGinflaskeScene) getGUI().getScene(SceneType.REDIGERGINFLASKE)).setGinflaske(listView14.getSelectionModel().getSelectedItem());
            getGUI().switchScene(SceneType.REDIGERGINFLASKE);
        } else {
            getGUI().alert("Fejl", "Ingen ginflaske valgt", "Ingen ginflaske valgt", Alert.AlertType.ERROR).showAndWait();
        }
    }

    @Override
    public void update() {
        ((RedigerGinflaskeScene) getGUI().getScene(SceneType.REDIGERGINFLASKE)).setGinflaske(null);
        listView14.getItems().clear();
        listView14.getItems().addAll(getGUI().getController().getGinflasker());
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public XIcon getIcon() {
        return XIcon.GINFLASKE;
    }
}
