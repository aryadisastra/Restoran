/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.Koneksi;
import Support.UntukTabel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LABKOM01-RPL07
 */
public class LihatDataAdminFXMLController implements Initializable {

    @FXML
    private Label lbl_usr;
    @FXML
    private VBox vb_admin;
    @FXML
    private HBox hb_tpa1;
    @FXML
    private HBox hb_ld2;
    @FXML
    private HBox hb_cs3;
    @FXML
    private TableView<UntukTabel> tbl_data;
    @FXML
    private TableColumn<UntukTabel, String> col_no;
    @FXML
    private TableColumn<UntukTabel, String> col_nama;
    @FXML
    private TableColumn<UntukTabel, String> col_masakan;
    @FXML
    private TableColumn<UntukTabel, String> col_jumlah;
    Connection con;
    Statement stm;
    ResultSet rs;
    
    Stage closeStage = new Stage();
    UntukTabel ut = new UntukTabel();
    ObservableList<UntukTabel> listdata;
    Integer urut = 0;
    @FXML
    private TextField tf_nama;
    @FXML
    private TextField tf_masakan;
    @FXML
    private TextField tf_jumlah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Koneksi db = new Koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        tabel();
        aksitabel();
    }    
    public void setAkses(String akses)
    {
 
        this.lbl_usr.setText(akses);
        
    }

    @FXML
    private void hbadmout1(MouseEvent event) {
        hb_tpa1.setStyle("-fx-background-color : white;");
    }

    @FXML
    private void hbadmin1(MouseEvent event) {
        hb_tpa1.setStyle("-fx-background-color : whitesmoke;");
    }

    @FXML
    private void PesanAdminKlik(MouseEvent event) {
        Stage stage = new Stage();
        try{
        FXMLLoader fxmlloader= new
                FXMLLoader(getClass().getResource("/FXML/IndexAdminFXML.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                closeStage =(Stage) node.getScene().getWindow();
                closeStage.close();
                IndexAdminFXMLController in = fxmlloader.getController();
                in.setAkses(lbl_usr.getText());
                stage.setScene(new Scene(root));
                //stage.setResizable(false);
               // stage.setFullScreen(true);
                //stage.setFullScreenExitHint("Layar Anda Akan Otomatis Full Screen");
              //  stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.show();
        }
        catch(Exception e)
        {
            
        }
        
    }

    @FXML
    private void hbadmout2(MouseEvent event) {
        hb_ld2.setStyle("-fx-background-color : white;");
    }

    @FXML
    private void hbadmin2(MouseEvent event) {
        hb_ld2.setStyle("-fx-background-color : whitesmoke;");
    }

    @FXML
    private void LihatDataKlik(MouseEvent event) {
        Stage stage = new Stage();
        try{
        FXMLLoader fxmlloader= new
                FXMLLoader(getClass().getResource("/FXML/LihatDataAdminFXML.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                closeStage =(Stage) node.getScene().getWindow();
                closeStage.close();
                LihatDataAdminFXMLController in = fxmlloader.getController();
                in.setAkses(lbl_usr.getText());
                stage.setScene(new Scene(root));
                //stage.setResizable(false);
               // stage.setFullScreen(true);
                //stage.setFullScreenExitHint("Layar Anda Akan Otomatis Full Screen");
              //  stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.show();
        }
        catch(Exception e)
        {
            
        }
    }

    @FXML
    private void StokKlik(MouseEvent event) {
    }

    @FXML
    private void hbadmout3(MouseEvent event) {
        hb_cs3.setStyle("-fx-background-color : white;");
    }

    @FXML
    private void hbadmin3(MouseEvent event) {
        hb_cs3.setStyle("-fx-background-color : whitesmoke;");
    }

    @FXML
    private void tabelKlik(MouseEvent event) {
        UntukTabel ambil = tbl_data.getSelectionModel().getSelectedItem();
        tf_nama.setText(ambil.getNama());
        tf_masakan.setText(ambil.getMasakan());
        tf_jumlah.setText(ambil.getJumlah());
    }
    
    private void tabel()
    {
        col_no.setCellValueFactory((TableColumn.CellDataFeatures<UntukTabel, String> celData) -> 
            celData.getValue().noProperty()
        );
        col_nama.setCellValueFactory((TableColumn.CellDataFeatures<UntukTabel, String> celData) -> 
            celData.getValue().namaProperty()
        );
        col_masakan.setCellValueFactory((TableColumn.CellDataFeatures<UntukTabel, String> celData) -> 
            celData.getValue().masakanProperty()
        );
        col_jumlah.setCellValueFactory((TableColumn.CellDataFeatures<UntukTabel, String> celData) -> 
            celData.getValue().jumlahProperty()
        );
        listdata = FXCollections.observableArrayList();
        tbl_data.getSelectionModel().clearSelection();
    }
    private void aksitabel()
    {
        listdata = getDataAll();
        tbl_data.setItems(listdata);
    }
    
    public ObservableList<UntukTabel> getDataAll()
    {
        ObservableList<UntukTabel> listdata =FXCollections.observableArrayList();
        try{
            Koneksi db = new Koneksi();
            db.config();
            con = db.con;
            stm = db.stm;
            String sql = "Select * from testt";
            rs= stm.executeQuery(sql);
            while(rs.next())
            {
                urut = urut+1;
                String nomer = urut.toString();
                
                UntukTabel d = new UntukTabel();
                d.setNo(nomer);
                d.setNama(rs.getString("nama"));
                d.setMasakan(rs.getString("masakan"));
                d.setJumlah(rs.getString("jumlah"));
                listdata.add(d);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return listdata;
    }

    @FXML
    private void editKlik(ActionEvent event) {
        try{
            String sql = "update testt set nama = '"+tf_nama.getText()+"', masakan = '"+tf_masakan.getText()+"', jumlah = '"+tf_jumlah.getText()+"' where nama = '"+tf_nama.getText()+"'";
            stm.execute(sql);
            tabel();
            aksitabel();
            tf_jumlah.setText("");
            tf_masakan.setText("");
            tf_nama.setText("");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void hapusKlik(ActionEvent event) {
        try{
            String sql = "delete from testt where nama = '"+tf_nama.getText()+"'";
            stm.execute(sql);
            tabel();
            aksitabel();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
