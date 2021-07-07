/**
 * Beschreiben Sie hier die Klasse HauptFenster.
 * 
 * @author (Rafael Marsmann, Paul Görner) 
 * @version (05.07.2021)
 */

import javax.swing.*;
import java.awt.*;

public class HauptFenster extends JFrame
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JPanel knoepfePanel;
    private JFrame frame;
    private JButton knopfSingleplayer, knopfMultiplayer, knopfProfil, knopfBeenden;
    
    private ImageIcon knopfSingelplayerIcon, knopfMultiplayerIcon, knopfProfilIcon, knopfBeendenIcon;

    /**
     * Konstruktor für Objekte der Klasse HauptFenster
     */
    public HauptFenster()
    {
        super("Blackjack");
        frame = new JFrame();
        // Instanzvariable initialisieren
        knopfSingelplayerIcon = new ImageIcon(getClass().getResource("\\res\\knopfSpielstart.png"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfBeenden.png"));
        
        
        knopfSingleplayer = new JButton(knopfSingelplayerIcon);
        knopfMultiplayer = new JButton("Multiplayer");
        knopfProfil = new JButton("Profil");
        knopfBeenden = new JButton(knopfBeendenIcon);
    }
    
    public void erzeugen()
    {
        frame.setName("Blackjack-Hauptmenü");
        frame.setSize(1000,1000);
        
        frame.add(erzeugeHintergrundPanel());
        frame.setVisible(true);
    }
    
    public void schließen()
    {
        frame.dispose();
    }
    
    private JPanel erzeugeHintergrundPanel()
    {   
        /*Image image = null;
         * try {
         *     image = ImageIO.read(getClass().getResource("\\res\\dealertisch.png"));
         *  } catch(IOException ioe) {
         *      JOptionPane.showMessageDialog(null,
         *      "Das Hintergrundbild konnte nicht geladen werden!\n" + ioe.getLocalizedMessage(),
         *      ioe.getClass().getName(),
         *      JOptionPane.WARNING_MESSAGE);
         *  }

         *  BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());
         *  mainPanel.setImage(image); //hier kann man einstellen, ob das Bild im Original oder eingepasst ausgegeben werden soll (true/false)
         */
        
        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(true);
        mainPanel.add(erzeugeKnoepfePanel(mainPanel.isOpaque()));
        
        return mainPanel;
    }
    
    public JPanel erzeugeKnoepfePanel(boolean opaque)
    {
        JPanel knoepfePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        knoepfePanel.setOpaque(opaque);
        
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
        //Ereignisverarbeitung fehlt!
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