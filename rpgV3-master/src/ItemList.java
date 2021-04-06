import java.util.ArrayList;

//Turunan untuk menyimpan barang seperti kunci, roti, dan cincin emas
public class ItemList extends Item{

    public ItemList(String nama) {
        super.setNama(nama);
    }

    @Override
    public void prosesAksi(int subPilihan){
        //Jika player memilih 1
        if (subPilihan == 1) {
            System.out.println(super.getDeskripsi()); //Mendeskripsikan barang
        }
        //Jika memilih 2
        else if (subPilihan == 2){
            if (super.getObjRuangan() == null){
                //Player membuang Item ke ruangan
                System.out.println("Player membuang item ke ruangan!");
                dibuang();
            }
            else{
                //Player mengambil Item dari ruuangan
                diambil();
            }
        }
    }

    public void dibuang() {
        super.getObjGameInfo().getObjPlayer().hapusItem(this); //hapus dari player
        super.getObjGameInfo().getObjRuangan().addItem(this);  //tambah ke ruangan
        super.setObjRuangan(super.getObjGameInfo().getObjRuangan()); // set ruangan
    }


    //pindahkan item dari ruangan ke player
    public void diambil() {
        //jika ruangan sudah kosong dan player mencoba mengambil item
        if (objRuangan == null){
            System.out.println("Player telah mengambil item dari ruangan!");
        }
        //Jika ruangan memiliki item
        else{
            System.out.println("Item diambil oleh player");
            super.getObjGameInfo().getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
            super.getObjRuangan().hapusItem(this);                    //hapus dari ruangan
            super.setObjRuangan(null);
        }
    }

    @Override
    public ArrayList<String> getAksi() {
        //aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrItem = new ArrayList<>();
        if (super.getObjRuangan() == null){
            //Jika item berada pada Player
            arrItem.add("Deskripsikan Item!");
            arrItem.add("Buang Item oleh Player");
        }
        else{
            //Jika item berada pada ruangan
            arrItem.add("Deskripsikan Item!");
            arrItem.add("Ambil Item oleh Player");
        }
        return(arrItem);
    }

}
