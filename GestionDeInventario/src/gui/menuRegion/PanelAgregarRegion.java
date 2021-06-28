package gui.menuRegion;

import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.TextoErrores;
import gui.TextPrompt;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelAgregarRegion extends javax.swing.JPanel {

    PanelMenuRegiones pmr = null;

    public PanelAgregarRegion(PanelMenuRegiones pmr) {
        this.pmr = pmr;

        initComponents();
    }

    private void recargarColores() {
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));

        labelErrorNombre.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelErrorNombre = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        setPreferredSize(new java.awt.Dimension(547, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pmr.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_REGION.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelTitulo.setPreferredSize(new java.awt.Dimension(548, 32));
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        textNombre.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textNombre.setPreferredSize(new java.awt.Dimension(350, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.NOMBRE.getTexto(), textNombre);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 66, 388, -1));

        labelErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorNombre.setToolTipText("Aqui deberia de ir un Error");
        labelErrorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorNombre.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        add(labelErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 66, -1, -1));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAceptar.setFocusPainted(false);
        buttonAceptar.setFocusable(false);
        buttonAceptar.setOpaque(true);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 134, -1, -1));

        buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        buttonCancelar.setFocusPainted(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setOpaque(true);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmr.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 134, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        recargarColores();

        try {
            String error = pmr.controlRegion.agregarRegion(textNombre.getText());
            if (error == null) {
                PanelMenuRegiones newPmr = new PanelMenuRegiones(pmr.getFramePrincipal(), null);
                pmr.getFramePrincipal().cargarPanel(pmr.getFramePrincipal().getPanelPrincipal(), newPmr);
            } else if (error.equals(TextoErrores.NOMBRE_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_NOMBRE_20.getTexto()) || error.equals(TextoErrores.REGION_DUPLICADO.getTexto())) {
                labelErrorNombre.setVisible(true);
                labelErrorNombre.setToolTipText(error);

                textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelAgregarRegion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelMenuRegiones newPmr = new PanelMenuRegiones(pmr.getFramePrincipal(), null);
        pmr.getFramePrincipal().cargarPanel(pmr.getFramePrincipal().getPanelPrincipal(), newPmr);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel labelErrorNombre;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
