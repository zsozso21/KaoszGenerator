// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:33:39
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ElonyHatranyPanel.java

package kaosz.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Referenced classes of package kaosz.view:
//            Lapozo, GUIControl

public class ElonyHatranyPanel extends JPanel
    implements ActionListener
{

    public ElonyHatranyPanel(GUIControl guiControl)
    {
        elonyHatrany();
        this.guiControl = guiControl;
    }

    public void elonyHatrany()
    {
        setLayout(new BorderLayout());
        add(new Lapozo(this), "South");
        add(new JLabel("El\u0151ny\366k/H\341tr\341nyok egyel\u0151re funkci\363 n\351lk\374l"), "Center");
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("Tov\341bb"))
            guiControl.setJartassagPanel();
        if(event.getActionCommand().equals("Vissza"))
            guiControl.setFoErtekPanel();
    }

    private GUIControl guiControl;
}
