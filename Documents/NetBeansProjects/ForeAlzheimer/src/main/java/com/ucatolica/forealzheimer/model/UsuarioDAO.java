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
import java.util.ArrayList;
import java.util.List;
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
    
    
    public Object consultaDatos(int numDoc) {
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

            ps.setInt(1, numDoc);

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
    
    public Object login(String email) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        //ArrayList<Persona> datos = new ArrayList();

        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {

            //Statement s = con.createStatement();
            Usuario usr = new Usuario();
            PreparedStatement ps = con.prepareStatement("select Tipo_documento, Num_documento, Nombres,"
                    + "Apellido1, Apellido2, Contrasena, Tel_fijo, Celular, Email, Rol1, Rol2, Rol3 from "
                    + "arcadb.usuario where Email = ? ");

            ps.setString(1, email);

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
    public Usuario consultarUsuario(int Doc) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        Usuario usr= new Usuario();
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {
            

                PreparedStatement ps = con.prepareStatement("SELECT Tipo_documento,Num_documento,Nombres,Apellido1,"
                        + "Apellido2,Tel_fijo,Celular,Email, Rol3 FROM arcadb.usuario WHERE (Rol1='AUXILIAR' or Rol2='PSICOLOGO') and Num_documento=?");
                ps.setInt(1, Doc);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    usr.setTipo_documento(rs.getString(1));
                    usr.setNum_documento(rs.getInt(2));
                    usr.setNombres(rs.getString(3));
                    usr.setApellido1(rs.getString(4));
                    usr.setApellido2(rs.getString(5));
                    usr.setTel_fijo(rs.getString(6));
                    usr.setCelular(rs.getString(7));
                    usr.setEmail(rs.getString(8));
                    usr.setRol3(rs.getString(9));                                     
                }
                con.close();
                return usr;
            

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Usuario consultarPaciente(int Doc) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        Usuario usr= new Usuario();
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {
            

                PreparedStatement ps = con.prepareStatement("SELECT Tipo_documento,Num_documento,Nombres,Apellido1,"
                        + "Apellido2,Tel_fijo,Celular,Email, Rol3 FROM arcadb.usuario WHERE Rol3='PACIENTE' and Num_documento=?");
                ps.setInt(1, Doc);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    
                    usr.setTipo_documento(rs.getString(1));
                    usr.setNum_documento(rs.getInt(2));
                    usr.setNombres(rs.getString(3));
                    usr.setApellido1(rs.getString(4));
                    usr.setApellido2(rs.getString(5));
                    usr.setTel_fijo(rs.getString(6));
                    usr.setCelular(rs.getString(7));
                    usr.setEmail(rs.getString(8));
                    usr.setRol3(rs.getString(9));                                     
                }
                con.close();
                return usr;
            

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Usuario> consultarPacientes(String Rol[]) {
        List<Usuario> pacientes = new ArrayList<>();
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {
            if (Rol.length == 1) {

                PreparedStatement ps = con.prepareStatement("SELECT Tipo_documento,Num_documento,Nombres,Apellido1,"
                        + "Apellido2,Tel_fijo,Celular,Email, Rol3 FROM arcadb.usuario WHERE Rol3=?");
                ps.setString(1, Rol[0]);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Usuario usr = new Usuario();
                    usr.setTipo_documento(rs.getString(1));
                    usr.setNum_documento(rs.getInt(2));
                    usr.setNombres(rs.getString(3));
                    usr.setApellido1(rs.getString(4));
                    usr.setApellido2(rs.getString(5));
                    usr.setTel_fijo(rs.getString(6));
                    usr.setCelular(rs.getString(7));
                    usr.setEmail(rs.getString(8));
                    usr.setRol3(rs.getString(9));
                    
                    pacientes.add(usr);
                }

            } else {

                PreparedStatement ps = con.prepareStatement("SELECT Tipo_documento,Num_documento,Nombres,Apellido1,"
                        + "Apellido2,Tel_fijo,Celular,Email, Rol1, Rol2 FROM arcadb.usuario WHERE Rol1=? or Rol2=?");
                
                ps.setString(1, Rol[0]);
                ps.setString(2, Rol[1]);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Usuario usr = new Usuario();
                    usr.setTipo_documento(rs.getString(1));
                    usr.setNum_documento(rs.getInt(2));
                    usr.setNombres(rs.getString(3));
                    usr.setApellido1(rs.getString(4));
                    usr.setApellido2(rs.getString(5));
                    usr.setTel_fijo(rs.getString(6));
                    usr.setCelular(rs.getString(7));
                    usr.setEmail(rs.getString(8));
                    usr.setRol1(rs.getString(9));
                    usr.setRol2(rs.getString(10));

                    pacientes.add(usr);

                }
            }
            con.close();
            return pacientes;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void ChangePassword(String pass, int doc) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {

            PreparedStatement ps = con.prepareStatement("UPDATE arcadb.usuario SET contrasena "
                    + "= ? WHERE num_documento = ?");

            ps.setString(1, pass);
            ps.setInt(2, doc);

            ps.execute();
            //Object p = null;

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void updateUsr(Usuario usr, int Num_Doc) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();

        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {

            PreparedStatement ps = con.prepareStatement("UPDATE arcadb.usuario SET "
                    + "Tipo_documento =?,"
                    + "Num_documento=?,"
                    + "Nombres=?,"
                    + "Apellido1=?,"
                    + "Apellido2=?,"
                    + "Tel_fijo=?,"
                    + "Celular=?,"
                    + "Email=?,"
                    + "Rol1=?, "
                    + "Rol2=?,"
                    + " Rol3=? where num_documento=?");

            ps.setString(1, usr.getTipo_documento());
            ps.setInt(2, usr.getNum_documento());
            ps.setString(3, usr.getNombres());
            ps.setString(4, usr.getApellido1());
            ps.setString(5, usr.getApellido2());
            ps.setString(6, usr.getTel_fijo());
            ps.setString(7, usr.getCelular());
            ps.setString(8, usr.getEmail());
            ps.setString(9, usr.getRol1());
            ps.setString(10, usr.getRol2());
            ps.setString(11, usr.getRol3());
            ps.setInt(12, Num_Doc);

            ps.execute();
            //Object p = null;

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    public void DeleteUser(int num){
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {

            PreparedStatement ps = con.prepareStatement("delete from arcadb.usuario where Num_documento=?");

            ps.setInt(1, num);

            ps.execute();
            //Object p = null;

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    public boolean register(Usuario usr) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        //ArrayList<Persona> datos = new ArrayList();

        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO arcadb.usuario (Tipo_documento,"
                    + "Num_documento,Nombres,Apellido1,Apellido2,Contrasena,Tel_fijo,Celular,Email,"
                    + "Rol1, Rol2, Rol3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, usr.getTipo_documento());
            ps.setInt(2, usr.getNum_documento());
            ps.setString(3, usr.getNombres());
            ps.setString(4, usr.getApellido1());
            ps.setString(5, usr.getApellido2());
            ps.setString(6, usr.getContrasena());
            ps.setString(7, usr.getTel_fijo());
            ps.setString(8, usr.getCelular());
            ps.setString(9, usr.getEmail());
            ps.setString(10, usr.getRol1());
            ps.setString(11, usr.getRol2());
            ps.setString(12, usr.getRol3());

            boolean rs = ps.execute();
            //Object p = null;

            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    
    public void create(Usuario usr) {
        MysqlConnection conDB = new MysqlConnection();
        Connection con = conDB.initializeDatabase();
        //ArrayList<Persona> datos = new ArrayList();

        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO arcadb.usuario (Tipo_documento,"
                    + "Num_documento,Nombres,Apellido1,Apellido2,Contrasena,Tel_fijo,Celular,Email,"
                    + "Rol1, Rol2, Rol3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, usr.getTipo_documento());
            ps.setInt(2, usr.getNum_documento());
            ps.setString(3, usr.getNombres());
            ps.setString(4, usr.getApellido1());
            ps.setString(5, usr.getApellido2());
            ps.setString(6, Integer.toString(usr.getNum_documento()));
            ps.setString(7, usr.getTel_fijo());
            ps.setString(8, usr.getCelular());
            ps.setString(9, usr.getEmail());
            ps.setString(10, usr.getRol1());
            ps.setString(11, usr.getRol2());
            ps.setString(12, usr.getRol3());

            boolean rs = ps.execute();
            //Object p = null;

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
