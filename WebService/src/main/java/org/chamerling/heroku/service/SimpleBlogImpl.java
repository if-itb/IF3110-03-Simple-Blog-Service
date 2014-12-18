/**
 * 
 */
package org.chamerling.heroku.service;

import Helper.MD5;
import Helper.UrlHelper;
import Model.Comment;
import Model.Post;
import Model.User;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import java.util.List;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/**
 * @author chamerling
 * 
 */
public class SimpleBlogImpl implements SimpleBlog {

    private String firebase_url = "https://simple-blog-30.firebaseio.com/";
    private boolean status;
    @Override
    public boolean addUser(String username,String password,String role,String name,String email) throws InterruptedException  {
        Firebase firebase = new Firebase(firebase_url);
        Firebase userRef = firebase.child("Users");
        Map<String,Object> userMap = new HashMap<String,Object>();
        userMap.put("password",password);
        userMap.put("role",role);
        userMap.put("name",name);
        userMap.put("email",email);
        status = false;
        final CountDownLatch done = new CountDownLatch(1);
        userRef.child(username).setValue(userMap,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

    @Override
    public boolean validate(String username, String password) {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Users/"+username+".json"); 
            JSONObject obj = new JSONObject(json);
            if (obj.getString("password").equals(MD5.getMD5(password)))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public User getUser(String username) {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Users/"+username+".json"); 
            JSONObject obj = new JSONObject(json);
            User user = new User();
            user.setUsername(username);
            user.setPasswordUnEncrypt(obj.getString("password"));
            user.setRole(obj.getString("role"));
            user.setName(obj.getString("name"));
            user.setEmail(obj.getString("email"));
            return user;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<User> getAllUser() {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Users.json"); 
            JSONObject obj = new JSONObject(json);
            List<User> LS = new LinkedList();
            for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                String username = (String) iterator.next();
                User user = new User();
                user.setUsername(username);
                JSONObject user_d = (JSONObject) obj.get(username);
                user.setPasswordUnEncrypt(user_d.getString("password"));
                user.setRole(user_d.getString("role"));
                user.setName(user_d.getString("name"));
                user.setEmail(user_d.getString("email"));
                LS.add(user);
            }
            return LS;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean editUser(String user,String username,String password,String role,String name,String email) throws InterruptedException {
        Firebase firebase = new Firebase(firebase_url);
        Firebase userRef = firebase.child("Users");
        userRef.child(user).removeValue();
        Map<String,Object> userMap = new HashMap<String,Object>();
        userMap.put("password",password);
        userMap.put("role",role);
        userMap.put("name",name);
        userMap.put("email",email);
        status = false;
        final CountDownLatch done = new CountDownLatch(1);
        userRef.child(username).setValue(userMap,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        if (status)
        {
            for (Post post : getPostbyAuthor(username))
            {
                boolean del = hardDelPost(post.getId());
            }
            for (Post post : getDraftbyAuthor(username))
            {
                boolean del = hardDelPost(post.getId());
            }
            for (Post post : getDeletedbyAuthor(username))
            {
                boolean del = hardDelPost(post.getId());
            }
        }
        return status;
    }

    @Override
    public boolean delUser(String username) throws InterruptedException  {
        Firebase firebase = new Firebase(firebase_url);
        Firebase userRef = firebase.child("Users");
        status = false;
        final CountDownLatch done = new CountDownLatch(1);
        userRef.child(username).removeValue(new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

    @Override
    public boolean addPost(String title, String image, String date, String content, String author, boolean published) throws InterruptedException {
        Firebase firebase = new Firebase(firebase_url);
        Firebase rootRef = firebase.child("Posts");
        Firebase postRef;
        if (published)
        {
            postRef = rootRef.child("published");
        }
        else
        {
            postRef = rootRef.child("draft");
        }
        Map<String,Object> postMap = new HashMap<String,Object>();
        postMap.put("title",title);
        postMap.put("image",image);
        postMap.put("date",date);
        postMap.put("content",content);
        postMap.put("author",author);
        status = false;
        final CountDownLatch done = new CountDownLatch(1);
        postRef.push().setValue(postMap,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done.countDown();
            }
        });
        done.await();
        return status;
    }

    @Override
    public List<Post> getAllPost() {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/published.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Post> LP = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject post_d = (JSONObject) obj.get(id);
                    String title = post_d.getString("title");
                    String image = post_d.getString("image");
                    String date = post_d.getString("date");
                    String content = post_d.getString("content");
                    User author = getUser(post_d.getString("author"));
                    boolean published = true;
                    boolean deleted = false;
                    Post post = new Post(id, title,image, date, content, author, published, deleted);
                    LP.add(post);
                }
                return LP;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Post getPost(String pid) {
        try
        {
            boolean published = true;
            boolean deleted = false;
            String json = UrlHelper.getString(firebase_url+"Posts/published/"+pid+".json");
            if (json.equals("null"))
            {
                json = UrlHelper.getString(firebase_url+"Posts/draft/"+pid+".json");
                published = false;
            }
            if (json.equals("null"))
            {
                json = UrlHelper.getString(firebase_url+"Posts/deleted/"+pid+".json");
                deleted = true;
            }
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                String title = obj.getString("title");
                String image = obj.getString("image");
                String date = obj.getString("date");
                String content = obj.getString("content");
                User author = getUser(obj.getString("author"));
                Post post = new Post(pid, title,image, date, content, author, published, deleted);
                return post;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Post> getAllDraft() {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/draft.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Post> LP = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject post_d = (JSONObject) obj.get(id);
                    String title = post_d.getString("title");
                    String image = post_d.getString("image");
                    String date = post_d.getString("date");
                    String content = post_d.getString("content");
                    User author = getUser(post_d.getString("author"));
                    boolean published = false;
                    boolean deleted = false;
                    Post post = new Post(id, title,image, date, content, author, published, deleted);
                    LP.add(post);
                }
                return LP;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Post> getDraftbyAuthor(String username) {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/draft.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Post> LP = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject post_d = (JSONObject) obj.get(id);
                    if (post_d.getString("author").equals(username))
                    {
                        String title = post_d.getString("title");
                        String image = post_d.getString("image");
                        String date = post_d.getString("date");
                        String content = post_d.getString("content");
                        User author = getUser(post_d.getString("author"));
                        boolean published = false;
                        boolean deleted = false;
                        Post post = new Post(id, title,image, date, content, author, published, deleted);
                        LP.add(post);
                    }
                }
                return LP;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Post> getPostbyAuthor(String username) {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/published.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Post> LP = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject post_d = (JSONObject) obj.get(id);
                    if (post_d.getString("author").equals(username))
                    {
                        String title = post_d.getString("title");
                        String image = post_d.getString("image");
                        String date = post_d.getString("date");
                        String content = post_d.getString("content");
                        User author = getUser(post_d.getString("author"));
                        boolean published = false;
                        boolean deleted = false;
                        Post post = new Post(id, title,image, date, content, author, published, deleted);
                        LP.add(post);
                    }
                }
                return LP;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Post> getAllDeleted() {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/deleted.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Post> LP = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject post_d = (JSONObject) obj.get(id);
                    String title = post_d.getString("title");
                    String image = post_d.getString("image");
                    String date = post_d.getString("date");
                    String content = post_d.getString("content");
                    User author = getUser(post_d.getString("author"));
                    boolean published = false;
                    boolean deleted = false;
                    Post post = new Post(id, title,image, date, content, author, published, deleted);
                    LP.add(post);
                }
                return LP;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<Post> getDeletedbyAuthor(String username) {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/deleted.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Post> LP = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject post_d = (JSONObject) obj.get(id);
                    if (post_d.getString("author").equals(username))
                    {
                        String title = post_d.getString("title");
                        String image = post_d.getString("image");
                        String date = post_d.getString("date");
                        String content = post_d.getString("content");
                        User author = getUser(post_d.getString("author"));
                        boolean published = false;
                        boolean deleted = false;
                        Post post = new Post(id, title,image, date, content, author, published, deleted);
                        LP.add(post);
                    }
                }
                return LP;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean editPost(String pid, String title, String image, String date, String content, String author, boolean published) throws InterruptedException {
        Firebase firebase = new Firebase(firebase_url);
        Firebase rootRef = firebase.child("Posts");
        Firebase postRef;
        if (published)
        {
            postRef = rootRef.child("published");
        }
        else
        {
            postRef = rootRef.child("draft");
        }
        status = false;
        final CountDownLatch done1 = new CountDownLatch(1);
        postRef.child(pid).child("title").setValue(title,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done1.countDown();
            }
        });
        done1.await();
        final CountDownLatch done2 = new CountDownLatch(1);
        postRef.child(pid).child("image").setValue(image,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done2.countDown();
            }
        });
        done2.await();
        final CountDownLatch done3 = new CountDownLatch(1);
        postRef.child(pid).child("date").setValue(date,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done3.countDown();
            }
        });
        done3.await();
        final CountDownLatch done4 = new CountDownLatch(1);
        postRef.child(pid).child("content").setValue(content,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done4.countDown();
            }
        });
        done4.await();
        final CountDownLatch done5 = new CountDownLatch(1);
        postRef.child(pid).child("author").setValue(author,new Firebase.CompletionListener() {

            @Override
            public void onComplete(FirebaseError fe, Firebase frbs) {
                status = true;
                done5.countDown();
            }
        });
        done5.await();
        return status;
    }

    @Override
    public boolean hardDelPost(String pid) throws InterruptedException {
        Firebase firebase = new Firebase(firebase_url);
        Firebase rootRef = firebase.child("Posts");
        Firebase postRef = rootRef.child("deleted");
        Post post = getPost(pid);
        if (post != null)
        {
            status = false;
            final CountDownLatch done = new CountDownLatch(1);
            postRef.child(pid).removeValue(new Firebase.CompletionListener() {

                @Override
                public void onComplete(FirebaseError fe, Firebase frbs) {
                    status = true;
                    done.countDown();
                }
            });
            done.await();
            return status;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean softDelPost(String pid) throws InterruptedException {
        Firebase firebase = new Firebase(firebase_url);
        Firebase rootRef = firebase.child("Posts");
        Firebase postRef;
        Post post = getPost(pid);
        if (post.getPublished())
        {
            postRef = rootRef.child("published");
        }
        else
        {
            postRef = rootRef.child("draft");
        }
        if (post != null)
        {
            status = false;
            final CountDownLatch done = new CountDownLatch(1);
            postRef.child(pid).removeValue(new Firebase.CompletionListener() {

                @Override
                public void onComplete(FirebaseError fe, Firebase frbs) {
                    status = true;
                    done.countDown();
                }
            });
            done.await();
            if (status)
            {
                postRef = rootRef.child("deleted");
                Map<String,Object> postMap = new HashMap<String,Object>();
                postMap.put("title",post.getTitle());
                postMap.put("image",post.getImage());
                postMap.put("date",post.getDate());
                postMap.put("content",post.getContent());
                postMap.put("author",post.getAuthor().getUsername());
                status = false;
                final CountDownLatch done1 = new CountDownLatch(1);
                postRef.push().setValue(postMap,new Firebase.CompletionListener() {

                    @Override
                    public void onComplete(FirebaseError fe, Firebase frbs) {
                        status = true;
                        done1.countDown();
                    }
                });
                done1.await();
            }
            return status;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean restorePost(String pid) throws InterruptedException {
        Firebase firebase = new Firebase(firebase_url);
        Firebase rootRef = firebase.child("Posts");
        Firebase postRef = rootRef.child("deleted");
        Post post = getPost(pid);
        if (post != null)
        {
            status = false;
            final CountDownLatch done = new CountDownLatch(1);
            postRef.child(pid).removeValue(new Firebase.CompletionListener() {

                @Override
                public void onComplete(FirebaseError fe, Firebase frbs) {
                    status = true;
                    done.countDown();
                }
            });
            done.await();
            if (status)
            {
                postRef = rootRef.child("draft");
                Map<String,Object> postMap = new HashMap<String,Object>();
                postMap.put("title",post.getTitle());
                postMap.put("image",post.getImage());
                postMap.put("date",post.getDate());
                postMap.put("content",post.getContent());
                postMap.put("author",post.getAuthor().getUsername());
                status = false;
                final CountDownLatch done1 = new CountDownLatch(1);
                postRef.push().setValue(postMap,new Firebase.CompletionListener() {

                    @Override
                    public void onComplete(FirebaseError fe, Firebase frbs) {
                        status = true;
                        done1.countDown();
                    }
                });
                done1.await();
            }
            return status;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean publishPost(String pid) throws InterruptedException {
        Firebase firebase = new Firebase(firebase_url);
        Firebase rootRef = firebase.child("Posts");
        Firebase postRef = rootRef.child("draft");
        Post post = getPost(pid);
        if (post != null)
        {
            status = false;
            final CountDownLatch done = new CountDownLatch(1);
            postRef.child(pid).removeValue(new Firebase.CompletionListener() {

                @Override
                public void onComplete(FirebaseError fe, Firebase frbs) {
                    status = true;
                    done.countDown();
                }
            });
            done.await();
            if (status)
            {
                postRef = rootRef.child("published");
                Map<String,Object> postMap = new HashMap<String,Object>();
                postMap.put("title",post.getTitle());
                postMap.put("image",post.getImage());
                postMap.put("date",post.getDate());
                postMap.put("content",post.getContent());
                postMap.put("author",post.getAuthor().getUsername());
                status = false;
                final CountDownLatch done1 = new CountDownLatch(1);
                postRef.push().setValue(postMap,new Firebase.CompletionListener() {

                    @Override
                    public void onComplete(FirebaseError fe, Firebase frbs) {
                        status = true;
                        done1.countDown();
                    }
                });
                done1.await();
            }
            return status;
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<Post> searchPost(String query) {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/published.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Post> LP = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject post_d = (JSONObject) obj.get(id);
                    String title = post_d.getString("title");
                    String image = post_d.getString("image");
                    String date = post_d.getString("date");
                    String content = post_d.getString("content");
                    if (title.toLowerCase().contains(query.toLowerCase()) || content.toLowerCase().contains(query.toLowerCase()))
                    {
                        User author = getUser(post_d.getString("author"));
                        boolean published = true;
                        boolean deleted = false;
                        Post post = new Post(id, title,image, date, content, author, published, deleted);
                        LP.add(post);
                    }
                }
                return LP;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean addComment(String pid,String name, String email, String content) throws InterruptedException {
        Post post = getPost(pid);
        if (post != null)
        {
            Firebase firebase = new Firebase(firebase_url);
            Firebase rootRef = firebase.child("Posts");
            Firebase postRef = rootRef.child("published");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            Map<String,Object> postMap = new HashMap<String,Object>();
            postMap.put("name",name);
            postMap.put("email",email);
            postMap.put("content",content);
            postMap.put("time",dateFormat.format(date));
            status = false;
            final CountDownLatch done = new CountDownLatch(1);
            postRef.child(pid).child("comments").push().setValue(postMap,new Firebase.CompletionListener() {

                @Override
                public void onComplete(FirebaseError fe, Firebase frbs) {
                    status = true;
                    done.countDown();
                }
            });
            done.await();
            return status;
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<Comment> getComment(String pid) {
        try
        {
            String json = UrlHelper.getString(firebase_url+"Posts/published/"+pid+"/comments.json"); 
            if (json.equals("null"))
            {
                return null;
            }
            else
            {
                JSONObject obj = new JSONObject(json);
                List<Comment> LC = new LinkedList();
                for(Iterator iterator = obj.keys(); iterator.hasNext();) {
                    String id = (String) iterator.next();
                    JSONObject com_d = (JSONObject) obj.get(id);
                    String name = com_d.getString("name");
                    String email = com_d.getString("email");
                    String content = com_d.getString("content");
                    String time = com_d.getString("time");
                    Comment comment = new Comment(name,email,content,time);
                    LC.add(comment);
                }
                return LC;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }
   
}
