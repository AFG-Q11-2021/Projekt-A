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
    
     
    
    public void gui(){
    
        fenster = new JFrame("Blackjack-Demo");
        
        
        
        
        leisteRechts = new JPanel();
        
        knopf1 = new JButton("Hit");
        knopf1.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf1);
        
        knopf1.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     System.out.println("Ja");
                 }          
          }
          );
          
          
        
        knopf2 = new JButton("Stand");
        knopf2.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf2);
        
        knopf2.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     System.out.println("Nein");
                 }          
          }
          );
          
          
        
        knopf3 = new JButton("Start");
        knopf3.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf3);
        
        knopf3.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     System.out.println("Ok Button3 clicked.");
                 }          
          }
          );
          
          
        
        knopf4 = new JButton ("Stop");
        knopf4.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteRechts.add(knopf4);
        
        
          knopf4.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     System.out.println("Ok Button4 clicked.");
                 }          
          }
          );
        
    
        fenster.add(BorderLayout.EAST, leisteRechts);
        
        
        
        textleiste  = new JTextArea();
        
        fenster.add(BorderLayout.SOUTH, textleiste);
        
        fenster.pack();
        
        
        fenster.setVisible(true);
        
    }
    
    
    
}