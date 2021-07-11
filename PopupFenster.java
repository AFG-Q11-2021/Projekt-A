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
    private JButton knopfJa, knopfNein;
    private JLabel ereignisLabel, beendenLabel;
    private ImageIcon knopfJaIcon, knopfNeinIcon, ereignisIcon, beendenIcon;
    
    public PopupFenster()
    {
        beendenFenster = new JDialog();
        
        knopfJaIcon = new ImageIcon(getClass().getResource("\\res\\knopfJa.jpg"));
        knopfNeinIcon = new ImageIcon(getClass().getResource("\\res\\knopfNein.jpg"));
        
        //knopfBestaetigen = new JButton(knopfBestaetigenIcon);
        knopfJa = new JButton(knopfJaIcon);
        knopfNein = new JButton(knopfNeinIcon);
    }
    
    public void popupFensterErzeugen(int ereignis){
        beendenFenster.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-200,Toolkit.getDefaultToolkit().getScreenSize().height/2-300);
        if(ereignis == 0)
        {
            beendenFenster.setSize(376,139);
        }else
        {
            beendenFenster.setSize(376,189);
        }
        beendenFenster.add(verwaltenPanel(true, ereignis));
        beendenFenster.setVisible(true);
        beendenFenster.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        beendenFenster.setResizable(false);
    }

    public void closePopupFenster()
    {
        beendenFenster.dispose();
    }
    public JPanel verwaltenPanel(boolean opaque, int ereignis)
    {
        ereignisLabel = new JLabel();
        beendenLabel = new JLabel();
        
        knopfJa.setOpaque(true);
        knopfJa.setPreferredSize(new Dimension(180,50));
        
        knopfNein.setOpaque(true);
        knopfNein.setPreferredSize(new Dimension(180,50));
        
        beendenIcon = new ImageIcon(getClass().getResource("\\res\\ereignisse\\ereignis0.jpg"));
        beendenLabel.setPreferredSize(new Dimension(360,50));
        beendenLabel.setIcon(beendenIcon);
        beendenLabel.setOpaque(true);
        
        JPanel verwaltenPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        verwaltenPanel.setOpaque(opaque);
        
        if(ereignis != 0){
            ereignisIcon = new ImageIcon(getClass().getResource("\\res\\ereignisse\\ereignis"+ ereignis +".jpg"));
            ereignisLabel.setPreferredSize(new Dimension(360,50));
            ereignisLabel.setIcon(ereignisIcon);
            ereignisLabel.setOpaque(true);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            verwaltenPanel.add(ereignisLabel, gbc);
        }
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        verwaltenPanel.add(beendenLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        verwaltenPanel.add(knopfJa, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        verwaltenPanel.add(knopfNein, gbc);
        
        return verwaltenPanel;
    }
    
    public JButton getKnopfJa()
    {
        return knopfJa;
    }

    public JButton getKnopfNein()
    {
        return knopfNein;
    }
}
