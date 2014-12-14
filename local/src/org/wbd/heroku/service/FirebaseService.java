/**
 * FirebaseService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.wbd.heroku.service;

public interface FirebaseService extends java.rmi.Remote {
    public boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, int arg4) throws java.rmi.RemoteException;
    public boolean deleteComment(java.lang.String arg0) throws java.rmi.RemoteException;
    public org.wbd.heroku.service.Post[] listPost(int arg0) throws java.rmi.RemoteException;
    public boolean editUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, int arg5) throws java.rmi.RemoteException;
    public boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public boolean pulverizePost(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean setPostPublish(java.lang.String arg0, boolean arg1) throws java.rmi.RemoteException;
    public boolean setPostDelete(java.lang.String arg0, boolean arg1) throws java.rmi.RemoteException;
    public org.wbd.heroku.service.Post[] search(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean editPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public org.wbd.heroku.service.Comment[] listComment() throws java.rmi.RemoteException;
    public org.wbd.heroku.service.User[] listUser() throws java.rmi.RemoteException;
    public boolean addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
    public boolean deleteUser(java.lang.String arg0) throws java.rmi.RemoteException;
}
