
package gui;

import FunGenerales.FunCliente;
import FunGenerales.FunProducto;
import FunGenerales.FunRegion;
import FunGenerales.FunSucursal;
import domain.Sistema;
import enumeraciones.Musica;
import enumeraciones.Texto;
import gui.MenuPrincipal.PanelMenuPrincipal;

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
    public int imagen = 0;
    public int modo = 0;
    
    public FramePrincipal(Sistema sistema) throws SQLException, LineUnavailableException, IOException, UnsupportedAudioFileException {
        this.sistema = sistema;
        
        initComponents();
        
        sonido();
        iniciarPrograma();
    }
    
    public final void sonido() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream( Musica.MUSICA_ACTUAL.getMusica() ));
        AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
        sonido = AudioSystem.getClip();
        sonido.open(ais);
        sonido.loop(-1);
    }
    
    private void iniciarPrograma() throws SQLException {
        sistema.setRegiones(FunRegion.listarRegiones());
        for (int i = 0; i < sistema.getRegiones().size(); i++) {
            sistema.getRegiones().get(i).setSucursales(FunSucursal.listarSucursales(sistema.getRegiones().get(i)));
        }
        
        sistema.setClientes(FunCliente.listarClientes());
        sistema.setProductos(FunProducto.listarProductos());
        
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