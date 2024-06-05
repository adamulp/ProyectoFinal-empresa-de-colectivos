package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adam
 */
public class Pasajeros extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column) {
                // Bloquear ediciones dentro de la tabla
                return false;
            }
    };
    /**
     * Creates new form Pasajeros
     */
    public Pasajeros() {
        initComponents();
        ArrayList<String> columnas = new ArrayList<>();
        
        
        columnas.add("idPasajero");
        columnas.add("nombre");
        columnas.add("apellido");
        columnas.add("dni");
        columnas.add("correo");
        columnas.add("telefono");
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
        jlNombre = new javax.swing.JLabel();
        jbModificarFila = new javax.swing.JButton();
        jlCorreo = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        checkboxEstado = new javax.swing.JCheckBox();
        jlIdPasajero = new javax.swing.JLabel();
        jbAgregarFila = new javax.swing.JButton();
        jlDni = new javax.swing.JLabel();
        jbQuitarFila = new javax.swing.JButton();
        jlTelefono = new javax.swing.JLabel();
        textIdPasajero = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();

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

        jlNombre.setText("nombre:");

        jbModificarFila.setText("modificarFila");
        jbModificarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarFilaActionPerformed(evt);
            }
        });

        jlCorreo.setText("correo:");

        jlApellido.setText("apellido:");

        checkboxEstado.setText("estado");

        jlIdPasajero.setText("idPasajero:");

        jbAgregarFila.setText("agregarFila");
        jbAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarFilaActionPerformed(evt);
            }
        });

        jlDni.setText("dni:");

        jbQuitarFila.setText("quitarFila");
        jbQuitarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitarFilaActionPerformed(evt);
            }
        });

        jlTelefono.setText("telefono:");

        textIdPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdPasajeroActionPerformed(evt);
            }
        });
        textIdPasajero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textIdPasajeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlNombre)
                                    .addComponent(jlApellido))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(textIdPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jlDni))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlTelefono)
                                            .addComponent(jlCorreo))))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlIdPasajero))
                        .addGap(16, 16, 16)
                        .addComponent(checkboxEstado)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbQuitarFila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAgregarFila, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jbModificarFila, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdPasajero)
                    .addComponent(jlDni)
                    .addComponent(textIdPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jlCorreo)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbQuitarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlApellido)
                    .addComponent(jlTelefono)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxEstado)
                    .addComponent(jbModificarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarFilaActionPerformed
        agregarFila();
    }//GEN-LAST:event_jbAgregarFilaActionPerformed

    private void textIdPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdPasajeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIdPasajeroActionPerformed

    private void jbQuitarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarFilaActionPerformed
        quitarFilasSeleccionadas();
    }//GEN-LAST:event_jbQuitarFilaActionPerformed

    private void jbModificarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarFilaActionPerformed
        modificarFila();
    }//GEN-LAST:event_jbModificarFilaActionPerformed

    private void textIdPasajeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIdPasajeroKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_textIdPasajeroKeyTyped

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
        textIdPasajero.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
    }
    private void cargarCampos(){
        
    }
    private void agregarFila() {
        if(validarCamposEntrada()){
            modelo.addRow(new Object[]{
                textIdPasajero.getText(),
                txtApellido.getText(),
                txtCorreo.getText(),
                txtDni.getText(),
                checkboxEstado.isSelected()
            });
            limpiarCampos();
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
        if(textIdPasajero.getText().isBlank()){
            JOptionPane.showMessageDialog(null, 
                    "Error: el id de la fila no puede estar vacía.");
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkboxEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregarFila;
    private javax.swing.JButton jbModificarFila;
    private javax.swing.JButton jbQuitarFila;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlCorreo;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlIdPasajero;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlTelefono;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField textIdPasajero;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
