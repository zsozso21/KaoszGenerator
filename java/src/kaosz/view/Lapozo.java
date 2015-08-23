// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:34:51
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Lapozo.java

package kaosz.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Lapozo extends JPanel
    implements ActionListener
{

    Lapozo(ActionListener listener)
    {
        setLayout(new BorderLayout());
        JButton Vissza = new JButton("Vissza");
        add(Vissza, "West");
        Vissza.addActionListener(listener);
        JButton Tovabb = new JButton("Tov\341bb");
        add(Tovabb, "East");
        Tovabb.addActionListener(listener);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    }
}
