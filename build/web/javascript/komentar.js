function checkform()
{
    if(document.getElementById("Nama").value!="" && document.getElementById("Email").value!= "" &&
     document.getElementById("Komentar").value!= "")
    {
        return true;
    }
    else
    {
        return false;
    }
}

function checkemail()
{
    var foundAt= document.getElementById("Email").value.indexOf("@");
    var foundDot= document.getElementById("Email").value.lastIndexOf(".");
   
    if(foundAt!= -1 && foundDot!= -1 && foundAt+1<foundDot && foundAt>0 && foundDot+1<document.getElementById("Email").value.length)
    {
        return true;
    }
    else
    {
        alert("Email tidak valid!");
        return false;
    }
}

function get_komentar()
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("Tempat_Komentar").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","get_comment?idPost="+ document.getElementById("ID").value,true);

    xmlhttp.send();
}

function post_komentar()
{
    if(checkform())
    {
        if(checkemail())
        {
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    get_komentar();
                    document.getElementById("Nama").value="";
                    document.getElementById("Email").value="";
                    document.getElementById("Komentar").value="";
                }
            }
            var ID=document.getElementById("ID").value;
            var Nama=document.getElementById("Nama").value;
            var Email=document.getElementById("Email").value;
            var Komentar=document.getElementById("Komentar").value;
       
            xmlhttp.open("POST","add_comment",true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("idPost="+ ID+ "&Nama="+ Nama +"&Email=" + Email + "&Komentar=" + Komentar);
        }
        else
        {
            alert("Email not valid");
        }
    }
    else
    {
        alert("Tidak bisa post komentar kosong");
    }
    return false;
    
}