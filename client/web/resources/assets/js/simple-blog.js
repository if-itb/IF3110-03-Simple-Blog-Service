var oDoc, sDefTxt;

function initDoc() {
    oDoc = document.getElementById("textBox");
    sDefTxt = oDoc.innerHTML;
    if (document.getElementById('switchBox').checked) {
        setDocMode(true);
    }
    
    document.getElementById('textBox').innerHTML = document.getElementById('_post-form:konten').value;     
}

function formatDoc(sCmd, sValue) {
    if (validateMode()) {
        document.execCommand(sCmd, false, sValue);
        oDoc.focus();
    }
}

function validateMode() {
    if (!document.getElementById('switchBox').checked) {
        return true;
    }
    alert("Uncheck \"Show HTML\".");
    oDoc.focus();
    return false;
}

function setDocMode(bToSource) {
    var oContent;
    if (bToSource) {
        oContent = document.createTextNode(oDoc.innerHTML);
        oDoc.innerHTML = "";
        var oPre = document.createElement("pre");
        oDoc.contentEditable = false;
        oPre.id = "sourceText";
        oPre.contentEditable = true;
        oPre.appendChild(oContent);
        oDoc.appendChild(oPre);
    } else {
        if (document.all) {
            oDoc.innerHTML = oDoc.innerText;
        } else {
            oContent = document.createRange();
            oContent.selectNodeContents(oDoc.firstChild);
            oDoc.innerHTML = oContent.toString();
        }
        oDoc.contentEditable = true;
    }
    oDoc.focus();
}

function printDoc() {
    if (!validateMode()) {
        return;
    }
    var oPrntWin = window.open("", "_blank", "width=450,height=470,left=400,top=100,menubar=yes,toolbar=no,location=no,scrollbars=yes");
    oPrntWin.document.open();
    oPrntWin.document.write("<!doctype html><html><head><title>Print<\/title><\/head><body onload=\"print();\">" + oDoc.innerHTML + "<\/body><\/html>");
    oPrntWin.document.close();
}

document.addEventListener('DOMContentLoaded', function() {
    // call initDoc
    initDoc();
});
