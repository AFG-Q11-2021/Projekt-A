/*
 * Zweitlösung für das Gui eingefügt
 * am 06.05.2021
 * von Sasha und Raphael
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gui 
{

    private JFrame fenster;
    private JButton knopf1,knopf2,knopf3,knopf4;
    private JPanel leisteRechts;
    private JTextArea textleiste;
    
    public Gui(){
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
     * public void action2Performed(ActionEvent e) {
        System.out.println("Nein");
    }          

    public void action3Performed(ActionEvent e) 
    {
        System.out.println("Ok Button3 clicked.");
    }

    
    public void action4Performed(ActionEvent e) {
        System.out.println("Ok Button4 clicked.");
        textleiste.append("lo");
     */

    }



