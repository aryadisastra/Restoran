/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.Koneksi;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 * FXML Controller class
 *
 * @author viugraph
 */
public class LoginFXMLController implements Initializable {
    @FXML
    private TextField tf_id;
    @FXML
    private PasswordField pf_pass;
    Connection con;
    Statement stm;
    ResultSet rs;
        Stage closeStage = new Stage();

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

    @FXML
    private void masukKlik(ActionEvent event) throws IOException {
        String sql1 = "Select * from penguna where id_pengguna = '"+tf_id.getText()+"' AND password = '"+pf_pass.getText()+"'  OR id_pegawai = '"+tf_id.getText()+"'";
        Stage stage = new Stage();
        try{
            rs = stm.executeQuery(sql1);
            if(rs.next())
            {
                FXMLLoader fxmlloader= new
                FXMLLoader(getClass().getResource("/FXML/IndexFXML.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                closeStage =(Stage) node.getScene().getWindow();
                closeStage.close();
                IndexFXMLController in = fxmlloader.getController();
                in.setAkses(rs.getString("hak_akses"));
                stage.setScene(new Scene(root));
                //stage.setResizable(false);
               // stage.setFullScreen(true);
                //stage.setFullScreenExitHint("Layar Anda Akan Otomatis Full Screen");
              //  stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.show();
            }
        }catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null, "Tidak Bisa Login!!"+e);
        }
    }

    
}
