public class Produk {
    private int id;
    private String judul;
    private int durasi;

    public Produk(int id, String judul, int durasi){
        this.id = id;
        this.judul = judul;
        this.durasi = durasi;
    }
    public int getId(){ return id; }
    public String getJudul(){ return judul; }
    public int getDurasi(){ return durasi; }
    public void setJudul(String judul){ this.judul = judul; }
    public void setDurasi(int durasi){ this.durasi = durasi; }
}