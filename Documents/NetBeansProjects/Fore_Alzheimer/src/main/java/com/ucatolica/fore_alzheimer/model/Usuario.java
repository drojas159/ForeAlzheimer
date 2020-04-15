/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.fore_alzheimer.model;

/**
 *
 * @author Daniela
 */
public class Usuario {
    
    String Tipo_documento;
    int Num_documento;
    String Nombres;
    String Apellido1;
    String Apellido2;
    String Contrasena;
    String Tel_fijo;
    String Celular;
    String Email;
    String Rol1;
    String Rol2;
    String Rol3;
    
    public Usuario(){
    }
    public Usuario(int Num_documento) {
        this.Num_documento = Num_documento;
    }
    
    public Usuario(int identificacion, String Contrasena) {
        this.Num_documento = identificacion;
        this.Contrasena = Contrasena;
    }
    
    public Usuario( String Tipo_documento,
                    int Num_documento,
                    String Nombres,
                    String Apellido1,
                    String Apellido2,
                    String Contrasena,
                    String Tel_fijo,
                    String Celular,
                    String Email,
                    String Rol1,
                    String Rol2,
                    String Rol3) {
        
        this.Tipo_documento = Tipo_documento;
        this.Num_documento = Num_documento;
        this.Nombres = Nombres;
        this.Apellido1 = Apellido1;
        this.Apellido2= Apellido2;
        this.Contrasena= Contrasena;
        this.Tel_fijo= Tel_fijo;
        this.Celular= Celular;
        this.Email= Email;
        this.Rol1= Rol1;
        this.Rol2= Rol2;
        this.Rol3= Rol3;   
    }

    public String getTipo_documento() {
        return Tipo_documento;
    }

    public int getNum_documento() {
        return Num_documento;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public String getTel_fijo() {
        return Tel_fijo;
    }

    public String getCelular() {
        return Celular;
    }

    public String getEmail() {
        return Email;
    }

    public String getRol1() {
        return Rol1;
    }

    public String getRol2() {
        return Rol2;
    }

    public String getRol3() {
        return Rol3;
    }

    public void setNum_documento(int Num_documento) {
        this.Num_documento = Num_documento;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    
    
    
}
