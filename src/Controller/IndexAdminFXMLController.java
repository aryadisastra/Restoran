/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.Koneksi;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author viugraph
 */
public class IndexAdminFXMLController implements Initializable {
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
    Stage stage = new Stage();
    Stage closeStage = new Stage();
    @FXML
    private TextField tf_nama;
    @FXML
    private TextField tf_masakan;
    @FXML
    private TextField tf_jumlah;
    Connection con;
    Statement stm;
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Koneksi db = new Koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
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
    private void simpanKlik(ActionEvent event) {
        
        try{
            String sql = "Insert into testt(nama, masakan, jumlah) values('"+tf_nama.getText()+"','"+tf_masakan.getText()+"','"+tf_jumlah.getText()+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil Input!!");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
