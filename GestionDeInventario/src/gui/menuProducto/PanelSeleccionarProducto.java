package gui.menuProducto;

import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;



public class PanelSeleccionarProducto extends javax.swing.JPanel {

    PanelMenuProductos pmp = null;

    public PanelSeleccionarProducto(PanelMenuProductos pmp) {
        this.pmp = pmp;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        if(pmp.barCode != null){
            List<String> datos = pmp.controlProducto.seleccionarProducto(pmp.barCode);
            
            textNombre.setText(datos.get(0));
            textMarca.setText(datos.get(1));
            textBarCode.setText(datos.get(2));
            textPrecio.setText(datos.get(3));
            textStockTotal.setText(datos.get(4));
            textDescripcion.setText(datos.get(5));
            
            cargarSucursalesStock();
        }else{
            buttonEliminar.setVisible(false);
            buttonModificar.setVisible(false);
        }
    }
    
    private void cargarSucursalesStock(){
        List<String> NombreSucursales = new ArrayList<>();
        List<Integer> StocksSucursales = new ArrayList<>();
        
        try {
            pmp.controlProducto.listarSucursalStock(pmp.barCode, NombreSucursales, StocksSucursales);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSeleccionarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String matriz[][] = new String[NombreSucursales.size()][2];
        
        for (int i = 0; i < NombreSucursales.size(); i++) {
            matriz[i][0] = " " + NombreSucursales.get(i);
            matriz[i][1] = " " + StocksSucursales.get(i);
        }
        
        tableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "Sucursal", "Stock"
            }
        )
        {
            @Override
            public boolean isCellEditable(int row, int column){return false;}
        });
        
        if (tableSucursales.getColumnModel().getColumnCount() > 0){
            tableSucursales.getColumnModel().getColumn(0).setResizable(false);
            tableSucursales.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableSucursales.getColumnModel().getColumn(1).setResizable(false);
            tableSucursales.getColumnModel().getColumn(1).setPreferredWidth(68);
        }
    }
    
    public final void cargarPanel(JPanel nuevoPanel) {
        panelGrafico.removeAll();
        panelGrafico.add(nuevoPanel);
        panelGrafico.repaint();
        panelGrafico.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        textMarca = new javax.swing.JLabel();
        labelBarCode = new javax.swing.JLabel();
        textBarCode = new javax.swing.JLabel();
        scrollSucursales = new javax.swing.JScrollPane();
        tableSucursales = new javax.swing.JTable();
        labelPrecio = new javax.swing.JLabel();
        textPrecio = new javax.swing.JLabel();
        labelStockTotal = new javax.swing.JLabel();
        textStockTotal = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        scrollDescripcion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextPane();
        panelGrafico = new javax.swing.JPanel();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(300, 16));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textNombre.setText("(Nombre Producto)");
        textNombre.setPreferredSize(new java.awt.Dimension(300, 28));

        labelMarca.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelMarca.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelMarca.setText(Texto.MARCA.getTexto());
        labelMarca.setPreferredSize(new java.awt.Dimension(140, 16));

        textMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textMarca.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textMarca.setText("(Marca Producto)");
        textMarca.setPreferredSize(new java.awt.Dimension(140, 28));

        labelBarCode.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelBarCode.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelBarCode.setText(Texto.BARCODE.getTexto());
        labelBarCode.setPreferredSize(new java.awt.Dimension(142, 16));

        textBarCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textBarCode.setText("(BarCode Producto)");
        textBarCode.setMinimumSize(new java.awt.Dimension(142, 25));
        textBarCode.setPreferredSize(new java.awt.Dimension(142, 28));

        scrollSucursales.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        scrollSucursales.setPreferredSize(new java.awt.Dimension(200, 218));
        scrollSucursales.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));

        tableSucursales.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(pmp.getFramePrincipal().getModo())));
        tableSucursales.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        tableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sucursal", "Stock"
            }
        ));
        tableSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableSucursales.setFocusable(false);
        tableSucursales.setGridColor(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        tableSucursales.setRowHeight(25);
        tableSucursales.setRowSelectionAllowed(false);
        tableSucursales.getTableHeader().setReorderingAllowed(false);
        tableSucursales.getTableHeader().setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));

        tableSucursales.getTableHeader().setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));

        tableSucursales.getTableHeader().setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        scrollSucursales.setViewportView(tableSucursales);

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelPrecio.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelPrecio.setText(Texto.PRECIO.getTexto());
        labelPrecio.setPreferredSize(new java.awt.Dimension(140, 16));

        textPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textPrecio.setText("(Precio Producto)");
        textPrecio.setPreferredSize(new java.awt.Dimension(140, 28));

        labelStockTotal.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelStockTotal.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelStockTotal.setText(Texto.STOCK_TOTAL.getTexto());
        labelStockTotal.setPreferredSize(new java.awt.Dimension(142, 16));

        textStockTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textStockTotal.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textStockTotal.setText("(Stock Total Producto)");
        textStockTotal.setMinimumSize(new java.awt.Dimension(142, 25));
        textStockTotal.setPreferredSize(new java.awt.Dimension(142, 28));

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelDescripcion.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelDescripcion.setText(Texto.DESCRIPCION.getTexto());
        labelDescripcion.setPreferredSize(new java.awt.Dimension(300, 16));

        scrollDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        scrollDescripcion.setPreferredSize(new java.awt.Dimension(300, 132));

        textDescripcion.setEditable(false);
        textDescripcion.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        textDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())))));
        textDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textDescripcion.setText("(Descripcion Producto)");
        textDescripcion.setCaretPosition(0);
        textDescripcion.setPreferredSize(new java.awt.Dimension(300, 132));
        scrollDescripcion.setViewportView(textDescripcion);

        panelGrafico.setLayout(new java.awt.CardLayout());

        buttonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonModificar.setBorder(null);
        buttonModificar.setBorderPainted(false);
        buttonModificar.setContentAreaFilled(false);
        buttonModificar.setFocusPainted(false);
        buttonModificar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_MODIFICAR_DRAGGED.getColor(pmp.getFramePrincipal().getModo()))));
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonEliminar.setBorder(null);
        buttonEliminar.setBorderPainted(false);
        buttonEliminar.setContentAreaFilled(false);
        buttonEliminar.setFocusPainted(false);
        buttonEliminar.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ELIMINAR_DRAGGED.getColor(pmp.getFramePrincipal().getModo()))));
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelStockTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textStockTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        
    }//GEN-LAST:event_buttonEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JLabel labelBarCode;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelStockTotal;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JScrollPane scrollDescripcion;
    private javax.swing.JScrollPane scrollSucursales;
    private javax.swing.JTable tableSucursales;
    private javax.swing.JLabel textBarCode;
    private javax.swing.JTextPane textDescripcion;
    private javax.swing.JLabel textMarca;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textPrecio;
    private javax.swing.JLabel textStockTotal;
    // End of variables declaration//GEN-END:variables
}
