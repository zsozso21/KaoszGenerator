// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:32:40
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Faj.java

package kaosz.model.bean;

import java.util.Map;

public class Faj
{

    public String getNev()
    {
        return nev;
    }

    public void setNev(String nev)
    {
        this.nev = nev;
    }

    public int getFizikumMin()
    {
        return fizikumMin;
    }

    public void setFizikumMin(int fizikumMin)
    {
        this.fizikumMin = fizikumMin;
    }

    public int getFizikumMax()
    {
        return fizikumMax;
    }

    public void setFizikumMax(int fizikumMax)
    {
        this.fizikumMax = fizikumMax;
    }

    public int getRatermettsegMin()
    {
        return ratermettsegMin;
    }

    public void setRatermettsegMin(int ratermettsegMin)
    {
        this.ratermettsegMin = ratermettsegMin;
    }

    public int getRatermettsegMax()
    {
        return ratermettsegMax;
    }

    public void setRatermettsegMax(int ratermettsegMax)
    {
        this.ratermettsegMax = ratermettsegMax;
    }

    public int getTudatMin()
    {
        return tudatMin;
    }

    public void setTudatMin(int tudatMin)
    {
        this.tudatMin = tudatMin;
    }

    public int getTudatMax()
    {
        return tudatMax;
    }

    public void setTudatMax(int tudatMax)
    {
        this.tudatMax = tudatMax;
    }

    public int getEsszenciaMin()
    {
        return esszenciaMin;
    }

    public void setEsszenciaMin(int esszenciaMin)
    {
        this.esszenciaMin = esszenciaMin;
    }

    public int getEsszenciaMax()
    {
        return esszenciaMax;
    }

    public void setEsszenciaMax(int esszenciaMax)
    {
        this.esszenciaMax = esszenciaMax;
    }

    public int getGyorsasagMin()
    {
        return gyorsasagMin;
    }

    public void setGyorsasagMin(int gyorsasagMin)
    {
        this.gyorsasagMin = gyorsasagMin;
    }

    public int getGyorsasagAtlag()
    {
        return gyorsasagAtlag;
    }

    public void setGyorsasagAtlag(int gyorsasagAtlag)
    {
        this.gyorsasagAtlag = gyorsasagAtlag;
    }

    public int getGyorsasagMax()
    {
        return gyorsasagMax;
    }

    public void setGyorsasagMax(int gyorsasagMax)
    {
        this.gyorsasagMax = gyorsasagMax;
    }

    public Map getSpecialitasok()
    {
        return specialitasok;
    }

    public void setSpecialitasok(Map specialitasok)
    {
        this.specialitasok = specialitasok;
    }

    public int getMaxJartassagSzint()
    {
        return maxJartassagSzint;
    }

    public void setMaxJartassagSzint(int maxJartassagSzint)
    {
        this.maxJartassagSzint = maxJartassagSzint;
    }

    private String nev;
    private int fizikumMin;
    private int fizikumMax;
    private int ratermettsegMin;
    private int ratermettsegMax;
    private int tudatMin;
    private int tudatMax;
    private int esszenciaMin;
    private int esszenciaMax;
    private int gyorsasagMin;
    private int gyorsasagAtlag;
    private int gyorsasagMax;
    private Map specialitasok;
    private int maxJartassagSzint;
}
