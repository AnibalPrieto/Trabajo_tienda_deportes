/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Dominio.Carrito;
import Dominio.CarritoDao;
import Dominio.Categoria;
import Dominio.CategoriaDao;
import Dominio.Marca;
import Dominio.MarcaDao;
import Dominio.Producto;
import Dominio.ProductoDao;
import Dominio.Usuario;
import Dominio.UsuarioDao;
import ficheros.archivos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aniba
 */
public class Test_Tienda {
    static Scanner ent = new Scanner(System.in);
    static java.util.Date utilDate = new java.util.Date();
    static java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    static UsuarioDao usuarioDao = new UsuarioDao();
    static CategoriaDao categoriaDao = new CategoriaDao();
    static ProductoDao productoDao = new ProductoDao();
    static MarcaDao marcaDao = new MarcaDao();
    static CarritoDao carritoDao = new CarritoDao();
    
    
    
    
    public static void main(String[] args) throws IOException, SQLException {
        /*Usuario u1 = new Usuario ("02572633Z","JFKSN5859","alberto@gmail.com","elias","Prieto","porto Pajares","674839201","imagen cuando este");
        Usuario u2 = new Usuario ("02572633Z","JFKSN5859","alberto@gmail.com","Anibal","Hernandez","porto Pajares","674839201","imagen cuando este");
        Categoria c1 = new Categoria(1,"Futbol Sala","Donde 10 jugadores se retan en el campo",sqlDate);
        Categoria c2 = new Categoria(1,"Futbol","Donde 22 jugadores se retan en el campo",sqlDate);
        Producto p1 = new Producto(1,"Chandal","Running",99.99);
        Producto p2 = new Producto(1,"Chaqueta","Invierno",99.99);
        Marca m1 = new Marca(1,"Nike","Deporte",sqlDate);
        Marca m2 = new Marca(1,"Adidas","Deporte",sqlDate);
        Carrito ca1 = new Carrito(1,sqlDate,19.78,false,"02572633Z");
        Carrito ca2 = new Carrito(1,sqlDate,19.78,false,"02572633Z");*/
        
        int opcion=-1;
	while(opcion!=0){
		System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
		System.out.printf("\tMenú\n");
		System.out.printf("\t====\n");
                System.out.println("Que desea hacer");
		System.out.printf("1.- VISUALIZAR \n");
		System.out.printf("2.- AGREGAR \n");
		System.out.printf("3.- BUSCAR \n");
		System.out.printf("4.- ELIMINAR \n");
                System.out.printf("5.- MODIFICAR \n");
		System.out.printf("0.- SALIR\n");
		System.out.printf("\n\tSeleccione una de las siguientes opciones: ");
		opcion = ent.nextInt();
		switch(opcion){
			case 1:
				System.out.printf("\nVISUALIZAR \n\n");
				int opcion2=-1;
                                while(opcion2!=0){
                                        System.out.println("Que desea visualizar");
                                        System.out.printf("1.- USUARIOS \n");
                                        System.out.printf("2.- PRODUCTOS \n");
                                        System.out.printf("3.- CATEGORIAS \n");
                                        System.out.printf("4.- MARCAS \n");
                                        System.out.printf("5.- COMPRAS \n");
                                        System.out.printf("0.- SALIR\n");
                                        opcion2 = ent.nextInt();
                                        switch(opcion2){
                                                case 1:
                                                        System.out.printf("\nVISUALIZAR USUSARIOS \n\n");
                                                        try{
                                                            //TABLA USUARIO =======================================
                                                            //usuarioDao.insertar(u1); 
                                                            //usuarioDao.actualizar(u2);
                                                            //usuarioDao.delete(u1);
                                                            List<Usuario> usuarios = usuarioDao.seleccionar();
                                                            for (Usuario u :usuarios) {
                                                                System.out.println(u.toString());
                                                                System.out.println("");
                                                            }
                                                        }catch (SQLException ex){
                                                            ex.printStackTrace(System.out);
                                                        }
                                                        break;
                                                case 2:
                                                        System.out.printf("\nVISUALIZAR PRODUCTOS \n\n");
                                                        try{
                                                            //TABLA PRODUCTO =======================================
                                                            //productoDao.insertar(p1);
                                                            //productoDao.actualizar(p2);
                                                            //productoDao.delete(p1);
                                                            List<Producto> productos = productoDao.seleccionar();
                                                            for (Producto p :productos) {
                                                                System.out.println(p.toString());
                                                                System.out.println("");
                                                            }
                                                        }catch (SQLException ex){
                                                            ex.printStackTrace(System.out);
                                                        }
                                                        break;
                                                case 3:
                                                        System.out.printf("\nVISUALIZAR CATEGORIAS\n\n");
                                                        try{
                                                            //TABLA CATEGORIA =======================================
                                                            //categoriaDao.insertar(c1);
                                                            //categoriaDao.actualizar(c2);
                                                            //categoriaDao.delete(c1);
                                                            List<Categoria> categorias = categoriaDao.seleccionar();
                                                            for (Categoria c :categorias) {
                                                                System.out.println(c.toString());
                                                                System.out.println("");
                                                            }
                                                        }catch (SQLException ex){
                                                            ex.printStackTrace(System.out);
                                                        }
                                                        break;
                                                case 4:
                                                        System.out.printf("\nVISUALIZAR MARCAS \n\n");
                                                        try{
                                                            //TABLA MARCA =======================================
                                                            //marcaDao.insertar(m1); 
                                                            //marcaDao.actualizar(m2);
                                                            //marcaDao.delete(m1);
                                                            List<Marca> marcas = marcaDao.seleccionar();
                                                            for (Marca m :marcas) {
                                                                System.out.println(m.toString());
                                                                System.out.println("");
                                                            }
                                                        }catch (SQLException ex){
                                                            ex.printStackTrace(System.out);
                                                        }

                                                        break;
                                                case 5:
                                                        System.out.printf("\nVISUALIZAR CARRITOS \n\n");
                                                        try{
                                                            //TABLA CARRITO =======================================
                                                            //carritoDao.insertar(ca1); 
                                                            //carritoDao.actualizar(ca2);
                                                            //carritoDao.delete(ca1);
                                                            List<Carrito> carritos = carritoDao.seleccionar();
                                                            for (Carrito c :carritos) {
                                                                System.out.println(c.toString());
                                                                System.out.println("");
                                                            }


                                                        }catch (SQLException ex){
                                                            ex.printStackTrace(System.out);
                                                        }
                                                        break;
                                                case 0:
                                                    System.out.println("VOLVERA AL MENÚ");
                                                        break;
                                                default:
                                                        System.out.printf("\nElija entre 0 y 5\n\n");
                                                        break;
                                        }
                                        ent.nextLine();
                                        
                                }
                            
				break;
			case 2:
                                System.out.printf("\nAGREGAR \n\n");
				int opcion3=-1;
                                while(opcion3!=0){
                                        System.out.println("Que desea AGREGAR");
                                        System.out.printf("1.- USUARIOS \n");
                                        System.out.printf("2.- PRODUCTOS \n");
                                        System.out.printf("3.- MARCAS \n");
                                        System.out.printf("4.- CATEGORIAS \n");
                                        System.out.printf("5.- COMPRA \n");
                                        System.out.printf("0.- SALIR\n");
                                        opcion3 = ent.nextInt();
                                        switch(opcion3){
                                                case 1:
                                                        System.out.printf("\nAGREGAR USUSARIOS \n\n");
                                                        añadirUsuario();
                                                        break;
                                                case 2:
                                                        System.out.printf("\nAGREGAR PRODUCTOS \n\n");
                                                        instanciarProducto();
                                                        break;
                                                case 3:
                                                        System.out.printf("\nAGREGAR MARCAS\n\n");
                                                        instanciarMarca();
                                                        break;
                                                case 4:
                                                        System.out.printf("\nAGREGAR CATEGORIAS \n\n");
                                                        instanciarCategoria();
                                                        break;
                                                case 5:
                                                        System.out.printf("\nAGREGAR CARRITOS \n\n");
                                                        instanciarCarrito();
                                                        break;
                                                case 0:
                                                        System.out.println("VOLVERA AL MENÚ");
                                                        break;
                                                default:
                                                        System.out.printf("\nElija entre 0 y 5\n\n");
                                                        break;
                                        }
                                        ent.nextLine();
                                        
                                }
                                break;
                                
			case 3:
				System.out.printf("\nBUSCAR \n\n");
				int opcion4=-1;
                                while(opcion4!=0){
                                        System.out.println("Que desea BUSCAR");
                                        System.out.printf("1.- USUARIOS \n");
                                        System.out.printf("2.- PRODUCTOS \n");
                                        System.out.printf("3.- MARCAS \n");
                                        System.out.printf("4.- CATEGORIAS \n");
                                        System.out.printf("5.- COMPRA \n");
                                        System.out.printf("0.- SALIR\n");
                                        opcion4 = ent.nextInt();
                                        switch(opcion4){
                                                case 1:
                                                        System.out.printf("\nBUSCAR USUSARIOS \n\n");
                                                        buscarUsuario();
                                                        break;
                                                case 2:
                                                        System.out.printf("\nBUSCAR PRODUCTOS \n\n");
                                                        buscarProducto();
                                                        break;
                                                case 3:
                                                        System.out.printf("\nBUSCAR MARCAS\n\n");
                                                        buscarMarca();
                                                        break;
                                                case 4:
                                                        System.out.printf("\nBUSCAR CATEGORIAS \n\n");
                                                        buscarCategoria();
                                                        break;
                                                case 5:
                                                        System.out.printf("\nBUSCAR CARRITOS \n\n");
                                                        buscarCompra();
                                                        break;
                                                case 0:
                                                        System.out.println("VOLVERA AL MENÚ");
                                                        break;
                                                default:
                                                        System.out.printf("\nElija entre 0 y 5\n\n");
                                                        break;
                                        }
                                        ent.nextLine();
                                      
				
				
                                }
                                break;
			case 4:
				System.out.printf("\nELIMINAR \n\n");
				int opcion5=-1;
                                while(opcion5!=0){
                                        System.out.println("Que desea ELIMINAR");
                                        System.out.printf("1.- USUARIOS \n");
                                        System.out.printf("2.- PRODUCTOS \n");
                                        System.out.printf("3.- MARCAS \n");
                                        System.out.printf("4.- CATEGORIA \n");
                                        System.out.printf("5.- COMPRA \n");
                                        System.out.printf("0.- SALIR\n");
                                        opcion5 = ent.nextInt();
                                        switch(opcion5){
                                                case 1:
                                                        System.out.printf("\nELIMINAR USUSARIOS \n\n");
                                                        borrarUsuario();
                                                        break;
                                                case 2:
                                                        System.out.printf("\nELIMINAR PRODUCTOS \n\n");
                                                        borrarProducto();
                                                        break;
                                                case 3:
                                                        System.out.printf("\nELIMINAR MARCAS\n\n");
                                                        borrarMarca();
                                                        break;
                                                case 4:
                                                        System.out.printf("\nMODIFICAR CATEGORIAS \n\n");
                                                        borrarCategoria();
                                                        break;
                                                case 5:
                                                        System.out.printf("\nELIMINAR CARRITOS \n\n");
                                                        borrarCarrito();
                                                        break;
                                                case 0:
                                                        System.out.println("VOLVERA AL MENÚ");
                                                        break;
                                                default:
                                                        System.out.printf("\nElija entre 0 y 5\n\n");
                                                        break;
                                        }
                                        ent.nextLine();
                                        
                                
				
                                }
                                break;
                        case 5:
				int opcion6=-1;
                                while(opcion6!=0){
                                        System.out.println("Que desea MODIFICAR");
                                        System.out.printf("1.- USUARIOS \n");
                                        System.out.printf("2.- PRODUCTOS \n");
                                        System.out.printf("3.- MARCAS \n");
                                        System.out.printf("4.- CATEGORIA \n");
                                        System.out.printf("5.- COMPRA \n");
                                        System.out.printf("0.- SALIR\n");
                                        opcion6 = ent.nextInt();
                                        switch(opcion6){
                                                case 1:
                                                        System.out.printf("\nMODIFICAR USUSARIOS \n\n");
                                                        modUsuario();
                                                        break;
                                                case 2:
                                                        System.out.printf("\nMODIFICAR PRODUCTOS \n\n");
                                                        modProducto();
                                                        break;
                                                case 3:
                                                        System.out.printf("\nMODIFICAR MARCAS\n\n");
                                                        modMarca();
                                                        break;
                                                case 4:
                                                        System.out.printf("\nMODIFICAR CATEGORIAS \n\n");
                                                        modCategoria();
                                                        break;
                                                case 5:
                                                        System.out.printf("\nMODIFICAR CARRITOS \n\n");
                                                        modCarrtio();
                                                        break;
                                                case 0:
                                                        System.out.println("VOLVERA AL MENÚ");
                                                        break;
                                                default:
                                                        System.out.printf("\nElija entre 0 y 5\n\n");
                                                        break;
                                        }
                                        ent.nextLine();
                                       
                                
				
                                }
                                break;
			case 0:
                                System.out.println("Gracias por usar la aplicacion");
				break;
			default:
				System.out.printf("\nElija entre 0 y 3\n\n");
				break;
		}
                ent.nextLine();
                
                
		
	}
    
        /*try{
            //TABLA USUARIO =======================================
            //usuarioDao.insertar(u1); 
            usuarioDao.actualizar(u2);
            //usuarioDao.delete(u1);
            List<Usuario> usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario ->{
                System.out.println("Usuario = "+usuarios);
                System.out.println("");
            
            });
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        try{
            //TABLA CATEGORIA =======================================
            //categoriaDao.insertar(c1);
            //categoriaDao.actualizar(c2);
            //categoriaDao.delete(c1);
            List<Categoria> categorias = categoriaDao.seleccionar();
            categorias.forEach(categoria ->{
                System.out.println("Categoria = "+categoria);
                System.out.println("");
            
            });
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        try{
            //TABLA PRODUCTO =======================================
            //productoDao.insertar(p1);
            productoDao.actualizar(p2);
            //productoDao.delete(p1);
            List<Producto> productos = productoDao.seleccionar();
            productos.forEach(producto ->{
                System.out.println("Producto = "+producto);
                System.out.println("");
            
            });
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        try{
            //TABLA MARCA =======================================
            //marcaDao.insertar(m1); 
            marcaDao.actualizar(m2);
            //marcaDao.delete(m1);
            List<Marca> marcas = marcaDao.seleccionar();
            marcas.forEach(usuario ->{
                System.out.println("Marcas = "+marcas);
                System.out.println("");
            
            });
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        try{
            //TABLA CARRITO =======================================
            //carritoDao.insertar(ca1); 
            carritoDao.actualizar(ca2);
            //carritoDao.delete(ca1);
            List<Carrito> carritos = carritoDao.seleccionar();
            carritos.forEach(usuario ->{
                System.out.println("Compra = "+carritos);
                System.out.println("");
            
            });
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }*/
        
        
    }
    public static void añadirUsuario() throws FileNotFoundException{
        String DNI;
        String contra;
        String email;
        String nom;
        String apell;
        String direc;
        String telf;
        String ima;
        System.out.println("Introduzca el DNI: ");
        ent.nextLine();
        DNI = ent.nextLine();
        System.out.println("Introduzca la contraseña: ");
        contra = ent.nextLine();
        System.out.println("Introduzca su email: ");
        email = ent.nextLine();
        System.out.println("Introduzca su nombre: ");
        nom = ent.nextLine();
        System.out.println("Introduzca sus apellidos: ");
        apell = ent.nextLine();
        System.out.println("Introduzca su direccion: ");
        direc = ent.nextLine();
        System.out.println("Introduzca su telefono: ");
        telf = ent.nextLine();
        System.out.println("Introduzca la ruta de la imagen deseada: ");
        ima = ent.nextLine();
        Usuario u = new Usuario(DNI,contra,email,nom,apell,direc,telf,ima);
        usuarioDao.insertar(u);
        System.out.println("El usuario ha sido creado con exito");
        //en el stock las columnas representan el ID, nombre y precio
        
    }
    public static void instanciarProducto(){
        String nom;
        String tipo;
        double precio;
        System.out.println("Introduzca el nombre del producto que va a desear: ");
        ent.nextLine();
        nom = ent.nextLine();
        System.out.println("Tipo del producto:  ");
        tipo = ent.nextLine();
        System.out.println("Introduzca su precio, recuerde que los decimales se escriben con una coma y NO un punto: ");
        precio = ent.nextDouble();
        Producto p = new Producto(nom,tipo,precio);
        productoDao.insertar(p);
        System.out.println("El producto ha sido insertado en el catálogo de manera satisfactoria");
        archivos.agregarArchivo("Stock.txt",p.getNombre()+"|"+p.getTipo()+"|"+p.getPrecio());
        archivos.agregarArchivo("Stock.txt", "\n");
        
    }
    public static void instanciarCategoria(){
        String nom;
        String desc;
        Date fecha;
        fecha=sqlDate;
        System.out.println("Introduzca el nombre de la categoria: ");
        ent.nextLine();
        nom = ent.nextLine();
        System.out.println("introduzca una breve descripcion:  ");
        desc = ent.nextLine();
        Categoria c = new Categoria(nom,desc,fecha);
        categoriaDao.insertar(c);
        System.out.println("La categoria ha sido registrada con exito");
        //en el stock las columnas representan el ID, nombre y precio
        
    }
    public static void instanciarMarca(){
        String nom;
        String tipo;
        Date fecha;
        fecha=sqlDate;
        System.out.println("Introduzca el nombre de la marca: ");
        ent.nextLine();
        nom = ent.nextLine();
        System.out.println("introduzca el tipo:  ");
        tipo = ent.nextLine();
        Marca m = new Marca(nom,tipo,fecha);
        marcaDao.insertar(m);
        System.out.println("La marca ha sido insertada de manera satisfactoria");
        //en el stock las columnas representan el ID, nombre y precio
        
    }
    public static void instanciarCarrito(){
        Date fecha;
        fecha=sqlDate;
        String DNI;
        Boolean pagado;
        double precio;
        System.out.println("Introduzca su DNI (recuerde que si no esta registrado no podrá realizar ninguna compra: ");
        ent.nextLine();
        DNI = ent.nextLine();
        System.out.println("Introduzca el total a pagar; ");
        precio = ent.nextDouble();
        System.out.println("¿Ha pagado su pedido?  ");
        pagado = ent.nextBoolean();
        Carrito ca = new Carrito(fecha,precio,pagado,DNI);
        carritoDao.insertar(ca);
        System.out.println("El producto ha sido insertado en el catálogo de manera satisfactoria");
        //en el stock las columnas representan el ID, nombre y precio
        archivos.agregarArchivo("ordenes.txt","COMPRA---->"+ca.getDNI()+"|"+ca.getPrecio()+"€|"+ca.isPagado()+"|\n");
        
    }
    public static void borrarUsuario(){
        String DNI;
        System.out.println("Introduzca el DNI para borrar su usuario: ");
        ent.nextLine();
        DNI = ent.nextLine();
        Usuario u = new Usuario (DNI);
        usuarioDao.delete(u);
        System.out.println("El usuario ha sido eliminado");
        
    }
    public static void borrarProducto(){
        int idp;
        System.out.println("Introduzca el ID del producto para borrarlo: ");
        ent.nextLine();
        idp = ent.nextInt();
        Producto p = new Producto(idp);
        productoDao.delete(p);
        System.out.println("El producto ha sido eliminado");
        
    }
    public static void borrarCategoria(){
        int idc;
        System.out.println("Introduzca el ID para borrarla: ");
        ent.nextLine();
        idc = ent.nextInt();
        Categoria c = new Categoria (idc);
        categoriaDao.delete(c);
        System.out.println("La categoria ha sido eliminada");
        
    }
    public static void borrarMarca(){
        int idm;
        System.out.println("Introduzca el ID de la marca para borrarla: ");
        ent.nextLine();
        idm = ent.nextInt();
        Marca m = new Marca (idm);
        marcaDao.delete(m);
        System.out.println("La marca ha sido eliminada");
        
    }
    public static void borrarCarrito(){
        int idca;
        System.out.println("Introduzca el ID de la comra para borrarla: ");
        ent.nextLine();
        idca = ent.nextInt();
        Carrito ca = new Carrito (idca);
        carritoDao.delete(ca);
        System.out.println("La compra ha sido eliminada");
        
    }
    
