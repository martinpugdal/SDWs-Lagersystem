package gui.scene.scenes.fad;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OpretFadScene extends XScene {
    public OpretFadScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 12: Opret fad

        Label label55 = new Label("Opret fad");
        label55.setTranslateX(0);
        label55.setTranslateY(150);
        label55.setFont(new Font("Arial",36));
        label55.setTextFill(Color.BLACK);

        Label label56 = new Label("Nummer");
        label56.setTranslateX(0);
        label56.setTranslateY(150);
        label56.setFont(new Font("Arial",16));
        label56.setTextFill(Color.BLACK);

        Label label57 = new Label("Type");
        label57.setTranslateX(0);
        label57.setTranslateY(150);
        label57.setFont(new Font("Arial",16));
        label57.setTextFill(Color.BLACK);

        Label label58 = new Label("Antal gange brugt");
        label58.setTranslateX(0);
        label58.setTranslateY(150);
        label58.setFont(new Font("Arial",16));
        label58.setTextFill(Color.BLACK);

        Label label59 = new Label("Seneste tømningsdato");
        label59.setTranslateX(0);
        label59.setTranslateY(150);
        label59.setFont(new Font("Arial",16));
        label59.setTextFill(Color.BLACK);

        Label label60 = new Label("Påfyldningsdato");
        label60.setTranslateX(0);
        label60.setTranslateY(150);
        label60.setFont(new Font("Arial",16));
        label60.setTextFill(Color.BLACK);

        Label label61 = new Label("Solgt til 1");
        label61.setTranslateX(0);
        label61.setTranslateY(150);
        label61.setFont(new Font("Arial",16));
        label61.setTextFill(Color.BLACK);

        Label label62 = new Label("Solgt til 2");
        label62.setTranslateX(0);
        label62.setTranslateY(150);
        label62.setFont(new Font("Arial",16));
        label62.setTextFill(Color.BLACK);

        Label label63 = new Label("Solgt til 3");
        label63.setTranslateX(0);
        label63.setTranslateY(150);
        label63.setFont(new Font("Arial",16));
        label63.setTextFill(Color.BLACK);

        Label label64 = new Label("Solgt til 4");
        label64.setTranslateX(0);
        label64.setTranslateY(150);
        label64.setFont(new Font("Arial",16));
        label64.setTextFill(Color.BLACK);

        Label label65 = new Label("Solgt til 5");
        label65.setTranslateX(0);
        label65.setTranslateY(150);
        label65.setFont(new Font("Arial",16));
        label65.setTextFill(Color.BLACK);

        Label label66 = new Label("Står ved");
        label66.setTranslateX(0);
        label66.setTranslateY(150);
        label66.setFont(new Font("Arial",16));
        label66.setTextFill(Color.BLACK);

        Label label67 = new Label("Antal liter");
        label67.setTranslateX(0);
        label67.setTranslateY(150);
        label67.setFont(new Font("Arial",16));
        label67.setTextFill(Color.BLACK);

        TextField textField22 = new TextField();
        textField22.setMaxWidth(100);
        Tooltip tooltip65 = new Tooltip();
        tooltip65.setText("Indtast nummeret på fadet her");
        textField22.setTooltip(tooltip65);
        textField22.setCursor(Cursor.TEXT);

        TextField textField23 = new TextField();
        textField23.setMaxWidth(100);
        Tooltip tooltip66 = new Tooltip();
        tooltip66.setText("Indtast typen af fad her");
        textField23.setTooltip(tooltip66);
        textField23.setCursor(Cursor.TEXT);

        TextField textField24 = new TextField();
        textField24.setMaxWidth(100);
        Tooltip tooltip67 = new Tooltip();
        tooltip67.setText("Indtast antallet af gange fadet har været brugt her");
        textField24.setTooltip(tooltip67);
        textField24.setCursor(Cursor.TEXT);

        TextField textField25 = new TextField();
        textField25.setMaxWidth(100);
        Tooltip tooltip68 = new Tooltip();
        tooltip68.setText("Indtast datoen for hvornår fadet senest har været tømt her");
        textField25.setTooltip(tooltip68);
        textField25.setCursor(Cursor.TEXT);

        TextField textField26 = new TextField();
        textField26.setMaxWidth(100);
        Tooltip tooltip69 = new Tooltip();
        tooltip69.setText("Indtast datoen for hvornår fadet er blevet fyldt her");
        textField26.setTooltip(tooltip69);
        textField26.setCursor(Cursor.TEXT);

        TextField textField27 = new TextField();
        textField27.setMaxWidth(100);
        Tooltip tooltip70 = new Tooltip();
        tooltip70.setText("Indtast navnet på eventuel køber 1 her");
        textField27.setTooltip(tooltip70);
        textField27.setCursor(Cursor.TEXT);

        TextField textField28 = new TextField();
        textField28.setMaxWidth(100);
        Tooltip tooltip71 = new Tooltip();
        tooltip71.setText("Indtast navnet på eventuel køber 2 her");
        textField28.setTooltip(tooltip71);
        textField28.setCursor(Cursor.TEXT);

        TextField textField29 = new TextField();
        textField29.setMaxWidth(100);
        Tooltip tooltip72 = new Tooltip();
        tooltip72.setText("Indtast navnet på eventuel køber 3 her");
        textField29.setTooltip(tooltip72);
        textField29.setCursor(Cursor.TEXT);

        TextField textField30 = new TextField();
        textField30.setMaxWidth(100);
        Tooltip tooltip73 = new Tooltip();
        tooltip73.setText("Indtast navnet på eventuel køber 4 her");
        textField30.setTooltip(tooltip73);
        textField30.setCursor(Cursor.TEXT);

        TextField textField31 = new TextField();
        textField31.setMaxWidth(100);
        Tooltip tooltip74 = new Tooltip();
        tooltip74.setText("Indtast navnet på eventuel køber 5 her");
        textField31.setTooltip(tooltip74);
        textField31.setCursor(Cursor.TEXT);

        TextField textField32 = new TextField();
        textField32.setMaxWidth(100);
        Tooltip tooltip75 = new Tooltip();
        tooltip75.setText("Indtast hvor fadet står her");
        textField32.setTooltip(tooltip75);
        textField32.setCursor(Cursor.TEXT);

        TextField textField33 = new TextField();
        textField33.setMaxWidth(100);
        Tooltip tooltip76 = new Tooltip();
        tooltip76.setText("Indtast antal liter på fadet her");
        textField33.setTooltip(tooltip76);
        textField33.setCursor(Cursor.TEXT);

        CheckBox checkBox1 = new CheckBox();
        checkBox1.setText("Intakt");

        CheckBox checkBox2 = new CheckBox();
        checkBox2.setText("Fadet kan anvendes igen");

        CheckBox checkBox3 = new CheckBox();
        checkBox3.setText("Solgt");

        ImageView imageView11 = XIcon.FAD.getImageView();
        imageView11.setFitHeight(100);
        imageView11.setFitWidth(100);
        imageView11.setTranslateX(10);
        imageView11.setTranslateY(-10);
        getLayout().getChildren().add(imageView11);

        Button button44 = new Button("Opret fad");
        button44.setTranslateX(-150);
        button44.setTranslateY(-280);
        button44.setPrefSize(250,45);
        button44.setOnAction(e -> getGUI().switchScene(this));
        button44.setFont(new Font("Arial",16));
        button44.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button44.setCursor(Cursor.HAND);
        Tooltip tooltip77 = new Tooltip("Tryk her for at oprette fadet");
        button44.setTooltip(tooltip77);

        Button button45 = new Button("Gå tilbage til oversigt over fade");
        button45.setTranslateX(-150);
        button45.setTranslateY(-280);
        button45.setPrefSize(250,45);
        button45.setOnAction(e -> getGUI().switchScene(this));
        button45.setFont(new Font("Arial",16));
        button45.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button45.setCursor(Cursor.HAND);
        Tooltip tooltip78 = new Tooltip("Tryk her for at gå tilbage til oversigten");
        button45.setTooltip(tooltip78);

        Button button46 = new Button("Gå tilbage til forside");
        button46.setTranslateX(-150);
        button46.setTranslateY(-280);
        button46.setPrefSize(250,45);
        button46.setOnAction(e -> getGUI().gåTilForside());
        button46.setFont(new Font("Arial",16));
        button46.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button46.setCursor(Cursor.HAND);
        Tooltip tooltip79 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button46.setTooltip(tooltip79);

        getLayout().getChildren().addAll(label55, label56, label57, label58, label59, label60, label61, label62, label63, label64, label65, label66, label67, textField22, textField23, textField24, textField25, textField26, textField27, textField28, textField29, textField30, textField31, textField32, textField33, checkBox1, checkBox2, checkBox3, button44, button45, button46);
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
