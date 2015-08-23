// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:31:50
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Jartassagok.java

package kaosz.model;

import java.io.File;
import java.util.*;

import kaosz.model.bean.Jartassag;

import org.w3c.dom.*;

// Referenced classes of package kaosz.model:
//            XMLConnect

public class Jartassagok extends XMLConnect
{

    public Jartassagok()
        throws Exception
    {
        super(fileName);
        document = null;
        document = super.getDocument();
    }

    public Map getJartassagok()
    {
        Map<String,Jartassag> jartassagok = new HashMap<String,Jartassag>();
        NodeList elements = document.getElementsByTagName("j\341rtass\341g");
        int elementCount = elements.getLength();
        for(int i = 0; i < elementCount; i++)
        {
            Jartassag jartassag = new Jartassag();
            Element element = (Element)elements.item(i);
            jartassag.setNev(element.getElementsByTagName("n\351v").item(0).getTextContent());
            jartassag.setLeiras(element.getElementsByTagName("le\355r\341s").item(0).getTextContent());
            jartassag.setSzuksegesFoErtekNev(((Element)element.getElementsByTagName("sz\374ks\351gesF\u0151\351rt\351k").item(0)).getElementsByTagName("f\u0151\351rt\351kN\351v").item(0).getTextContent());
            int szuksegesFoertekek[] = new int[11];
            Element szuksegesElement = (Element)element.getElementsByTagName("sz\374ks\351gesF\u0151\351rt\351k").item(0);
            szuksegesFoertekek[1] = szuksegesFoertekek[2] = szuksegesFoertekek[3] = Integer.parseInt(szuksegesElement.getElementsByTagName("szint1_3").item(0).getTextContent());
            szuksegesFoertekek[4] = szuksegesFoertekek[5] = szuksegesFoertekek[6] = Integer.parseInt(szuksegesElement.getElementsByTagName("szint4_6").item(0).getTextContent());
            szuksegesFoertekek[7] = szuksegesFoertekek[8] = szuksegesFoertekek[9] = Integer.parseInt(szuksegesElement.getElementsByTagName("szint7_9").item(0).getTextContent());
            szuksegesFoertekek[10] = Integer.parseInt(szuksegesElement.getElementsByTagName("szint10").item(0).getTextContent());
            jartassag.setSzuksegesFoErtekSzint(szuksegesFoertekek);
            int jpIgeny[] = new int[11];
            Element jpIgenyElement = (Element)element.getElementsByTagName("jpIg\351ny").item(0);
            for(int j = 1; j <= 10; j++)
                jpIgeny[j] = Integer.parseInt(jpIgenyElement.getElementsByTagName((new StringBuilder("szint_")).append(j).toString()).item(0).getTextContent());

            jartassag.setJpIgeny(jpIgeny);
            
            // sz�ks�ges j�rtass�gok
            NodeList szuksegesJartassagok = element.getElementsByTagName("sz\374ks\351gesJ\341rtass\341g");
            ArrayList szuksegesJartassagLista = new ArrayList();
            for(int j = 0; j < szuksegesJartassagok.getLength(); j++)
            {
                Element szuksegesJartassag = (Element)szuksegesJartassagok.item(j);
                szuksegesJartassagLista.add(szuksegesJartassag.getTextContent());
            }

            jartassag.setSzuksegesJartassagok(szuksegesJartassagLista);
            
            // vagyolt sz�ks�ges j�rtass�gok
            NodeList szuksegesJartassagokVagy = element.getElementsByTagName("sz\374ks\351gesJ\341rtass\341g_Vagy");
            ArrayList szuksegesJartassagVagyLista = new ArrayList();
            for(int j = 0; j < szuksegesJartassagokVagy.getLength(); j++)
            {
                Element szuksegesJartassagVagy = (Element)szuksegesJartassagokVagy.item(j);
                szuksegesJartassagVagyLista.add(szuksegesJartassagVagy.getTextContent());
            }
            jartassag.setSzuksegesJartassagokVagy(szuksegesJartassagVagyLista);
            
            jartassagok.put(jartassag.getNev(), jartassag);
        }

        return jartassagok;
    }

    protected static final String fileName = "data" + File.separator + "xml" + File.separator + "jartassagok.xml";
    private Document document;
}
