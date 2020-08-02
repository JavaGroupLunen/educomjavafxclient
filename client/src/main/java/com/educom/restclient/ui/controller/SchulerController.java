package com.educom.restclient.ui.controller;


import com.educom.restclient.client.RestTemplateClient;
import com.educom.restclient.client.SchulerClient;
import com.educom.restclient.client.WebClientStockClient;
import com.educom.restclient.model.Schuler;
import com.educom.restclient.util.ActionButtonTableCell;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;


@Component
public class SchulerController implements Initializable {

    @FXML
    private TableView tableView;
    private ObservableList<Schuler> SchulersData = observableArrayList();
    @FXML
    private TableColumn<Schuler, String> clmVorname, clmName, clmEmail;
    @FXML
    private TextField tfFirstName, tfLastName, tfEmail, tfage, tfSearch;
    @FXML
    private TableColumn clmDelete, clmUpdate;
    @FXML
    private TableColumn<Schuler, Integer> clmAge;
    private List<Schuler> list = null;

    @FXML
    private RadioButton rbtVorname, rbtNachname, rbtEmail;
    @FXML
    private Button btnAdd, btnUpdate, btnDelete, btnSave;
    private Long updatedSchulerId;
    private final WebClient webClient = WebClient.builder().build();

    private final RestTemplate restTemplate = new RestTemplate();
    private  SchulerClient schulerClient; //= new SchulerClient(restTemplate);
    @FXML
    private void addAction() throws IOException, URISyntaxException {

        Schuler schuler = new Schuler();
        schuler.setFirstName(tfFirstName.getText());
        schuler.setLastName(tfLastName.getText());
        schuler.setEmail(tfEmail.getText());
        schulerClient = new SchulerClient(restTemplate);
        schulerClient.add(schuler);
        getAllSchuler();
        fillTableview();
        clearField();
    }


    @FXML
    private void saveAction() throws IOException, URISyntaxException {
        Schuler updatedSchuler = new Schuler();
        updatedSchuler.setLastName(tfLastName.getText());
        updatedSchuler.setFirstName(tfFirstName.getText());
        updatedSchuler.setEmail(tfEmail.getText());
        schulerClient = new SchulerClient(restTemplate);
        schulerClient.updateschuler(getUpdatedSchulerId(),updatedSchuler);
        getAllSchuler();
        fillTableview();
        clearField();
    }



    private void getAllSchuler() {
        list = new WebClientStockClient(webClient).getSchulerList().collectList().block();

    }

    private void fillTableview() {
        if (tfSearch.getText().strip().isEmpty()) {
            getAllSchuler();
        }

        SchulersData = FXCollections.observableList(list).sorted();
        tableView.setItems(SchulersData);
    }

    private void deleteClient(Long id) {
        schulerClient= new SchulerClient(restTemplate);
        schulerClient.delete(id);
        getAllSchuler();
        fillTableview();
    }

    private void findBy(String param) {
        RestTemplateClient restClientTemplate = new RestTemplateClient(restTemplate);
        if (rbtVorname.isSelected()) {
            list = schulerClient.findByName(param);

        } else if (rbtNachname.isSelected()) {
            list = schulerClient.findByLastName(param);

        } else if (rbtEmail.isSelected()) {
            list = schulerClient.findByEmail(param);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnAdd.getStyleClass().add("button-raised");
        btnSave.getStyleClass().add("button-raised");
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        clmVorname.setCellValueFactory(new PropertyValueFactory("firstName"));
        clmName.setCellValueFactory(new PropertyValueFactory("lastName"));
        clmEmail.setCellValueFactory(new PropertyValueFactory("email"));
        //  clmAge.setCellValueFactory(new PropertyValueFactory<Schuler,Integer>("age"));

        clmDelete.setCellFactory(ActionButtonTableCell.forTableColumn("Delete", (Schuler p) -> {
            deleteClient(p.getId());
            return p;
        }));
        clmUpdate.setCellFactory(ActionButtonTableCell.forTableColumn("Update", (Schuler p) -> {
            fillFieldForUpdate(p);
            setUpdatedSchulerId(p.getId());
            return p;
        }));
        tableView.getItems().setAll(SchulersData);
        tableView.getColumns().setAll(clmVorname, clmName, clmEmail, clmAge, clmDelete, clmUpdate);


        fillTableview();
        tfSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                System.out.println(" Text Changed to  " + newValue + "\n");
                if (!newValue.strip().isEmpty()) {
                    findBy(newValue);

                }
                fillTableview();

            }
        });

        ToggleGroup searchGroup = new ToggleGroup();
        rbtEmail.setToggleGroup(searchGroup);
        rbtVorname.setToggleGroup(searchGroup);
        rbtNachname.setToggleGroup(searchGroup);

    }

    private void clearField() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfEmail.setText("");
    }

    private Long getUpdatedSchulerId() {
        return updatedSchulerId;
    }

    private void setUpdatedSchulerId(Long id) {
        this.updatedSchulerId = id;
    }

    private void fillFieldForUpdate(Schuler p) {
        setUpdatedSchulerId(p.getId());
        tfFirstName.setText(p.getFirstName());
        tfLastName.setText(p.getLastName());
        tfEmail.setText(p.getEmail());
    }


}