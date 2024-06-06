/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adam
 */
public class Horarios extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Bloquear ediciones dentro de la tabla
            return false;
        }
    };

    /**
     * Creates new form Horarios
     */
    public Horarios() {
        initComponents();
        ArrayList<String> columnas = new ArrayList<>();

        columnas.add("idHorario");
        columnas.add("idRuta");
        columnas.add("horaSalida");
        columnas.add("horaLlegada");
        columnas.add("capacidad");
        columnas.add("estado");

        armarJTable(columnas.toArray(String[]::new));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSalidaHora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSalidaMinutos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLlegadaHora = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtLlegadaMinutos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdHorario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdRuta = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        checkboxEstado = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarFila = new javax.swing.JButton();
        btnQuitarFila = new javax.swing.JButton();
        btnModificarFila = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        jLabel5.setText("hs");

        jLabel3.setText("Hora salida");

        txtSalidaHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalidaHoraKeyTyped(evt);
            }
        });

        jLabel6.setText(":");

        txtSalidaMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaMinutosActionPerformed(evt);
            }
        });
        txtSalidaMinutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalidaMinutosKeyTyped(evt);
            }
        });

        jLabel7.setText("hs");

        txtLlegadaHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLlegadaHoraKeyTyped(evt);
            }
        });

        jLabel16.setText(":");

        txtLlegadaMinutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLlegadaMinutosKeyTyped(evt);
            }
        });

        jLabel4.setText("Hora llegada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSalidaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalidaMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLlegadaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLlegadaMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSalidaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSalidaMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtLlegadaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtLlegadaMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jLabel1.setText("Id horario");

        txtIdHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdHorarioKeyTyped(evt);
            }
        });

        jLabel2.setText("Id ruta");

        txtIdRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRutaActionPerformed(evt);
            }
        });
        txtIdRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdRutaKeyTyped(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        checkboxEstado.setText("estado");
        checkboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, 120, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkboxEstado)
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxEstado))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnAgregarFila.setText("Agregar fila");
        btnAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFilaActionPerformed(evt);
            }
        });

        btnQuitarFila.setText("Quitar fila");
        btnQuitarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarFilaActionPerformed(evt);
            }
        });

        btnModificarFila.setText("Modificar fila");
        btnModificarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFilaActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nueva fila");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo))
        );

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setText("Horarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxEstadoActionPerformed

    private void txtSalidaMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaMinutosActionPerformed

    //Boton agregar fila
    private void btnAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFilaActionPerformed
        agregarFila();
        checkboxEstado.setEnabled(true);
        btnNuevo.setEnabled(false);

    }//GEN-LAST:event_btnAgregarFilaActionPerformed

    //Boton quitar fila
    private void btnQuitarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFilaActionPerformed
        quitarFilasSeleccionadas();
        limpiarCampos();
        btnNuevo.setEnabled(false);
        btnAgregarFila.setEnabled(true);
        btnModificarFila.setEnabled(false);
        btnQuitarFila.setEnabled(false);
        jtTabla.clearSelection();

    }//GEN-LAST:event_btnQuitarFilaActionPerformed

    //Boton modificar fila
    private void btnModificarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFilaActionPerformed
        modificarFila();
        limpiarCampos();
        btnAgregarFila.setEnabled(true);
        btnQuitarFila.setEnabled(false);

    }//GEN-LAST:event_btnModificarFilaActionPerformed

    private void txtIdRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRutaActionPerformed

    private void txtIdHorarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdHorarioKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdHorarioKeyTyped

    private void txtIdRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdRutaKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdRutaKeyTyped

    private void txtSalidaHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaHoraKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSalidaHoraKeyTyped

    private void txtSalidaMinutosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaMinutosKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSalidaMinutosKeyTyped

    private void txtLlegadaHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLlegadaHoraKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLlegadaHoraKeyTyped

    private void txtLlegadaMinutosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLlegadaMinutosKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLlegadaMinutosKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
        checkboxEstado.setSelected(true);
        btnNuevo.setEnabled(false);
        btnAgregarFila.setEnabled(true);
        btnModificarFila.setEnabled(false);
        btnQuitarFila.setEnabled(false);
        jtTabla.clearSelection();
    }//GEN-LAST:event_btnNuevoActionPerformed
    private void armarJTable(String[] columnas) {
        for (String columna : columnas) {
            modelo.addColumn(columna);
        }
        jtTabla.setModel(modelo);
        jtTabla.setCellSelectionEnabled(false);
        jtTabla.setRowSelectionAllowed(true);
        
        checkboxEstado.setSelected(true);
        btnQuitarFila.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnModificarFila.setEnabled(false);
        /*
        columnas.add("idHorario");
        columnas.add("idRuta");
        columnas.add("horaSalida");
        columnas.add("horaLlegada");
        columnas.add("capacidad");
        columnas.add("estado");
        */
        
        jtTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    return;
                }

                int filaSeleccionada = jtTabla.getSelectedRow();
                int numFilas = jtTabla.getSelectedRowCount();
                System.out.println("rowcount=" + numFilas);
                
                if (filaSeleccionada != -1) {
                    if(numFilas == 1){
                        btnModificarFila.setEnabled(true);
                        btnNuevo.setEnabled(true);
                        btnQuitarFila.setEnabled(true);
                        btnAgregarFila.setEnabled(false);
                        Boolean estado = (Boolean) jtTabla.getValueAt(filaSeleccionada, 4);
                        if(estado != null){
                            checkboxEstado.setSelected(estado);
                        }
                        

                        txtIdHorario.setText(jtTabla.getValueAt(filaSeleccionada, 0).toString());
                        txtIdRuta.setText(jtTabla.getValueAt(filaSeleccionada, 1).toString());
//                        txt.setText(jtTabla.getValueAt(filaSeleccionada, 2).toString());
//                        
//                        String duracion = (String) jtTabla.getValueAt(filaSeleccionada, 3);
//                        if(duracion.length() == 2){
//                            String[] duracionHHMM = duracion.split(":");
//                            if(!duracionHHMM[0].isEmpty()){
//                                txtDuracionHora.setText(duracionHHMM[0]);
//                            }
//                            if(!duracionHHMM[1].isEmpty()){
//                            txtDuracionMin.setText(duracionHHMM[1]);
//                            }
//                        }
                        
                    }
                }
                if(numFilas == 0){
                    btnModificarFila.setEnabled(false);
                    btnQuitarFila.setEnabled(false);
                    btnAgregarFila.setEnabled(true);
                    checkboxEstado.setEnabled(true);
                }
                if(numFilas > 1){
                    btnModificarFila.setEnabled(false);
                    btnQuitarFila.setEnabled(true);
                    btnAgregarFila.setEnabled(false);
                    checkboxEstado.setEnabled(false);
                }
            }
        });
    }

    private void limpiarCampos() {
//        txt.setText("");
//        combo.setSelectedIndex(-1);
        txtIdHorario.setText("");
        txtIdRuta.setText("");
        txtLlegadaHora.setText("");
        txtLlegadaMinutos.setText("");
        txtSalidaHora.setText("");
        txtSalidaMinutos.setText("");
    }

    private void cargarCampos() {

    }

    private void agregarFila() {
        String horaSalida = txtSalidaHora.getText() + " " + txtSalidaMinutos.getText();
        String horaLlegada = txtLlegadaHora.getText() + " " + txtLlegadaMinutos.getText();
        if(validarCamposEntrada()){
            modelo.addRow(new Object[]{
            txtIdHorario.getText(),
            txtIdRuta.getText(),
            horaSalida,
            horaLlegada,
            checkboxEstado.isSelected()
        });
            limpiarCampos();
        }        else{
            JOptionPane.showMessageDialog(null,
                "No se puede agregar la fila porque tiene "
                        + "datos ínvalidos.");
        }
     }

    private void quitarFilasSeleccionadas(){
// ----------------------- Pendiente --------------------
//        Integer[] idFilas = getIdsDeLaJTabla();
//        for(Integer idFila: idFilas){
            // borrar fila de los datos persistentes
            // Pendiente para hacer: Accesso a Datos::ColectivosData.java
            // ColectivosDatos.borrarColectivo(idFila)
//        }    
// ----------------------- Pendiente --------------------
        int[] filasSeleccionadas = jtTabla.getSelectedRows();
        int filas = modelo.getRowCount();
        for(int i=filasSeleccionadas.length-1; i >= 0; i--){
            modelo.removeRow(filasSeleccionadas[i]);
        }
        jtTabla.repaint();
// ----------------------- Pendiente --------------------
//        limpiarJTabla();
  // ----------------------- Pendiente --------------------      
        
    }
    
    private void limpiarJTabla(){
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
        jtTabla.repaint();
        
    }

    

    private void modificarFila() {
        quitarFilasSeleccionadas();
        agregarFila();
    }
