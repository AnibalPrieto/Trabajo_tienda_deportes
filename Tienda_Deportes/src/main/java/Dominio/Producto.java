/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aniba
 */
public class Producto implements Serializable{
    private int Idp;
    private String Nombre;
    private String Tipo;
    private double Precio;

    public Producto() {
    }

    public Producto(int Idp) {
        this.Idp = Idp;
    }
    

    public Producto(int Idp, String Nombre, String Tipo, double Precio) {
        this.Idp = Idp;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Precio = Precio;
    }

    public Producto(String Nombre, String Tipo, double Precio) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Precio = Precio;
    }

    public int getIdp() {
        return Idp;
    }

    public void setIdp(int Idp) {
        this.Idp = Idp;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{Idp=").append(Idp);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", Tipo=").append(Tipo);
        sb.append(", Precio=").append(Precio);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.Idp;
        hash = 47 * hash + Objects.hashCode(this.Nombre);
        hash = 47 * hash + Objects.hashCode(this.Tipo);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.Precio) ^ (Double.doubleToLongBits(this.Precio) >>> 32));
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
        final Producto other = (Producto) obj;
        if (this.Idp != other.Idp) {
            return false;
        }
        if (Double.doubleToLongBits(this.Precio) != Double.doubleToLongBits(other.Precio)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        return true;
    }

    
    
}
