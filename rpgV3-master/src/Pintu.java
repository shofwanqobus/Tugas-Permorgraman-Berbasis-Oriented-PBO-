import java.util.ArrayList;

public class Pintu extends Item{

    public Pintu(String nama) {
        ArrayList<String> arrAksi = new ArrayList<>();
        arrAksi.add("Deskripsikan Pintu!");
        arrAksi.add("Coba buka pintu oleh player!");

        super.setArrAksi(arrAksi);
        super.setNama(nama);
    }

    @Override
    public void prosesAksi(int subPilihan){ //Override method pintu dari class Item
        //Deskripsi tentang Pintu
        if (subPilihan == 1){ //subPilihan == 1
            System.out.println("Deskripsi : " + super.getDeskripsi());
        }

        //Player membuka pintu
        else if (subPilihan == 2) { //subPilihan == 2
            if (super.getObjGameInfo().getObjPlayer().cariItem("Kunci")) {
                //Pintu akan terbuka jika player memiliki kunci
                System.out.println("Player menggunakan kuncinya untuk membuka pintu!");
                System.out.println("Pintu telah terbuka oleh player, Player keluar dari ruangan!");
                super.getObjGameInfo().setGameOver(true);
            }
            else {
                //Jika player tidak memiliki kunci
                System.out.println("Player masih belum memiliki item Kunci untuk membuka Pintu!");
            }
        }
    }

    @Override
    public ArrayList<String> getAksi() {
        return(super.getArrAksi());
    }
}
