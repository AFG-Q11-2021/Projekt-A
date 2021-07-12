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

public class HauptFenster
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JPanel knoepfePanel;
    private JFrame frame;
    private JButton knopfSingleplayer, knopfMultiplayer, knopfProfil, knopfCredits, knopfRegeln, knopfBeenden;
    private JTextArea blackjack;
    
    private ImageIcon knopfSingleplayerIcon, knopfMultiplayerIcon, knopfProfilIcon, knopfCreditsIcon, knopfRegelnIcon, knopfBeendenIcon;

    /**
     * Konstruktor für Objekte der Klasse HauptFenster
     */
    public HauptFenster()
    {
        frame = new JFrame();
        
        knopfSingleplayerIcon = new ImageIcon(getClass().getResource("\\res\\knopfStart.jpg"));
        knopfMultiplayerIcon = new ImageIcon(getClass().getResource("\\res\\knopfMultiplayer.jpg"));
        knopfProfilIcon = new ImageIcon(getClass().getResource("\\res\\knopfProfil.jpg"));
        knopfCreditsIcon = new ImageIcon(getClass().getResource("\\res\\knopfCredits.jpg"));
        knopfRegelnIcon = new ImageIcon(getClass().getResource("\\res\\knopfRegeln.jpg"));
        knopfBeendenIcon = new ImageIcon(getClass().getResource("\\res\\knopfClose.jpg"));
        
        knopfSingleplayer = new JButton(knopfSingleplayerIcon);
        knopfMultiplayer = new JButton(knopfMultiplayerIcon);
        knopfProfil = new JButton(knopfProfilIcon);
        knopfCredits = new JButton(knopfCreditsIcon);
        knopfRegeln = new JButton(knopfRegelnIcon);
        knopfBeenden = new JButton(knopfBeendenIcon);
    }
    
    public void erzeugen()
    {
        frame.setSize(400,600);
        frame.setResizable(false);
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
        mainPanel.add(erzeugeKnoepfePanelTop(mainPanel.isOpaque()), BorderLayout.NORTH);
        mainPanel.add(erzeugeKnoepfePanelCenter(mainPanel.isOpaque()), BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    public JPanel erzeugeKnoepfePanelCenter(boolean opaque)
    {
        knopfSingleplayer.setOpaque(true);
        knopfSingleplayer.setPreferredSize(new Dimension(180,50));
        knopfMultiplayer.setOpaque(true);
        knopfMultiplayer.setPreferredSize(new Dimension(180,50));
        knopfRegeln.setOpaque(true);
        knopfRegeln.setPreferredSize(new Dimension(360,50));
        knopfCredits.setOpaque(true);
        knopfCredits.setPreferredSize(new Dimension(360,50));
        
        JPanel knoepfePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        knoepfePanel.setOpaque(opaque);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        knoepfePanel.add(knopfSingleplayer, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        knoepfePanel.add(knopfMultiplayer, gbc);
        
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        knoepfePanel.add(knopfRegeln, gbc);
        
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        knoepfePanel.add(knopfCredits, gbc);
        
        return knoepfePanel;
    }
    
    public JPanel erzeugeKnoepfePanelTop(boolean opaque)
    {
        knopfProfil.setOpaque(true);
        knopfProfil.setPreferredSize(new Dimension(180,50));
        knopfBeenden.setOpaque(true);
        knopfBeenden.setPreferredSize(new Dimension(180,50));
        
        JPanel knoepfePanelLinks = new JPanel(new FlowLayout(FlowLayout.LEFT));
        knoepfePanelLinks.setOpaque(opaque);
        knoepfePanelLinks.add(knopfProfil);
        
        JPanel knoepfePanelRechts = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        knoepfePanelRechts.setOpaque(opaque);
        knoepfePanelRechts.add(knopfBeenden);
        
        JPanel knoepfePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        knoepfePanel.setOpaque(opaque);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        knoepfePanel.add(knoepfePanelLinks, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        knoepfePanel.add(knoepfePanelRechts, gbc);
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
    
    public JButton getKnopfRegeln()
    {
        return knopfRegeln;
    }
    
    public JButton getKnopfCredits()
    {
        return knopfCredits;
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