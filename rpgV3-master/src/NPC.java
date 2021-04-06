import java.util.ArrayList;

public class NPC extends Item {
    //Inisialisasi Kunci
    ItemList Kunci = new ItemList("Kunci");
    boolean isKenal = false;

    public NPC(String nama) {
        ArrayList<String> arrAksi = new ArrayList<>();

        //menambahkan deskripsi ke array
        arrAksi.add("Player berkenalan dengan Penjaga");
        arrAksi.add("Player meminta kunci kepada Penjaga");

        //inisialisasi Kunci
        Kunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        super.setNama(nama);
        super.setArrAksi(arrAksi);
    }

    @Override
    public void prosesAksi(int subPilihan){
        if (subPilihan == 1){
            System.out.println("Penjaga : 'Hai, saya merupakan penjaga dari pintu ini!'");
            isKenal = true;
        }
        else if (subPilihan == 2){
            if (isKenal){
                //Penjaga memberikan kunci kepada Penjaga
                if (Kunci == null){
                    System.out.println("Penjaga : 'Masa anda lupa? Saya kan sudah memberikan kuncinya kepada anda!'");
                }
                //Jika penjaga belum memberikan kuncinya kepada player
                else{
                    System.out.println("Penjaga : 'Kunci akan saya berikan kepada anda'");
                    objGameInfo.getObjPlayer().addItem(Kunci);
                    Kunci = null;
                }
            }
            else{
                System.out.println("Penjaga : 'Siapa anda? Mari kita berkenalan.'");
            }
        }
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        Kunci.setObjGameInfo(objGameInfo);
    }

    @Override
    public ArrayList<String> getArrAksi() {
       return super.getArrAksi();
    }
}
