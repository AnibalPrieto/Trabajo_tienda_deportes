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
public class Marca implements Serializable {
    private int Idm;
    private String Nombre;
    private String Tipo;
    private Date Fecha;

    public Marca() {
    }

    public Marca(int Idm) {
        this.Idm = Idm;
    }
    

    public Marca(String Nombre, String Tipo, Date Fecha) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Fecha = Fecha;
    }

    public Marca(int Idm, String Nombre, String Tipo, Date Fecha) {
        this.Idm = Idm;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Fecha = Fecha;
    }

    public int getIdm() {
        return Idm;
    }

    public void setIdm(int Idm) {
        this.Idm = Idm;
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

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca{Idm=").append(Idm);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", Tipo=").append(Tipo);
        sb.append(", Fecha=").append(Fecha);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.Idm;
        hash = 53 * hash + Objects.hashCode(this.Nombre);
        hash = 53 * hash + Objects.hashCode(this.Tipo);
        hash = 53 * hash + Objects.hashCode(this.Fecha);
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
        final Marca other = (Marca) obj;
        if (this.Idm != other.Idm) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        return true;
    }

    

    
    
    
}
