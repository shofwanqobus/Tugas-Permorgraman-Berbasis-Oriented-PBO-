import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan {

    private ArrayList<Item> arrItem = new ArrayList<>(); //Inisialisasi item
    private String deskripsi;
    private GameInfo objGameInfo;
    private Scanner sc = new Scanner(System.in);

    //Inisialisasi Pintu, Roti, dan Penjaga
    private Pintu Pintu;
    private ItemList Roti;
    private NPC Penjaga;

    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        Pintu.setObjGameInfo(objGameInfo);
        Penjaga.setObjGameInfo(objGameInfo);

        for (Item objItem : arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    public Ruangan() {
        Roti  = new ItemList("Roti"); //Membuat object Roti
        Pintu = new Pintu("Pintu"); //Membuat object Pintu
        Penjaga = new NPC("Penjaga"); //Membuat object Penjaga

        Roti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik"); //Set deskripsi tentang Roti
        Roti.setObjRuangan(this); //Set Roti di ruangan

        Pintu.setDeskripsi("Pintu berwarna merah dengan tulisan 'EXIT' di atas"); //Set deskripsi tentang Pintu

        //tambah item ke array
        arrItem.add(Roti);
        arrItem.add(Pintu);
        arrItem.add(Penjaga);
    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi
    public void pilihanAksi() {

        int urutPil = 0;  //item, pintu
        int subPil = 0;   //aksinya

        //Aksi dengan Polymorphism
        System.out.println("========== Pilihan Aksi pada Ruangan =============");
        System.out.println("|                 Item di ruangan                |");
        System.out.println("==================================================");
        System.out.println();

        //Menampilkan item dalam Array Item (Polymorphism)
        for (Item listItem : arrItem){
            urutPil++;
            subPil = 0; // Sistem penomoran 11, 12, 13, dan seterusnya

            System.out.println(listItem.getNama()); //Menampilkan nama pada arrItem

            //Menampilkan aksi pada turunan method dengan polymorphism
            ArrayList<String> arrPil = listItem.getAksi();
            for (String stringPilihan : arrPil){
                subPil++;
                //Print pilihan menu
                System.out.printf("%d%d. %s %n", urutPil, subPil, stringPilihan);
            }
        }

        System.out.print("Pilihan anda : ");
        String strPil = sc.next();
        System.out.println("---------------");

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        //Inheritance dari Proses Aksi dengan Polymorphism
        Item pilih = arrItem.get(pil-1);
        pilih.prosesAksi(subPil); //aksi item
    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
