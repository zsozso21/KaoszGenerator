// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:33:44
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ErtekPanel.java

package kaosz.view;

import javax.swing.JPanel;
import kaosz.model.bean.Karakter;

// Referenced classes of package kaosz.view:
//            GUIControl

public class ErtekPanel extends JPanel
{

    public ErtekPanel(GUIControl guiControl)
    {
        this.guiControl = guiControl;
    }

    public String getFoErtekPanel()
    {
        return (new StringBuilder("Megmaradt Jp:")).append(Karakter.getJartassagPont()).append(". Megmaradt F\u0151\351rt\351k pont: ").append(Karakter.getFoErtekPont()).toString();
    }

    public String getJartassagPanel()
    {
        return "";
    }

    private GUIControl guiControl;
    private static int i = 0;

}
