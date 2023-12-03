package gui.scene;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XLayout;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ForsideScene extends XScene {

    private final DestilleringScene destilleringScene = new DestilleringScene(getGUI());

    public ForsideScene(GUI gui) {
        super(new XLayout(), gui);
        initLayout();
    }

    private XLayout getLayout() {
        return (XLayout) getRoot();
    }

    private void initLayout() {
        //Skærmbillede 1: Forside
        Label label1 = new Label("Sall Whisky Distillery - Lagersystem");
        label1.setTranslateX(0);
        label1.setTranslateY(150);
        label1.setFont(new Font("Calibri", 24));
        label1.setTextFill(Color.BLACK);

        Label label2 = new Label("Destilleringer");
        label2.setTranslateX(-300);
        label2.setTranslateY(250);
        label2.setFont(new Font("Calibri", 14));
        label2.setTextFill(Color.BLACK);

        Label label3 = new Label("Råvarer");
        label3.setTranslateX(-150);
        label3.setTranslateY(250);
        label3.setFont(new Font("Calibri", 14));
        label3.setTextFill(Color.BLACK);

        Label label4 = new Label("Fade");
        label4.setTranslateX(0);
        label4.setTranslateY(250);
        label4.setFont(new Font("Calibri", 14));
        label4.setTextFill(Color.BLACK);

        Label label5 = new Label("Plastictanke");
        label5.setTranslateX(-100);
        label5.setTranslateY(50);
        label5.setFont(new Font("Calibri", 14));
        label5.setTextFill(Color.BLACK);

        Label label6 = new Label("Lager");
        label6.setTranslateX(-50);
        label6.setTranslateY(50);
        label6.setFont(new Font("Calibri", 14));
        label6.setTextFill(Color.BLACK);

        Label label7 = new Label("Whiskyflasker");
        label7.setTranslateX(-100);
        label7.setTranslateY(150);
        label7.setFont(new Font("Calibri", 14));
        label7.setTextFill(Color.BLACK);

        Label label8 = new Label("Ginflasker");
        label8.setTranslateX(0);
        label8.setTranslateY(0);
        label8.setFont(new Font("Calibri", 14));
        label8.setTextFill(Color.BLACK);

        ImageView view1 = XIcon.DESTILLERING.getImageView();
        view1.setFitHeight(100);
        view1.setFitWidth(100);
        view1.setPreserveRatio(true);

        Button button1 = new Button();
        button1.setTranslateX(-300);
        button1.setTranslateY(25);
        button1.setPrefSize(100, 100);
        button1.setGraphic(view1);
        button1.setOnAction(e -> getGUI().switchScene(destilleringScene));
        button1.setFont(new Font("Calibri", 12));
        button1.setCursor(Cursor.HAND);
        Tooltip tooltip1 = new Tooltip("Tryk her for at administrere destillinger");
        button1.setTooltip(tooltip1);

        ImageView view2 = XIcon.ENEBÆR.getImageView();
        view2.setFitHeight(100);
        view2.setFitWidth(100);
        view2.setPreserveRatio(true);

        Button button2 = new Button();
        button2.setTranslateX(-150);
        button2.setTranslateY(25);
        button2.setPrefSize(100, 100);
        button2.setGraphic(view2);
        button2.setOnAction(e -> getGUI().switchScene(this));
        button2.setFont(new Font("Calibri", 12));
        button2.setCursor(Cursor.HAND);
        Tooltip tooltip2 = new Tooltip("Tryk her for at administrere råvarer");
        button2.setTooltip(tooltip2);

        ImageView view3 = XIcon.FAD.getImageView();
        view3.setFitHeight(100);
        view3.setFitWidth(100);
        view3.setPreserveRatio(true);

        Button button3 = new Button();
        button3.setTranslateX(0);
        button3.setTranslateY(25);
        button3.setPrefSize(100, 100);
        button3.setGraphic(view3);
        button3.setOnAction(e -> getGUI().switchScene(this));
        button3.setFont(new Font("Calibri", 12));
        button3.setCursor(Cursor.HAND);
        Tooltip tooltip3 = new Tooltip("Tryk her for at administrere fade");
        button3.setTooltip(tooltip3);

        ImageView view4 = XIcon.PLASTIK_TANK.getImageView();
        view4.setFitHeight(100);
        view4.setFitWidth(100);
        view4.setPreserveRatio(true);

        Button button4 = new Button();
        button4.setTranslateX(150);
        button4.setTranslateY(25);
        button4.setPrefSize(100, 100);
        button4.setGraphic(view4);
        button4.setOnAction(e -> getGUI().switchScene(this));
        button4.setFont(new Font("Calibri", 12));
        button4.setCursor(Cursor.HAND);
        Tooltip tooltip4 = new Tooltip("Tryk her for at administrere plastictanke");
        button4.setTooltip(tooltip4);

        ImageView view5 = XIcon.LAGER.getImageView();
        view5.setFitHeight(100);
        view5.setFitWidth(100);
        view5.setPreserveRatio(true);

        Button button5 = new Button();
        button5.setTranslateX(300);
        button5.setTranslateY(25);
        button5.setPrefSize(100, 100);
        button5.setGraphic(view5);
        button5.setOnAction(e -> getGUI().switchScene(this));
        button5.setFont(new Font("Calibri", 12));
        button5.setCursor(Cursor.HAND);
        Tooltip tooltip5 = new Tooltip("Tryk her for at administrere lagre");
        button5.setTooltip(tooltip5);

        ImageView view6 = XIcon.WHISKYFLASKE.getImageView();
        view6.setFitHeight(100);
        view6.setFitWidth(100);
        view6.setPreserveRatio(true);

        Button button6 = new Button();
        button6.setTranslateX(-150);
        button6.setTranslateY(-280);
        button6.setPrefSize(100, 100);
        button6.setGraphic(view6);
        button6.setOnAction(e -> getGUI().switchScene(this));
        button6.setFont(new Font("Calibri", 12));
        button6.setCursor(Cursor.HAND);
        Tooltip tooltip6 = new Tooltip("Tryk her for at administrere whiskyflasker");
        button6.setTooltip(tooltip6);


        ImageView view7 = XIcon.GINFLASKE.getImageView();
        view7.setFitHeight(100);
        view7.setFitWidth(100);
        view7.setPreserveRatio(true);

        Button button7 = new Button();
        button7.setTranslateX(-150);
        button7.setTranslateY(-280);
        button7.setPrefSize(100, 100);
        button7.setGraphic(view7);
        button7.setOnAction(e -> getGUI().switchScene(this));
        button7.setFont(new Font("Calibri", 12));
        button7.setCursor(Cursor.HAND);
        Tooltip tooltip7 = new Tooltip("Tryk her for at administrere ginflasker");
        button7.setTooltip(tooltip7);

        getLayout().getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, label8, button1, button2, button3, button4, button5, button6, button7);
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Lagersystem";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.LAGER;
    }
}
