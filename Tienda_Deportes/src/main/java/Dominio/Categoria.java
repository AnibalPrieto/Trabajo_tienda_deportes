/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author aniba
 */
public class Categoria implements Serializable{
    private int Idc;
    private String Nombre;
    private String Descripcion;
    private Date Fecha;

    public Categoria() {
    }

    public Categoria(int Idc) {
        this.Idc = Idc;
    }
    

    public Categoria(int Idc, String Nombre, String Descripcion, Date Fecha) {
        this.Idc = Idc;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
    }

    public Categoria(String Nombre, String Descripcion, Date Fecha) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
    }


    public int getIdc() {
        return Idc;
    }

    public void setIdc(int Idc) {
        this.Idc = Idc;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categoria{Idc=").append(Idc);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", Descripcion=").append(Descripcion);
        sb.append(", Fecha=").append(Fecha);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.Idc;
        hash = 37 * hash + Objects.hashCode(this.Nombre);
        hash = 37 * hash + Objects.hashCode(this.Descripcion);
        hash = 37 * hash + Objects.hashCode(this.Fecha);
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
        final Categoria other = (Categoria) obj;
        if (this.Idc != other.Idc) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Descripcion, other.Descripcion)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        return true;
    }

    
    
     
}
