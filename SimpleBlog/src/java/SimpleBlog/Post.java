package SimpleBlog;

import java.sql.Date;
import java.sql.Time;

public class Post {
    public int idPost;
    public int id;
    public String judul;
    public Date tanggal;
    public Time waktu;
    public String konten;
    public boolean publish;
  
    public Post()
    {
        idPost=0;
        id=0;
        judul=null;
        tanggal=null;
        waktu=null;
        konten=null;
        publish=false;
    }
    
    public Post(int _idPost, int _id, String _judul, Date _tanggal, Time _waktu, String _konten, boolean _publish)
    {
        idPost=_idPost;
        id=_id;
        judul=_judul;
        tanggal=_tanggal;
        waktu=_waktu;
        konten=_konten;
        publish=_publish;
    }
    
    public void setPost(int _idPost, int _id, String _judul, Date _tanggal, Time _waktu, String _konten, boolean _publish)
    {
        idPost=_idPost;
        id=_id;
        judul=_judul;
        tanggal=_tanggal;
        waktu=_waktu;
        konten=_konten;
        publish=_publish;
    }
}
