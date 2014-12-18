/**
 * Simpleblog_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package simpleblog.service.endpoint;

public class Simpleblog_ServiceLocator extends org.apache.axis.client.Service implements simpleblog.service.endpoint.Simpleblog_Service {

    public Simpleblog_ServiceLocator() {
    }


    public Simpleblog_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Simpleblog_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SimpleblogPort
    private java.lang.String SimpleblogPort_address = "http://ramaedmundalvin.herokuapp.com/Simpleblog";

    public java.lang.String getSimpleblogPortAddress() {
        return SimpleblogPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SimpleblogPortWSDDServiceName = "SimpleblogPort";

    public java.lang.String getSimpleblogPortWSDDServiceName() {
        return SimpleblogPortWSDDServiceName;
    }

    public void setSimpleblogPortWSDDServiceName(java.lang.String name) {
        SimpleblogPortWSDDServiceName = name;
    }

    public simpleblog.service.endpoint.Simpleblog_PortType getSimpleblogPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SimpleblogPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSimpleblogPort(endpoint);
    }

    public simpleblog.service.endpoint.Simpleblog_PortType getSimpleblogPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            simpleblog.service.endpoint.SimpleblogSoapBindingStub _stub = new simpleblog.service.endpoint.SimpleblogSoapBindingStub(portAddress, this);
            _stub.setPortName(getSimpleblogPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSimpleblogPortEndpointAddress(java.lang.String address) {
        SimpleblogPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (simpleblog.service.endpoint.Simpleblog_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                simpleblog.service.endpoint.SimpleblogSoapBindingStub _stub = new simpleblog.service.endpoint.SimpleblogSoapBindingStub(new java.net.URL(SimpleblogPort_address), this);
                _stub.setPortName(getSimpleblogPortWSDDServiceName());
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
        if ("SimpleblogPort".equals(inputPortName)) {
            return getSimpleblogPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://endpoint.service.simpleblog/", "Simpleblog");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://endpoint.service.simpleblog/", "SimpleblogPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SimpleblogPort".equals(portName)) {
            setSimpleblogPortEndpointAddress(address);
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
