/**
 * Erzeugt ein Popupfenster.
 * 
 * @author (Paul Görner) 
 * @version (09.07.2021)
 */
import javax.swing.*;
import java.awt.*;

public class SonstigeFenster
{
    private JDialog beendenFenster;
    private ImageIcon creditsIcon, regelnIcon;
    
    /**
     * Konstruktor für Objekte der Klasse PupupFenster.
     */
    public SonstigeFenster()
    {
        beendenFenster = new JDialog();
        creditsIcon = new ImageIcon(getClass().getResource("\\res\\creditsImage.png"));
        regelnIcon = new ImageIcon(getClass().getResource("\\res\\regelnImage.png"));
    }
    
    /**
     * Erzeugt das SonstigeFenster.
     * 
     * @param ereignis - Gibt an mit welchem Bild das SonstigeFenster gefüllt wird
     */
    public void erzeugen(int ereignis){
        beendenFenster.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-200,Toolkit.getDefaultToolkit().getScreenSize().height/2-300);
        beendenFenster.setSize(400,600);
        beendenFenster.add(verwaltenPanel(true, ereignis));
        beendenFenster.setVisible(true);
        beendenFenster.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        beendenFenster.setResizable(false);
    }
    
    /**
     * Schließt das Pupupfenster.
     */
    public void schließen()
    {
        beendenFenster.dispose();
    }
    
    public JLabel verwaltenPanel(boolean opaque, int ereignis)
    {
        JLabel ereignisLabel = new JLabel();
        
        if(ereignis == 1)
        {
            ereignisLabel.setIcon(regelnIcon);
        }
        else if(ereignis == 2)
        {
            ereignisLabel.setIcon(creditsIcon);
        }
        return ereignisLabel;
    }
}
