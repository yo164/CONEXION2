import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MariaDBExample {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mariadb://localhost:3306/baloncesto";
        String usuario = "root";
        String contraseña = "";

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            sentencia = conexion.createStatement();

            String query = "SELECT * FROM socio";
            resultado = sentencia.executeQuery(query);

            while(resultado.next()){
                int socioID = resultado.getInt("socioID");
                String nombre = resultado.getString("nombre");
                int estatura = resultado.getInt("estatura");
                int edad = resultado.getInt("edad");
                String localidad = resultado.getString("localidad");

                System.out.println("ID Socio: " + socioID + " Nombre: " + nombre + " Estatura: " + estatura + " Edad: " + edad + " Localidad: " + localidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            try {
                if ( resultado != null) {
                    resultado.close();
                }
                if(sentencia != null) {
                    sentencia.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        

    }   
}
