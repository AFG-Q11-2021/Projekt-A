/**
 * Beschreiben Sie hier die Klasse HauptFenster.
 * 
 * @author (Rafael Marsmann, Paul Görner) 
 * @version (05.07.2021)
 */

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.io.IOException;

public class HauptFenster extends JFrame
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JPanel knoepfePanel;
    private JFrame frame;
    private JButton knopfSingleplayer, knopfMultiplayer, knopfProfil, knopfBeenden;
    private JTextArea blackjack;
    
    private ImageIcon knopfSingleplayerIcon, knopfMultiplayerIcon, knopfProfilIcon, knopfBeendenIcon;

    /**
     * Konstruktor für Objekte der Klasse HauptFenster
     */
    public HauptFenster()
    {
        super("Blackjack");
        frame = new JFrame();
        // Instanzvariable initialisieren
        knopfSingleplayerIcon = new ImageIcon(getClass().getResource("\\res\\knopfStart.jpg"));
        knopfMultiplayerIcon = new ImageIcon(getClass().getResource("\\res\\knopfMultiplayer.jpg"));
        knopfProfilIcon = new ImageIcon(getClass().getResource("\\res\\knopfProfil.jpg"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfClose.jpg"));
        
        
        knopfSingleplayer = new JButton(knopfSingleplayerIcon);
        knopfMultiplayer = new JButton(knopfMultiplayerIcon);
        knopfProfil = new JButton(knopfProfilIcon);
        knopfBeenden = new JButton(knopfBeendenIcon);
        
        knopfBeenden = new JButton(knopfBeendenIcon);
    }
    
    public void erzeugen()
    {
        frame.setName("Blackjack-Hauptmenü");
        frame.setSize(400,600);
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-200,Toolkit.getDefaultToolkit().getScreenSize().height/2-300);
        frame.add(erzeugeHintergrundPanel());
        frame.setVisible(true);
    }
    
    public void schließen()
    {
        frame.dispose();
    }
    
    private JPanel erzeugeHintergrundPanel()
    {   
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResource("\\res\\hauptmenü.png"));
        } catch(IOException ioe) {
            JOptionPane.showMessageDialog(null,
            "Das Hintergrundbild konnte nicht geladen werden!\n" + ioe.getLocalizedMessage(),
            ioe.getClass().getName(),
            JOptionPane.WARNING_MESSAGE);
           }

        BackgroundImagePanel mainPanel = new BackgroundImagePanel(new BorderLayout());
        mainPanel.setImage(image); //hier kann man einstellen, ob das Bild im Original oder eingepasst ausgegeben werden soll (true/false)
        
        mainPanel.setOpaque(false);
        mainPanel.add(erzeugeKnoepfePanel(mainPanel.isOpaque()), BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    public JPanel erzeugeKnoepfePanel(boolean opaque)
    {
        knopfSingleplayer.setOpaque(true);
        knopfSingleplayer.setPreferredSize(new Dimension(180,50));
        knopfMultiplayer.setOpaque(true);
        knopfMultiplayer.setPreferredSize(new Dimension(180,50));
        knopfProfil.setOpaque(true);
        knopfProfil.setPreferredSize(new Dimension(180,50));
        knopfBeenden.setOpaque(true);
        knopfBeenden.setPreferredSize(new Dimension(180,50));
        
        JPanel knoepfePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        knoepfePanel.setOpaque(opaque);
        
        //JPanel center1Panel = new JPanel(new FloLayout());
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        knoepfePanel.add(knopfSingleplayer, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        knoepfePanel.add(knopfMultiplayer, gbc);
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
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