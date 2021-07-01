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

public class Gui 
{

    public JFrame fenster;
    private Image image;
    
    private JDialog beendenFenster;
    private JPanel leisteUntenBeenden;
    public JButton popupJaKnopf,popupNeinKnopf;
    
    public Gui()
    {          
    }
    
     //erzeugt das Fenster und alle Elemente des GUIs
    public void fensterErzeugen(String fensterName)
    {
        //setzt das Icon des Fensters
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\res\\Icon.png"));
        fenster.setIconImage(image);
        
        fenster.pack();
        fenster.setSize(1000,600);
        fenster.setVisible(true);
    }

    //setzt das look and feel des Guis
    public static void laF() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (UnsupportedLookAndFeelException e) {
            System.out.println("LaF fehler");
        }
        catch (ClassNotFoundException e) {
            System.out.println("LaF fehler");
        }
        catch (InstantiationException e) {
            System.out.println("LaF fehler");
        }
        catch (IllegalAccessException e) {
            System.out.println("LaF fehler");
        }
    }
    
    
        public JButton popupJaKnopfGeben()
    {
        return popupJaKnopf;
    }
    
    public JButton popupNeinKnopfGeben()
    {
        return popupNeinKnopf;
    }
    
    public void popupFensterErzeugen(String knopfJaName, String knopfNeinName)
    {        
        //JDialog popupFenster = new JDialog(fenster,titel);
        beendenFenster = new JDialog();
        
        popupJaKnopf = new JButton(knopfJaName);
        popupJaKnopf.setFont(new Font("Arial", Font.PLAIN, 12));

        popupNeinKnopf = new JButton(knopfNeinName);
        popupNeinKnopf.setFont(new Font("Arial", Font.PLAIN, 12));
        
        beendenFenster.setLocation(500,350);
        beendenFenster.setSize(200,75);
        beendenFenster.setVisible(true);
        beendenFenster.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        beendenFenster.setResizable(false);

        leisteUntenBeenden = new JPanel();
        beendenFenster.add(BorderLayout.CENTER,leisteUntenBeenden);
        leisteUntenBeenden.add(popupJaKnopf);
        leisteUntenBeenden.add(popupNeinKnopf);
    }

    public void popupFensterErzeugenSchließen()
    {
        beendenFenster.setVisible(false);
        beendenFenster.dispose();
    }

}

