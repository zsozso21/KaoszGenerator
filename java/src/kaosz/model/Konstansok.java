// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:32:04
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Konstansok.java

package kaosz.model;

import java.io.File;

import kaosz.model.bean.Konstans;

import org.w3c.dom.*;

// Referenced classes of package kaosz.model:
//            XMLConnect

public class Konstansok extends XMLConnect
{

    public Konstansok()
        throws Exception
    {
        super(fileName);
        document = null;
        document = super.getDocument();
    }

    public void setKonstansok()
    {
        Element foErtek = (Element)document.getElementsByTagName("f\u0151\351rt\351kpontok").item(0);
        Konstans.setFoErtekPontok(Integer.parseInt(foErtek.getAttribute("\351rt\351k")));
        Element jartassag = (Element)document.getElementsByTagName("j\341rtass\341gpontok").item(0);
        Konstans.setJartassagPontok(Integer.parseInt(jartassag.getAttribute("\351rt\351k")));
    }

    protected static final String fileName = "data" + File.separator + "xml" + File.separator + "konstansok.xml";
    private Document document;
}
