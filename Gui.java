/*
 * Zweitlösung für das Gui eingefügt
 * am 06.05.2021
 * von Sasha und Raphael
 * Popup Menü beim beenden + Textarea
 * am 18.06.
 * von Sasha, Raphael & Magdalena
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.Toolkit;
import java.awt.Image;

public class Gui 
{
    private JButton knopfHit,knopfStand,knopfStart,knopfStop,beendenJaKnopf,beendenNeinKnopf;
    private JPanel leisteRechts,leisteUntenBeenden;
    private JScrollPane scrollTextleiste;
    private Image image;
    public JTextArea textleiste;
    public JFrame fenster;
    private JDialog beendenFenster;
    
    public Gui(){       

        //erzeugt das Fenster und alle Elemente des GUIs
        fenster = new JFrame("Blackjack-Demo");
        leisteRechts = new JPanel();

        knopfHit = new JButton("Hit");
        knopfHit.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopfHit);

        knopfStand = new JButton("Stand");
        knopfStand.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopfStand);

        knopfStart = new JButton("Start");
        knopfStart.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopfStart);

        knopfStop = new JButton ("Stop");
        knopfStop.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopfStop);

        beendenJaKnopf = new JButton("Beenden");
        beendenJaKnopf.setFont(new Font("Arial", Font.PLAIN, 12));

        beendenNeinKnopf = new JButton("Nein");
        beendenNeinKnopf.setFont(new Font("Arial", Font.PLAIN, 12));

        textleiste  = new JTextArea();

        scrollTextleiste = new JScrollPane(textleiste);
        scrollTextleiste.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        fenster.add(scrollTextleiste);

        
        fenster.add(BorderLayout.EAST, leisteRechts);
        //fenster.add(BorderLayout.SOUTH, textleiste);
        fenster.pack();
        fenster.setSize(1000,600);
        
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\Icon.png"));
        fenster.setIconImage(image);

        fenster.setVisible(true);
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

    public JButton beendenJaKnopfGeben()
    {
        return beendenJaKnopf;
    }

    public JButton beendenNeinKnopfGeben()
    {
        return beendenNeinKnopf;
    }

    public void beendenBestaetigen()
    {
        beendenFenster = new JDialog();
        beendenFenster.setLocation(500,350);
        beendenFenster.setSize(200,75);
        beendenFenster.setVisible(true);
        beendenFenster.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        beendenFenster.setResizable(false);
        
        leisteUntenBeenden = new JPanel();
        beendenFenster.add(BorderLayout.CENTER,leisteUntenBeenden);
        leisteUntenBeenden.add(beendenJaKnopf);
        leisteUntenBeenden.add(beendenNeinKnopf);
    }


    public void beendenBestaetigenSchließen()
    {
        beendenFenster.setVisible(false);
        beendenFenster.dispose();
    }

}

