package com.example.labautomationv3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static com.example.labautomationv4.userLoginCtrl.users;

public class UserMainFrameCtrl implements Initializable {
    public static ArrayList<LabMain.Sample> Samples = new ArrayList<>();
    @FXML
    ListView listview1;
    ObservableList list1 = FXCollections.observableArrayList();
    @Override//listview
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData1();
    }
    private void loadData1() {
        list1.removeAll(list1);
        String a = "Kan Tahlili";
        String b = "İdrar Tahlili";
        list1.addAll(a, b);
        listview1.getItems().addAll(list1);
    }
    public void numuneTeslimi() {
        String numunetipi = (String) listview1.getSelectionModel().getSelectedItem();
        //Numune nesnesi olusturuluyor
        Samples.add(new LabMain.Sample(numunetipi));
        Samples.get(Samples.size()-1).musteri = users.get(users.size()-1);
        Samples.get(Samples.size()-1).sahibi= LabMain.Sample.musteri.Isim;
        System.out.println("Numune Bilgileri: Numune Sahibi: "+Samples.get(Samples.size()-1).musteri.Isim+
                ", Numune Tipi: "+Samples.get(Samples.size()-1).numuneTipi + ", Numune Teslim Tarihi: " +
                Samples.get(Samples.size()-1).teslimTarihi);
    }

    public void LogOut(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}
