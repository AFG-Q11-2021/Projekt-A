/**
 * Beschreiben Sie hier die Klasse SpielFenster.
 * 
 * @author (Paul Görner)
 * @version (04.07.2021)
 */

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class FensterManager
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ImageIcon fensterIcon;
    

    /**
     * Konstruktor für Objekte der Klasse GraphicManager
     */
    public FensterManager()
    {
        fensterIcon = new ImageIcon(getClass().getResource("\\res\\Icon.png"));
        
        JFrame frame = new JFrame();
        SpielFenster2 spielfenster = new SpielFenster2();
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setSize(1920,1080);
        frame.setBackground(Color.decode("#3B5C1C"));
        frame.setVisible(true);
        frame.add(spielfenster);
    }

    public void getSpielStatus()
    {
    
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public void updateFenster(){
        
        
    }
    
    public void erzeugeHauptfenster()
    {
    }
}
