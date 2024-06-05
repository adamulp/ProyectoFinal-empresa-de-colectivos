/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adam
 */
public class Rutas extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column) {
                // Bloquear ediciones dentro de la tabla
                return false;
            }
    };
    /**
     * Creates new form Rutas
     */
    public Rutas() {
        initComponents();
        ArrayList<String> columnas = new ArrayList<>();
        
        
        columnas.add("idRuta");
        columnas.add("origen");
        columnas.add("destino");
        columnas.add("duracionEstimada");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        checkboxEstado = new javax.swing.JCheckBox();
        btnAgregarFila = new javax.swing.JButton();
        btnQuitarFila = new javax.swing.JButton();
        btnModificarFila = new javax.swing.JButton();
        txtRuta = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        txtDuracionHora = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDuracionMin = new javax.swing.JTextField();

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

        jLabel1.setText("idRuta");

        jLabel2.setText("Origen");

        jLabel3.setText("Destino");

        jLabel4.setText("Duración Estimada");

        checkboxEstado.setText("Estado");

        btnAgregarFila.setText("agregarFila");
        btnAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFilaActionPerformed(evt);
            }
        });

        btnQuitarFila.setText("quitarFila");
        btnQuitarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarFilaActionPerformed(evt);
            }
        });

        btnModificarFila.setText("modificarFila");
        btnModificarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFilaActionPerformed(evt);
            }
        });

        txtRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaActionPerformed(evt);
            }
        });
        txtRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutaKeyTyped(evt);
            }
        });

        txtDuracionHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionHoraKeyTyped(evt);
            }
        });

        jLabel5.setText(":");

        txtDuracionMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionMinKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtDuracionHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(checkboxEstado)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtDuracionMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(checkboxEstado))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarFila)
                    .addComponent(btnQuitarFila)
                    .addComponent(btnModificarFila)
                    .addComponent(jLabel4)
                    .addComponent(txtDuracionHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuracionMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(299, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaActionPerformed

    private void btnAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFilaActionPerformed
        agregarFila();
    }//GEN-LAST:event_btnAgregarFilaActionPerformed

    private void btnQuitarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFilaActionPerformed
        quitarFilasSeleccionadas();
    }//GEN-LAST:event_btnQuitarFilaActionPerformed

    private void btnModificarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFilaActionPerformed
        modificarFila();
    }//GEN-LAST:event_btnModificarFilaActionPerformed

    private void txtRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutaKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRutaKeyTyped

    private void txtDuracionHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionHoraKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDuracionHoraKeyTyped

    private void txtDuracionMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionMinKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDuracionMinKeyTyped

    private void armarJTable(String[] columnas) {
        for(String columna: columnas){
            modelo.addColumn(columna);
        }
        jtTabla.setModel(modelo);
        jtTabla.setCellSelectionEnabled(false);
        jtTabla.setRowSelectionAllowed(true);
    }
    private void limpiarCampos() {
//        txt.setText("");
//        combo.setSelectedIndex(-1);
        txtDestino.setText("");
        txtDuracionHora.setText("");
        txtDuracionMin.setText("");
        txtOrigen.setText("");
        txtRuta.setText("");
        checkboxEstado.setSelected(true);
    }
    private void cargarCampos(){
        
    }
    private void agregarFila() {
        String duracion = txtDuracionHora.getText() + ":" + txtDuracionMin.getText();
        if(validarCamposEntrada()){
            modelo.addRow(new Object[]{
                txtDestino.getText(),
                duracion,
                txtOrigen.getText(),
                txtRuta.getText(),
                checkboxEstado.isSelected()
            });
            limpiarCampos();
        }else{
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
        if(txtRuta.getText().isBlank()){
            JOptionPane.showMessageDialog(null, 
                    "Error: el id de la fila no puede estar vacía.");
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFila;
    private javax.swing.JButton btnModificarFila;
    private javax.swing.JButton btnQuitarFila;
    private javax.swing.JCheckBox checkboxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDuracionHora;
    private javax.swing.JTextField txtDuracionMin;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
