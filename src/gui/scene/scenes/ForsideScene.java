package gui.scene.scenes;

import gui.GUI;
import gui.scene.SceneType;
import gui.setting.XIcon;
import gui.setting.XScene;
import gui.setting.XStyle;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ForsideScene extends XScene {

    public ForsideScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        Label label1 = new Label("Sall Whisky Distillery - Lagersystem");
        label1.setTranslateX(0);
        label1.setTranslateY(100 + 60 + 20);
        label1.setFont(XStyle.XXL_FONT);


        ImageView view1 = XIcon.DESTILLERING.getImageView();
        view1.setFitHeight(75);
        view1.setFitWidth(75);
        view1.setPreserveRatio(true);

        Label label2 = new Label("Destilleringer");
        label2.setFont(XStyle.M_FONT);
        label2.setPrefSize(100, 25);
        label2.setAlignment(Pos.CENTER);
        Button button1 = new Button();
        button1.setPrefSize(100, 100);
        button1.setMinSize(100, 100);
        button1.setMaxSize(100, 100);
        button1.setGraphic(view1);
        button1.setOnAction(e -> getGUI().switchScene(SceneType.DESTILLERING));
        button1.setCursor(Cursor.HAND);
        Tooltip tooltip1 = new Tooltip("Tryk her for at administrere destillinger");
        button1.setTooltip(tooltip1);

        VBox vboxDestillering = new VBox();
        vboxDestillering.setPrefSize(100, 100);
        vboxDestillering.setMaxSize(100, 100);
        vboxDestillering.setMinSize(100, 100);
        vboxDestillering.setAlignment(javafx.geometry.Pos.CENTER);
        vboxDestillering.setTranslateX(-300);
        vboxDestillering.setTranslateY(270);
        vboxDestillering.getChildren().addAll(button1, label2);


        ImageView view2 = XIcon.ENEBÆR.getImageView();
        view2.setFitHeight(75);
        view2.setFitWidth(75);
        view2.setPreserveRatio(true);

        Label label3 = new Label("Råvarer");
        label3.setFont(XStyle.M_FONT);
        label3.setPrefSize(100, 25);
        label3.setAlignment(Pos.CENTER);
        Button button2 = new Button();
        button2.setPrefSize(100, 100);
        button2.setMinSize(100, 100);
        button2.setMaxSize(100, 100);
        button2.setGraphic(view2);
        button2.setOnAction(e -> getGUI().switchScene(SceneType.RÅVARE));
        button2.setCursor(Cursor.HAND);
        Tooltip tooltip2 = new Tooltip("Tryk her for at administrere råvarer");
        button2.setTooltip(tooltip2);

        VBox vboxRåvarer = new VBox();
        vboxRåvarer.setPrefSize(100, 100);
        vboxRåvarer.setMaxSize(100, 100);
        vboxRåvarer.setMinSize(100, 100);
        vboxRåvarer.setAlignment(javafx.geometry.Pos.CENTER);
        vboxRåvarer.setTranslateX(-100);
        vboxRåvarer.setTranslateY(170);
        vboxRåvarer.getChildren().addAll(button2, label3);


        ImageView view3 = XIcon.FAD.getImageView();
        view3.setFitHeight(75);
        view3.setFitWidth(75);
        view3.setPreserveRatio(true);

        Label label4 = new Label("Fade");
        label4.setFont(XStyle.M_FONT);
        label4.setPrefSize(100, 25);
        label4.setAlignment(Pos.CENTER);
        Button button3 = new Button();
        button3.setPrefSize(100, 100);
        button3.setMinSize(100, 100);
        button3.setMaxSize(100, 100);
        button3.setGraphic(view3);
        button3.setOnAction(e -> getGUI().switchScene(SceneType.FAD));
        button3.setCursor(Cursor.HAND);
        Tooltip tooltip3 = new Tooltip("Tryk her for at administrere fade");
        button3.setTooltip(tooltip3);

        VBox vboxFade = new VBox();
        vboxFade.setPrefSize(100, 100);
        vboxFade.setMaxSize(100, 100);
        vboxFade.setMinSize(100, 100);
        vboxFade.setAlignment(javafx.geometry.Pos.CENTER);
        vboxFade.setTranslateX(100);
        vboxFade.setTranslateY(50 + 20);
        vboxFade.getChildren().addAll(button3, label4);


        ImageView view4 = XIcon.PLASTIKTANK.getImageView();
        view4.setFitHeight(75);
        view4.setFitWidth(75);
        view4.setPreserveRatio(true);

        Label label5 = new Label("Plastictanke");
        label5.setFont(XStyle.M_FONT);
        label5.setPrefSize(100, 25);
        label5.setAlignment(Pos.CENTER);
        Button button4 = new Button();
        button4.setPrefSize(100, 100);
        button4.setMinSize(100, 100);
        button4.setMaxSize(100, 100);
        button4.setGraphic(view4);
        button4.setOnAction(e -> getGUI().switchScene(SceneType.PLASTICTANK));
        button4.setCursor(Cursor.HAND);
        Tooltip tooltip4 = new Tooltip("Tryk her for at administrere plastictanke");
        button4.setTooltip(tooltip4);

        VBox vboxPlastictanke = new VBox();
        vboxPlastictanke.setPrefSize(100, 100);
        vboxPlastictanke.setMaxSize(100, 100);
        vboxPlastictanke.setMinSize(100, 100);
        vboxPlastictanke.setAlignment(javafx.geometry.Pos.CENTER);
        vboxPlastictanke.setTranslateX(300);
        vboxPlastictanke.setTranslateY(-30);
        vboxPlastictanke.getChildren().addAll(button4, label5);


        ImageView view5 = XIcon.LAGER.getImageView();
        view5.setFitHeight(75);
        view5.setFitWidth(75);
        view5.setPreserveRatio(true);

        Label label6 = new Label("Lager");
        label6.setFont(XStyle.M_FONT);
        label6.setPrefSize(100, 25);
        label6.setAlignment(Pos.CENTER);
        Button button5 = new Button();
        button5.setPrefSize(100, 100);
        button5.setMinSize(100, 100);
        button5.setMaxSize(100, 100);
        button5.setGraphic(view5);
        button5.setOnAction(e -> getGUI().switchScene(SceneType.LAGER));
        button5.setCursor(Cursor.HAND);
        Tooltip tooltip5 = new Tooltip("Tryk her for at administrere lagre");
        button5.setTooltip(tooltip5);

        VBox vboxLager = new VBox();
        vboxLager.setPrefSize(100, 100);
        vboxLager.setMaxSize(100, 100);
        vboxLager.setMinSize(100, 100);
        vboxLager.setAlignment(javafx.geometry.Pos.CENTER);
        vboxLager.setTranslateX(-300);
        vboxLager.setTranslateY(40 + 10);
        vboxLager.getChildren().addAll(button5, label6);


        ImageView view9 = XIcon.AFDELING.getImageView();
        view9.setFitHeight(75);
        view9.setFitWidth(75);
        view9.setPreserveRatio(true);

        Label label9 = new Label("Afdelinger");
        label9.setFont(XStyle.M_FONT);
        label9.setPrefSize(100, 25);
        label9.setAlignment(Pos.CENTER);
        Button button9 = new Button();
        button9.setPrefSize(100, 100);
        button9.setMinSize(100, 100);
        button9.setMaxSize(100, 100);
        button9.setGraphic(view9);
        button9.setOnAction(e -> getGUI().switchScene(SceneType.AFDELING));
        button9.setCursor(Cursor.HAND);
        Tooltip tooltip9 = new Tooltip("Tryk her for at administrere afdelinger");
        button9.setTooltip(tooltip9);

        VBox vboxAfdeling = new VBox();
        vboxAfdeling.setPrefSize(100, 100);
        vboxAfdeling.setMaxSize(100, 100);
        vboxAfdeling.setMinSize(100, 100);
        vboxAfdeling.setAlignment(javafx.geometry.Pos.CENTER);
        vboxAfdeling.setTranslateX(-100);
        vboxAfdeling.setTranslateY(-100 + 50);
        vboxAfdeling.getChildren().addAll(button9, label9);


        ImageView view6 = XIcon.WHISKYFLASKE.getImageView();
        view6.setFitHeight(75);
        view6.setFitWidth(75);
        view6.setPreserveRatio(true);

        Label label7 = new Label("Whiskyflasker");
        label7.setFont(XStyle.M_FONT);
        label7.setPrefSize(100, 25);
        label7.setAlignment(Pos.CENTER);
        Button button6 = new Button();
        button6.setPrefSize(100, 100);
        button6.setMinSize(100, 100);
        button6.setMaxSize(100, 100);
        button6.setGraphic(view6);
        button6.setOnAction(e -> getGUI().switchScene(SceneType.WHISKYFLASKE));
        button6.setCursor(Cursor.HAND);
        Tooltip tooltip6 = new Tooltip("Tryk her for at administrere whiskyflasker");
        button6.setTooltip(tooltip6);

        VBox vboxWhiskyflasker = new VBox();
        vboxWhiskyflasker.setPrefSize(100, 100);
        vboxWhiskyflasker.setMaxSize(100, 100);
        vboxWhiskyflasker.setMinSize(100, 100);
        vboxWhiskyflasker.setAlignment(javafx.geometry.Pos.CENTER);
        vboxWhiskyflasker.setTranslateX(100);
        vboxWhiskyflasker.setTranslateY(-150);
        vboxWhiskyflasker.getChildren().addAll(button6, label7);


        ImageView view7 = XIcon.GINFLASKE.getImageView();
        view7.setFitHeight(75);
        view7.setFitWidth(75);
        view7.setPreserveRatio(true);

        Label label8 = new Label("Ginflasker");
        label8.setFont(XStyle.M_FONT);
        label8.setPrefSize(100, 25);
        label8.setAlignment(Pos.CENTER);
        Button button7 = new Button();
        button7.setPrefSize(100, 100);
        button7.setMinSize(100, 100);
        button7.setMaxSize(100, 100);
        button7.setGraphic(view7);
        button7.setOnAction(e -> getGUI().switchScene(SceneType.GINFLASKE));
        button7.setCursor(Cursor.HAND);
        Tooltip tooltip7 = new Tooltip("Tryk her for at administrere ginflasker");
        button7.setTooltip(tooltip7);

        VBox vboxGinflasker = new VBox();
        vboxGinflasker.setPrefSize(100, 100);
        vboxGinflasker.setMaxSize(100, 100);
        vboxGinflasker.setMinSize(100, 100);
        vboxGinflasker.setAlignment(javafx.geometry.Pos.CENTER);
        vboxGinflasker.setTranslateX(300);
        vboxGinflasker.setTranslateY(-250);
        vboxGinflasker.getChildren().addAll(button7, label8);

        getLayout().getChildren().addAll(label1, vboxDestillering, vboxRåvarer, vboxFade, vboxPlastictanke, vboxLager, vboxAfdeling, vboxWhiskyflasker, vboxGinflasker);
    }

    @Override
    public String getTitle() {
        return "Sall Whisky Distillery - Lagersystem";
    }

    @Override
    public XIcon getIcon() {
        return XIcon.SALLWHISKY;
    }
}
