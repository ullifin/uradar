/*
 * RadarGUI.java
 *
 * Created on 4. Juni 2007, 23:59
 */

package radarwonline;

import java.net.*;
import javax.swing.*;
import java.util.Date;
import com.digitprop.tonic.TonicLookAndFeel;
import java.awt.MediaTracker;
import java.awt.Point;
import java.util.Calendar;
import java.util.prefs.Preferences;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * tdo: 
 *      *automatic tracker, checkt nach neuen Bild, regelmäßig
 *      *nodata-bild muss zum ausschnitt passen
 *      *Click auf Rand des Bildes spricgt zum nächsten Teilgebiet 
 *          (dazu muss pro gebiet ein satz mit Nachbargeb. existieren, 
 *            oder teilmaps pro gebiet definieren (ähnlich map in html?))
 *      *animation: mit anfang, ende, speed, etc (als extra control, oder overlayfenster)
 *        export der ani?
 *      *configuration mit Preferences (in die registry) 
 *      *grenzdaten gebietsdaten dummybilder, addressen als ressources
 *           ebenso bildgrößen
 *      *als applet?
 * @author  finke
 */
public class RadarGUI extends javax.swing.JFrame {
    
    /** Creates new form RadarGUI      */
    public RadarGUI() {
         try {
             UIManager.setLookAndFeel(new TonicLookAndFeel());
             SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {}
         catch (Exception e){}
        
        initComponents();
        spTime.setModel(spmodel);
        cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -10);
        spmodel.setValue(cal.getTime());

        cbGebiete.setModel(comboModel);
        
        prefs= Preferences.userNodeForPackage(this.getClass());
        comboModel.setSelectedItem(prefs.get("Gebiet", "Niedersachsen"));
        
        setIconImage(new ImageIcon("fd.jpg").getImage());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbPic = new javax.swing.JLabel();
        btExit = new javax.swing.JButton();
        btGet = new javax.swing.JButton();
        lbOk = new javax.swing.JLabel();
        spTime = new javax.swing.JSpinner();
        cbGebiete = new javax.swing.JComboBox();
        btNow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Das Aktuelle Radar-Bild von Wetter-Online.de");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DWD-Radar"));

        lbPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/radarwonline/nodatapic.gif"))); // NOI18N
        lbPic.setToolTipText("Click to change into that region");
        lbPic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPicMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPic)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbPic)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        btGet.setText("Get");
        btGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetActionPerformed(evt);
            }
        });

        lbOk.setText("ok");
        lbOk.setToolTipText("(cc) U. Finke");

        spTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.MINUTE));
        spTime.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spTimeStateChanged(evt);
            }
        });

        cbGebiete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baden-Württemberg", "Bayern", "Brandenburg/Berlin", "Mecklenburg-Vorpommern", "Niedersachsen/Bremen", "Nordrhein-Westfalen", "Rheinland-Pfalz", "Sachsen", "Sachsen-Anhalt", "Schleswig-Holstein", "Thüringen" }));
        cbGebiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGebieteActionPerformed(evt);
            }
        });

        btNow.setText("Now");
        btNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbOk))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btGet)
                        .addGap(40, 40, 40)
                        .addComponent(btNow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spTime, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbGebiete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btExit, btGet});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExit)
                    .addComponent(btGet)
                    .addComponent(cbGebiete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNow))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetActionPerformed

        Date d = (Date)spTime.getValue();
        String fname = generateName(d)+".gif";
        ImageIcon ic = null;
        try {
            URL imageurl = new URL(webaddress+gebDirname+fname);
            ic = new ImageIcon(imageurl);
        } catch (MalformedURLException ex) {System.out.println(ex);}
        
        if (ic.getImageLoadStatus()==MediaTracker.COMPLETE) lbPic.setIcon(ic);
        else lbPic.setIcon(dummypic);
        
    }//GEN-LAST:event_btGetActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        //set preferencies
        prefs.put("Gebiet", (String)cbGebiete.getSelectedItem());
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void spTimeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spTimeStateChanged
        btGetActionPerformed(null);
    }//GEN-LAST:event_spTimeStateChanged

    private void cbGebieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGebieteActionPerformed
        gebDirname=gebietsTag[cbGebiete.getSelectedIndex()];
        //tdo: auch nodatapic anpassen
        btGetActionPerformed(evt);
    }//GEN-LAST:event_cbGebieteActionPerformed

    private void btNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNowActionPerformed
        //spTime.setValue(new Date(new Date().getTime()-(2L*60+10)*60*1000) );
        spTime.setValue(new Date());
    }//GEN-LAST:event_btNowActionPerformed

    private void lbPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPicMouseClicked
        //get point
        Point p = evt.getPoint();
        lbOk.setText(p.toString());
    }//GEN-LAST:event_lbPicMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RadarGUI().setVisible(true);
            }
        });
    }

        
