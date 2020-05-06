/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.forealzheimer.model;

import com.ucatolica.forealzheimer.BDConnection.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela
 */
public class UsuarioDAO {
   public Object consultar(int Num_doc) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        //ArrayList<Persona> datos = new ArrayList();
        
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {

            //Statement s = con.createStatement();
            Usuario usr = new Usuario();
            PreparedStatement ps = con.prepareStatement("select Num_documento from "
                    + "arcadb.usuario where Num_documento = ?");
            ps.setInt(1, Num_doc);

            ResultSet rs = ps.executeQuery();
            //Object p = null;
            while (rs.next()) {
                usr.setNum_documento(rs.getInt(1));
            }
            return usr;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
