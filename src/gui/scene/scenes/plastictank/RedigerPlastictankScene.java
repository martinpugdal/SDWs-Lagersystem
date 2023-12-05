package gui.scene.scenes.plastictank;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RedigerPlastictankScene extends XScene {
    public RedigerPlastictankScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 16: Rediger plastictank

        Label label95 = new Label("Rediger plastictank");
        label95.setTranslateX(0);
        label95.setTranslateY(150);
        label95.setFont(new Font("Arial",16));
        label95.setTextFill(Color.BLACK);

        Label label96 = new Label("Nummer");
        label96.setTranslateX(0);
        label96.setTranslateY(150);
        label96.setFont(new Font("Arial",16));
        label96.setTextFill(Color.BLACK);

        Label label97 = new Label("Antal gange brugt");
        label97.setTranslateX(0);
        label97.setTranslateY(150);
        label97.setFont(new Font("Arial",16));
        label97.setTextFill(Color.BLACK);

        Label label98 = new Label("Seneste tømningsdato");
        label98.setTranslateX(0);
        label98.setTranslateY(150);
        label98.setFont(new Font("Arial",16));
        label98.setTextFill(Color.BLACK);

        Label label99 = new Label("Påfyldningsdato");
        label99.setTranslateX(0);
        label99.setTranslateY(150);
        label99.setFont(new Font("Arial",16));
        label99.setTextFill(Color.BLACK);

        Label label100 = new Label("Solgt til 1");
        label100.setTranslateX(0);
        label100.setTranslateY(150);
        label100.setFont(new Font("Arial",16));
        label100.setTextFill(Color.BLACK);

        Label label101 = new Label("Solgt til 2");
        label101.setTranslateX(0);
        label101.setTranslateY(150);
        label101.setFont(new Font("Arial",16));
        label101.setTextFill(Color.BLACK);

        Label label102 = new Label("Solgt til 3");
        label102.setTranslateX(0);
        label102.setTranslateY(150);
        label102.setFont(new Font("Arial",16));
        label102.setTextFill(Color.BLACK);

        Label label103 = new Label("Solgt til 4");
        label103.setTranslateX(0);
        label103.setTranslateY(150);
        label103.setFont(new Font("Arial",16));
        label103.setTextFill(Color.BLACK);

        Label label104 = new Label("Solgt til 5");
        label104.setTranslateX(0);
        label104.setTranslateY(150);
        label104.setFont(new Font("Arial",16));
        label104.setTextFill(Color.BLACK);

        Label label105 = new Label("Står ved");
        label105.setTranslateX(0);
        label105.setTranslateY(150);
        label105.setFont(new Font("Arial",16));
        label105.setTextFill(Color.BLACK);

        Label label106 = new Label("Antal liter");
        label106.setTranslateX(0);
        label106.setTranslateY(150);
        label106.setFont(new Font("Arial",16));
        label106.setTextFill(Color.BLACK);

        TextField textField57 = new TextField();
        textField57.setMaxWidth(100);
        Tooltip tooltip113 = new Tooltip();
        tooltip113.setText("Indtast nummeret på tanken her");
        textField57.setTooltip(tooltip113);
        textField57.setCursor(Cursor.TEXT);

        TextField textField58 = new TextField();
        textField58.setMaxWidth(100);
        Tooltip tooltip114 = new Tooltip();
        tooltip114.setText("Indtast antal gange tanken har været brugt her");
        textField58.setTooltip(tooltip114);
        textField58.setCursor(Cursor.TEXT);

        TextField textField59 = new TextField();
        textField59.setMaxWidth(100);
        Tooltip tooltip115 = new Tooltip();
        tooltip115.setText("Indtast datoen for hvornår tanken sidst har været tømt her");
        textField59.setTooltip(tooltip115);
        textField59.setCursor(Cursor.TEXT);

        TextField textField60 = new TextField();
        textField60.setMaxWidth(100);
        Tooltip tooltip116 = new Tooltip();
        tooltip116.setText("Indtast datoen for hvornår tanken er blevet fyldt her");
        textField60.setTooltip(tooltip116);
        textField60.setCursor(Cursor.TEXT);

        TextField textField61 = new TextField();
        textField61.setMaxWidth(100);
        Tooltip tooltip117 = new Tooltip();
        tooltip117.setText("Indtast navnet på eventuel køber 1 her");
        textField61.setTooltip(tooltip117);
        textField61.setCursor(Cursor.TEXT);

        TextField textField62 = new TextField();
        textField62.setMaxWidth(100);
        Tooltip tooltip118 = new Tooltip();
        tooltip118.setText("Indtast navnet på eventuel køber 2 her");
        textField62.setTooltip(tooltip118);
        textField62.setCursor(Cursor.TEXT);

        TextField textField63 = new TextField();
        textField63.setMaxWidth(100);
        Tooltip tooltip119 = new Tooltip();
        tooltip119.setText("Indtast navnet på eventuel køber 3 her");
        textField63.setTooltip(tooltip119);
        textField63.setCursor(Cursor.TEXT);

        TextField textField64 = new TextField();
        textField64.setMaxWidth(100);
        Tooltip tooltip120 = new Tooltip();
        tooltip120.setText("Indtast navnet på eventuel køber 4 her");
        textField64.setTooltip(tooltip120);
        textField64.setCursor(Cursor.TEXT);

        TextField textField65 = new TextField();
        textField65.setMaxWidth(100);
        Tooltip tooltip121 = new Tooltip();
        tooltip121.setText("Indtast navnet på eventuel køber 5 her");
        textField65.setTooltip(tooltip121);
        textField65.setCursor(Cursor.TEXT);

        TextField textField66 = new TextField();
        textField66.setMaxWidth(100);
        Tooltip tooltip122 = new Tooltip();
        tooltip122.setText("Indtast hvor tanken står her");
        textField66.setTooltip(tooltip122);
        textField66.setCursor(Cursor.TEXT);

        TextField textField67 = new TextField();
        textField67.setMaxWidth(100);
        Tooltip tooltip123 = new Tooltip();
        tooltip123.setText("Indtast antal liter her");
        textField67.setTooltip(tooltip123);
        textField67.setCursor(Cursor.TEXT);

        CheckBox checkBox10 = new CheckBox();
        checkBox10.setText("Intakt");

        CheckBox checkBox11 = new CheckBox();
        checkBox11.setText("Tanken kan anvendes igen");

        CheckBox checkBox12 = new CheckBox();
        checkBox12.setText("Solgt");

        ImageView imageView15 = XIcon.PLASTIKTANK.getImageView();
        imageView15.setFitHeight(100);
        imageView15.setFitWidth(100);
        imageView15.setTranslateX(10);
        imageView15.setTranslateY(-10);
        getLayout().getChildren().add(imageView15);

        Button button57 = new Button("Rediger plastictank");
        button57.setTranslateX(-150);
        button57.setTranslateY(-280);
        button57.setPrefSize(250,45);
        button57.setOnAction(e -> getGUI().switchScene(this));
        button57.setFont(new Font("Arial",16));
        button57.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button57.setCursor(Cursor.HAND);
        Tooltip tooltip124 = new Tooltip("Tryk her for at flytte destilleringsvæsken");
        button57.setTooltip(tooltip124);

        Button button58 = new Button("Annuller");
        button58.setTranslateX(-150);
        button58.setTranslateY(-280);
        button58.setPrefSize(250,45);
        button58.setOnAction(e -> getGUI().switchScene(this));
        button58.setFont(new Font("Arial",16));
        button58.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button58.setCursor(Cursor.HAND);
        Tooltip tooltip125 = new Tooltip("Tryk her for at annullere");
        button58.setTooltip(tooltip125);

        Button button59 = new Button("Gå tilbage til forside");
        button59.setTranslateX(-150);
        button59.setTranslateY(-280);
        button59.setPrefSize(250,45);
        button59.setOnAction(e -> getGUI().gåTilForside());
        button59.setFont(new Font("Arial",16));
        button59.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button59.setCursor(Cursor.HAND);
        Tooltip tooltip126 = new Tooltip("Tryk her for at flytte destilleringsvæsken");
        button59.setTooltip(tooltip126);

        getLayout().getChildren().addAll(label95, label96, label97, label98, label99, label100, label101, label102, label103, label104, label105, label106, textField57, textField58, textField59, textField60, textField61, textField62, textField63, textField64, textField65, textField66, textField67, checkBox10, checkBox11, checkBox12, button57, button58, button59);
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
