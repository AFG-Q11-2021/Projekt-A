/**
 * Beschreiben Sie hier die Klasse PopupFenster.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import javax.swing.*;
import java.awt.*;

public class PopupFenster
{
    private JDialog beendenFenster;
    private JPanel knoepfe;
    private JButton knopfBestaetigen,knopfAbbrechen;
    private ImageIcon knopfBestaetigenIcon, knopfAbbrechenIcon;
    
    public PopupFenster()
    {
        beendenFenster = new JDialog();
        knoepfe = new JPanel();
        
        //knopfBestaetigenIcon = new ImageIcon(getClass().getResource("\\res\\knopfBestätigen.png"));
        knopfAbbrechenIcon = new ImageIcon(getClass().getResource("\\res\\knopfAbbrechen.png"));
        
        //knopfBestaetigen = new JButton(knopfBestaetigenIcon);
        knopfBestaetigen = new JButton("Bestätigen");
        knopfAbbrechen = new JButton(knopfAbbrechenIcon);
    }
    
    public void popupFensterErzeugen(String text){
        knopfBestaetigen.setFont(new Font("Arial", Font.PLAIN, 12));
        knoepfe.add(knopfBestaetigen);

        knopfAbbrechen.setFont(new Font("Arial", Font.PLAIN, 12));
        knoepfe.add(knopfAbbrechen);
        
        beendenFenster.add(BorderLayout.CENTER,knoepfe);
        
        
        beendenFenster.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-200,Toolkit.getDefaultToolkit().getScreenSize().height/2-300);
        beendenFenster.setSize(250,250);
        beendenFenster.setVisible(true);
        beendenFenster.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        beendenFenster.setResizable(false);
    }

    public void closePopupFenster()
    {
        beendenFenster.setVisible(false);
        beendenFenster.dispose();
    }
    
    public JButton getKnopfBestaetigen()
    {
        return knopfBestaetigen;
    }

    public JButton getKnopfAbbrechen()
    {
        return knopfAbbrechen;
    }
}
