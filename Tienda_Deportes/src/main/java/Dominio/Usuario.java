/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

/**
 *
 * @author aniba
 */
public class Usuario implements Serializable {
    private String DNI;
    private String Contraseña;
    private String Email;
    private String Nombre;
    private String Apellidos;
    private String Direccion;
    private String telefono;
    private String imagen;

    public Usuario() {
    }

    public Usuario(String DNI) {
        this.DNI = DNI;
    }
    
//  new Usuario(DNI, contraseña, email, nombre, apellidos, direccion, telefono)
    
    public Usuario(String DNI, String Contraseña, String Email, String Nombre, String Apellidos, String Direccion, String telefono, String imagen) {
        this.DNI = DNI;
        this.Contraseña = Contraseña;
        this.Email = Email;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public Usuario(String Contraseña, String Email, String Nombre, String Apellidos, String Direccion, String telefono, String imagen) {
        this.Contraseña = Contraseña;
        this.Email = Email;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }   

    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    
    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getimagen() {
        return imagen;
    }

    public void setimagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{DNI=").append(DNI);
        sb.append(", Contrase\u00f1a=").append(Contraseña);
        sb.append(", Email=").append(Email);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", Apellidos=").append(Apellidos);
        sb.append(", Direccion=").append(Direccion);
        sb.append(", telefono=").append(telefono);
        sb.append(", Usuario_imagen=").append(imagen);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.DNI);
        hash = 59 * hash + Objects.hashCode(this.Contraseña);
        hash = 59 * hash + Objects.hashCode(this.Email);
        hash = 59 * hash + Objects.hashCode(this.Nombre);
        hash = 59 * hash + Objects.hashCode(this.Apellidos);
        hash = 59 * hash + Objects.hashCode(this.Direccion);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.imagen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        if (!Objects.equals(this.Contraseña, other.Contraseña)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellidos, other.Apellidos)) {
            return false;
        }
        if (!Objects.equals(this.Direccion, other.Direccion)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        return true;
    }
    
    

   

    
    
    
}
