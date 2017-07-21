/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joset
 */

//Aqui haremos la conexion a la base de datos
class Conexion{
    //la conexion propiamente dicha
    private static Connection conn;
    /*
    Se deben especificar esta informacion que detalla el usuario, la contraseña y la informacion del servidor (ip , puerto, y nombre de la base de datos).
    
    */
    
    
    private static final String driver = "com.mysql.jdbc.Driver"; //driver (se queda siempre igual, si se usa mysql)
    private static final String usuario = "root"; //usuario de la base de datos
    private static final String contrasenna = ""; //contraseña del usuario
    private static final String url = "jdbc:mysql://localhost:3306/sakila"; //basicamnete es la informacion del servidor de la base deatos y es jdbc:mysql://(direccionIp):(puerto)/(nombreDeLaBaseDeDatos)
    
    
    /*
    Este metodo es el constructor del metodo Conexion y se hace de esta forma normalmente
    
    */
    
    public Conexion(){
        conn =null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, contrasenna);
            if ( conn != null){
                System.out.println("se ha realizado una conexion exitosa!");
            }
        }catch( ClassNotFoundException | SQLException e){
            System.out.println("ha sucecido un problema");
            e.printStackTrace();
        }
    }
    
    //Obtiene el objeto Connection que es el que se instancia para hacer los querys
    public Connection getConnection(){
        return this.conn;
    }
    
    //cierra la conexion con la base de datos 
    public void cerrarConexion() throws SQLException{
        conn.close();
    }
    
    
}
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    
    /*
    Ejemplo del select
    
    */
    
    public static void ejemploSelect(Connection instanciaConexion){
        try{
            //Query donde se hace el select
            String sql = "SELECT first_name , last_name FROM actor WHERE actor_id > 10 ;";
            //Objeto que prepara la conexion
            Statement  stmt = instanciaConexion.createStatement();
            //Es un tipo de dato iterable que almacena el resultado del query
            ResultSet rs = stmt.executeQuery(sql);

            //Se itera sobre el resultado del query
            if(rs.next()){
                do{     
                    //Obtiene el segundo campo del query resultante.
                    System.out.println(rs.getString(2));
                    //Obtiene los valores que le pertenecen al campo de nombre first_name
                    System.out.println(rs.getString("first_name"));
                }while(rs.next());
            } 
            
        }catch( SQLException e){
            System.out.println("ha sucecido un problema");
            e.printStackTrace();
        }
        
    }
    
    /*
    Ejemplo del insert
    (Los insert , update , y delete se hacen de la misma forma )
    //Forma de hacer con los signos de interrogacion
    */
    public static void ejemploInsert(Connection instanciaConexion){
        try{
            //
            String sql = "INSERT INTO actor( first_name , last_name , last_update ) VALUES ( ?, ?, ?)";
            PreparedStatement  stmt = instanciaConexion.prepareStatement(sql);
            //Cada uno de los signos de interrogacion , representa cada uno de los signos de interrogacion del query.
            stmt.setString(1, "jose");
            stmt.setString(2, "viteri");
            stmt.setString(3, "2012-06-13 04:02:21");
            //ejecuta el query y da un result de las filas ingresadas
            int filasIngresadas = stmt.executeUpdate();
            if (filasIngresadas > 0) {
                System.out.println("Se ha ingresado "+ filasIngresadas+ " un actor");
            }

            
        }catch( SQLException e){
            System.out.println("ha sucecido un problema");
            e.printStackTrace();
        }
        
    }
    
    /*
    Ejemplo del update
    (Los insert , update , y delete se hacen de la misma forma )
    //Forma de hacerco quemando los datos en el qyery
    */
    public static void ejemploUpdate(Connection instanciaConexion){
        try{
            //Se hace el query con los datos quemados en el
            String sql = "UPDATE actor SET first_name='antonio' WHERE last_name='viteri';";
            PreparedStatement stmt = instanciaConexion.prepareStatement(sql);
            //stmt.setString(1, "antonio");
            //stmt.setString(2, "viteri");
            int filasActualizar = stmt.executeUpdate(sql);
            if (filasActualizar> 0) {
                System.out.println("Se han actualizado "+ filasActualizar+ " actor/es");
            }
        }catch( SQLException e){
            System.out.println("ha sucecido un problema");
            e.printStackTrace();
        }
        
    }
    /*
    Ejemplo del delete
    (Los insert , update , y delete se hacen de la misma forma )
    
    */
    
    public static void ejemploDelete(Connection instanciaConexion){
        try{
            String sql = "DELETE FROM actor WHERE last_name='viteri';";
            PreparedStatement stmt = instanciaConexion.prepareStatement(sql);
            //stmt.setString(1, "viteri");
            int filasBorradas = stmt.executeUpdate(sql);
            if (filasBorradas> 0) {
                System.out.println("Se han borrado "+ filasBorradas+ " actor/es");
            }
            

        }catch( SQLException e){
            System.out.println("ha sucecido un problema");
            e.printStackTrace();
        }       
    }
    

    
    
    
    
    
    /*
    
    
    main
    */
    public static void main(String[] args) {
        
        Conexion haciendoConexion = new Conexion();
        Connection instanciaConexion = haciendoConexion.getConnection();
        
        
        
        
        //ejemplo select

        ejemploSelect(instanciaConexion);
        ejemploInsert(instanciaConexion);
        ejemploUpdate(instanciaConexion);
        ejemploDelete(instanciaConexion);

        
        // TODO code application logic here
    }
    
}
