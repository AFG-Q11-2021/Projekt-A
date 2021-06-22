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

public class Gui 
{
    private JFrame fenster, fensterBeenden;
    private JButton knopfHit,knopfStand,knopfStart,knopfStop,beendenJaKnopf,beendenNeinKnopf;
    private JPanel leisteRechts,leisteUntenBeenden;
    private JScrollPane scrollTextleiste;
    public JTextArea textleiste;

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
        fensterBeenden = new JFrame("Beenden?");

        leisteUntenBeenden = new JPanel();

        leisteUntenBeenden.add(beendenJaKnopf);
        leisteUntenBeenden.add(beendenNeinKnopf);

        fensterBeenden.add(BorderLayout.CENTER,leisteUntenBeenden);
        fensterBeenden.pack();
        fensterBeenden.setSize(200,80);
        fensterBeenden.setVisible(true);

    }

 

    public void beendenBestaetigenSchließen()
    {
        System.out.println("test");
        fensterBeenden.setVisible(false);
        fensterBeenden.dispose();
        fenster.setVisible(false);
        fenster.dispose();
    }

}

