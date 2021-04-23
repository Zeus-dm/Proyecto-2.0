
package gui.MenuProductos;

import FunGenerales.FunProducto;
import enumeraciones.Colores;
import java.awt.BorderLayout;

import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jfree.chart.*;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;



public class PanelGraficarProducto extends javax.swing.JPanel {
    DialogMenuProducto dmp = null;
    
    public PanelGraficarProducto(DialogMenuProducto dmp) {
        this.dmp = dmp;
        
        initComponents();
        this.dmp.setSize(492, 458);
        this.dmp.setLocationRelativeTo(this.dmp.getFramePrincipal());
        
        iniciarDatos();
    }
    
    private void iniciarDatos(){
        List<String> datos = dmp.controladorProducto.seleccionarProducto(dmp.barCode);
        
        textNombre.setText(datos.get(0));
        ajustarTitulo();
        
        cargarGrafico();
    }
    
    private DefaultPieDataset cargarSucursalesStock(){
        List<String> nombreSucursales = new ArrayList<>();
        List<Integer> stocksSucursales = new ArrayList<>();
        
        try {
            dmp.controladorProducto.listarSucursalStock(dmp.barCode, nombreSucursales, stocksSucursales);
        } catch (SQLException ex) {
            Logger.getLogger(PanelGraficarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultPieDataset datos = new DefaultPieDataset();
        
        for (int i = 0; i < nombreSucursales.size(); i++) {
            datos.setValue(nombreSucursales.get(i), stocksSucursales.get(i));
        }
        
        return datos;
    }
    
    private void cargarGrafico(){
        JFreeChart grafico = ChartFactory.createPieChart("Stock de Sucursales", cargarSucursalesStock(), true, false, false);
        
        grafico.setBackgroundPaint(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        grafico.getTitle().setPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        grafico.getTitle().setFont(new java.awt.Font("Segoe UI", 1, 20));
        
        grafico.getLegend().setBackgroundPaint(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        grafico.getLegend().setBorder(0, 0, 0, 0);
        grafico.getLegend().setItemPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        grafico.getLegend().setItemFont(new java.awt.Font("Segoe UI", 0, 12));
        grafico.getLegend().setPosition(RectangleEdge.BOTTOM);
        
        //PiePlot
        PiePlot plot = (PiePlot)grafico.getPlot();
        
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setBackgroundPaint(null);
        
        //cambiar el contenido de las etiquetas
        PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                "{1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%")
        );
        plot.setLabelGenerator(generator);
        
        plot.setLabelPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        plot.setLabelBackgroundPaint(null);
        plot.setLabelShadowPaint(null);
        plot.setLabelOutlineStroke(null);
        
        plot.setLabelLinkPaint(Color.decode(Colores.TEXTO.getColor(dmp.getFramePrincipal().modo)));
        
        //Panel
        ChartPanel graficoPanel = new ChartPanel(grafico);
        
        graficoPanel.setMouseWheelEnabled(true);
        graficoPanel.setPopupMenu(null);
        
        //Cargar Panel
        jPanelGrafico.setLayout(new BorderLayout());
        jPanelGrafico.add(graficoPanel, BorderLayout.CENTER);
        
        jPanelGrafico.revalidate();
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
        buttonAtras = new javax.swing.JButton();
        jPanelGrafico = new javax.swing.JPanel();

        jPanelFondo.setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));

        textNombre.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        textNombre.setForeground(Color.decode(Colores.TITULO.getColor(dmp.getFramePrincipal().modo)));
        textNombre.setText("(Nombre Producto)");

        buttonAtras.setBackground(Color.decode(Colores.FONDO.getColor(dmp.getFramePrincipal().modo)));
        buttonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource(Colores.ICONO_ATRAS.getColor(dmp.getFramePrincipal().modo))));
        buttonAtras.setToolTipText("Volver al Producto");
        buttonAtras.setBorder(null);
        buttonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAtras.setPreferredSize(new java.awt.Dimension(32, 32));
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });

        jPanelGrafico.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode(Colores.BORDE.getColor(dmp.getFramePrincipal().modo))));
        jPanelGrafico.setPreferredSize(new java.awt.Dimension(430, 330));

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        PanelSeleccionarProducto psp = new PanelSeleccionarProducto(dmp);
        dmp.cargarPanel(psp);
    }//GEN-LAST:event_buttonAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtras;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JLabel textNombre;
    // End of variables declaration//GEN-END:variables
}