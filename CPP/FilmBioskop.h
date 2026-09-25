#ifndef FILMBIOSKOP_H
#define FILMBIOSKOP_H
#include "Film.h"

class FilmBioskop : public Film {
private:
    string studio;
    string jadwal;
    int harga;
public:
    FilmBioskop() {}
    FilmBioskop(int id, string judul, int durasi, string genre, string sutradara, string klasifikasi,
                string studio, string jadwal, int harga)
        : Film(id, judul, durasi, genre, sutradara, klasifikasi) {
        this->studio = studio;
        this->jadwal = jadwal;
        this->harga = harga;
    }
    string getStudio() { return studio; }
    string getJadwal() { return jadwal; }
    int getHarga() { return harga; }
    void setStudio(string x) { studio = x; }
    void setJadwal(string x) { jadwal = x; }
    void setHarga(int x) { harga = x; }
};
#endif