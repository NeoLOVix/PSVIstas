package ddr.pelisseries.modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public  class ConexionBD {

    public  static Connection conn;
    

    public Connection conectarBD() {
        
        //llamada a clase tipo Singleton
        ConfiguradorBD c = ConfiguradorBD.getConfiguradorBD();
             
        try {
                      
            conn = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
        
            if(conn!=null){
                System.out.println("Conectado Correctamente a la Base de Datos Local " + c.getDatabase());
            }else{
                System.err.println("Error conexion");
            }

        } catch (SQLException e) {
            System.err.println("Error de conexion: "+e);
        } catch (Exception e) {
            System.err.println("Error desconocido: "+e);
        }
        
        return conn;
    }

}