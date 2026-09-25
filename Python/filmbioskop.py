from film import Film

class FilmBioskop(Film):
    def __init__(self, id, judul, durasi, genre, sutradara, klasifikasi, studio, jadwal, harga):
        super().__init__(id, judul, durasi, genre, sutradara, klasifikasi)
        self.studio = studio
        self.jadwal = jadwal
        self.harga = harga

    def get_studio(self):
        return self.studio

    def get_jadwal(self):
        return self.jadwal

    def get_harga(self):
        return self.harga

    def set_studio(self, studio):
        self.studio = studio

    def set_jadwal(self, jadwal):
        self.jadwal = jadwal

    def set_harga(self, harga):
        self.harga = harga