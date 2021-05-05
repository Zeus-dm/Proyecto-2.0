package gui.menuCliente;

import FunGenerales.FunCliente;
import gui.FramePrincipal;
import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.MyScrollBarUI;
import gui.menuPrincipal.PanelMenuPrincipal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

public class PanelMenuClientes extends javax.swing.JPanel {

    private FramePrincipal fp = null;
    FunCliente controlCliente;
    int idCliente = -1;
    int posSeleccion = 0;

    public PanelMenuClientes(FramePrincipal fp) {
        this.fp = fp;
        this.controlCliente = new FunCliente(this.fp.getSistema());

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        cargarClientes(controlCliente.nombresClientes());
        cargarId();

        PanelSeleccionarCliente psc = new PanelSeleccionarCliente(this);
        cargarPanel(psc);
    }

    private void cargarId() {
        List<Integer> listaIdsCliente = controlCliente.idsClientes();
        if (!(listaIdsCliente.isEmpty())) {
            idCliente = listaIdsCliente.get(posSeleccion);
        }
    }

    public void cargarClientes(List<String> clientes) {
        String matriz[][] = new String[clientes.size()][1];

        for (int i = 0; i < clientes.size(); i++) {
            matriz[i][0] = "  " + clientes.get(i);
        }

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
            tableClientes.getSelectionModel().setSelectionInterval(posSeleccion, posSeleccion);
        }
    }

    //Metodos para el panel
    public final void cargarPanel(JPanel nuevoPanel) {
        panelCliente.removeAll();
        panelCliente.add(nuevoPanel);
        panelCliente.repaint();
        panelCliente.revalidate();
    }

    public FramePrincipal getFramePrincipal() {
        return fp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonHome = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        scrollClientes = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        buttonAgregar = new javax.swing.JButton();
        panelCliente = new javax.swing.JPanel();

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
        labelTitulo.setText(Texto.CLIENTES.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelTitulo.setPreferredSize(new java.awt.Dimension(350, 32));

        scrollClientes.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        scrollClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode(Colores.FONDO.getColor(fp.getModo()))));
        scrollClientes.setPreferredSize(new java.awt.Dimension(240, 340));
        scrollClientes.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        scrollClientes.setViewportBorder(null);

        //Scrollbar personalizada
        scrollClientes.setComponentZOrder(scrollClientes.getVerticalScrollBar(),0);
        scrollClientes.setComponentZOrder(scrollClientes.getViewport(),1);
        scrollClientes.getVerticalScrollBar().setOpaque(false);

        scrollClientes.setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollClientes = (JScrollPane) parent;

                Rectangle availR = scrollClientes.getBounds();
                availR.x = availR.y = 0;

                Insets parentInsets = parent.getInsets();
                availR.x = parentInsets.left;
                availR.y = parentInsets.top;
                availR.width -= parentInsets.left + parentInsets.right + 9;
                availR.height -= parentInsets.top + parentInsets.bottom;

                Rectangle vsbR = new Rectangle();
                vsbR.width = 9;
                vsbR.height = availR.height;
                vsbR.x = availR.x + availR.width - vsbR.width + 9;
                vsbR.y = availR.y;

                if (viewport != null) {
                    viewport.setBounds(availR);
                }
                if (vsb != null) {
                    vsb.setVisible(true);
                    vsb.setBounds(vsbR);
                }
            }
        });

        scrollClientes.getVerticalScrollBar().setUI(new MyScrollBarUI(fp.getModo(), 0));

        tableClientes.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.getModo())));
        tableClientes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableClientes.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableClientes.setGridColor(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        tableClientes.setRowHeight(35);
        tableClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableClientes.getTableHeader().setReorderingAllowed(false);
        tableClientes.setTableHeader(null);
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        scrollClientes.setViewportView(tableClientes);

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

        panelCliente.setPreferredSize(new java.awt.Dimension(548, 430));
        panelCliente.setLayout(new java.awt.CardLayout());

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
                            .addComponent(scrollClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(scrollClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(pmp);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
        posSeleccion = tableClientes.getSelectedRow();
        cargarId();

        PanelSeleccionarCliente psc = new PanelSeleccionarCliente(this);
        cargarPanel(psc);
    }//GEN-LAST:event_tableClientesMouseClicked

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        posSeleccion = -1;
        cargarClientes(controlCliente.nombresClientes());

        PanelAgregarCliente pac = new PanelAgregarCliente(this);
        cargarPanel(pac);
    }//GEN-LAST:event_buttonAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonHome;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
