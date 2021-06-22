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
    private JButton knopf1,knopf2,knopf3,knopf4,beendenJaKnopf,beendenNeinKnopf;
    private JPanel leisteRechts,leisteUntenBeenden;
    private JScrollPane scrollTextleiste;
    public JTextArea textleiste;

    public Gui(){   
        //erzeugt das Fenster und alle Elemente des GUIs
        fenster = new JFrame("Blackjack-Demo");
        leisteRechts = new JPanel();
        
        knopf1 = new JButton("Hit");
        knopf1.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf1);

        knopf2 = new JButton("Stand");
        knopf2.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf2);

        knopf3 = new JButton("Start");
        knopf3.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf3);

        knopf4 = new JButton ("Stop");
        knopf4.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf4);

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

    public JButton knopf1Geben()
    {
        return knopf1;
    }

    public JButton knopf2Geben()
    {
        return knopf2;
    }

    public JButton knopf3Geben()
    {
        return knopf3;
    }

    public JButton knopf4Geben()
    {
        return knopf4;
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

    public JButton beendenJaKnopfGeben()
    {
        return beendenJaKnopf;
    }

    public JButton beendenNeinKnopfGeben()
    {
        return beendenNeinKnopf;
    }

    public void beendenBestaetigenSchließen()
    {
        System.out.println("test");
        fensterBeenden.setVisible(false);
        fensterBeenden.dispose();
    }

}

