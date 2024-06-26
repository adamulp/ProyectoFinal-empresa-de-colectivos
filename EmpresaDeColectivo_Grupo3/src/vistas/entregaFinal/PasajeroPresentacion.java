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
public class PasajeroPresentacion extends javax.swing.JPanel {

    /**
     * Creates new form PasajeroPresentacion
     */
    public PasajeroPresentacion() {
        initComponents();
    }

   private JButton botonSeleccionado;
   
    private void mostrarCargarPasajeros(){
      CargaDePasajero c1 = new CargaDePasajero();
        c1.setSize(817, 602);
        c1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(c1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
    
     private void mostrarBuscarPasajeros(){
      buscarPasajeros c1 = new buscarPasajeros();
        c1.setSize(817, 602);
        c1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(c1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPGestionPasajeros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBCargar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jPMostrar = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(817, 602));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPGestionPasajeros.setBackground(new java.awt.Color(0, 102, 102));
        jPGestionPasajeros.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion de pasajeros");

        jBCargar.setBackground(new java.awt.Color(0, 102, 102));
        jBCargar.setForeground(new java.awt.Color(255, 255, 255));
        jBCargar.setText("Cargar pasajeros");
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

        jBBuscar.setBackground(new java.awt.Color(0, 102, 102));
        jBBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jBBuscar.setText("Buscar pasajeros");
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

        javax.swing.GroupLayout jPGestionPasajerosLayout = new javax.swing.GroupLayout(jPGestionPasajeros);
        jPGestionPasajeros.setLayout(jPGestionPasajerosLayout);
        jPGestionPasajerosLayout.setHorizontalGroup(
            jPGestionPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGestionPasajerosLayout.createSequentialGroup()
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPGestionPasajerosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        jPGestionPasajerosLayout.setVerticalGroup(
            jPGestionPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGestionPasajerosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPGestionPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGap(0, 472, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPGestionPasajeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPGestionPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        mostrarCargarPasajeros();
        jBCargar.setBackground(new Color(0, 153, 153));
        jBBuscar.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBCargar;
    }//GEN-LAST:event_jBCargarActionPerformed

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
        mostrarBuscarPasajeros();
        jBBuscar.setBackground(new Color(0, 153, 153));
        jBCargar.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBBuscar;
    }//GEN-LAST:event_jBBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPGestionPasajeros;
    private javax.swing.JPanel jPMostrar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
