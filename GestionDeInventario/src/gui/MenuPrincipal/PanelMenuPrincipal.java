package gui.MenuPrincipal;

import gui.FramePrincipal;
import FunGenerales.FunUsuario;
import enumeraciones.Colores;
import enumeraciones.Musica;
import enumeraciones.Texto;
import gui.MenuClientes.PanelMenuClientes;
import gui.MenuProductos.PanelMenuProductos;
import gui.MenuRegiones.PanelMenuRegiones;
import gui.MenuSesion.DialogMenuSesion;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PanelMenuPrincipal extends javax.swing.JPanel {
    private FramePrincipal fp = null;
    private final FunUsuario controladorUsuario;
    
    public PanelMenuPrincipal(FramePrincipal fp) {
        this.fp = fp;
        controladorUsuario = new FunUsuario(this.fp.getSistema());
        
        initComponents();
        
        if(controladorUsuario.existenciaUsuario() == false){
            menuSesion();
        }
        
        iniciarDatos();
    }

    private void iniciarDatos() {
        labelBienvenida.setText(Texto.BIENVENIDO.getTexto() + " " + controladorUsuario.seleccionarNombreUsuario());
        
        if(fp.musica){ //cargar musica solo 1 vez y al iniciar el programa
            try {
                fp.sonido();
                fp.musica = false;
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                Logger.getLogger(PanelMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (fp.mute) {
            buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MUTE.getColor(fp.modo))));
            buttonSonido.setToolTipText("Activar Sonido");
        } else {
            buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO.getColor(fp.modo))));
            buttonSonido.setToolTipText("Desactivar Sonido");
        }

        if (fp.modo == 0) {
            buttonOpcion.setToolTipText("Cambiar a Modo Claro");
        } else {
            buttonOpcion.setToolTipText("Cambiar a Modo Oscuro");
        }

        buttonOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODO.getColor(fp.modo))));

        switch (fp.imagen) {
            case 0 ->
                labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/chefcito_150.png"))); // NOI18N
            case 1 ->
                labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/seba_150.png"))); // NOI18N
        }
    }
    
    private void menuSesion() {
        DialogMenuSesion dms = new DialogMenuSesion(new javax.swing.JFrame(), true, fp);
        dms.setLocationRelativeTo(this);
        dms.setVisible(true);
        
        if(controladorUsuario.existenciaUsuario() == false){
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        buttonReporte = new javax.swing.JButton();
        buttonSonido = new javax.swing.JButton();
        buttonOpcion = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        labelBienvenida = new javax.swing.JLabel();
        buttonRegiones = new javax.swing.JButton();
        buttonClientes = new javax.swing.JButton();
        buttonProductos = new javax.swing.JButton();
        buttonCerrarSesion = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        jPanelImagen = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(400, 450));
        setPreferredSize(new java.awt.Dimension(400, 450));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        jPanelFondo.setMaximumSize(new java.awt.Dimension(400, 450));
        jPanelFondo.setMinimumSize(new java.awt.Dimension(400, 450));

        buttonReporte.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        buttonReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource( Colores.ICONO_ARCHIVO.getColor(fp.modo) )));
        buttonReporte.setToolTipText("Generar Reporte");
        buttonReporte.setBorder(null);
        buttonReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonReporte.setFocusable(false);
        buttonReporte.setPreferredSize(new java.awt.Dimension(32, 32));

        buttonSonido.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource( Colores.ICONO_SONIDO.getColor(fp.modo) )));
        buttonSonido.setToolTipText("Activar/Desactivar Sonido");
        buttonSonido.setBorder(null);
        buttonSonido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSonido.setFocusable(false);
        buttonSonido.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonSonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSonidoActionPerformed(evt);
            }
        });

        buttonOpcion.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        buttonOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODO.getColor(fp.modo))));
        buttonOpcion.setToolTipText("Configurar Colores");
        buttonOpcion.setBorder(null);
        buttonOpcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonOpcion.setFocusable(false);
        buttonOpcion.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpcionActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 34)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(fp.modo)));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.TITULO.getTexto());
        labelTitulo.setPreferredSize(new java.awt.Dimension(388, 50));

        labelBienvenida.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        labelBienvenida.setForeground(Color.decode(Colores.TEXTO.getColor(fp.modo)));
        labelBienvenida.setText(Texto.BIENVENIDO.getTexto());
        labelBienvenida.setPreferredSize(new java.awt.Dimension(354, 40));

        buttonRegiones.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonRegiones.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonRegiones.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonRegiones.setText(Texto.REGIONES.getTexto());
        buttonRegiones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonRegiones.setFocusable(false);
        buttonRegiones.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonRegiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegionesActionPerformed(evt);
            }
        });

        buttonClientes.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonClientes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonClientes.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonClientes.setText(Texto.CLIENTES.getTexto());
        buttonClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonClientes.setFocusable(false);
        buttonClientes.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });

        buttonProductos.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonProductos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonProductos.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonProductos.setText(Texto.PRODUCTOS.getTexto());
        buttonProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonProductos.setFocusable(false);
        buttonProductos.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductosActionPerformed(evt);
            }
        });

        buttonCerrarSesion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCerrarSesion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonCerrarSesion.setText("Cerrar Sesión");
        buttonCerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonCerrarSesion.setFocusable(false);
        buttonCerrarSesion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarSesionActionPerformed(evt);
            }
        });

        buttonSalir.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.modo)));
        buttonSalir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonSalir.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.modo)));
        buttonSalir.setText(Texto.SALIR.getTexto());
        buttonSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        buttonSalir.setFocusable(false);
        buttonSalir.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        jPanelImagen.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/chefcito_150.png"))); // NOI18N
        labelImagen.setToolTipText("Cambiar Canción");
        labelImagen.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.modo))));
        labelImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelImagen.setPreferredSize(new java.awt.Dimension(150, 150));
        labelImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelImagenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelImagenLayout = new javax.swing.GroupLayout(jPanelImagen);
        jPanelImagen.setLayout(jPanelImagenLayout);
        jPanelImagenLayout.setHorizontalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagenLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelImagenLayout.setVerticalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagenLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonRegiones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonProductos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonCerrarSesion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(labelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(buttonRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        labelTitulo.getAccessibleContext().setAccessibleName("labelTitulo");
        labelBienvenida.getAccessibleContext().setAccessibleName("labelBienvenida");
        buttonRegiones.getAccessibleContext().setAccessibleName("buttonRegiones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegionesActionPerformed
        PanelMenuRegiones pmr = new PanelMenuRegiones(fp);
        fp.cargarPanel(pmr);
    }//GEN-LAST:event_buttonRegionesActionPerformed

    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClientesActionPerformed
        PanelMenuClientes pmc = new PanelMenuClientes(fp);
        fp.cargarPanel(pmc);
    }//GEN-LAST:event_buttonClientesActionPerformed

    private void buttonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductosActionPerformed
        PanelMenuProductos pmp = new PanelMenuProductos(fp);
        fp.cargarPanel(pmp);
    }//GEN-LAST:event_buttonProductosActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonSonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSonidoActionPerformed
        if (fp.mute) {
            fp.mute = false;
            buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO.getColor(fp.modo))));
            fp.sonido.start();
            fp.sonido.loop(-1);
            buttonSonido.setToolTipText("Desactivar Sonido");
        } else {
            fp.mute = true;
            buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MUTE.getColor(fp.modo))));
            fp.sonido.stop();
            buttonSonido.setToolTipText("Activar Sonido");
        }
    }//GEN-LAST:event_buttonSonidoActionPerformed

    private void buttonOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpcionActionPerformed
        if (fp.modo == 0) {
            fp.modo = 1;
        } else {
            fp.modo = 0;
        }

        buttonOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODO.getColor(fp.modo))));
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(pmp);
    }//GEN-LAST:event_buttonOpcionActionPerformed

    private void labelImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImagenMouseClicked
        if (fp.imagen == 0) {
            fp.imagen = 1;
            labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/seba_150.png"))); // NOI18N
            Musica.MUSICA_ACTUAL.setMusica(Musica.CHAYANNE_TORERO.getMusica());
        } else if (fp.imagen == 1) {
            fp.imagen = 0;
            labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/chefcito_150.png"))); // NOI18N
            Musica.MUSICA_ACTUAL.setMusica(Musica.CAMILLE_LE_FESTIN.getMusica());
        }

        try {
            fp.sonido.close();
            fp.sonido();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(PanelMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (fp.mute) {
            fp.sonido.stop();
        }
    }//GEN-LAST:event_labelImagenMouseClicked

    private void buttonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarSesionActionPerformed
        controladorUsuario.eliminarUsuario();
        menuSesion();
        labelBienvenida.setText(Texto.BIENVENIDO.getTexto() + " " + controladorUsuario.seleccionarNombreUsuario());
    }//GEN-LAST:event_buttonCerrarSesionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCerrarSesion;
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonOpcion;
    private javax.swing.JButton buttonProductos;
    private javax.swing.JButton buttonRegiones;
    private javax.swing.JButton buttonReporte;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JButton buttonSonido;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelImagen;
    private javax.swing.JLabel labelBienvenida;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
