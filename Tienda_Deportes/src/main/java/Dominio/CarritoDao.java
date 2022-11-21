/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aniba
 */
public class CarritoDao {
    private static final String SQL_SELECT ="SELECT * FROM carrito";
    private static final String SQL_INSERT ="INSERT INTO carrito (Idca,"+
            "Fecha, Precio, Pagado,DNI ) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE carrito SET"+
            " Fecha=?,Precio=?,Pagado=?,DNI=?"
            + "WHERE Idca=?";
    private static final String SQL_DELETE ="DELETE FROM carrito WHERE Idca=?";
    
    public List<Carrito> seleccionar () throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        Marca marca =null;
        List<Carrito> carritos = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while(rs.next()){
            int Idc = rs.getInt("Idca");//"nombre puestos en la base de datos"
            Date Fecha = rs.getDate("Fecha");
            Double Precio = rs.getDouble("Precio");
            Boolean Pagado = rs.getBoolean("Pagado");
            String DNI = rs.getString("DNI");
            //instancio un nuevo objeto
            carritos.add(new Carrito(Idc,Fecha , Precio, Pagado,DNI));//clase persona
        }
        close(rs);
        close(stmt);
        close(conn);
        
        return carritos;
    }
    public int insertar(Carrito carro){
        //declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros= 0;
        try {
            //1.Establecemos la conexión
            conn= getConnection ();
            //2.preparo mi instruccion
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar losvalores de los ? de la consulta
            stmt.setInt(1, carro.getIdc());
            stmt.setDate(2, carro.getFecha());
            stmt.setDouble(3, carro.getPrecio());
            stmt.setBoolean(4, carro.isPagado());
            stmt.setString(5, carro.getDNI());
            
            
            //3.ejecuto la query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    public int actualizar(Carrito carrito){
        //declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros= 0;
        try {
            //1.Establecemos la conexión
            conn= getConnection ();
            //2.preparo mi instruccion
            stmt = conn.prepareStatement(SQL_UPDATE);
            //Asignar losvalores de los ? de la consulta 
            stmt.setDate(1, carrito.getFecha());
            stmt.setDouble(2, carrito.getPrecio());
            stmt.setBoolean(3, carrito.isPagado());
            stmt.setString(4, carrito.getDNI());
            stmt.setInt(5, carrito.getIdc());
            
            
            registros = stmt.executeUpdate();
            
            //3.ejecuto la query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    public int delete(Carrito carrito){
        //declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros= 0;
        try {
            //1.Establecemos la conexión
            conn= getConnection ();
            //2.preparo mi instruccion
            stmt = conn.prepareStatement(SQL_DELETE);
            //Asignar losvalores de los ? de la consulta
            stmt.setInt(1, carrito.getIdc());
            
            //3.ejecuto la query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
