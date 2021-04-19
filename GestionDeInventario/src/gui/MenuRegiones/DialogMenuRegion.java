
package gui.MenuRegiones;

import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.FramePrincipal;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DialogMenuRegion extends javax.swing.JDialog {
    private FramePrincipal fp = null;
    
    public DialogMenuRegion(java.awt.Frame parent, boolean modal, FramePrincipal fp, int id) {
        super(parent, modal);
        this.fp = fp;
        
        initComponents();
        
        iniciarFrame(id);
    }
    
    private void iniciarFrame(int id){
        setIconImage(new ImageIcon("src/gui/imagenes/chefcito_icon_80.png").getImage());
        
        switch (id) {
            case 1 -> {
                PanelCrearRegion pcr = new PanelCrearRegion(this);
                cargarPanel(pcr);
            }
            case 2 -> {
                PanelEliminarRegion per = new PanelEliminarRegion(this);
                cargarPanel(per);
            }
            case 3 -> {
                PanelModificarRegion pmr = new PanelModificarRegion(this);
                cargarPanel(pmr);
            }
        }
    }
    
    public final void cargarPanel(JPanel nuevoPanel){
        jPanelPrincipal.removeAll();
        jPanelPrincipal.add(nuevoPanel);
        jPanelPrincipal.repaint();
        jPanelPrincipal.revalidate();
    }
    
    public FramePrincipal getFramePrincipal(){
        return fp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(Texto.TITULO.getTexto());
        setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setResizable(false);

        jPanelPrincipal.setBackground(Color.decode(Colores.FONDO.getColor(fp.modo)));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(350, 220));
        jPanelPrincipal.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}