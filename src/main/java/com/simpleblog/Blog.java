/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleblog;

import com.firebase.client.Firebase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.json.*;

/**
 *
 * @author user
 */
@WebService(serviceName = "Blog")
public class Blog {

    private Firebase fb;
    final String datastorage = "https://simpleblogjava.firebaseio.com/";

    public Blog() {
        fb = new Firebase(datastorage);
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") final String judul, @WebParam(name = "konten") final String konten, @WebParam(name = "tanggal") final String tanggal) {
        Firebase posts = fb.child("post");
        Map<String, Object> newPost = new HashMap<String, Object>();
        newPost.put("judul", judul);
        newPost.put("konten", konten);
        newPost.put("tanggal", tanggal);
        newPost.put("published", false);
        newPost.put("deleted", false);
        posts.push().setValue(newPost);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editPost")
    public Boolean editPost(@WebParam(name = "id") final String id, @WebParam(name = "judul") final String judul, @WebParam(name = "konten") final String konten, @WebParam(name = "tanggal") final String tanggal, @WebParam(name = "published") final Boolean published, @WebParam(name = "deleted") final Boolean deleted) {
        Firebase post = fb.child("post").child(id);
        Map<String, Object> newPost = new HashMap<String, Object>();
        newPost.put("judul", judul);
        newPost.put("konten", konten);
        newPost.put("tanggal", tanggal);
        newPost.put("published", published);
        newPost.put("deleted", deleted);
        post.updateChildren(newPost);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePost")
    public Boolean deletePost(@WebParam(name = "id") final String id) {
        Firebase post = fb.child("post").child(id);
        post.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addComment")
    public Boolean addComment(@WebParam(name = "created_at") final String created_at, @WebParam(name = "id_post") final String id_post, @WebParam(name = "nama") final String nama, @WebParam(name = "email") final String email, @WebParam(name = "konten") final String konten) {
        Firebase comments = fb.child("post").child(id_post).child("comment");
        Map<String, String> newComment = new HashMap<String, String>();
        newComment.put("created_at", created_at);
        newComment.put("nama", nama);
        newComment.put("email", email);
        newComment.put("konten", konten);
        comments.push().setValue(newComment);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "nama") final String nama, @WebParam(name = "password") final String password, @WebParam(name = "email") final String email, @WebParam(name = "role") final String role) {
        Firebase users = fb.child("user");
        HashMap<String, String> newUser = new HashMap<String, String>();
        newUser.put("email", email);
        newUser.put("role", role);
        newUser.put("password", password);
        newUser.put("nama", nama);
        users.push().setValue(newUser);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "id") String id) {
        Firebase user = fb.child("user").child(id);
        user.removeValue();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editUser")
    public Boolean editUser(@WebParam(name = "password") final String password, @WebParam(name = "id") final String id, @WebParam(name = "nama") final String nama, @WebParam(name = "role") final String role, @WebParam(name = "email") final String email) {
        Firebase user = fb.child("user").child(id);
        Map<String, Object> newUser = new HashMap<String, Object>();
        newUser.put("nama", nama);
        newUser.put("role", role);
        newUser.put("password", password);
        newUser.put("email", email);
        user.updateChildren(newUser);
        return true;
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "listUser")
    public ArrayList<UserModel> listUser() {
        ArrayList<UserModel> users = new ArrayList<UserModel>();

        String jsonString = "";
        try {
            URLConnection conn = (new URL(datastorage + "user.json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            jsonString = inp.readLine();
            System.out.println(jsonString);
            JSONObject usersJSON = new JSONObject(jsonString);
            JSONArray usersIDJSON = usersJSON.names();
            System.out.println(usersIDJSON.length());
            for (int it = 0; it < usersIDJSON.length(); ++it) {
                String userID = usersIDJSON.getString(it);
                JSONObject userJSON = usersJSON.getJSONObject(userID);
                UserModel user = new UserModel();
                user.setId(userID);
                user.setEmail(userJSON.getString("email"));
                user.setNama(userJSON.getString("nama"));
                user.setPassword(userJSON.getString("password"));
                user.setRole(userJSON.getString("role"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "publishPost")
    public Boolean publishPost(@WebParam(name = "id") final String id) {
        final Firebase post = fb.child("post").child(id);
        HashMap<String, Object> status = new HashMap<String, Object>();
        status.put("published", "published");
        post.updateChildren(status);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listPost")
    public ArrayList<PostModel> listPost() {
        ArrayList<PostModel> posts = new ArrayList<PostModel>();

        String jsonString = "";
        try {
            URLConnection conn = (new URL(datastorage + "post.json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            jsonString = inp.readLine();
//
            JSONObject postsJSON = new JSONObject(jsonString);
            JSONArray postsIDJSON = postsJSON.names();
            for (int it = 0; it < postsIDJSON.length(); ++it) {
                String postID = postsIDJSON.getString(it);
                JSONObject postJSON = postsJSON.getJSONObject(postID);
                PostModel post = new PostModel();
                post.setId(postID);
                post.setJudul(postJSON.getString("judul"));
                post.setKonten(postJSON.getString("konten"));
                post.setPublished(Boolean.parseBoolean(postJSON.getString("published")));
                post.setDeleted(Boolean.parseBoolean(postJSON.getString("deleted")));
                post.setTanggal(postJSON.getString("tanggal"));
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listComment")
    public ArrayList<CommentModel> listComment(@WebParam(name = "id") final String id) {
        ArrayList<CommentModel> comments = new ArrayList<CommentModel>();

        String jsonString = "";
        try {
            URLConnection conn = (new URL(datastorage + "post//" + id + "//comment.json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            jsonString = inp.readLine();

            JSONObject commentsJSON = new JSONObject(jsonString);
            JSONArray commentsIDJSON = commentsJSON.names();
            for (int it = 0; it < commentsIDJSON.length(); ++it) {
                String commentID = commentsIDJSON.getString(it);
                JSONObject commentJSON = commentsJSON.getJSONObject(commentID);
                CommentModel comment = new CommentModel();
                comment.setEmail(commentJSON.getString("email"));
                comment.setId(commentID);
                comment.setKonten(commentJSON.getString("konten"));
                comment.setNama(commentJSON.getString("nama"));
                comment.setTanggal(commentJSON.getString("created_at"));
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUser")
    public UserModel getUser(@WebParam(name = "id") final String id) {
        UserModel user = null;
        try {
            URLConnection conn = (new URL(datastorage + "user//" + id + "//.json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonString = inp.readLine();

            JSONObject userJSON = new JSONObject(jsonString);
            user = new UserModel();
            user.setId(id);
            user.setEmail(userJSON.getString("email"));
            user.setNama(userJSON.getString("nama"));
            user.setPassword(userJSON.getString("password"));
            user.setRole(userJSON.getString("role"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Web service operation
     *
     * @param id
     */
    @WebMethod(operationName = "getPost")
    public ArrayList<PostModel> getPost(@WebParam(name = "id") final String id) {
        ArrayList<PostModel> posts = new ArrayList<PostModel>();

        String jsonString = "";
        try {
            URLConnection conn = (new URL(datastorage + "post.json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            jsonString = inp.readLine();

            JSONObject postsJSON = new JSONObject(jsonString);
            JSONArray postsIDJSON = postsJSON.names();
            for (int it = 0; it < postsIDJSON.length(); ++it) {
                String postID = postsIDJSON.getString(it);
                JSONObject postJSON = postsJSON.getJSONObject(postID);
                PostModel post = new PostModel();
                post.setId(postID);
                post.setJudul(postJSON.getString("judul"));
                post.setKonten(postJSON.getString("konten"));
                post.setPublished(Boolean.parseBoolean(postJSON.getString("published")));
                post.setDeleted(Boolean.parseBoolean(postJSON.getString("deleted")));
                post.setTanggal(postJSON.getString("tanggal"));
                if (post.getId().equalsIgnoreCase(id)) {
                    posts.add(post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    public ArrayList<PostModel> search(@WebParam(name = "keyword") final String keyword) {
        ArrayList<PostModel> posts = new ArrayList<PostModel>();

        String jsonString = "";
        try {
            URLConnection conn = (new URL(datastorage + "post.json")).openConnection();
            BufferedReader inp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            jsonString = inp.readLine();

            JSONObject postsJSON = new JSONObject(jsonString);
            JSONArray postsIDJSON = postsJSON.names();
            for (int it = 0; it < postsIDJSON.length(); ++it) {
                String postID = postsIDJSON.getString(it);
                JSONObject postJSON = postsJSON.getJSONObject(postID);
                PostModel post = new PostModel();
                post.setId(postID);
                post.setJudul(postJSON.getString("judul"));
                post.setKonten(postJSON.getString("konten"));
                post.setPublished(Boolean.parseBoolean(postJSON.getString("published")));
                post.setDeleted(Boolean.parseBoolean(postJSON.getString("deleted")));
                post.setTanggal(postJSON.getString("tanggal"));
                if (post.getJudul().toLowerCase().contains(keyword.toLowerCase()) || post.getKonten().toLowerCase().contains(keyword.toLowerCase())) {
                    posts.add(post);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
}
