// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:32:31
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   XMLConnect.java

package kaosz.model;

import java.io.InputStream;

import kaosz.model.wrappers.Xerces;

import org.w3c.dom.Document;

// Referenced classes of package kaosz.model:
//            ParserWrapper

public class XMLConnect {
	protected static final String DEFAULT_PARSER_NAME = "kaosz.model.wrappers.Xerces";
	private ParserWrapper parser;
	private Document document;

	public XMLConnect(String fileName, boolean stream) throws Exception {
		parser = null;
		document = null;
		parser = (ParserWrapper) Class.forName("kaosz.model.wrappers.Xerces")
				.newInstance();
		
		try {
			if (stream) {
		    	InputStream ios = Xerces.class.getResourceAsStream("/"+fileName);
		    	if (ios == null) {
					document = parser.parse(fileName);	
		    	} else {
					document = ((Xerces)parser).parse(ios);
		    	}
			} else {
				document = parser.parse(fileName);	
			}
		} catch (Exception e) {
			System.out.println("Nem található az alábbi fájl: " + fileName);
			System.exit(1);
		}
		
	}

	public XMLConnect(String fileName) throws Exception {
		this(fileName, true);
	}

	public Document getDocument() {
		return document;
	}
}
