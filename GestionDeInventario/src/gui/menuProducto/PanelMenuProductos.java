package gui.menuProducto;

import FunGenerales.FunProducto;
import gui.FramePrincipal;
import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.MyScrollBarUI;
import gui.TextPrompt;
import gui.menuPrincipal.PanelMenuPrincipal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

public class PanelMenuProductos extends javax.swing.JPanel {

    private FramePrincipal fp = null;
    FunProducto controlProducto;
    String barCode = null;

    public PanelMenuProductos(FramePrincipal fp) {
        this.fp = fp;
        this.controlProducto = new FunProducto(this.fp.getSistema());

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        cargarProductos(controlProducto.todosProductos());
        
        PanelGraficarMarcas pgm = new PanelGraficarMarcas(this);
        cargarPanel(pgm);
    }

    public void cargarProductos(List<String> productos) {
        String matriz[][] = new String[productos.size()][1];

        for (int i = 0; i < productos.size(); i++) {
            matriz[i][0] = "  " + productos.get(i);
        }

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
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

    //Metodos para el panel
    public final void cargarPanel(JPanel nuevoPanel) {
        panelProducto.removeAll();
        panelProducto.add(nuevoPanel);
        panelProducto.repaint();
        panelProducto.revalidate();
    }
    
    private void cargarBarCode(int posSeleccion) {
        List<String> listaBarCodes = controlProducto.todosBarCodes();
        if (!(listaBarCodes.isEmpty())) {
            barCode = listaBarCodes.get(posSeleccion);
        }
    }

    public FramePrincipal getFramePrincipal() {
        return fp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonHome = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        textBuscar = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        scrollProductos = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        buttonAgregar = new javax.swing.JButton();
        panelProducto = new javax.swing.JPanel();

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
        labelTitulo.setText(Texto.PRODUCTOS.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelTitulo.setPreferredSize(new java.awt.Dimension(350, 32));
        labelTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTituloMouseClicked(evt);
            }
        });

        textBuscar.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        textBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textBuscar.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
        textBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
        textBuscar.setPreferredSize(new java.awt.Dimension(212, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.BUSCAR.getTexto(), textBuscar);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);

        buttonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_LUPA.getColor(fp.getModo()))));
        buttonBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
        buttonBuscar.setContentAreaFilled(false);
        buttonBuscar.setFocusPainted(false);
        buttonBuscar.setFocusable(false);
        buttonBuscar.setPreferredSize(new java.awt.Dimension(28, 28));
        buttonBuscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_LUPA.getColor(fp.getModo()))));
        buttonBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_LUPA_DRAGGED.getColor(fp.getModo()))));
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        scrollProductos.setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        scrollProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode(Colores.FONDO.getColor(fp.getModo()))));
        scrollProductos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollProductos.setPreferredSize(new java.awt.Dimension(240, 306));
        scrollProductos.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        scrollProductos.setViewportBorder(null);

        //Scrollbar personalizada
        scrollProductos.setComponentZOrder(scrollProductos.getVerticalScrollBar(),0);
        scrollProductos.setComponentZOrder(scrollProductos.getViewport(),1);
        scrollProductos.getVerticalScrollBar().setOpaque(false);

        scrollProductos.setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollProducto = (JScrollPane) parent;

                Rectangle availR = scrollProducto.getBounds();
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

        scrollProductos.getVerticalScrollBar().setUI(new MyScrollBarUI(fp.getModo(), 0));

        tableProductos.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(fp.getModo())));
        tableProductos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tableProductos.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableProductos.setGridColor(Color.decode(Colores.FONDO.getColor(fp.getModo())));
        tableProductos.setRowHeight(35);
        tableProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableProductos.getTableHeader().setReorderingAllowed(false);
        tableProductos.setTableHeader(null);
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductosMouseClicked(evt);
            }
        });
        scrollProductos.setViewportView(tableProductos);

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

        panelProducto.setPreferredSize(new java.awt.Dimension(548, 430));
        panelProducto.setLayout(new java.awt.CardLayout());

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
                            .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(pmp);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        int pos = tableProductos.getSelectedRow();
        cargarBarCode(pos);
        
        PanelSeleccionarProducto psp = new PanelSeleccionarProducto(this);
        cargarPanel(psp);
    }//GEN-LAST:event_tableProductosMouseClicked

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        cargarProductos(controlProducto.filtrarProductos(0, 0, textBuscar.getText()));
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void labelTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTituloMouseClicked
        PanelGraficarMarcas pgm = new PanelGraficarMarcas(this);
        cargarPanel(pgm);
        
        cargarProductos(controlProducto.filtrarProductos(0, 0, textBuscar.getText()));
    }//GEN-LAST:event_labelTituloMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonHome;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField textBuscar;
    // End of variables declaration//GEN-END:variables
}
