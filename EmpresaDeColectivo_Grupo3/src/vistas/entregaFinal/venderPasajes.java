/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.entregaFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author 54266
 */
public class venderPasajes extends javax.swing.JPanel{

   
    public venderPasajes() {
       initComponents();
        
   }

  private void mostrarCargarUsuario() {
        crearUsuario p1 = new crearUsuario();
        p1.setSize(817, 602);
        p1.setLocation(0, 0);

        jPFondo3.removeAll();
        jPFondo3.add(p1, BorderLayout.CENTER);
        jPFondo3.revalidate();
        jPFondo3.repaint();
    }

  
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPFondo3 = new javax.swing.JPanel();
        jLBuscarPasaje = new javax.swing.JLabel();
        jLFecha = new javax.swing.JLabel();
        jDateChFecha = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTDNI = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jBCrearUsuario = new javax.swing.JButton();
        jTDNI2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLRuta = new javax.swing.JLabel();
        jLOrigen = new javax.swing.JLabel();
        jLDestino = new javax.swing.JLabel();
        jCBOrigen = new javax.swing.JComboBox<>();
        jCBDestino = new javax.swing.JComboBox<>();
        jLHorario = new javax.swing.JLabel();
        jCBHorario = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLPrecio = new javax.swing.JLabel();
        jBVender = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLAsiento = new javax.swing.JLabel();
        jCBAsiento = new javax.swing.JComboBox<>();
        jBAsignar = new javax.swing.JButton();
        jLCargaColectivo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(817, 602));

        jPFondo3.setBackground(new java.awt.Color(255, 255, 255));
        jPFondo3.setPreferredSize(new java.awt.Dimension(805, 433));

        jLBuscarPasaje.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLBuscarPasaje.setForeground(new java.awt.Color(51, 51, 51));
        jLBuscarPasaje.setText("Buscar Pasaje");

        jLFecha.setForeground(new java.awt.Color(102, 102, 102));
        jLFecha.setText("Fecha");

        jDateChFecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateChFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jDateChFecha.setForeground(new java.awt.Color(102, 102, 102));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Pasajero");

        jTDNI.setBackground(new java.awt.Color(255, 255, 255));
        jTDNI.setForeground(new java.awt.Color(102, 102, 102));
        jTDNI.setText("Ingrese el DNI");
        jTDNI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        jTDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTDNIKeyTyped(evt);
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

        jBCrearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jBCrearUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jBCrearUsuario.setText("Crear Usuario");
        jBCrearUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBCrearUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBCrearUsuarioMouseExited(evt);
            }
        });
        jBCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTDNI2.setBackground(new java.awt.Color(255, 255, 255));
        jTDNI2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jTDNI)
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTDNI2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jBCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTDNI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jLRuta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLRuta.setForeground(new java.awt.Color(51, 51, 51));
        jLRuta.setText("Ruta");

        jLOrigen.setForeground(new java.awt.Color(102, 102, 102));
        jLOrigen.setText("Origen");

        jLDestino.setForeground(new java.awt.Color(102, 102, 102));
        jLDestino.setText("Destino");

        jCBOrigen.setBackground(new java.awt.Color(255, 255, 255));
        jCBOrigen.setForeground(new java.awt.Color(102, 102, 102));
        jCBOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBOrigen.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jCBDestino.setBackground(new java.awt.Color(255, 255, 255));
        jCBDestino.setForeground(new java.awt.Color(102, 102, 102));
        jCBDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBDestino.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLOrigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLDestino))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLRuta)
                        .addGap(43, 43, 43)))
                .addComponent(jCBDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLOrigen)
                    .addComponent(jCBDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDestino))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLHorario.setForeground(new java.awt.Color(102, 102, 102));
        jLHorario.setText("Horario");

        jCBHorario.setBackground(new java.awt.Color(255, 255, 255));
        jCBHorario.setForeground(new java.awt.Color(102, 102, 102));
        jCBHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBHorario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jLPrecio.setForeground(new java.awt.Color(51, 51, 51));
        jLPrecio.setText("Precio");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLPrecio)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLPrecio)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jBVender.setBackground(new java.awt.Color(255, 255, 255));
        jBVender.setForeground(new java.awt.Color(102, 102, 102));
        jBVender.setText("Vender pasaje");
        jBVender.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBVenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBVenderMouseExited(evt);
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

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        jTable.setBackground(new java.awt.Color(255, 255, 255));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable);

        jLAsiento.setForeground(new java.awt.Color(51, 51, 51));
        jLAsiento.setText("Asiento");

        jCBAsiento.setBackground(new java.awt.Color(255, 255, 255));
        jCBAsiento.setForeground(new java.awt.Color(102, 102, 102));
        jCBAsiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBAsiento.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));

        jBAsignar.setBackground(new java.awt.Color(255, 255, 255));
        jBAsignar.setForeground(new java.awt.Color(102, 102, 102));
        jBAsignar.setText("Asignar Unidad");
        jBAsignar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jBAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBAsignarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBAsignarMouseExited(evt);
            }
        });
        jBAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAsignarActionPerformed(evt);
            }
        });

        jLCargaColectivo.setForeground(new java.awt.Color(51, 51, 51));
        jLCargaColectivo.setText("Carga de colectivo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLCargaColectivo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLAsiento)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBAsiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLCargaColectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLAsiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPFondo3Layout = new javax.swing.GroupLayout(jPFondo3);
        jPFondo3.setLayout(jPFondo3Layout);
        jPFondo3Layout.setHorizontalGroup(
            jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFondo3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLFecha)
                .addGap(40, 40, 40)
                .addComponent(jDateChFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 573, Short.MAX_VALUE))
            .addGroup(jPFondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPFondo3Layout.createSequentialGroup()
                        .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLBuscarPasaje)
                            .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPFondo3Layout.createSequentialGroup()
                                    .addComponent(jLHorario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addComponent(jCBHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9))
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBVender, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPFondo3Layout.setVerticalGroup(
            jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLBuscarPasaje)
                .addGap(2, 2, 2)
                .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPFondo3Layout.createSequentialGroup()
                        .addComponent(jBVender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLHorario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPFondo3, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPFondo3, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAsignarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAsignarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrarCargarUsuario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseEntered
        jBBuscar.setBackground(new Color(0,102,102));
        jBBuscar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jBBuscarMouseEntered

    private void jBBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBBuscarMouseExited
         jBBuscar.setBackground(new Color(255,255,255)); 
         jBBuscar.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_jBBuscarMouseExited

    private void jBCrearUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCrearUsuarioMouseEntered
        jBCrearUsuario.setBackground(new Color(0,102,102));
        jBCrearUsuario.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jBCrearUsuarioMouseEntered

    private void jBCrearUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCrearUsuarioMouseExited
         jBCrearUsuario.setBackground(new Color(255,255,255)); 
         jBCrearUsuario.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_jBCrearUsuarioMouseExited

    private void jBVenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBVenderMouseEntered
        jBVender.setBackground(new Color(0,102,102));
        jBVender.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jBVenderMouseEntered

    private void jBVenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBVenderMouseExited
         jBVender.setBackground(new Color(255,255,255)); 
         jBVender.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_jBVenderMouseExited

    private void jBLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimpiarMouseEntered
        jBLimpiar.setBackground(new Color(0,102,102));
        jBLimpiar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jBLimpiarMouseEntered

    private void jBLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimpiarMouseExited
        jBLimpiar.setBackground(new Color(255,255,255)); 
         jBLimpiar.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_jBLimpiarMouseExited

    private void jBAsignarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAsignarMouseEntered
        jBAsignar.setBackground(new Color(0,102,102));
        jBAsignar.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jBAsignarMouseEntered

    private void jBAsignarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAsignarMouseExited
         jBAsignar.setBackground(new Color(255,255,255)); 
         jBAsignar.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_jBAsignarMouseExited

    private void jTDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDNIKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter) && caracter != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_jTDNIKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAsignar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCrearUsuario;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBVender;
    private javax.swing.JComboBox<String> jCBAsiento;
    private javax.swing.JComboBox<String> jCBDestino;
    private javax.swing.JComboBox<String> jCBHorario;
    private javax.swing.JComboBox<String> jCBOrigen;
    private com.toedter.calendar.JDateChooser jDateChFecha;
    private javax.swing.JLabel jLAsiento;
    private javax.swing.JLabel jLBuscarPasaje;
    private javax.swing.JLabel jLCargaColectivo;
    private javax.swing.JLabel jLDestino;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLHorario;
    private javax.swing.JLabel jLOrigen;
    private javax.swing.JLabel jLPrecio;
    private javax.swing.JLabel jLRuta;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPFondo3;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDNI;
    private javax.swing.JTextField jTDNI2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
