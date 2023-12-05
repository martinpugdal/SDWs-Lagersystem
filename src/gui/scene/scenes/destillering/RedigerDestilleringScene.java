package gui.scene.scenes.destillering;

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

public class RedigerDestilleringScene extends XScene {
    public RedigerDestilleringScene(GUI gui) {
        super(gui);
    }

    @Override
    public void initLayout() {
        //Skærmbillede 4: Rediger destillering

        Label label17 = new Label("Rediger destillering");
        label17.setTranslateX(0);
        label17.setTranslateY(150);
        label17.setFont(new Font("Arial", 36));
        label17.setTextFill(Color.BLACK);

        Label label18 = new Label("Her kan destilleringsvæsken opdateres/ændres");
        label18.setTranslateX(0);
        label18.setTranslateY(150);
        label18.setFont(new Font("Arial", 16));
        label18.setTextFill(Color.BLACK);

        Label label19 = new Label("Nummer");
        label19.setTranslateX(0);
        label19.setTranslateY(150);
        label19.setFont(new Font("Arial", 16));
        label19.setTextFill(Color.BLACK);

        Label label20 = new Label("Navn");
        label20.setTranslateX(0);
        label20.setTranslateY(150);
        label20.setFont(new Font("Arial", 16));
        label20.setTextFill(Color.BLACK);

        Label label21 = new Label("Antal liter");
        label21.setTranslateX(0);
        label21.setTranslateY(150);
        label21.setFont(new Font("Arial", 16));
        label21.setTextFill(Color.BLACK);

        Label label22 = new Label("Alkoholprocent");
        label22.setTranslateX(0);
        label22.setTranslateY(150);
        label22.setFont(new Font("Arial", 16));
        label22.setTextFill(Color.BLACK);

        TextField textField5 = new TextField();
        textField5.setMaxWidth(100);
        Tooltip tooltip22 = new Tooltip();
        tooltip22.setText("Indtast nummer på destilleringsvæsken her");
        textField5.setTooltip(tooltip22);
        textField5.setCursor(Cursor.TEXT);

        TextField textField6 = new TextField();
        textField6.setMaxWidth(100);
        Tooltip tooltip23 = new Tooltip();
        tooltip23.setText("Indtast navnet på destilleringsvæsken her");
        textField6.setTooltip(tooltip23);
        textField6.setCursor(Cursor.TEXT);

        TextField textField7 = new TextField();
        textField7.setMaxWidth(100);
        Tooltip tooltip24 = new Tooltip();
        tooltip24.setText("Indtast antallet af liter her");
        textField7.setTooltip(tooltip24);
        textField7.setCursor(Cursor.TEXT);

        TextField textField8 = new TextField();
        textField8.setMaxWidth(100);
        Tooltip tooltip25 = new Tooltip();
        tooltip25.setText("Indtast alkoholprocenten her");
        textField8.setTooltip(tooltip25);
        textField8.setCursor(Cursor.TEXT);

        ImageView imageView3 = XIcon.ALKOHOL.getImageView();
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(100);
        imageView3.setTranslateX(10);
        imageView3.setTranslateY(-10);
        getLayout().getChildren().add(imageView3);

        Button button18 = new Button("Rediger destillering");
        button18.setTranslateX(-150);
        button18.setTranslateY(-280);
        button18.setPrefSize(250, 45);
        button18.setOnAction(e -> getGUI().switchScene(this));
        button18.setFont(new Font("Arial", 16));
        button18.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button18.setCursor(Cursor.HAND);
        Tooltip tooltip26 = new Tooltip("Tryk her for at opdatere destilleringsvæsken");
        button18.setTooltip(tooltip26);

        Button button19 = new Button("Annuller");
        button19.setTranslateX(-150);
        button19.setTranslateY(-280);
        button19.setPrefSize(250, 45);
        button19.setOnAction(e -> getGUI().switchScene(this));
        button19.setFont(new Font("Arial", 16));
        button19.setCursor(Cursor.HAND);
        Tooltip tooltip27 = new Tooltip("Tryk her for at annullere");
        button19.setTooltip(tooltip27);

        Button button20 = new Button("Gå tilbage til forside");
        button20.setTranslateX(-150);
        button20.setTranslateY(-280);
        button20.setPrefSize(250, 45);
        button20.setOnAction(e -> getGUI().gåTilForside());
        button20.setFont(new Font("Arial", 16));
        button20.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        button20.setCursor(Cursor.HAND);
        Tooltip tooltip28 = new Tooltip("Tryk her for at gå tilbage til forsiden");
        button20.setTooltip(tooltip28);

        getLayout().getChildren().addAll(label17, label18, label19, label20, label21, label22, textField5, textField6, textField7, textField8, button18, button19, button20);
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
