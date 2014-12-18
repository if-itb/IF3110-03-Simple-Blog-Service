package lingga;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jelink
 */
@ManagedBean(name="post",eager=true)
@SessionScoped
public class Post implements Comparable {
    String id_post;
    String judul;
    String tanggal;
    String konten;
    int published;
    boolean isReadMore=false;
    
    public Post(){
	
    }
    
    public void copy(Post p){
	id_post = p.id_post;
	judul = p.judul;
	tanggal = p.tanggal;
	konten = p.konten;
	published = p.published;
    }
    
    public void makeEmpty(){
	judul = tanggal = konten = null;
	published = 1;
    }

    public Post(String id_post, String judul, String tanggal, String konten, int published) {
        this.id_post = id_post;
        this.judul = judul;
        this.tanggal = tanggal;
        this.konten = konten;
        this.published = published;
    }

    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    /*public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }*/
    
    public void setTanggal(String tanggal){
	this.tanggal = tanggal;
    }

    public String getKonten() {
        return konten;
    }
    
    public String getExcerptHTML(int n) {
	List<String> l = new ArrayList<String>();
	int pos = 0;
	boolean br = false;
	while (l.size() < n && !br) {
	    int excerpt = konten.indexOf(' ', pos);
	    if (excerpt == -1) {
		l.add(konten.substring(pos));
		br=true;
	    }
	    if(!br){
		l.add(konten.substring(pos, excerpt));
		pos = excerpt + 1;
	    }
	}
	String retval="";
	for(String word : l){
	    retval = retval + ' ' + word;
	}
	//System.out.println(">>>"+l.size()+" " + n);
	if(l.size()<n){ 
	    this.isReadMore = false;
	    return retval.replace("\n", " ");
	}
	else{
	    this.isReadMore = true;
	    return retval.replace("\n", " ")+". . .";
	}
	
    }
    
    public String getKontenHTML(){
	return konten.replace("\n", "<br />");
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }
    
    public String editButton(int role){
	if (!(role==2 || role==3 || (role==1 && published==1))) return "none";
	else return "block-inline";
    }
    
    public String showPost(int role){
	if (role == 1 && published == 1) return "";
	else if (role == 2 && published == 0) return "";
	else if (role == 2 && published == 1) return "";
	else if (role == 3) return "";
	else if (role == 4 && published == 1) return "";
	else return "invisiblePost";
    }
    
    public String publishButton(int role){
	if(published==1 || role==1 || role==4) return "none";
	else return "block-inline";
    }
    
    public String deleteButton(int role){
	if(role==4) return "none";
	else return "block-inline";
    }
    
    public String hardDeleteButton(int role){
	if(role==3) return "block-inline";
	else return "none";
    }
    
    public String readMoreButton(){
	
	if(!isReadMore){ 
	    System.out.println("none");
	    return "none";
	}
	else{
	    return "block-inline";
	}
    }

    @Override
    public int compareTo(Object other) {
	Post otherPost = (Post) other;
	int last = otherPost.tanggal.compareTo(this.tanggal);
        return last == 0 ? this.tanggal.compareTo(otherPost.tanggal) : last;
    }
    
}