package vistas.entregaFinal;

import EmpresaDeColectivo.Entidades.Colectivo;
import accesoADatos.ColectivoData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.ListSelectionModel;
import vistas.jtabla.JTablaCompuesta;
import vistas.jtabla.ModeloTablaCompuesta;
import vistas.jtabla.SeccionTabla;


public class BuscarColectivos extends javax.swing.JPanel {
    
    private JTablaCompuesta tabla;
    private ModeloTablaCompuesta modelo;
    private SeccionTabla datosColectivos;

    public BuscarColectivos() {
        initComponents();
        checkBoxColectivosActivos.setSelected(true);
        vincularTablaConFormulario();
    }
    
    private void vincularTablaConFormulario() {
        modelo = new ModeloTablaCompuesta();
                
        this.datosColectivos = new SeccionTabla(
                "Colectivos",
                "Colectivos"
        );
        
        datosColectivos.agregarColumna("Marca");
        datosColectivos.agregarColumna("Modelo");
        datosColectivos.agregarColumna(
                "Matricula",
                jTMatricula,
                true
        );
        datosColectivos.agregarColumna("Capacidad");
        llenarTabla();
        modelo.agregarSeccion(datosColectivos);
        tabla = new JTablaCompuesta(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla); 
        
    }
    
   
    private void borrarLista() {
        int filas = modelo.getRowCount() - 1;
        if (filas > 0) {
            for (int i = filas; i >= 0; i--) {
                modelo.eliminarFila(i);
            }
            tabla.repaint();
        }
    }
    
    private void actualizarTabla(){
        borrarLista();
        vincularTablaConFormulario();
    }
    
    private void llenarTabla(){
        boolean estado = checkBoxColectivosActivos.isSelected();
        borrarLista();
        ColectivoData colectivoData = new ColectivoData();
        List<Colectivo> colectivos = colectivoData.listarColectivos(
                estado
        );
        
        for(Colectivo colectivo : colectivos){
            int idColectivo = colectivo.getIdColectivo();
            this.datosColectivos.agregarFila(idColectivo, new Object[]{
                colectivo.getMarca(),
                colectivo.getModelo(),
                colectivo.getMatricula(),
                colectivo.getCapacidad()
            });
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLColectivo = new javax.swing.JLabel();
        checkBoxColectivosActivos = new javax.swing.JCheckBox();
        jBEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLMatricula = new javax.swing.JLabel();
        jTMatricula = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(772, 397));
        setPreferredSize(new java.awt.Dimension(817, 602));

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setOpaque(false);

        jTable.setBackground(new java.awt.Color(255, 255, 255));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setForeground(new java.awt.Color(0, 51, 51));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Modelo", "Marca", "Matricula", "Capacidad"
            }
        ));
        jTable.setGridColor(new java.awt.Color(0, 51, 51));
        jTable.setOpaque(false);
        jScrollPane1.setViewportView(jTable);

        jLColectivo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLColectivo.setForeground(new java.awt.Color(51, 51, 51));
        jLColectivo.setText("Colectivos");

        checkBoxColectivosActivos.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxColectivosActivos.setForeground(new java.awt.Color(102, 102, 102));
        checkBoxColectivosActivos.setText("Colectivos activos");
        checkBoxColectivosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxColectivosActivosActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jBEliminar.setForeground(new java.awt.Color(102, 102, 102));
        jBEliminar.setText("Eliminar");
        jBEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBEliminarMouseExited(evt);
            }
        });
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLMatricula.setForeground(new java.awt.Color(51, 51, 51));
        jLMatricula.setText("Buscar por matricula");

        jTMatricula.setBackground(new java.awt.Color(255, 255, 255));
        jTMatricula.setForeground(new java.awt.Color(102, 102, 102));
        jTMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTMatricula.setText("Ingrese la matricula");
        jTMatricula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        jTMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTMatriculaFocusLost(evt);
            }
        });
        jTMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMatriculaMouseClicked(evt);
            }
        });

        jBBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jBBuscar.setForeground(new java.awt.Color(102, 102, 102));
        jBBuscar.setText("Buscar");
        jBBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBBuscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jTMatricula))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(jLMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jTMatricula)
                .addGap(18, 18, 18)
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(241, 241, 241)
                                .addComponent(checkBoxColectivosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxColectivosActivos, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jBEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(235, 235, 235))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseEntered
        jBEliminar.setBackground(new Color(0, 102, 102));
        jBEliminar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBEliminarMouseEntered

    private void jBEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEliminarMouseExited
        jBEliminar.setBackground(new Color(255, 255, 255));
        jBEliminar.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jBEliminarMouseExited

    private void jBBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseEntered
        jBBuscar.setBackground(new Color(0, 102, 102));
        jBBuscar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBBuscarMouseEntered

    private void jBBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseExited
        jBBuscar.setBackground(new Color(255, 255, 255));
        jBBuscar.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jBBuscarMouseExited

    private void jTMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMatriculaMouseClicked
        if(jTMatricula.getText().equals("Ingrese la matricula")){
            jTMatricula.setText("");
        }
    }//GEN-LAST:event_jTMatriculaMouseClicked

    private void jTMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTMatriculaFocusLost
        if(jTMatricula.getText().isBlank()){
            jTMatricula.setText("Ingrese la matricula");
        }
    }//GEN-LAST:event_jTMatriculaFocusLost

    private void checkBoxColectivosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxColectivosActivosActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_checkBoxColectivosActivosActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int indiceFila = tabla.getSelectedRow();
        if(indiceFila != -1){
//            Object val = modelo.getValueAt(indiceFila, 
//                    datosColectivos.
            modelo.eliminarFila(indiceFila);
        }
    }//GEN-LAST:event_jBEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxColectivosActivos;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JLabel jLColectivo;
    private javax.swing.JLabel jLMatricula;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTMatricula;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
