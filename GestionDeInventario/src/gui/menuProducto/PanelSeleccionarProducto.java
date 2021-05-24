package gui.menuProducto;

import FunGenerales.FunGraficoSucursales;
import enumeraciones.Colores;
import enumeraciones.Texto;
import java.awt.BorderLayout;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            pmp.getFramePrincipal().reCargarTexto(textNombre, 18, 300);
            
            textMarca.setText(datos.get(1));
            pmp.getFramePrincipal().reCargarTexto(textMarca, 18, 140);
            
            textBarCode.setText("#" + datos.get(2));
            pmp.getFramePrincipal().reCargarTexto(textBarCode, 18, 142);
            
            textPrecio.setText("$" + datos.get(3));
            textStockTotal.setText(datos.get(4));
            textDescripcion.setText(datos.get(5));
            
            cargarSucursalesStock();
            cargarGrafico();
        }else{
            buttonEliminar.setVisible(false);
            buttonModificar.setVisible(false);
        }
    }
    
    private void cargarSucursalesStock(){
        //pmp.getFramePrincipal().cargarScrollBar(scrollSucursales, 0);
        
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
    
    private void cargarGrafico(){
        FunGraficoSucursales fgs = new FunGraficoSucursales(pmp.barCode, pmp.controlProducto, pmp.getFramePrincipal().getModo(), 0);
        
        panelGraficoSucursales.setLayout(new BorderLayout());
        panelGraficoSucursales.add(fgs.cargarGrafico(), BorderLayout.CENTER);
        
        panelGraficoSucursales.revalidate();
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
        labelPrecio = new javax.swing.JLabel();
        textPrecio = new javax.swing.JLabel();
        labelStockTotal = new javax.swing.JLabel();
        textStockTotal = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        scrollDescripcion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextPane();
        scrollSucursales = new javax.swing.JScrollPane();
        tableSucursales = new javax.swing.JTable();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        panelGrafico = new javax.swing.JPanel();
        panelGraficoSucursales = new javax.swing.JPanel();
        buttonMaximizar = new javax.swing.JButton();

        setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        setPreferredSize(new java.awt.Dimension(548, 430));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(300, 16));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textNombre.setText("(Nombre Producto)");

        labelMarca.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelMarca.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelMarca.setText(Texto.MARCA.getTexto());
        labelMarca.setPreferredSize(new java.awt.Dimension(140, 16));

        textMarca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textMarca.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textMarca.setText("(Marca Producto)");

        labelBarCode.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelBarCode.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pmp.getFramePrincipal().getModo())));
        labelBarCode.setText(Texto.BARCODE.getTexto());
        labelBarCode.setPreferredSize(new java.awt.Dimension(142, 16));

        textBarCode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textBarCode.setText("(BarCode Producto)");

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

        scrollDescripcion.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        scrollDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        scrollDescripcion.setPreferredSize(new java.awt.Dimension(300, 132));
        //Scrollbar personalizada
        pmp.getFramePrincipal().cargarScrollBar(scrollDescripcion, 0);

        textDescripcion.setEditable(false);
        textDescripcion.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        textDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())))));
        textDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        textDescripcion.setText("(Descripcion Producto)");
        textDescripcion.setCaretPosition(0);
        textDescripcion.setPreferredSize(new java.awt.Dimension(300, 132));
        scrollDescripcion.setViewportView(textDescripcion);

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

        panelGrafico.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        panelGrafico.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo()))));
        panelGrafico.setPreferredSize(new java.awt.Dimension(200, 200));

        panelGraficoSucursales.setPreferredSize(new java.awt.Dimension(198, 138));

        javax.swing.GroupLayout panelGraficoSucursalesLayout = new javax.swing.GroupLayout(panelGraficoSucursales);
        panelGraficoSucursales.setLayout(panelGraficoSucursalesLayout);
        panelGraficoSucursalesLayout.setHorizontalGroup(
            panelGraficoSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        panelGraficoSucursalesLayout.setVerticalGroup(
            panelGraficoSucursalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        buttonMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_EXPANDIR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonMaximizar.setBorder(null);
        buttonMaximizar.setBorderPainted(false);
        buttonMaximizar.setContentAreaFilled(false);
        buttonMaximizar.setFocusPainted(false);
        buttonMaximizar.setPreferredSize(new java.awt.Dimension(24, 24));
        buttonMaximizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_EXPANDIR.getColor(pmp.getFramePrincipal().getModo()))));
        buttonMaximizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_EXPANDIR_DRAGGED.getColor(pmp.getFramePrincipal().getModo()))));
        buttonMaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMaximizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
            .addComponent(panelGraficoSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficoLayout.createSequentialGroup()
                .addComponent(panelGraficoSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(buttonMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelStockTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textStockTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(textBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        PanelModificarProducto pmod = new PanelModificarProducto(pmp);
        pmp.getFramePrincipal().cargarPanel(pmp.getPanelProducto(), pmod);
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        DialogoConfirmarEliminarProducto  dcep = new DialogoConfirmarEliminarProducto(new javax.swing.JFrame(), true, pmp);
        dcep.setLocationRelativeTo(this);
        dcep.setVisible(true);
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonMaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMaximizarActionPerformed
        PanelGraficarSucursales pgs = new PanelGraficarSucursales(pmp);
        pmp.getFramePrincipal().cargarPanel(pmp.getPanelProducto(), pgs);
    }//GEN-LAST:event_buttonMaximizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonMaximizar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JLabel labelBarCode;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelStockTotal;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JPanel panelGraficoSucursales;
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
