/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controller.controller_perpus;
import com.koneksi.koneksi;
import com.view.form_login;
import com.view.form_perpus_login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB 2 PC 04
 */
public class model_perpus implements controller_perpus{

    @Override
    public void Simpan(form_login perpus) throws SQLException {
        try {
            Connection con = koneksi.getcon();
            String sql = "Insert Into perpus Values (?,?,?)";
            PreparedStatement prepare = con.prepareStatement (sql);
            prepare.setString(1, perpus.txt_idBuku.getText());
            prepare.setString(2, perpus.txt_namaBuku.getText());
            prepare.setString(3, perpus.txt_gendre.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(perpus);
            perpus.setLebarKolom();
        }  
    }

    @Override
    public void baru(form_login perpus) throws SQLException {
        perpus.txt_idBuku.setText("");
        perpus.txt_namaBuku.setText("");
        perpus.txt_gendre.setText("");
    }

    @Override
    public void ubah(form_login perpus) throws SQLException {
       
        try {
            Connection con = koneksi.getcon();
            String sql = "UPDATE perpus SET nama=?, genre=? WHERE id=?";
                     
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(3, perpus.txt_idBuku.getText());
            prepare.setString(1, perpus.txt_namaBuku.getText());
            prepare.setString(2, perpus.txt_gendre.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Ubah");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(perpus);
            perpus.setLebarKolom();
            baru(perpus);
        }  
    }

    @Override
    public void Tampil(form_login perpus) throws SQLException {
              perpus.tblmodel.getDataVector().removeAllElements();
        perpus.tblmodel.fireTableDataChanged();
        
        try {
            Connection con = koneksi.getcon();
            Statement stt = con.createStatement();
            String sql = "SELECT * FROM perpus ORDER BY id ASC";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {                
                Object[] ob = new Object[8]; // hasilnya 8
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                perpus.tblmodel.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void KlikTabel(form_login perpus) throws SQLException {
        try {
            int pilih = perpus.table.getSelectedRow();
            if (pilih == -1) {
                return;
            }
            perpus.txt_idBuku.setText(perpus.tblmodel.getValueAt(pilih, 0).toString());
            perpus.txt_namaBuku.setText(perpus.tblmodel.getValueAt(pilih, 1).toString());
            perpus.txt_gendre.setText(perpus.tblmodel.getValueAt(pilih, 2).toString());
        }catch (Exception e) {
            
        }
        //memberi nilai jk pada radio button
      
    }

    @Override
    public void Hapus(form_login perpus) throws SQLException {
     try {
            Connection con = koneksi.getcon();
        String sql = "DELETE FROM perpus WHERE id=?";
        PreparedStatement prepare = con.prepareStatement(sql);
        prepare.setString(1, perpus.txt_idBuku.getText());
        prepare.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(perpus);
            perpus.setLebarKolom();
            baru(perpus);
        }  
    }

   

    
    
}
