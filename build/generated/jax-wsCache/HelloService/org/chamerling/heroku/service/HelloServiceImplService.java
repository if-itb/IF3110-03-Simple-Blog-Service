
package org.chamerling.heroku.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloServiceImplService", targetNamespace = "http://service.heroku.chamerling.org/", wsdlLocation = "http://desolate-stream-8948.herokuapp.com/HelloService?wsdl")
public class HelloServiceImplService
    extends Service
{

    private final static URL HELLOSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException HELLOSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName HELLOSERVICEIMPLSERVICE_QNAME = new QName("http://service.heroku.chamerling.org/", "HelloServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://desolate-stream-8948.herokuapp.com/HelloService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        HELLOSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public HelloServiceImplService() {
        super(__getWsdlLocation(), HELLOSERVICEIMPLSERVICE_QNAME);
    }

    public HelloServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOSERVICEIMPLSERVICE_QNAME, features);
    }

    public HelloServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, HELLOSERVICEIMPLSERVICE_QNAME);
    }

    public HelloServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOSERVICEIMPLSERVICE_QNAME, features);
    }

    public HelloServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloService
     */
    @WebEndpoint(name = "HelloServiceImplPort")
    public HelloService getHelloServiceImplPort() {
        return super.getPort(new QName("http://service.heroku.chamerling.org/", "HelloServiceImplPort"), HelloService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloService
     */
    @WebEndpoint(name = "HelloServiceImplPort")
    public HelloService getHelloServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.heroku.chamerling.org/", "HelloServiceImplPort"), HelloService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw HELLOSERVICEIMPLSERVICE_EXCEPTION;
        }
        return HELLOSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
