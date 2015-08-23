// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:34:34
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JartassagPanel.java

package kaosz.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kaosz.model.Jartassagok;
import kaosz.model.bean.Jartassag;
import kaosz.model.bean.Karakter;
import kaosz.view.layout.SpringUtilities;

// Referenced classes of package kaosz.view:
//            GUIControl

public class JartassagPanel extends JPanel
    implements ChangeListener, ActionListener
{

    public JartassagPanel(GUIControl guiControl)
    {
        this.guiControl = guiControl;
        Jartassagok jartassagXML = null;
        try
        {
            jartassagXML = new Jartassagok();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        jartassagok = jartassagXML.getJartassagok();
        Karakter.setOsszesJartassag(jartassagok);
        jartassag();
    }

    private void jartassag()
    {
        setLayout(new BorderLayout());
        add(maradekPont(), "North");
        add(jartassagLista(), "Center");
        add(new Lapozo(this), "South");
        elofeltetelCheck();
    }

    private JPanel maradekPont()
    {
        JPanel maradekPont = new JPanel();
        maradekJp = new JLabel((new StringBuilder("Marad\351k j\341rtass\341gpont: ")).append(Karakter.getJartassagPont()).toString());
        maradekPont.add(maradekJp);
        return maradekPont;
    }

    private String toolTipVago(String szoveg, int karakterSzam)
    {
        String toolTipSzoveg = szoveg;
        String ujSzoveg = "";
        StringTokenizer token = new StringTokenizer(toolTipSzoveg);
        int betukSzama = 0;
        while(token.hasMoreTokens()) 
        {
            String idg = token.nextToken();
            betukSzama += idg.length();
            ujSzoveg = ujSzoveg.concat(" ").concat(idg);
            if(betukSzama > karakterSzam)
            {
                betukSzama = 0;
                ujSzoveg = ujSzoveg.concat("<br>");
            }
        }
        ujSzoveg = "<html>".concat(ujSzoveg).concat("</html>");
        return ujSzoveg;
    }
    

    

    private JScrollPane jartassagLista()
    {
        JPanel panel = new JPanel();
        JScrollPane jartassagPanel = new JScrollPane(panel);
        panel.setLayout(new SpringLayout());
        jartassagSpinnerek = new HashMap();
        ArrayList<String> jartassagLista = new ArrayList(jartassagok.keySet());
        Collections.sort(jartassagLista);
        
        for(int k=0 ; k<jartassagLista.size() ; k++ )
        {
            JLabel label = new JLabel((String)jartassagLista.get(k));
            label.setToolTipText(toolTipVago(((Jartassag)jartassagok.get(jartassagLista.get(k))).getLeiras(), 50));
            panel.add(label);
            SpinnerNumberModel model = new SpinnerNumberModel(0, 0, Karakter.getJartassagSzintMax(), 1);
            JSpinner spinner = new JSpinner(model);
            spinner.setName((String)jartassagLista.get(k));
            Component mySpinnerEditor = spinner.getEditor();
            JFormattedTextField jftf = ((JSpinner.DefaultEditor) mySpinnerEditor).getTextField();
            jftf.setColumns(2);
            panel.add(spinner);
            spinner.addChangeListener(this);
            jartassagSpinnerek.put((String)jartassagLista.get(k), spinner);
            
            for(int i = 1; i <= 10; i++)
            {
                JLabel jpLabel = new JLabel(Integer.toString(((Jartassag) jartassagok.get(jartassagLista.get(k))).getAtszamoltJpIgeny()[i]));
                panel.add(jpLabel);
            }
        }
        
        SpringUtilities.makeCompactGrid(panel,
        		jartassagok.size(), 12, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad
        return jartassagPanel;
    }

    private void elofeltetelCheck()
    {
        java.util.Map.Entry entry;
        SpinnerNumberModel model;
        for(Iterator iterator = jartassagSpinnerek.entrySet().iterator(); iterator.hasNext(); ((JSpinner)entry.getValue()).setModel(model))
        {
            entry = (java.util.Map.Entry)iterator.next();
            Jartassag jartassag = (Jartassag)jartassagok.get(entry.getKey());
            ArrayList szuksegesJartassagok = jartassag.getSzuksegesJartassagok();
            int maxSzint = Karakter.getJartassagSzintMax();
            if(szuksegesJartassagok != null)
            {
                for(int i = 0; i < szuksegesJartassagok.size(); i++)
                {
                    int szuksegesSzintje = ((Integer)((JSpinner)jartassagSpinnerek.get(szuksegesJartassagok.get(i))).getValue()).intValue();
                    if(maxSzint > szuksegesSzintje)
                        maxSzint = szuksegesSzintje;
               }

            }
            
            ArrayList szuksegesJartassagokVagy = jartassag.getSzuksegesJartassagokVagy();
            if(szuksegesJartassagokVagy != null && szuksegesJartassagokVagy.size()!=0)
            {
            	int vagyMaxSzint = 0;
                for(int i = 0; i < szuksegesJartassagokVagy.size(); i++)
                {
                    int szuksegesSzintje = ((Integer)((JSpinner)jartassagSpinnerek.get(szuksegesJartassagokVagy.get(i))).getValue()).intValue();
                    if (vagyMaxSzint < szuksegesSzintje) 
                    	vagyMaxSzint = szuksegesSzintje;
                }
                if(maxSzint > vagyMaxSzint)
                    maxSzint = vagyMaxSzint;

            }
            
            if(((Integer)((JSpinner)entry.getValue()).getValue()).intValue() > maxSzint)
                ((JSpinner)entry.getValue()).setValue(Integer.valueOf(maxSzint));
            int spinErtek = ((Integer)((JSpinner)entry.getValue()).getValue()).intValue();
            model = new SpinnerNumberModel(spinErtek, 0, maxSzint, 1);
            if(maxSzint == 0)
                ((JSpinner)entry.getValue()).setEnabled(false);
            else
                ((JSpinner)entry.getValue()).setEnabled(true);
        }

    }

    private void jartassagFeltolt()
    {
        Map meglevoJartassagok = new HashMap();
        for(Iterator iterator = jartassagSpinnerek.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(((Integer)((JSpinner)entry.getValue()).getValue()).intValue() > 0)
                meglevoJartassagok.put((String)entry.getKey(), (Integer)((JSpinner)entry.getValue()).getValue());
        }

        Karakter.setJartassagok(meglevoJartassagok);
    }

    public void stateChanged(ChangeEvent e)
    {
        elofeltetelCheck();
        jartassagFeltolt();
        maradekJp.setText((new StringBuilder("Marad\351k j\341rtass\341gpont: ")).append(Karakter.getJartassagPont()).toString());
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("Tov\341bb"))
            guiControl.setJartassagPanel();
        if(event.getActionCommand().equals("Vissza"))
            guiControl.setFoErtekPanel();
    }

    private GUIControl guiControl;
    private Map jartassagok;
    private Map jartassagSpinnerek;
    private JLabel maradekJp;
}
