package gui.scene.scenes;

import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RåvareScene extends XScene {
    public RåvareScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 8: Råvarer

        Label label39 = new Label("Råvarer");
        label39.setTranslateX(0);
        label39.setTranslateY(150);
        label39.setFont(new Font("Arial",36));
        label39.setTextFill(Color.BLACK);

        Label label40 = new Label("Her ses den nuværende beholdning");
        label40.setTranslateX(0);
        label40.setTranslateY(150);
        label40.setFont(new Font("Arial",16));
        label40.setTextFill(Color.BLACK);

        ListView listView9 = new ListView<>();
        listView9.setTranslateX(20);
        listView9.setTranslateY(20);
        listView9.setPrefSize(200,200);

        ImageView imageView7 = XIcon.KORIANDERFRØ.getImageView();
        imageView7.setFitHeight(100);
        imageView7.setFitWidth(100);
        imageView7.setTranslateX(10);
        imageView7.setTranslateY(-10);
        getLayout().getChildren().add(imageView7);

        Button button30 = new Button("Opret råvare");
        button30.setTranslateX(-150);
        button30.setTranslateY(-280);
        button30.setPrefSize(250,45);
        button30.setOnAction(e -> getGUI().switchScene(SceneType.OPRETRÅVARE));
        button30.setFont(new Font("Arial",16));
        button30.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button30.setCursor(Cursor.HAND);
        Tooltip tooltip41 = new Tooltip("Tryk her for at oprette en råvare");
        button30.setTooltip(tooltip41);

        Button button31 = new Button("Rediger råvare");
        button31.setTranslateX(-150);
        button31.setTranslateY(-280);
        button31.setPrefSize(250,45);
        button31.setOnAction(e -> getGUI().switchScene(SceneType.REDIGERRÅVARE));
        button31.setFont(new Font("Arial",16));
        button31.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button31.setCursor(Cursor.HAND);
        Tooltip tooltip42 = new Tooltip("Tryk her for at opdatere en råvare");
        button31.setTooltip(tooltip42);

        Button button32 = new Button("Slet råvare");
        button32.setTranslateX(-150);
        button32.setTranslateY(-280);
        button32.setPrefSize(250,45);
        button32.setFont(new Font("Arial",16));
        button32.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button32.setCursor(Cursor.HAND);
        Tooltip tooltip43 = new Tooltip("Tryk her for at slette en råvare");
        button32.setTooltip(tooltip43);

        Button button33 = new Button("Gå tilbage til forside");
        button33.setTranslateX(-150);
        button33.setTranslateY(-280);
        button33.setPrefSize(250,45);
        button33.setOnAction(e -> getGUI().gåTilForside());
        button33.setFont(new Font("Arial",16));
        button33.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button33.setCursor(Cursor.HAND);
        Tooltip tooltip44 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button33.setTooltip(tooltip44);

        getLayout().getChildren().addAll(label39, label40, listView9, button30, button31, button32, button33);
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
