from produk import Produk

class Film(Produk):
    def __init__(self, id, judul, durasi, genre, sutradara, klasifikasi):
        super().__init__(id, judul, durasi)
        self.genre = genre
        self.sutradara = sutradara
        self.klasifikasi = klasifikasi

    def get_genre(self):
        return self.genre

    def get_sutradara(self):
        return self.sutradara

    def get_klasifikasi(self):
        return self.klasifikasi

    def set_genre(self, genre):
        self.genre = genre

    def set_sutradara(self, sutradara):
        self.sutradara = sutradara

    def set_klasifikasi(self, klasifikasi):
        self.klasifikasi = klasifikasi