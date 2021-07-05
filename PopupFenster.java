/**
 * Beschreiben Sie hier die Klasse PopupFenster.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;

public class PopupFenster
{
    private JDialog beendenFenster;
    private JPanel knoepfe;
    private JButton knopfBestaetigen,knopfAbbrechen;
    
    public PopupFenster()
    {
        beendenFenster = new JDialog();
        knoepfe = new JPanel();
        
        knopfBestaetigen = new JButton("Bestätigen");
        knopfAbbrechen = new JButton("Abbrechen");
    }
    
    public void popupFensterErzeugen(String text){
        knopfBestaetigen.setFont(new Font("Arial", Font.PLAIN, 12));
        knoepfe.add(knopfBestaetigen);

        knopfAbbrechen.setFont(new Font("Arial", Font.PLAIN, 12));
        knoepfe.add(knopfAbbrechen);
        
        beendenFenster.add(BorderLayout.CENTER,knoepfe);
        
        beendenFenster.setLocation(500,350);
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
