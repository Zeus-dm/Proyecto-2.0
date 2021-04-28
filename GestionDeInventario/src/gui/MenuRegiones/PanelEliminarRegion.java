
package gui.MenuRegiones;

import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class PanelEliminarRegion extends javax.swing.JPanel {
    private DialogMenuRegion dmr = null;
    
    public PanelEliminarRegion(DialogMenuRegion dmr) {
        this.dmr = dmr;
        
        initComponents();
        this.dmr.setSize(350, 172);
        this.dmr.setLocationRelativeTo(this.dmr.getFramePrincipal());
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        ItemsComboRegiones(dmr.controladorRegion.nombresRegiones());
    }
    
    private void ItemsComboRegiones(List<String> regiones){
        comboBoxListaRegiones.removeAllItems();
        
        if(regiones.isEmpty()){
            return;
        }
        
        regiones.forEach(region -> {
            comboBoxListaRegiones.addItem(region);
        });
        comboBoxListaRegiones.setSelectedIndex(0);
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
        labelRegion = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        comboBoxListaRegiones = new javax.swing.JComboBox<>();

        DialogConfirmacion.setTitle("Confirmacion");
        DialogConfirmacion.setMinimumSize(new java.awt.Dimension(310, 135));
        DialogConfirmacion.setModal(true);
        DialogConfirmacion.setUndecorated(true);

        jPanelConfirmacion.setBackground(Color.decode(Colores.FONDO.getColor(dmr.getFramePrincipal().modo)));
        jPanelConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmr.getFramePrincipal().modo))));
        jPanelConfirmacion.setPreferredSize(new java.awt.Dimension(310, 135));

        labelTituloConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelTituloConfirmacion.setForeground(Color.decode(Colores.TITULO.getColor(dmr.getFramePrincipal().modo)));
        labelTituloConfirmacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTituloConfirmacion.setText(Texto.CONFIRMACION_ELIMINAR.getTexto());

        buttonAceptarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setText(Texto.ACEPTAR.getTexto());
        buttonAceptarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmr.getFramePrincipal().modo))));
        buttonAceptarConfirmacion.setFocusable(false);
        buttonAceptarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarConfirmacionActionPerformed(evt);
            }
        });

        buttonCancelarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setText(Texto.CANCELAR.getTexto());
        buttonCancelarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmr.getFramePrincipal().modo))));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
                .addContainerGap(28, Short.MAX_VALUE))
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

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmr.getFramePrincipal().modo))));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmr.getFramePrincipal().modo)));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(350, 270));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(dmr.getFramePrincipal().modo)));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.ELIMINAR_REGION.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(350, 30));

        labelRegion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRegion.setForeground(Color.decode(Colores.TEXTO.getColor(dmr.getFramePrincipal().modo)));
        labelRegion.setText(Texto.REGION.getTexto());
        labelRegion.setPreferredSize(new java.awt.Dimension(90, 26));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmr.getFramePrincipal().modo))));
        buttonAceptar.setFocusable(false);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmr.getFramePrincipal().modo)));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmr.getFramePrincipal().modo))));
        buttonCancelar.setFocusable(false);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        comboBoxListaRegiones.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmr.getFramePrincipal().modo)));
        comboBoxListaRegiones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxListaRegiones.setForeground(Color.decode(Colores.TEXTO.getColor(dmr.getFramePrincipal().modo)));
        comboBoxListaRegiones.setMaximumRowCount(7);
        comboBoxListaRegiones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxListaRegiones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmr.getFramePrincipal().modo))));
        comboBoxListaRegiones.setFocusable(false);
        comboBoxListaRegiones.setPreferredSize(new java.awt.Dimension(182, 26));

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
                        .addComponent(labelRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxListaRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxListaRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        DialogConfirmacion.setLocationRelativeTo(dmr);
        DialogConfirmacion.setVisible(true);
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dmr.setVisible(false);
    }//GEN-LAST:event_buttonCancelarActionPerformed

//Botones Confirmacion
    private void buttonAceptarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarConfirmacionActionPerformed
        List<String> nombresRegiones = dmr.controladorRegion.nombresRegiones();
        if(nombresRegiones.isEmpty()){
            DialogConfirmacion.setVisible(false);
            dmr.setVisible(false);
            return;
        }
        
        try {
            String nombre = (String)comboBoxListaRegiones.getSelectedItem();
            dmr.controladorRegion.eliminarRegion(nombre);
            DialogConfirmacion.setVisible(false);
            dmr.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(PanelEliminarRegion.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> comboBoxListaRegiones;
    private javax.swing.JPanel jPanelConfirmacion;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel labelRegion;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTituloConfirmacion;
    // End of variables declaration//GEN-END:variables
}