
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bala
 */
public class Server {
     public static void main(String sd[]){
        try{
            ServerSocket s=new ServerSocket(1000);
            Socket c;
            while(true){
                c=s.accept();
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/TCP","bala","bala");
                Statement sta=con.createStatement();
           
            DataInputStream in=new DataInputStream(c.getInputStream());
            DataOutputStream out=new DataOutputStream(c.getOutputStream());
            int ch=in.readInt();
            int sno;
            String sname,sql;
            long ph;
            switch(ch){
                case 1:
                        sno=in.readInt();
                        sname=in.readUTF();
                        ph=in.readLong();
                        sql = "insert into student values("+sno+", '" + sname + "' , " + ph + ")";
                        System.out.println(sql);
                        sta.executeUpdate(sql);
                        out.writeUTF("Your record Inserted");
                         break;
                case 2:
                        sno=in.readInt();
                        sname=in.readUTF();
                        ph=in.readLong();
                        sql = "update student set SNAME='" + sname + "' , PHONE=" + ph + "where SNO =" + sno;
                        System.out.println(sql);
                        sta.executeUpdate(sql);
                        out.writeUTF("Your record Updated");
                        break;
                case 3:
                        sno=in.readInt();
                        sql = " delete  from student where SNO =" + sno;
                        System.out.println(sql);
                        sta.executeUpdate(sql);
                         out.writeUTF("Your record Deleted");
                        break;
                case 4:
                        sno=in.readInt();
                        sql ="select * from student where sno=" + sno;
                        System.out.println(sql);
                        ResultSet rs=sta.executeQuery(sql);
                        while(rs.next()){
                            out.writeInt(rs.getInt("sno"));
                            out.writeUTF(rs.getString("sname"));
                            out.writeLong(rs.getLong("phone"));
                        }
                       
                        break;
            }

           
           

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
