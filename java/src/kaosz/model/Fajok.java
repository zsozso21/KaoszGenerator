// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:31:14
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Fajok.java

package kaosz.model;

import java.io.File;
import java.util.*;

import kaosz.model.bean.Faj;
import kaosz.model.bean.Specialitas;

import org.w3c.dom.*;

// Referenced classes of package kaosz.model:
//            XMLConnect

public class Fajok extends XMLConnect
{

    public Fajok()
        throws Exception
    {
        super(fileName);
        document = null;
        document = super.getDocument();
    }

    public Map getFajok()
    {
        Map fajok = new HashMap();
        NodeList elements = document.getElementsByTagName("faj");
        int elementCount = elements.getLength();
        for(int i = 0; i < elementCount; i++)
        {
            Faj faj = new Faj();
            Element element = (Element)elements.item(i);
            faj.setNev(element.getElementsByTagName("név").item(0).getTextContent());
            Element foErtek = (Element)element.getElementsByTagName("főérték").item(0);
            faj.setFizikumMin(Integer.parseInt(((Element)foErtek.getElementsByTagName("fizikum").item(0)).getElementsByTagName("min").item(0).getTextContent()));
            faj.setFizikumMax(Integer.parseInt(((Element)foErtek.getElementsByTagName("fizikum").item(0)).getElementsByTagName("max").item(0).getTextContent()));
            faj.setRatermettsegMin(Integer.parseInt(((Element)foErtek.getElementsByTagName("rátermettség").item(0)).getElementsByTagName("min").item(0).getTextContent()));
            faj.setRatermettsegMax(Integer.parseInt(((Element)foErtek.getElementsByTagName("rátermettség").item(0)).getElementsByTagName("max").item(0).getTextContent()));
            faj.setTudatMin(Integer.parseInt(((Element)foErtek.getElementsByTagName("tudat").item(0)).getElementsByTagName("min").item(0).getTextContent()));
            faj.setTudatMax(Integer.parseInt(((Element)foErtek.getElementsByTagName("tudat").item(0)).getElementsByTagName("max").item(0).getTextContent()));
            faj.setEsszenciaMin(Integer.parseInt(((Element)foErtek.getElementsByTagName("esszencia").item(0)).getElementsByTagName("min").item(0).getTextContent()));
            faj.setEsszenciaMax(Integer.parseInt(((Element)foErtek.getElementsByTagName("esszencia").item(0)).getElementsByTagName("max").item(0).getTextContent()));
            faj.setGyorsasagMin(Integer.parseInt(((Element)element.getElementsByTagName("gyorsaság").item(0)).getElementsByTagName("min").item(0).getTextContent()));
            faj.setGyorsasagAtlag(Integer.parseInt(((Element)element.getElementsByTagName("gyorsaság").item(0)).getElementsByTagName("átlag").item(0).getTextContent()));
            faj.setGyorsasagMax(Integer.parseInt(((Element)element.getElementsByTagName("gyorsaság").item(0)).getElementsByTagName("max").item(0).getTextContent()));
            Map specialitasokMap = new HashMap();
            if(element.getElementsByTagName("specialitasok").getLength() != 0)
            {
                Element specialitasok = (Element)element.getElementsByTagName("specialitasok").item(0);
                NodeList specialElements = specialitasok.getElementsByTagName("special");
                int specialElementCount = specialElements.getLength();
                for(int j = 0; j < specialElementCount; j++)
                {
                    Specialitas specObject = new Specialitas();
                    Element special = (Element)specialElements.item(j);
                    specObject.setNev(special.getElementsByTagName("név").item(0).getTextContent());
                    specObject.setAr(Integer.parseInt(special.getElementsByTagName("ár").item(0).getTextContent()));
                    specObject.setMennyiseg(special.getElementsByTagName("mennyiség").item(0).getTextContent());
                    ArrayList eloFeltetelLista = new ArrayList();
                    NodeList eloFeltetelek = special.getElementsByTagName("előfeltétel");
                    int eloFeltetelCount = eloFeltetelek.getLength();
                    for(int k = 0; k < eloFeltetelCount; k++)
                        eloFeltetelLista.add(eloFeltetelek.item(k).getTextContent());

                    specObject.setEloFeltetlek(eloFeltetelLista);
                    specialitasokMap.put(specObject.getNev(), specObject);
                }

            }
            faj.setSpecialitasok(specialitasokMap);
            faj.setMaxJartassagSzint(Integer.parseInt(element.getElementsByTagName("maximálisJártasságszint").item(0).getTextContent()));
            fajok.put(faj.getNev(), faj);
        }

        return fajok;
    }

    protected static final String fileName = "data" + File.separator + "xml" + File.separator + "fajok.xml";
    private Document document;
}