//    private long truncIt(long date, int calendarField, int increment){
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(date);
//        int m = (cal.get(calendarField)/increment)*increment;
//        cal.set(calendarField, m);
//        return cal.getTimeInMillis();
//    }
    
    /**
     * Creates name string containing year/month/day/time
     *  is set to GMT and to multiples of 15min
     * @param date in Date
     * @return string with date separated by / directory-separators
     */      
    private String generateName(Date date) {
        int calendarField = Calendar.MINUTE;
        int increment = 15;
        //set to gmt -> -2hours
        cal.setTime(date);
        cal.add(Calendar.HOUR, -2);
        //trunc auf volle 15-min
        int m = (cal.get(calendarField)/increment)*increment;
        cal.set(calendarField, m);
        return String.format("%1$tY/%1$tm/%1$td/%1$tH%1$tM", cal.getTime());
     }
    
    private Preferences prefs;
    
    private Calendar cal;
    
    private String webaddress = "http://www.wetteronline.de/daten/radar/";
    
    private String[] gebietsNamen = new String[] {"Deutschland","Baden-Württemberg","Bayern","Brandenburg/Berlin",
        "Hessen","Mecklenburg-Vorpommern","Niedersachsen","Nordrhein-Westfalen","Rheinland-Pfalz",
        "Sachsen","Sachsen-Anhalt","Schleswig-Holstein","Thüringen"};
    private String[] gebietsTag   = new String[] {"dwddg/","dbad/","dbay/","dber/","dhes/","dmec/","dnie/",
        "dnrw/","drlp/","dsac/","dsan/","dsch/","dtue/"};
    private String gebDirname = gebietsTag[0];
    
    private ImageIcon dummypic = new ImageIcon(getClass().getResource("/radarwonline/nodatapic.gif"));
    
    private MySpinnerModel spmodel = new MySpinnerModel(Calendar.MINUTE, 15);
        
    private DefaultComboBoxModel comboModel = new DefaultComboBoxModel(gebietsNamen); 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btGet;
    private javax.swing.JButton btNow;
    private javax.swing.JComboBox cbGebiete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbOk;
    private javax.swing.JLabel lbPic;
    private javax.swing.JSpinner spTime;
    // End of variables declaration//GEN-END:variables
    
    /**
     * SpinnerModel, with settable inc/decrements in 
     *   endtime is now, which is updated with getNextValue
     */
    class MySpinnerModel extends SpinnerDateModel{
        private Calendar cal = Calendar.getInstance();
        private int calField;
        private int increment;

        /**
         * 
         * @param calendarField CalendarField to be incremented e.g. Calendar.MINUTE
         * @param increment increment
         */
        public MySpinnerModel(int calendarField, int increment) {
            super();
            this.calField=calendarField;
            this.increment=increment;
        }
        
        /**
         * Truncates the date to integer multipliers of the calendarfield, e.g. 15minutes
         * @param date input date (millisec)
         * @param calendarField 
         * @param incr
         * @return truncated date (millisec)
         */
        private long truncDateLong(long date, int calendarField, int incr){
            cal.setTimeInMillis(date);
            int m = (cal.get(calendarField)/incr)*incr;
            cal.set(calendarField, m);
            return cal.getTimeInMillis();
        }
        
        /**
         * Truncates the date 
         * @param date input date (Date)
         * @param calendarField
         * @param incr
         * @return the truncated Date-object (new)
         */
        private Date truncDate(Date date, int calendarField, int incr){
            Date d = (Date) date;
            long t = truncDateLong(d.getTime(), calendarField, incr); 
            return new Date(t);
        }
        
        @Override
        public void setStart(Comparable start) {
            Date d = (Date) start;
            Date date = truncDate(d, calField, increment);
            super.setStart(date);
        }

        @Override
        public void setValue(Object value) {
            super.setValue(truncDate((Date)value, calField, increment));
        }

        /**
         * Next Value; Each  call sets Endtime to Now
         * @return 
         */
        @Override
        public Object getNextValue() {
            cal.setTime(truncDate(getDate(), calField, increment));
            cal.add(calField, increment);
            Date next = cal.getTime();
            setEnd(new Date());
            return ((getEnd() == null) || (getEnd().compareTo(next) >= 0)) ? next : null; 
        }
        
        @Override
        public Object getPreviousValue() {
            cal.setTime(truncDate(getDate(), calField, increment));
            cal.add(calField, -increment);
            Date prev = cal.getTime();
            return ((getStart() == null) || (getStart().compareTo(prev) <= 0)) ? prev : null; 
        }
        
    }
    
}