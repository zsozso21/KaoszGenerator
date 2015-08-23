// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:33:24
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Xerces.java

package kaosz.model.wrappers;

import java.io.InputStream;
import java.io.PrintStream;

import kaosz.model.ParserWrapper;

import org.apache.xerces.dom.TextImpl;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.xml.sax.*;

public class Xerces
    implements ParserWrapper, kaosz.model.ParserWrapper.DocumentInfo, ErrorHandler
{

    public Xerces()
    {
        parser = new DOMParser();
        parser.setErrorHandler(this);
    }

    public Document parse(String uri)
        throws Exception
    {
        parser.parse(uri);
        return parser.getDocument();
    }
    
    public Document parse(InputStream stream)
            throws Exception
    {
        parser.parse(new InputSource(stream));
        return parser.getDocument();
    }

    public void setFeature(String featureId, boolean state)
        throws SAXNotRecognizedException, SAXNotSupportedException
    {
        parser.setFeature(featureId, state);
    }

    public kaosz.model.ParserWrapper.DocumentInfo getDocumentInfo()
    {
        return this;
    }

    public boolean isIgnorableWhitespace(Text text)
    {
        return ((TextImpl)text).isIgnorableWhitespace();
    }

    public void warning(SAXParseException ex)
        throws SAXException
    {
        printError("Warning", ex);
    }

    public void error(SAXParseException ex)
        throws SAXException
    {
        printError("Error", ex);
    }

    public void fatalError(SAXParseException ex)
        throws SAXException
    {
        printError("Fatal Error", ex);
        throw ex;
    }

    protected void printError(String type, SAXParseException ex)
    {
        System.err.print("[");
        System.err.print(type);
        System.err.print("] ");
        String systemId = ex.getSystemId();
        if(systemId != null)
        {
            int index = systemId.lastIndexOf('/');
            if(index != -1)
                systemId = systemId.substring(index + 1);
            System.err.print(systemId);
        }
        System.err.print(':');
        System.err.print(ex.getLineNumber());
        System.err.print(':');
        System.err.print(ex.getColumnNumber());
        System.err.print(": ");
        System.err.print(ex.getMessage());
        System.err.println();
        System.err.flush();
    }

    protected DOMParser parser;
}
