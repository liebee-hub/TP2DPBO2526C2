<?php
require 'Produk.php';

class Film extends Produk {
    private $genre;
    private $sutradara;
    private $klasifikasi;

    public function __construct($id, $judul, $durasi, $foto_produk, $genre, $sutradara, $klasifikasi){
        parent::__construct($id, $judul, $durasi, $foto_produk);
        $this->genre = $genre;
        $this->sutradara = $sutradara;
        $this->klasifikasi = $klasifikasi;
    }
    public function getGenre(){ return $this->genre; }
    public function getSutradara(){ return $this->sutradara; }
    public function getKlasifikasi(){ return $this->klasifikasi; }
    public function setGenre($x){ $this->genre = $x; }
    public function setSutradara($x){ $this->sutradara = $x; }
    public function setKlasifikasi($x){ $this->klasifikasi = $x; }
}