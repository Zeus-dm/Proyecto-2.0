package gui.menuRegion;

import FunGenerales.FunSucursal;
import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.util.List;

public class PanelSeleccionarRegion extends javax.swing.JPanel {

    PanelMenuRegiones pmr = null;
    FunSucursal controlSucursal = null;

    public PanelSeleccionarRegion(PanelMenuRegiones pmr) {
        this.pmr = pmr;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        if (pmr.nombreRegion != null) {
            textNombre.setText(pmr.nombreRegion);
            controlSucursal = new FunSucursal(pmr.getFramePrincipal().getSistema().obtenerRegion(pmr.nombreRegion), pmr.getFramePrincipal().getSistema());
            cargarSucursales(controlSucursal.nombresSucursales());
        }else{
            buttonAgregarSucursal.setVisible(false);
        }
    }
    
    public void cargarSucursales(List<String> sucursales) {
        String matriz[][] = new String[sucursales.size()][1];

        for (int i = 0; i < sucursales.size(); i++) {
            matriz[i][0] = "  " + sucursales.get(i);
        }

        tableSucursales.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    ""
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNombre = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        labelSucursales = new javax.swing.JLabel();
        panelSucursales = new javax.swing.JPanel();
        buttonAgregarSucursal = new javax.swing.JButton();
        scrollSucursales = new javax.swing.JScrollPane();
        tableSucursales = new javax.swing.JTable();

        setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));

        panelNombre.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(350, 16));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        textNombre.setText("(Nombre Region)");

        buttonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pmr.getFramePrincipal().getModo()))));
        buttonModificar.setBorder(null);
        buttonModificar.setBorderPainted(false);
        buttonModificar.setContentAreaFilled(false);
        buttonModificar.setFocusPainted(false);
        buttonModificar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pmr.getFramePrincipal().getModo()))));
        buttonModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_DRAGGED.getColor(pmr.getFramePrincipal().getModo()))));
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pmr.getFramePrincipal().getModo()))));
        buttonEliminar.setBorder(null);
        buttonEliminar.setBorderPainted(false);
        buttonEliminar.setContentAreaFilled(false);
        buttonEliminar.setFocusPainted(false);
        buttonEliminar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pmr.getFramePrincipal().getModo()))));
        buttonEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_DRAGGED.getColor(pmr.getFramePrincipal().getModo()))));
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNombreLayout = new javax.swing.GroupLayout(panelNombre);
        panelNombre.setLayout(panelNombreLayout);
        panelNombreLayout.setHorizontalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelNombreLayout.setVerticalGroup(
            panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombreLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNombreLayout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelNombreLayout.createSequentialGroup()
                        .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        labelSucursales.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelSucursales.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmr.getFramePrincipal().getModo())));
        labelSucursales.setText(Texto.SUCURSALES.getTexto());
        labelSucursales.setPreferredSize(new java.awt.Dimension(350, 16));

        panelSucursales.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        panelSucursales.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmr.getFramePrincipal().getModo()))));
        panelSucursales.setPreferredSize(new java.awt.Dimension(536, 323));

        buttonAgregarSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAgregarSucursal.setBorder(null);
        buttonAgregarSucursal.setBorderPainted(false);
        buttonAgregarSucursal.setContentAreaFilled(false);
        buttonAgregarSucursal.setFocusPainted(false);
        buttonAgregarSucursal.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAgregarSucursal.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAgregarSucursal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR_DRAGGED.getColor(pmr.getFramePrincipal().getModo()))));
        buttonAgregarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarSucursalActionPerformed(evt);
            }
        });

        scrollSucursales.setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        scrollSucursales.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo()))));
        scrollSucursales.setPreferredSize(new java.awt.Dimension(450, 309));
        scrollSucursales.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        scrollSucursales.setViewportBorder(null);

        //Scrollbar personalizada
        pmr.getFramePrincipal().cargarScrollBar(scrollSucursales, 0);

        tableSucursales.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(pmr.getFramePrincipal().getModo())));
        tableSucursales.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableSucursales.setForeground(Color.decode(Colores.TEXTO.getColor(pmr.getFramePrincipal().getModo())));
        tableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableSucursales.setGridColor(Color.decode(Colores.FONDO.getColor(pmr.getFramePrincipal().getModo())));
        tableSucursales.setRowHeight(30);
        tableSucursales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSucursales.getTableHeader().setReorderingAllowed(false);
        tableSucursales.setTableHeader(null);
        tableSucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSucursalesMouseClicked(evt);
            }
        });
        scrollSucursales.setViewportView(tableSucursales);

        javax.swing.GroupLayout panelSucursalesLayout = new javax.swing.GroupLayout(panelSucursales);
        panelSucursales.setLayout(panelSucursalesLayout);
        panelSucursalesLayout.setHorizontalGroup(
            panelSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSucursalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(buttonAgregarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSucursalesLayout.setVerticalGroup(
            panelSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSucursalesLayout.createSequentialGroup()
                .addGroup(panelSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSucursalesLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(buttonAgregarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSucursalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAgregarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarSucursalActionPerformed
        
    }//GEN-LAST:event_buttonAgregarSucursalActionPerformed

    private void tableSucursalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSucursalesMouseClicked
        
    }//GEN-LAST:event_tableSucursalesMouseClicked

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        PanelModificarRegion pmod = new PanelModificarRegion(pmr);
        pmr.cargarPanel(pmod);
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        DialogoConfirmarEliminarRegion dcer = new DialogoConfirmarEliminarRegion(new javax.swing.JFrame(), true, pmr);
        dcer.setLocationRelativeTo(this);
        dcer.setVisible(true);
    }//GEN-LAST:event_buttonEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregarSucursal;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSucursales;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelSucursales;
    private javax.swing.JScrollPane scrollSucursales;
    private javax.swing.JTable tableSucursales;
    private javax.swing.JLabel textNombre;
    // End of variables declaration//GEN-END:variables
}
