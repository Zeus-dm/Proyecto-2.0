package gui.MenuProductosSucursal;

import enumeraciones.Colores;
import enumeraciones.Texto;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelSeleccionarProductoSucursal extends javax.swing.JPanel {

    private DialogMenuProductosSucursal dmps = null;

    public PanelSeleccionarProductoSucursal(DialogMenuProductosSucursal dmps) {
        this.dmps = dmps;

        int tamX = dmps.getSize().width - 478;
        int tamY = dmps.getSize().height - 320;

        initComponents();
        this.dmps.setSize(478, 320);
        this.dmps.setLocation(dmps.getLocation().x + (tamX / 2), dmps.getLocation().y + (tamY / 2));

        iniciarDatos();
    }

    private void iniciarDatos() {
        try {
            List<String> datos = dmps.controladorProductoSucursal.seleccionarProducto(dmps.barCode);
            if (datos == null) {
                dmps.setVisible(false);
            } else {
                textNombre.setText(datos.get(0));
                ajustarTitulo();

                textMarca.setText(datos.get(1));
                textBarCode.setText("# " + datos.get(2));
                textPrecio.setText("$ " + datos.get(3));
                textStockTotal.setText(datos.get(4));
                textDescripcion.setText(datos.get(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSeleccionarProductoSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ajustarTitulo() {
        int tamano = 20;

        textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
        while (true) {
            if (textNombre.getPreferredSize().width > 380) {
                textNombre.setFont(new java.awt.Font("Segoe UI", 3, tamano));
            } else {
                break;
            }
            tamano -= 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogConfirmacion = new javax.swing.JDialog();
        jPanelConfirmacion = new javax.swing.JPanel();
        labelTituloConfirmacion = new javax.swing.JLabel();
        buttonAceptarConfirmacion = new javax.swing.JButton();
        buttonCancelarConfirmacion = new javax.swing.JButton();
        jPanelFondo = new javax.swing.JPanel();
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
        jScrollPaneDescripcion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextPane();
        jPanelBotones = new javax.swing.JPanel();
        buttonEliminar = new javax.swing.JButton();
        buttonModificarStock = new javax.swing.JButton();
        buttonVolver = new javax.swing.JButton();

        DialogConfirmacion.setTitle("Confirmacion");
        DialogConfirmacion.setMinimumSize(new java.awt.Dimension(310, 135));
        DialogConfirmacion.setModal(true);
        DialogConfirmacion.setUndecorated(true);

        jPanelConfirmacion.setBackground(Color.decode(Colores.FONDO.getColor(dmps.getFramePrincipal().modo)));
        jPanelConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        jPanelConfirmacion.setPreferredSize(new java.awt.Dimension(310, 135));

        labelTituloConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelTituloConfirmacion.setForeground(Color.decode(Colores.TITULO.getColor(dmps.getFramePrincipal().modo)));
        labelTituloConfirmacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTituloConfirmacion.setText(Texto.CONFIRMACION_ELIMINAR_PRODUCTO_SUCURSAL.getTexto());
        labelTituloConfirmacion.setPreferredSize(new java.awt.Dimension(106, 27));

        buttonAceptarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonAceptarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonAceptarConfirmacion.setText(Texto.ACEPTAR.getTexto());
        buttonAceptarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonAceptarConfirmacion.setFocusable(false);
        buttonAceptarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonAceptarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarConfirmacionActionPerformed(evt);
            }
        });

        buttonCancelarConfirmacion.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonCancelarConfirmacion.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonCancelarConfirmacion.setText(Texto.CANCELAR.getTexto());
        buttonCancelarConfirmacion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonCancelarConfirmacion.setFocusable(false);
        buttonCancelarConfirmacion.setPreferredSize(new java.awt.Dimension(110, 30));
        buttonCancelarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarConfirmacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConfirmacionLayout = new javax.swing.GroupLayout(jPanelConfirmacion);
        jPanelConfirmacion.setLayout(jPanelConfirmacionLayout);
        jPanelConfirmacionLayout.setHorizontalGroup(
            jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTituloConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelConfirmacionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(buttonAceptarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(buttonCancelarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanelConfirmacionLayout.setVerticalGroup(
            jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfirmacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTituloConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanelConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelarConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogConfirmacionLayout = new javax.swing.GroupLayout(DialogConfirmacion.getContentPane());
        DialogConfirmacion.getContentPane().setLayout(DialogConfirmacionLayout);
        DialogConfirmacionLayout.setHorizontalGroup(
            DialogConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DialogConfirmacionLayout.setVerticalGroup(
            DialogConfirmacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmps.getFramePrincipal().modo)));

        textNombre.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TITULO.getColor(dmps.getFramePrincipal().modo)));
        textNombre.setText("(Nombre Producto)");

        labelMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelMarca.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelMarca.setText(Texto.MARCA.getTexto());
        labelMarca.setPreferredSize(new java.awt.Dimension(70, 26));

        textMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMarca.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textMarca.setText("(Marca Producto)");
        textMarca.setPreferredSize(new java.awt.Dimension(172, 26));

        labelBarCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelBarCode.setText(Texto.BARCODE.getTexto());
        labelBarCode.setPreferredSize(new java.awt.Dimension(70, 26));

        textBarCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBarCode.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textBarCode.setText("(BarCode Producto)");
        textBarCode.setPreferredSize(new java.awt.Dimension(172, 26));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelPrecio.setText(Texto.PRECIO.getTexto());
        labelPrecio.setPreferredSize(new java.awt.Dimension(70, 26));

        textPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrecio.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textPrecio.setText("(Precio Producto)");
        textPrecio.setPreferredSize(new java.awt.Dimension(172, 26));

        labelStockTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelStockTotal.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelStockTotal.setText(Texto.STOCK_TOTAL.getTexto());
        labelStockTotal.setPreferredSize(new java.awt.Dimension(70, 26));

        textStockTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textStockTotal.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textStockTotal.setText("(Stock Total Producto)");
        textStockTotal.setPreferredSize(new java.awt.Dimension(172, 26));

        labelDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        labelDescripcion.setText(Texto.DESCRIPCION.getTexto());
        labelDescripcion.setPreferredSize(new java.awt.Dimension(70, 26));

        jScrollPaneDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        jScrollPaneDescripcion.setPreferredSize(new java.awt.Dimension(254, 70));

        textDescripcion.setEditable(false);
        textDescripcion.setBackground(Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)));
        textDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 1, Color.decode(Colores.FONDO_TABLA.getColor(dmps.getFramePrincipal().modo)))));
        textDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDescripcion.setForeground(Color.decode(Colores.TEXTO.getColor(dmps.getFramePrincipal().modo)));
        textDescripcion.setText("(Descripcion Producto)");
        textDescripcion.setCaretPosition(0);
        jScrollPaneDescripcion.setViewportView(textDescripcion);

        jPanelBotones.setBackground(Color.decode(Colores.FONDO.getColor(dmps.getFramePrincipal().modo)));

        buttonEliminar.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonEliminar.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonEliminar.setText(Texto.ELIMINAR.getTexto());
        buttonEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonEliminar.setFocusable(false);
        buttonEliminar.setPreferredSize(new java.awt.Dimension(150, 30));
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonModificarStock.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonModificarStock.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonModificarStock.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonModificarStock.setText(Texto.MODIFICAR_STOCK.getTexto());
        buttonModificarStock.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonModificarStock.setFocusable(false);
        buttonModificarStock.setPreferredSize(new java.awt.Dimension(150, 30));
        buttonModificarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarStockActionPerformed(evt);
            }
        });

        buttonVolver.setBackground(Color.decode(Colores.FONDO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonVolver.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonVolver.setForeground(Color.decode(Colores.TEXTO_BOTON.getColor(dmps.getFramePrincipal().modo)));
        buttonVolver.setText(Texto.VOLVER.getTexto());
        buttonVolver.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmps.getFramePrincipal().modo))));
        buttonVolver.setFocusable(false);
        buttonVolver.setPreferredSize(new java.awt.Dimension(150, 30));
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModificarStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonModificarStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                                .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                                        .addComponent(labelStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textStockTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                                        .addComponent(labelBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textBarCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                                        .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        DialogConfirmacion.setLocationRelativeTo(dmps);
        DialogConfirmacion.setVisible(true);
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        dmps.setVisible(false);
    }//GEN-LAST:event_buttonVolverActionPerformed

    private void buttonModificarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarStockActionPerformed
        DialogMenuProductosSucursal nuevoDmps = new DialogMenuProductosSucursal(new javax.swing.JFrame(), true, dmps.getFramePrincipal(), 3, dmps.barCode, dmps.controladorProductoSucursal.nombreRegion(), dmps.controladorProductoSucursal.nombreSucursal());
        nuevoDmps.setLocationRelativeTo(dmps);
        nuevoDmps.setVisible(true);

        PanelSeleccionarProductoSucursal psps = new PanelSeleccionarProductoSucursal(dmps);
        dmps.cargarPanel(psps);
    }//GEN-LAST:event_buttonModificarStockActionPerformed

    private void buttonAceptarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarConfirmacionActionPerformed
        try {
            dmps.controladorProductoSucursal.eliminarProducto(dmps.barCode);
            dmps.barCode = null;
            DialogConfirmacion.setVisible(false);
            dmps.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSeleccionarProductoSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAceptarConfirmacionActionPerformed

    private void buttonCancelarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarConfirmacionActionPerformed
        DialogConfirmacion.setVisible(false);
    }//GEN-LAST:event_buttonCancelarConfirmacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogConfirmacion;
    private javax.swing.JButton buttonAceptarConfirmacion;
    private javax.swing.JButton buttonCancelarConfirmacion;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonModificarStock;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelConfirmacion;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPaneDescripcion;
    private javax.swing.JLabel labelBarCode;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelStockTotal;
    private javax.swing.JLabel labelTituloConfirmacion;
    private javax.swing.JLabel textBarCode;
    private javax.swing.JTextPane textDescripcion;
    private javax.swing.JLabel textMarca;
    private javax.swing.JLabel textNombre;
    private javax.swing.JLabel textPrecio;
    private javax.swing.JLabel textStockTotal;
    // End of variables declaration//GEN-END:variables
}
