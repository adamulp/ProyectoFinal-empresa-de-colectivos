package vistas.entregaFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author adam, enzo, alexis, nicolas
 */
public class ColectivoPresentacion extends javax.swing.JPanel {

   
    public ColectivoPresentacion() {
        initComponents();
    }
    
   private JButton botonSeleccionado;
    
     private void mostrarColectivos(){
      BuscarColectivos c1 = new BuscarColectivos();
        c1.setSize(817, 602);
        c1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(c1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }

    
    
    private void mostrarCarga(){
      CargaDeColectivos r1 = new CargaDeColectivos();
        r1.setSize(817, 602);
        r1.setLocation(0, 0);

        jPMostrar.removeAll();
        jPMostrar.add(r1, BorderLayout.CENTER);
        jPMostrar.revalidate();
        jPMostrar.repaint();
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPPresentacionColectivos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBCargar = new javax.swing.JButton();
        jBListar = new javax.swing.JButton();
        jPMostrar = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(817, 602));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPPresentacionColectivos.setBackground(new java.awt.Color(0, 102, 102));
        jPPresentacionColectivos.setForeground(new java.awt.Color(0, 102, 102));
        jPPresentacionColectivos.setPreferredSize(new java.awt.Dimension(817, 125));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion de colectivos");

        jBCargar.setBackground(new java.awt.Color(0, 102, 102));
        jBCargar.setForeground(new java.awt.Color(255, 255, 255));
        jBCargar.setText("Carga de colectivos");
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

        jBListar.setBackground(new java.awt.Color(0, 102, 102));
        jBListar.setForeground(new java.awt.Color(255, 255, 255));
        jBListar.setText("Lista de colectivos");
        jBListar.setBorder(null);
        jBListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBListarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBListarMouseExited(evt);
            }
        });
        jBListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPresentacionColectivosLayout = new javax.swing.GroupLayout(jPPresentacionColectivos);
        jPPresentacionColectivos.setLayout(jPPresentacionColectivosLayout);
        jPPresentacionColectivosLayout.setHorizontalGroup(
            jPPresentacionColectivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPresentacionColectivosLayout.createSequentialGroup()
                .addComponent(jBListar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 511, Short.MAX_VALUE))
            .addGroup(jPPresentacionColectivosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPresentacionColectivosLayout.setVerticalGroup(
            jPPresentacionColectivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPresentacionColectivosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPPresentacionColectivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBListar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addGap(0, 436, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPresentacionColectivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPPresentacionColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListarActionPerformed
      mostrarColectivos();
        jBListar.setBackground(new Color(0, 153, 153));
        jBCargar.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBListar;

    }//GEN-LAST:event_jBListarActionPerformed

    private void jBCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarActionPerformed
       mostrarCarga();
        jBCargar.setBackground(new Color(0, 153, 153));
        jBListar.setBackground(new Color(0, 102, 102));
        botonSeleccionado = jBCargar;
    }//GEN-LAST:event_jBCargarActionPerformed

    private void jBListarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBListarMouseEntered
         if (botonSeleccionado != jBListar) {
            jBListar.setBackground(new Color(0, 153, 153));
        }
    }//GEN-LAST:event_jBListarMouseEntered

    private void jBListarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBListarMouseExited
          if (botonSeleccionado != jBListar) {
            jBListar.setBackground(new Color(0, 102, 102));
        }
    }//GEN-LAST:event_jBListarMouseExited

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCargar;
    private javax.swing.JButton jBListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPMostrar;
    private javax.swing.JPanel jPPresentacionColectivos;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
