package gui.inicioSesion;

import FunGenerales.FunUsuario;
import gui.FramePrincipal;
import enumeraciones.Colores;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelMenuSesion extends javax.swing.JPanel {

    private FramePrincipal fp = null;
    FunUsuario controlUsuario;

    public PanelMenuSesion(FramePrincipal fp) {
        this.fp = fp;
        controlUsuario = new FunUsuario(this.fp.getSistema());

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        PanelInicioSesion pis = new PanelInicioSesion(this);
        fp.cargarPanel(panelSesion, pis);
    }

    public FramePrincipal getFramePrincipal() {
        return fp;
    }
    
    public JPanel getPanelSesion(){
        return panelSesion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCerrar = new javax.swing.JButton();
        panelSesion = new javax.swing.JPanel();

        setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));

        buttonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_CERRAR.getColor(fp.getModo()))));
        buttonCerrar.setBorder(null);
        buttonCerrar.setBorderPainted(false);
        buttonCerrar.setContentAreaFilled(false);
        buttonCerrar.setFocusPainted(false);
        buttonCerrar.setFocusable(false);
        buttonCerrar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_CERRAR.getColor(fp.getModo()))));
        buttonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_CERRAR_DRAGGED.getColor(fp.getModo()))));
        buttonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarActionPerformed(evt);
            }
        });

        panelSesion.setPreferredSize(new java.awt.Dimension(340, 500));
        panelSesion.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(buttonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCerrar;
    private javax.swing.JPanel panelSesion;
    // End of variables declaration//GEN-END:variables
}
