/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lingga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jelink
 */

@ManagedBean(name="postlist",eager=true)
@SessionScoped
public class PostList {
    private ArrayList <Post> listPos;
    private ArrayList <Post> unlistPos;
    private ArrayList <Post> trashPos;
    
    public void initPostList(DBConnector dbc){
        listPos = new ArrayList<Post>(dbc.listPost("true"));
	unlistPos = new ArrayList<Post>(dbc.listPost("false"));
	trashPos = new ArrayList<Post>(dbc.listPost("deleted"));
    }

    public Post getPost(int n){
        return listPos.get(n);
    }

    public ArrayList<Post> getListPos(User us) {
	return listPos;
    }
    
    public ArrayList<Post> getUnlistPos(User us) {
	if(us.getType()==2 || us.getType()==3){
	    return unlistPos;
	}
	else{
	    return null;
	}
    }
    
    public ArrayList<Post> getSearchResults(String query, DBConnector dbc){
	List<simpleblog.Posting> lp = dbc.search(query);
	ArrayList<Post> retval = new ArrayList<Post>();
	for (simpleblog.Posting p : lp){
	    Post pc = new Post(p.getId(), p.getJudul(), dbc.gregToString(p.getTanggal(),"yyyy-MM-dd"), p.getKonten(), p.getPublished());
	    retval.add(pc);
	}
	Collections.sort(retval);
	return retval;
    }
    
    public ArrayList<Post> getTrashPos(User us) {
	if(us.getType()==3){
	    return trashPos;
	}
	else{
	    return null;
	}
    }
    
    public static ArrayList<Post> sort(ArrayList<Post> pl){
	Collections.sort(pl);
	return pl;
    }
}
