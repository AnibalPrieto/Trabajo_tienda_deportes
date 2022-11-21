/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author aniba
 */
public class UsuarioDao {
    
    private static final String SQL_SELECT ="SELECT * FROM usuarios";
    private static final String SQL_INSERT ="INSERT INTO usuarios (DNI,"+
            "Contraseña, Nombre, Apellidos, Email, Direccion, Telefono, Usuario_imagen) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE usuarios SET"+
            " Contraseña=?,Nombre=?,Apellidos=?,Email=?,Direccion=?,Telefono=?,Usuario_imagen=?"
            + "WHERE DNI=?";
    private static final String SQL_DELETE ="DELETE FROM usuarios WHERE DNI=?";
    private static final String SQL_BUSCAR ="SELECT * FROM usuarios WHERE DNI=?";
    
    
    //metodo que nos lista todas las personas de nuestro sistema
    public List<Usuario> seleccionar () throws SQLException, IOException {
        
        Connection conn = null;
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        Usuario usuario =null;
        List<Usuario> usuarios = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while(rs.next()){
            String DNI = rs.getString("DNI");//"nombre puestos en la base de datos"
            //System.out.println("DNI = " + DNI);
            String nombre = rs.getString("Nombre");
            String contraseña = rs.getString("Contraseña");
            String apellidos = rs.getString("Apellidos");
            String email = rs.getString("Email");
            String direccion = rs.getString("Direccion");
            String telefono = rs.getString("Telefono");
            Blob imagen = rs.getBlob("Usuario_imagen");
            InputStream imagenStream = imagen.getBinaryStream();
            ByteArrayOutputStream outputimagen = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            
            while ((bytesRead = imagenStream.read(buffer)) != -1) {
                outputimagen.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = outputimagen.toByteArray();

            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            imagenStream.close();
            outputimagen.close();
                        //conversion
            
            //instancio un nuevo objeto
            usuarios.add(new Usuario(DNI, contraseña, email, nombre, apellidos, direccion, telefono,base64Image));//clase persona
        }
        close(rs);
        close(stmt);
        close(conn);
        
        return usuarios;
    }
    public int insertar(Usuario usuario) throws FileNotFoundException{
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
            stmt.setString(1, usuario.getDNI());
            stmt.setString(2, usuario.getContraseña());
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getApellidos());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getDireccion());
            stmt.setString(7, usuario.getTelefono());
            stmt.setString(8, usuario.getimagen());
            InputStream imagen_usu = new FileInputStream(usuario.getimagen());
            stmt.setBlob(9, imagen_usu);
            
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
    public int actualizar(Usuario usuario){
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
            stmt.setString(1, usuario.getContraseña());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getTelefono());
            stmt.setString(7, usuario.getimagen());
            stmt.setString(8, usuario.getDNI());
            
            
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
    
    public int delete(Usuario usuario){
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
            stmt.setString(1, usuario.getDNI());
            
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
