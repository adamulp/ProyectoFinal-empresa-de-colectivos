package vistas.entregaFinal;

import EmpresaDeColectivo.Entidades.Ruta;
import accesoADatos.RutaData;
import java.awt.Color;
import java.time.Duration;
import javax.swing.JOptionPane;

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
        jSPHoras = new javax.swing.JSpinner();
        jTDestino = new javax.swing.JTextField();
        jSPMinutos = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jBGuardar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
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
        jTOrigen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTOrigenFocusLost(evt);
            }
        });
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

        jSPHoras.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jSPHoras.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jTDestino.setBackground(new java.awt.Color(255, 255, 255));
        jTDestino.setForeground(new java.awt.Color(153, 153, 153));
        jTDestino.setText("Ingrese destino");
        jTDestino.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jTDestino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTDestinoFocusLost(evt);
            }
        });
        jTDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTDestinoMousePressed(evt);
            }
        });

        jSPMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jSPMinutos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

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
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        jBLimpiar.setForeground(new java.awt.Color(102, 102, 102));
        jBLimpiar.setText("Limpiar");
        jBLimpiar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBLimpiarMouseExited(evt);
            }
        });
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
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
                                .addComponent(jSPHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSPMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTDestino)
                            .addComponent(jTOrigen))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jBLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDuracion)
                            .addComponent(jSPHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSPMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jBLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimpiarMouseEntered
        jBLimpiar.setBackground(new Color(0, 102, 102));
        jBLimpiar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBLimpiarMouseEntered

    private void jBLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimpiarMouseExited
        jBLimpiar.setBackground(new Color(255, 255, 255));
        jBLimpiar.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jBLimpiarMouseExited

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

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarCampos();

    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        boolean error = false;
        if ((int) jSPHoras.getValue() <= 0
                && (int) jSPMinutos.getValue() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "La duración tiene que ser mayor a zero");
            error = true;
        }
        if (jTOrigen.getText().isBlank()
                || jTDestino.getText().isBlank()
                || jTOrigen.getText().equals("Ingrese origen")
                || jTDestino.getText().equals("Ingrese destino")) {
            JOptionPane.showMessageDialog(null,
                    "Los campos del origen y del destino "
                    + "no pueden estar vacíos");
            error = true;
        }
        if (jTOrigen.getText().equals(jTDestino.getText())) {
            JOptionPane.showMessageDialog(null,
                    "Los campos del origen y del destino "
                    + "no pueden ser iguales");
            error = true;
        }
        if(error){
            return;
        }
        Ruta ruta = new Ruta();
        ruta.setOrigen(jTOrigen.getText());
        ruta.setDestino(jTDestino.getText());
        
        long minutos = (int)jSPHoras.getValue() * 60 + (int) jSPMinutos.getValue();
        Duration duracion = Duration.ofMinutes((minutos));
        
        ruta.setDuracionEstimada(Duration.ZERO);
        ruta.setEstado(true);
        
        RutaData rutaData = new RutaData();
        rutaData.guardarRuta(ruta);
        
        
    }//GEN-LAST:event_jBGuardarActionPerformed
    
    private void limpiarCampos(){
        jSPHoras.setValue(0);
        jSPMinutos.setValue(0);
        jTOrigen.setText("Ingrese origen");
        jTDestino.setText("Ingrese destino");
        jTOrigen.setForeground(new java.awt.Color(102, 102, 102));
        jTDestino.setForeground(new java.awt.Color(102, 102, 102));
    }
    private void jTOrigenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTOrigenFocusLost
        if (jTOrigen.getText().isBlank()) {
            jTOrigen.setText("Ingrese origen");
            jTOrigen.setForeground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jTOrigenFocusLost

    private void jTDestinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTDestinoFocusLost
        if (jTDestino.getText().isBlank()) {
            jTDestino.setText("Ingrese destino");
            jTDestino.setForeground(new java.awt.Color(102, 102, 102));
        }
    }//GEN-LAST:event_jTDestinoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JLabel jLCargar;
    private javax.swing.JLabel jLDestino;
    private javax.swing.JLabel jLDuracion;
    private javax.swing.JLabel jLOrigen;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSPHoras;
    private javax.swing.JSpinner jSPMinutos;
    private javax.swing.JTextField jTDestino;
    private javax.swing.JTextField jTOrigen;
    // End of variables declaration//GEN-END:variables
}
