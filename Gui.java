 /*
 * Gui
 * am 04.05.2021
 * von Sasha und Raphael
 */

/*
 
import java.awt.Button;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import jdk.internal.org.jline.utils.Display;

public class Gui {

    protected Shell shell;

    /**
     * Launch the application.
     * @param args
     */
    /*
    public static void main(String[] args) {
        try {
            Gui window = new Gui();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    /*
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
*/
    /**
     * Create contents of the window.
     */
/*
    protected void createContents() {
        shell = new Shell();
        shell.setSize(826, 573);
        shell.setText("SWT Application");
        shell.setLayout(null);
        
        Button btnNewButton = new Button(shell, SWT.FLAT);
        btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        btnNewButton.setBounds(601, 485, 120, 49);
        btnNewButton.setText("Stand");
        
        Button btnHit = new Button(shell, SWT.FLAT);
        btnHit.setText("Hit");
        btnHit.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        btnHit.setBounds(601, 430, 120, 49);
        
        Button btnSplit = new Button(shell, SWT.NONE);
        btnSplit.setBounds(727, 509, 73, 25);
        btnSplit.setText("Split");
        
        Button btnNewButton_1 = new Button(shell, SWT.NONE);
        btnNewButton_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            }
        });
        btnNewButton_1.setBounds(727, 454, 73, 25);
        btnNewButton_1.setText("Double");
        
        Button btnNewButton_2 = new Button(shell, SWT.NONE);
        btnNewButton_2.setFont(SWTResourceManager.getFont("Segoe UI", 21, SWT.NORMAL));
        btnNewButton_2.setBounds(601, 10, 199, 49);
        btnNewButton_2.setText("Start");
        
        Button btnNewButton_3 = new Button(shell, SWT.NONE);
        btnNewButton_3.setFont(SWTResourceManager.getFont("Segoe UI", 21, SWT.NORMAL));
        btnNewButton_3.setBounds(601, 65, 199, 49);
        btnNewButton_3.setText("Stop");

    }
}

*/