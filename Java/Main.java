import java.util.*;

public class Main {
    static String tengah(String s, int w){
        if(s.length() >= w) return s;
        int kiri = (w - s.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < kiri; i++) sb.append(' ');
        sb.append(s);
        for(int i = 0; i < w - s.length() - kiri; i++) sb.append(' ');
        return sb.toString();
    }

    static void tabel(List<FilmBioskop> list){
        if(list.isEmpty()){ System.out.println("Belum ada data film."); return; }
        String[] head = {"ID", "Judul", "Durasi", "Genre", "Sutradara", "Klasifikasi", "Studio", "Jadwal", "Harga (Rp)"};
        int n = head.length;
        int[] w = new int[n];
        for(int i = 0; i < n; i++) w[i] = head[i].length();
        for(FilmBioskop f : list){
            w[0] = Math.max(w[0], String.valueOf(f.getId()).length());
            w[1] = Math.max(w[1], f.getJudul().length());
            w[2] = Math.max(w[2], String.valueOf(f.getDurasi()).length());
            w[3] = Math.max(w[3], f.getGenre().length());
            w[4] = Math.max(w[4], f.getSutradara().length());
            w[5] = Math.max(w[5], f.getKlasifikasi().length());
            w[6] = Math.max(w[6], f.getStudio().length());
            w[7] = Math.max(w[7], f.getJadwal().length());
            w[8] = Math.max(w[8], String.valueOf(f.getHarga()).length());
        }
        StringBuilder garis = new StringBuilder("+");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < w[i] + 2; j++) garis.append('-');
            garis.append('+');
        }
        System.out.println(garis);
        StringBuilder h = new StringBuilder("|");
        for(int i = 0; i < n; i++) h.append(" ").append(tengah(head[i], w[i])).append(" |");
        System.out.println(h);
        System.out.println(garis);
        for(FilmBioskop f : list){
            String[] baris = {String.valueOf(f.getId()), f.getJudul(), String.valueOf(f.getDurasi()),
                              f.getGenre(), f.getSutradara(), f.getKlasifikasi(),
                              f.getStudio(), f.getJadwal(), String.valueOf(f.getHarga())};
            StringBuilder r = new StringBuilder("|");
            for(int i = 0; i < n; i++) r.append(" ").append(tengah(baris[i], w[i])).append(" |");
            System.out.println(r);
        }
        System.out.println(garis);
        System.out.println("Total: " + list.size() + " film tayang.");
    }

    static String bacaStr(Scanner sc, String prompt){
        System.out.print(prompt);
        if(!sc.hasNextLine()) return "";
        return sc.nextLine();
    }

    static int bacaInt(Scanner sc, String prompt){
        System.out.print(prompt);
        if(sc.hasNextInt()){
            int v = sc.nextInt();
            if(sc.hasNextLine()) sc.nextLine();
            return v;
        }
        if(sc.hasNextLine()) sc.nextLine();
        System.out.println("Input harus angka.");
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<FilmBioskop> list = new ArrayList<>();
        list.add(new FilmBioskop(1,  "Interstellar",     169, "Sci-Fi",    "Christopher Nolan", "13+", "Studio 1", "19:30", 55000));
        list.add(new FilmBioskop(2,  "Dilan 1990",       110, "Romance",   "Fajar Bustomi",     "13+", "Studio 2", "16:00", 45000));
        list.add(new FilmBioskop(3,  "Avengers: Endgame",181, "Action",    "Russo Brothers",    "13+", "IMAX",     "20:00", 80000));
        list.add(new FilmBioskop(4,  "Pengabdi Setan",   112, "Horror",    "Joko Anwar",        "17+", "Studio 3", "22:00", 50000));
        list.add(new FilmBioskop(5,  "Laskar Pelangi",   124, "Drama",     "Riri Riza",         "SU",  "Studio 4", "13:00", 40000));

        while(true){
            System.out.println("\n===== MENU BIOSKOP =====");
            System.out.println("1. Tambah Film");
            System.out.println("2. Tampilkan Semua (Tabel)");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");

            if(!sc.hasNextLine()) break;
            int pilih;
            if(sc.hasNextInt()){
                pilih = sc.nextInt();
                if(sc.hasNextLine()) sc.nextLine();
            }else{
                System.out.println("Input harus angka.");
                sc.nextLine();
                continue;
            }

            if(pilih == 1){
                int id = bacaInt(sc, "ID       : ");
                String judul = bacaStr(sc, "Judul    : ");
                int durasi = bacaInt(sc, "Durasi   : ");
                String genre = bacaStr(sc, "Genre    : ");
                String sutradara = bacaStr(sc, "Sutradara: ");
                String klasifikasi = bacaStr(sc, "Klasifikasi (SU/13+/17+): ");
                String studio = bacaStr(sc, "Studio   : ");
                String jadwal = bacaStr(sc, "Jadwal   : ");
                int harga = bacaInt(sc, "Harga    : ");
                list.add(new FilmBioskop(id, judul, durasi, genre, sutradara, klasifikasi, studio, jadwal, harga));
                System.out.println("Film berhasil ditambahkan.");
            }else if(pilih == 2){
                tabel(list);
            }else if(pilih == 3){
                break;
            }else{
                System.out.println("Pilihan tidak valid.");
            }
        }
        sc.close();
    }
}