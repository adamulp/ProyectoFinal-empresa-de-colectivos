package vistas.entregaFinal;

import java.awt.Color;

/**
 *
 * @author adam, enzo, alexis, nicolas
 */
public class CargaRuta extends javax.swing.JPanel {

    public CargaRuta() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLOrigen = new javax.swing.JLabel();
        jLDestino = new javax.swing.JLabel();
        jLDuracion = new javax.swing.JLabel();
        jTOrigen = new javax.swing.JTextField();
        jSP1 = new javax.swing.JSpinner();
        jTDestino = new javax.swing.JTextField();
        jSP2 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jBGuardar = new javax.swing.JButton();
        jBLimpiar2 = new javax.swing.JButton();
        jLCargar = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(817, 602));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jLOrigen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLOrigen.setForeground(new java.awt.Color(102, 102, 102));
        jLOrigen.setText("Origen");

        jLDestino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLDestino.setForeground(new java.awt.Color(102, 102, 102));
        jLDestino.setText("Destino");

        jLDuracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLDuracion.setForeground(new java.awt.Color(102, 102, 102));
        jLDuracion.setText("Duracion");

        jTOrigen.setBackground(new java.awt.Color(255, 255, 255));
        jTOrigen.setForeground(new java.awt.Color(153, 153, 153));
        jTOrigen.setText("Ingrese origen");
        jTOrigen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jTOrigen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTOrigenMousePressed(evt);
            }
        });
        jTOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTOrigenActionPerformed(evt);
            }
        });

        jSP1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jTDestino.setBackground(new java.awt.Color(255, 255, 255));
        jTDestino.setForeground(new java.awt.Color(153, 153, 153));
        jTDestino.setText("Ingrese destino");
        jTDestino.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jTDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTDestinoMousePressed(evt);
            }
        });

        jSP2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText(":");

        jBGuardar.setBackground(new java.awt.Color(255, 255, 255));
        jBGuardar.setForeground(new java.awt.Color(102, 102, 102));
        jBGuardar.setText("Guardar");
        jBGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBGuardarMouseExited(evt);
            }
        });

        jBLimpiar2.setBackground(new java.awt.Color(255, 255, 255));
        jBLimpiar2.setForeground(new java.awt.Color(102, 102, 102));
        jBLimpiar2.setText("Limpiar");
        jBLimpiar2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBLimpiar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBLimpiar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBLimpiar2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLDuracion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDestino)
                            .addComponent(jLOrigen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTDestino)
                            .addComponent(jTOrigen))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jBLimpiar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(68, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jBGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLOrigen)
                            .addComponent(jTOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLDestino))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jBLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDuracion)
                            .addComponent(jSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLCargar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLCargar.setForeground(new java.awt.Color(51, 51, 51));
        jLCargar.setText("Cargar rutas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLCargar)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLCargar)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
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

    private void jBGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGuardarMouseEntered
        jBGuardar.setBackground(new Color(0, 102, 102));
        jBGuardar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBGuardarMouseEntered

    private void jBGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGuardarMouseExited
        jBGuardar.setBackground(new Color(255, 255, 255));
        jBGuardar.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jBGuardarMouseExited

    private void jBLimpiar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimpiar2MouseEntered
        jBLimpiar2.setBackground(new Color(0, 102, 102));
        jBLimpiar2.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBLimpiar2MouseEntered

    private void jBLimpiar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimpiar2MouseExited
        jBLimpiar2.setBackground(new Color(255, 255, 255));
        jBLimpiar2.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jBLimpiar2MouseExited

    private void jTOrigenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTOrigenMousePressed
          if (jTOrigen.getText().equals("Ingrese origen")) {
            jTOrigen.setText("");
            jTOrigen.setForeground(Color.black);
        }
        if (jTDestino.getText().isEmpty()) {
          jTDestino.setText("Ingrese destino");
           jTDestino.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_jTOrigenMousePressed

    private void jTDestinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDestinoMousePressed
          if (jTDestino.getText().equals("Ingrese destino")) {
           jTDestino.setText("");
           jTDestino.setForeground(Color.black);
        }
        if (jTOrigen.getText().isEmpty()) {
            jTOrigen.setText("Ingrese origen");
           jTOrigen.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jTDestinoMousePressed

    private void jTOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTOrigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar2;
    private javax.swing.JLabel jLCargar;
    private javax.swing.JLabel jLDestino;
    private javax.swing.JLabel jLDuracion;
    private javax.swing.JLabel jLOrigen;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSP1;
    private javax.swing.JSpinner jSP2;
    private javax.swing.JTextField jTDestino;
    private javax.swing.JTextField jTOrigen;
    // End of variables declaration//GEN-END:variables
}
