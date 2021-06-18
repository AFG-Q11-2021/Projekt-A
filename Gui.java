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
import javax.swing.border.BevelBorder;

public class Gui 
{
    private JFrame fenster;
    private JButton knopf1,knopf2,knopf3,knopf4,beendenJaKnopf,beendenNeinKnopf;
    private JPanel leisteRechts,leisteUntenBeenden;
    public JPopupMenu beendenMenu; 
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

        

        fenster.add(BorderLayout.EAST, leisteRechts);
        textleiste  = new JTextArea();
        fenster.add(BorderLayout.SOUTH, textleiste);
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
    
    /*
    public void beendenBestaetigen()
    {
        JMenuItem item;
        
        beendenMenu = new JPopupMenu("Beenden?");
        
        beendenMenu.add(item = new JMenuItem("Settings"));
        beendenMenu.setLabel("Justification");
        beendenMenu.setBorder(new BevelBorder(BevelBorder.RAISED));
       leisteUntenBeenden = new JPanel();
        
        beendenJaKnopf = new JButton("Ja");
        beendenJaKnopf.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteUntenBeenden.add(beendenJaKnopf);
        
        beendenMenu.add(BorderLayout.EAST, leisteRechts);
        beendenMenu.setSize(100,60);
        beendenMenu.pack();
        beendenMenu.show();
    }
    */
}



