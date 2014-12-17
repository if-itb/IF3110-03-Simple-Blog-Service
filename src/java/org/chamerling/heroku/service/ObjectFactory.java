
package org.chamerling.heroku.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.chamerling.heroku.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHi_QNAME = new QName("http://service.heroku.chamerling.org/", "sayHi");
    private final static QName _SayHiResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "sayHiResponse");
    private final static QName _KaliResponse_QNAME = new QName("http://service.heroku.chamerling.org/", "kaliResponse");
    private final static QName _Kali_QNAME = new QName("http://service.heroku.chamerling.org/", "kali");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.chamerling.heroku.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Kali }
     * 
     */
    public Kali createKali() {
        return new Kali();
    }

    /**
     * Create an instance of {@link KaliResponse }
     * 
     */
    public KaliResponse createKaliResponse() {
        return new KaliResponse();
    }

    /**
     * Create an instance of {@link SayHiResponse }
     * 
     */
    public SayHiResponse createSayHiResponse() {
        return new SayHiResponse();
    }

    /**
     * Create an instance of {@link SayHi }
     * 
     */
    public SayHi createSayHi() {
        return new SayHi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "sayHi")
    public JAXBElement<SayHi> createSayHi(SayHi value) {
        return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "sayHiResponse")
    public JAXBElement<SayHiResponse> createSayHiResponse(SayHiResponse value) {
        return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME, SayHiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KaliResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "kaliResponse")
    public JAXBElement<KaliResponse> createKaliResponse(KaliResponse value) {
        return new JAXBElement<KaliResponse>(_KaliResponse_QNAME, KaliResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Kali }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.heroku.chamerling.org/", name = "kali")
    public JAXBElement<Kali> createKali(Kali value) {
        return new JAXBElement<Kali>(_Kali_QNAME, Kali.class, null, value);
    }

}
