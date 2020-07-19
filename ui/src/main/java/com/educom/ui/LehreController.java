package com.educom.ui;


import com.educom.restclient.client.RestTemplateClient;
import com.educom.restclient.client.WebClientStockClient;
import com.educom.restclient.model.Lehre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import util.ActionButtonTableCell;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;


@Component
public class LehreController implements Initializable {
    private  ObservableList<Lehre> lehresData = observableArrayList();

    @FXML
    private TableView tableView;
    @FXML
    private TextField tfFirstName, tfLastName, tfEmail,tfage;

    @FXML
    private TableColumn<Lehre, String> clmVorname, clmName, clmEmail;
    @FXML
    private  TableColumn  clmDelete,clmUpdate;
    @FXML
    private TableColumn<Lehre,Integer> clmAge;

    private Lehre updatelehre=new Lehre();

    private final RestTemplate restTemplate=new RestTemplate();

    private final WebClient webClient = WebClient.builder().build();

    private List<Lehre> list;


    @FXML
    private Button btnAdd, btnUpdate, btnDelete, btnSave;


    @FXML
    private void addAction() throws IOException, URISyntaxException {

        Lehre lehre = new Lehre(tfFirstName.getText(), tfLastName.getText(), tfEmail.getText());
        Integer codeValue = new WebClientStockClient(webClient).saveLehre(lehre).getStatusCodeValue();
        System.out.println(codeValue);
        fillTableView();
        clearField();
    }

    @FXML
    private void saveAction() throws IOException ,URISyntaxException{
        updatelehre.setLastName( tfLastName.getText());
        updatelehre.setFirstName(tfFirstName.getText());
        updatelehre.setEmailId(tfEmail.getText());
        Integer codeValue = new WebClientStockClient(webClient).saveLehre(updatelehre).getStatusCodeValue();
        System.out.println(codeValue);
        fillTableView();

        clearField();
    }

    @FXML
    private void switchToPrimary() throws IOException {

    }

    private void fillTableView() {
        List<Lehre> lehrelist = new WebClientStockClient(webClient).getLehreList().collectList().block();
        lehresData = FXCollections.observableList(lehrelist).sorted();
        tableView.setItems(lehresData);
    }

    private void deleteClient(Lehre lehre){
        RestTemplateClient restClientTemplate = new RestTemplateClient(restTemplate);
        restClientTemplate.deleteEmployee(lehre);
        fillTableView();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        clmVorname.setCellValueFactory(new PropertyValueFactory("firstName"));
        clmName.setCellValueFactory(new PropertyValueFactory("lastName"));
        clmEmail.setCellValueFactory(new PropertyValueFactory("emailId"));
        //  clmAge.setCellValueFactory(new PropertyValueFactory<Lehre,Integer>("age"));

        clmDelete.setCellFactory(ActionButtonTableCell.<Lehre>forTableColumn("Delete", (Lehre p) -> {
        deleteClient(p);
            return p;
        }));
        clmUpdate.setCellFactory(ActionButtonTableCell.<Lehre>forTableColumn("Update", (Lehre p) -> {
            fillUpdate(p);
            return p;
        }));
        tableView.getItems().setAll(lehresData);
        tableView.getColumns().setAll(clmVorname, clmName, clmEmail,clmAge,clmDelete,clmUpdate);
        fillTableView();

    }

    private void clearField() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfEmail.setText("");
    }

    private void fillUpdate(Lehre p){
        tfFirstName.setText(p.getFirstName());
        tfLastName.setText(p.getLastName());
        tfEmail.setText(p.getEmailId());
        updatelehre.setId(p.getId());
    }



}