// ----------------------- Pendiente --------------------
//    private Integer getIdTabla(int fila) {
//        Object val = jtTabla.getValueAt(fila, 0);
//
//        if (val == null) {
//            return null;
//        }
//        
//        StringBuilder cadenaIdFila = new StringBuilder();
//            cadenaIdFila.append(val);
//
//        return Integer.valueOf(
//                    cadenaIdFila.toString());
//    }
    
//        private Integer getIdsJTabla(int fila) {
//        Object val = jtTabla.getValueAt(fila, 0);
//        if (val == null) {
//            return null;
//        }
//        if (val instanceof Integer) {
//            return (Integer) val;
//        }
//        return Integer.valueOf((String) val);
//    }
// ----------------------- Pendiente --------------------
    
        private Integer[] getIdsDeLaJTabla(){
        int numFilas = modelo.getRowCount();
        if(numFilas < 1){
            return null;
        }
        int[] filasSeleccionadas = jtTabla.getSelectedRows();
        System.out.println("filasSelccionadas.length=" + filasSeleccionadas.length);
        Integer[] idFilas = new Integer[filasSeleccionadas.length];

        for (int i = 0; i < filasSeleccionadas.length; i++) {
            Object val = modelo.getValueAt(filasSeleccionadas[i], 0);
            Integer idFila = null;
            StringBuilder cadenaIdFila = new StringBuilder();
            cadenaIdFila.append(val);
            idFilas[i] = Integer.valueOf(
                    cadenaIdFila.toString());
        }

        return idFilas;
    }
        
    private boolean validarCamposEntrada(){
//        Boolean retorno = null;
        boolean retorno = true;
        if(txtIdHorario.getText().isBlank()){
            JOptionPane.showMessageDialog(null, 
                    "Error: el id del horario no puede estar vacía.");
            retorno = false;
        }
        if(txtIdRuta.getText().isBlank()){
            JOptionPane.showMessageDialog(null, 
                    "Error: el id de la ruta no puede estar vacía.");
            retorno = false;
        }
        
        return retorno;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFila;
    private javax.swing.JButton btnModificarFila;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarFila;
    private javax.swing.JCheckBox checkboxEstado;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField txtIdHorario;
    private javax.swing.JTextField txtIdRuta;
    private javax.swing.JTextField txtLlegadaHora;
    private javax.swing.JTextField txtLlegadaMinutos;
    private javax.swing.JTextField txtSalidaHora;
    private javax.swing.JTextField txtSalidaMinutos;
    // End of variables declaration//GEN-END:variables
}
