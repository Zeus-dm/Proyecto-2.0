package gui.inicioSesion;

import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.TextoErrores;
import gui.TextPrompt;
import gui.menuPrincipal.PanelMenuPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelCrearUsuario extends javax.swing.JPanel {

    private PanelMenuSesion pms = null;
    private boolean modoVista = false;

    public PanelCrearUsuario(PanelMenuSesion pms) {
        this.pms = pms;

        initComponents();
    }
    
    private void recargarColores(){
        textUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textVerContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));

        labelErrorUsuario.setVisible(false);
        labelErrorPaswords.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImagen = new javax.swing.JLabel();
        labelLineaIzquierda = new javax.swing.JLabel();
        labelLineaDerecha = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        labelErrorUsuario = new javax.swing.JLabel();
        textContraseña = new javax.swing.JPasswordField();
        textVerContraseña = new javax.swing.JPasswordField();
        buttonVista = new javax.swing.JButton();
        labelErrorPaswords = new javax.swing.JLabel();
        buttonCrearCuenta = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        setPreferredSize(new java.awt.Dimension(340, 500));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/iconosMultiProposito/chefcito_redondo_100.png"))); // NOI18N

        labelLineaIzquierda.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        labelLineaIzquierda.setPreferredSize(new java.awt.Dimension(120, 2));

        labelLineaDerecha.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        labelLineaDerecha.setPreferredSize(new java.awt.Dimension(120, 2));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.CREA_CUENTA.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(240, 24));

        textUsuario.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textUsuario.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textUsuario.setPreferredSize(new java.awt.Dimension(240, 28));
        TextPrompt placeHolderUsuario = new TextPrompt(Texto.USUARIO.getTexto(), textUsuario);
        placeHolderUsuario.changeAlpha(0.75f);
        placeHolderUsuario.changeStyle(Font.ITALIC);

        labelErrorUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelErrorUsuario.setToolTipText("Aqui deberia de ir un Error");
        labelErrorUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorUsuario.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorUsuario.setVisible(false);

        textContraseña.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textContraseña.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textContraseña.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textContraseña.setPreferredSize(new java.awt.Dimension(212, 28));
        textContraseña.setEchoChar('\u2022');

        TextPrompt placeHolderPassword = new TextPrompt(Texto.PASSWORD.getTexto(), textContraseña);
        placeHolderPassword.changeAlpha(0.75f);
        placeHolderPassword.changeStyle(Font.ITALIC);

        textVerContraseña.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textVerContraseña.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textVerContraseña.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textVerContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textVerContraseña.setPreferredSize(new java.awt.Dimension(240, 28));
        textVerContraseña.setEchoChar('\u2022');

        TextPrompt placeHolderVerPassword = new TextPrompt(Texto.VER_PASSWORD.getTexto(), textVerContraseña);
        placeHolderVerPassword.changeAlpha(0.75f);
        placeHolderVerPassword.changeStyle(Font.ITALIC);

        buttonVista.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setContentAreaFilled(false);
        buttonVista.setFocusPainted(false);
        buttonVista.setPreferredSize(new java.awt.Dimension(28, 28));
        buttonVista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVistaActionPerformed(evt);
            }
        });

        labelErrorPaswords.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelErrorPaswords.setToolTipText("Aqui deberia de ir un Error");
        labelErrorPaswords.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorPaswords.setVisible(false);

        buttonCrearCuenta.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonCrearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCrearCuenta.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonCrearCuenta.setText(Texto.CREAR_CUENTA.getTexto());
        buttonCrearCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonCrearCuenta.setFocusPainted(false);
        buttonCrearCuenta.setFocusable(false);
        buttonCrearCuenta.setOpaque(true);
        buttonCrearCuenta.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCrearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCrearCuenta.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonCrearCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCrearCuenta.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonCrearCuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCrearCuentaActionPerformed(evt);
            }
        });

        buttonVolver.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonVolver.setFocusPainted(false);
        buttonVolver.setFocusable(false);
        buttonVolver.setOpaque(true);
        buttonVolver.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonVolver.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelLineaIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelImagen)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelLineaDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCrearCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textVerContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelErrorPaswords))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(labelImagen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(labelLineaIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(labelLineaDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelErrorPaswords))
                .addGap(22, 22, 22)
                .addComponent(textVerContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVistaActionPerformed
        if (modoVista) {
            modoVista = false;
            textContraseña.setEchoChar('\u2022');
            textVerContraseña.setEchoChar('\u2022');
            buttonVista.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        } else {
            modoVista = true;
            textContraseña.setEchoChar((char) 0);
            textVerContraseña.setEchoChar((char) 0);
            buttonVista.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_VISTA_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        }
    }//GEN-LAST:event_buttonVistaActionPerformed

    private void buttonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCrearCuentaActionPerformed
        recargarColores();

        try {
            String error = pms.controlUsuario.agregarUsuario(textUsuario.getText(), new String(textContraseña.getPassword()), new String(textVerContraseña.getPassword()));
            if (error != null) {
                if ((error.equals(TextoErrores.USUARIO_EXISTENTE.getTexto())) || (error.equals(TextoErrores.USUARIO_VACIO.getTexto())) || (error.equals(TextoErrores.USUARIO_MAXIMO_CARACTERES_20.getTexto()))) {
                    labelErrorUsuario.setVisible(true);
                    labelErrorUsuario.setToolTipText(error);

                    textUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
                } else {
                    labelErrorPaswords.setVisible(true);
                    labelErrorPaswords.setToolTipText(error);

                    textContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
                    textVerContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
                    buttonVista.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
                }
            } else {
                PanelMenuPrincipal pmp = new PanelMenuPrincipal(pms.getFramePrincipal());
                pms.getFramePrincipal().cargarPanel(pmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCrearCuentaActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        PanelInicioSesion pis = new PanelInicioSesion(pms);
        pms.cargarPanel(pis);
    }//GEN-LAST:event_buttonVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCrearCuenta;
    private javax.swing.JButton buttonVista;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JLabel labelErrorPaswords;
    private javax.swing.JLabel labelErrorUsuario;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelLineaDerecha;
    private javax.swing.JLabel labelLineaIzquierda;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPasswordField textContraseña;
    private javax.swing.JTextField textUsuario;
    private javax.swing.JPasswordField textVerContraseña;
    // End of variables declaration//GEN-END:variables
}
