package com.mechanitis.demo.ui;


import com.mechanitis.demo.client.Lehre;
import com.mechanitis.demo.client.StockClient;
import com.mechanitis.demo.client.WebClientStockClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import static javafx.collections.FXCollections.observableArrayList;


@Component
public class SecondaryController implements Initializable {

    //ObservableList = Table view bir list turudur. burda bir Objekt listesi olusturuyoruz. table view e data atmak icin bunu olusturuyoruz.
    // arraylist ObservableList uzerinden tableview e ekliyoruz.
   // private ObservableList<Lehre> data=FXCollections.observableList();
    private  ObservableList<Lehre> lehresData = observableArrayList();

    // SceneBuilder da olusturdugumuz kompanenetlerileri ve sonrasinda kullanicagimiylari burda tanimliyoruz.
    @FXML
    private TableView tableView;
    @FXML
    private TextField tfFirstName, tfLastName, tfEmail,tfage;
    //Bu listeyi Table view icin kullaniyoruz.
    //kolonlari Lehre Objesiyle baglamak icin.
    @FXML
    private TableColumn<Lehre, String> clmVorname, clmName, clmEmail;
    @FXML
    private  TableColumn  clmDelete,clmUpdate;
    @FXML
    private TableColumn<Lehre,Integer> clmAge;

    private Lehre updatelehre=new Lehre();

    private WebClient webClient;

    //ObservableList uzerinden bu arraylisti Tableview e ekliyoruz.
    // bunun icin liste tanimlamamiz lazim ve bu listeyi Tableview
    // Tableview ile ObservableList baglantili
    // list ile de Tableview baglantili
    private List list = new ArrayList();
   // int row=0;


    //  butun butanlari tanimliyoruz.
    @FXML
    private Button btnAdd, btnUpdate, btnDelete, btnSave;




    //Add butonuna Click lendiginde yapicak islem.
    @FXML
    private void addAction() throws IOException, URISyntaxException {

        Lehre lehre = new Lehre(tfFirstName.getText(), tfLastName.getText(), tfEmail.getText());
         Integer codeValue=new WebClientStockClient(webClient).saveLehre(lehre).getStatusCodeValue();
        System.out.println(codeValue);

        lehresData = FXCollections.observableList(list);
        tableView.setItems(lehresData);
        clearField();
    }

    @FXML
    private void saveAction() throws IOException {
        updatelehre.setLastName( tfLastName.getText());
        updatelehre.setFirstName(tfFirstName.getText());
        updatelehre.setEmailId(tfEmail.getText());
        list.set(Math.toIntExact(updatelehre.getId()),updatelehre);
        ObservableList data = FXCollections.observableList(list);
        tableView.setItems(data);
        clearField();
    }
    @FXML
    private void switchToPrimary() throws IOException {

    }


    //clm ile yazilanlar Tableview in icerisindeki kolonlar
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webClient = WebClient.builder().build();

         Flux<Lehre> lehre = new WebClientStockClient(webClient).getLehreById(7L).take(1).log();
        List<Lehre> lehrelist = new WebClientStockClient(webClient).getLehreList().collectList().block();

        List list = new ArrayList();
        list.addAll(lehrelist);

        lehresData = FXCollections.observableList(list);
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        //Lehre object icerisindeki field lar ile ayni olmasi gerekir
        // kolonlarin hucrelerindeki degerler. Lehre Classinda ki degerler = ayni olacak
        clmVorname.setCellValueFactory(new PropertyValueFactory("firstName"));
        clmName.setCellValueFactory(new PropertyValueFactory("lastName"));
        clmEmail.setCellValueFactory(new PropertyValueFactory("emailId"));
      //  clmAge.setCellValueFactory(new PropertyValueFactory<Lehre,Integer>("age"));

        clmDelete.setCellFactory(ActionButtonTableCell.<Lehre>forTableColumn("Delete", (Lehre p) -> {
            tableView.getItems().remove(p);
            return p;
        }));
//        clmUpdate.setCellFactory(ActionButtonTableCell.<Lehre>forTableColumn("Update", (Lehre p) -> {
//
//            TablePosition pos = (TablePosition) tableView.getSelectionModel().getSelectedCells().get(0);
//            int row = pos.getRow();
//            fillUpdate(p);
//            System.out.println(row);
//            p.setId(row);
//            return p;
//        }));
        tableView.getItems().setAll(lehresData);
        tableView.getColumns().setAll(clmVorname, clmName, clmEmail,clmAge,clmDelete,clmUpdate);

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