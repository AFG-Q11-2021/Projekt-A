/*
 * von Raphael
 * am 02.07.2021
 */
import java.awt.*;
import javax.swing.*;
public class PopupNeustartFenster extends Gui
{
    
    public PopupNeustartFenster()
    {
    
    }
    
    @Override
    public void popupFensterErzeugen(String knopfJaName, String knopfNeinName)
    { 
        /*
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
                  
        */
        super.popupFensterErzeugen(knopfJaName,knopfNeinName);
    }

    public JButton popupJaKnopfGeben()
    {
        return popupJaKnopf;
    }

    public JButton popupNeinKnopfGeben()
    {
        return popupNeinKnopf;  
    }
}
