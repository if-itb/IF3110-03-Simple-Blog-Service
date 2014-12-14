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
  
  public boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.addUser(arg0, arg1, arg2, arg3, arg4);
  }
  
  public boolean deleteComment(int arg0) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.deleteComment(arg0);
  }
  
  public org.wbd.heroku.service.Post[] listPost(int arg0) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.listPost(arg0);
  }
  
  public boolean editUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.editUser(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.addPost(arg0, arg1, arg2, arg3);
  }
  
  public boolean pulverizePost(java.lang.String arg0) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.pulverizePost(arg0);
  }
  
  public boolean setPostPublish(java.lang.String arg0, boolean arg1) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.setPostPublish(arg0, arg1);
  }
  
  public boolean setPostDelete(java.lang.String arg0, boolean arg1) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.setPostDelete(arg0, arg1);
  }
  
  public org.wbd.heroku.service.Post[] search(java.lang.String arg0) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.search(arg0);
  }
  
  public boolean editPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.editPost(arg0, arg1, arg2, arg3);
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
  
  public boolean addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.addComment(arg0, arg1, arg2, arg3, arg4);
  }
  
  public boolean deleteUser(java.lang.String arg0) throws java.rmi.RemoteException{
    if (firebaseService == null)
      _initFirebaseServiceProxy();
    return firebaseService.deleteUser(arg0);
  }
  
  
}