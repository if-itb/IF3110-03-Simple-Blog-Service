/**
cx * Simpleblog_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package simpleblog.service.endpoint;

public interface Simpleblog_Service extends javax.xml.rpc.Service {
    public java.lang.String getSimpleblogPortAddress();

    public simpleblog.service.endpoint.Simpleblog_PortType getSimpleblogPort() throws javax.xml.rpc.ServiceException;

    public simpleblog.service.endpoint.Simpleblog_PortType getSimpleblogPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
