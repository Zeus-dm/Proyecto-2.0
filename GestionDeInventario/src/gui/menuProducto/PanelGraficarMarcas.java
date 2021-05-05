package gui.menuProducto;

import enumeraciones.Colores;
import gui.MyScrollBarUI;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
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

    PanelMenuProductos pmp = null;
    private double cantidadMarcas;

    public PanelGraficarMarcas(PanelMenuProductos pmp) {
        this.pmp = pmp;

        initComponents();

        iniciarPanel();
    }

    private void iniciarPanel() {
        cargarGrafico();
    }
    
    private DefaultCategoryDataset marcasCantidad(){
        List<String> marcas = pmp.controlProducto.listarMarcas();
        List<Integer> cantidades = pmp.controlProducto.cantidadProductosMarca();
        
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
        
        grafico.setBackgroundPaint(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        grafico.getTitle().setPaint(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        grafico.getTitle().setFont(new java.awt.Font("Segoe UI", 1, 20));
        
        //CategoryPlot
        CategoryPlot plot = (CategoryPlot)grafico.getPlot();
        
        plot.setBackgroundPaint(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        plot.setOutlinePaint(Color.decode(Colores.BORDE.getColor(pmp.getFramePrincipal().getModo())));
        plot.setRangeGridlinePaint(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        
        //Eje X
        CategoryAxis ejex = plot.getDomainAxis();
        
        ejex.setLabelPaint(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        ejex.setLabelFont(new java.awt.Font("Segoe UI", 0, 16));
        ejex.setTickLabelPaint(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        ejex.setTickLabelFont(new java.awt.Font("Segoe UI", 0, 12));
        ejex.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        //Eje Y
        NumberAxis ejey = (NumberAxis)plot.getRangeAxis();
        
        ejey.setLabelPaint(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        ejey.setLabelFont(new java.awt.Font("Segoe UI", 0, 16));
        ejey.setTickLabelPaint(Color.decode(Colores.TEXTO.getColor(pmp.getFramePrincipal().getModo())));
        ejey.setTickLabelFont(new java.awt.Font("Segoe UI", 0, 12));
        
        //Barras
        BarRenderer barras = (BarRenderer) plot.getRenderer();
        
        barras.setSeriesPaint(0, Color.decode(Colores.GRAFICO_BARRAS.getColor(pmp.getFramePrincipal().getModo())));
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
        int tamano = 498;
        if(cantidadMarcas > 10){
            tamano = (int) (tamano * (cantidadMarcas/10.0)); //obtiene el tamaño justo para la cantidad de datos
        }
        graficoPanel.setPreferredSize(new Dimension(tamano,380));
        
        //Cargar Panel
        panelGrafico.setLayout(new BorderLayout());
        panelGrafico.add(graficoPanel, BorderLayout.CENTER);
        panelGrafico.setPreferredSize(new Dimension(tamano,380));
        
        panelGrafico.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollGrafico = new javax.swing.JScrollPane();
        panelGrafico = new javax.swing.JPanel();

        setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        setPreferredSize(new java.awt.Dimension(548, 430));

        scrollGrafico.setBackground(Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo())));
        scrollGrafico.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.FONDO.getColor(pmp.getFramePrincipal().getModo()))));
        scrollGrafico.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollGrafico.setPreferredSize(new java.awt.Dimension(500, 400));
        //Scrollbar personalizada

        scrollGrafico.setComponentZOrder(scrollGrafico.getHorizontalScrollBar(),0);
        scrollGrafico.setComponentZOrder(scrollGrafico.getViewport(),1);
        scrollGrafico.getHorizontalScrollBar().setOpaque(false);

        scrollGrafico.setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollGrafico = (JScrollPane) parent;

                Rectangle availR = scrollGrafico.getBounds();
                availR.x = availR.y = 0;

                Insets parentInsets = parent.getInsets();
                availR.x = parentInsets.left;
                availR.y = parentInsets.top;
                availR.width -= parentInsets.left + parentInsets.right;
                availR.height -= parentInsets.top + parentInsets.bottom + 9;

                Rectangle vsbR = new Rectangle();
                vsbR.width = availR.width;
                vsbR.height = 9;
                vsbR.x = availR.x;
                vsbR.y = availR.y + availR.height - vsbR.height + 9;

                if (viewport != null) {
                    viewport.setBounds(availR);
                }
                if (hsb != null) {
                    hsb.setVisible(true);
                    hsb.setBounds(vsbR);
                }
            }
        });

        scrollGrafico.getHorizontalScrollBar().setUI(new MyScrollBarUI(pmp.getFramePrincipal().getModo(), 1));

        panelGrafico.setPreferredSize(new java.awt.Dimension(498, 398));

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        scrollGrafico.setViewportView(panelGrafico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JScrollPane scrollGrafico;
    // End of variables declaration//GEN-END:variables
}
