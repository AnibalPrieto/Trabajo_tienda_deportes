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
public class CategoriaDao {
    private static final String SQL_SELECT ="SELECT * FROM categoria";
    private static final String SQL_INSERT ="INSERT INTO categoria (Idc,"+
            "Nombre, Descripcion, Fecha) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE categoria SET"+
            " Nombre=?,Descripcion=?,Fecha=?"
            + "WHERE Idc=?";
    private static final String SQL_DELETE ="DELETE FROM categoria WHERE Idc=?";
    
    public List<Categoria> seleccionar () throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        Usuario usuario =null;
        List<Categoria> categorias = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while(rs.next()){
            int Idc = rs.getInt("Idc");//"nombre puestos en la base de datos"
            String Nombre = rs.getString("Nombre");
            String Descripcion = rs.getString("Descripcion");
            Date Fecha = rs.getDate("Fecha");
            //instancio un nuevo objeto
            categorias.add(new Categoria(Idc, Nombre, Descripcion, Fecha));//clase persona
        }
        close(rs);
        close(stmt);
        close(conn);
        
        return categorias;
    }
    public int insertar(Categoria categoria){
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
            stmt.setInt(1, categoria.getIdc());
            stmt.setString(2, categoria.getNombre());
            stmt.setString(3, categoria.getDescripcion());
            stmt.setDate(4, categoria.getFecha());
           
            
            
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
    public int actualizar(Categoria categoria){
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
            stmt.setString(1, categoria.getNombre());
            stmt.setString(2, categoria.getDescripcion());
            stmt.setDate(3, categoria.getFecha());
            stmt.setInt(4, categoria.getIdc());
            
            
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
    public int delete(Categoria categoria){
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
            stmt.setInt(1, categoria.getIdc());
            
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
