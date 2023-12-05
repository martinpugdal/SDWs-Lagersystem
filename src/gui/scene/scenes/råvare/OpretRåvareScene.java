package gui.scene.scenes.råvare;

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


public class OpretRåvareScene extends XScene {

    public OpretRåvareScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 9: Opret råvare

        Label label41 = new Label("Opret råvare");
        label41.setTranslateX(0);
        label41.setTranslateY(150);
        label41.setFont(new Font("Arial",36));
        label41.setTextFill(Color.BLACK);

        Label label42 = new Label("Navn");
        label42.setTranslateX(0);
        label42.setTranslateY(150);
        label42.setFont(new Font("Arial",16));
        label42.setTextFill(Color.BLACK);

        Label label43 = new Label("Antal");
        label43.setTranslateX(0);
        label43.setTranslateY(150);
        label43.setFont(new Font("Arial",16));
        label43.setTextFill(Color.BLACK);

        Label label44 = new Label("Liter");
        label44.setTranslateX(0);
        label44.setTranslateY(150);
        label44.setFont(new Font("Arial",16));
        label44.setTextFill(Color.BLACK);

        Label label45 = new Label("Kilogram");
        label45.setTranslateX(0);
        label45.setTranslateY(150);
        label45.setFont(new Font("Arial",16));
        label45.setTextFill(Color.BLACK);

        Label label46 = new Label("Bruges til");
        label46.setTranslateX(0);
        label46.setTranslateY(150);
        label46.setFont(new Font("Arial",16));
        label46.setTextFill(Color.BLACK);

        TextField textField12 = new TextField();
        textField12.setMaxWidth(100);
        Tooltip tooltip45 = new Tooltip();
        tooltip45.setText("Indtast navn på råvare her");
        textField12.setTooltip(tooltip45);
        textField12.setCursor(Cursor.TEXT);

        TextField textField13 = new TextField();
        textField13.setMaxWidth(100);
        Tooltip tooltip46 = new Tooltip();
        tooltip46.setText("Indtast antallet af råvare her");
        textField13.setTooltip(tooltip46);
        textField13.setCursor(Cursor.TEXT);

        TextField textField14 = new TextField();
        textField14.setMaxWidth(100);
        Tooltip tooltip47 = new Tooltip();
        tooltip47.setText("Indtast antal liter her");
        textField14.setTooltip(tooltip47);
        textField14.setCursor(Cursor.TEXT);

        TextField textField15 = new TextField();
        textField15.setMaxWidth(100);
        Tooltip tooltip48 = new Tooltip();
        tooltip48.setText("Indtast antal kilo her");
        textField15.setTooltip(tooltip48);
        textField15.setCursor(Cursor.TEXT);

        TextField textField16 = new TextField();
        textField16.setMaxWidth(100);
        Tooltip tooltip49 = new Tooltip();
        tooltip49.setText("Indtast hvilke produkter råvaren bruges til her");
        textField16.setTooltip(tooltip49);
        textField16.setCursor(Cursor.TEXT);

        ImageView imageView8 = XIcon.KORIANDERFRØ.getImageView();
        imageView8.setFitHeight(100);
        imageView8.setFitWidth(100);
        imageView8.setTranslateX(10);
        imageView8.setTranslateY(-10);
        getLayout().getChildren().add(imageView8);

        Button button34 = new Button("Opret råvare");
        button34.setTranslateX(-150);
        button34.setTranslateY(-280);
        button34.setPrefSize(250,45);
        button34.setOnAction(e -> getGUI().switchScene(this));
        button34.setFont(new Font("Arial",16));
        button34.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button34.setCursor(Cursor.HAND);
        Tooltip tooltip50 = new Tooltip("Tryk her for at oprette råvaren");
        button34.setTooltip(tooltip50);

        Button button35 = new Button("Tilbage til råvare oversigten");
        button35.setTranslateX(-150);
        button35.setTranslateY(-280);
        button35.setPrefSize(250,45);
        button35.setOnAction(e -> getGUI().switchScene(this));
        button35.setFont(new Font("Arial",16));
        button35.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button35.setCursor(Cursor.HAND);
        Tooltip tooltip51 = new Tooltip("Tryk her for at annullere og vende tilbage til oversigten");
        button35.setTooltip(tooltip51);

        Button button36 = new Button("Gå tilbage til forside");
        button36.setTranslateX(-150);
        button36.setTranslateY(-280);
        button36.setPrefSize(100,100);
        button36.setOnAction(e -> getGUI().gåTilForside());
        button36.setFont(new Font("Arial",16));
        button36.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button36.setCursor(Cursor.HAND);
        Tooltip tooltip52 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button36.setTooltip(tooltip52);

        getLayout().getChildren().addAll(label41, label42, label43, label44, label45, label46, textField12, textField13, textField14, textField15, textField16, button34, button35, button36);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public XIcon getIcon() {
        return XIcon.KORIANDERFRØ;
    }
}
