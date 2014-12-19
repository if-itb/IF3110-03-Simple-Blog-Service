function loadcomment()
{
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            document.getElementById("load").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","getkomentar.php?id="+document.getElementById("ID").value,true);
    xmlhttp.send();
}

function addcomment()
{
    if(checkComment() && checkEmail(document.getElementById("Email").value))
    {
        var xmlhttp=new XMLHttpRequest();
        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                document.getElementById("load").innerHTML=xmlhttp.responseText;
                loadcomment();
                document.getElementById("Nama").value="";
                document.getElementById("Email").value="";
                document.getElementById("Komentar").value="";
            }
        }
        xmlhttp.open("POST","add_comment.php",true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("ID="+document.getElementById("ID").value+" &Nama="+document.getElementById("Nama").value+" &Email="+document.getElementById("Email").value+" &Komentar="+document.getElementById("Komentar").value);
    }
    return false;
}