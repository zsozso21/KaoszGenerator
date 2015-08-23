// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:34:29
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   GUIControl.java

package kaosz.view;

import javax.swing.JOptionPane;

// Referenced classes of package kaosz.view:
//            FajokPanel, GUI, FoErtekPanel, ElonyHatranyPanel, 
//            JartassagPanel

public class GUIControl
{

    public GUIControl(GUI gui)
    {
        this.gui = gui;
    }

    public void setFajokPanel()
    {
        fajokPanel = new FajokPanel(this);
        gui.setActualContent(fajokPanel);
    }

    public void setFoErtekPanel()
    {
        foErtekPanel = new FoErtekPanel(this);
        gui.setActualContent(foErtekPanel);
    }

    public void setElonyHatranyPanel()
    {
        elonyHatranyPanel = new ElonyHatranyPanel(this);
        gui.setActualContent(elonyHatranyPanel);
    }

    public void setJartassagPanel()
    {
        jartassagPanel = new JartassagPanel(this);
        gui.setActualContent(jartassagPanel);
    }

    public void addPopup(String szoveg)
    {
        JOptionPane popup = new JOptionPane();
        JOptionPane.showMessageDialog(gui.getWindow(), szoveg);
    }

    private FajokPanel fajokPanel;
    private FoErtekPanel foErtekPanel;
    private ElonyHatranyPanel elonyHatranyPanel;
    private JartassagPanel jartassagPanel;
    private GUI gui;
}
