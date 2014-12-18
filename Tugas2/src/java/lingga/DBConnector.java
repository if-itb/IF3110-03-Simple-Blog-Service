/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lingga;

/**
 *
 * @author Jelink
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import simpleblog.Akun;
import simpleblog.Posting;

@ManagedBean(name="dbconnector",eager=true)
@SessionScoped
public class DBConnector {
    
    public DBConnector(){
	
    }
    
    //Verifikasi Login
    public String verify(User pengguna, CookieHandler ch){
	String username = pengguna.getName();
	String userpass = pengguna.getPassword();
	simpleblog.Akun user = getUser(username);
	System.out.println("passworduser : " + user.getPassword());
	System.out.println("passwordpengguna : " + userpass);

	if(user == null){
	    pengguna.setLoggedon(true);
	    pengguna.setName("Guest");
	    pengguna.setEmail("");
	    pengguna.setType(4);
	    return "";
	}
	try{
	    if(ch.getCookie("if3110_sb_uid")!=null){
		String sb_uid = ch.getCookie("if3110_sb_uid").getValue();
		//System.out.println("uid : " + sb_uid);
		pengguna.copy(selectUser(sb_uid));
		pengguna.setLoggedon(true);
		return "";
	    }
	    else if (user.getPassword().equals(userpass)) {
		System.out.println("success");
		// Handle user
		pengguna.setUserid(user.getUsername());
		pengguna.setLoggedon(true);
		pengguna.setName(username);
		pengguna.setType(user.getRole());
		pengguna.setEmail(user.getEmail());
		//System.out.println("masuk");
		// Handle cookie

		ch.setCookie("if3110_sb_uid", pengguna.getUserid(), 3600);
		return "";
	    }
	    else {
		pengguna.setLoggedon(true);
		pengguna.setName("Guest");
		pengguna.setEmail("");
		pengguna.setType(4);
		return "";
	    }
	}
	catch(NullPointerException e){
	    System.out.println("npe");
	    pengguna.setLoggedon(true);
	    pengguna.setName("Guest");
	    pengguna.setEmail("");
	    pengguna.setType(4);
	    return "";
	}
    }
    
    /* Mengambil salah satu isi post */
    public Post selectPost(String pid){
	simpleblog.Posting pos = getPost(pid);
	String judul = pos.getJudul();//rs.getString("judul");
	String tanggal = gregToString(pos.getTanggal(),"yyyy-MM-dd");//rs.getString("tanggal");
	String konten = pos.getKonten();//rs.getString("konten");
	int published = pos.getPublished();//(rs.getInt("published")==1);
	return new Post(pid,judul,tanggal,konten,published);
    }
    
    /* Mengambil salah satu user */
    public User selectUser(String uid){
	simpleblog.Akun ak = getUser(uid);
	return new User(ak.getUsername(),ak.getUsername(),ak.getPassword(),ak.getEmail(),ak.getRole());
    }
    
    /* String to XMLGregorian
    */
    public static XMLGregorianCalendar 
    convertStringDateToXmlGregorianCalendar( String dateStr, String dateFormat, boolean noTimezone )
    {
        try
        {
            // this may throw DatatypeConfigurationException
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            GregorianCalendar calendar = new GregorianCalendar();
            // reset all fields
            calendar.clear();
 
            Calendar parsedCalendar = Calendar.getInstance();
            // eg "yyyy-MM-dd"
            SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
            // this may throw ParseException
            Date rawDate = sdf.parse( dateStr );
            parsedCalendar.setTime( rawDate );
 
            // set date from parameter and leave time as default calendar values
            calendar.set( parsedCalendar.get( Calendar.YEAR ), 
                            parsedCalendar.get( Calendar.MONTH ),
                            parsedCalendar.get( Calendar.DATE ) );
 
            XMLGregorianCalendar xmlCalendar = datatypeFactory.newXMLGregorianCalendar( calendar );
            // clears default timezone
            if ( noTimezone )
            {
                xmlCalendar.setTimezone( DatatypeConstants.FIELD_UNDEFINED );
            }
 
            return xmlCalendar;
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }
    
    
    /* Menambahkan Post ke Database */
    public String insertPost(User pengguna, Post p){
	if(pengguna.isLoggedon() && (pengguna.getType()==1 || pengguna.getType()==3)){
	    addPost(p.judul, p.konten, convertStringDateToXmlGregorianCalendar(p.tanggal, "yyyy-MM-dd", true));
	    
	    return "Unpublished_Posts.xhtml?faces-redirect=true";
	}
	return null;
    }
    
    /* Menambahkan User ke Database */
    public String insertUser(User pengguna, User p){
	if(pengguna.isLoggedon() && pengguna.getType()==3){
	    /*try {
		st = con.createStatement();
		String query = "SELECT COUNT(username) AS c FROM `sb_users` WHERE `username`='" + p.getName() + "'";
		//System.out.println(query);
		rs = st.executeQuery(query);
		rs.next();
		System.out.println(" >>" + rs.getString("c") + "<<");
		if(rs.getString("c").equals("0")){
		    query = "INSERT INTO `sb_users`(`username`, `password`, `email`, `type`) VALUES ('" + p.getName() + "','" + p.getPassword() + "','" + p.getEmail() + "','" + p.getType() + "')";

		    System.out.println(query);
		    pst = con.prepareStatement(query);
		    pst.executeUpdate();
		    return "User_Management.xhtml?faces-redirect=true";
		}
		else return "?faces-redirect=true&success=no";
	    } catch (SQLException ex) {
		Logger lgr = Logger.getLogger(DBConnector.class.getName());
		lgr.log(Level.SEVERE, ex.getMessage(), ex);
	    } catch (Throwable e){
	    }
	    System.out.println("bocor");*/
	    addUser(p.getName(), p.getEmail(), p.getPassword(), p.getType());
	    return "User_Management.xhtml?faces-redirect=true";
	}
	return null;
    }
    
    /* Menambahkan Komentar ke Database */
    public void insertComment(User pengguna, Comment c){
	addComment(c.getPost_id(), c.getNama(), c.getEmail(), c.getKomentar());
    }
    
    /* Mengupdate Post di Database */
    public String updatePost(User pengguna, Post p){
	if(pengguna.isLoggedon() && pengguna.getType()<=3){
	    editPost(p.id_post, p.judul, p.konten, convertStringDateToXmlGregorianCalendar(p.tanggal , "yyyy-MM-dd", true), p.published);
	    return "Published_Posts?faces-redirect=true";
	}
	return null;
    }
    
    /* Mengupdate User di Database */
    public String updateUser(User admin, User p){
	if(admin.isLoggedon() && admin.getType()==3){
	    if(p.getName() == p.getEditedName())
		editUser(0, p.getName(), p.getEmail(), p.getPassword(), p.getType());
	    else{
		deleteUser_1(p.getEditedName());
		addUser(p.getName(), p.getEmail(), p.getPassword(), p.getType());
	    }
	    return "faces/User_Management.xhtml?faces-redirect=true";
	}
	return null;
    }
    
    /* Mendelete User di Database */
    public String deleteUser(User admin, User p){
	if(admin.isLoggedon() && admin.getType()==3){
	    deleteUser_1(p.getName());
	}
	return "faces/User_Management.xhtml?faces-redirect=true";
    }
    
    /* Mendelete Post di Database */
    public String deletePost(User pengguna, String pid){
	if(pengguna.isLoggedon() && pengguna.getType()<=3){
	    System.out.println("hapus " + pid);
	    /*try {
		String query = "DELETE FROM `sb_posts` where `id_post`='" + pid + "';";
		pst = con.prepareStatement(query);
		pst.executeUpdate();
		return "faces/Published_Posts.xhtml?faces-redirect=true";
	    } catch (SQLException ex) {
		Logger lgr = Logger.getLogger(DBConnector.class.getName());
		lgr.log(Level.SEVERE, ex.getMessage(), ex);
	    } catch (Throwable e){
	    }*/
	    deletePost_1(pid);
	    return "faces/Published_Posts.xhtml?faces-redirect=true";
	}
	return null;
    }
    
    /* Mempublish Post */
    public String publishPost(User pengguna, Post p){
	if(pengguna.isLoggedon() && (pengguna.getType()==3 || pengguna.getType()==2)){
	    //String query = "UPDATE `sb_posts` SET `published`=1 WHERE `id_post`=" + p.id_post + ";";
	    //System.out.println(query);
	    //pst = con.prepareStatement(query);
	    //pst.executeUpdate();
	    
	    publishPost_1(p.id_post, 1);
	    
	    return "Published_Posts?faces-redirect=true";
	}
	return null;
    }
    
    /* SoftDelete Post */
    public String softDeletePost(User pengguna, String pid){
	if(pengguna.getType()!=4){
	    System.out.println("hapus soft " + pid);
	    /*try {
		String query = "UPDATE `sb_posts` SET `published`=2 WHERE `id_post`=" + pid + ";";
		System.out.println(query);
		pst = con.prepareStatement(query);
		pst.executeUpdate();
		return "Published_Posts?faces-redirect=true";
	    } catch (SQLException ex) {
		Logger lgr = Logger.getLogger(DBConnector.class.getName());
		lgr.log(Level.SEVERE, ex.getMessage(), ex);
	    } catch (Throwable e){
	    }*/
	    publishPost_1(pid, 2);
	    return "Published_Posts?faces-redirect=true";
	}
	return null;
    }
    
    /* Restore Post */
    public String restorePost(User pengguna, String pid){
	if(pengguna.getType()==3){
	    /*try {
		String query = "UPDATE `sb_posts` SET `published`=0 WHERE `id_post`=" + pid + ";";
		System.out.println(query);
		pst = con.prepareStatement(query);
		pst.executeUpdate();
		return "Published_Posts?faces-redirect=true";
	    } catch (SQLException ex) {
		Logger lgr = Logger.getLogger(DBConnector.class.getName());
		lgr.log(Level.SEVERE, ex.getMessage(), ex);
	    } catch (Throwable e){
	    }*/
	    publishPost_1(pid, 0);
	    return "Unpublished_Posts?faces-redirect=true";
	}
	return null;
    }
    
    /* Mengambil seluruh isi post */
    public ArrayList<Post> listPost(String pub){
	//st = con.createStatement();
	int pubs=0;
	if(pub=="true") pubs=1;
	else if(pub=="false") pubs=0;
	else if(pub=="deleted") pubs=2;

	ArrayList<Post> retval = new ArrayList<Post>();
	java.util.List<simpleblog.Posting> lp = listPost_1();
	System.out.println("jumlah pos : " + lp.size());
	for(simpleblog.Posting p : lp){
	    //published posts
	    if(p.getPublished() == pubs){
		String id_post = p.getId();
		String judul = p.getJudul();
		String tanggal = gregToString(p.getTanggal(),"yyyy-MM-dd");
		String konten = p.getKonten();
		int published = p.getPublished();
		retval.add(new Post(id_post, judul, tanggal, konten, published));
	    }
	}
	retval = PostList.sort(retval);
	return retval;
    }
    
    /* Mengambil seluruh isi komentar pos ini */
    public ArrayList<Comment> listComment(String pid){	
	ArrayList<Comment> retval = new ArrayList<Comment> ();
	
	java.util.List<simpleblog.Komentar> kl = listComment_1(pid);
	System.out.println("jumlah komentar : " + kl.size() + " " + pid + " ");
	for(simpleblog.Komentar c : kl){
		Comment cmt = new Comment(c.getId(), c.getNama(), c.getEmail(), c.getKomen(), gregToString(c.getTime(),"yyyy-MM-dd hh:mm"), pid);
		retval.add(cmt);
	}
	Collections.reverse(retval);
	return retval;
    }
    
    public String gregToString(XMLGregorianCalendar dx, String format){
	Calendar calendar = dx.toGregorianCalendar();
	SimpleDateFormat formatter = new SimpleDateFormat(format);
	formatter.setTimeZone(calendar.getTimeZone());
	String dateString = formatter.format(calendar.getTime());
	return dateString;
    }
    
    /* Crud */
    public ArrayList<User> listUser(User pengguna){
	if(pengguna.isLoggedon() && pengguna.getType()==3){
	    if(pengguna.getType()==3){
		ArrayList<User> retval = new ArrayList<User>();
		for(simpleblog.Akun pg : listUser_1()){
		    User us = new User(pg.getUsername(), pg.getUsername(), pg.getPassword(), pg.getEmail(), pg.getRole());
		    retval.add(us);
		}
		return retval;
	    }
	}
	return null;
    }

    private static java.util.List<simpleblog.Posting> listPost_1() {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.listPost();
    }

    private static Posting getPost(java.lang.String postId) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.getPost(postId);
    }

    private static Boolean addPost(java.lang.String judul, java.lang.String konten, javax.xml.datatype.XMLGregorianCalendar tanggal) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.addPost(judul, konten, tanggal);
    }

    private static Boolean publishPost_1(java.lang.String id, int published) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.publishPost(id, published);
    }

    private static Boolean deletePost_1(java.lang.String id) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.deletePost(id);
    }

    private static Boolean editPost(java.lang.String id, java.lang.String judul, java.lang.String konten, javax.xml.datatype.XMLGregorianCalendar tanggal, int published) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.editPost(id, judul, konten, tanggal, published);
    }

    private static java.util.List<simpleblog.Komentar> listComment_1(java.lang.String idPost) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.listComment(idPost);
    }

    private static Boolean addComment(java.lang.String idPost, java.lang.String nama, java.lang.String email, java.lang.String konten) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.addComment(idPost, nama, email, konten);
    }

    private static Akun getUser(java.lang.String username) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.getUser(username);
    }

    private static java.util.List<simpleblog.Akun> listUser_1() {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.listUser();
    }

    private static Boolean editUser(int id, java.lang.String nama, java.lang.String email, java.lang.String password, int role) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.editUser(id, nama, email, password, role);
    }

    private static Boolean deleteUser_1(java.lang.String id) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.deleteUser(id);
    }

    private static Boolean addUser(java.lang.String nama, java.lang.String email, java.lang.String password, int role) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.addUser(nama, email, password, role);
    }

    public static java.util.List<simpleblog.Posting> search(java.lang.String query) {
	simpleblog.Simpleblogws_Service service = new simpleblog.Simpleblogws_Service();
	simpleblog.Simpleblogws port = service.getSimpleblogwsPort();
	return port.search(query);
    }
}