#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include "FilmBioskop.h"
using namespace std;

string tengah(string s, size_t w){
    if(s.length() >= w) return s;
    size_t kiri = (w - s.length()) / 2;
    return string(kiri, ' ') + s + string(w - s.length() - kiri, ' ');
}

void tabel(vector<FilmBioskop*> list){
    if(list.empty()){ cout << "Belum ada data film.\n"; return; }
    string head[9] = {"ID", "Judul", "Durasi", "Genre", "Sutradara", "Klasifikasi", "Studio", "Jadwal", "Harga (Rp)"};
    size_t w[9];
    for(size_t i = 0; i < 9; i++) w[i] = head[i].length();
    for(FilmBioskop* f : list){
        w[0] = max(w[0], to_string(f->getId()).length());
        w[1] = max(w[1], f->getJudul().length());
        w[2] = max(w[2], to_string(f->getDurasi()).length());
        w[3] = max(w[3], f->getGenre().length());
        w[4] = max(w[4], f->getSutradara().length());
        w[5] = max(w[5], f->getKlasifikasi().length());
        w[6] = max(w[6], f->getStudio().length());
        w[7] = max(w[7], f->getJadwal().length());
        w[8] = max(w[8], to_string(f->getHarga()).length());
    }
    string garis = "+";
    for(size_t i = 0; i < 9; i++) garis += string(w[i] + 2, '-') + "+";
    cout << garis << "\n";
    cout << "|";
    for(size_t i = 0; i < 9; i++) cout << " " << tengah(head[i], w[i]) << " |";
    cout << "\n" << garis << "\n";
    for(FilmBioskop* f : list){
        cout << "| " << tengah(to_string(f->getId()), w[0]) << " | "
             << tengah(f->getJudul(), w[1]) << " | "
             << tengah(to_string(f->getDurasi()), w[2]) << " | "
             << tengah(f->getGenre(), w[3]) << " | "
             << tengah(f->getSutradara(), w[4]) << " | "
             << tengah(f->getKlasifikasi(), w[5]) << " | "
             << tengah(f->getStudio(), w[6]) << " | "
             << tengah(f->getJadwal(), w[7]) << " | "
             << tengah(to_string(f->getHarga()), w[8]) << " |\n";
    }
    cout << garis << "\n";
    cout << "Total: " << list.size() << " film tayang.\n";
}

int main(){
    vector<FilmBioskop*> list;
    list.push_back(new FilmBioskop(1,  "Interstellar",    169, "Sci-Fi",    "Christopher Nolan", "13+", "Studio 1", "19:30", 55000));
    list.push_back(new FilmBioskop(2,  "Dilan 1990",      110, "Romance",   "Fajar Bustomi",     "13+", "Studio 2", "16:00", 45000));
    list.push_back(new FilmBioskop(3,  "Avengers: Endgame",181, "Action",   "Russo Brothers",    "13+", "IMAX",     "20:00", 80000));
    list.push_back(new FilmBioskop(4,  "Pengabdi Setan",  112, "Horror",    "Joko Anwar",        "17+", "Studio 3", "22:00", 50000));
    list.push_back(new FilmBioskop(5,  "Laskar Pelangi",  124, "Drama",     "Riri Riza",         "SU",  "Studio 4", "13:00", 40000));

    int pilih;
    do{
        cout << "\n===== MENU BIOSKOP =====\n"
             << "1. Tambah Film\n"
             << "2. Tampilkan Semua (Tabel)\n"
             << "3. Keluar\n"
             << "Pilihan: ";
        cin >> pilih;
        cin.ignore();

        if(pilih == 1){
            int id, durasi, harga; string judul, genre, sutradara, klasifikasi, studio, jadwal;
            cout << "ID       : "; cin >> id; cin.ignore();
            cout << "Judul    : "; getline(cin, judul);
            cout << "Durasi   : "; cin >> durasi; cin.ignore();
            cout << "Genre    : "; getline(cin, genre);
            cout << "Sutradara: "; getline(cin, sutradara);
            cout << "Klasifikasi (SU/13+/17+): "; getline(cin, klasifikasi);
            cout << "Studio   : "; getline(cin, studio);
            cout << "Jadwal   : "; getline(cin, jadwal);
            cout << "Harga    : "; cin >> harga; cin.ignore();
            list.push_back(new FilmBioskop(id, judul, durasi, genre, sutradara, klasifikasi, studio, jadwal, harga));
            cout << "Film berhasil ditambahkan.\n";
        }else if(pilih == 2){
            tabel(list);
        }else if(pilih != 3){
            cout << "Pilihan tidak valid.\n";
        }
    }while(pilih != 3);

    for(FilmBioskop* f : list) delete f;
    return 0;
}