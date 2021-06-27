
package gui.menuPrincipal;

import enumeraciones.Colores;
import enumeraciones.Texto;
import java.awt.Color;

public class DialogoConfirmarReporte extends javax.swing.JDialog {
    
    PanelMenuPrincipal pmp = null;
    
    public DialogoConfirmarReporte(java.awt.Frame parent, boolean modal, PanelMenuPrincipal pmp) {
        super(parent, modal);
        this.pmp = pmp;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConfirmacion = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
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

        panelConfirmacion.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        panelConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        panelConfirmacion.setPreferredSize(new java.awt.Dimension(310, 135));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pmp.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.CONFIRMACION_REPORTE.getTexto());

        buttonOK.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        buttonOK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonOK.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pmp.getFramePrincipal().getModo())));
        buttonOK.setText(Texto.OK.getTexto());
        buttonOK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        buttonOK.setFocusPainted(false);
        buttonOK.setFocusable(false);
        buttonOK.setOpaque(true);
        buttonOK.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonOK.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pmp.getFramePrincipal().getModo())));
                buttonOK.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonOK.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
                buttonOK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
            }
        });
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConfirmacionLayout = new javax.swing.GroupLayout(panelConfirmacion);
        panelConfirmacion.setLayout(panelConfirmacionLayout);
        panelConfirmacionLayout.setHorizontalGroup(
            panelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelConfirmacionLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 99, Short.MAX_VALUE))
        );
        panelConfirmacionLayout.setVerticalGroup(
            panelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfirmacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTitulo)
                .addGap(30, 30, 30)
                .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        setVisible(false);
    }//GEN-LAST:event_buttonOKActionPerformed
    
    private int xx, xy;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        setLocation(x-xx, y-xy);
    }//GEN-LAST:event_formMouseDragged
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOK;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelConfirmacion;
    // End of variables declaration//GEN-END:variables
}
