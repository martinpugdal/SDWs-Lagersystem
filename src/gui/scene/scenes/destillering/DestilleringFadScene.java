package gui.scene.scenes.destillering;

import application.model.Destillering;
import application.model.opbevaring.Fad;
import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DestilleringFadScene extends XScene {

    public DestilleringFadScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 5: Tilføj/fjern destillering til/fra fad

        Label label23 = new Label("Tilføj/fjern destillering til/fra fad");
        label23.setTranslateX(0);
        label23.setTranslateY(150);
        label23.setFont(new Font("Arial", 36));
        label23.setTextFill(Color.BLACK);

        Label label24 = new Label("Omhæld fra fad til fad her");
        label24.setTranslateX(0);
        label24.setTranslateY(150);
        label24.setFont(new Font("Arial", 16));
        label24.setTextFill(Color.BLACK);

        Label label25 = new Label("Fra fad:");
        label25.setTranslateX(0);
        label25.setTranslateY(150);
        label25.setFont(new Font("Arial", 16));
        label25.setTextFill(Color.BLACK);

        Label label26 = new Label("Til fad:");
        label26.setTranslateX(0);
        label26.setTranslateY(150);
        label26.setFont(new Font("Arial", 16));
        label26.setTextFill(Color.BLACK);

        Label label27 = new Label("Antal liter der skal flyttes");
        label27.setTranslateX(0);
        label27.setTranslateY(150);
        label27.setFont(new Font("Arial", 16));
        label27.setTextFill(Color.BLACK);

        TextField textField9 = new TextField();
        textField9.setMaxWidth(100);
        Tooltip tooltip29 = new Tooltip();
        tooltip29.setText("Indtast antal liter her");
        textField9.setTooltip(tooltip29);
        textField9.setCursor(Cursor.TEXT);

        ListView<Destillering> listView2 = new ListView<>();
        listView2.getItems().addAll(getGUI().getController().getDestilleringer());
        listView2.setTranslateX(-200);
        listView2.setTranslateY(20);
        listView2.setMaxWidth(200);
        listView2.setPrefSize(200, 200);

        ListView<Fad> listView3 = new ListView<>();
        listView3.getItems().addAll(getGUI().getController().getFade());
        listView3.setTranslateX(-200);
        listView3.setTranslateY(20);
        listView3.setMaxWidth(200);
        listView3.setPrefSize(200, 200);

/*        ImageView imageView4 = XIcon.ALKOHOL.getImageView();
        imageView4.setFitHeight(100);
        imageView4.setFitWidth(100);
        imageView4.setTranslateX(10);
        imageView4.setTranslateY(-10);
        getLayout().getChildren().add(imageView4);*/

        Button button21 = new Button("Flyt destillering");
        button21.setTranslateX(-150);
        button21.setTranslateY(-280);
        button21.setPrefSize(250, 45);
        button21.setOnAction(e -> flytDestillering());
        button21.setFont(new Font("Arial", 16));
        button21.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button21.setCursor(Cursor.HAND);
        Tooltip tooltip30 = new Tooltip("Tryk her for at flytte destilleringsvæsken");
        button21.setTooltip(tooltip30);

        Button button22 = new Button("Annuller");
        button22.setTranslateX(-150);
        button22.setTranslateY(-280);
        button22.setPrefSize(250, 45);
        button22.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERING));
        button22.setFont(new Font("Arial", 16));
        button22.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button22.setCursor(Cursor.HAND);
        Tooltip tooltip31 = new Tooltip("Tryk her for at annullere");
        button22.setTooltip(tooltip31);

        Button button23 = new Button("Gå tilbage til forside");
        button23.setTranslateX(-150);
        button23.setTranslateY(-280);
        button23.setPrefSize(250, 45);
        button23.setOnAction(e -> getGUI().gåTilForside());
        button23.setFont(new Font("Arial", 16));
        button23.setStyle(XStyle.PRIMARY_BUTTON_STYLE);
        button23.setCursor(Cursor.HAND);
        Tooltip tooltip32 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button23.setTooltip(tooltip32);

        getLayout().getChildren().addAll(label23, label24, label25, label26, label27, textField9, listView2, listView3, button21, button22, button23);
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
        return null;
    }
}
