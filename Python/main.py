from filmbioskop import FilmBioskop


def tengah(s, w):
    if len(s) >= w:
        return s
    kiri = (w - len(s)) // 2
    return " " * kiri + s + " " * (w - len(s) - kiri)


def tabel(list_film):
    if not list_film:
        print("Belum ada data film.")
        return
    head = ["ID", "Judul", "Durasi", "Genre", "Sutradara", "Klasifikasi", "Studio", "Jadwal", "Harga (Rp)"]
    w = [len(h) for h in head]
    for f in list_film:
        w[0] = max(w[0], len(str(f.get_id())))
        w[1] = max(w[1], len(f.get_judul()))
        w[2] = max(w[2], len(str(f.get_durasi())))
        w[3] = max(w[3], len(f.get_genre()))
        w[4] = max(w[4], len(f.get_sutradara()))
        w[5] = max(w[5], len(f.get_klasifikasi()))
        w[6] = max(w[6], len(f.get_studio()))
        w[7] = max(w[7], len(f.get_jadwal()))
        w[8] = max(w[8], len(str(f.get_harga())))
    garis = "+" + "+".join("-" * (wi + 2) for wi in w) + "+"
    print(garis)
    print("|" + "|".join(" " + tengah(head[i], w[i]) + " " for i in range(len(w))) + "|")
    print(garis)
    for f in list_film:
        baris = [
            str(f.get_id()), f.get_judul(), str(f.get_durasi()), f.get_genre(),
            f.get_sutradara(), f.get_klasifikasi(), f.get_studio(), f.get_jadwal(), str(f.get_harga())
        ]
        print("|" + "|".join(" " + tengah(baris[i], w[i]) + " " for i in range(len(w))) + "|")
    print(garis)
    print("Total:", len(list_film), "film tayang.")


def main():
    list_film = [
        FilmBioskop(1, "Interstellar", 169, "Sci-Fi", "Christopher Nolan", "13+", "Studio 1", "19:30", 55000),
        FilmBioskop(2, "Dilan 1990", 110, "Romance", "Fajar Bustomi", "13+", "Studio 2", "16:00", 45000),
        FilmBioskop(3, "Avengers: Endgame", 181, "Action", "Russo Brothers", "13+", "IMAX", "20:00", 80000),
        FilmBioskop(4, "Pengabdi Setan", 112, "Horror", "Joko Anwar", "17+", "Studio 3", "22:00", 50000),
        FilmBioskop(5, "Laskar Pelangi", 124, "Drama", "Riri Riza", "SU", "Studio 4", "13:00", 40000),
    ]

    while True:
        print("\n===== MENU BIOSKOP =====")
        print("1. Tambah Film")
        print("2. Tampilkan Semua (Tabel)")
        print("3. Keluar")
        pilih = input("Pilihan: ")

        if pilih == "1":
            id = int(input("ID       : "))
            judul = input("Judul    : ")
            durasi = int(input("Durasi   : "))
            genre = input("Genre    : ")
            sutradara = input("Sutradara: ")
            klasifikasi = input("Klasifikasi (SU/13+/17+): ")
            studio = input("Studio   : ")
            jadwal = input("Jadwal   : ")
            harga = int(input("Harga    : "))
            list_film.append(FilmBioskop(id, judul, durasi, genre, sutradara, klasifikasi, studio, jadwal, harga))
            print("Film berhasil ditambahkan.")
        elif pilih == "2":
            tabel(list_film)
        elif pilih == "3":
            break
        else:
            print("Pilihan tidak valid.")


if __name__ == "__main__":
    main()