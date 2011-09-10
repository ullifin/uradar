/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radarwonline;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author finke
 */
public class TstCal {

    Preferences prefs;

    public void setPrefs() {
        //prefs = Preferences.userRoot().node(this.getClass().getName());
        prefs = Preferences.userNodeForPackage(this.getClass());
        String p1 = "Test1";
        String p2 = "Hallo";
        String p3 = "Temperatur";
        
        System.out.println(prefs.getBoolean(p1, true));
        System.out.println(prefs.get(p2, " Ich"));
        System.out.println(prefs.getInt(p3, 23));
        
        prefs.putInt(p3, 66);
        prefs.put(p2, "Wir");
        prefs.putBoolean(p1, false);
    }
       
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OutputStream os = null;
        try {
            TstCal test = new TstCal();
            test.setPrefs();
            os = new FileOutputStream("c:/ddd.xml");
            test.prefs.exportNode(os);
            os.close();
        } catch (BackingStoreException ex) {
            Logger.getLogger(TstCal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TstCal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(TstCal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
