package FunGenerales;

import enumeraciones.Colores;
import gui.menuProducto.PanelGraficarSucursales;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

public class FunGraficoSucursales {

    private final String barCode;
    private final FunProducto controlProducto;
    private final int modo;
    private final int opc;

    public FunGraficoSucursales(String barCode, FunProducto controlProducto, int modo, int opc) {
        this.barCode = barCode;
        this.controlProducto = controlProducto;
        this.modo = modo;
        this.opc = opc;
    }

    private DefaultPieDataset cargarSucursalesStock() {
        List<String> nombreSucursales = new ArrayList<>();
        List<Integer> stocksSucursales = new ArrayList<>();

        try {
            controlProducto.listarSucursalStock(barCode, nombreSucursales, stocksSucursales);
        } catch (SQLException ex) {
            Logger.getLogger(PanelGraficarSucursales.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultPieDataset datos = new DefaultPieDataset();

        for (int i = 0; i < nombreSucursales.size(); i++) {
            datos.setValue(nombreSucursales.get(i), stocksSucursales.get(i));
        }

        return datos;
    }

    public ChartPanel cargarGrafico() {
        JFreeChart grafico = ChartFactory.createPieChart("Stock de Sucursales", cargarSucursalesStock(), true, false, false);

        grafico.setBackgroundPaint(Color.decode(Colores.FONDO.getColor(modo)));
        if (opc == 0) {
            grafico.getTitle().setVisible(false);
            grafico.getLegend().setVisible(false);
        } else if (opc == 1) {
            grafico.getTitle().setPaint(Color.decode(Colores.TEXTO.getColor(modo)));
            grafico.getTitle().setFont(new java.awt.Font("Segoe UI", 1, 20));

            grafico.getLegend().setBackgroundPaint(Color.decode(Colores.FONDO.getColor(modo)));
            grafico.getLegend().setBorder(0, 0, 0, 0);
            grafico.getLegend().setItemPaint(Color.decode(Colores.TEXTO.getColor(modo)));
            grafico.getLegend().setItemFont(new java.awt.Font("Segoe UI", 0, 12));
            grafico.getLegend().setPosition(RectangleEdge.BOTTOM);
        }

        //PiePlot
        PiePlot plot = (PiePlot) grafico.getPlot();

        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setBackgroundPaint(null);

        if (opc == 0) {
            plot.setLabelGenerator(null);
        } else if (opc == 1) {
            //cambiar el contenido de las etiquetas
            PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                    "{1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%")
            );
            plot.setLabelGenerator(generator);

            plot.setLabelPaint(Color.decode(Colores.TEXTO.getColor(modo)));
            plot.setLabelLinkPaint(Color.decode(Colores.TEXTO.getColor(modo)));

            plot.setLabelBackgroundPaint(null);
            plot.setLabelShadowPaint(null);
            plot.setLabelOutlineStroke(null);
        }

        //Panel
        ChartPanel graficoPanel = new ChartPanel(grafico);

        graficoPanel.setMouseWheelEnabled(true);
        graficoPanel.setPopupMenu(null);
        if (opc == 0) {
            graficoPanel.setPreferredSize(new Dimension(198, 138));
        } else if (opc == 1) {
            graficoPanel.setPreferredSize(new Dimension(536, 353));
        }

        return graficoPanel;
    }
}
