/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radarwonline;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author finke
 */
public class TstResources {

    Properties resp;
            
    public void initres(){
        
        URL c = ClassLoader.getSystemResource("radarwonline/radardata.properties");
        System.out.println("URL "+c);
        InputStream in = null;
//        ClassLoader loader = ClassLoader.getSystemClassLoader();
//        in = loader.getResourceAsStream("radarwonline/radardata.properties");
//        in = ClassLoader.getSystemResourceAsStream("radarwonline/radardata.properties");
          in = getClass().getResourceAsStream("/radarwonline/radardata.properties");
        resp= new Properties();
        try {
            resp.load(in);
        } catch (IOException ex) {
            Logger.getLogger(TstResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try { in.close (); } catch (Throwable ignore) {}
        }
    }                    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TstResources t = new TstResources();
        t.initres();
        System.out.println(t.resp);
        
        String s = t.resp.getProperty("Gebiete");
        System.out.println(s);
        String[] gebs = s.split("[,]");
        System.out.println(Arrays.toString(gebs));
        System.out.println(gebs[1].trim());
        
        
    }
}
