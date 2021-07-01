import java.awt.*;
import javax.swing.*;

public class PopupBeendenFenster extends Gui
{
    @Override
    public void popupFensterErzeugen(String knopfJaName, String knopfNeinName)
    { 
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
