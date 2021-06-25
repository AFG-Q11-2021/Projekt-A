import java.awt.*;
import javax.swing.*;

public class PopupBeendenFenster extends Gui
{
    public PopupBeendenFenster()
    {
        fenster = new JFrame("Blackjack-Demo");
    }
 /*   
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
    */
}
