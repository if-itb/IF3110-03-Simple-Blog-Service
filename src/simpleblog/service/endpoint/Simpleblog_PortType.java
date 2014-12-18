/**
 * Simpleblog_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package simpleblog.service.endpoint;

public interface Simpleblog_PortType extends java.rmi.Remote {
    public boolean publishPost(java.lang.String arg0) throws java.rmi.RemoteException;
    public simpleblog.service.endpoint.Post getPost(java.lang.String arg0) throws java.rmi.RemoteException;
    public simpleblog.service.endpoint.Post[] search(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean editPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public simpleblog.service.endpoint.Comment[] listComment(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public simpleblog.service.endpoint.User[] listUser() throws java.rmi.RemoteException;
    public boolean deleteUser(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public boolean deleteComment(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean deletePost(java.lang.String arg0) throws java.rmi.RemoteException;
    public simpleblog.service.endpoint.Post[] listPost() throws java.rmi.RemoteException;
    public boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public boolean editUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
}
