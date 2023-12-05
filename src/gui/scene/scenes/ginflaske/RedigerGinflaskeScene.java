package gui.scene.scenes.ginflaske;

import gui.GUI;
import gui.setting.XIcon;
import gui.setting.XScene;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RedigerGinflaskeScene extends XScene {
    public RedigerGinflaskeScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 25: Rediger ginflaske

        Label label140 = new Label("Rediger ginflaske");
        label140.setTranslateX(0);
        label140.setTranslateY(150);
        label140.setFont(new Font("Arial",36));
        label140.setTextFill(Color.BLACK);

        Label label141 = new Label("Nummer");
        label141.setTranslateX(0);
        label141.setTranslateY(150);
        label141.setFont(new Font("Arial",16));
        label141.setTextFill(Color.BLACK);

        Label label142 = new Label("Navn");
        label142.setTranslateX(0);
        label142.setTranslateY(150);
        label142.setFont(new Font("Arial",16));
        label142.setTextFill(Color.BLACK);

        Label label143 = new Label("Volumen");
        label143.setTranslateX(0);
        label143.setTranslateY(150);
        label143.setFont(new Font("Arial",16));
        label143.setTextFill(Color.BLACK);

        Label label144 = new Label("Antal");
        label144.setTranslateX(0);
        label144.setTranslateY(150);
        label144.setFont(new Font("Arial",16));
        label144.setTextFill(Color.BLACK);

        TextField textField90 = new TextField();
        textField90.setMaxWidth(100);
        Tooltip tooltip176 = new Tooltip();
        tooltip176.setText("Indtast nummeret på ginflasken her");
        textField90.setTooltip(tooltip176);
        textField90.setCursor(Cursor.TEXT);

        TextField textField91 = new TextField();
        textField91.setMaxWidth(100);
        Tooltip tooltip177 = new Tooltip();
        tooltip177.setText("Indtast navnet på ginflasken her");
        textField91.setTooltip(tooltip177);
        textField91.setCursor(Cursor.TEXT);

        TextField textField92 = new TextField();
        textField92.setMaxWidth(100);
        Tooltip tooltip178 = new Tooltip();
        tooltip178.setText("Indtast antal liter her");
        textField92.setTooltip(tooltip178);
        textField92.setCursor(Cursor.TEXT);

        TextField textField93 = new TextField();
        textField93.setMaxWidth(100);
        Tooltip tooltip179 = new Tooltip();
        tooltip179.setText("Indtast antal ginflasker her");
        textField93.setTooltip(tooltip179);
        textField93.setCursor(Cursor.TEXT);

        ImageView imageView24 = XIcon.GINFLASKE.getImageView();
        imageView24.setFitHeight(100);
        imageView24.setFitWidth(100);
        imageView24.setTranslateX(10);
        imageView24.setTranslateY(-10);
        getLayout().getChildren().add(imageView24);

        Button button87 = new Button("Rediger ginflaske");
        button87.setTranslateX(-150);
        button87.setTranslateY(-280);
        button87.setPrefSize(250,45);
        button87.setOnAction(e -> getGUI().switchScene(this));
        button87.setFont(new Font("Arial",16));
        button87.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button87.setCursor(Cursor.HAND);
        Tooltip tooltip180 = new Tooltip("Tryk her for at redigere");
        button87.setTooltip(tooltip180);

        Button button88 = new Button("Annuller");
        button88.setTranslateX(-150);
        button88.setTranslateY(-280);
        button88.setPrefSize(250,45);
        button88.setOnAction(e -> getGUI().switchScene(this));
        button88.setFont(new Font("Arial",16));
        button88.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button88.setCursor(Cursor.HAND);
        Tooltip tooltip181 = new Tooltip("Tryk her for at annullere");
        button88.setTooltip(tooltip181);

        Button button89 = new Button("Gå tilbage til forside");
        button89.setTranslateX(-150);
        button89.setTranslateY(-280);
        button89.setPrefSize(250,45);
        button89.setOnAction(e -> getGUI().switchScene(this));
        button89.setFont(new Font("Arial",16));
        button89.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button89.setCursor(Cursor.HAND);
        Tooltip tooltip182 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button89.setTooltip(tooltip182);

        getLayout().getChildren().addAll(label140, label141, label142, label143, label144, textField90, textField91, textField92, textField93, button87, button88, button89);
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
