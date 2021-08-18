/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileprg;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class FilePrg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            File f = new File("c:\\data");                   f.mkdir();
            System.out.println(f.isDirectory());
                   f = new File("c:\\data\\a.txt");       f.createNewFile();
            System.out.println(f.isFile());
            
            Writer wr=new FileWriter("c:\\data\\a.txt");
                        wr.write("This is my file content..…");
                        wr.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
