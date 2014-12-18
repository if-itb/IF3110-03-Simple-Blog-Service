<?php

if(basename($_SERVER['SCRIPT_FILENAME'])==basename(__FILE__))
	exit;

require_once('firebaseLib.php');

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
		$num = $this->_metaDB->get(posts);
		$num++;
		$data = array (
			"author" => $user,
			"title"   => $title,
			"content" => $content,
			"date" => $date,
			"published" => "0"
		);
		$this->_postsDB->push($num, $data);
		return true;
	}
	
	/**
	 * List Post
	 * 
	 * @return PostTypeArray
	 */
	function post_list() {
		$retval=Array();
		return $retval;
	}

	/**
	 * View Post
	 * 
	 * @param int $postid
	 * @return PostType
	 */
	function post_view($postid) {
		return new PostType();
	}

	/**
	 * Publish Post
	 * 
	 * @param int $postid
	 * @return boolean true is success
	 */
	function post_publish($postid) {
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
		return true;
	}

	/**
	 * Dekete Post
	 * 
	 * @param int $postid
	 * @return boolean true is success
	 */
	function post_del($postid) {
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
		return true;
	}

	/**
	 * Dekete Post
	 * 
	 * @param int $commentid
	 * @return boolean true is success
	 */
	function comment_delete($commentid) {
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
		return true;
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
		return true;
	}

	/**
	 * Delete User
	 * 
	 * @param string $username
	 * @return boolean true is success
	 */
	function user_delete($username) {
		return true;
	}

	/**
	 * Edit user role
	 * 
	 * @param string $username
	 * @param int $role
	 * @return boolean true is success
	 */
	function user_edit($username, $role) {
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
