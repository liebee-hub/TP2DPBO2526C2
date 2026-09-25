#ifndef FILM_H
#define FILM_H
#include "Produk.h"

class Film : public Produk {
private:
    string genre;
    string sutradara;
    string klasifikasi;
public:
    Film() {}
    Film(int id, string judul, int durasi, string genre, string sutradara, string klasifikasi)
        : Produk(id, judul, durasi) {
        this->genre = genre;
        this->sutradara = sutradara;
        this->klasifikasi = klasifikasi;
    }
    string getGenre() { return genre; }
    string getSutradara() { return sutradara; }
    string getKlasifikasi() { return klasifikasi; }
    void setGenre(string x) { genre = x; }
    void setSutradara(string x) { sutradara = x; }
    void setKlasifikasi(string x) { klasifikasi = x; }
};
#endif