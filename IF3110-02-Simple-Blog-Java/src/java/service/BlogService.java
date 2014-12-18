/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author calvin-pc
 */
public class BlogService {
    private static heroku.service.NewWebService instance;
    private static void init() {
        heroku.service.NewWebService_Service service = new heroku.service.NewWebService_Service();
        instance = service.getNewWebServicePort();
    }
    
    public static heroku.service.NewWebService getInstance() {
        if (instance == null) init();
        return instance;
    }
}