    public static void buscarUsuario() throws SQLException,IOException{
        List<Usuario> usuarios = usuarioDao.seleccionar();
        String DNI;
        System.out.println("Introduzca el DNI del usuario que quiera buscar");
        ent.nextLine();
        DNI = ent.nextLine();
        System.out.println("Su usuario es el siguiente: ");
        for(Usuario u :usuarios){
            if (u.getDNI().equalsIgnoreCase(DNI)) {
                System.out.println(u.toString());
   
            }
        }
    }
    
    public static void buscarProducto() throws SQLException,IOException{
        List<Producto> productos = productoDao.seleccionar();
        String tipo;
        System.out.println("Introduzca el tipo de producto que quiere buscar");
        ent.nextLine();
        tipo = ent.nextLine();
        System.out.println("Hay estos productos del tipo seleccionado: ");
        for(Producto p :productos){
            if (p.getTipo().equalsIgnoreCase(tipo)) {
                System.out.println(p.toString());
   
            }
        }
    }
    public static void buscarMarca() throws SQLException,IOException{
        List<Marca> marcas = marcaDao.seleccionar();
        String nombre;
        System.out.println("Introduzca la marca que quiere buscar");
        ent.nextLine();
        nombre = ent.nextLine();
        System.out.println("Hay estos productos del tipo seleccionado: ");
        for(Marca m :marcas){
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(m.toString());
   
            }
        }
    }
    public static void buscarCategoria() throws SQLException,IOException{
        List<Categoria> categorias = categoriaDao.seleccionar();
        String nombre;
        System.out.println("Introduzca el nombre de la categoria que quiere buscar");
        ent.nextLine();
        nombre = ent.nextLine();
        System.out.println("Hay estos productos de la categoria seleccionada: ");
        for(Categoria c :categorias){
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(c.toString());
   
            }
        }
    }
    
    
    public static void buscarCompra() throws SQLException,IOException{
        List<Carrito> carritos = carritoDao.seleccionar();
        String DNI;
        System.out.println("Introduzca el DNI del usuario que ha realizado la compra: ");
        ent.nextLine();
        DNI = ent.nextLine();
        System.out.println("Esta es la compra realizada: ");
        for(Carrito ca :carritos){
            if (ca.getDNI().equalsIgnoreCase(DNI)) {
                System.out.println(ca.toString());
   
            }
        }
    }
    public static void modUsuario() throws FileNotFoundException{
        String DNI;
        String contra;
        String email;
        String nom;
        String apell;
        String direc;
        String telf;
        String ima;
        System.out.println("Introduzca el DNI del usuario que desea modificar: ");
        ent.nextLine();
        DNI = ent.nextLine();
        System.out.println("Introduzca la contraseña: ");
        contra = ent.nextLine();
        System.out.println("Introduzca su email: ");
        email = ent.nextLine();
        System.out.println("Introduzca su nombre: ");
        nom = ent.nextLine();
        System.out.println("Introduzca sus apellidos: ");
        apell = ent.nextLine();
        System.out.println("Introduzca su direccion: ");
        direc = ent.nextLine();
        System.out.println("Introduzca su telefono: ");
        telf = ent.nextLine();
        System.out.println("Introduzca la ruta de la imagen deseada: ");
        ima = ent.nextLine();
        Usuario u = new Usuario(DNI,contra,email,nom,apell,direc,telf,ima);
        usuarioDao.actualizar(u);
        System.out.println("El usuario ha sido modificado con exito");
        //en el stock las columnas representan el ID, nombre y precio
        
    }
    public static void modProducto(){
        int idp;
        String nom;
        String tipo;
        double precio;
        System.out.println("Introduzca el id del producto que va a cambiar: ");
        idp=ent.nextInt();
        System.out.println("Introduzca el nuevo nombre del producto");
        nom = ent.nextLine();
        ent.nextLine();
        System.out.println("Tipo del producto:  ");
        tipo = ent.nextLine();
        ent.nextLine();
        System.out.println("Introduzca su precio, recuerde que los decimales se escriben con una coma y NO un punto: ");
        precio = ent.nextDouble();
        ent.nextLine();
        Producto p = new Producto(idp,nom,tipo,precio);
        productoDao.actualizar(p);
        System.out.println("El producto ha sido modificado con exito");
        //en el stock las columnas representan el ID, nombre y precio
        
    }
    public static void modCategoria(){
        int idc;
        String nom;
        String desc;
        Date fecha;
        fecha=sqlDate;
        System.out.println("Introduzca el id de la categoria que va ha modificar: ");
        idc=ent.nextInt();
        ent.nextLine();
        System.out.println("Introduzca el nuevo nombre de la categoria");
        nom = ent.nextLine();
        ent.nextLine();
        System.out.println("introduzca una breve descripcion:  ");
        desc = ent.nextLine();
        ent.nextLine();
        Categoria c = new Categoria(idc,nom,desc,fecha);
        categoriaDao.actualizar(c);
        System.out.println("La categoria ha sido actualizado de manera satisfactoria");
        //en el stock las columnas representan el ID, nombre y precio
        
    }
    public static void modMarca(){
        int idm;
        String tipo;
        String nom;
        String desc;
        Date fecha;
        fecha=sqlDate;
        System.out.println("Introduzca el id de la MARCA que va ha modificar: ");
        idm=ent.nextInt();
        ent.nextLine();
        System.out.println("Introduzca el nuevo nombre de la marca");
        nom = ent.nextLine();
        ent.nextLine();
        System.out.println("Introduzca el nuevo tipo de la marca");
        tipo = ent.nextLine();
        ent.nextLine();
        Marca m = new Marca(idm,nom,tipo,fecha);
        marcaDao.actualizar(m);
        System.out.println("La categoria ha sido actualizado de manera satisfactoria");
        //en el stock las columnas representan el ID, nombre y precio
        
    }
    public static void modCarrtio(){
        int idc;
        Date fecha;
        fecha=sqlDate;
        String DNI;
        Boolean pagado;
        double precio;
        System.out.println("Introduzca el id de la compra que quiere modificar");
        idc=ent.nextInt();
        ent.nextLine();
        DNI = ent.nextLine();
        System.out.println("Introduzca el total a pagar: ");
        precio = ent.nextDouble();
        System.out.println("¿Ha pagado su pedido?  ");
        pagado = ent.nextBoolean();
        Carrito ca = new Carrito(idc,fecha,precio,pagado,DNI);
        carritoDao.insertar(ca);
        System.out.println("La compra ha sido actualizada de manera satisfactoria");
    }
    
    /*public static void iniAdmin() throws FileNotFoundException{
        String DNI;
        String contra;
        System.out.println("Introduzca su DNI");
        DNI=ent.nextLine();
        ent.nextLine();
        System.out.println("Introduzca la contraseña");
        contra=ent.nextLine();
        ent.nextLine();
        
        if (DNI=="02572633Z" && contra=="123456789"){
            System.out.println("Bienvenido Anibal");
        }else{
            System.out.println("Usted no es admin");
            }
        }*/
        
        
}
