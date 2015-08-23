// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:34:40
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   KaoszGenerator.java

package kaosz.view;


// Referenced classes of package kaosz.view:
//            GUI

public class KaoszGenerator
{

    public KaoszGenerator()
    {
    }

    public void startDesktop()
    {
        GUI gui = new GUI();
        gui.startGUI();
    }

    public static void main(String args[])
    {
        KaoszGenerator kaosz = new KaoszGenerator();
        kaosz.startDesktop();
    }
}
