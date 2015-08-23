// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:33:00
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Karakter.java

package kaosz.model.bean;

import java.util.*;

// Referenced classes of package kaosz.model.bean:
//            Faj, Specialitas, Jartassag

public class Karakter
{

    public static Faj getFaj()
    {
        return faj;
    }

    public static void setFaj(Faj faj)
    {
        Karakter.faj = faj;
    }

    public static int getFizikum()
    {
        return fizikum;
    }

    public static void setFizikum(int fizikum)
    {
    	Karakter.fizikum = fizikum;
    }

    public static int getEro()
    {
        return ero;
    }

    public static void setEro(int ero)
    {
    	Karakter.ero = ero;
    }

    public static int getSzivossag()
    {
        return szivossag;
    }

    public static void setSzivossag(int szivossag)
    {
    	Karakter.szivossag = szivossag;
    }

    public static int getRatermettseg()
    {
        return ratermettseg;
    }

    public static void setRatermettseg(int ratermettseg)
    {
    	Karakter.ratermettseg = ratermettseg;
    }

    public static int getUgyesseg()
    {
        return ugyesseg;
    }

    public static void setUgyesseg(int ugyesseg)
    {
    	Karakter.ugyesseg = ugyesseg;
    }

    public static int getReflex()
    {
        return reflex;
    }

    public static void setReflex(int reflex)
    {
    	Karakter.reflex = reflex;
    }

    public static int getTudat()
    {
        return tudat;
    }

    public static void setTudat(int tudat)
    {
    	Karakter.tudat = tudat;
    }

    public static int getIntelligencia()
    {
        return intelligencia;
    }

    public static void setIntelligencia(int intelligencia)
    {
    	Karakter.intelligencia = intelligencia;
    }

    public static int getLelkiero()
    {
        return lelkiero;
    }

    public static void setLelkiero(int lelkiero)
    {
    	Karakter.lelkiero = lelkiero;
    }

    public static int getEsszencia()
    {
        return esszencia;
    }

    public static void setEsszencia(int esszencia)
    {
    	Karakter.esszencia = esszencia;
    }

    public static int getVarazsero()
    {
        return varazsero;
    }

    public static void setVarazsero(int varazsero)
    {
    	Karakter.varazsero = varazsero;
    }

    public static int getEsszenciapajzs()
    {
        return esszenciapajzs;
    }

    public static void setEsszenciapajzs(int esszenciapajzs)
    {
    	Karakter.esszenciapajzs = esszenciapajzs;
    }

    public static int getGyorsasag()
    {
        return gyorsasag;
    }

    public static void setGyorsasag(int gyorsasag)
    {
    	Karakter.gyorsasag = gyorsasag;
    }

    public static Map getSpecialitasok()
    {
        return specialitasok;
    }

    public static void setSpecialitasok(Map specialitasok)
    {
    	Karakter.specialitasok = specialitasok;
    }

    public static int getAlapJartassagPont()
    {
        return alapJartassagPont;
    }

    public static void setAlapJartassagPont(int alapJartassagPont)
    {
    	Karakter.alapJartassagPont = alapJartassagPont;
    }

    public static int getAlapFoErtekPont()
    {
        return alapFoErtekPont;
    }

    public static void setAlapFoErtekPont(int alapFoErtekPont)
    {
    	Karakter.alapFoErtekPont = alapFoErtekPont;
    }

    public static int getJartassagSzintMax()
    {
        return jartassagSzintMax;
    }

    public static void setJartassagSzintMax(int jartassagSzintMax)
    {
    	Karakter.jartassagSzintMax = jartassagSzintMax;
    }

    public static Map getFoErtekek()
    {
        Map foErtekek = new HashMap();
        foErtekek.put("Fizikum", Integer.valueOf(getFizikum()));
        foErtekek.put("Er\u0151", Integer.valueOf(getEro()));
        foErtekek.put("Sz\355v\363ss\341g", Integer.valueOf(getSzivossag()));
        foErtekek.put("R\341termetts\351g", Integer.valueOf(getRatermettseg()));
        foErtekek.put("\334gyess\351g", Integer.valueOf(getUgyesseg()));
        foErtekek.put("Reflex", Integer.valueOf(getReflex()));
        foErtekek.put("Tudat", Integer.valueOf(getTudat()));
        foErtekek.put("Intelligencia", Integer.valueOf(getIntelligencia()));
        foErtekek.put("Lelkier\u0151", Integer.valueOf(getLelkiero()));
        foErtekek.put("Esszencia", Integer.valueOf(getEsszencia()));
        foErtekek.put("Varázser\u0151", Integer.valueOf(getVarazsero()));
        foErtekek.put("Esszencia", Integer.valueOf(getEsszenciapajzs()));
        return foErtekek;
    }

    public static Map getJartassagok()
    {
        return jartassagok;
    }

    public static void setJartassagok(Map jartassagok)
    {
    	Karakter.jartassagok = jartassagok;
    }

    public static Map getOsszesJartassag()
    {
        return osszesJartassag;
    }

    public static void setOsszesJartassag(Map osszesJartassag)
    {
    	Karakter.osszesJartassag = osszesJartassag;
    }

    public static int getFoErtekPont()
    {
        int foErtekPont = getAlapFoErtekPont();
        Map osszesSpec = faj.getSpecialitasok();
        foErtekPont = getAlapFoErtekPont() - getFizikum() - getRatermettseg() - getTudat() - getEsszencia();
        Map selectedSpec = getSpecialitasok();
        for(Iterator iterator = selectedSpec.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            foErtekPont -= ((Specialitas)osszesSpec.get(entry.getKey())).getAr() * ((Integer)entry.getValue()).intValue();
        }

        return foErtekPont;
    }

    public static int getJartassagPont()
    {
        int jartassagPont = getFoErtekPont() * 150 + getAlapJartassagPont();
        if(osszesJartassag != null && jartassagok != null)
        {
            for(Iterator iterator = jartassagok.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Jartassag jartassag = (Jartassag)osszesJartassag.get(entry.getKey());
                for(int i = 1; i <= ((Integer)entry.getValue()).intValue(); i++)
                    jartassagPont -= jartassag.getAtszamoltJpIgeny()[i];

            }

        }
        return jartassagPont;
    }

    private static int fizikum;
    private static int ero;
    private static int szivossag;
    private static int ratermettseg;
    private static int ugyesseg;
    private static int reflex;
    private static int tudat;
    private static int intelligencia;
    private static int lelkiero;
    private static int esszencia;
    private static int varazsero;
    private static int esszenciapajzs;
    private static int gyorsasag;
    private static int alapJartassagPont;
    private static int alapFoErtekPont;
    private static int jartassagSzintMax;
    private static Map specialitasok;
    private static Map jartassagok;
    private static Faj faj;
    private static Map osszesJartassag;
}
