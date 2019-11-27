/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author viugraph
 */
public class Koneksi {
   public Connection con;
   public Statement stm;
    public void config() 
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/restoran", "root", "");
        stm = (Statement) con.createStatement();
        }catch(Exception e)
        {
            printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal Konek Database!!");
        }
    }
}
