/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.viandwi24.asteroidguard;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import com.github.kevinsawicki.http.HttpRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;

/**
 *
 * @author viandwi24
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        animateComponents();
    }
    
    public void animateComponents() {
        // animate img planet1 bounce top and down
        Timer planet1Animation = createAnimationPlanet(ImgPlanet1);
        Timer planet2Animation = createAnimationPlanet(ImgPlanet2);
        Timer planet3Animation = createAnimationPlanet(ImgPlanet3);
        Timer planet4Animation = createAnimationPlanet(ImgPlanet4);

        // Animated Rocket
        JLabel rocket = ImgRocket;
        Timer rocketAnimation = new Timer();
        rocketAnimation.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                rocket.setLocation(rocket.getX() + 1, rocket.getY() - 1);
                if (rocket.getY() < (0 - rocket.getHeight())) {
                    rocket.setLocation(0 - rocket.getWidth(), rocket.getParent().getHeight() + rocket.getHeight());
                }
            }
        }, 0, 10);
    }

    public Timer createAnimationPlanet(JLabel planet) {
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            // rand true or false
            boolean up = Math.random() < 0.5;
            boolean left = Math.random() < 0.5;
            int initialY = planet.getY();
            int initialX = planet.getX();
            int maxAnimationPx = (int) (Math.random() * 100);
            @Override
            public void run() {
                int newY = planet.getY() + (up ? -1 : 1);
                int newX = planet.getX() + (left ? -1 : 1);
                up = (newY < initialY - maxAnimationPx) ? false : (newY > initialY + maxAnimationPx) ? true : up;
                left = (newX < initialX - maxAnimationPx) ? false : (newX > initialX + maxAnimationPx) ? true : left;
                planet.setLocation(newX, newY);
            }
        }, 0, 100);
        return t;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ImgPlanet4 = new javax.swing.JLabel();
        ImgPlanet3 = new javax.swing.JLabel();
        ImgPlanet2 = new javax.swing.JLabel();
        ImgPlanet1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ImgAsteroid1 = new javax.swing.JLabel();
        ImgAsteroid2 = new javax.swing.JLabel();
        ImgRocket = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText(" Asteroids Tracker");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 200, 40));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Exit");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 200, 40));

        ImgPlanet4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/planet-01.png"))); // NOI18N
        jPanel1.add(ImgPlanet4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 200, 210));

        ImgPlanet3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/planet-11.png"))); // NOI18N
        jPanel1.add(ImgPlanet3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 200, 210));

        ImgPlanet2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/planet-08.png"))); // NOI18N
        jPanel1.add(ImgPlanet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 200, 200));

        ImgPlanet1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/planet-13.png"))); // NOI18N
        jPanel1.add(ImgPlanet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 200, 210));

        jLabel5.setFont(new java.awt.Font("Silom", 0, 62)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GUARDS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 310, 70));

        jLabel6.setFont(new java.awt.Font("Silom", 0, 62)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ASTEROID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 310, 70));

        jLabel7.setFont(new java.awt.Font("Silom", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("by : viandwi24");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 100, 40));

        ImgAsteroid1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/70.png"))); // NOI18N
        jPanel1.add(ImgAsteroid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 40, 40));

        ImgAsteroid2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/100.png"))); // NOI18N
        jPanel1.add(ImgAsteroid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 90, 80));

        ImgRocket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/Rocket.png"))); // NOI18N
        jPanel1.add(ImgRocket, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 90, 80));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/viandwi24/asteroidguard/assets/background_space.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AsteroidTracker win = new AsteroidTracker();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel ImgAsteroid1;
    private javax.swing.JLabel ImgAsteroid2;
    private javax.swing.JLabel ImgPlanet1;
    private javax.swing.JLabel ImgPlanet2;
    private javax.swing.JLabel ImgPlanet3;
    private javax.swing.JLabel ImgPlanet4;
    private javax.swing.JLabel ImgRocket;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void init() {
        HttpRequest request = HttpRequest.get("https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=xWHjrzoCgaxPbqzw4Ak3pfukBPYSerUiTw1Gxbiu");
        String rawDataJson = request.body();
        JSONObject jsonObject = new JSONObject(rawDataJson);
        JSONObject nearEarthObjects = jsonObject.getJSONObject("near_earth_objects");
        
        // loop through each date
        Iterator<String> keys = nearEarthObjects.keys();
        while (keys.hasNext()) {
            String date = keys.next();
            JSONArray nearEarthObjectsOnDate = nearEarthObjects.getJSONArray(date);
            for (int i = 0; i < nearEarthObjectsOnDate.length(); i++) {
                JSONObject nearEarthObject = nearEarthObjectsOnDate.getJSONObject(i);
                String name = nearEarthObject.getString("name");
                String nasaJson = nearEarthObject.getString("nasa_jpl_url");
                Boolean isPotentiallyHazardous = nearEarthObject.getBoolean("is_potentially_hazardous_asteroid");
                Float absoluteMagnitude = nearEarthObject.getFloat("absolute_magnitude_h");
                JSONObject estimatedDiameter = nearEarthObject.getJSONObject("estimated_diameter");
                JSONObject kilometers = estimatedDiameter.getJSONObject("kilometers");
                Float estimatedDiameterMinKm = kilometers.getFloat("estimated_diameter_min");
                Float estimatedDiameterMaxKm = kilometers.getFloat("estimated_diameter_max");

                System.out.println(name);
                System.out.println(nasaJson);
                System.out.println(isPotentiallyHazardous);
                System.out.println(absoluteMagnitude);
                System.out.println(estimatedDiameterMinKm);
                System.out.println(estimatedDiameterMaxKm);
            }
        }
    }
}