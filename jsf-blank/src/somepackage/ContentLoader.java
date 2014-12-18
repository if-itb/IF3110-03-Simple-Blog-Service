package somepackage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.chamerling.heroku.service.Content;
import org.chamerling.heroku.service.HelloService;
import org.chamerling.heroku.service.HelloServiceImplService;

@ManagedBean (name="contentLoader", eager=true)
public class ContentLoader {
	
	private Connector con;
	private ArrayList<Content> posting, publishedPost, deletedPost;
	private List<Content> unpublishedPost;
	private Content currentContent;
	public static String staticCurrentID;	
	HelloService tes;
	public ContentLoader() {
		tes = new HelloServiceImplService().getHelloServiceImplPort();
		try {
			con = new Connector("db_simple_blog", "root","");
			listPosting();
			addPublishedPost();
			addUnpublishedPost();
			addDeletedPost();
			changeCurrentContent(staticCurrentID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Content> getPosting() {
		return posting;
	}
	
	public ArrayList<Content> getPublishedPost() {
		return publishedPost;
	}
	public List<org.chamerling.heroku.service.Content> getUnpublishedPost() {
		return unpublishedPost;
	}
	public ArrayList<Content> getDeletedPost(){
		return deletedPost;
	}
	public void setPosting(ArrayList<Content> posting) {
		this.posting = posting;
	}

	public Content getCurrentContent() {
		return currentContent;
	}
	public void setCurrentContent(Content content) {
		currentContent = content;
	}
	
	public String toContentPage(String ID) {
		staticCurrentID = ID;
		return("konten?faces-redirect=true");
	}
	public String toEditPage(String ID){
		staticCurrentID = ID;
		return("edit?faces-redirect=true");
	}
	
	private void listPosting() throws SQLException {
		posting = new ArrayList<>();
		posting = (ArrayList<Content>) tes.loadPost();
		/*try (ResultSet rs = con.executeQuery("select * from tbl_posting order by `tanggal` desc")) {
			while(rs.next()) {
				Content temp = new Content();
				temp.setJudul(rs.getString("judul"));
				temp.setContent(rs.getString("konten"));
				temp.setTanggal(rs.getString("tanggal"));
				temp.setID(rs.getString("id_post"));				
				temp.setPublished(rs.getString("status_published"));
				temp.setDeleted(rs.getString("status_delete"));
				
				posting.add(temp);
			}
		}		
		con.closeConnection();*/
	}
	
	private void addPublishedPost() {
		publishedPost = new ArrayList<>();
		for (Content content : posting) {
			if(content.getPublished().equals("1") && content.getDeleted().equals("0"))
				publishedPost.add(content);
		}
	}
	
	private void addUnpublishedPost() {
		unpublishedPost = new ArrayList<>();
		for (Content content : posting) {
			if(content.getPublished().equals("0") && content.getDeleted().equals("0"))
				unpublishedPost.add(content);
		}
	}
	
	private void addDeletedPost() {
		deletedPost = new ArrayList<>();
		for (Content content : posting) {
			if (content.getDeleted().equals("1"))
				deletedPost.add(content);
		}
	}
	
	public String editPost() {
//		int id=currentContent.getID();
//		String judul="'" + posting.get(currentIdx).getJudul() + "'";
//		String content="'" + posting.get(currentIdx).getContent() + "'";
//		String tanggal="'" + posting.get(currentIdx).getTanggal() + "'";
		
//		String judul="'" + currentContent.getJudul() + "'";
//		String content="'" + currentContent.getContent() + "'";
//		String tanggal="'" + currentContent.getTanggal() + "'";
		
		tes.editPost(currentContent.getID(), currentContent.getJudul(), 
				currentContent.getTanggal(), currentContent.getContent());
		return("index?faces-redirect=true");
	}
	
	private void changeCurrentContent(String id) {
		for (Content content : posting) {
			if (content.getID().equals(id)) {
				currentContent = content;
				staticCurrentID = id;
				break;
			}
		}
	}
	
	

//	public String deletePost(String ID) throws SQLException {
////		staticCurrentID = ID;
////		String id=currentContent.getID();
//		//System.out.println(id);
//		tes.deletePost(ID);
//		return("index?faces-redirect=true");
//	}
	
	public String deletePostTemp(String ID) {
//		con.executeUpdate("UPDATE tbl_posting SET status_delete= 1 WHERE id_post=" + ID);
		tes.deletePost(ID);
		return("index?faces-redirect=true");
	}
	public String publishPost(String ID) {
//		con.executeUpdate("UPDATE tbl_posting SET status_published= 1 WHERE id_post=" + ID);
		tes.publishPost(ID);
		return("index?faces-redirect=true");
	}
	public String restorePost(String ID) throws SQLException {
//		con.executeUpdate("UPDATE tbl_posting SET status_published = 0, status_delete= 0 WHERE id_post=" + ID);
		tes.restoreDeletedPost(ID);
		return("index?faces-redirect=true");
	}
}