package oberflache;

import datenhaltung.Datensatz;
import fachkonzept.Methoden;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@SuppressWarnings("ALL")
public class GUI_Controller {

    private Methoden methoden = new Methoden();

    @FXML
    private Button abbrechenButton;

    @FXML
    private Button endeButton;

    @FXML
    private TextField hausNummerFeld;

    @FXML
    private Button loschenButton;

    @FXML
    private TextField nachNameFeld;

    @FXML
    private TextField nameFeld;

    @FXML
    private Button neuButton;

    @FXML
    private TextField ortFeld;

    @FXML
    private TextField plzFeld;

    @FXML
    private Button rechtsButton;

    @FXML
    private Button speichernButton;

    @FXML
    private Button startButton;

    @FXML
    private TextField strasseFeld;

    @FXML
    private TextField telefonNummerFeld;

    @FXML
    private TextField vorwahlFeld;

    @FXML
    private Button zuruckButton;

    @FXML
    void abbrechenKlick(ActionEvent event) {
        einschaltenButtons(false);
    }

    @FXML
    void backClick(ActionEvent event) {
        anzeigenDaten(methoden.links());
    }

    @FXML
    void dateiLadenKlick(ActionEvent event) {

    }

    @FXML
    void dateiSpeichernKlick(ActionEvent event) {

    }

    @FXML
    void endeKlick(ActionEvent event) {
        anzeigenDaten(methoden.letztesElement());
    }

    @FXML
    void googleKlick(ActionEvent event) {

    }

    @FXML
    void loschenKlick(ActionEvent event) {
        methoden.delete();
        anzeigenDaten(methoden.letztesElement());
    }

    @FXML
    void neuKlick(ActionEvent event) {
        einschaltenButtons(true);
        anzeigenDaten(new Datensatz());
    }

    @FXML
    void rechtsKlick(ActionEvent event) {
        anzeigenDaten(methoden.rechts());
    }

    @FXML
    void schliessenKlick(ActionEvent event) {

    }

    @FXML
    void speichernKlick(ActionEvent event) {
        einschaltenButtons(false);
        Datensatz datensatz = lesenDaten();
        methoden.insert(datensatz);
    }

    @FXML
    void startKlick(ActionEvent event) {
        anzeigenDaten(methoden.erstesElement());
    }

    @FXML
    void uberKlick(ActionEvent event) {

    }

    private void einschaltenButtons(boolean status) {
        neuButton.setDisable(status);
        loschenButton.setDisable(status);
        rechtsButton.setDisable(status);
        zuruckButton.setDisable(status);
        endeButton.setDisable(status);
        startButton.setDisable(status);
        speichernButton.setDisable(!status);
        abbrechenButton.setDisable(!status);
    }

    private void anzeigenDaten(Datensatz datensatz) {
        nachNameFeld.setText(datensatz.getName());
        ortFeld.setText(datensatz.getOrt());
        nameFeld.setText(datensatz.getVorname());
        plzFeld.setText(datensatz.getPLZ());
        strasseFeld.setText(datensatz.getStrasse());
        hausNummerFeld.setText(datensatz.getHausNummer());
        telefonNummerFeld.setText(datensatz.getTelNummer());
        vorwahlFeld.setText(datensatz.getVorwahl());
    }

    private Datensatz lesenDaten() {
        return new Datensatz(nachNameFeld.getText(), ortFeld.getText(), nameFeld.getText(), plzFeld.getText(), strasseFeld.getText(), hausNummerFeld.getText(), telefonNummerFeld.getText(), vorwahlFeld.getText());
    }

}
