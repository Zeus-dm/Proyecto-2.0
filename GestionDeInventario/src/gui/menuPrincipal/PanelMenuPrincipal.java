package gui.menuPrincipal;

import FunGenerales.FunReporte;
import FunGenerales.FunUsuario;
import gui.FramePrincipal;
import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.inicioSesion.PanelMenuSesion;
import gui.menuCliente.PanelMenuClientes;
import gui.menuProducto.PanelMenuProductos;
import gui.menuRegion.PanelMenuRegiones;

import java.awt.Color;

public class PanelMenuPrincipal extends javax.swing.JPanel {

    private FramePrincipal fp = null;

    public PanelMenuPrincipal(FramePrincipal fp) {
        this.fp = fp;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        labelBienvenida.setText(Texto.BIENVENIDO.getTexto() + " " + new FunUsuario(fp.getSistema()).seleccionarNombreUsuario());

        if (fp.getModo() == 0) {
            buttonModo.setToolTipText("Cambiar a Modo Claro");
        } else {
            buttonModo.setToolTipText("Cambiar a Modo Oscuro");
        }

        if (fp.isMute()) {
            cargarMute();
        } else {
            cargarSonido();
        }
    }

    private void cargarMute() {
        buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MUTE.getColor(fp.getModo()))));
        buttonSonido.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MUTE.getColor(fp.getModo()))));
        buttonSonido.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MUTE_DRAGGED.getColor(fp.getModo()))));
        buttonSonido.setToolTipText("Activar Sonido");
    }

    private void cargarSonido() {
        buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO.getColor(fp.getModo()))));
        buttonSonido.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO.getColor(fp.getModo()))));
        buttonSonido.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO_DRAGGED.getColor(fp.getModo()))));
        buttonSonido.setToolTipText("Desactivar Sonido");
    }

    public FramePrincipal getFramePrincipal() {
        return fp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonModo = new javax.swing.JButton();
        buttonSonido = new javax.swing.JButton();
        buttonReporte = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        labelBienvenida = new javax.swing.JLabel();
        labelCerrarSesion = new javax.swing.JLabel();
        buttonRegiones = new javax.swing.JButton();
        buttonClientes = new javax.swing.JButton();
        buttonProductos = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        labelImagen = new javax.swing.JLabel();

        setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));

        buttonModo.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODO.getColor(fp.getModo()))));
        buttonModo.setBorder(null);
        buttonModo.setBorderPainted(false);
        buttonModo.setContentAreaFilled(false);
        buttonModo.setFocusPainted(false);
        buttonModo.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonModo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODO.getColor(fp.getModo()))));
        buttonModo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODO_DRAGGED.getColor(fp.getModo()))));
        buttonModo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModoActionPerformed(evt);
            }
        });

        buttonSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO.getColor(fp.getModo()))));
        buttonSonido.setBorder(null);
        buttonSonido.setBorderPainted(false);
        buttonSonido.setContentAreaFilled(false);
        buttonSonido.setFocusPainted(false);
        buttonSonido.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonSonido.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO.getColor(fp.getModo()))));
        buttonSonido.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_SONIDO_DRAGGED.getColor(fp.getModo()))));
        buttonSonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSonidoActionPerformed(evt);
            }
        });

        buttonReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ARCHIVO.getColor(fp.getModo()))));
        buttonReporte.setToolTipText("Generar Reporte");
        buttonReporte.setBorder(null);
        buttonReporte.setBorderPainted(false);
        buttonReporte.setContentAreaFilled(false);
        buttonReporte.setFocusPainted(false);
        buttonReporte.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonReporte.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ARCHIVO.getColor(fp.getModo()))));
        buttonReporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ARCHIVO_DRAGGED.getColor(fp.getModo()))));
        buttonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReporteActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(fp.getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.TITULO.getTexto());

        labelBienvenida.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        labelBienvenida.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
        labelBienvenida.setText(Texto.BIENVENIDO.getTexto());
        labelBienvenida.setPreferredSize(new java.awt.Dimension(660, 32));

        labelCerrarSesion.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelCerrarSesion.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
        labelCerrarSesion.setText(Texto.CERRAR_SESION.getTexto());
        labelCerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO.getColor(fp.getModo()))));
        labelCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCerrarSesion.setPreferredSize(new java.awt.Dimension(90, 22));
        labelCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCerrarSesionMouseClicked(evt);
            }
        });
        labelCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCerrarSesion.setForeground(Color.decode(Colores.TEXTO_ERROR.getColor(fp.getModo())));
                labelCerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(fp.getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCerrarSesion.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
                labelCerrarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO.getColor(fp.getModo()))));
            }
        });

        buttonRegiones.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        buttonRegiones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonRegiones.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.getModo())));
        buttonRegiones.setText(Texto.REGIONES.getTexto());
        buttonRegiones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
        buttonRegiones.setFocusPainted(false);
        buttonRegiones.setFocusable(false);
        buttonRegiones.setOpaque(true);
        buttonRegiones.setPreferredSize(new java.awt.Dimension(130, 30));
        buttonRegiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonRegiones.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.getModo())));
                buttonRegiones.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonRegiones.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
                buttonRegiones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
        });
        buttonRegiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegionesActionPerformed(evt);
            }
        });

        buttonClientes.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        buttonClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonClientes.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.getModo())));
        buttonClientes.setText(Texto.CLIENTES.getTexto());
        buttonClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
        buttonClientes.setFocusPainted(false);
        buttonClientes.setFocusable(false);
        buttonClientes.setOpaque(true);
        buttonClientes.setPreferredSize(new java.awt.Dimension(130, 30));
        buttonClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonClientes.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.getModo())));
                buttonClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonClientes.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
                buttonClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
        });
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });

        buttonProductos.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        buttonProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonProductos.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.getModo())));
        buttonProductos.setText(Texto.PRODUCTOS.getTexto());
        buttonProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
        buttonProductos.setFocusPainted(false);
        buttonProductos.setFocusable(false);
        buttonProductos.setOpaque(true);
        buttonProductos.setPreferredSize(new java.awt.Dimension(130, 30));
        buttonProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonProductos.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.getModo())));
                buttonProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonProductos.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
                buttonProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
        });
        buttonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductosActionPerformed(evt);
            }
        });

        buttonSalir.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        buttonSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonSalir.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.getModo())));
        buttonSalir.setText(Texto.SALIR.getTexto());
        buttonSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
        buttonSalir.setFocusPainted(false);
        buttonSalir.setFocusable(false);
        buttonSalir.setOpaque(true);
        buttonSalir.setPreferredSize(new java.awt.Dimension(130, 30));
        buttonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSalir.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(fp.getModo())));
                buttonSalir.setForeground(Color.decode(Colores.TEXTO_ERROR.getColor(fp.getModo())));
                buttonSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonSalir.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
                buttonSalir.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(fp.getModo())));
                buttonSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
        });
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/imagenes/iconosMenuPrincipal/chefcito_redondo_250.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSonido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRegiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelImagen)
                        .addGap(175, 175, 175))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSonido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelTitulo)
                .addGap(30, 30, 30)
                .addComponent(labelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(buttonRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelImagen)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonModoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModoActionPerformed
        fp.cambiarModo();
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(fp.getPanelPrincipal(), pmp);
    }//GEN-LAST:event_buttonModoActionPerformed

    private void buttonSonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSonidoActionPerformed
        if (fp.isMute()) {
            fp.continuarMusica();
            cargarSonido();
        } else {
            fp.pausarMusica();
            cargarMute();
        }
    }//GEN-LAST:event_buttonSonidoActionPerformed

    private void buttonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReporteActionPerformed
        FunReporte.generarReporte(fp.getSistema());
        
        DialogoConfirmarReporte dcr = new DialogoConfirmarReporte(new javax.swing.JFrame(), true, this);
        dcr.setLocationRelativeTo(this);
        dcr.setVisible(true);
    }//GEN-LAST:event_buttonReporteActionPerformed

    private void labelCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCerrarSesionMouseClicked
        new FunUsuario(fp.getSistema()).eliminarUsuario();
        PanelMenuSesion pms = new PanelMenuSesion(fp);
        fp.cargarPanel(fp.getPanelPrincipal(), pms);
    }//GEN-LAST:event_labelCerrarSesionMouseClicked

    private void buttonRegionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegionesActionPerformed
        PanelMenuRegiones pmr = new PanelMenuRegiones(fp, null);
        fp.cargarPanel(fp.getPanelPrincipal(), pmr);
    }//GEN-LAST:event_buttonRegionesActionPerformed

    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClientesActionPerformed
        PanelMenuClientes pmc = new PanelMenuClientes(fp);
        fp.cargarPanel(fp.getPanelPrincipal(), pmc);
    }//GEN-LAST:event_buttonClientesActionPerformed

    private void buttonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductosActionPerformed
        PanelMenuProductos pmp = new PanelMenuProductos(fp);
        fp.cargarPanel(fp.getPanelPrincipal(), pmp);
    }//GEN-LAST:event_buttonProductosActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonModo;
    private javax.swing.JButton buttonProductos;
    private javax.swing.JButton buttonRegiones;
    private javax.swing.JButton buttonReporte;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JButton buttonSonido;
    private javax.swing.JLabel labelBienvenida;
    private javax.swing.JLabel labelCerrarSesion;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
