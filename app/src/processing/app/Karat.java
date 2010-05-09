package processing.app;

import java.io.*;

public class Karat {

   Base base;

       public void linusb() {
 
            try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec("./karatusb/karatusb.py"); 
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
                String line=null;
 
                while((line=input.readLine()) != null) {
                    System.out.println(line);
                }
 
                int exitVal = pr.waitFor();
                System.out.println("USB Monitor closed "+exitVal);
 
            } catch(Exception ex) {
                System.out.println(ex.toString());
                ex.printStackTrace();
            }
        }

       public void winusb() {
 
            try {
                Runtime rt = Runtime.getRuntime();
                //Process pr = rt.exec("cmd /c dir");
                Process pr = rt.exec("karatusb\\karatusb.exe");
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
 
                String line=null;
 
                while((line=input.readLine()) != null) {
                    System.out.println(line);
                }
 
                int exitVal = pr.waitFor();
                System.out.println("USB Monitor closed "+exitVal);
 
            } catch(Exception ex) {
                System.out.println(ex.toString());
                ex.printStackTrace();
            }
        }
}
