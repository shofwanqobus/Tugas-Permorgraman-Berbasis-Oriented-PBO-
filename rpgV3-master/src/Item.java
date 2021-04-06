import java.util.ArrayList;

public class Item {
    String deskripsi;
    String nama;

    ArrayList<String> arrAksi = new ArrayList<>(); //pilihan aksi untuk item

    Ruangan objRuangan;  //ruangan tempat item, jika null artinya item dipegang npc atau plyaer
    GameInfo objGameInfo;

    //constructor
    /*
    public Item(String nama) {
        this.nama = nama;
        // -- dipindahkan karena dinamik tergantung diambil atau dibuang
        //  arrAksi.add("Deskripsi Item");
        //  arrAksi.add("Ambil item");
    }
    */

    public void prosesAksi(int subPil) {
        //pilihan user untuk aksi yang akan diambil
        //urutan harus sama dengan isi arrAksi

        //Masuk ke turunan (Override)
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void printItem() {
        //print deskripsi item
        System.out.println(deskripsi);
    }

    public ArrayList<String> getAksi() {
        return arrAksi;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }

    public Ruangan getObjRuangan() {
        return objRuangan;
    }

    public GameInfo getObjGameInfo() {
        return objGameInfo;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public ArrayList<String> getArrAksi() {
        return arrAksi;
    }

    public void setArrAksi(ArrayList<String> arrAksi) {
        this.arrAksi = arrAksi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
