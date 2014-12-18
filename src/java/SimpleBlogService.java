/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M. Reza Irvanda
 */
public class SimpleBlogService {

    public static java.util.List<blog.Post> listPost() {
        blog.Cobablog_Service service = new blog.Cobablog_Service();
        blog.Cobablog port = service.getCobablogPort();
        return port.listPost();
    }
}
