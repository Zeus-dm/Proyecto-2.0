
package gui.MenuProductos;

import enumeraciones.Colores;
import enumeraciones.Texto;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

public class PanelGraficarMarcas extends javax.swing.JPanel {
    private DialogMenuProducto dmp = null;
    private double cantidadMarcas;
    
    public PanelGraficarMarcas(DialogMenuProducto dmp) {
        this.dmp = dmp;
        
        initComponents();
        this.dmp.setSize(485, 458);
        this.dmp.setLocationRelativeTo(this.dmp.getFramePrincipal());
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        cargarGrafico();
    }
    
    private DefaultCategoryDataset marcasCantidad(){
        List<String> marcas = dmp.controladorProducto.listarMarcas();
        List<Integer> cantidades = dmp.controladorProducto.cantidadProductosMarca();
        
        cantidadMarcas = (double)marcas.size();
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        
        for (int i = 0; i < marcas.size(); i++) {
            datos.addValue(cantidades.get(i), "", marcas.get(i));
        }
        
        return datos;
    }
    
    /**
     * Esta Funcion crea un panel con el grafico de barras de las marcas y su cantidad de productos diferentes
     */
    private void cargarGrafico(){
        JFreeChart grafico = ChartFactory.createBarChart("Productos por Marca", "Marcas", "Cantidades", marcasCantidad(), PlotOrientation.VERTICAL, false, true, false);
        
        grafico.setBackgroundPaint(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        grafico.getTitle().setPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        grafico.getTitle().setFont(new java.awt.Font("Segoe UI", 1, 20));
        
        //CategoryPlot
        CategoryPlot plot = (CategoryPlot)grafico.getPlot();
        
        plot.setBackgroundPaint(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        plot.setOutlinePaint(Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo)));
        plot.setRangeGridlinePaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        
        //Eje X
        CategoryAxis ejex = plot.getDomainAxis();
        
        ejex.setLabelPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        ejex.setLabelFont(new java.awt.Font("Segoe UI", 0, 16));
        ejex.setTickLabelPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        ejex.setTickLabelFont(new java.awt.Font("Segoe UI", 0, 12));
        ejex.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        //Eje Y
        NumberAxis ejey = (NumberAxis)plot.getRangeAxis();
        
        ejey.setLabelPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        ejey.setLabelFont(new java.awt.Font("Segoe UI", 0, 16));
        ejey.setTickLabelPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        ejey.setTickLabelFont(new java.awt.Font("Segoe UI", 0, 12));
        
        //Barras
        BarRenderer barras = (BarRenderer) plot.getRenderer();
        
        barras.setSeriesPaint(0, Color.decode(Colores.GRAFICO_BARRAS.getColor(dmp.getFramePrincipal().modo)));
        barras.setBarPainter(new StandardBarPainter());
        barras.setDrawBarOutline(false);
        
        //Cambiar etiquetas de toolTips
        barras.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator(
                "{2}", NumberFormat.getInstance()
        ));
        
        //Panel
        ChartPanel graficoPanel = new ChartPanel(grafico);
        
        graficoPanel.setRangeZoomable(false);
        graficoPanel.setMouseWheelEnabled(false);
        graficoPanel.setPopupMenu(null);
        
        //Cambia el tamaño del grafico dependiedo de cuantas marcas hay en el programa
        int tamano = 420;
        if(cantidadMarcas > 10){
            tamano = (int) (tamano * (cantidadMarcas/10.0)); //obtiene el tamaño justo para la cantidad de datos
        }
        graficoPanel.setPreferredSize(new Dimension(tamano,310));
        
        //Cargar Panel
        jPanelGrafico.setLayout(new BorderLayout());
        jPanelGrafico.add(graficoPanel, BorderLayout.CENTER);
        
        jPanelGrafico.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        buttonAtras = new javax.swing.JButton();
        jScrollPaneGrafico = new javax.swing.JScrollPane();
        jPanelGrafico = new javax.swing.JPanel();

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        labelTitulo.setForeground(Color.decode(Colores.TITULO.getColor(dmp.getFramePrincipal().modo)));
        labelTitulo.setText(Texto.PRODUCTOS.getTexto());

        buttonAtras.setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        buttonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ATRAS.getColor(dmp.getFramePrincipal().modo))));
        buttonAtras.setToolTipText("Volver a los Productos");
        buttonAtras.setBorder(null);
        buttonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAtras.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });

        jScrollPaneGrafico.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo))));
        jScrollPaneGrafico.setMaximumSize(new java.awt.Dimension(430, 330));
        jScrollPaneGrafico.setPreferredSize(new java.awt.Dimension(430, 330));

        jPanelGrafico.setAutoscrolls(true);

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        jScrollPaneGrafico.setViewportView(jPanelGrafico);

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jScrollPaneGrafico.getAccessibleContext().setAccessibleName("");
        jScrollPaneGrafico.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        dmp.setVisible(false);
    }//GEN-LAST:event_buttonAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtras;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JScrollPane jScrollPaneGrafico;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
