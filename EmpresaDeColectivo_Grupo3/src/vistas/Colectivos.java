package vistas;

import EmpresaDeColectivo.Entidades.Colectivo;
import accesoADatos.ColectivoData;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adam
 */
public class Colectivos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // Bloquear ediciones dentro de la tabla
            return false;
        }
    };
    
    private ColectivoData colectivodata;

    /**
     * Creates new form Colectivos
     */
    public Colectivos() {
        initComponents();
        colectivodata = new ColectivoData();
        
        ArrayList<String> columnas = new ArrayList<>();

        columnas.add("IDCollectivo");
        columnas.add("Matricula");
        columnas.add("Marca");
        columnas.add("Modelo");
        columnas.add("Capacidad");
        columnas.add("Estado");

        armarJTable(columnas.toArray(String[]::new));
        
        btnQuitarFila.setEnabled(false);
        btnModificarFila.setEnabled(false);
        btnNuevo.setEnabled(false);
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
        btnAgregarFila = new javax.swing.JButton();
        btnQuitarFila = new javax.swing.JButton();
        btnModificarFila = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdColectivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        checkboxEstado = new javax.swing.JCheckBox();
        txtCapacidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Modelo", "Marca", "Matricula", "Capacidad"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        btnAgregarFila.setText("Agregar");
        btnAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFilaActionPerformed(evt);
            }
        });

        btnQuitarFila.setText("Eliminar");
        btnQuitarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarFilaActionPerformed(evt);
            }
        });

        btnModificarFila.setText("Modificar");
        btnModificarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFilaActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuitarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnModificarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLabel1.setText("idColectivo");

        txtIdColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdColectivoActionPerformed(evt);
            }
        });
        txtIdColectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdColectivoKeyTyped(evt);
            }
        });

        jLabel4.setText("modelo");

        jLabel3.setText("marca");

        checkboxEstado.setText("estado");
        checkboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxEstadoActionPerformed(evt);
            }
        });

        jLabel5.setText("capacidad");

        jLabel2.setText("matricula");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(checkboxEstado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtIdColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(checkboxEstado)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Colectivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFilaActionPerformed
      try {
          String matricula = txtMatricula.getText();
          String marca = txtMarca.getText();
          String modelo = txtModelo.getText();
          int capacidad = Integer.parseInt(txtCapacidad.getText());
          boolean estado = checkboxEstado.isSelected();
          
          Colectivo colectivo = new Colectivo();
          colectivo.setMatricula(matricula);
          colectivo.setMarca(marca);
          colectivo.setModelo(modelo);
          colectivo.setCapacidad(capacidad);
          colectivo.setEstado(estado);
          
          colectivodata.guardarColectivo(colectivo);
          
      }catch (NumberFormatException ex){
          JOptionPane.showMessageDialog(null, "No puede tener campos vacíos");
      }
    }//GEN-LAST:event_btnAgregarFilaActionPerformed

    private void btnQuitarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarFilaActionPerformed
        quitarFilasSeleccionadas();
        limpiarCampos();
        btnNuevo.setEnabled(false);
        btnAgregarFila.setEnabled(true);
        btnModificarFila.setEnabled(false);
        btnQuitarFila.setEnabled(false);
        jtTabla.clearSelection();
    }//GEN-LAST:event_btnQuitarFilaActionPerformed

    private void btnModificarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFilaActionPerformed
        modificarFila();
        limpiarCampos();
        btnAgregarFila.setEnabled(true);
        btnQuitarFila.setEnabled(false);
    }//GEN-LAST:event_btnModificarFilaActionPerformed

    private void checkboxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxEstadoActionPerformed

    private void txtIdColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdColectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdColectivoActionPerformed

    private void txtIdColectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdColectivoKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdColectivoKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void armarJTable(String[] columnas) {
        for (String columna : columnas) {
            modelo.addColumn(columna);
        }
        jtTabla.setModel(modelo);
        jtTabla.setCellSelectionEnabled(false);
        jtTabla.setRowSelectionAllowed(true);
    }

    private void limpiarCampos() {
//        txt.setText("");
//        combo.setSelectedIndex(-1);
        txtCapacidad.setText("");
        txtIdColectivo.setText("");
        txtMarca.setText("");
        txtMatricula.setText("");
        txtModelo.setText("");
    }

    private void cargarCampos() {

    }

    private void agregarFila() {
        if (validarCamposEntrada()) {
            modelo.addRow(new Object[]{
                txtIdColectivo.getText(),
                txtMatricula.getText(),
                txtMarca.getText(),
                txtModelo.getText(),
                txtCapacidad.getText(),
                checkboxEstado.isSelected()
            });
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se puede agregar la fila porque tiene "
                    + "datos ínvalidos.");
        }

    }

    private void quitarFilasSeleccionadas() {
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
        for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
            modelo.removeRow(filasSeleccionadas[i]);
        }
        jtTabla.repaint();
// ----------------------- Pendiente --------------------
//        limpiarJTabla();
        // ----------------------- Pendiente --------------------      

    }

    private void limpiarJTabla() {
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
    private Integer[] getIdsDeLaJTabla() {
        int numFilas = modelo.getRowCount();
        if (numFilas < 1) {
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

    private boolean validarCamposEntrada() {
        if (txtIdColectivo.getText().isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Error: el id de la fila no puede estar vacía.");
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFila;
    private javax.swing.JButton btnModificarFila;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarFila;
    private javax.swing.JCheckBox checkboxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtIdColectivo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
