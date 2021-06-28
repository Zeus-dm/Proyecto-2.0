package gui.menuCliente;

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

public class PanelModificarCliente extends javax.swing.JPanel {

    PanelMenuClientes pmc = null;

    public PanelModificarCliente(PanelMenuClientes pmc) {
        this.pmc = pmc;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        List<String> datos = pmc.controlCliente.seleccionarCliente(pmc.idCliente);

        textNombre.setText(datos.get(0));
        textEdad.setText(datos.get(1));
        textDireccion.setText(datos.get(2));
        textTelefono.setText(datos.get(3));
        textEmail.setText(datos.get(4));
    }

    private void recargarColores() {
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textEdad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));

        labelErrorNombre.setVisible(false);
        labelErrorEdad.setVisible(false);
        labelErrorTelefono.setVisible(false);
        labelErrorDireccion.setVisible(false);
        labelErrorEmail.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelErrorNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        textEdad = new javax.swing.JTextField();
        labelErrorEdad = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelIdTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        labelErrorTelefono = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        labelErrorDireccion = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        labelErrorEmail = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pmc.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.MODIFICAR_CLIENTE.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelTitulo.setPreferredSize(new java.awt.Dimension(548, 32));
        add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/iconosMultiProposito/chefcito_redondo_100.gif"))); // NOI18N
        add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(350, 16));
        add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 50, -1, -1));

        textNombre.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textNombre.setPreferredSize(new java.awt.Dimension(350, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.NOMBRE.getTexto(), textNombre);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 66, -1, -1));

        labelErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
        labelErrorNombre.setToolTipText("Aqui deberia de ir un Error");
        labelErrorNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorNombre.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorNombre.setVisible(false);
        add(labelErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 66, -1, -1));

        labelEdad.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelEdad.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelEdad.setText(Texto.EDAD.getTexto());
        labelEdad.setPreferredSize(new java.awt.Dimension(150, 16));
        add(labelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 112, 110, -1));

        textEdad.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        textEdad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textEdad.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textEdad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textEdad.setPreferredSize(new java.awt.Dimension(110, 28));
        placeHolder = new TextPrompt(Texto.EDAD.getTexto(), textEdad);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 128, -1, -1));

        labelErrorEdad.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
        labelErrorEdad.setToolTipText("Aqui deberia de ir un Error");
        labelErrorEdad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorEdad.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorEdad.setVisible(false);
        add(labelErrorEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 128, -1, -1));

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelTelefono.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelTelefono.setText(Texto.TELEFONO.getTexto());
        labelTelefono.setPreferredSize(new java.awt.Dimension(194, 16));
        add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 112, -1, -1));

        labelIdTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelIdTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        labelIdTelefono.setText(Texto.ID_TELEFONO.getTexto());
        labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        labelIdTelefono.setPreferredSize(new java.awt.Dimension(54, 29));
        add(labelIdTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 128, -1, -1));

        textTelefono.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textTelefono.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textTelefono.setPreferredSize(new java.awt.Dimension(140, 28));
        placeHolder = new TextPrompt(Texto.TELEFONO.getTexto(), textTelefono);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 129, -1, -1));

        labelErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
        labelErrorTelefono.setToolTipText("Aqui deberia de ir un Error");
        labelErrorTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorTelefono.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorTelefono.setVisible(false);
        add(labelErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 129, -1, -1));

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDireccion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelDireccion.setText(Texto.DIRECCION.getTexto());
        labelDireccion.setPreferredSize(new java.awt.Dimension(350, 16));
        add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 175, -1, -1));

        textDireccion.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        textDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDireccion.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textDireccion.setPreferredSize(new java.awt.Dimension(350, 28));
        placeHolder = new TextPrompt(Texto.DIRECCION.getTexto(), textDireccion);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 191, -1, -1));

        labelErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
        labelErrorDireccion.setToolTipText("Aqui deberia de ir un Error");
        labelErrorDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorDireccion.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorDireccion.setVisible(false);
        add(labelErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 191, -1, -1));

        labelEmail.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelEmail.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmc.getFramePrincipal().getModo())));
        labelEmail.setText(Texto.EMAIL.getTexto());
        labelEmail.setPreferredSize(new java.awt.Dimension(350, 16));
        add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 237, -1, -1));

        textEmail.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        textEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textEmail.setForeground(Color.decode(Colores.TEXTO.getColor(pmc.getFramePrincipal().getModo())));
        textEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        textEmail.setPreferredSize(new java.awt.Dimension(350, 28));
        placeHolder = new TextPrompt(Texto.EMAIL.getTexto(), textEmail);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);
        add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 253, -1, -1));

        labelErrorEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
        labelErrorEmail.setToolTipText("Aqui deberia de ir un Error");
        labelErrorEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorEmail.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorEmail.setVisible(false);
        add(labelErrorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 253, -1, -1));

        buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmc.getFramePrincipal().getModo())));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        buttonAceptar.setFocusPainted(false);
        buttonAceptar.setFocusable(false);
        buttonAceptar.setOpaque(true);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmc.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 321, -1, -1));

        buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmc.getFramePrincipal().getModo())));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
        buttonCancelar.setFocusPainted(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setOpaque(true);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmc.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pmc.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmc.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 321, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        recargarColores();

        try {
            String error = pmc.controlCliente.modificarCliente(pmc.idCliente, textNombre.getText(), textEdad.getText(), textDireccion.getText(), textTelefono.getText(), textEmail.getText());
            if (error == null) {
                pmc.cargarClientes(pmc.controlCliente.nombresClientes());

                PanelSeleccionarCliente psc = new PanelSeleccionarCliente(pmc);
                pmc.getFramePrincipal().cargarPanel(pmc.getPanelCliente(), psc);
            } else if (error.equals(TextoErrores.NOMBRE_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_NOMBRE_40.getTexto())) {
                labelErrorNombre.setVisible(true);
                labelErrorNombre.setToolTipText(error);

                textNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.EDAD_VACIO.getTexto()) || error.equals(TextoErrores.EDAD_NO_RANGO.getTexto()) || error.equals(TextoErrores.EDAD_NO_NUMERO.getTexto())) {
                labelErrorEdad.setVisible(true);
                labelErrorEdad.setToolTipText(error);

                textEdad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.TELEFONO_VACIO.getTexto()) || error.equals(TextoErrores.TELEFONO_RANGO.getTexto()) || error.equals(TextoErrores.TELEFONO_INVALIDO.getTexto())) {
                labelErrorTelefono.setVisible(true);
                labelErrorTelefono.setToolTipText(error);

                labelIdTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
                textTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.DIRECCION_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_DIRECCION_20.getTexto())) {
                labelErrorDireccion.setVisible(true);
                labelErrorDireccion.setToolTipText(error);

                textDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
            } else if (error.equals(TextoErrores.EMAIL_VACIO.getTexto()) || error.equals(TextoErrores.MAXIMO_CARACTERES_EMAIL_40.getTexto()) || error.equals(TextoErrores.EMAIL_INVALIDO.getTexto())) {
                labelErrorEmail.setVisible(true);
                labelErrorEmail.setToolTipText(error);

                textEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pmc.getFramePrincipal().getModo()))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelSeleccionarCliente psc = new PanelSeleccionarCliente(pmc);
        pmc.getFramePrincipal().cargarPanel(pmc.getPanelCliente(), psc);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelErrorDireccion;
    private javax.swing.JLabel labelErrorEdad;
    private javax.swing.JLabel labelErrorEmail;
    private javax.swing.JLabel labelErrorNombre;
    private javax.swing.JLabel labelErrorTelefono;
    private javax.swing.JLabel labelIdTelefono;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textEdad;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
