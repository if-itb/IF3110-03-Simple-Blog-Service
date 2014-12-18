package Model;

import java.sql.Timestamp;

/**
 * Representation of comment
 * @author Riva Syafri Rachmatullah
 */
public class Comment {
    private String name;
    private String email;
    private String content;
    private String time;
    
    /**
     * Create an empty instance of Post
     */
    public Comment()
    {
        name = "";
        email = "";
        content = "";
        time = null;
    }
    
    /**
     * Create an instance of comment
     * @param id id of comment
     * @param pid id of post
     * @param name name of commentator
     * @param email email of commentator
     * @param content content of comment
     * @param time time taken
     */
    public Comment(String name, String email, String content, String time) {
        this.name = name;
        this.email = email;
        this.content = content;
        this.time = time;
    }
    
    /**
     * Get name of commentator
     * @return name of commentator
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get email of commentator
     * @return email of commentator
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Get content of comment
     * @return content of comment
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Get time taken on comment
     * @return time taken on comment
     */
    public String getTime() {
        return time;
    }
    
    /**
     * Set name of commentator
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set name of commentator
     * @param email new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Set content of comment
     * @param content new content
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * Set time taken on comment
     * @param time new time of comment
     */
    public void setTime(String time) {
        this.time = time;
    }
}
