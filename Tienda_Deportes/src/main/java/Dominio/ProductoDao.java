/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aniba
 */
public class ProductoDao {
    private static final String SQL_SELECT ="SELECT * FROM producto";
    private static final String SQL_INSERT ="INSERT INTO producto (Idp,"+
            "Nombre, Tipo, Precio) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE producto SET"+
            " Nombre=?,Tipo=?,Precio=?"
            + "WHERE Idp=?";
    private static final String SQL_DELETE ="DELETE FROM producto WHERE Idp=?";
    
    public List<Producto> seleccionar () throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        Producto producto =null;
        List<Producto> productos = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while(rs.next()){
            int Idp = rs.getInt("Idp");//"nombre puestos en la base de datos"
            String Nombre = rs.getString("Nombre");
            String Tipo = rs.getString("Tipo");
            double Precio = rs.getFloat("Precio");
            //instancio un nuevo objeto
            productos.add(new Producto(Idp, Nombre, Tipo, Precio));//clase persona
        }
        close(rs);
        close(stmt);
        close(conn);
        
        return productos;
    }
    public int insertar(Producto producto){
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
            stmt.setInt(1, producto.getIdp());
            stmt.setString(2, producto.getNombre());
            stmt.setString(3, producto.getTipo());
            stmt.setDouble(4, producto.getPrecio());
            
            
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
    public int actualizar(Producto producto){
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
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getTipo());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setDouble(4, producto.getIdp());
            
            
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
    public int delete(Producto producto){
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
            stmt.setInt(1, producto.getIdp());
            
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
