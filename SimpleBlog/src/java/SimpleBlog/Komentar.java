package SimpleBlog;

import java.sql.Timestamp;

public class Komentar {
    
    public int idPost;
    public int idKomentar;
    public String nama;
    public String email;
    public Timestamp tanggal;
    public String komentar;
    
    public Komentar(int _idPost, int _idKomentar,  String _nama, String _email, Timestamp _tanggal, String _komentar)
    {
        idPost=_idPost;
        idKomentar=_idKomentar;
        nama=_nama;
        email=_email;
        tanggal=_tanggal;
        komentar=_komentar;
    }
}
