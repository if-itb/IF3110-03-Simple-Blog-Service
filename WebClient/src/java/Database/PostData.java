package Database;

import Model.Comment;
import Model.Post;
import Model.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.chamerling.heroku.service.InterruptedException_Exception;
import org.chamerling.heroku.service.SimpleBlog;
import org.chamerling.heroku.service.SimpleBlogImplService;

/**
 * Representation of Data Post
 * @author Riva Syafri Rachmatullah
 * @modified Luthfi Hamid Masykuri
 */
@ManagedBean(name="PostData")
@RequestScoped
public class PostData implements Serializable {
    private MySQL db;
    private String table;
    private Part part;
    private String upload;
    private SimpleBlog SB;
    
    /**
     * Create an instance of PostData
     */
    public PostData() {
        table = "post";
        upload = "";
        db = new MySQL();
        SB = new SimpleBlogImplService().getSimpleBlogImplPort();
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }
    
    /**
     * Get post by its id from database
     * @param id_post the id of post
     * @return an instance of post from database
     */
    public Post getPost(String id_post) {
        if (SB.getPost(id_post) != null)
        {
            Post post = new Post(SB.getPost(id_post));
            return post;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Get all post from database
     * @return list of post
     */
    public List<Post> getAllPost() {
        
        List<Post> LP = new LinkedList();
        for (org.chamerling.heroku.service.Post p : SB.getAllPost())
        {
            Post post = new Post(p);
            LP.add(post);
        }
        
        return LP;
    }
    
    /**
     * Get all post based on username
     * @param user username
     * @return All post by username
     */
    public List<Post> getPostbyAuthor(User user) {
        List<Post> LP = new LinkedList();
        for (org.chamerling.heroku.service.Post p : SB.getPostbyAuthor(user.getUsername()))
        {
            Post post = new Post(p);
            LP.add(post);
        }
        
        return LP;
    }
    
    /**
     * Get all draft from database
     * @return list of draft
     */
    public List<Post> getAllDraft() {
        List<Post> LP = new LinkedList();
        for (org.chamerling.heroku.service.Post p : SB.getAllDraft())
        {
            Post post = new Post(p);
            LP.add(post);
        }
        
        return LP;
    }
    
    /**
     * Get all draft based on username
     * @param user username
     * @return All draft by username
     */
    public List<Post> getDraftbyAuthor(User user) {
        List<Post> LP = new LinkedList();
        for (org.chamerling.heroku.service.Post p : SB.getDraftbyAuthor(user.getUsername()))
        {
            Post post = new Post(p);
            LP.add(post);
        }
        
        return LP;
    }
    
    public List<Post> getAllDeleted() {
        List<Post> LP = new LinkedList();
        for (org.chamerling.heroku.service.Post p : SB.getAllDeleted())
        {
            Post post = new Post(p);
            LP.add(post);
        }
        
        return LP;
    }
    
    /**
     * Get all draft based on username
     * @param user username
     * @return All draft by username
     */
    public List<Post> getDeletedbyAuthor(User user) {
        List<Post> LP = new LinkedList();
        for (org.chamerling.heroku.service.Post p : SB.getDeletedbyAuthor(user.getUsername()))
        {
            Post post = new Post(p);
            LP.add(post);
        }
        
        return LP;
    }
    
    public List<Post> searchPost(String query) {
        
        List<Post> LP = new LinkedList();
        for (org.chamerling.heroku.service.Post p : SB.searchPost(query))
        {
            Post post = new Post(p);
            LP.add(post);
        }
        
        return LP;
    }
    
    /**
     * Add post to database
     * @param post the new post
     * @param author the author of new post
     * @param published published status of post
     * @return String status to pass
     */
    public String addPost(Post post, User author, boolean published) throws IOException, InterruptedException_Exception {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        String basePath = facesContext.getExternalContext().getRealPath("");
        String image = uploadFile(author.getUsername());
        String title = post.getTitle();
        String date = post.getDate().toString();
        String content = post.getContent();
        String user = author.getUsername();
        boolean query = SB.addPost(title, image, date, content, user, published);
        if (query) {
            return "success";
        } else {
            return "failed";
        }
    }
    
    /**
     * Edit post on database
     * @param post updated post
     * @return String status
     */
    public String editPost(Post post,boolean published) throws IOException, InterruptedException_Exception {
        if (upload.equals("oke")){
            String pid = post.getId();
            String image = uploadFile(getPost(pid).getAuthor().getUsername());
            String title = post.getTitle();
            String date = post.getDate();
            String content = post.getContent();
            String user = getPost(pid).getAuthor().getUsername();
            boolean query = SB.editPost(pid,title, image, date, content, user, published);
            if (query) {
                return "success";
            } else {
                return "failed";
            }
        }else {
            String pid = post.getId();
            String image = getPost(pid).getImage();
            String title = post.getTitle();
            String date = post.getDate();
            String content = post.getContent();
            String user = getPost(pid).getAuthor().getUsername();
            boolean query = SB.editPost(pid,title, image, date, content, user, published);
            if (query) {
                return "success";
            } else {
                return "failed";
            }
        }
    }
    
    /**
     * Delete post from database 
     * @param post deleted post
     */
    public String hardDelPost(Post post) throws InterruptedException_Exception {
        boolean del = SB.hardDelPost(post.getId());
        return "deleted";
    }
    
    /**
     * Check deleted status on database but not delete post in database
     * @param post deleted post to recycle bin
     * @return string status
     */
    public String softDelPost(Post post) throws InterruptedException_Exception {
        if (SB.softDelPost(post.getId())) {
            return "success";
        } else {
            return "failed";
        }
    }
    
    /**
     * Restore soft deleted post in database
     * @param post restored post
     * @return string status
     */
    public String restorePost(Post post) throws InterruptedException_Exception {
        if (SB.restorePost(post.getId())) {
            return "success";
        } else {
            return "failed";
        }
    }
    
    public String publishPost(Post post) throws InterruptedException_Exception {
        if (SB.publishPost(post.getId())) {
            return "published";
        } else {
            return "failed";
        }
    }
    
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    
    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("***** partHeader: " + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                String filename = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                int extensionIndex = filename.lastIndexOf(".");
                String fileExtension = filename.substring(extensionIndex + 1);
                System.out.println(filename);
                return fileExtension;
            }
        }
        return null;
    }
    
    public String uploadFile(String username) throws IOException {

        // Extract file name from content-disposition header of file part
        java.util.Date date = new java.util.Date();
        Timestamp time = new Timestamp(date.getTime());
        String fileName = username + "_" + time.toString().replace(' ', '_').replace(':', '-') + "." + getFileName(part);
        System.out.println("***** fileName: " + fileName);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        String basePath = facesContext.getExternalContext().getRealPath("") + File.separator + "upload" + File.separator;
        File outputFilePath = new File(basePath + fileName);

        // Copy uploaded file to destination path
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = part.getInputStream();
            outputStream = new FileOutputStream(outputFilePath);

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            //statusMessage = "File upload successfull !!";
        } catch (IOException e) {
            e.printStackTrace();
            //statusMessage = "File upload failed !!";
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return fileName;    // return to same page
    }
    
    public static void main(String args[])
    {
        PostData pd = new PostData();
        Post post = pd.getPost("-JdQD1UvqoUkCUS-Mv8u");
    }
}
