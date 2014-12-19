<?php

if(basename($_SERVER['SCRIPT_FILENAME'])==basename(__FILE__))
	exit;

require_once('firebaseLib.php');
require_once('class.PostType.php');

/**
 * the main service of this stuff
 * 
 * @service SimpleBlogSoap
 */
class SimpleBlogSoap{
	
	/**
	 *	
	 * @var Firebase
	 */
	private $_postsDB;
	/**
	 *	
	 * @var Firebase
	 */
	private $_usersDB;
	/**
	 *	
	 * @var Firebase
	 */
	private $_commentsDB;
		/**
	 *	
	 * @var Firebase
	 */
	private $_metaDB;
	
	function _construct() {
		$this->_postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$this->_usersDB = new Firebase("https://blazing-torch-8839.firebaseio.com/users");
		$this->_commentsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/comments");
		$this->_metaDB = new Firebase("https://blazing-torch-8839.firebaseio.com/meta");
	}

	/**
	 * New Post
	 * 
	 * @param string $user
	 * @param string $title
	 * @param string $date
	 * @param string $content
	 * @return boolean true is success
	 */
	function post_new($user, $title, $date, $content) {
		$metaDB = new Firebase("https://blazing-torch-8839.firebaseio.com/meta");
		$postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$num = $metaDB->get("postsNum");
		$num++;
		$data = array (
			"author" => $user,
			"title"   => $title,
			"content" => $content,
			"date" => $date,
			"published" => "0",
			"id" => $num
		);
		$postsDB->push($num, $data);
		return true;
	}
	
	/**
	 * List Post
	 * 
	 * @return PostTypeArray
	 */
	function post_list() {
		$postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$posts=json_decode($postsDB->get("/"), true);
		$retval = array();
		foreach ($posts as $post) {
			$postTyp = new PostType();
			$postTyp->id = $post['ID'];
			$postTyp->judul = $post['title'];
			$postTyp->konten = $post['content'];
			$postTyp->tanggal = $post['date'];
			$postTyp->isPublished= $post['published'];
			array_push($retval,$postTyp);
		}
		return $retval;
	}

	/**
	 * View Post
	 * 
	 * @param int $postid
	 * @return PostType
	 */
	function post_view($postid) {
		$postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$thisPost=json_decode($postsDB->get($postid), true);
		$retval = new PostType();
		$retval->id = $postid;
		$retval->judul = $thisPost['title'];
		$retval->konten = $thisPost['content'];
		$retval->tanggal = $thisPost['date'];
		$retval->isPublished= $thisPost['published'];
		return $retval;
	}

	/**
	 * Publish Post
	 * 
	 * @param int $postid
	 * @return boolean true is success
	 */
	function post_publish($postid) {
		$postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$post = $postsDB->get($postid);
		$post['published'] = 1;
		$postsDB->update($postid, $post);
		return true;
	}
	
	/**
	 * Edit Post
	 * 
	 * @param int $postid
	 * @param string $user
	 * @param string $title
	 * @param string $date
	 * @param string $content
	 * @return boolean true is success
	 */
	function post_edit($postid, $user, $title, $date, $content) {
		$postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$post = $postsDB->get($postid);
		$post['author'] = $user;
		$post['content'] = $content;
		$post['date'] = $date;
		$post['title'] = $title;
		$postsDB->update($postid, $post);
		return true;
	}

	/**
	 * Dekete Post
	 * 
	 * @param int $postid
	 * @return boolean true is success
	 */
	function post_del($postid) {
		$postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$postsDB->delete($postid);
		return true;
	}

	/**
	 * New Comment
	 * 
	 * @param int $postid
	 * @param string $message
	 * @param string $author
	 * @param string $date
	 * @param string $content
	 * @return boolean true is success
	 */
	function comment_add($postid, $message, $author, $date) {
		$commentsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/comments");
		$metaDB = new Firebase("https://blazing-torch-8839.firebaseio.com/meta");
		$num = $metaDB->get("commentsNum");
		$num++;
		$data = array (
			"name" => $author,
			"content" => $message,
			"date" => $date,
			"PID" => $postid
		);
		$commentsDB->push($num, $data);
		return true;
	}

	/**
	 * Dekete Post
	 * 
	 * @param int $commentid
	 * @return boolean true is success
	 */
	function comment_delete($commentid) {
		$commentsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/comments");
		$commentsDB->delete($commentid);
		return true;
	}

	/**
	 * User Login
	 * 
	 * @param string $username
	 * @param string $pass
	 * @return boolean true is success
	 */
	function user_login($username, $pass) {
		$usersDB = new Firebase("https://blazing-torch-8839.firebaseio.com/users");
		$user = $usersDB->get($username);
		if ($user['password'] === $pass) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add user
	 * 
	 * @param string $username
	 * @param string $pass
	 * @param int $role
	 * @return boolean true is success
	 */
	function user_add($username, $pass, $role) {
		$usersDB = new Firebase("https://blazing-torch-8839.firebaseio.com/users");
		$user = $usersDB->get($username);
		if (empty($user)) {
			$usersDB->push($username, $data);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Delete User
	 * 
	 * @param string $username
	 * @return boolean true is success
	 */
	function user_delete($username) {
		$usersDB = new Firebase("https://blazing-torch-8839.firebaseio.com/users");
		$user = $usersDB->get($username);
		if (!empty($user)) {
			$usersDB->delete($username);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Edit user role
	 * 
	 * @param string $username
	 * @param int $role
	 * @return boolean true is success
	 */
	function user_edit($username, $role) {
		$usersDB = new Firebase("https://blazing-torch-8839.firebaseio.com/users");
		$user = $usersDB->get($username);
		$user['type'] = $role;
		$usersDB->update($username, $user);
		return true;
	}

	/**
	 * Search
	 * 
	 * @param string $query the string to be searched for in title and content
	 * @return PostTypeArray
	 */
	function search($query) {
		$retval=Array();
		return $retval;
	}
}
