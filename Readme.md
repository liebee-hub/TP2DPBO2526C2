# TP2 DPBO - Bioskop (Multilevel Inheritance)

## Janji

Saya Refan Maher Aysel dengan NIM 2509129 mengerjakan TP2 dalam
mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya maka saya
tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

---

## Deskripsi Singkat

Program memodelkan **tayangan film di bioskop** yang direpresentasikan dengan
**3 class** menggunakan konsep **OOP Multilevel Inheritance**:

```
Produk  -->  Film  -->  FilmBioskop
```

Relasi ini masuk akal di dunia nyata: sebuah **Produk** hiburan (punya id,
judul, durasi) diwujudkan sebagai **Film** (punya tambahan genre, sutradara,
dan klasifikasi umur), lalu **Film** tersebut ditayangkan di bioskop sebagai
**FilmBioskop** (punya studio, jadwal tayang, dan harga tiket).

Masing-masing dari 3 class memiliki minimal **3 atribut** (total 9 atribut
yang diwariskan secara berjenjang ke objek `FilmBioskop`).

Program diimplementasikan dalam **4 bahasa**: C++, Java, Python, dan PHP.

---

## Penjelasan Atribut dan Methods

### 1. Class `Produk` (parent)

| Atribut  | Tipe    | Keterangan                        |
| -------- | ------- | --------------------------------- |
| `id`     | int     | Identitas unik produk/film        |
| `judul`  | string  | Judul film                        |
| `durasi` | int     | Durasi film dalam menit           |
| `foto_produk` | string | Path file gambar produk (**KHUSUS PHP SAJA**) |

- `Produk(id, judul, durasi)` — constructor (versi PHP menerima `foto_produk` juga)
- `getId()`, `getJudul()`, `getDurasi()` — getter
- `setJudul(x)`, `setDurasi(x)` — setter
- PHP: `getFotoProduk()`, `setFotoProduk(x)` — getter/setter `foto_produk`

### 2. Class `Film` extends `Produk`

| Atribut        | Tipe   | Keterangan                                   |
| -------------- | ------ | -------------------------------------------- |
| `genre`        | string | Genre film (Action, Drama, Horror, dll)      |
| `sutradara`    | string | Nama sutradara film                          |
| `klasifikasi`  | string | Rating umur film (SU, 13+, 17+)              |

- `Film(id, judul, durasi, genre, sutradara, klasifikasi)` — constructor
- `getGenre()`, `getSutradara()`, `getKlasifikasi()` — getter
- `setGenre(x)`, `setSutradara(x)`, `setKlasifikasi(x)` — setter

### 3. Class `FilmBioskop` extends `Film`

| Atribut | Tipe   | Keterangan                               |
| ------- | ------ | ---------------------------------------- |
| `studio`| string | Nama studio/ruang tayang (Studio 1, IMAX) |
| `jadwal`| string | Jam tayang (mis. 19:30)                  |
| `harga` | int    | Harga tiket dalam Rupiah                 |

- `FilmBioskop(id, judul, durasi, genre, sutradara, klasifikasi, studio, jadwal, harga)` — constructor
- `getStudio()`, `getJadwal()`, `getHarga()` — getter
- `setStudio(x)`, `setJadwal(x)`, `setHarga(x)` — setter

Ubahan kode class di tiap bahasa:

| Bahasa | Produk        | Film      | FilmBioskop | Main / entry       |
| ------ | ------------- | --------- | ----------- | ------------------ |
| C++    | `CPP/Produk.h`| `CPP/Film.h` | `CPP/FilmBioskop.h` | `CPP/main.cpp` |
| Java   | `Java/Produk.java` | `Java/Film.java` | `Java/FilmBioskop.java` | `Java/Main.java` |
| Python | `Python/produk.py` | `Python/film.py` | `Python/filmbioskop.py` | `Python/main.py` |
| PHP    | `PHP/Produk.php` | `PHP/Film.php` | `PHP/FilmBioskop.php` | `PHP/index.php` |

---

## Design Diagram

Gambar diagram tersedia di
[`Dokumentasi/design diagram.png`](Dokumentasi/design%20diagram.png).

Source diagram yang bisa diedit ulang (draw.io / diagrams.net) tersedia di
[`Dokumentasi/design_bioskop.drawio`](Dokumentasi/design_bioskop.drawio).
Buka lewat <https://app.diagrams.net> → **File → Open From → Device**, lalu
**File → Export as → PNG** untuk menghasilkan ulang `design diagram.png`.

```
+---------------------------------------+
|               Produk                  |
|---------------------------------------|
| - id : int                           |
| - judul : string                     |
| - durasi : int                       |
| (PHP tambahan: - foto_produk)        |
|---------------------------------------|
| + Produk(...)                        |
| + getId/getJudul/getDurasi           |
| + setJudul/setDurasi                 |
+------------------+--------------------+
                   |  (inheritance)
                   v
+---------------------------------------+
|               Film                    |
|---------------------------------------|
| - genre : string                     |
| - sutradara : string                 |
| - klasifikasi : string               |
|---------------------------------------|
| + Film(...)                          |
| + getGenre/getSutradara/getKlasifikasi|
+------------------+--------------------+
                   |  (inheritance)
                   v
+---------------------------------------+
|            FilmBioskop                |
|---------------------------------------|
| - studio : string                    |
| - jadwal : string                    |
| - harga : int                        |
|---------------------------------------|
| + FilmBioskop(...)                   |
| + getStudio/getJadwal/getHarga       |
+---------------------------------------+
```

**Hubungan is-a (Multilevel Inheritance):**
`FilmBioskop` is-a `Film` is-a `Produk`.

---

## Penjelasan Alur Program

### CLI (C++, Java, Python)

```
Main membuat 5 objek awal FilmBioskop
                |
                v
        Tampilkan menu:
        1 Tambah / 2 Tampilkan / 3 Keluar
                |
                v
        Baca pilihan user
                |
   +------------+------------+
   |            |            |
   v            v            v
Tambahkan     Tampilkan    Keluar
objek baru     SATU TABEL  (break loop)
ke list      dinamis berisi
               SEMUA atribut
```

1. Program **selalu diawali dengan 5 objek `FilmBioskop`** yang dibuat langsung
   di `main()` sebelum ada input user (Interstellar, Dilan 1990,
   Avengers: Endgame, Pengabdi Setan, Laskar Pelangi).
2. Menu **1 = Tambah**: user mengisi 9 data (id, judul, durasi, genre,
   sutradara, klasifikasi, studio, jadwal, harga) lalu objek `FilmBioskop`
   baru dimasukkan ke kumpulan list/vector/ArrayList.
3. Menu **2 = Tampilkan**: seluruh data dari **semua class** ditampilkan
   **di dalam satu tabel** (kolom ID, Judul, Durasi, Genre, Sutradara,
   Klasifikasi, Studio, Jadwal, Harga). Tabel bersifat **dinamis** — lebar
   kolom dihitung otomatis dari isi data, dan jumlah baris bertambah seiring
   data ditambahkan.
4. Menu **3 = Keluar**: mengakhiri perulangan program.

### Web (PHP)

```
index.php
  |- require FilmBioskop.php (rantai: Produk -> Film -> FilmBioskop)
  |- session_start(); $_SESSION['film'] = 5 objek awal FilmBioskop
  |- Jika form "Tambah" di-POST: buat objek FilmBioskop baru
     (termasuk field foto_produk) lalu push ke $_SESSION['film']
  |- HTML: form input + tabel daftar film (baris tabel dinamis
     sesuai jumlah objek di $_SESSION['film'], kolom Foto Produk
     khusus tampil di PHP)
