package gui.scene;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XLayout;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DestilleringScene extends XScene {

    public DestilleringScene(GUI gui) {
        super(new XLayout(), gui);
        initLayout();
    }

    private XLayout getLayout() {
        return (XLayout) getRoot();
    }

    private void initLayout() {
        //Skærmbillede 2: Destillering
        Label label9 = new Label("Destillering");
        label9.setTranslateX(0);
        label9.setTranslateY(150);
        label9.setFont(new Font("Calibri", 24));
        label9.setTextFill(Color.BLACK);

        Label label10 = new Label("Her kan der oprettes væsker som så kan fordeles på fade, tanke samt flasker");
        label10.setTranslateX(0);
        label10.setTranslateY(150);
        label10.setFont(new Font("Calibri", 12));
        label10.setTextFill(Color.BLACK);

        ListView listView1 = new ListView<>();
        listView1.setTranslateX(20);
        listView1.setTranslateY(20);
        listView1.setPrefSize(200, 200);

        ImageView imageView1 = XIcon.DESTILLERING.getImageView();
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(600);
        imageView1.setTranslateX(10);
        imageView1.setTranslateY(-10);
        getLayout().getChildren().add(imageView1);

        Button button8 = new Button();
        button8.setTranslateX(-150);
        button8.setTranslateY(-280);
        button8.setPrefSize(100, 100);
        button8.setOnAction(e -> getGUI().gåTilForside());
        button8.setFont(new Font("Calibri", 12));
        button8.setCursor(Cursor.HAND);
        Tooltip tooltip8 = new Tooltip("Tryk her for at oprette destilleringsvæske");
        button8.setTooltip(tooltip8);

        Button button9 = new Button();
        button9.setTranslateX(-150);
        button9.setTranslateY(-280);
        button9.setPrefSize(100, 100);
        button9.setOnAction(e -> getGUI().gåTilForside());
        button9.setFont(new Font("Calibri", 12));
        button9.setCursor(Cursor.HAND);
        Tooltip tooltip9 = new Tooltip("Tryk her for at redigere destilleringsvæske");
        button9.setTooltip(tooltip9);

        Button button10 = new Button();
        button10.setTranslateX(-150);
        button10.setTranslateY(-280);
        button10.setPrefSize(100, 100);
        button10.setFont(new Font("Calibri", 12));
        button10.setCursor(Cursor.HAND);
        Tooltip tooltip10 = new Tooltip("Tryk her for at slette destilleringsvæsken fra systemet");
        button10.setTooltip(tooltip10);

        Button button11 = new Button();
        button11.setTranslateX(-150);
        button11.setTranslateY(-280);
        button11.setPrefSize(100, 100);
        button11.setOnAction(e -> getGUI().gåTilForside());
        button11.setFont(new Font("Calibri", 12));
        button11.setCursor(Cursor.HAND);
        Tooltip tooltip11 = new Tooltip("Tryk her for at tilføje/fjerne destilleringsvæske til/fra et fad");
        button11.setTooltip(tooltip11);

        Button button12 = new Button();
        button12.setTranslateX(-150);
        button12.setTranslateY(-280);
        button12.setPrefSize(100, 100);
        button12.setOnAction(e -> getGUI().gåTilForside());
        button12.setFont(new Font("Calibri", 12));
        button12.setCursor(Cursor.HAND);
        Tooltip tooltip12 = new Tooltip("Tryk her for at tilføje/fjerne destilleringsvæske til/fra en plastictank");
        button12.setTooltip(tooltip12);

        Button button13 = new Button();
        button13.setTranslateX(-150);
        button13.setTranslateY(-280);
        button13.setPrefSize(100, 100);
        button13.setOnAction(e -> getGUI().gåTilForside());
        button13.setFont(new Font("Calibri", 12));
        button13.setCursor(Cursor.HAND);
        Tooltip tooltip13 = new Tooltip("Tryk her for at tilføje/fjerne destilleringsvæske til/fra flasker");
        button13.setTooltip(tooltip13);

        Button button14 = new Button();
        button14.setTranslateX(-150);
        button14.setTranslateY(-280);
        button14.setMaxSize(100, 100);
        button14.setOnAction(e -> getGUI().gåTilForside());
        button14.setFont(new Font("Calibri", 12));
        ImageView view14 = XIcon.TILBAGE.getImageView();
        view14.setFitHeight(100);
        view14.setFitWidth(100);
        view14.setPreserveRatio(true);
        button14.setGraphic(view14);
        button14.setCursor(Cursor.HAND);
        Tooltip tooltip14 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button14.setTooltip(tooltip14);

        getLayout().getChildren().addAll(label9, label10, listView1, button8, button9, button10, button11, button12, button13, button14);
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
