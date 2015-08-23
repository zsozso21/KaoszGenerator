// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:33:12
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Specialitas.java

package kaosz.model.bean;

import java.util.ArrayList;

public class Specialitas
{

    public Specialitas()
    {
    }

    public String getNev()
    {
        return nev;
    }

    public void setNev(String nev)
    {
        this.nev = nev;
    }

    public int getAr()
    {
        return ar;
    }

    public void setAr(int ar)
    {
        this.ar = ar;
    }

    public String getMennyiseg()
    {
        return mennyiseg;
    }

    public void setMennyiseg(String mennyiseg)
    {
        this.mennyiseg = mennyiseg;
    }

    public ArrayList getEloFeltetlek()
    {
        return eloFeltetlek;
    }

    public void setEloFeltetlek(ArrayList eloFeltetlek)
    {
        this.eloFeltetlek = eloFeltetlek;
    }

    private String nev;
    private int ar;
    private String mennyiseg;
    private ArrayList eloFeltetlek;
}
