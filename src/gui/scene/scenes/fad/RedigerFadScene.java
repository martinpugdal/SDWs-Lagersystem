package gui.scene.scenes.fad;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RedigerFadScene extends XScene {
    public RedigerFadScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 13: Rediger fad

        Label label68 = new Label("Rediger fad");
        label68.setTranslateX(0);
        label68.setTranslateY(150);
        label68.setFont(new Font("Arial", 36));
        label68.setTextFill(Color.BLACK);

        Label label69 = new Label("Nummer");
        label69.setTranslateX(0);
        label69.setTranslateY(150);
        label69.setFont(new Font("Arial", 16));
        label69.setTextFill(Color.BLACK);

        Label label70 = new Label("Type");
        label70.setTranslateX(0);
        label70.setTranslateY(150);
        label70.setFont(new Font("Arial", 16));
        label70.setTextFill(Color.BLACK);

        Label label71 = new Label("Antal gange brugt");
        label71.setTranslateX(0);
        label71.setTranslateY(150);
        label71.setFont(new Font("Arial", 16));
        label71.setTextFill(Color.BLACK);

        Label label72 = new Label("Seneste tømningsdato");
        label72.setTranslateX(0);
        label72.setTranslateY(150);
        label72.setFont(new Font("Arial", 16));
        label72.setTextFill(Color.BLACK);

        Label label73 = new Label("Påfyldningsdato");
        label73.setTranslateX(0);
        label73.setTranslateY(150);
        label73.setFont(new Font("Arial", 16));
        label73.setTextFill(Color.BLACK);

        Label label74 = new Label("Solgt til 1");
        label74.setTranslateX(0);
        label74.setTranslateY(150);
        label74.setFont(new Font("Arial", 16));
        label74.setTextFill(Color.BLACK);

        Label label75 = new Label("Solgt til 2");
        label75.setTranslateX(0);
        label75.setTranslateY(150);
        label75.setFont(new Font("Arial", 16));
        label75.setTextFill(Color.BLACK);

        Label label76 = new Label("Solgt til 3");
        label76.setTranslateX(0);
        label76.setTranslateY(150);
        label76.setFont(new Font("Arial", 16));
        label76.setTextFill(Color.BLACK);

        Label label77 = new Label("Solgt til 4");
        label77.setTranslateX(0);
        label77.setTranslateY(150);
        label77.setFont(new Font("Arial", 16));
        label77.setTextFill(Color.BLACK);

        Label label78 = new Label("Solgt til 5");
        label78.setTranslateX(0);
        label78.setTranslateY(150);
        label78.setFont(new Font("Arial", 16));
        label78.setTextFill(Color.BLACK);

        Label label79 = new Label("Står ved");
        label79.setTranslateX(0);
        label79.setTranslateY(150);
        label79.setFont(new Font("Arial", 16));
        label79.setTextFill(Color.BLACK);

        Label label80 = new Label("Antal liter");
        label80.setTranslateX(0);
        label80.setTranslateY(150);
        label80.setFont(new Font("Arial", 16));
        label80.setTextFill(Color.BLACK);

        TextField textField34 = new TextField();
        textField34.setMaxWidth(100);
        Tooltip tooltip80 = new Tooltip();
        tooltip80.setText("Indtast nummeret på fadet her");
        textField34.setTooltip(tooltip80);
        textField34.setCursor(Cursor.TEXT);

        TextField textField35 = new TextField();
        textField35.setMaxWidth(100);
        Tooltip tooltip81 = new Tooltip();
        tooltip81.setText("Indtast typen af fad her");
        textField35.setTooltip(tooltip81);
        textField35.setCursor(Cursor.TEXT);

        TextField textField36 = new TextField();
        textField36.setMaxWidth(100);
        Tooltip tooltip82 = new Tooltip();
        tooltip82.setText("Indtast antal gange fadet har været brugt her");
        textField36.setTooltip(tooltip82);
        textField36.setCursor(Cursor.TEXT);

        TextField textField37 = new TextField();
        textField37.setMaxWidth(100);
        Tooltip tooltip83 = new Tooltip();
        tooltip83.setText("Indtast datoen for hvornår fadet sidst har været tømt her");
        textField37.setTooltip(tooltip83);
        textField37.setCursor(Cursor.TEXT);

        TextField textField38 = new TextField();
        textField38.setMaxWidth(100);
        Tooltip tooltip84 = new Tooltip();
        tooltip84.setText("Indtast hvornår fadet er blevet fyldt her");
        textField38.setTooltip(tooltip84);
        textField38.setCursor(Cursor.TEXT);

        TextField textField39 = new TextField();
        textField39.setMaxWidth(100);
        Tooltip tooltip85 = new Tooltip();
        tooltip85.setText("Indtast navnet på eventuel køber 1 her");
        textField39.setTooltip(tooltip85);
        textField39.setCursor(Cursor.TEXT);

        TextField textField40 = new TextField();
        textField40.setMaxWidth(100);
        Tooltip tooltip86 = new Tooltip();
        tooltip86.setText("Indtast navnet på eventuel køber 2 her");
        textField40.setTooltip(tooltip86);
        textField40.setCursor(Cursor.TEXT);

        TextField textField41 = new TextField();
        textField41.setMaxWidth(100);
        Tooltip tooltip87 = new Tooltip();
        tooltip87.setText("Indtast navnet på eventuel køber 3 her");
        textField41.setTooltip(tooltip87);
        textField41.setCursor(Cursor.TEXT);

        TextField textField42 = new TextField();
        textField42.setMaxWidth(100);
        Tooltip tooltip88 = new Tooltip();
        tooltip88.setText("Indtast navnet på eventuel køber 4 her");
        textField42.setTooltip(tooltip88);
        textField42.setCursor(Cursor.TEXT);

        TextField textField43 = new TextField();
        textField43.setMaxWidth(100);
        Tooltip tooltip89 = new Tooltip();
        tooltip89.setText("Indtast navnet på eventuel køber 5 her");
        textField43.setTooltip(tooltip89);
        textField43.setCursor(Cursor.TEXT);

        TextField textField44 = new TextField();
        textField44.setMaxWidth(100);
        Tooltip tooltip90 = new Tooltip();
        tooltip90.setText("Indtast hvor fadet står her");
        textField44.setTooltip(tooltip90);
        textField44.setCursor(Cursor.TEXT);

        TextField textField45 = new TextField();
        textField45.setMaxWidth(100);
        Tooltip tooltip91 = new Tooltip();
        tooltip91.setText("Indtast antal liter her");
        textField45.setTooltip(tooltip91);
        textField45.setCursor(Cursor.TEXT);

        CheckBox checkBox4 = new CheckBox();
        checkBox4.setText("Intakt");

        CheckBox checkBox5 = new CheckBox();
        checkBox5.setText("Fadet kan anvendes igen");

        CheckBox checkBox6 = new CheckBox();
        checkBox6.setText("Solgt");

        ImageView imageView12 = XIcon.FAD.getImageView();
        imageView12.setFitHeight(100);
        imageView12.setFitWidth(100);
        imageView12.setTranslateX(10);
        imageView12.setTranslateY(-10);
        getLayout().getChildren().add(imageView12);

        Button button47 = new Button("Rediger fad");
        button47.setTranslateX(-150);
        button47.setTranslateY(-280);
        button47.setPrefSize(250, 45);
        button47.setOnAction(e -> getGUI().switchScene(this));
        button47.setFont(new Font("Arial", 16));
        button47.setCursor(Cursor.HAND);
        button47.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        Tooltip tooltip92 = new Tooltip("Tryk her for at redigere fadet");
        button47.setTooltip(tooltip92);

        Button button48 = new Button("Gå tilbage til oversigt over fade");
        button48.setTranslateX(-150);
        button48.setTranslateY(-280);
        button48.setPrefSize(250, 45);
        button48.setOnAction(e -> getGUI().switchScene(this));
        button48.setFont(new Font("Arial", 16));
        button48.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button48.setCursor(Cursor.HAND);
        Tooltip tooltip93 = new Tooltip("Tryk her for at vende tilbage til oversigten");
        button48.setTooltip(tooltip93);

        Button button49 = new Button("Gå tilbage til forside");
        button49.setTranslateX(-150);
        button49.setTranslateY(-280);
        button49.setPrefSize(250, 45);
        button49.setOnAction(e -> getGUI().gåTilForside());
        button49.setFont(new Font("Arial", 16));
        button49.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button49.setCursor(Cursor.HAND);
        Tooltip tooltip94 = new Tooltip("Tryk her for at flytte destilleringsvæsken");
        button49.setTooltip(tooltip94);

        getLayout().getChildren().addAll(label68, label69, label70, label71, label72, label73, label74, label75, label76, label77, label78, label79, label80, textField34, textField35, textField36, textField37, textField38, textField39, textField40, textField41, textField42, textField43, textField44, textField45, checkBox4, checkBox5, checkBox6, button47, button48, button49);
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
