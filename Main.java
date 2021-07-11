/**
 * Klasse Main setzt das LookAndFeel und startet die GUI.
 * 
 * @author (Paul Görner) 
 * @version (05.07.2021)
 */
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            System.err.println(e);
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                new GraphicManager();
            }
        });
    }   
}
