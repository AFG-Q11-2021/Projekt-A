/*
 * erzeugt das Startmenü.
 * 
 * von Raphael
 * am 28.06.2021
 */

import java.awt.*;
import javax.swing.*;
public class StartMenue extends Gui
{
    private JButton knopfSpielstart, knopfSpielstartAbbrechen;
    private JPanel spielstartPanel;

    public StartMenue()
    {

    }
    
    public JButton knopfSpielstartGeben()
    {
        return knopfSpielstart;
    }
    
    public JButton knopfSpielstartAbbrechenGeben()
    {
        return knopfSpielstartAbbrechen;
    }

    @Override
    public void fensterErzeugen(String fensterName)
    { 
        fenster = new JFrame(fensterName);
        
        spielstartPanel = new JPanel();
         
        Image spielstartIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\knopfSpielstart.png"));
        knopfSpielstart = new JButton(new ImageIcon(spielstartIcon));
        knopfSpielstart.setFont(new Font("Arial", Font.PLAIN, 24));        
        spielstartPanel.add(knopfSpielstart);
                
        Image spielstartAbbrechenIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\knopfSpielstartAbbrechen.png"));
        knopfSpielstartAbbrechen = new JButton(new ImageIcon(spielstartAbbrechenIcon));
        knopfSpielstartAbbrechen.setFont(new Font("Arial", Font.PLAIN, 24));
        spielstartPanel.add(knopfSpielstartAbbrechen);
         
        fenster.add(BorderLayout.CENTER,spielstartPanel);
        
        super.fensterErzeugen(fensterName);
    }
    
}
