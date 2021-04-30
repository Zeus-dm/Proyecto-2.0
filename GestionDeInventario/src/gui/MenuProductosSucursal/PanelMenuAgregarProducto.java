
package gui.MenuProductosSucursal;

import gui.MenuRegiones.*;
import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelMenuAgregarProducto extends javax.swing.JPanel {
    private DialogMenuProductosSucursal dmps = null;
    
    public PanelMenuAgregarProducto(DialogMenuProductosSucursal dmps) {
        this.dmps = dmps;
        
        int tamX = dmps.getSize().width - 350;
        int tamY = dmps.getSize().height - 214;
        
        initComponents();
        this.dmps.setSize(350, 214);
        this.dmps.setLocation(dmps.getLocation().x + (tamX/2), dmps.getLocation().y + (tamY/2));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        buttonNuevo = new javax.swing.JButton();
        buttonExistente = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmps.getFramePrincipal().modo)));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(dmps.getFramePrincipal().modo)));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_PRODUCTO.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(348, 30));

        buttonNuevo.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonNuevo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonNuevo.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonNuevo.setText(Texto.NUEVO.getTexto());
        buttonNuevo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonNuevo.setFocusable(false);
        buttonNuevo.setMaximumSize(new java.awt.Dimension(110, 30));
        buttonNuevo.setMinimumSize(new java.awt.Dimension(110, 30));
        buttonNuevo.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoActionPerformed(evt);
            }
        });

        buttonExistente.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonExistente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonExistente.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonExistente.setText(Texto.EXISTENTE.getTexto());
        buttonExistente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonExistente.setFocusable(false);
        buttonExistente.setMaximumSize(new java.awt.Dimension(110, 30));
        buttonExistente.setMinimumSize(new java.awt.Dimension(110, 30));
        buttonExistente.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExistenteActionPerformed(evt);
            }
        });

        buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonVolver.setFocusable(false);
        buttonVolver.setMaximumSize(new java.awt.Dimension(110, 30));
        buttonVolver.setMinimumSize(new java.awt.Dimension(110, 30));
        buttonVolver.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonExistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevoActionPerformed
        PanelCrearProducto pcp = new PanelCrearProducto(dmps);
        dmps.cargarPanel(pcp);
    }//GEN-LAST:event_buttonNuevoActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        dmps.setVisible(false);
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void buttonExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExistenteActionPerformed
        PanelAgregarProductoExistente pape = new PanelAgregarProductoExistente(dmps);
        dmps.cargarPanel(pape);
    }//GEN-LAST:event_buttonExistenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExistente;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}