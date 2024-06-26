package vistas.entregaFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author adam, enzo, alexis, nicolas
 */
public class RutaPresentacion extends javax.swing.JPanel {

   
    public RutaPresentacion() {
        initComponents();
    }
    private JButton botonSeleccionado;
  
      private void mostrarRutas() {
        BuscarRutas r1 = new BuscarRutas();
        r1.setSize(817, 602);
        r1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(r1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
      
       private void mostrarCargaRutas() {
        CargaRuta r1 = new CargaRuta();
        r1.setSize(817, 602);
        r1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(r1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
      
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPRutaPresentacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBCargar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jPMostrar = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(817, 602));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPRutaPresentacion.setBackground(new java.awt.Color(0, 102, 102));
        jPRutaPresentacion.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion de rutas");

        jBCargar.setBackground(new java.awt.Color(0, 102, 102));
        jBCargar.setForeground(new java.awt.Color(255, 255, 255));
        jBCargar.setText("Carga de rutas");
        jBCargar.setBorder(null);
        jBCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBCargarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBCargarMouseExited(evt);
            }
        });
        jBCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargarActionPerformed(evt);
            }
        });

        jBListar.setBackground(new java.awt.Color(0, 102, 102));
        jBListar.setForeground(new java.awt.Color(255, 255, 255));
        jBListar.setText("Lista de Rutas");
        jBListar.setBorder(null);
        jBListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBListarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBListarMouseExited(evt);
            }
        });
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPRutaPresentacionLayout = new javax.swing.GroupLayout(jPRutaPresentacion);
        jPRutaPresentacion.setLayout(jPRutaPresentacionLayout);
        jPRutaPresentacionLayout.setHorizontalGroup(
            jPRutaPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRutaPresentacionLayout.createSequentialGroup()
                .addComponent(jBListar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 511, Short.MAX_VALUE))
            .addGroup(jPRutaPresentacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPRutaPresentacionLayout.setVerticalGroup(
            jPRutaPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRutaPresentacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPRutaPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBListar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPMostrar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPMostrarLayout = new javax.swing.GroupLayout(jPMostrar);
        jPMostrar.setLayout(jPMostrarLayout);
        jPMostrarLayout.setHorizontalGroup(
            jPMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPMostrarLayout.setVerticalGroup(
            jPMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPRutaPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPRutaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCargarMouseEntered
        if (botonSeleccionado != jBCargar) {
            jBCargar.setBackground(new Color(0, 153, 153));
        }
    }//GEN-LAST:event_jBCargarMouseEntered

    private void jBCargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCargarMouseExited
        if (botonSeleccionado != jBCargar) {
            jBCargar.setBackground(new Color(0, 102, 102));
        }
    }//GEN-LAST:event_jBCargarMouseExited

    private void jBCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarActionPerformed
        mostrarCargaRutas();
        jBCargar.setBackground(new Color(0, 153, 153));
        jBListar.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBCargar;
    }//GEN-LAST:event_jBCargarActionPerformed

    private void jBListarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBListarMouseEntered
        if (botonSeleccionado != jBListar) {
            jBListar.setBackground(new Color(0, 153, 153));
        }
    }//GEN-LAST:event_jBListarMouseEntered

    private void jBListarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBListarMouseExited
        if (botonSeleccionado != jBListar) {
            jBListar.setBackground(new Color(0, 102, 102));
        }
    }//GEN-LAST:event_jBListarMouseExited

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
        mostrarRutas();
        jBListar.setBackground(new Color(0, 153, 153));
        jBCargar.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBListar;
    }//GEN-LAST:event_jBListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCargar;
    private javax.swing.JButton jBListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPMostrar;
    private javax.swing.JPanel jPRutaPresentacion;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

  
}
