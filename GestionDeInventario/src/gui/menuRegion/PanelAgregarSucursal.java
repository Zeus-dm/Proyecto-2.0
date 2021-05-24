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

public class PanelAgregarSucursal extends javax.swing.JPanel {

    PanelMenuRegiones pmr = null;
    private boolean jefe = false;

    public PanelAgregarSucursal(PanelMenuRegiones pmr) {
        this.pmr = pmr;

        initComponents();
        
        iniciarPanel();
    }
    
    private void iniciarPanel() {
        pmr.getFramePrincipal().cargarPanel(panelFondoJefe, subPanelSinJefe);
    }

    private void recargarColores() {
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));

        labelErrorNombre.setVisible(false);
        labelErrorTelefono.setVisible(false);
        labelErrorDireccion.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanelSinJefe = new javax.swing.JPanel();
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
        panelFondoJefe = new javax.swing.JPanel();

        subPanelSinJefe.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        subPanelSinJefe.setPreferredSize(new java.awt.Dimension(530, 200));

        javax.swing.GroupLayout subPanelSinJefeLayout = new javax.swing.GroupLayout(subPanelSinJefe);
        subPanelSinJefe.setLayout(subPanelSinJefeLayout);
        subPanelSinJefeLayout.setHorizontalGroup(
            subPanelSinJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        subPanelSinJefeLayout.setVerticalGroup(
            subPanelSinJefeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pmr.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_SUCURSAL.getTexto() + " a " + pmr.nombreRegion);
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
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
        textNombre.setPreferredSize(new java.awt.Dimension(388, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.NOMBRE.getTexto(), textNombre);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 66, -1, -1));

        labelErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorNombre.setToolTipText("Aqui deberia de ir un Error");
        labelErrorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorNombre.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        add(labelErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 66, -1, -1));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(194, 16));
        add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 112, -1, -1));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(54, 29));
        add(labelIdTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 128, -1, -1));

        textTelefono.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textTelefono.setPreferredSize(new java.awt.Dimension(140, 28));
        placeHolder = new TextPrompt(Texto.TELEFONO.getTexto(), textTelefono);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 129, -1, -1));

        labelErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorTelefono.setToolTipText("Aqui deberia de ir un Error");
        labelErrorTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorTelefono.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorTelefono.setVisible(false);
        add(labelErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 129, -1, -1));

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(388, 16));
        add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 175, -1, -1));

        textDireccion.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        textDireccion.setPreferredSize(new java.awt.Dimension(388, 28));
        placeHolder = new TextPrompt(Texto.DIRECCION.getTexto(), textDireccion);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 191, -1, -1));

        labelErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmr.getFramePrincipal().getModo()))));
        labelErrorDireccion.setToolTipText("Aqui deberia de ir un Error");
        labelErrorDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorDireccion.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorDireccion.setVisible(false);
        add(labelErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 191, -1, -1));

        panelFondoJefe.setPreferredSize(new java.awt.Dimension(530, 200));
        panelFondoJefe.setLayout(new java.awt.CardLayout());
        add(panelFondoJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelErrorDireccion;
    private javax.swing.JLabel labelErrorNombre;
    private javax.swing.JLabel labelErrorTelefono;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelFondoJefe;
    private javax.swing.JPanel subPanelSinJefe;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}