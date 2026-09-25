class Produk:
    def __init__(self, id, judul, durasi):
        self.id = id
        self.judul = judul
        self.durasi = durasi

    def get_id(self):
        return self.id

    def get_judul(self):
        return self.judul

    def get_durasi(self):
        return self.durasi

    def set_judul(self, judul):
        self.judul = judul

    def set_durasi(self, durasi):
        self.durasi = durasi