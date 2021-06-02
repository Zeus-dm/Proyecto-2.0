package gui.menuSucursal;

import gui.menuProducto.*;
import FunGenerales.FunProducto;
import FunGenerales.FunProductoSucursal;
import FunGenerales.FunSucursal;
import gui.FramePrincipal;
import enumeraciones.Colores;
import enumeraciones.Texto;
import gui.TextPrompt;
import gui.menuPrincipal.PanelMenuPrincipal;
import gui.menuRegion.PanelMenuRegiones;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JPanel;

public class PanelMenuSucursal extends javax.swing.JPanel {

    private FramePrincipal fp = null;
    FunSucursal controlSucursal;
    FunProductoSucursal controlProducto;
    String nombreSucursal = null;
    String barCode = null;
    int posSeleccion = -1;

    public PanelMenuSucursal(FramePrincipal fp, String nombreSucursal, String nombreRegion) {
        this.fp = fp;
        this.controlSucursal = new FunSucursal(this.fp.getSistema().obtenerRegion(nombreRegion), this.fp.getSistema());
        this.nombreSucursal = nombreSucursal;
        this.controlProducto = new FunProductoSucursal(this.fp.getSistema(), this.fp.getSistema().obtenerRegion(nombreRegion).obtenerSucursal(this.nombreSucursal));

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        cargarProductos(controlProducto.todosProductos());
        
        labelTitulo.setText(controlSucursal.nombreRegion() + " - " + nombreSucursal);
        fp.reCargarTexto(labelTitulo, 28, 680, 3);
        
        //iniciar panel con los datos de la sucursal
        PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(this);
        fp.cargarPanel(panelProducto, pss);
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
        
        generarPosSeleccion();
        if (posSeleccion >= 0) {
            tableProductos.getSelectionModel().setSelectionInterval(posSeleccion, posSeleccion);
        }
    }
    
    public void reiniciarProductos(){
        textBuscar.setText("");
        barCode = null;
        cargarProductos(controlProducto.todosProductos());
    }
    
    public void generarPosSeleccion(){
        if(barCode != null){
            List<String> barcodes = controlProducto.todosBarCodes();
            for (int i = 0; i < barcodes.size(); i++) {
                if(barCode.equals(barcodes.get(i))){
                    posSeleccion = i;
                    return;
                }
            }
        }
        posSeleccion = -1;
    }

    private void cargarBarCode(int pos) {
        List<String> listaBarCodes = controlProducto.todosBarCodes();
        if (!(listaBarCodes.isEmpty())) {
            barCode = listaBarCodes.get(pos);
        }
    }

    public FramePrincipal getFramePrincipal() {
        return fp;
    }
    
    public JPanel getPanelProducto(){
        return panelProducto;
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
        buttonAtras = new javax.swing.JButton();

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
        labelTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO.getColor(fp.getModo()))));
        labelTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTitulo.setForeground(Color.decode(Colores.BORDE.getColor(fp.getModo())));
                labelTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(fp.getModo()))));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTitulo.setForeground(Color.decode(Colores.TEXTO.getColor(fp.getModo())));
                labelTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO.getColor(fp.getModo()))));
            }
            @Override
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
        buttonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        fp.cargarScrollBar(scrollProductos, 0);

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

        buttonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ATRAS.getColor(fp.getModo()))));
        buttonAtras.setBorder(null);
        buttonAtras.setBorderPainted(false);
        buttonAtras.setContentAreaFilled(false);
        buttonAtras.setFocusPainted(false);
        buttonAtras.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ATRAS.getColor(fp.getModo()))));
        buttonAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ATRAS_DRAGGED.getColor(fp.getModo()))));
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
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
                        .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(buttonAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        PanelMenuPrincipal pmp = new PanelMenuPrincipal(fp);
        fp.cargarPanel(fp.getPanelPrincipal(), pmp);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        int pos = tableProductos.getSelectedRow();
        cargarBarCode(pos);

        PanelSeleccionarProductoSucursal psps = new PanelSeleccionarProductoSucursal(this);
        fp.cargarPanel(panelProducto, psps);
    }//GEN-LAST:event_tableProductosMouseClicked

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        /*textBuscar.setText("");
        barCode = null;
        cargarProductos(controlProducto.todosProductos());

        PanelAgregarProducto pap = new PanelAgregarProducto(this);
        fp.cargarPanel(panelProducto, pap);*/
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        cargarProductos(controlProducto.filtrarProductos(0, 0, textBuscar.getText()));
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        PanelMenuRegiones pmr = new PanelMenuRegiones(fp, controlSucursal.nombreRegion());
        fp.cargarPanel(fp.getPanelPrincipal(), pmr);
    }//GEN-LAST:event_buttonAtrasActionPerformed
    
    private void labelTituloMouseClicked(java.awt.event.MouseEvent evt) {                                         
        PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(this);
        fp.cargarPanel(panelProducto, pss);
        
        textBuscar.setText("");
        barCode = null;
        cargarProductos(controlProducto.todosProductos());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonHome;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField textBuscar;
    // End of variables declaration//GEN-END:variables
}
