
package tests;

import domain.Sistema;
import gui.FramePrincipal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class test2 {
    public static void main(String args[]) throws SQLException {
        Sistema sistema = new Sistema();
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FramePrincipal(sistema).setVisible(true);
            } catch (SQLException | LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                Logger.getLogger(test2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
}
