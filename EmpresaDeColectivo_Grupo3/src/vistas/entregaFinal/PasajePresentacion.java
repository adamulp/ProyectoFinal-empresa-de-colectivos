/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.entregaFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author 54266
 */
public class PasajePresentacion extends javax.swing.JPanel {

   
    public PasajePresentacion() {
        initComponents();
    }

    private JButton botonSeleccionado;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPGestionPasajes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBVender = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jPMostrar = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(817, 602));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPGestionPasajes.setBackground(new java.awt.Color(0, 102, 102));
        jPGestionPasajes.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion de pasajes");

        jBVender.setBackground(new java.awt.Color(0, 102, 102));
        jBVender.setForeground(new java.awt.Color(255, 255, 255));
        jBVender.setText("Vender pasajes");
        jBVender.setBorder(null);
        jBVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBVenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBVenderMouseExited(evt);
            }
        });
        jBVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVenderActionPerformed(evt);
            }
        });

        jBBuscar.setBackground(new java.awt.Color(0, 102, 102));
        jBBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jBBuscar.setText("Buscar pasajes");
        jBBuscar.setBorder(null);
        jBBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBBuscarMouseExited(evt);
            }
        });
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPGestionPasajesLayout = new javax.swing.GroupLayout(jPGestionPasajes);
        jPGestionPasajes.setLayout(jPGestionPasajesLayout);
        jPGestionPasajesLayout.setHorizontalGroup(
            jPGestionPasajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGestionPasajesLayout.createSequentialGroup()
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBVender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 511, Short.MAX_VALUE))
            .addGroup(jPGestionPasajesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPGestionPasajesLayout.setVerticalGroup(
            jPGestionPasajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGestionPasajesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPGestionPasajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addGap(0, 466, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPGestionPasajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPGestionPasajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

     private void venderPasajes() {
        VenderPasajes p1 = new VenderPasajes();
        p1.setSize(817, 602);
        p1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(p1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
      
       private void buscarPasajes() {
        BuscarPasajes b1 = new BuscarPasajes();
        b1.setSize(817, 602);
        b1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(b1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
      
    
    private void jBVenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBVenderMouseEntered
        if (botonSeleccionado != jBVender) {
            jBVender.setBackground(new Color(0, 153, 153));
        }
    }//GEN-LAST:event_jBVenderMouseEntered

    private void jBVenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBVenderMouseExited
        if (botonSeleccionado != jBVender) {
            jBVender.setBackground(new Color(0, 102, 102));
        }
    }//GEN-LAST:event_jBVenderMouseExited

    private void jBVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVenderActionPerformed
        venderPasajes();
        jBVender.setBackground(new Color(0, 153, 153));
        jBBuscar.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBVender;
    }//GEN-LAST:event_jBVenderActionPerformed

    private void jBBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseEntered
        if (botonSeleccionado != jBBuscar) {
            jBBuscar.setBackground(new Color(0, 153, 153));
        }
    }//GEN-LAST:event_jBBuscarMouseEntered

    private void jBBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseExited
        if (botonSeleccionado != jBBuscar) {
            jBBuscar.setBackground(new Color(0, 102, 102));
        }
    }//GEN-LAST:event_jBBuscarMouseExited

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        buscarPasajes();
        jBBuscar.setBackground(new Color(0, 153, 153));
        jBVender.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBBuscar;
    }//GEN-LAST:event_jBBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPGestionPasajes;
    private javax.swing.JPanel jPMostrar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
