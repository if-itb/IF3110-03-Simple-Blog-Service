/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SPM
 */

package datatype;

public class post {
    public String idPost;
    public String id;
    public String judul;
    public String konten;
    public String tanggal;
    public int publish;
  
    public post()
    {
        idPost=null;
        id=null;
        judul=null;
        konten=null;
	tanggal = null;
        publish=0;
    }
    
    public post(String _idPost, String _id, String _judul, String _konten, String _tanggal)
    {
        idPost=_idPost;
        id=_id;
        judul=_judul;
        konten=_konten;
        publish=0;
	tanggal = _tanggal;
    }
    
    public void setPost(String _idPost, String _id, String _judul, String _konten, String _tanggal)
    {
        idPost=_idPost;
        id=_id;
        judul=_judul;
        konten=_konten;
        publish=0;
	tanggal = _tanggal;
    }
}
