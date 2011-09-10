/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radarwonline;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.*;

/**
 *
 * @author finke
 */
public class Gebiet {
    
    private String name;
    private HashMap<Rectangle,Gebiet> nachbarGebiete;

    public Gebiet(String name) {
        this.name = name;
        nachbarGebiete = new HashMap<Rectangle, Gebiet>();
    }

    @Override
    public String toString() {
        return name;
    }
    
    /**
     * Sucht das Nachbargebiet in dem der Punkt liegt, definiert durch die 
     *   Rechtecke
     * @param p
     * @return 
     */
    public Gebiet suchNachbarGebietfuerPunkt(Point p){
        Gebiet g = this;
        for (Rectangle r : nachbarGebiete.keySet()){
            if (r.contains(p)) g=nachbarGebiete.get(r);
        }
        return g;
    }
    
    public void setNachbar(Gebiet g, Rectangle r){
        nachbarGebiete.put(r, g);
    }
    
    public static void main(String[] args) {
        Gebiet nie =new Gebiet("Niedersachsen");
        Gebiet ber =new Gebiet("Brandenburg/Berlin");
        Gebiet nrw =new Gebiet("NRW");
        Gebiet sch =new Gebiet("Schleswig-Holstein");
        Gebiet hes =new Gebiet("Hessen");
        
        nie.setNachbar(hes, new Rectangle(0, 0, 100, 20));
        nie.setNachbar(sch, new Rectangle(0,70, 100, 100));
        nie.setNachbar(nrw, new Rectangle(0,20, 40, 70));
        
        System.out.println(hes.suchNachbarGebietfuerPunkt(new Point(50,50)));
        
    }
    
}
