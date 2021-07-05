/*
 * Zweitlösung für das Gui eingefügt
 * am 06.05.2021
 * von Sasha und Raphael
 * Popup Menü beim beenden + Textarea
 * am 18.06.
 * von Sascha, Raphael & Magdalena
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Gui 
{

    public JFrame fenster;
    public JFrame kartenbild;
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


        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());     
        fenster.setSize(xSize,ySize);


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
        leisteUntenBeenden = new JPanel();
        
        beendenFenster.add(BorderLayout.CENTER,leisteUntenBeenden); 

        popupJaKnopf = new JButton(knopfJaName);
        popupJaKnopf.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteUntenBeenden.add(popupJaKnopf);

        popupNeinKnopf = new JButton(knopfNeinName);
        popupNeinKnopf.setFont(new Font("Arial", Font.PLAIN, 12));
        leisteUntenBeenden.add(popupNeinKnopf);

        beendenFenster.setLocation(500,350);
        beendenFenster.setSize(250,75);
        beendenFenster.setVisible(true);
        beendenFenster.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        beendenFenster.setResizable(false);
    }

    public void popupFensterErzeugenSchließen()
    {
        beendenFenster.setVisible(false);
        beendenFenster.dispose();
    }
    
    // Erzeugt Karten auf dem Spielertisch, sobald eine gezogen wurde.
    

}

