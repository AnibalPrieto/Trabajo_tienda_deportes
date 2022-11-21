/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author aniba
 */
public class Carrito {
    private int idc;
    private Date Fecha;
    private Double Precio;
    private boolean pagado;
    private String DNI;

    public Carrito() {
    }

    public Carrito(int idc) {
        this.idc = idc;
    }
    

    public Carrito(Date Fecha, Double Precio, boolean pagado, String DNI) {
        this.Fecha = Fecha;
        this.Precio = Precio;
        this.pagado = pagado;
        this.DNI = DNI;
    }

    public Carrito(int idc, Date Fecha, Double Precio, boolean pagado, String DNI) {
        this.idc = idc;
        this.Fecha = Fecha;
        this.Precio = Precio;
        this.pagado = pagado;
        this.DNI = DNI;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public Date getFecha() {
        return Fecha;
    }
    

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito {id=").append(idc);
        sb.append(", Fecha=").append(Fecha);
        sb.append(", Precio=").append(Precio);
        sb.append(", pagado=").append(pagado);
        sb.append(", DNI=").append(DNI);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idc;
        hash = 71 * hash + Objects.hashCode(this.Fecha);
        hash = 71 * hash + Objects.hashCode(this.Precio);
        hash = 71 * hash + (this.pagado ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.DNI);
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
        final Carrito other = (Carrito) obj;
        if (this.idc != other.idc) {
            return false;
        }
        if (this.pagado != other.pagado) {
            return false;
        }
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        if (!Objects.equals(this.Fecha, other.Fecha)) {
            return false;
        }
        if (!Objects.equals(this.Precio, other.Precio)) {
            return false;
        }
        return true;
    }

    

    
    
    
            
}
