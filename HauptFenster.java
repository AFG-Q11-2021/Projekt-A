
/**
 * Beschreiben Sie hier die Klasse HauptFenster.
 * 
 * @author (Rafael Marsmann, Paul Görner) 
 * @version (05.07.2021)
 */

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class HauptFenster extends JPanel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JPanel knoepfePanel;
    private JButton knopfSingleplayer, knopfMultiplayer, knopfProfil, knopfBeenden;
    private ImageIcon knopfSingelplayerIcon, knopfMultiplayerIcon, knopfProfilIcon, knopfBeendenIcon;

    /**
     * Konstruktor für Objekte der Klasse HauptFenster
     */
    public HauptFenster()
    {
        // Instanzvariable initialisieren
        knopfSingelplayerIcon = new ImageIcon(getClass().getResource("\\res\\knopfSpielstart.png"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfBeenden.png"));
        
        
        knopfSingleplayer = new JButton();
        knopfMultiplayer = new JButton("Multiplayer");
        knopfProfil = new JButton("Profil");
        knopfBeenden = new JButton();
        
        knoepfePanel = new JPanel();
    }
    
    public void paint(Graphics g)
    {
        //knopfSingleplayer = new RoundButton("Singleplayer", 75);
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public JPanel knoepfeErzeugen()
    {
        knoepfePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        knopfSingleplayer.setIcon(knopfSingelplayerIcon);
        //knopfSingleplayer.setFont(new Font("Arial", Font.PLAIN, 24));
        
        //knopfMultiplayer.setIcon(knopfMultiplayerIcon);
        knopfMultiplayer.setFont(new Font("Arial", Font.PLAIN, 24));
        
        //knopfProfil.setIcon(knopfProfilIcon);
        knopfProfil.setFont(new Font("Arial", Font.PLAIN, 24));
        
        knopfBeenden.setIcon(knopfBeendenIcon);
        //knopfBeenden.setFont(new Font("Arial", Font.PLAIN, 24));
        
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        knoepfePanel.add(knopfSingleplayer, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        knoepfePanel.add(knopfMultiplayer, gbc);
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        knoepfePanel.add(knopfProfil, gbc);
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        knoepfePanel.add(knopfBeenden, gbc);
        
        return knoepfePanel;
    }
    
    public JButton getKnopfSingleplayer()
    {
        return knopfSingleplayer;
    }
    
    public JButton getKnopfMultiplayer()
    {
        return knopfMultiplayer;
    }

    public JButton getKnopfProfil()
    {
        return knopfProfil;
    }
    
    public JButton getKnopfBeenden()
    {
        return knopfBeenden;
    }
}