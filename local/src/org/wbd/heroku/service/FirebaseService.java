/**
 * FirebaseService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.wbd.heroku.service;

public interface FirebaseService extends java.rmi.Remote {
    public boolean addUser(java.lang.String username, java.lang.String password, java.lang.String name, java.lang.String email, int role) throws java.rmi.RemoteException;
    public boolean deleteComment(java.lang.String id) throws java.rmi.RemoteException;
    public org.wbd.heroku.service.Post[] listPost(int code) throws java.rmi.RemoteException;
    public boolean editUser(java.lang.String id, java.lang.String username, java.lang.String password, java.lang.String name, java.lang.String email, int role) throws java.rmi.RemoteException;
    public boolean addPost(java.lang.String judul, java.lang.String konten, java.lang.String tanggal, java.lang.String idAuthor) throws java.rmi.RemoteException;
    public boolean pulverizePost(java.lang.String id) throws java.rmi.RemoteException;
    public boolean setPostPublish(java.lang.String id, boolean status) throws java.rmi.RemoteException;
    public boolean setPostDelete(java.lang.String id, boolean status) throws java.rmi.RemoteException;
    public org.wbd.heroku.service.Post getPost(java.lang.String id) throws java.rmi.RemoteException;
    public org.wbd.heroku.service.Post[] search(java.lang.String query) throws java.rmi.RemoteException;
    public boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String konten, java.lang.String tanggal) throws java.rmi.RemoteException;
    public org.wbd.heroku.service.Comment[] listComment() throws java.rmi.RemoteException;
    public org.wbd.heroku.service.User[] listUser() throws java.rmi.RemoteException;
    public boolean addComment(java.lang.String name, java.lang.String email, java.lang.String kontent, java.lang.String tanggal, java.lang.String idPost) throws java.rmi.RemoteException;
    public boolean deleteUser(java.lang.String id) throws java.rmi.RemoteException;
}
