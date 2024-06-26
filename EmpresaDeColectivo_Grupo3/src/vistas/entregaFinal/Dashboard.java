
package vistas.entregaFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import vistas.entregaFinal.ColectivoPresentacion;
import vistas.entregaFinal.buscarColectivos;
import vistas.entregaFinal.Principal;
import vistas.entregaFinal.buscarHorarios;
import vistas.entregaFinal.buscarRutas;
import vistas.entregaFinal.cargaDeColectivos;
import vistas.entregaFinal.HorarioPresentacion;
import vistas.entregaFinal.PasajePresentacion;
import vistas.entregaFinal.PasajeroPresentacion;
import vistas.entregaFinal.RutaPresentacion;

/**
 *
 * @author 54266
 */
public class Dashboard extends javax.swing.JFrame {

    
    public Dashboard() {
        initComponents();
        jLnombre.requestFocusInWindow();
        setDate();
        setLocationRelativeTo(null);
        mostrarPrincipal();
        
    }


   
    
    private void mostrarPrincipal() {
        Principal p1 = new Principal();
        p1.setSize(772, 397);
        p1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(p1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }

    private void mostrarColectivoPresentacion() {
        ColectivoPresentacion d1 = new ColectivoPresentacion();
        d1.setSize(817, 602);
        d1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(d1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
    
       private void mostrarCargaColectivos() {
           cargaDeColectivos d1 = new cargaDeColectivos();
        d1.setSize(817, 602);
        d1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(d1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
    
        private void mostrarHorarios() {
            HorarioPresentacion hp1 = new HorarioPresentacion();
        hp1.setSize(817, 602);
        hp1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(hp1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
        
      private void mostrarsRutas() {
          RutaPresentacion rp1 = new RutaPresentacion();
        rp1.setSize(817, 602);
        rp1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(rp1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
      
        private void mostrarPasajes() {
         PasajePresentacion rp1 = new PasajePresentacion();
        rp1.setSize(817, 602);
        rp1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(rp1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
        
          private void mostrarPasajeros() {
              PasajeroPresentacion pp1 = new PasajeroPresentacion();
        pp1.setSize(817, 602);
        pp1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(pp1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBColectivos = new javax.swing.JButton();
        jBHorarios = new javax.swing.JButton();
        jBPrincipal = new javax.swing.JButton();
        jBPasajeros = new javax.swing.JButton();
        jBRutas = new javax.swing.JButton();
        jBPasajes = new javax.swing.JButton();
        jLnombre = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPMostrar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dateText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(51, 51, 51)));

        jBColectivos.setBackground(new java.awt.Color(0, 102, 102));
        jBColectivos.setForeground(new java.awt.Color(255, 255, 255));
        jBColectivos.setText("Colectivos ");
        jBColectivos.setBorder(null);
        jBColectivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBColectivosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBColectivosMouseExited(evt);
            }
        });
        jBColectivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBColectivosActionPerformed(evt);
            }
        });

        jBHorarios.setBackground(new java.awt.Color(0, 102, 102));
        jBHorarios.setForeground(new java.awt.Color(255, 255, 255));
        jBHorarios.setText("Horarios");
        jBHorarios.setBorder(null);
        jBHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBHorariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBHorariosMouseExited(evt);
            }
        });
        jBHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHorariosActionPerformed(evt);
            }
        });

        jBPrincipal.setBackground(new java.awt.Color(0, 102, 102));
        jBPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        jBPrincipal.setText("Principal");
        jBPrincipal.setBorder(null);
        jBPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBPrincipalMouseExited(evt);
            }
        });
        jBPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrincipalActionPerformed(evt);
            }
        });

        jBPasajeros.setBackground(new java.awt.Color(0, 102, 102));
        jBPasajeros.setForeground(new java.awt.Color(255, 255, 255));
        jBPasajeros.setText("Pasajeros");
        jBPasajeros.setBorder(null);
        jBPasajeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBPasajerosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBPasajerosMouseExited(evt);
            }
        });
        jBPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPasajerosActionPerformed(evt);
            }
        });

        jBRutas.setBackground(new java.awt.Color(0, 102, 102));
        jBRutas.setForeground(new java.awt.Color(255, 255, 255));
        jBRutas.setText("Rutas");
        jBRutas.setBorder(null);
        jBRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBRutasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBRutasMouseExited(evt);
            }
        });
        jBRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRutasActionPerformed(evt);
            }
        });

        jBPasajes.setBackground(new java.awt.Color(0, 102, 102));
        jBPasajes.setForeground(new java.awt.Color(255, 255, 255));
        jBPasajes.setText("Pasajes");
        jBPasajes.setBorder(null);
        jBPasajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBPasajesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBPasajesMouseExited(evt);
            }
        });
        jBPasajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPasajesActionPerformed(evt);
            }
        });

        jLnombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLnombre.setForeground(new java.awt.Color(255, 255, 255));
        jLnombre.setText("Sol Bus");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBColectivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBPasajeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBPasajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBRutas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLnombre)
                .addGap(98, 98, 98))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLnombre)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jBPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPasajes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jPMostrar.setBackground(new java.awt.Color(255, 255, 255));
        jPMostrar.setPreferredSize(new java.awt.Dimension(817, 602));

        javax.swing.GroupLayout jPMostrarLayout = new javax.swing.GroupLayout(jPMostrar);
        jPMostrar.setLayout(jPMostrarLayout);
        jPMostrarLayout.setHorizontalGroup(
            jPMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPMostrarLayout.setVerticalGroup(
            jPMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        dateText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateText.setForeground(new java.awt.Color(255, 255, 255));
        dateText.setText("{Nombredia}{dia} de {mes} de {año}  ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(dateText)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBPasajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPasajesActionPerformed
    mostrarPasajes();
    }//GEN-LAST:event_jBPasajesActionPerformed

    private void jBRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRutasActionPerformed
       mostrarsRutas();
    }//GEN-LAST:event_jBRutasActionPerformed

    private void jBPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPasajerosActionPerformed
        mostrarPasajeros();
    }//GEN-LAST:event_jBPasajerosActionPerformed

    private void jBPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrincipalActionPerformed
        mostrarPrincipal();
    }//GEN-LAST:event_jBPrincipalActionPerformed

    private void jBHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHorariosActionPerformed
        mostrarHorarios();
    }//GEN-LAST:event_jBHorariosActionPerformed

    private void jBColectivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBColectivosActionPerformed
        mostrarColectivoPresentacion();
    }//GEN-LAST:event_jBColectivosActionPerformed

    private void jBPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPrincipalMouseEntered
         jBPrincipal.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_jBPrincipalMouseEntered

    private void jBPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPrincipalMouseExited
        jBPrincipal.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_jBPrincipalMouseExited

    private void jBColectivosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBColectivosMouseEntered
        jBColectivos.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_jBColectivosMouseEntered

    private void jBColectivosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBColectivosMouseExited
       jBColectivos.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_jBColectivosMouseExited

    private void jBHorariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBHorariosMouseEntered
        jBHorarios.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_jBHorariosMouseEntered

    private void jBHorariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBHorariosMouseExited
      jBHorarios.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_jBHorariosMouseExited

    private void jBPasajerosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPasajerosMouseEntered
       jBPasajeros.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_jBPasajerosMouseEntered

    private void jBPasajerosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPasajerosMouseExited
        jBPasajeros.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_jBPasajerosMouseExited

    private void jBPasajesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPasajesMouseEntered
        jBPasajes.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_jBPasajesMouseEntered

    private void jBPasajesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPasajesMouseExited
        jBPasajes.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_jBPasajesMouseExited

    private void jBRutasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBRutasMouseEntered
        jBRutas.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_jBRutasMouseEntered

    private void jBRutasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBRutasMouseExited
       jBRutas.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_jBRutasMouseExited

    
    private void setDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        dateText.setText(now.format(DateTimeFormatter.ofPattern(" 'Hoy es' EEEE dd 'de' MMMM 'de' yyyy ", spanishLocale)));
    }
    
    
    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateText;
    private javax.swing.JButton jBColectivos;
    private javax.swing.JButton jBHorarios;
    private javax.swing.JButton jBPasajeros;
    private javax.swing.JButton jBPasajes;
    private javax.swing.JButton jBPrincipal;
    private javax.swing.JButton jBRutas;
    private javax.swing.JLabel jLnombre;
    private javax.swing.JPanel jPMostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
