package gui.scene;

import gui.GUI;
import gui.scene.scenes.*;
import gui.scene.scenes.afdeling.OpretAfdelingScene;
import gui.scene.scenes.afdeling.RedigerAfdelingScene;
import gui.scene.scenes.destillering.DestilleringOmhældningScene;
import gui.scene.scenes.destillering.DestilleringOverførScene;
import gui.scene.scenes.destillering.OpretDestilleringScene;
import gui.scene.scenes.destillering.RedigerDestilleringScene;
import gui.scene.scenes.fad.OpretFadScene;
import gui.scene.scenes.fad.PåfyldningerFadScene;
import gui.scene.scenes.fad.RedigerFadScene;
import gui.scene.scenes.ginflaske.OpretGinflaskeScene;
import gui.scene.scenes.ginflaske.RedigerGinflaskeScene;
import gui.scene.scenes.lager.OpretLagerScene;
import gui.scene.scenes.lager.RedigerLagerScene;
import gui.scene.scenes.plastictank.OpretPlastictankScene;
import gui.scene.scenes.plastictank.PåfyldningerPlastictankScene;
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
    // afdeling
    private final XScene afdelingScene;
    private final XScene opretAfdelingScene;
    private final XScene redigerAfdelingScene;
    // destillering
    private final XScene destilleringScene;
    private final XScene opretDestilleringScene;
    private final XScene redigerDestilleringScene;
    private final XScene omhældningDestilleringScene;
    private final XScene overførDestilleringScene;
    // fad
    private final XScene fadScene;
    private final XScene opretFadScene;
    private final XScene redigerFadScene;
    private final XScene påfyldningFadScene;
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
    private final XScene påfyldningPlastictankScene;

    public SceneManager(GUI gui) {
        // forside
        forsideScene = new ForsideScene(gui);
        // lager
        lagerScene = new LagerScene(gui);
        opretLagerScene = new OpretLagerScene(gui);
        redigerLagerScene = new RedigerLagerScene(gui);
        // afdeling
        afdelingScene = new AfdelingScene(gui);
        opretAfdelingScene = new OpretAfdelingScene(gui);
        redigerAfdelingScene = new RedigerAfdelingScene(gui);
        // destillering
        destilleringScene = new DestilleringScene(gui);
        opretDestilleringScene = new OpretDestilleringScene(gui);
        redigerDestilleringScene = new RedigerDestilleringScene(gui);
        omhældningDestilleringScene = new DestilleringOmhældningScene(gui);
        overførDestilleringScene = new DestilleringOverførScene(gui);
        // fad
        fadScene = new FadScene(gui);
        opretFadScene = new OpretFadScene(gui);
        redigerFadScene = new RedigerFadScene(gui);
        påfyldningFadScene = new PåfyldningerFadScene(gui);
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
        påfyldningPlastictankScene = new PåfyldningerPlastictankScene(gui);
    }

    public XScene getScene(SceneType sceneType) {
        return switch (sceneType) {
            // forside
            default -> forsideScene;
            // lager
            case LAGER -> lagerScene;
            case OPRETLAGER -> opretLagerScene;
            case REDIGERLAGER -> redigerLagerScene;
            // afdeling
            case AFDELING -> afdelingScene;
            case OPRETAFDELING -> opretAfdelingScene;
            case REDIGERAFDELING -> redigerAfdelingScene;
            // destillering
            case DESTILLERING -> destilleringScene;
            case OPRETDESTILLERING -> opretDestilleringScene;
            case REDIGERDESTILLERING -> redigerDestilleringScene;
            case DESTILLERINGOMHÆLDNING -> omhældningDestilleringScene;
            case DESTILLERINGOVERFØR -> overførDestilleringScene;
            // fad
            case FAD -> fadScene;
            case OPRETFAD -> opretFadScene;
            case REDIGERFAD -> redigerFadScene;
            case PÅFYLDNINGFAD -> påfyldningFadScene;
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
            case PÅFYLDNINGPLASTICTANK -> påfyldningPlastictankScene;
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
