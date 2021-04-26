
package gui.MenuSucursales;

import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class PanelEliminarSucursal extends javax.swing.JPanel {
    private DialogMenuSucursal dms = null;
    
    public PanelEliminarSucursal(DialogMenuSucursal dms) {
        this.dms = dms;
        
        initComponents();
        this.dms.setSize(350, 172);
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        ItemsComboSucursales(dms.controladorSucursal.nombresSucursales());
    }
    
    private void ItemsComboSucursales(List<String> sucursales){
        comboBoxListaSucursales.removeAllItems();
        
        if(sucursales.isEmpty()){
            return;
        }
        
        sucursales.forEach(sucursal -> {
            comboBoxListaSucursales.addItem(sucursal);
        });
        comboBoxListaSucursales.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogConfirmacion = new javax.swing.JDialog();
        jPanelConfirmacion = new javax.swing.JPanel();
        labelTituloConfirmacion = new javax.swing.JLabel();
        buttonAceptarConfirmacion = new javax.swing.JButton();
        buttonCancelarConfirmacion = new javax.swing.JButton();
        jPanelFondo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelSucursales = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        comboBoxListaSucursales = new javax.swing.JComboBox<>();

        DialogConfirmacion.setTitle("Confirmacion");
        DialogConfirmacion.setMinimumSize(new java.awt.Dimension(325, 175));
        DialogConfirmacion.setModal(true);

        jPanelConfirmacion.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        jPanelConfirmacion.setPreferredSize(new java.awt.Dimension(310, 135));

        labelTituloConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelTituloConfirmacion.setForeground(Color.decode(Colores.TITULO.getColor(dms.getFramePrincipal().modo)));
        labelTituloConfirmacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTituloConfirmacion.setText(Texto.CONFIRMACION_ELIMINAR.getTexto());

        buttonAceptarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setText(Texto.ACEPTAR.getTexto());
        buttonAceptarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonAceptarConfirmacion.setFocusable(false);
        buttonAceptarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarConfirmacionActionPerformed(evt);
            }
        });

        buttonCancelarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setText(Texto.CANCELAR.getTexto());
        buttonCancelarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonCancelarConfirmacion.setFocusable(false);
        buttonCancelarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarConfirmacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConfirmacionLayout = new javax.swing.GroupLayout(jPanelConfirmacion);
        jPanelConfirmacion.setLayout(jPanelConfirmacionLayout);
        jPanelConfirmacionLayout.setHorizontalGroup(
            jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTituloConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelConfirmacionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(buttonAceptarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(buttonCancelarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanelConfirmacionLayout.setVerticalGroup(
            jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfirmacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTituloConfirmacion)
                .addGap(30, 30, 30)
                .addGroup(jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogConfirmacionLayout = new javax.swing.GroupLayout(DialogConfirmacion.getContentPane());
        DialogConfirmacion.getContentPane().setLayout(DialogConfirmacionLayout);
        DialogConfirmacionLayout.setHorizontalGroup(
            DialogConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DialogConfirmacionLayout.setVerticalGroup(
            DialogConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(350, 270));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(dms.getFramePrincipal().modo)));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.ELIMINAR_SUCURSAL.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(350, 30));

        labelSucursales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSucursales.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelSucursales.setText(Texto.SUCURSAL.getTexto());
        labelSucursales.setPreferredSize(new java.awt.Dimension(90, 26));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonAceptar.setFocusable(false);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dms.getFramePrincipal().modo)));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        buttonCancelar.setFocusable(false);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        comboBoxListaSucursales.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dms.getFramePrincipal().modo)));
        comboBoxListaSucursales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxListaSucursales.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        comboBoxListaSucursales.setMaximumRowCount(10);
        comboBoxListaSucursales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxListaSucursales.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))));
        comboBoxListaSucursales.setFocusable(false);
        comboBoxListaSucursales.setPreferredSize(new java.awt.Dimension(182, 26));

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxListaSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxListaSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, 348, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        DialogConfirmacion.setIconImage(new ImageIcon("src/gui/imagenes/chefcito_icon_80.png").getImage());
        DialogConfirmacion.setLocationRelativeTo(dms);
        DialogConfirmacion.setVisible(true);
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dms.setVisible(false);
    }//GEN-LAST:event_buttonCancelarActionPerformed

//Botones Confirmacion
    private void buttonAceptarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarConfirmacionActionPerformed
        List<String> nombresSucursales = dms.controladorSucursal.nombresSucursales();
        if(nombresSucursales.isEmpty()){
            DialogConfirmacion.setVisible(false);
            dms.setVisible(false);
            return;
        }
        
        try {
            String nombre = (String)comboBoxListaSucursales.getSelectedItem();
            dms.controladorSucursal.eliminarSucursal(nombre);
            DialogConfirmacion.setVisible(false);
            dms.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(PanelEliminarSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarConfirmacionActionPerformed

    private void buttonCancelarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarConfirmacionActionPerformed
        DialogConfirmacion.setVisible(false);
    }//GEN-LAST:event_buttonCancelarConfirmacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogConfirmacion;
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonAceptarConfirmacion;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonCancelarConfirmacion;
    private javax.swing.JComboBox<String> comboBoxListaSucursales;
    private javax.swing.JPanel jPanelConfirmacion;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel labelSucursales;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTituloConfirmacion;
    // End of variables declaration//GEN-END:variables
}