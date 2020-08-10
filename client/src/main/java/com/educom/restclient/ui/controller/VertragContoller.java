package com.educom.restclient.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class VertragContoller implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label tfadres;

    @FXML
    private TextField tfVorname;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfGeburstdatum;

    @FXML
    private TextField tfAdresse;

    @FXML
    private ComboBox<?> cbxGeschlecht;

    @FXML
    private TextField tfPlz;

    @FXML
    private TextField tfStadt;

    @FXML
    private TextField tfTel;

    @FXML
    private TextField tfSchule;

    @FXML
    private TextField tfKlasse;

    @FXML
    private TextField tfRaum;

    @FXML
    private TextField tfLehre;

    @FXML
    private TextField tfKursName;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSave;

    @FXML
    private Label tfLehre1;

    @FXML
    private Label tfLehre2;

    @FXML
    private Label tfLehre21;

    @FXML
    private Label tfLehre211;

    @FXML
    private Label tfLehre213;

    @FXML
    private TextField tfDauer;

    @FXML
    private TextField tfKurslang;

    @FXML
    private TextField tfAnfangenAb;

    @FXML
    private TextField tfEndeBis;

    @FXML
    private TextField tfPrice;

    @FXML
    private TableView<?> tbwKurs1;

    @FXML
    private TableColumn<?, ?> clmKursName1;

    @FXML
    private TableColumn<?, ?> clmRaum1;

    @FXML
    private TableColumn<?, ?> clmLehre1;

    @FXML
    private TextField tfDauer211;

    @FXML
    private Label lblvertragNo;

    @FXML
    private TextField tfAnfangsdatum;

    @FXML
    private TextField tfEndeDatum;

    @FXML
    private ChoiceBox<?> cbxZahlungsType;

    @FXML
    private TextField tfMonatlichPrice;

    @FXML
    private TextField tfEinmaligePrice;

    @FXML
    private TextField tfAnmeldegebuhr;

    @FXML
    private TextField tfMaterialprice;

    @FXML
    private TextField tfTotalprice;

    @FXML
    private TextField tfRabatprice;

    @FXML
    private TextField tfRabatPercent;

    @FXML
    private TextField tfVatername;

    @FXML
    private TextField tfMuttername;

    @FXML
    private TextField tfElternAdres;

    @FXML
    private TextField tfElternPlz;

    @FXML
    private TextField tfElternStadt;

    @FXML
    private TextField tfElternTel;

    @FXML
    private TextField tfBic;

    @FXML
    private TextField tfIban;

    @FXML
    private TextField tfInstitute;

    @FXML
    private TextField tfInhaber;

    @FXML
    private TextField tfSearch;

    @FXML
    void addAction(ActionEvent event) {

    }

    @FXML
    void saveAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void addAction(){

    }
    @FXML
    void saveAction(){

    }
}
