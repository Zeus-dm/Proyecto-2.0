package gui.inicioSesion;

import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.TextPrompt;
import gui.menuPrincipal.PanelMenuPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelInicioSesion extends javax.swing.JPanel {

    private PanelMenuSesion pms = null;
    private boolean modoVista = false;

    public PanelInicioSesion(PanelMenuSesion pms) {
        this.pms = pms;

        initComponents();
    }

    private void recargarColores() {
        textUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImagen = new javax.swing.JLabel();
        labelLineaIzquierda = new javax.swing.JLabel();
        labelLineaDerecha = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        textContraseña = new javax.swing.JPasswordField();
        buttonVista = new javax.swing.JButton();
        buttonIniciarSesion = new javax.swing.JButton();
        labelPregunta = new javax.swing.JLabel();
        labelRegistro = new javax.swing.JLabel();
        labelError = new javax.swing.JLabel();

        setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        setPreferredSize(new java.awt.Dimension(340, 500));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/iconosMultiProposito/chefcito_redondo_100.gif"))); // NOI18N
        labelImagen.setFocusable(false);

        labelLineaIzquierda.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        labelLineaIzquierda.setFocusable(false);
        labelLineaIzquierda.setPreferredSize(new java.awt.Dimension(120, 2));

        labelLineaDerecha.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        labelLineaDerecha.setFocusable(false);
        labelLineaDerecha.setPreferredSize(new java.awt.Dimension(120, 2));

        textUsuario.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textUsuario.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textUsuario.setPreferredSize(new java.awt.Dimension(240, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.USUARIO.getTexto(), textUsuario);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);

        textContraseña.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textContraseña.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textContraseña.setPreferredSize(new java.awt.Dimension(212, 28));
        textContraseña.setEchoChar('\u2022');

        placeHolder = new TextPrompt(Texto.PASSWORD.getTexto(), textContraseña);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);

        buttonVista.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setContentAreaFilled(false);
        buttonVista.setFocusPainted(false);
        buttonVista.setFocusable(false);
        buttonVista.setPreferredSize(new java.awt.Dimension(28, 28));
        buttonVista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        buttonVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVistaActionPerformed(evt);
            }
        });

        buttonIniciarSesion.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonIniciarSesion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonIniciarSesion.setText(Texto.INICIAR_SESION.getTexto());
        buttonIniciarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonIniciarSesion.setFocusPainted(false);
        buttonIniciarSesion.setFocusable(false);
        buttonIniciarSesion.setOpaque(true);
        buttonIniciarSesion.setPreferredSize(new java.awt.Dimension(240, 30));
        buttonIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonIniciarSesion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonIniciarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonIniciarSesion.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonIniciarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIniciarSesionActionPerformed(evt);
            }
        });

        labelPregunta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPregunta.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        labelPregunta.setText(Texto.NO_CUENTA.getTexto());
        labelPregunta.setFocusable(false);

        labelRegistro.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelRegistro.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        labelRegistro.setText(Texto.REGISTRATE.getTexto());
        labelRegistro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo()))));
        labelRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRegistro.setFocusable(false);
        labelRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegistroMouseClicked(evt);
            }
        });
        labelRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRegistro.setForeground(Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo())));
                labelRegistro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRegistro.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
                labelRegistro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo()))));
            }
        });

        labelError.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelError.setToolTipText("Aqui deberia de ir un Error");
        labelError.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelError.setPreferredSize(new java.awt.Dimension(28, 28));
        labelError.setVisible(false);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(labelPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRegistro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(buttonVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(labelImagen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(labelLineaIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(labelLineaDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(buttonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPregunta)
                    .addComponent(labelRegistro))
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistroMouseClicked
        PanelCrearUsuario pcu = new PanelCrearUsuario(pms);
        pms.cargarPanel(pcu);
    }//GEN-LAST:event_labelRegistroMouseClicked

    private void buttonVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVistaActionPerformed
        if (modoVista) {
            modoVista = false;
            textContraseña.setEchoChar('\u2022');
            buttonVista.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_NO_VISTA_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        } else {
            modoVista = true;
            textContraseña.setEchoChar((char) 0);
            buttonVista.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_VISTA.getColor(pms.getFramePrincipal().getModo()))));
            buttonVista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_VISTA_DRAGGED.getColor(pms.getFramePrincipal().getModo()))));
        }
    }//GEN-LAST:event_buttonVistaActionPerformed

    private void buttonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIniciarSesionActionPerformed
        recargarColores();

        try {
            String error = pms.controlUsuario.iniciarSesion(textUsuario.getText(), new String(textContraseña.getPassword()));
            if (error != null) {
                labelError.setVisible(true);
                labelError.setToolTipText(error);

                textUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
                textContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
                buttonVista.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
            } else {
                PanelMenuPrincipal pmp = new PanelMenuPrincipal(pms.getFramePrincipal());
                pms.getFramePrincipal().cargarPanel(pmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonIniciarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonIniciarSesion;
    private javax.swing.JButton buttonVista;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelLineaDerecha;
    private javax.swing.JLabel labelLineaIzquierda;
    private javax.swing.JLabel labelPregunta;
    private javax.swing.JLabel labelRegistro;
    private javax.swing.JPasswordField textContraseña;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
