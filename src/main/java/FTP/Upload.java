package FTP;

import java.io.FileInputStream;
import java.io.IOException;
 
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
 
public class Upload {
 
    public static void main(String[] args) {
 
        // Creando nuestro objeto ClienteFTP
        FTPClient client = new FTPClient();
 
        // Datos para conectar al servidor FTP
        String ftp = "ftp.miservidor.com"; // También puede ir la IP
        String user = "usuario";
        String password = "password";
 
        try {
            // Conactando al servidor
            client.connect(ftp);
 
            // Logueado un usuario (true = pudo conectarse, false = no pudo
            // conectarse)
            boolean login = client.login(user, password);
 
            client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
            client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            client.enterLocalPassiveMode();
 
            String filename = "miarchivo.txt";
 
            FileInputStream fis = new FileInputStream(filename);
 
            // Guardando el archivo en el servidor
            client.storeFile(filename, fis);
 
            // Cerrando sesión
            client.logout();
 
            // Desconectandose con el servidor
            client.disconnect();
 
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}