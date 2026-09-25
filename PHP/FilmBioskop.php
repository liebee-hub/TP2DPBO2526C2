<?php
require 'Film.php';

class FilmBioskop extends Film {
    private $studio;
    private $jadwal;
    private $harga;

    public function __construct($id, $judul, $durasi, $foto_produk, $genre, $sutradara, $klasifikasi,
                                $studio, $jadwal, $harga){
        parent::__construct($id, $judul, $durasi, $foto_produk, $genre, $sutradara, $klasifikasi);
        $this->studio = $studio;
        $this->jadwal = $jadwal;
        $this->harga = $harga;
    }
    public function getStudio(){ return $this->studio; }
    public function getJadwal(){ return $this->jadwal; }
    public function getHarga(){ return $this->harga; }
    public function setStudio($x){ $this->studio = $x; }
    public function setJadwal($x){ $this->jadwal = $x; }
    public function setHarga($x){ $this->harga = $x; }
}