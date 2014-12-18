
package org.wbd.heroku.service;

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
@WebServiceClient(name = "FirebaseServiceImplService", targetNamespace = "http://service.heroku.wbd.org/", wsdlLocation = "http://firebase-simple-blog.herokuapp.com/FirebaseService?wsdl")
public class FirebaseServiceImplService
    extends Service
{

    private final static URL FIREBASESERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException FIREBASESERVICEIMPLSERVICE_EXCEPTION;
    private final static QName FIREBASESERVICEIMPLSERVICE_QNAME = new QName("http://service.heroku.wbd.org/", "FirebaseServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://firebase-simple-blog.herokuapp.com/FirebaseService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FIREBASESERVICEIMPLSERVICE_WSDL_LOCATION = url;
        FIREBASESERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public FirebaseServiceImplService() {
        super(__getWsdlLocation(), FIREBASESERVICEIMPLSERVICE_QNAME);
    }

    public FirebaseServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FIREBASESERVICEIMPLSERVICE_QNAME, features);
    }

    public FirebaseServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, FIREBASESERVICEIMPLSERVICE_QNAME);
    }

    public FirebaseServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FIREBASESERVICEIMPLSERVICE_QNAME, features);
    }

    public FirebaseServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FirebaseServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FirebaseService
     */
    @WebEndpoint(name = "FirebaseServiceImplPort")
    public FirebaseService getFirebaseServiceImplPort() {
        return super.getPort(new QName("http://service.heroku.wbd.org/", "FirebaseServiceImplPort"), FirebaseService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FirebaseService
     */
    @WebEndpoint(name = "FirebaseServiceImplPort")
    public FirebaseService getFirebaseServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.heroku.wbd.org/", "FirebaseServiceImplPort"), FirebaseService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FIREBASESERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw FIREBASESERVICEIMPLSERVICE_EXCEPTION;
        }
        return FIREBASESERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
