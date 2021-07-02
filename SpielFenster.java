/*
 * Erzeugt das Spielfenster
 * 
 * von Raphael
 * am 28.06.2021
 */

import java.awt.*;
import javax.swing.*;
public class SpielFenster extends Gui
{
    private JButton knopfHit,knopfStand,knopfStart,knopfStop;
    private JPanel leisteUnten, leisteRechts;
    private JScrollPane scrollTextleiste;
    public JTextArea textleiste;
    public JTextPane dealerWertPane, spielerWertPane;

    public SpielFenster()
    {
    }

    @Override
    public void fensterErzeugen(String fensterName)
    {   
        fenster = new JFrame(fensterName);

        leisteRechts = new JPanel();
        leisteUnten = new JPanel();
        
        dealerWertPane = new JTextPane();
        leisteRechts.add(dealerWertPane);

        spielerWertPane = new JTextPane();
        leisteRechts.add(spielerWertPane);

        Image hitIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\knopfHit.png"));
        knopfHit = new JButton(new ImageIcon(hitIcon));
        knopfHit.setFont(new Font("Arial", Font.PLAIN, 12));
        //knopfHit.setPreferredSize(new Dimension(100, 40));
        leisteUnten.add(knopfHit);

        Image standIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\knopfStand.png"));
        knopfStand = new JButton(new ImageIcon(standIcon));
        knopfStand.setFont(new Font("Arial", Font.PLAIN, 12));
        //knopfStand.setPreferredSize(new Dimension(100, 40));
        leisteUnten.add(knopfStand);

        Image startIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\knopfSpielstart.png"));
        knopfStart = new JButton(new ImageIcon(startIcon));
        knopfStart.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteUnten.add(knopfStart);

        Image beendenIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\knopfBeenden.png"));
        knopfStop = new JButton (new ImageIcon(beendenIcon));
        knopfStop.setFont(new Font("Arial", Font.PLAIN, 12));
        //knopfStop.setPreferredSize(new Dimension(100, 40));
        leisteUnten.add(knopfStop);

        textleiste  = new JTextArea();

        scrollTextleiste = new JScrollPane(textleiste);
        scrollTextleiste.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        fenster.add(scrollTextleiste);

        fenster.add(BorderLayout.SOUTH, leisteUnten);
        fenster.add(BorderLayout.EAST, leisteRechts);
        super.fensterErzeugen(fensterName);
    }

    public JButton knopfHitGeben()
    {
        return knopfHit;
    }

    public JButton knopfStandGeben()
    {
        return knopfStand;
    }

    public JButton knopfStartGeben()
    {
        return knopfStart;
    }

    public JButton knopfStopGeben()
    {
        return knopfStop;
    }
}
