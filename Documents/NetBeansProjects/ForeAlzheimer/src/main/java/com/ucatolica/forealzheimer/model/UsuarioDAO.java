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
            con.close();
            return usr;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Object login(int Num_documento) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        //ArrayList<Persona> datos = new ArrayList();

        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {
            

            //Statement s = con.createStatement();
            Usuario usr = new Usuario();
            PreparedStatement ps = con.prepareStatement("select Tipo_documento, Num_documento, Nombres,"
                    + "Apellido1, Apellido2, Contrasena, Tel_fijo, Celular, Email, Rol1, Rol2, Rol3 from "
                    + "arcadb.usuario where Num_documento = ? ");
            
            
            ps.setInt(1, Num_documento);
            
            

            ResultSet rs = ps.executeQuery();
            //Object p = null;
            while (rs.next()) {
                usr.setTipo_documento(rs.getString(1));
                usr.setNum_documento(rs.getInt(2));
                usr.setNombres(rs.getString(3));
                usr.setApellido1(rs.getString(4));
                usr.setApellido2(rs.getString(5));
                usr.setContrasena(rs.getString(6));
                usr.setTel_fijo(rs.getString(7));
                usr.setCelular(rs.getString(8));
                usr.setEmail(rs.getString(9));
                usr.setRol1(rs.getString(10));
                usr.setRol2(rs.getString(11));
                usr.setRol3(rs.getString(12));
            }
            con.close();
            return usr;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
