function cekTanggal()
{
    var tanggalpost = document.getElementById("Tanggal").value;
    var tanggalkini = new Date();
    var tanggal = tanggalkini.getDate();
    var bulan = tanggalkini.getMonth()+1;
    var tahun = tanggalkini.getFullYear();
    var tgl = tanggalpost.split("-");
    var tgl2 = parseInt(tgl[2]);
    var tgl1 = parseInt(tgl[1]);
    var tgl0 = parseInt(tgl[0]);
    if(tgl0==tahun)
    {
        if(tgl1==bulan)
        {
            if(tgl2==tanggal)
            {
                return true;
            }
            else if(tgl2<tanggal)
            {
                alert("Tanggal harus lebih besar atau sama dengan tanggal hari ini!");
                return false;
            }
            else
            {
                return true
            }
        }
        else if(tgl1<bulan)
        {
            alert("Tanggal harus lebih besar atau sama dengan tanggal hari ini!");
            return false;
        }
        else
        {
            return true
        }
    }
    else if(tgl0<tahun)
    {
        alert("Tanggal harus lebih besar atau sama dengan tanggal hari ini!");
        return false;
    }
    else
    {
        return true
    }
}