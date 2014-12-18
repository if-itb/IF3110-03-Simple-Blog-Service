<!DOCTYPE html>
<?php 
require_once('firebaseLib.php');
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
		<?php
		$postsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/posts");
		$usersDB = new Firebase("https://blazing-torch-8839.firebaseio.com/users");
		$commentsDB = new Firebase("https://blazing-torch-8839.firebaseio.com/comments");
		
		$test = $postsDB->get(1);
		echo $test;
		?>
    </body>
</html>
