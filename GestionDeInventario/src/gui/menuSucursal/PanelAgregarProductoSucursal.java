package gui.menuSucursal;

import FunGenerales.FunProducto;
import enumeraciones.Colores;
import enumeraciones.Texto;
import enumeraciones.TextoErrores;
import gui.TextPrompt;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelAgregarProductoSucursal extends javax.swing.JPanel {

    PanelMenuSucursal pms = null;

    public PanelAgregarProductoSucursal(PanelMenuSucursal pms) {
        this.pms = pms;

        initComponents();
        
        iniciarPanel();
    }
    
    private void ItemsComboProductos(List<String> productos) {
        jComboProductos.removeAllItems();

        if (productos.isEmpty()) {
            return;
        }

        productos.forEach(producto -> {
            jComboProductos.addItem(producto);
        });
        jComboProductos.setSelectedIndex(0);
    }
    
    private void iniciarPanel() {
        ItemsComboProductos(pms.controlProducto.nombresNoSucursal());
        jComboProductosActionPerformed(null);
    }

    private void recargarColores() {
        textStock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));

        labelErrorStock.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        jComboProductos = new javax.swing.JComboBox<>();
        labelStock = new javax.swing.JLabel();
        textStock = new javax.swing.JTextField();
        labelErrorStock = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        panelPrev = new javax.swing.JPanel();
        labelSubTitulo = new javax.swing.JLabel();
        labelNombrePrev = new javax.swing.JLabel();
        textNombrePrev = new javax.swing.JLabel();
        labelMarcaPrev = new javax.swing.JLabel();
        textMarcaPrev = new javax.swing.JLabel();
        labelBarCodePrev = new javax.swing.JLabel();
        textBarCodePrev = new javax.swing.JLabel();
        labelPrecioPrev = new javax.swing.JLabel();
        textPrecioPrev = new javax.swing.JLabel();

        setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        setPreferredSize(new java.awt.Dimension(548, 430));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pms.getFramePrincipal().getModo())));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText(Texto.AGREGAR_EXISTENTE.getTexto());
        labelTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelTitulo.setPreferredSize(new java.awt.Dimension(536, 32));

        labelNombre.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombre.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelNombre.setText(Texto.NOMBRE.getTexto());
        labelNombre.setPreferredSize(new java.awt.Dimension(200, 16));

        jComboProductos.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(pms.getFramePrincipal().getModo())));
        jComboProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboProductos.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        jComboProductos.setMaximumRowCount(10);
        jComboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        jComboProductos.setFocusable(false);
        jComboProductos.setPreferredSize(new java.awt.Dimension(240, 28));
        jComboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProductosActionPerformed(evt);
            }
        });

        labelStock.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelStock.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelStock.setText(Texto.STOCK.getTexto());
        labelStock.setPreferredSize(new java.awt.Dimension(140, 16));

        textStock.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        textStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textStock.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textStock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        textStock.setPreferredSize(new java.awt.Dimension(209, 28));
        TextPrompt placeHolder = new TextPrompt(Texto.STOCK.getTexto(), textStock);
        placeHolder.changeAlpha(0.75f);
        placeHolder.changeStyle(Font.ITALIC);

        labelErrorStock.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
        labelErrorStock.setToolTipText("Aqui deberia de ir un Error");
        labelErrorStock.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelErrorStock.setPreferredSize(new java.awt.Dimension(28, 28));
        labelErrorStock.setVisible(false);

        buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonAceptar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonAceptar.setText(Texto.ACEPTAR.getTexto());
        buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonAceptar.setFocusPainted(false);
        buttonAceptar.setFocusable(false);
        buttonAceptar.setOpaque(true);
        buttonAceptar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(pms.getFramePrincipal().getModo())));
        buttonCancelar.setText(Texto.CANCELAR.getTexto());
        buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        buttonCancelar.setFocusPainted(false);
        buttonCancelar.setFocusable(false);
        buttonCancelar.setOpaque(true);
        buttonCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(pms.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCancelar.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
                buttonCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        panelPrev.setBackground(Color.decode(Colores.FONDO.getColor(pms.getFramePrincipal().getModo())));
        panelPrev.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(pms.getFramePrincipal().getModo()))));
        panelPrev.setPreferredSize(new java.awt.Dimension(480, 243));

        labelSubTitulo.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelSubTitulo.setForeground(Color.decode(Colores.TITULO.getColor(pms.getFramePrincipal().getModo())));
        labelSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSubTitulo.setText(Texto.PREVISUALIZACION.getTexto());
        labelSubTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelSubTitulo.setPreferredSize(new java.awt.Dimension(388, 28));

        labelNombrePrev.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelNombrePrev.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelNombrePrev.setText(Texto.NOMBRE.getTexto());
        labelNombrePrev.setPreferredSize(new java.awt.Dimension(388, 16));

        textNombrePrev.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textNombrePrev.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textNombrePrev.setText("(Nombre Producto)");

        labelMarcaPrev.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelMarcaPrev.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelMarcaPrev.setText(Texto.MARCA.getTexto());
        labelMarcaPrev.setPreferredSize(new java.awt.Dimension(174, 16));

        textMarcaPrev.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textMarcaPrev.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textMarcaPrev.setText("(Marca Producto)");

        labelBarCodePrev.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelBarCodePrev.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelBarCodePrev.setText(Texto.BARCODE.getTexto());
        labelBarCodePrev.setPreferredSize(new java.awt.Dimension(174, 16));

        textBarCodePrev.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textBarCodePrev.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textBarCodePrev.setText("(BarCode Producto)");

        labelPrecioPrev.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        labelPrecioPrev.setForeground(Color.decode(Colores.TEXTO_HEADER.getColor(pms.getFramePrincipal().getModo())));
        labelPrecioPrev.setText(Texto.PRECIO.getTexto());
        labelPrecioPrev.setPreferredSize(new java.awt.Dimension(174, 16));

        textPrecioPrev.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textPrecioPrev.setForeground(Color.decode(Colores.TEXTO.getColor(pms.getFramePrincipal().getModo())));
        textPrecioPrev.setText("(Precio Producto)");

        javax.swing.GroupLayout panelPrevLayout = new javax.swing.GroupLayout(panelPrev);
        panelPrev.setLayout(panelPrevLayout);
        panelPrevLayout.setHorizontalGroup(
            panelPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrevLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textPrecioPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecioPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelPrevLayout.createSequentialGroup()
                            .addComponent(textMarcaPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textBarCodePrev, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelNombrePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrevLayout.createSequentialGroup()
                            .addComponent(labelMarcaPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelBarCodePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(textNombrePrev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelPrevLayout.setVerticalGroup(
            panelPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrevLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelSubTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelNombrePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textNombrePrev, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMarcaPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBarCodePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(panelPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMarcaPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBarCodePrev, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPrecioPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textPrecioPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(labelErrorStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jComboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(labelErrorStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        recargarColores();

        try {
            List<String> barCodesNoSucursal = pms.controlProducto.barCodesNoSucursal();
            int pos = jComboProductos.getSelectedIndex();
            if(pos == -1){
                PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(pms);
                pms.getFramePrincipal().cargarPanel(pms.getPanelProducto(), pss);
            }
            
            String error = pms.controlProducto.agregarProducto(barCodesNoSucursal.get(pos), textStock.getText());
            if (error == null) {
                pms.reiniciarProductos();
                
                PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(pms);
                pms.getFramePrincipal().cargarPanel(pms.getPanelProducto(), pss);
            } else if (error.equals(TextoErrores.STOCK_VACIO.getTexto()) || error.equals(TextoErrores.STOCK_RANGO.getTexto()) || error.equals(TextoErrores.STOCK_CERO.getTexto()) || error.equals(TextoErrores.STOCK_INVALIDO.getTexto()) || error.equals(TextoErrores.STOCK_MAYOR_CERO.getTexto())) {
                labelErrorStock.setVisible(true);
                labelErrorStock.setToolTipText(error);

                textStock.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode(Colores.TEXTO_ERROR.getColor(pms.getFramePrincipal().getModo()))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelAgregarProductoSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        PanelSeleccionarSucursal pss = new PanelSeleccionarSucursal(pms);
        pms.getFramePrincipal().cargarPanel(pms.getPanelProducto(), pss);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void jComboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProductosActionPerformed
        int pos = jComboProductos.getSelectedIndex();
        if(pos >= 0){
            List<String> datos = new FunProducto(pms.getFramePrincipal().getSistema()).seleccionarProducto(pms.controlProducto.barCodesNoSucursal().get(pos));
            
            textNombrePrev.setText(datos.get(0));
            pms.getFramePrincipal().reCargarTexto(textNombrePrev, 18, 388, 0);
            
            textMarcaPrev.setText(datos.get(1));
            pms.getFramePrincipal().reCargarTexto(textMarcaPrev, 18, 174, 0);
            
            textBarCodePrev.setText("#" + datos.get(2));
            textPrecioPrev.setText("$" + datos.get(3));
        }
    }//GEN-LAST:event_jComboProductosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JComboBox<String> jComboProductos;
    private javax.swing.JLabel labelBarCodePrev;
    private javax.swing.JLabel labelErrorStock;
    private javax.swing.JLabel labelMarcaPrev;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombrePrev;
    private javax.swing.JLabel labelPrecioPrev;
    private javax.swing.JLabel labelStock;
    private javax.swing.JLabel labelSubTitulo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelPrev;
    private javax.swing.JLabel textBarCodePrev;
    private javax.swing.JLabel textMarcaPrev;
    private javax.swing.JLabel textNombrePrev;
    private javax.swing.JLabel textPrecioPrev;
    private javax.swing.JTextField textStock;
    // End of variables declaration//GEN-END:variables
}