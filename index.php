<html>
	<script src='https://cdn.firebase.com/v0/firebase.js'></script>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js'></script>
	<head>
		<title> Penguasa Dunia </title>
	</head>
	<body>
		Search Blog Post <br/>
		<input type='text' id='keyword' placeholder='keyword'> </input>
		<input type='text' id='tbl_name' placeholder='tabel_name'> </input>
		<script>		
			/*$('#keyword').keypress(function (e) {
				alert('cibai');
				myDataRef.once('value', function(snap) {
					var msg = snap.val();
					jQuery.each(msg, function() {
						alert (this.judul);
					});
				});
			
			});*/
			
			$('#tbl_name').keypress(function (e) {
				if (e.keyCode == 13) {
					alert('cibai');
					var tbl_name = document.getElementById('tbl_name').value;
					var ref_val = document.getElementById('keyword').value;
					
					//fetchData(tbl_name, ref_val); 
					//updatePost();
					//addNewUser();
					deleteUser();
				}
			});
			
			function fetchData(tbl_name, ref_val) {
				var myDataRef = new Firebase('https://luminous-inferno-4376.firebaseio.com/'+tbl_name+'/');
				alert('cibai 2');
				myDataRef.once('value', function(snap) {
					var msg = snap.val();
					jQuery.each(msg, function() {
						if (this.id_user == ref_val) {
							alert(this.username);
						}
					});
				});
			}
			
			function updatePost() {
				var myDataRef = new Firebase('https://luminous-inferno-4376.firebaseio.com/posts/');
				alert('cibai 2');
				var updateThis = myDataRef.child("0");
				updateThis.update({
					"judul": "wira ganteng banget aaah"
				});
			}
			
			function addNewUser() {
				var myDataRef = new Firebase('https://luminous-inferno-4376.firebaseio.com/users/');
				alert('cibai 2');
				myDataRef.child("4").set({ //1 adalah index user yang baru
					email : "cibailang@gmail.com",
					id_user : "5",
					password : "cibailang",
					role : "admin",
					username : "cibai"
				});
			}
			
			function deleteUser() {
				var myDataRef = new Firebase('https://luminous-inferno-4376.firebaseio.com/users/');
				alert('cibai 2');
				myDataRef.child("4").remove();
			}
			
		</script>
		<div id='messagesDiv'></div>
	</body>
</html>