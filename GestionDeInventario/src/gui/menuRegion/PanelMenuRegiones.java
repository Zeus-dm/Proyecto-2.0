package gui.menuRegion;

import FunGenerales.FunRegion;
import gui.FramePrincipal;
import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.menuPrincipal.PanelMenuPrincipal;

import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;

public class PanelMenuRegiones extends javax.swing.JPanel {

    private FramePrincipal fp = null;
    FunRegion controlRegion;
    String nombreRegion = null;
    int posSeleccion = 0;

    public PanelMenuRegiones(FramePrincipal fp, String nombreRegion) {
        this.fp = fp;
        this.nombreRegion = nombreRegion;
        this.controlRegion = new FunRegion(this.fp.getSistema());

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        cargarNombre();
        cargarRegiones(controlRegion.nombresRegiones());

        PanelSeleccionarRegion psr = new PanelSeleccionarRegion(this);
        fp.cargarPanel(panelRegion, psr);
    }

    private void cargarNombre() {
        List<String> listaNombresRegiones = controlRegion.nombresRegiones();
        if (!(listaNombresRegiones.isEmpty())) {
            if (nombreRegion == null) {
                nombreRegion = listaNombresRegiones.get(posSeleccion);
            } else {
                for (int i = 0; i < listaNombresRegiones.size(); i++) {
                    if(nombreRegion.equals(listaNombresRegiones.get(i))){
                        posSeleccion = i;
                        return;
                    }
                }
            }
        }
    }

    public void cargarRegiones(List<String> regiones) {
        String matriz[][] = new String[regiones.size()][1];

        for (int i = 0; i < regiones.size(); i++) {
            matriz[i][0] = "  " + regiones.get(i);
        }

        tableRegiones.setModel(new javax.swing.table.DefaultTableModel(
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

        if (posSeleccion >= 0) {
            tableRegiones.getSelectionModel().setSelectionInterval(posSeleccion, posSeleccion);
        }
    }

    public FramePrincipal getFramePrincipal() {
        return fp;
    }
    
    public JPanel getPanelRegion(){
        return panelRegion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonHome = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        scrollRegiones = new javax.swing.JScrollPane();
        tableRegiones = new javax.swing.JTable();
        buttonAgregar = new javax.swing.JButton();
        panelRegion = new javax.swing.JPanel();

        setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));

        buttonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_HOME.getColor(fp.getModo()))));
        buttonHome.setBorder(null);
        buttonHome.setBorderPainted(false);
        buttonHome.setContentAreaFilled(false);
        buttonHome.setFocusPainted(false);
        buttonHome.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonHome.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_HOME.getColor(fp.getModo()))));
        buttonHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_HOME_DRAGGED.getColor(fp.getModo()))));
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(fp.getModo())));
        labelTitulo.setText(Texto.REGIONES.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelTitulo.setPreferredSize(new java.awt.Dimension(350, 32));

        scrollRegiones.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        scrollRegiones.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode(Colores.FONDO.getColor(fp.getModo()))));
        scrollRegiones.setPreferredSize(new java.awt.Dimension(240, 340));
        scrollRegiones.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        scrollRegiones.setViewportBorder(null);

        //Scrollbar personalizada
        fp.cargarScrollBar(scrollRegiones, 0);

        tableRegiones.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.getModo())));
        tableRegiones.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableRegiones.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
        tableRegiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableRegiones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableRegiones.setGridColor(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        tableRegiones.setRowHeight(35);
        tableRegiones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableRegiones.getTableHeader().setReorderingAllowed(false);
        tableRegiones.setTableHeader(null);
        tableRegiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegionesMouseClicked(evt);
            }
        });
        scrollRegiones.setViewportView(tableRegiones);

        buttonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR.getColor(fp.getModo()))));
        buttonAgregar.setBorder(null);
        buttonAgregar.setBorderPainted(false);
        buttonAgregar.setContentAreaFilled(false);
        buttonAgregar.setFocusPainted(false);
        buttonAgregar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR.getColor(fp.getModo()))));
        buttonAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_AGREGAR_DRAGGED.getColor(fp.getModo()))));
        buttonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarActionPerformed(evt);
            }
        });

        panelRegion.setPreferredSize(new java.awt.Dimension(548, 430));
        panelRegion.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRegion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollRegiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRegion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(fp.getPanelPrincipal(), pmp);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void tableRegionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRegionesMouseClicked
        nombreRegion = null;
        posSeleccion = tableRegiones.getSelectedRow();
        cargarNombre();

        PanelSeleccionarRegion psr = new PanelSeleccionarRegion(this);
        fp.cargarPanel(panelRegion, psr);
    }//GEN-LAST:event_tableRegionesMouseClicked

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        posSeleccion = -1;
        cargarRegiones(controlRegion.nombresRegiones());
        
        PanelAgregarRegion par = new PanelAgregarRegion(this);
        fp.cargarPanel(panelRegion, par);
    }//GEN-LAST:event_buttonAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonHome;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelRegion;
    private javax.swing.JScrollPane scrollRegiones;
    private javax.swing.JTable tableRegiones;
    // End of variables declaration//GEN-END:variables
}
