<?php
require 'FilmBioskop.php';
session_start();

if(!isset($_SESSION['film'])){
    $_SESSION['film'] = [
        new FilmBioskop(1, "Interstellar", 169, "gambar/interstellar.jpg", "Sci-Fi", "Christopher Nolan", "13+", "Studio 1", "19:30", 55000),
        new FilmBioskop(2, "Dilan 1990", 110, "gambar/dilan1990.jpg", "Romance", "Fajar Bustomi", "13+", "Studio 2", "16:00", 45000),
        new FilmBioskop(3, "Avengers: Endgame", 181, "gambar/avengers.jpg", "Action", "Russo Brothers", "13+", "IMAX", "20:00", 80000),
        new FilmBioskop(4, "Pengabdi Setan", 112, "gambar/pengabdisetan.jpg", "Horror", "Joko Anwar", "17+", "Studio 3", "22:00", 50000),
        new FilmBioskop(5, "Laskar Pelangi", 124, "gambar/laskarpelangi.jpg", "Drama", "Riri Riza", "SU", "Studio 4", "13:00", 40000),
    ];
}

if(isset($_POST['tambah'])){
    $_SESSION['film'][] = new FilmBioskop(
        $_POST['id'], $_POST['judul'], $_POST['durasi'], $_POST['foto_produk'],
        $_POST['genre'], $_POST['sutradara'], $_POST['klasifikasi'],
        $_POST['studio'], $_POST['jadwal'], $_POST['harga']
    );
}
?>
<html>
<head><title>Bioskop - Manajemen Film</title></head>
<body>
<h2>Manajemen Data Bioskop</h2>

<h3>Tambah Film</h3>
<form method="post">
ID <input name="id" required><br>
Judul <input name="judul" required><br>
Durasi (menit) <input name="durasi" required><br>
Foto Produk (path file lokal - khusus PHP) <input name="foto_produk" required><br>
Genre <input name="genre" required><br>
Sutradara <input name="sutradara" required><br>
Klasifikasi (SU/13+/17+) <input name="klasifikasi" required><br>
Studio <input name="studio" required><br>
Jadwal (mis. 19:30) <input name="jadwal" required><br>
Harga (Rp) <input name="harga" required><br>
<button name="tambah">Tambah</button>
</form>

<h3>Daftar Film</h3>
<table border="1" cellpadding="5" cellspacing="0">
<tr>
<th>ID</th><th>Judul</th><th>Durasi</th><th>Foto Produk</th>
<th>Genre</th><th>Sutradara</th><th>Klasifikasi</th>
<th>Studio</th><th>Jadwal</th><th>Harga (Rp)</th>
</tr>
<?php foreach($_SESSION['film'] as $f){ ?>
<tr>
<td align="center"><?= $f->getId() ?></td>
<td><?= $f->getJudul() ?></td>
<td align="center"><?= $f->getDurasi() ?> menit</td>
<td><img src="<?= htmlspecialchars($f->getFotoProduk()) ?>" alt="foto" width="80" onerror="this.style.display='none'"><br>
    <small><?= htmlspecialchars($f->getFotoProduk()) ?></small></td>
<td><?= $f->getGenre() ?></td>
<td><?= $f->getSutradara() ?></td>
<td align="center"><?= $f->getKlasifikasi() ?></td>
<td><?= $f->getStudio() ?></td>
<td align="center"><?= $f->getJadwal() ?></td>
<td align="right">Rp <?= number_format($f->getHarga(), 0, ',', '.') ?></td>
</tr>
<?php } ?>
</table>

<p>Total: <?= count($_SESSION['film']) ?> film tayang.</p>
</body>
</html>