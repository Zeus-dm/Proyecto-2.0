package gui;

import FunGenerales.FunCliente;
import FunGenerales.FunProducto;
import domain.Sistema;
import enumeraciones.Musica;
import enumeraciones.Texto;
import gui.inicioSesion.PanelMenuSesion;
import java.awt.Image;
import java.awt.Toolkit;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.JPanel;

public class FramePrincipal extends javax.swing.JFrame {

    private Sistema sistema = null;
    private Clip sonido = null;
    private boolean mute = false;
    private int modo = 0;

    public FramePrincipal(Sistema sistema) {
        this.sistema = sistema;

        initComponents();

        iniciarPrograma();
    }

    private void iniciarPrograma() {
        try {
            //cargar datos
            new FunCliente(sistema).listarClientes();
            new FunProducto(sistema).listarProductos();
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            iniciarMusica();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PanelMenuSesion pms = new PanelMenuSesion(this);
        cargarPanel(pms);
    }

    //Metodos para la musica
    public boolean isMute() {
        return mute;
    }

    public void pausarMusica() {
        sonido.stop();
        mute = true;
    }

    public void continuarMusica() {
        sonido.start();
        sonido.loop(-1);
        mute = false;
    }

    private void iniciarMusica() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream(Musica.MUSICA_ACTUAL.getMusica()));
        AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
        sonido = AudioSystem.getClip();
        sonido.open(ais);
        sonido.loop(-1);
    }

    //Metodos para el modo oscuro o claro
    public int getModo() {
        return modo;
    }

    public void cambiarModo() {
        if (modo == 0) {
            modo = 1;
        } else {
            modo = 0;
        }
    }

    //Metodos para el sistema
    public Sistema getSistema() {
        return sistema;
    }

    //Metodos para el panel
    public final void cargarPanel(JPanel nuevoPanel) {
        panelPrincipal.removeAll();
        panelPrincipal.add(nuevoPanel);
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("gui/imagenes/chefcito_icon_80.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Texto.TITULO.getTexto());
        setIconImage(getIconImage());
        setName("framePrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        panelPrincipal.setPreferredSize(new java.awt.Dimension(800, 500));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int xx, xy;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
