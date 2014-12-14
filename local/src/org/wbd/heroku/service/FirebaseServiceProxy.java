package org.wbd.heroku.service;

public class FirebaseServiceProxy implements org.wbd.heroku.service.FirebaseService {
  private String _endpoint = null;
  private org.wbd.heroku.service.FirebaseService firebaseService = null;
  
  public FirebaseServiceProxy() {
    _initFirebaseServiceProxy();
  }
  
  public FirebaseServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFirebaseServiceProxy();
  }
  
  private void _initFirebaseServiceProxy() {
    try {
      firebaseService = (new org.wbd.heroku.service.FirebaseServiceImplServiceLocator()).getFirebaseServiceImplPort();
      if (firebaseService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)firebaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)firebaseService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (firebaseService != null)
      ((javax.xml.rpc.Stub)firebaseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.wbd.heroku.service.FirebaseService getFirebaseService() {
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService;
  }
  
  public boolean addUser(java.lang.String username, java.lang.String password, java.lang.String name, java.lang.String email, int role) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.addUser(username, password, name, email, role);
  }
  
  public boolean deleteComment(java.lang.String id) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.deleteComment(id);
  }
  
  public org.wbd.heroku.service.Post[] listPost(int code) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.listPost(code);
  }
  
  public boolean editUser(java.lang.String id, java.lang.String username, java.lang.String password, java.lang.String name, java.lang.String email, int role) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.editUser(id, username, password, name, email, role);
  }
  
  public boolean addPost(java.lang.String judul, java.lang.String konten, java.lang.String tanggal, java.lang.String idAuthor) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.addPost(judul, konten, tanggal, idAuthor);
  }
  
  public boolean pulverizePost(java.lang.String id) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.pulverizePost(id);
  }
  
  public boolean setPostPublish(java.lang.String id, boolean status) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.setPostPublish(id, status);
  }
  
  public boolean setPostDelete(java.lang.String id, boolean status) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.setPostDelete(id, status);
  }
  
  public org.wbd.heroku.service.Post getPost(java.lang.String id) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.getPost(id);
  }
  
  public org.wbd.heroku.service.Post[] search(java.lang.String query) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.search(query);
  }
  
  public boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String konten, java.lang.String tanggal) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.editPost(id, judul, konten, tanggal);
  }
  
  public org.wbd.heroku.service.Comment[] listComment() throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.listComment();
  }
  
  public org.wbd.heroku.service.User[] listUser() throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.listUser();
  }
  
  public boolean addComment(java.lang.String name, java.lang.String email, java.lang.String kontent, java.lang.String tanggal, java.lang.String idPost) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.addComment(name, email, kontent, tanggal, idPost);
  }
  
  public boolean deleteUser(java.lang.String id) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.deleteUser(id);
  }
  
  public org.wbd.heroku.service.Comment[] listPostComment(java.lang.String post_id) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.listPostComment(post_id);
  }
  
  
}