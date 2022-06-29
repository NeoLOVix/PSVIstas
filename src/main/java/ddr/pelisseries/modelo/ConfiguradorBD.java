//Creamos clase de tipo Singleton donde se configura los datos de conexión a la BBDD

package ddr.pelisseries.modelo;

public  class ConfiguradorBD {

    private String database;
    private String host;
    private String puerto;
    private String url;
    private String username;
    private String password;
    private static ConfiguradorBD miconfigurador;
    
    
    private ConfiguradorBD(){
        this.database = "pelisseries";
        this.host = "localhost";
        this.puerto = "3306";
        this.url = "jdbc:mysql://" + host + ":" + puerto + "/" + database;
        this.username = "root";
        this.password = "";        
    }
    
    public static ConfiguradorBD getConfiguradorBD(){
        
        if (miconfigurador == null) {
            miconfigurador = new ConfiguradorBD();
        }
        return miconfigurador;              
    }
    
    public String getDatabase() {
        return database;
    }

    public String getHost() {
        return host;
    }

    public String getPuerto() {
        return puerto;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}