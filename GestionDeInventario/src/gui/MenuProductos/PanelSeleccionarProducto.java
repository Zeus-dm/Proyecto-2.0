
package gui.MenuProductos;

import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelSeleccionarProducto extends javax.swing.JPanel {
    private DialogMenuProducto dmp = null;
    
    public PanelSeleccionarProducto(DialogMenuProducto dmp) {
        this.dmp = dmp;
        
        initComponents();
        this.dmp.setSize(492, 406);
        this.dmp.setLocationRelativeTo(this.dmp.getFramePrincipal());
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        List<String> datos = dmp.controladorProducto.seleccionarProducto(dmp.barCode);
        
        textNombre.setText(datos.get(0));
        ajustarTitulo();
        
        textMarca.setText(datos.get(1));
        textBarCode.setText("# " + datos.get(2));
        textPrecio.setText("$ " + datos.get(3));
        textStockTotal.setText(datos.get(4));
        textDescripcion.setText(datos.get(5));
        
        cargarSucursalesStock();
    }
    
    private void cargarSucursalesStock(){
        List<String> NombreSucursales = new ArrayList<>();
        List<Integer> StocksSucursales = new ArrayList<>();
        
        try {
            dmp.controladorProducto.listarSucursalStock(dmp.barCode, NombreSucursales, StocksSucursales);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSeleccionarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String matriz[][] = new String[NombreSucursales.size()][2];
        
        for (int i = 0; i < NombreSucursales.size(); i++) {
            matriz[i][0] = " " + NombreSucursales.get(i);
            matriz[i][1] = " " + StocksSucursales.get(i);
        }
        
        tableSucursalesStock.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "Sucursal", "Stock"
            }
        )
        {
            @Override
            public boolean isCellEditable(int row, int column){return false;}
        });
        
        if (tableSucursalesStock.getColumnModel().getColumnCount() > 0){
            tableSucursalesStock.getColumnModel().getColumn(0).setResizable(false);
            tableSucursalesStock.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableSucursalesStock.getColumnModel().getColumn(1).setResizable(false);
            tableSucursalesStock.getColumnModel().getColumn(1).setPreferredWidth(62);
        }
    }
    
    private void ajustarTitulo(){
        int tamano = 20;
        
        textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
        while(true){
            if(textNombre.getPreferredSize().width > 380){
                textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
            }else{
                break;
            }
            tamano -= 1;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        textNombre = new javax.swing.JLabel();
        buttonGrafico = new javax.swing.JButton();
        labelMarca = new javax.swing.JLabel();
        textMarca = new javax.swing.JLabel();
        labelBarCode = new javax.swing.JLabel();
        textBarCode = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        textPrecio = new javax.swing.JLabel();
        labelStockTotal = new javax.swing.JLabel();
        textStockTotal = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        jScrollPaneDescripcion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextPane();
        jScrollPaneSucursalesStock = new javax.swing.JScrollPane();
        tableSucursalesStock = new javax.swing.JTable();
        buttonModificar = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));

        textNombre.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TITULO.getColor(dmp.getFramePrincipal().modo)));
        textNombre.setText("(Nombre Producto)");

        buttonGrafico.setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        buttonGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_GRAFICO_TORTA.getColor(dmp.getFramePrincipal().modo))));
        buttonGrafico.setToolTipText("Graficar Stocks");
        buttonGrafico.setBorder(null);
        buttonGrafico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonGrafico.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGraficoActionPerformed(evt);
            }
        });

        labelMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMarca.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        labelMarca.setText(Texto.MARCA.getTexto());
        labelMarca.setPreferredSize(new java.awt.Dimension(70, 26));

        textMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMarca.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        textMarca.setText("(Marca Producto)");
        textMarca.setPreferredSize(new java.awt.Dimension(148, 26));

        labelBarCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        labelBarCode.setText(Texto.BARCODE.getTexto());
        labelBarCode.setPreferredSize(new java.awt.Dimension(70, 26));

        textBarCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        textBarCode.setText("(BarCode Producto)");
        textBarCode.setPreferredSize(new java.awt.Dimension(148, 26));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        labelPrecio.setText(Texto.PRECIO.getTexto());
        labelPrecio.setPreferredSize(new java.awt.Dimension(70, 26));

        textPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        textPrecio.setText("(Precio Producto)");
        textPrecio.setPreferredSize(new java.awt.Dimension(148, 26));

        labelStockTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelStockTotal.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        labelStockTotal.setText(Texto.STOCK_TOTAL.getTexto());
        labelStockTotal.setPreferredSize(new java.awt.Dimension(70, 26));

        textStockTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textStockTotal.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        textStockTotal.setText("(Stock Total Producto)");
        textStockTotal.setPreferredSize(new java.awt.Dimension(148, 26));

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        labelDescripcion.setText(Texto.DESCRIPCION.getTexto());
        labelDescripcion.setPreferredSize(new java.awt.Dimension(70, 26));

        jScrollPaneDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo))));
        jScrollPaneDescripcion.setPreferredSize(new java.awt.Dimension(230, 70));

        textDescripcion.setEditable(false);
        textDescripcion.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmp.getFramePrincipal().modo)));
        textDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmp.getFramePrincipal().modo)))));
        textDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        textDescripcion.setText("(Descripcion Producto)");
        textDescripcion.setCaretPosition(0);
        jScrollPaneDescripcion.setViewportView(textDescripcion);

        jScrollPaneSucursalesStock.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo))));
        jScrollPaneSucursalesStock.setPreferredSize(new java.awt.Dimension(194, 230));
        jScrollPaneSucursalesStock.getViewport().setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));

        tableSucursalesStock.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmp.getFramePrincipal().modo)));
        tableSucursalesStock.setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        tableSucursalesStock.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSucursalesStock.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableSucursalesStock.setFocusable(false);
        tableSucursalesStock.setGridColor(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        tableSucursalesStock.setRowHeight(25);
        tableSucursalesStock.setRowSelectionAllowed(false);
        tableSucursalesStock.getTableHeader().setReorderingAllowed(false);
        tableSucursalesStock.getTableHeader().setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));

        tableSucursalesStock.getTableHeader().setForeground(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));

        tableSucursalesStock.getTableHeader().setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo))));
        jScrollPaneSucursalesStock.setViewportView(tableSucursalesStock);

        buttonModificar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmp.getFramePrincipal().modo)));
        buttonModificar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonModificar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmp.getFramePrincipal().modo)));
        buttonModificar.setText(Texto.MODIFICAR.getTexto());
        buttonModificar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo))));
        buttonModificar.setFocusable(false);
        buttonModificar.setPreferredSize(new java.awt.Dimension(140, 30));
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmp.getFramePrincipal().modo)));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmp.getFramePrincipal().modo)));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo))));
        buttonVolver.setFocusable(false);
        buttonVolver.setPreferredSize(new java.awt.Dimension(140, 30));
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textStockTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPaneSucursalesStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneSucursalesStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        PanelModificarProducto pmp = new PanelModificarProducto(dmp);
        dmp.cargarPanel(pmp);
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        dmp.setVisible(false);
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void buttonGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGraficoActionPerformed
        PanelGraficarProducto pgp = new PanelGraficarProducto(dmp);
        dmp.cargarPanel(pgp);
    }//GEN-LAST:event_buttonGraficoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGrafico;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneDescripcion;
    private javax.swing.JScrollPane jScrollPaneSucursalesStock;
    private javax.swing.JLabel labelBarCode;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelStockTotal;
    private javax.swing.JTable tableSucursalesStock;
    private javax.swing.JLabel textBarCode;
    private javax.swing.JTextPane textDescripcion;
    private javax.swing.JLabel textMarca;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textPrecio;
    private javax.swing.JLabel textStockTotal;
    // End of variables declaration//GEN-END:variables
}
