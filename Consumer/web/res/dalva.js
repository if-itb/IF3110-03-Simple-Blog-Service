/*
 * dalva.js - property of dalva24.com
 * Copyright (C) 2014 Dalva
 * All Rights Reserved.
 */


var xmlhttp;
function ajaxGET(url,cfunc) { // Ajax Processor (not to be called from HTML)
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=cfunc;
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
	return xmlhttp;
}
function ajaxPOST(url,data,cfunc) { // Ajax Processor (not to be called from HTML)
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=cfunc;
	xmlhttp.open("POST",url,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(data);
	return xmlhttp;
}
function loadPage(url,eid) { // Ajax LoadPage Handler
	ajaxGET(url,function(){
		if (xmlhttp.readyState===4 && xmlhttp.status===200) {
			document.getElementById([eid]).innerHTML=xmlhttp.responseText;
		}
	});
}
function postComment(form,url,eid) { // Ajax LoadPage Handler
	var input = document.getElementById("EmailIn");
	var validformat=/^\S*@\S*\.\S*$/; //Basic check for format validity
	if (!validformat.test(input.value)) {
		alert("Invalid Email Format. Please correct and submit again.");
	} else {
		var data = "name=" + form.name.value + "&email=" + form.email.value + "&id=" + form.id.value + "&content=" + form.content.value;
		ajaxPOST(url, data, function(){
			if (xmlhttp.readyState===4 && xmlhttp.status===200) {
				document.getElementById([eid]).innerHTML=xmlhttp.responseText;
			}
		});
	}
	alert("Comment Posted");
	form.name.value="";
	form.email.value="";
	form.content.value="";
	return false;
}
