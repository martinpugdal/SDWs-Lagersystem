package gui.scene;

import gui.GUI;
import gui.scene.scenes.*;
import gui.scene.scenes.destillering.*;
import gui.scene.scenes.fad.OpretFadScene;
import gui.scene.scenes.fad.RedigerFadScene;
import gui.scene.scenes.ginflaske.OpretGinflaskeScene;
import gui.scene.scenes.ginflaske.RedigerGinflaskeScene;
import gui.scene.scenes.lager.OpretLagerScene;
import gui.scene.scenes.lager.RedigerLagerScene;
import gui.scene.scenes.plastictank.OpretPlastictankScene;
import gui.scene.scenes.plastictank.RedigerPlastictankScene;
import gui.scene.scenes.råvare.OpretRåvareScene;
import gui.scene.scenes.råvare.RedigerRåvareScene;
import gui.scene.scenes.whiskyflaske.OpretWhiskyflaskeScene;
import gui.scene.scenes.whiskyflaske.RedigerWhiskyflaskeScene;
import gui.setting.XScene;
import javafx.scene.control.Alert;

public class SceneManager {

    // forside
    private final XScene forsideScene;
    // lager
    private final XScene lagerScene;
    private final XScene opretLagerScene;
    private final XScene redigerLagerScene;
    // destillering
    private final XScene destilleringScene;
    private final XScene opretDestilleringScene;
    private final XScene redigerDestilleringScene;
    private final XScene destilleringFadScene;
    private final XScene destilleringTankScene;
    // fad
    private final XScene fadScene;
    private final XScene opretFadScene;
    private final XScene redigerFadScene;
    // ginflaske
    private final XScene ginflaskeScene;
    private final XScene opretGinflaskeScene;
    private final XScene redigerGinflaskeScene;
    // whiskyflaske
    private final XScene whiskyflaskeScene;
    private final XScene opretWhiskyflaskeScene;
    private final XScene redigerWhiskyflaskeScene;
    // råvare
    private final XScene råvareScene;
    private final XScene opretRåvareScene;
    private final XScene redigerRåvareScene;
    // plastictank
    private final XScene plastictankScene;
    private final XScene opretPlastictankScene;
    private final XScene redigerPlastictankScene;

    public SceneManager(GUI gui) {
        // forside
        forsideScene = new ForsideScene(gui);
        // lager
        lagerScene = new LagerScene(gui);
        opretLagerScene = new OpretLagerScene(gui);
        redigerLagerScene = new RedigerLagerScene(gui);
        // destillering
        destilleringScene = new DestilleringScene(gui);
        opretDestilleringScene = new OpretDestilleringScene(gui);
        redigerDestilleringScene = new RedigerDestilleringScene(gui);
        destilleringFadScene = new DestilleringFadScene(gui);
        destilleringTankScene = new DestilleringTankScene(gui);
        // fad
        fadScene = new FadScene(gui);
        opretFadScene = new OpretFadScene(gui);
        redigerFadScene = new RedigerFadScene(gui);
        // ginflaske
        ginflaskeScene = new GinflaskeScene(gui);
        opretGinflaskeScene = new OpretGinflaskeScene(gui);
        redigerGinflaskeScene = new RedigerGinflaskeScene(gui);
        // whiskyflaske
        whiskyflaskeScene = new WhiskyflaskeScene(gui);
        opretWhiskyflaskeScene = new OpretWhiskyflaskeScene(gui);
        redigerWhiskyflaskeScene = new RedigerWhiskyflaskeScene(gui);
        // råvare
        råvareScene = new RåvareScene(gui);
        opretRåvareScene = new OpretRåvareScene(gui);
        redigerRåvareScene = new RedigerRåvareScene(gui);
        // plastictank
        plastictankScene = new PlastictankScene(gui);
        opretPlastictankScene = new OpretPlastictankScene(gui);
        redigerPlastictankScene = new RedigerPlastictankScene(gui);
    }

    public XScene getScene(SceneType sceneType) {
        return switch (sceneType) {
            // forside
            default -> forsideScene;
            // lager
            case LAGER -> lagerScene;
            case OPRETLAGER -> opretLagerScene;
            case REDIGERLAGER -> redigerLagerScene;
            // destillering
            case DESTILLERING -> destilleringScene;
            case OPRETDESTILLERING -> opretDestilleringScene;
            case REDIGERDESTILLERING -> redigerDestilleringScene;
            case DESTILLERINGFAD -> destilleringFadScene;
            case DESTILLERINGTANK -> destilleringTankScene;
            // fad
            case FAD -> fadScene;
            case OPRETFAD -> opretFadScene;
            case REDIGERFAD -> redigerFadScene;
            // ginflaske
            case GINFLASKE -> ginflaskeScene;
            case OPRETGINFLASKE -> opretGinflaskeScene;
            case REDIGERGINFLASKE -> redigerGinflaskeScene;
            // whiskyflaske
            case WHISKYFLASKE -> whiskyflaskeScene;
            case OPRETWHISKYFLASKE -> opretWhiskyflaskeScene;
            case REDIGERWHISKYFLASKE -> redigerWhiskyflaskeScene;
            // råvare
            case RÅVARE -> råvareScene;
            case OPRETRÅVARE -> opretRåvareScene;
            case REDIGERRÅVARE -> redigerRåvareScene;
            // plastictank
            case PLASTICTANK -> plastictankScene;
            case OPRETPLASTICTANK -> opretPlastictankScene;
            case REDIGERPLASTICTANK -> redigerPlastictankScene;
        };
    }

    public Alert alert(String title, String headerText, String contentText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        return alert;
    }
}
