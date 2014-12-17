/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.util.ArrayList;
import java.util.List;
import model.Comment;
import model.Post;
import model.User;
import org.ccw.heroku.service.CommentModel;
import org.ccw.heroku.service.PostModel;
import org.ccw.heroku.service.UserModel;

/**
 *
 * @author christangga
 */
public class MySQL {
	public MySQL() {
	}

	// <editor-fold defaultstate="collapsed" desc="User">
	public boolean createUser(String email, String username, String password, String role) {
		return new RMIUser().createUser(email, username, password, role);
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		List<UserModel> userModels = new RMIUser().getAllUsers();
		if(userModels != null) {
			for(UserModel userModel : userModels) {
				User user = new User();
				user.setUserFromUsermodel(userModel);
				users.add(user);
			}
		}
		return users;
	}

	public User getUser(String id) {
		User user = new User();
		UserModel userModel = new RMIUser().getUser(id);
		user.setUserFromUsermodel(userModel);
		return user;
	}

	public boolean updateUser(String id, String email, String username, String password, String role) {
		return new RMIUser().updateUser(id, email, username, password, role);
	}

	public boolean deleteUser(String id) {
		return new RMIUser().deleteUser(id);
	}
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="Post">
	public String createPost(String title, long date, String content) {
		String id = new RMIPost().createPost(title, date, content);
		return id;
	}

	public List<Post> getAllPublishedPosts() {
		List<Post> posts = new ArrayList<>();
		List<PostModel> postModels = new RMIPost().getAllPublishedPosts(); //ingat ganti
		if (postModels != null) {
			for(PostModel pm : postModels) {
				Post p = new Post();
				p.setPostFromPostmodel(pm);
				posts.add(p);
			}
		}
		return posts;
	}

	public List<Post> getAllUnpublishedPosts() {
		List<Post> posts = new ArrayList<>();
		List<PostModel> postModels = new RMIPost().getAllUnpublishedPosts();
		if (postModels != null) {
			for(PostModel pm : postModels) {
				Post p = new Post();
				p.setPostFromPostmodel(pm);
				posts.add(p);
			}
		}
		return posts;
	}

	public List<Post> getAllDeletedPosts() {
		List<Post> posts = new ArrayList<>();
		List<PostModel> postModels = new RMIPost().getAllDeletedPosts();
		if (postModels != null) {
			for(PostModel pm : postModels) {
				Post p = new Post();
				p.setPostFromPostmodel(pm);
				posts.add(p);
			}
		}
		return posts;
	}

	public Post getPost(String id) {
		Post post = new Post();
		PostModel postModel = new RMIPost().getPost(id);
		post.setPostFromPostmodel(postModel);
		return post;
	}

	public boolean updatePost(String id, String title, long date, String content, boolean status) {
		return new RMIPost().updatePost(id, title, date, content, status);
	}

	public boolean deletePost(String id) {
		return new RMIPost().deletePost(id);
	}

	public boolean restorePost(String id) {
		return new RMIPost().restorePost(id);
	}
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="Comment">
	public boolean createComment(String post_id, String name, String email, String comment) {
		return new RMIComment().createComment(post_id, name, email, comment);
	}

	public List<Comment> getAllComments(String post_id) {
		List<Comment> comments = new ArrayList<>();
		List<CommentModel> commentModels = new RMIComment().getAllComments(post_id);
		if (commentModels != null) {
			for(CommentModel commentModel : commentModels) {
				Comment comment = new Comment();
				comment.setCommentFromCommentmodel(commentModel);
				comments.add(comment);
			}
		}
		return comments;
	}
	// </editor-fold>
}
