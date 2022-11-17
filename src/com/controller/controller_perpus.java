/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.view.form_login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LAB 2 PC 04
 */
public interface controller_perpus {
    public void Simpan (form_login perpus) throws SQLException;
    public void baru(form_login perpus) throws SQLException;
    public void ubah(form_login perpus) throws SQLException;
    public void Tampil(form_login perpus) throws SQLException;
    public void KlikTabel(form_login perpus) throws SQLException;
    public void Hapus(form_login perpus) throws SQLException;
}
