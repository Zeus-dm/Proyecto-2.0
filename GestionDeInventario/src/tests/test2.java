
package tests;

import domain.Sistema;
import gui.FramePrincipal;
import java.sql.SQLException;

public class test2 {
    public static void main(String args[]) throws SQLException {
        Sistema sistema = new Sistema();
        
        java.awt.EventQueue.invokeLater(() -> {
            new FramePrincipal(sistema).setVisible(true);
        });
    }
}
