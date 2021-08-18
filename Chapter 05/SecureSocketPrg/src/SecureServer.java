
import java.io.DataInputStream;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class SecureServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(1000);
SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();
DataInputStream dis=new DataInputStream(sslsocket.getInputStream());
String str = dis.readUTF();
System.out.println(str);
sslsocket.close();
} catch (Exception e) {
        System.out.println(e);
}
}
    }
    

