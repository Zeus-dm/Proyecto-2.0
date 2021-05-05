
package gui;

import enumeraciones.Colores;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollBarUI extends BasicScrollBarUI{
    private final Dimension d = new Dimension();
    private final int modo;
    private final int direccion;
    
    public MyScrollBarUI(int modo, int direcction) {
        this.modo = modo;
        this.direccion = direcction;
    }

  @Override
  protected JButton createDecreaseButton(int orientation) {
    return new JButton() {
      @Override
      public Dimension getPreferredSize() {
        return d;
      }
    };
  }

  @Override
  protected JButton createIncreaseButton(int orientation) {
    return new JButton() {
      @Override
      public Dimension getPreferredSize() {
        return d;
      }
    };
  }

  @Override
  protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
  }

  @Override
  protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

    JScrollBar sb = (JScrollBar) c;
    
    if(direccion == 0){
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        }
        g2.setPaint(Color.decode(Colores.FONDO_TABLA.getColor(modo)));
        g2.fillRoundRect(r.x, r.y, 8, r.height, 10, 10);
        g2.setPaint(Color.decode(Colores.BORDE.getColor(modo)));
        g2.drawRoundRect(r.x, r.y, 8, r.height, 10, 10);
        g2.dispose();
    }else{
        if (!sb.isEnabled() || r.height > r.width) {
            return;
        }
        g2.setPaint(Color.decode(Colores.FONDO_TABLA.getColor(modo)));
        g2.fillRoundRect(r.x, r.y, r.width, 8, 10, 10);
        g2.setPaint(Color.decode(Colores.BORDE.getColor(modo)));
        g2.drawRoundRect(r.x, r.y, r.width, 8, 10, 10);
        g2.dispose();
    }
  }

  @Override
  protected void setThumbBounds(int x, int y, int width, int height) {
    super.setThumbBounds(x, y, width, height);
    scrollbar.repaint();
  }
  
}
