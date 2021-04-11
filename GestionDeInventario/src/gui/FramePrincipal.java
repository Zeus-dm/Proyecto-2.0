
package gui;

import FunGenerales.FunCliente;
import FunGenerales.FunRegion;
import domain.Sistema;
import enumeraciones.Texto;
import gui.MenuPrincipal.PanelMenuPrincipal;
import gui.MenuSesion.DialogMenuSesion;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.sound.sampled.*;
import javax.swing.JPanel;

public class FramePrincipal extends javax.swing.JFrame {
    private Sistema sistema = null;
    public Clip sonido = null;
    public boolean mute = false;
    public boolean imagenSeba = true;
    public int modo = 0;
    
    public FramePrincipal(Sistema sistema) throws SQLException, LineUnavailableException, IOException, UnsupportedAudioFileException {
        this.sistema = sistema;
        
        initComponents();
        
        menuSesion();
        if( !(sistema.verificarExistenciaUsuario()) ){
            System.exit(0);
        }
        
        sonido();
        iniciarPrograma();
    }
    
    public final void sonido() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream("/gui/musica/chayanne_torero.wav"));
        AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
        sonido = AudioSystem.getClip();
        sonido.open(ais);
        sonido.loop(-1);
    }
    
    private void menuSesion() {
        DialogMenuSesion dms = new DialogMenuSesion(new javax.swing.JFrame(), true, this);
        dms.setLocationRelativeTo(this);
        dms.setVisible(true);
    }
    
    private void iniciarPrograma() throws SQLException {
        sistema.setRegiones(FunRegion.listarRegiones());
        sistema.setClientes(FunCliente.listarClientes());
        
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(this);
        cargarPanel(pmp);
    }
    
    public final void cargarPanel(JPanel nuevoPanel) {
        panelPrincipal.removeAll();
        panelPrincipal.add(nuevoPanel);
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public Sistema getSistema() {
        return sistema;
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
        setPreferredSize(new java.awt.Dimension(415, 490));
        setResizable(false);

        panelPrincipal.setMaximumSize(new java.awt.Dimension(400, 450));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(400, 450));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(400, 450));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}