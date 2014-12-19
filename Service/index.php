<!DOCTYPE html>
<?php 
require_once('class.SimpleBlogSoap.php');
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
		<h1>SimpleBlog SOAP API - Firebase Test Page</h1>
		<h2>access api at <a href="http://simpleblogdarieza.herokuapp.com/api.php" >http://simpleblogdarieza.herokuapp.com/api.php</a></h2><br/><br/>
		<?php $DBC = new SimpleBlogSoap(); ?>
		<h3>post_view test - post ID 1</h3>
		<?php
		$test = $DBC->post_view(1);
		echo $test->judul;
		echo " - ";
		echo $test->tanggal;
		echo " - ";
		echo $test->konten;
		?>
    </body>
</html>
