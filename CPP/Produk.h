#ifndef PRODUK_H
#define PRODUK_H
#include <string>
using namespace std;

class Produk {
private:
    int id;
    string judul;
    int durasi;
public:
    Produk() {}
    Produk(int id, string judul, int durasi) {
        this->id = id;
        this->judul = judul;
        this->durasi = durasi;
    }
    int getId() { return id; }
    string getJudul() { return judul; }
    int getDurasi() { return durasi; }
    void setJudul(string x) { judul = x; }
    void setDurasi(int x) { durasi = x; }
};
#endif