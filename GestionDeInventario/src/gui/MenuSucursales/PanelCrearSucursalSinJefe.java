
package gui.MenuSucursales;

import FunGenerales.FunSucursal;
import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;

public class PanelCrearSucursalSinJefe extends javax.swing.JPanel {
    private DialogMenuSucursal dms = null;
    
    public PanelCrearSucursalSinJefe(DialogMenuSucursal dms, List<String> datos) {
        this.dms = dms;
        
        initComponents();
        this.dms.setSize(365, 350);
        this.dms.setLocationRelativeTo(this.dms.getFramePrincipal());
        
        iniciarDatos(datos);
    }
    
    private void iniciarDatos(List<String> datos){
        if(datos == null){
            textNombre.setText("");
            textDireccion.setText("");
            textTelefono.setText("");
        }else{
            textNombre.setText(datos.get(0));
            textDireccion.setText(datos.get(1));
            textTelefono.setText(datos.get(2));
        }
        labelError.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        labelJefeSucursal = new javax.swing.JLabel();
        buttonAgregarJefe = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(350, 270));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(dms.getFramePrincipal().modo)));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_SUCURSAL.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(350, 30));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(90, 26));

        textNombre.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dms.getFramePrincipal().modo)));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        textNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dms.getFramePrincipal().modo)))));
        textNombre.setPreferredSize(new java.awt.Dimension(182, 26));

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(90, 26));

        textDireccion.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dms.getFramePrincipal().modo)));
        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        textDireccion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dms.getFramePrincipal().modo)))));
        textDireccion.setPreferredSize(new java.awt.Dimension(182, 26));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(90, 26));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(40, 26));

        textTelefono.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dms.getFramePrincipal().modo)));
        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        textTelefono.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dms.getFramePrincipal().modo))), javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dms.getFramePrincipal().modo)))));
        textTelefono.setPreferredSize(new java.awt.Dimension(130, 26));

        labelJefeSucursal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelJefeSucursal.setForeground(Color.decode(Colores.TEXTO.getColor(dms.getFramePrincipal().modo)));
        labelJefeSucursal.setText(Texto.JEFE_SUCURSAL.getTexto());
        labelJefeSucursal.setPreferredSize(new java.awt.Dimension(148, 30));

        buttonAgregarJefe.setBackground(Color.decode(Colores.FONDO.getColor(dms.getFramePrincipal().modo)));
        buttonAgregarJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR_JEFE_SUCURSAL.getColor(dms.getFramePrincipal().modo))));
        buttonAgregarJefe.setToolTipText("Agregar Jefe de Sucursal");
        buttonAgregarJefe.setBorder(null);
        buttonAgregarJefe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAgregarJefe.setFocusable(false);
        buttonAgregarJefe.setPreferredSize(new java.awt.Dimension(30, 30));
        buttonAgregarJefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarJefeActionPerformed(evt);
            }
        });

        labelError.setForeground(Color.decode(Colores.TEXTO_ERROR.getColor(dms.getFramePrincipal().modo)));
        labelError.setText("* Posible Error");
        labelError.setPreferredSize(new java.awt.Dimension(290, 16));

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

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelJefeSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAgregarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJefeSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAgregarJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        try {
            String ok = FunSucursal.agregarSucursal(dms.getFramePrincipal().getSistema(), dms.posRegion, textNombre.getText(), textDireccion.getText(), textTelefono.getText());
            if(ok != null){
                labelError.setText(ok);
            }else{
                dms.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelCrearSucursalSinJefe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dms.setVisible(false);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonAgregarJefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarJefeActionPerformed
        List<String> datos = new ArrayList<>();
        datos.add(textNombre.getText());
        datos.add(textDireccion.getText());
        datos.add(textTelefono.getText());
        
        PanelCrearSucursalConJefe pcscj = new PanelCrearSucursalConJefe(dms, datos);
        dms.cargarPanel(pcscj);
    }//GEN-LAST:event_buttonAgregarJefeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonAgregarJefe;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelJefeSucursal;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}