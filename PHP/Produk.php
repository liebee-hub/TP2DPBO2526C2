<?php
class Produk {
    private $id;
    private $judul;
    private $durasi;
    private $foto_produk; // khusus bahasa PHP

    public function __construct($id, $judul, $durasi, $foto_produk){
        $this->id = $id;
        $this->judul = $judul;
        $this->durasi = $durasi;
        $this->foto_produk = $foto_produk;
    }
    public function getId(){ return $this->id; }
    public function getJudul(){ return $this->judul; }
    public function getDurasi(){ return $this->durasi; }
    public function getFotoProduk(){ return $this->foto_produk; }
    public function setJudul($x){ $this->judul = $x; }
    public function setDurasi($x){ $this->durasi = $x; }
    public function setFotoProduk($x){ $this->foto_produk = $x; }
}