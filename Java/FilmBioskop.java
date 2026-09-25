public class FilmBioskop extends Film {
    private String studio;
    private String jadwal;
    private int harga;

    public FilmBioskop(int id, String judul, int durasi, String genre, String sutradara, String klasifikasi,
                       String studio, String jadwal, int harga){
        super(id, judul, durasi, genre, sutradara, klasifikasi);
        this.studio = studio;
        this.jadwal = jadwal;
        this.harga = harga;
    }
    public String getStudio(){ return studio; }
    public String getJadwal(){ return jadwal; }
    public int getHarga(){ return harga; }
    public void setStudio(String studio){ this.studio = studio; }
    public void setJadwal(String jadwal){ this.jadwal = jadwal; }
    public void setHarga(int harga){ this.harga = harga; }
}