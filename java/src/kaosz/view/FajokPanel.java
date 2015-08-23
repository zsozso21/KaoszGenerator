// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:33:49
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FajokPanel.java

package kaosz.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import kaosz.model.Fajok;
import kaosz.model.Konstansok;
import kaosz.model.bean.*;

// Referenced classes of package kaosz.view:
//            GUIControl

public class FajokPanel extends JPanel
    implements ActionListener, ChangeListener
{

    public FajokPanel(GUIControl guiControl)
    {
        gui = guiControl;
        try
        {
            Konstansok kons = new Konstansok();
            kons.setKonstansok();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        panelek();
    }

    private void panelek()
    {
        setLayout(new GridLayout(2, 1));
        add(fajLista());
        add(korszak());
    }

    private JPanel fajLista()
    {
        JPanel panel = new JPanel();
        Fajok fajXML = null;
        try
        {
            fajXML = new Fajok();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        fajok = fajXML.getFajok();
        panel.setLayout(new FlowLayout());
        JButton gomb;
        for(Iterator iterator = fajok.entrySet().iterator(); iterator.hasNext(); gomb.addActionListener(this))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            gomb = new JButton((String)entry.getKey());
            panel.add(gomb);
        }

        return panel;
    }

    private JPanel korszak()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(juvenisPanel());
        panel.add(adultusPanel());
        panel.add(seniusPanel());
        juvenisFoertek.setEnabled(false);
        juvenisJartassag.setEnabled(false);
        seniusFoertek.setEnabled(false);
        seniusJartassag.setEnabled(false);
        ButtonGroup group = new ButtonGroup();
        group.add(juvenis);
        group.add(adultus);
        group.add(senius);
        return panel;
    }

    private JPanel juvenisPanel()
    {
        JPanel panel = new JPanel();
        juvenis = new JRadioButton();
        juvenis.setText("juvenis");
        panel.add(juvenis);
        juvenis.addActionListener(this);
        panel.add(new JLabel("F\u0151\351rt\351k pontok(%)"));
        SpinnerNumberModel model = new SpinnerNumberModel(80, 50, 80, 10);
        juvenisFoertek = new JSpinner(model);
        panel.add(juvenisFoertek);
        juvenisFoertek.addChangeListener(this);
        panel.add(new JLabel("J\341rtass\341g pontok(%)"));
        model = new SpinnerNumberModel(80, 30, 80, 10);
        juvenisJartassag = new JSpinner(model);
        panel.add(juvenisJartassag);
        juvenisJartassag.addChangeListener(this);
        return panel;
    }

    private JPanel adultusPanel()
    {
        JPanel panel = new JPanel();
        adultus = new JRadioButton();
        adultus.setText("adultus");
        panel.add(adultus);
        adultus.addActionListener(this);
        adultus.setSelected(true);
        return panel;
    }

    private JPanel seniusPanel()
    {
        JPanel panel = new JPanel();
        senius = new JRadioButton();
        senius.setText("senius");
        panel.add(senius);
        senius.addActionListener(this);
        panel.add(new JLabel("F\u0151\351rt\351k pontok(%)"));
        SpinnerNumberModel model = new SpinnerNumberModel(80, 50, 80, 10);
        seniusFoertek = new JSpinner(model);
        panel.add(seniusFoertek);
        seniusFoertek.addChangeListener(this);
        panel.add(new JLabel("J\341rtass\341g pontok(%)"));
        model = new SpinnerNumberModel(200, 200, 500, 100);
        seniusJartassag = new JSpinner(model);
        panel.add(seniusJartassag);
        seniusJartassag.addChangeListener(this);
        panel.add(new JLabel("Maxim\341lisan tanulhat\363 j\341rtass\341gszint:"));
        model = new SpinnerNumberModel(3, 3, 10, 1);
        jartassagSzintMax = new JSpinner(model);
        panel.add(jartassagSzintMax);
        jartassagSzintMax.addChangeListener(this);
        return panel;
    }

    private void gombNyomas(ActionEvent event)
    {
        Faj faj = (Faj)fajok.get(event.getActionCommand());
        Karakter.setFaj(faj);
        Karakter.setJartassagSzintMax(faj.getMaxJartassagSzint());
        
        if(juvenis.isSelected())
        {
            Karakter.setAlapFoErtekPont((Konstans.getFoErtekPontok() * ((Integer)juvenisFoertek.getValue()).intValue()) / 100);
            Karakter.setAlapJartassagPont((Konstans.getJartassagPontok() * ((Integer)juvenisJartassag.getValue()).intValue()) / 100);
        }
        if(adultus.isSelected())
        {
            Karakter.setAlapFoErtekPont(Konstans.getFoErtekPontok());
            Karakter.setAlapJartassagPont(Konstans.getJartassagPontok());
        }
        if(senius.isSelected())
        {
            Karakter.setAlapFoErtekPont((Konstans.getFoErtekPontok() * ((Integer)seniusFoertek.getValue()).intValue()) / 100);
            Karakter.setAlapJartassagPont((Konstans.getJartassagPontok() * ((Integer)seniusJartassag.getValue()).intValue()) / 100);
            int fizikumMinIdg = faj.getFizikumMin();
            int ratermettsegMinIdg = faj.getRatermettsegMin();
            faj.setFizikumMin((fizikumMinIdg * ((Integer)seniusFoertek.getValue()).intValue()) / 100);
            faj.setRatermettsegMin((ratermettsegMinIdg * ((Integer)seniusFoertek.getValue()).intValue()) / 100);
            int atlagosValtozas = ((fizikumMinIdg + ratermettsegMinIdg) - faj.getFizikumMin() - faj.getRatermettsegMin()) / 2;
            faj.setEsszenciaMax(faj.getEsszenciaMax() + atlagosValtozas);
            faj.setTudatMax(faj.getTudatMax() + atlagosValtozas);
            Karakter.setJartassagSzintMax(((Integer)jartassagSzintMax.getValue()).intValue());
        }
        gui.setFoErtekPanel();
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource().getClass().equals((new JButton()).getClass()))
            gombNyomas(event);
        if(event.getSource() == juvenis)
        {
            juvenisFoertek.setEnabled(true);
            juvenisJartassag.setEnabled(true);
            seniusFoertek.setEnabled(false);
            seniusJartassag.setEnabled(false);
        }
        if(event.getSource() == adultus)
        {
            juvenisFoertek.setEnabled(false);
            juvenisJartassag.setEnabled(false);
            seniusFoertek.setEnabled(false);
            seniusJartassag.setEnabled(false);
        }
        if(event.getSource() == senius)
        {
            juvenisFoertek.setEnabled(false);
            juvenisJartassag.setEnabled(false);
            seniusFoertek.setEnabled(true);
            seniusJartassag.setEnabled(true);
        }
    }

    public void stateChanged(ChangeEvent changeevent)
    {
    }

    private static final long serialVersionUID = 0xa31c8233d2592389L;
    private GUIControl gui;
    private Map fajok;
    private JSpinner juvenisFoertek;
    private JSpinner juvenisJartassag;
    private JSpinner seniusFoertek;
    private JSpinner seniusJartassag;
    private JSpinner jartassagSzintMax;
    private JRadioButton juvenis;
    private JRadioButton adultus;
    private JRadioButton senius;
}
