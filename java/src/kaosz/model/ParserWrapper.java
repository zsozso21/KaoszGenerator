package kaosz.model;

import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public abstract interface ParserWrapper
{
  public abstract Document parse(String paramString)
    throws Exception;

  public abstract void setFeature(String paramString, boolean paramBoolean)
    throws SAXNotRecognizedException, SAXNotSupportedException;

  public abstract DocumentInfo getDocumentInfo();

  public static abstract interface DocumentInfo
  {
    public abstract boolean isIgnorableWhitespace(Text paramText);
  }
}

/* Location:           D:\szerepjáték\kaosz\kaosz karakter generator\
 * Qualified Name:     kaosz.model.ParserWrapper
 * JD-Core Version:    0.5.4
 */