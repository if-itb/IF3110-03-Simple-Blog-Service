/**
 * FirebaseServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.wbd.heroku.service;

public class FirebaseServiceImplServiceLocator extends org.apache.axis.client.Service implements org.wbd.heroku.service.FirebaseServiceImplService {

    public FirebaseServiceImplServiceLocator() {
    }


    public FirebaseServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FirebaseServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FirebaseServiceImplPort
    private java.lang.String FirebaseServiceImplPort_address = "http://agile-dusk-6040.herokuapp.com/FirebaseService";

    public java.lang.String getFirebaseServiceImplPortAddress() {
        return FirebaseServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FirebaseServiceImplPortWSDDServiceName = "FirebaseServiceImplPort";

    public java.lang.String getFirebaseServiceImplPortWSDDServiceName() {
        return FirebaseServiceImplPortWSDDServiceName;
    }

    public void setFirebaseServiceImplPortWSDDServiceName(java.lang.String name) {
        FirebaseServiceImplPortWSDDServiceName = name;
    }

    public org.wbd.heroku.service.FirebaseService getFirebaseServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FirebaseServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFirebaseServiceImplPort(endpoint);
    }

    public org.wbd.heroku.service.FirebaseService getFirebaseServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.wbd.heroku.service.FirebaseServiceImplServiceSoapBindingStub _stub = new org.wbd.heroku.service.FirebaseServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getFirebaseServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFirebaseServiceImplPortEndpointAddress(java.lang.String address) {
        FirebaseServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.wbd.heroku.service.FirebaseService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.wbd.heroku.service.FirebaseServiceImplServiceSoapBindingStub _stub = new org.wbd.heroku.service.FirebaseServiceImplServiceSoapBindingStub(new java.net.URL(FirebaseServiceImplPort_address), this);
                _stub.setPortName(getFirebaseServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FirebaseServiceImplPort".equals(inputPortName)) {
            return getFirebaseServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.heroku.wbd.org/", "FirebaseServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.heroku.wbd.org/", "FirebaseServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FirebaseServiceImplPort".equals(portName)) {
            setFirebaseServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
