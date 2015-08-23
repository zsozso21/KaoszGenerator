// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:34:08
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FoErtekPanel.java

package kaosz.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kaosz.model.bean.*;
import kaosz.view.layout.SpringUtilities;

// Referenced classes of package kaosz.view:
//            Lapozo, GUIControl

public class FoErtekPanel extends JPanel
    implements ActionListener, ChangeListener
{

    public FoErtekPanel(GUIControl guiControl)
    {
        gui = guiControl;
        foErtekek();
        stateChanged(null);
    }

    public void foErtekek()
    {
        setLayout(new BorderLayout());
        add(center(), "Center");
        add(new Lapozo(this), "South");
        add(szamlalo(), "North");
    }

    private JPanel szamlalo()
    {
        JPanel szamlalo = new JPanel();
        szamlalo.setLayout(new BorderLayout());
        north = new JLabel();
        szamlalo.add(north, "West");
        return szamlalo;
    }

    private JPanel center()
    {
        JPanel center = new JPanel();
        center.add(centerFent());
        center.add(centerLent());
        return center;
    }

    private JPanel centerLent()
    {
        JPanel center = new JPanel();
        //GridLayout layout = new GridLayout(10, 4);
        center.setLayout(new SpringLayout());
        specialBox = new HashMap();
        specialSpinner = new HashMap();
        Faj faj = Karakter.getFaj();
        specialitasok = faj.getSpecialitasok();
        for(Iterator iterator = specialitasok.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Specialitas spec = (Specialitas)entry.getValue();
            center.add(new JLabel((new StringBuilder(String.valueOf(spec.getNev()))).append(" (").append(spec.getAr()).append(" pont)").toString()));
            if(spec.getMennyiseg().equals("1"))
            {
                JCheckBox specBox = new JCheckBox();
                center.add(specBox);
                specBox.addActionListener(this);
                specialBox.put((String)entry.getKey(), specBox);
            } else
            {
                SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 999, 1);
                JSpinner specSpinner = new JSpinner(model);
                center.add(specSpinner);
                specSpinner.addChangeListener(this);
                specialSpinner.put((String)entry.getKey(), specSpinner);
            }
        }
        
        int rows = specialitasok.entrySet().size() / 2;
        if (specialitasok.entrySet().size() > 0 && specialitasok.entrySet().size() % 2 == 1) {
        	++rows;
        	center.add(new JPanel());
        	center.add(new JPanel());
        }

        SpringUtilities.makeCompactGrid(center,
        		rows, 4, //rows, cols
                5, 5, //initialX, initialY
                5, 5);//xPad, yPad
        return center;
    }

    private JPanel centerFent()
    {
        JPanel center = new JPanel();
        center.setLayout(new SpringLayout());
        Faj faj = Karakter.getFaj();
        center.add(new JLabel("Fizikum"));
        

        
        SpinnerNumberModel model = new SpinnerNumberModel(faj.getFizikumMin(), faj.getFizikumMin(), faj.getFizikumMax(), 1);
        fizikum = new JSpinner(model);
        center.add(fizikum);
        fizikum.addChangeListener(this);
        center.add(new JLabel("Er\u0151"));
        ero = new JSpinner();
        ero.setValue(Integer.valueOf(faj.getFizikumMin()));
        center.add(ero);
        ero.addChangeListener(this);
        center.add(new JLabel("Sz\355v\363ss\341g"));
        szivossag = new JLabel();
        szivossag.setText(Integer.toString(faj.getFizikumMin()));
        center.add(szivossag);
        center.add(new JLabel("R\341termetts\351g"));
        model = new SpinnerNumberModel(faj.getRatermettsegMin(), faj.getRatermettsegMin(), faj.getRatermettsegMax(), 1);
        ratermettseg = new JSpinner(model);
        center.add(ratermettseg);
        ratermettseg.addChangeListener(this);
        center.add(new JLabel("\334gyess\351g"));
        ugyesseg = new JSpinner();
        ugyesseg.setValue(Integer.valueOf(faj.getRatermettsegMin()));
        center.add(ugyesseg);
        ugyesseg.addChangeListener(this);
        center.add(new JLabel("Reflex"));
        reflex = new JLabel();
        reflex.setText(Integer.toString(faj.getRatermettsegMin()));
        center.add(reflex);
        center.add(new JLabel("Tudat"));
        model = new SpinnerNumberModel(faj.getTudatMin(), faj.getTudatMin(), faj.getTudatMax(), 1);
        tudat = new JSpinner(model);
        center.add(tudat);
        tudat.addChangeListener(this);
        center.add(new JLabel("Intelligencia"));
        intelligencia = new JSpinner();
        intelligencia.setValue(Integer.valueOf(faj.getTudatMin()));
        center.add(intelligencia);
        intelligencia.addChangeListener(this);
        center.add(new JLabel("Lelkier\u0151"));
        lelkiero = new JLabel();
        lelkiero.setText(Integer.toString(faj.getTudatMin()));
        center.add(lelkiero);
        center.add(new JLabel("Esszencia"));
        model = new SpinnerNumberModel(faj.getEsszenciaMin(), faj.getEsszenciaMin(), faj.getEsszenciaMax(), 1);
        esszencia = new JSpinner(model);
        center.add(esszencia);
        esszencia.addChangeListener(this);
        center.add(new JLabel("Varazser\u0151"));
        varazsero = new JSpinner();
        varazsero.setValue(Integer.valueOf(faj.getEsszenciaMin()));
        center.add(varazsero);
        varazsero.addChangeListener(this);
        center.add(new JLabel("Esszenciapajzs"));
        esszenciapajzs = new JLabel();
        esszenciapajzs.setText(Integer.toString(faj.getEsszenciaMin()));
        center.add(esszenciapajzs);
        SpringUtilities.makeCompactGrid(center, 4, 6, 0, 0, 10, 10);
        return center;
    }

    private void getErtekek()
    {
        Karakter.setFizikum(((Integer)fizikum.getValue()).intValue());
        Karakter.setEro(((Integer)ero.getValue()).intValue());
        Karakter.setSzivossag(Karakter.getFizikum() * 2 - Karakter.getEro());
        Karakter.setRatermettseg(((Integer)ratermettseg.getValue()).intValue());
        Karakter.setUgyesseg(((Integer)ugyesseg.getValue()).intValue());
        Karakter.setReflex(Karakter.getRatermettseg() * 2 - Karakter.getUgyesseg());
        Karakter.setTudat(((Integer)tudat.getValue()).intValue());
        Karakter.setIntelligencia(((Integer)intelligencia.getValue()).intValue());
        Karakter.setLelkiero(Karakter.getTudat() * 2 - Karakter.getIntelligencia());
        Karakter.setEsszencia(((Integer)esszencia.getValue()).intValue());
        Karakter.setVarazsero(((Integer)varazsero.getValue()).intValue());
        Karakter.setEsszenciapajzs(Karakter.getEsszencia() * 2 - Karakter.getVarazsero());
    }

    private void setCenterFent()
    {
        north.setText((new StringBuilder("Megmaradt Jp:")).append(Karakter.getJartassagPont()).append(". Megmaradt F\u0151\351rt\351k pont: ").append(Karakter.getFoErtekPont()).toString());
    }

    private void setSpinners()
    {
        if(Karakter.getEro() < (Karakter.getFizikum() * 8) / 10)
            Karakter.setEro((Karakter.getFizikum() * 8) / 10);
        if(Karakter.getEro() > (Karakter.getFizikum() * 12) / 10)
            Karakter.setEro((Karakter.getFizikum() * 12) / 10);
        SpinnerNumberModel model = new SpinnerNumberModel(Karakter.getEro(), (Karakter.getFizikum() * 8) / 10, (Karakter.getFizikum() * 12) / 10, 1);
        ero.setModel(model);
        szivossag.setText(Integer.toString(Karakter.getFizikum() * 2 - Karakter.getEro()));
        if(Karakter.getUgyesseg() < (Karakter.getRatermettseg() * 8) / 10)
            Karakter.setUgyesseg((Karakter.getRatermettseg() * 8) / 10);
        if(Karakter.getUgyesseg() > (Karakter.getRatermettseg() * 12) / 10)
            Karakter.setUgyesseg((Karakter.getRatermettseg() * 12) / 10);
        model = new SpinnerNumberModel(Karakter.getUgyesseg(), (Karakter.getRatermettseg() * 8) / 10, (Karakter.getRatermettseg() * 12) / 10, 1);
        ugyesseg.setModel(model);
        reflex.setText(Integer.toString(Karakter.getRatermettseg() * 2 - Karakter.getUgyesseg()));
        if(Karakter.getIntelligencia() < (Karakter.getTudat() * 8) / 10)
            Karakter.setIntelligencia((Karakter.getTudat() * 8) / 10);
        if(Karakter.getIntelligencia() > (Karakter.getTudat() * 12) / 10)
            Karakter.setIntelligencia((Karakter.getTudat() * 12) / 10);
        model = new SpinnerNumberModel(Karakter.getIntelligencia(), (Karakter.getTudat() * 8) / 10, (Karakter.getTudat() * 12) / 10, 1);
        intelligencia.setModel(model);
        lelkiero.setText(Integer.toString(Karakter.getTudat() * 2 - Karakter.getIntelligencia()));
        if(Karakter.getVarazsero() < (Karakter.getEsszencia() * 8) / 10)
            Karakter.setVarazsero((Karakter.getEsszencia() * 8) / 10);
        if(Karakter.getVarazsero() > (Karakter.getEsszencia() * 12) / 10)
            Karakter.setVarazsero((Karakter.getEsszencia() * 12) / 10);
        model = new SpinnerNumberModel(Karakter.getVarazsero(), (Karakter.getEsszencia() * 8) / 10, (Karakter.getEsszencia() * 12) / 10, 1);
        varazsero.setModel(model);
        esszenciapajzs.setText(Integer.toString(Karakter.getEsszencia() * 2 - Karakter.getVarazsero()));
    }

    private void getBoxAndSpinner()
    {
        Map selectedBoxAndSpinner = new HashMap();
        for(Iterator iterator = specialBox.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(((JCheckBox)entry.getValue()).isSelected())
                selectedBoxAndSpinner.put(entry.getKey(), Integer.valueOf(1));
        }

        for(Iterator iterator1 = specialSpinner.entrySet().iterator(); iterator1.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
            if(((Integer)((JSpinner)entry.getValue()).getValue()).intValue() > 0)
                selectedBoxAndSpinner.put(entry.getKey(), (Integer)((JSpinner)entry.getValue()).getValue());
        }

        Karakter.setSpecialitasok(selectedBoxAndSpinner);
        eloFeltetelek();
    }

    private void eloFeltetelek()
    {
        Map speckek = Karakter.getFaj().getSpecialitasok();
        for(Iterator iterator = speckek.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(((Specialitas)entry.getValue()).getEloFeltetlek() != null)
            {
                ArrayList eloFeltetelek = ((Specialitas)entry.getValue()).getEloFeltetlek();
                boolean megVanMindenEloFeltetel = true;
                for(int i = 0; i < eloFeltetelek.size(); i++)
                {
                    if(specialBox.containsKey(eloFeltetelek.get(i)) && !((JCheckBox)specialBox.get(eloFeltetelek.get(i))).isSelected())
                        megVanMindenEloFeltetel = false;
                    if(specialSpinner.containsKey(eloFeltetelek.get(i)) && ((Integer)((JSpinner)specialSpinner.get(eloFeltetelek.get(i))).getValue()).intValue() <= 0)
                        megVanMindenEloFeltetel = false;
                }

                if(megVanMindenEloFeltetel)
                {
                    if(specialBox.containsKey(entry.getKey()))
                        ((JCheckBox)specialBox.get(entry.getKey())).setEnabled(true);
                    if(specialSpinner.containsKey(entry.getKey()))
                        ((JSpinner)specialSpinner.get(entry.getKey())).setEnabled(true);
                } else
                {
                    if(specialBox.containsKey(entry.getKey()))
                    {
                        ((JCheckBox)specialBox.get(entry.getKey())).setSelected(false);
                        ((JCheckBox)specialBox.get(entry.getKey())).setEnabled(false);
                        Map karSpecek = Karakter.getSpecialitasok();
                        karSpecek.remove(entry.getKey());
                        Karakter.setSpecialitasok(karSpecek);
                    }
                    if(specialSpinner.containsKey(entry.getKey()))
                    {
                        ((JSpinner)specialSpinner.get(entry.getKey())).setValue(Integer.valueOf(0));
                        ((JSpinner)specialSpinner.get(entry.getKey())).setEnabled(false);
                        Map karSpecek = Karakter.getSpecialitasok();
                        karSpecek.remove(entry.getKey());
                        Karakter.setSpecialitasok(karSpecek);
                    }
                }
            }
        }

    }

    public void actionPerformed(ActionEvent event)
    {
        getBoxAndSpinner();
        setCenterFent();
        if(event.getActionCommand().equals("Tov\341bb"))
            if(Karakter.getFoErtekPont() < 0)
                gui.addPopup("A f\u0151\351rt\351k pontok sz\341ma nem lehet negat\355v!");
            else
                gui.setElonyHatranyPanel();
        if(event.getActionCommand().equals("Vissza"))
            gui.setFajokPanel();
    }

    public void stateChanged(ChangeEvent event)
    {
        getErtekek();
        setSpinners();
        getBoxAndSpinner();
        setCenterFent();
    }

    private static final long serialVersionUID = 0xb5fb710339d1eac0L;
    private GUIControl gui;
    private JSpinner fizikum;
    private JSpinner ero;
    private JLabel szivossag;
    private JSpinner ratermettseg;
    private JSpinner ugyesseg;
    private JLabel reflex;
    private JSpinner tudat;
    private JSpinner intelligencia;
    private JLabel lelkiero;
    private JSpinner esszencia;
    private JSpinner varazsero;
    private JLabel esszenciapajzs;
    private JLabel north;
    private Map specialitasok;
    private Map specialBox;
    private Map specialSpinner;
}
