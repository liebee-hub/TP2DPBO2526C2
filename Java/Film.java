public class Film extends Produk {
    private String genre;
    private String sutradara;
    private String klasifikasi;

    public Film(int id, String judul, int durasi, String genre, String sutradara, String klasifikasi){
        super(id, judul, durasi);
        this.genre = genre;
        this.sutradara = sutradara;
        this.klasifikasi = klasifikasi;
    }
    public String getGenre(){ return genre; }
    public String getSutradara(){ return sutradara; }
    public String getKlasifikasi(){ return klasifikasi; }
    public void setGenre(String genre){ this.genre = genre; }
    public void setSutradara(String sutradara){ this.sutradara = sutradara; }
    public void setKlasifikasi(String klasifikasi){ this.klasifikasi = klasifikasi; }
}