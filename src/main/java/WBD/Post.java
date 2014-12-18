package WBD;

/**
 *
 * @author Asep Saepudin
 */
public class Post {
    private int id;
    private String judul;
    private String tanggal;
    private String konten;
    private String status;
    private String image;
    
    public Post() { }
    public Post(int id, String judul, String tanggal, String konten, String status) {
    	this.id = id;
    	this.judul = judul;
    	this.tanggal = tanggal;
    	this.konten = konten;
    	this.status = status;
    	this.image = "";
    }
    public Post(int id, String judul, String tanggal, String konten, String status, String image) {
    	this.id = id;
    	this.judul = judul;
    	this.tanggal = tanggal;
    	this.konten = konten;
    	this.status = status;
    	this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }        
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
