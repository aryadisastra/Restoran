/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import Koneksi.Koneksi;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LABKOM01-RPL07
 */
public class UntukTabel {
    Connection con;
    Statement stm;
    ResultSet rs;
    
    
    
    private Integer urut = 0;
    
    
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
            
        }
        return listdata;
    }
    
    private final StringProperty no = new SimpleStringProperty();
    private final StringProperty nama = new SimpleStringProperty();
    private final StringProperty masakan = new SimpleStringProperty();
    private final StringProperty jumlah = new SimpleStringProperty();
    
    
    public String getNo()
    {
        return no.get();
    }
    public void setNo(String nilai)
    {
        no.set(nilai);
    }
    public StringProperty noProperty()
    {
        return no;
    }
    public String getNama()
    {
        return nama.get();
    }
    public void setNama(String nilai)
    {
        nama.set(nilai);
    }
    public StringProperty namaProperty()
    {
        return masakan;
    }
    public String getMasakan()
    {
        return masakan.get();
    }
    public void setMasakan(String nilai)
    {
        masakan.set(nilai);
    }
    public StringProperty masakanProperty()
    {
        return masakan;
    }
    public String getJumlah()
    {
        return jumlah.get();
    }
    public void setJumlah(String nilai)
    {
        jumlah.set(nilai);
    }
    public StringProperty jumlahProperty()
    {
        return jumlah;
    }
    
}
