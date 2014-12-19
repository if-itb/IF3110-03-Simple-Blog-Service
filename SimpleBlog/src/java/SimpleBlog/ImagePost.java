package SimpleBlog;

import java.sql.Date;
import java.sql.Time;

public class ImagePost {
    public int id;
    public String pesan;
    public Date tanggal;
    public Time waktu;
    public Object gambar;
  
    public ImagePost()
    {
        
        id=0;
        pesan = null;
        tanggal=null;
        waktu=null;
        gambar=null;
    }
    
    public ImagePost(int _id,String _pesan, Date _tanggal, Time _waktu, Object _gambar)
    {
        id=_id;
        tanggal = _tanggal;
        waktu = _waktu;
        gambar=_gambar;
    }
    
    public void setImagePost(int _id,String _pesan, Date _tanggal, Time _waktu, Object _gambar)
    {
      id=_id;
        tanggal = _tanggal;
        waktu = _waktu;
        gambar=_gambar;
    }
}
