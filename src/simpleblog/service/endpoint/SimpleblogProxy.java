package simpleblog.service.endpoint;

public class SimpleblogProxy implements simpleblog.service.endpoint.Simpleblog_PortType {
  private String _endpoint = null;
  private simpleblog.service.endpoint.Simpleblog_PortType simpleblog_PortType = null;
  
  public SimpleblogProxy() {
    _initSimpleblogProxy();
  }
  
  public SimpleblogProxy(String endpoint) {
    _endpoint = endpoint;
    _initSimpleblogProxy();
  }
  
  private void _initSimpleblogProxy() {
    try {
      simpleblog_PortType = (new simpleblog.service.endpoint.Simpleblog_ServiceLocator()).getSimpleblogPort();
      if (simpleblog_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)simpleblog_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)simpleblog_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (simpleblog_PortType != null)
      ((javax.xml.rpc.Stub)simpleblog_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public simpleblog.service.endpoint.Simpleblog_PortType getSimpleblog_PortType() {
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType;
  }
  
  public boolean publishPost(java.lang.String arg0) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.publishPost(arg0);
  }
  
  public simpleblog.service.endpoint.Post getPost(java.lang.String arg0) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.getPost(arg0);
  }
  
  public simpleblog.service.endpoint.Post[] search(java.lang.String arg0) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.search(arg0);
  }
  
  public boolean editPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.editPost(arg0, arg1, arg2, arg3);
  }
  
  public boolean addComment(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.addComment(arg0, arg1, arg2, arg3);
  }
  
  public simpleblog.service.endpoint.User[] listUser() throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.listUser();
  }
  
  public boolean deleteUser(java.lang.String arg0) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.deleteUser(arg0);
  }
  
  public boolean addUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.addUser(arg0, arg1, arg2, arg3);
  }
  
  public boolean deleteComment(java.lang.String arg0) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.deleteComment(arg0);
  }
  
  public boolean deletePost(java.lang.String arg0) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.deletePost(arg0);
  }
  
  public simpleblog.service.endpoint.Post[] listPost() throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.listPost();
  }
  
  public boolean addPost(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.addPost(arg0, arg1, arg2);
  }
  
  public boolean editUser(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.editUser(arg0, arg1, arg2, arg3, arg4);
  }
  
  public simpleblog.service.endpoint.Comment[] listComment(java.lang.String arg0) throws java.rmi.RemoteException{
    if (simpleblog_PortType == null)
      _initSimpleblogProxy();
    return simpleblog_PortType.listComment(arg0);
  }
  
  
}