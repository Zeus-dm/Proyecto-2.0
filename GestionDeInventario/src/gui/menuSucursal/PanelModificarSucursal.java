package gui.menuSucursal;

import gui.menuCliente.*;
import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.TextoErrores;
import gui.TextPrompt;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelModificarSucursal extends javax.swing.JPanel {

    PanelMenuSucursal pms = null;

    public PanelModificarSucursal(PanelMenuSucursal pms) {
        this.pms = pms;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        List<String> datos = pms.controlSucursal.seleccionarSucursal(pms.nombreSucursal);

        textNombre.setText(datos.get(0));
        textDireccion.setText(datos.get(1));
        textTelefono.setText(datos.get(2));
    }

    private void recargarColores() {
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));

        labelErrorNombre.setVisible(false);
        labelErrorTelefono.setVisible(false);
        labelErrorDireccion.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelErrorNombre = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        labelErrorTelefono = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        labelErrorDireccion = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pms.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.MODIFICAR_SUCURSAL.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelTitulo.setPreferredSize(new java.awt.Dimension(548, 32));
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        textNombre.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textNombre.setPreferredSize(new java.awt.Dimension(388, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.NOMBRE.getTexto(), textNombre);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 66, -1, -1));

        labelErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelErrorNombre.setToolTipText("Aqui deberia de ir un Error");
        labelErrorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorNombre.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        add(labelErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 66, -1, -1));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(194, 16));
        add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, -1, -1));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(54, 28));
        add(labelIdTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 129, -1, -1));

        textTelefono.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textTelefono.setPreferredSize(new java.awt.Dimension(140, 28));
        placeHolder = new TextPrompt(Texto.TELEFONO.getTexto(), textTelefono);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 129, -1, -1));

        labelErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelErrorTelefono.setToolTipText("Aqui deberia de ir un Error");
        labelErrorTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorTelefono.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorTelefono.setVisible(false);
        add(labelErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 129, -1, -1));

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 175, -1, -1));

        textDireccion.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textDireccion.setPreferredSize(new java.awt.Dimension(388, 28));
        placeHolder = new TextPrompt(Texto.DIRECCION.getTexto(), textDireccion);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 191, -1, -1));

        labelErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelErrorDireccion.setToolTipText("Aqui deberia de ir un Error");
        labelErrorDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorDireccion.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorDireccion.setVisible(false);
        add(labelErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 191, -1, -1));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonAceptar.setFocusPainted(false);
        buttonAceptar.setFocusable(false);
        buttonAceptar.setOpaque(true);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 269, -1, -1));

        buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonCancelar.setFocusPainted(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setOpaque(true);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 269, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        recargarColores();

        try {
            String error = pms.controlSucursal.modificarSucursal(pms.nombreSucursal, textNombre.getText(), textDireccion.getText(), textTelefono.getText());
            if (error == null) {
                PanelMenuSucursal newPms = new PanelMenuSucursal(pms.getFramePrincipal(), textNombre.getText(), pms.controlSucursal.nombreRegion());
                pms.getFramePrincipal().cargarPanel(pms.getFramePrincipal().getPanelPrincipal(), newPms);
            } else if (error.equals(TextoErrores.NOMBRE_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_NOMBRE_20.getTexto()) || error.equals(TextoErrores.SUCURSAL_DUPLICADO.getTexto())) {
                labelErrorNombre.setVisible(true);
                labelErrorNombre.setToolTipText(error);

                textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.TELEFONO_VACIO.getTexto()) || error.equals(TextoErrores.TELEFONO_RANGO.getTexto()) || error.equals(TextoErrores.TELEFONO_INVALIDO.getTexto())) {
                labelErrorTelefono.setVisible(true);
                labelErrorTelefono.setToolTipText(error);

                labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
                textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.DIRECCION_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_DIRECCION_20.getTexto())) {
                labelErrorDireccion.setVisible(true);
                labelErrorDireccion.setToolTipText(error);

                textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelModificarSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(pms);
        pms.getFramePrincipal().cargarPanel(pms.getPanelProducto(), pss);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelErrorDireccion;
    private javax.swing.JLabel labelErrorNombre;
    private javax.swing.JLabel labelErrorTelefono;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
