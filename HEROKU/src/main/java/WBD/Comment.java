package WBD;

/**
 *
 * @author Asep Saepudin
 */
public class Comment {
    private int id;    
    private String name;
    private String email;
    private String tanggal;
    private String komentar;
    
    public Comment() { }
    public Comment(int id, String name, String email, String tanggal, String komentar) {
    	this.id = id;    	
    	this.name = name;
    	this.email = email;
    	this.tanggal = tanggal;
    	this.komentar = komentar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }    
}
