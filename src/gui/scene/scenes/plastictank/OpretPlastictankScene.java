package gui.scene.scenes.plastictank;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OpretPlastictankScene extends XScene {
    public OpretPlastictankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 15: Opret plastictank

        Label label83 = new Label("Opret plastictank");
        label83.setTranslateX(0);
        label83.setTranslateY(150);
        label83.setFont(new Font("Arial",36));
        label83.setTextFill(Color.BLACK);

        Label label84 = new Label("Nummer");
        label84.setTranslateX(0);
        label84.setTranslateY(150);
        label84.setFont(new Font("Arial",16));
        label84.setTextFill(Color.BLACK);

        Label label85 = new Label("Antal gange brugt");
        label85.setTranslateX(0);
        label85.setTranslateY(150);
        label85.setFont(new Font("Arial",16));
        label85.setTextFill(Color.BLACK);

        Label label86 = new Label("Seneste tømningsdato");
        label86.setTranslateX(0);
        label86.setTranslateY(150);
        label86.setFont(new Font("Arial",16));
        label86.setTextFill(Color.BLACK);

        Label label87 = new Label("Påfyldningsdato");
        label87.setTranslateX(0);
        label87.setTranslateY(150);
        label87.setFont(new Font("Arial",16));
        label87.setTextFill(Color.BLACK);

        Label label88 = new Label("Solgt til 1");
        label88.setTranslateX(0);
        label88.setTranslateY(150);
        label88.setFont(new Font("Arial",16));
        label88.setTextFill(Color.BLACK);

        Label label89 = new Label("Solgt til 2");
        label89.setTranslateX(0);
        label89.setTranslateY(150);
        label89.setFont(new Font("Arial",16));
        label89.setTextFill(Color.BLACK);

        Label label90 = new Label("Solgt til 3");
        label90.setTranslateX(0);
        label90.setTranslateY(150);
        label90.setFont(new Font("Arial",16));
        label90.setTextFill(Color.BLACK);

        Label label91 = new Label("Solgt til 4");
        label91.setTranslateX(0);
        label91.setTranslateY(150);
        label91.setFont(new Font("Arial",16));
        label91.setTextFill(Color.BLACK);

        Label label92 = new Label("Solgt til 5");
        label92.setTranslateX(0);
        label92.setTranslateY(150);
        label92.setFont(new Font("Arial",16));
        label92.setTextFill(Color.BLACK);

        Label label93 = new Label("Står ved");
        label93.setTranslateX(0);
        label93.setTranslateY(150);
        label93.setFont(new Font("Arial",16));
        label93.setTextFill(Color.BLACK);

        Label label94 = new Label("Antal liter");
        label94.setTranslateX(0);
        label94.setTranslateY(150);
        label94.setFont(new Font("Arial",16));
        label94.setTextFill(Color.BLACK);

        TextField textField46 = new TextField();
        textField46.setMaxWidth(100);
        Tooltip tooltip99 = new Tooltip();
        tooltip99.setText("Indtast nummeret på tanken her");
        textField46.setTooltip(tooltip99);
        textField46.setCursor(Cursor.TEXT);

        TextField textField47 = new TextField();
        textField47.setMaxWidth(100);
        Tooltip tooltip100 = new Tooltip();
        tooltip100.setText("Indtast antal gange tanken har været brugt her");
        textField47.setTooltip(tooltip100);
        textField47.setCursor(Cursor.TEXT);

        TextField textField48 = new TextField();
        textField48.setMaxWidth(100);
        Tooltip tooltip101 = new Tooltip();
        tooltip101.setText("Indtast datoen for hvornår tanken sidst har været tømt her");
        textField48.setTooltip(tooltip101);
        textField48.setCursor(Cursor.TEXT);

        TextField textField49 = new TextField();
        textField49.setMaxWidth(100);
        Tooltip tooltip102 = new Tooltip();
        tooltip102.setText("Indtast datoen for hvornår tanken er blevet fyldt her");
        textField49.setTooltip(tooltip102);
        textField49.setCursor(Cursor.TEXT);

        TextField textField50 = new TextField();
        textField50.setMaxWidth(100);
        Tooltip tooltip103 = new Tooltip();
        tooltip103.setText("Indtast navnet på eventuel køber 1 her");
        textField50.setTooltip(tooltip103);
        textField50.setCursor(Cursor.TEXT);

        TextField textField51 = new TextField();
        textField51.setMaxWidth(100);
        Tooltip tooltip104 = new Tooltip();
        tooltip104.setText("Indtast navnet på eventuel køber 2 her");
        textField51.setTooltip(tooltip104);
        textField51.setCursor(Cursor.TEXT);

        TextField textField52 = new TextField();
        textField52.setMaxWidth(100);
        Tooltip tooltip105 = new Tooltip();
        tooltip105.setText("Indtast navnet på eventuel køber 3 her");
        textField52.setTooltip(tooltip105);
        textField52.setCursor(Cursor.TEXT);

        TextField textField53 = new TextField();
        textField53.setMaxWidth(100);
        Tooltip tooltip106 = new Tooltip();
        tooltip106.setText("Indtast navnet på eventuel køber 4 her");
        textField53.setTooltip(tooltip106);
        textField53.setCursor(Cursor.TEXT);

        TextField textField54 = new TextField();
        textField54.setMaxWidth(100);
        Tooltip tooltip107 = new Tooltip();
        tooltip107.setText("Indtast navnet på eventuel køber 5 her");
        textField54.setTooltip(tooltip107);
        textField54.setCursor(Cursor.TEXT);

        TextField textField55 = new TextField();
        textField55.setMaxWidth(100);
        Tooltip tooltip108 = new Tooltip();
        tooltip108.setText("Indtast hvor tanken står her");
        textField55.setTooltip(tooltip108);
        textField55.setCursor(Cursor.TEXT);

        TextField textField56 = new TextField();
        textField56.setMaxWidth(100);
        Tooltip tooltip109 = new Tooltip();
        tooltip109.setText("Indtast antal liter her");
        textField56.setTooltip(tooltip109);
        textField56.setCursor(Cursor.TEXT);

        CheckBox checkBox7 = new CheckBox();
        checkBox7.setText("Intakt");

        CheckBox checkBox8 = new CheckBox();
        checkBox8.setText("Tanken kan anvendes igen");

        CheckBox checkBox9 = new CheckBox();
        checkBox9.setText("Solgt");

        ImageView imageView14 = XIcon.PLASTIKTANK.getImageView();
        imageView14.setFitHeight(100);
        imageView14.setFitWidth(100);
        imageView14.setTranslateX(10);
        imageView14.setTranslateY(-10);
        getLayout().getChildren().add(imageView14);

        Button button54 = new Button("Opret plastictank");
        button54.setTranslateX(-150);
        button54.setTranslateY(-280);
        button54.setPrefSize(250,45);
        button54.setOnAction(e -> getGUI().switchScene(this));
        button54.setFont(new Font("Arial",16));
        button54.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button54.setCursor(Cursor.HAND);
        Tooltip tooltip110 = new Tooltip("Tryk her for at oprette plastictanken");
        button54.setTooltip(tooltip110);

        Button button55 = new Button("Annuller");
        button55.setTranslateX(-150);
        button55.setTranslateY(-280);
        button55.setPrefSize(250,45);
        button55.setOnAction(e -> getGUI().switchScene(this));
        button55.setFont(new Font("Arial",16));
        button55.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button55.setCursor(Cursor.HAND);
        Tooltip tooltip111 = new Tooltip("Tryk her for at annullere");
        button55.setTooltip(tooltip111);

        Button button56 = new Button("Gå tilbage til forsiden");
        button56.setTranslateX(-150);
        button56.setTranslateY(-280);
        button56.setPrefSize(250,45);
        button56.setOnAction(e -> getGUI().gåTilForside());
        button56.setFont(new Font("Calibri",12));
        button56.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button56.setCursor(Cursor.HAND);
        Tooltip tooltip112 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button56.setTooltip(tooltip112);

        getLayout().getChildren().addAll(label83, label84, label85, label86, label87, label88, label89, label90, label91, label92, label93, label94, textField46, textField47, textField48, textField49, textField50, textField51, textField52, textField53, textField54, textField55, textField56, checkBox7, checkBox8, checkBox9, button54, button55, button56);
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
