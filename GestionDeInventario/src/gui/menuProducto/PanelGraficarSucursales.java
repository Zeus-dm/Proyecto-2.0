package gui.menuProducto;

import FunGenerales.FunGraficoSucursales;
import enumeraciones.Colores;
import java.awt.BorderLayout;

import java.awt.Color;
import java.util.List;

public class PanelGraficarSucursales extends javax.swing.JPanel {

    PanelMenuProductos pmp = null;

    public PanelGraficarSucursales(PanelMenuProductos pmp) {
        this.pmp = pmp;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        List<String> datos = pmp.controlProducto.seleccionarProducto(pmp.barCode);
            
        textNombre.setText(datos.get(0));
        
        cargarGrafico();
    }
    
    private void cargarGrafico(){
        FunGraficoSucursales fgs = new FunGraficoSucursales(pmp.barCode, pmp.controlProducto, pmp.getFramePrincipal().getModo(), 1);
        
        panelGrafico.setLayout(new BorderLayout());
        panelGrafico.add(fgs.cargarGrafico(), BorderLayout.CENTER);
        
        panelGrafico.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textNombre = new javax.swing.JLabel();
        panelGrafico = new javax.swing.JPanel();
        buttonCerrar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        setPreferredSize(new java.awt.Dimension(548, 430));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TITULO.getColor(pmp.getFramePrincipal().getModo())));
        textNombre.setText("(Nombre Producto)");
        textNombre.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        textNombre.setPreferredSize(new java.awt.Dimension(450, 32));

        panelGrafico.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        panelGrafico.setPreferredSize(new java.awt.Dimension(536, 353));

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        buttonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_CERRAR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonCerrar.setBorder(null);
        buttonCerrar.setBorderPainted(false);
        buttonCerrar.setContentAreaFilled(false);
        buttonCerrar.setFocusPainted(false);
        buttonCerrar.setFocusable(false);
        buttonCerrar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_CERRAR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_CERRAR_DRAGGED.getColor(pmp.getFramePrincipal().getModo()))));
        buttonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGrafico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarActionPerformed
        PanelSeleccionarProducto psp = new PanelSeleccionarProducto(pmp);
        pmp.cargarPanel(psp);
    }//GEN-LAST:event_buttonCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCerrar;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JLabel textNombre;
    // End of variables declaration//GEN-END:variables
}
