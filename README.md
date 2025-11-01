<a name="top"></a>

<h1 align="center" style="color:#2e8b57;">🌾 CAPSTONE PROJECT KELOMPOK 11 🌾</h1>
<h1 align="center"><img width="500" height="500" alt="Logo" src="https://github.com/user-attachments/assets/389ffad9-6b59-4bcd-a5ee-0f45441ed1f7" />

<h2 align="center" style="color:#4CAF50;">SELAMAT DATANG DI SISTEM INFORMASI AGRICHAIN!</h2>

## 📚 Daftar Isi
- [👤 Profil Anggota](#-profil-anggota)
- [🌾 Nama Program](#-nama-program)
- [📝 Deskripsi Program](#-deskripsi-program)
- [📈 Use Case Diagram](#-use-case-diagram)
- [🔁 Flowchart Program](#-flowchart-program)
- [⚙️ Fitur Program](#️-fitur-program)
- [💡 Penerapan OOP](#-penerapan-oop)
- [📂 Struktur Folder / Package](#-struktur-folder--package)
- [🧰 Library / Framework yang Digunakan](#-library--framework-yang-digunakan)
- [💻 Cara Menggunakan Program](#-cara-menggunakan-program)
- [🖼️ Tampilan GUI](#-tampilan-gui)

## 👤 Profil Anggota
| Nayla Camelia Indraswari| Indah Maramin Al Inayah  | Nanda Pesona Putri | Luthfi Daffa Purbaya |
|-------------------------|--------------------------|--------------------|----------------------|

## 🌾 Nama Program
**AgriChain** adalah Sistem informasi berbasis Java untuk menghubungkan petani dan distributor dalam mengelola hasil panen, melakukan permintaan distribusi, dan memantau status pengiriman produk secara efisien.

## 📝 Deskripsi Program
Aplikasi **AgriChain** adalah sistem informasi berbasis Java yang dirancang untuk membantu proses distribusi hasil panen antara **petani** dan **distributor** secara digital dan terintegrasi.  
Tujuan utama aplikasi ini adalah untuk menciptakan rantai pasok pertanian yang lebih efisien, transparan, dan mudah digunakan oleh semua pihak yang terlibat dalam ekosistem pertanian lokal.  

---

### ⚙️ 1. Kebutuhan Sistem  
Agar aplikasi **AgriChain** bisa dijalankan dengan baik, berikut beberapa alat dan library yang digunakan dalam pengembangannya:  
- **`JDK 24`**: Digunakan untuk menjalankan dan mengompilasi program berbasis Java. Versi ini mendukung fitur terbaru Java untuk performa dan keamanan yang lebih baik.  
- **`NetBeans IDE 22`**: Digunakan sebagai tempat membuat dan mengedit tampilan aplikasi (GUI) serta menulis kode Java dengan mudah.  
- **`XAMPP`**: Menyediakan server lokal untuk menjalankan database MySQL agar aplikasi dapat menyimpan dan mengelola data pengguna.  
- **`MySQL Connector (mysql-connector-j-9.4.0.jar)`**: Berfungsi sebagai penghubung antara aplikasi Java dan database MySQL, memungkinkan pertukaran data antar keduanya.  
- **`Absolute Layout (AbsoluteLayout.jar)`**: Library tambahan untuk memudahkan pengaturan posisi komponen GUI secara presisi di dalam NetBeans.  
- **`JCalendar (jcalendar-1.4.jar)`**: Digunakan untuk menampilkan dan memilih tanggal secara otomatis dalam tampilan aplikasi.  
- **`FlatLaf (flatlaf-3.4.jar)`**: Library untuk mempercantik tampilan GUI agar terlihat lebih modern dan rapi.

---

### 🌾 2. Fungsi Utama  
AgriChain hadir untuk mempermudah komunikasi dan transaksi antara **petani** dan **distributor** tanpa perantara. Petani dapat menginput hasil panen yang mereka miliki, sementara distributor dapat melihat data hasil panen tersebut dan membuat permintaan langsung kepada petani. Aplikasi ini juga memungkinkan **admin** untuk mengelola akun pengguna dan memantau aktivitas sistem.

---

### 👥 3. Peran Utama dalam Sistem  
- **Petani**: Menginput hasil panen, memperbarui data lahan, dan menerima permintaan dari distributor.  
- **Distributor**: Melihat data hasil panen petani, membuat permintaan, dan memantau status pengiriman.  
- **Admin**: Mengelola data petani dan distributor serta memastikan sistem berjalan dengan baik.  

## 📈 Use Case Diagram

<details>
  <summary>Use Case</summary>
  <img src="https://github.com/user-attachments/assets/9f2fd37f-f0e6-49bc-ae39-efd53b1bf775" alt="">
</details>

## 🔁 Flowchart Program

<details>
  <summary>1. Menu Login</summary>
  <img src="https://github.com/user-attachments/assets/6a69e964-6f37-4c1c-a6d1-67eb5ade2ec7" alt="">
</details>

<details>
  <summary>2. Menu Admin</summary>
  <img src="https://github.com/user-attachments/assets/524d32cc-25cc-4da0-a4c4-18c6d00976e6" alt="">
</details>

<details>
  <summary>3. Menu Petani</summary>
  <img src="https://github.com/user-attachments/assets/9a95e796-88e3-4d7a-bc96-31b742cb8387" alt="">
</details>

<details>
  <summary>4. Menu Distributor</summary>
  <img src="https://github.com/user-attachments/assets/c71d27c9-f557-4d96-83f2-84302b8c3807" alt="">
</details>

<details>
  <summary>5. Kelola Petani</summary>
  <img src="https://github.com/user-attachments/assets/7f001eee-0b0e-4244-bb0f-920877927d6e" alt="">
</details>

<details>
  <summary>6. Kelola Distributor</summary>
  <img src="https://github.com/user-attachments/assets/b25bf5f2-a828-4acf-abfd-986899e7022b" alt="">
</details>

## ⚙️ Fitur Program

Aplikasi **AgriChain** memiliki beberapa fitur utama yang dibedakan berdasarkan peran pengguna: **Petani**, **Distributor**, dan **Admin**.

### 🧑‍💼 1. Fitur untuk Admin
Admin memiliki kontrol penuh terhadap sistem dan pengguna dalam aplikasi **AgriChain**. Berikut fitur-fitur utama yang dapat dilakukan oleh admin:

- **Kelola Akun Distributor**  
  Admin dapat menambah, mengedit, dan menghapus data distributor, termasuk nama, nomor telepon, status, dan tanggal registrasi.  

- **Kelola Akun Petani**  
  Admin bisa memantau data petani, hasil panen, serta aktivitas yang dilakukan di sistem.  

- **Pantau Permintaan Hasil Panen**  
  Admin dapat melihat daftar permintaan yang dilakukan oleh distributor kepada petani dan memastikan transaksi berjalan lancar.  

- **Manajemen Database Terpusat**  
  Semua data pengguna, hasil panen, dan permintaan tersimpan di database MySQL, sehingga memudahkan pemantauan dan pencarian data.  

- **Antarmuka Visual Interaktif**  
  Admin dapat berinteraksi langsung melalui tampilan GUI yang sederhana dan mudah digunakan, dilengkapi tombol *Tambah*, *Edit*, *Hapus*, serta tabel data.  

---

### 👨‍🌾 2. Fitur untuk Petani
- **Input Data Hasil Panen**  
  Petani dapat menambahkan data hasil panen seperti luas lahan, nama sawah, dan lokasi.  
- **Melihat dan Mengelola Permintaan**  
  Petani dapat melihat daftar permintaan dari distributor dan memperbarui statusnya (misalnya: *menunggu*, *diproses*, *selesai*).  
- **Dashboard Petani**  
  Menampilkan informasi panen dan permintaan dalam satu tampilan yang mudah dipahami.  

---

### 🚚 3. Fitur untuk Distributor
- **Melihat Data Petani dan Hasil Panen**  
  Distributor dapat mencari dan menyortir data hasil panen berdasarkan lokasi atau jumlah panen.  
- **Membuat Permintaan Hasil Panen**  
  Distributor dapat membuat permintaan kepada petani secara langsung dari aplikasi.  
- **Pantau Status Permintaan**  
  Distributor bisa melihat status permintaan yang dikirim apakah sudah diterima, sedang diproses, atau selesai.  

---

### 🖥️ 4. Fitur Umum
- **Login dan Register Sesuai Role**  
  Pengguna baru dapat mendaftar sebagai *Petani* atau *Distributor*, dan sistem akan menampilkan halaman sesuai perannya.  
- **Koneksi Database Otomatis**  
  Semua data tersimpan otomatis di MySQL menggunakan JDBC Connector.  
- **Tampilan GUI Menarik dan Responsif**  
  Dibangun menggunakan Java Swing dengan layout AbsoluteLayout dan tema modern dari FlatLaf.  

## 💡 Penerapan OOP

## 📂 Struktur Folder / Package

Struktur folder pada proyek **AgriChain** dibuat berdasarkan pola **MVC (Model-View-Controller)** agar setiap bagian kode memiliki tanggung jawab yang jelas. Dengan struktur seperti ini, pengembangan aplikasi jadi lebih mudah, rapi, dan terorganisir antara tampilan (View), logika (Controller), dan data (Model).

Secara umum, struktur foldernya adalah sebagai berikut:

<details>
  <summary>🧠 Controller</summary>
  Package ini berisi seluruh logika utama aplikasi (business logic) yang mengatur alur kerja antara tampilan (view) dan data (model). Controller menerima input dari user melalui form GUI, memproses data, lalu menghubungkannya ke database lewat package Database.

Berikut beberapa file penting di dalamnya:
- **`BaseController.java`**: Kelas dasar yang menjadi induk bagi controller lain, berisi fungsi umum seperti validasi input atau pengaturan koneksi awal.  
- **`LoginController.java`**: Mengatur proses login untuk semua pengguna (Admin, Petani, Distributor).  
- **`RegisterController.java`**: Menangani proses pendaftaran akun baru ke dalam database.  
- **`adminController.java`**: Mengatur fitur-fitur khusus admin seperti kelola akun distributor dan petani.  
- **`distributorController.java`**: Mengatur aktivitas distributor seperti membuat permintaan hasil panen.  
- **`hasilPanenController.java`**: Bertanggung jawab atas proses penambahan, pengeditan, dan penghapusan data hasil panen oleh petani.  
- **`permintaanController.java`**: Mengatur data permintaan hasil panen dari distributor dan statusnya.  
- **`petaniController.java`**: Mengelola data petani, termasuk sawah, lokasi, dan luas lahan.  
- **`generateID.java`**: Membuat ID unik otomatis untuk setiap data baru agar tidak terjadi duplikasi di database.

Package ini berfungsi sebagai “otak” dari aplikasi yang mengatur hubungan antar komponen dan memastikan logika berjalan dengan benar.
</details> 

<details>
  <summary>🗄️ Database</summary>
Package **Database** berfungsi untuk mengatur seluruh proses **koneksi dan komunikasi antara aplikasi AgriChain dengan database MySQL** menggunakan JDBC. Struktur di dalamnya mengikuti konsep *service layer*, di mana setiap jenis data (Admin, Petani, Distributor, Hasil Panen, dan Permintaan) memiliki class khusus untuk memproses query-nya masing-masing. Hal ini membuat kode menjadi lebih rapi, terpisah, dan mudah diperbaiki jika ada perubahan pada struktur database.

- **`Koneksi.java`**: Mengatur koneksi utama ke MySQL.  
  File ini menyimpan konfigurasi seperti URL database, username, dan password.  
  Semua file lain akan menggunakan koneksi dari sini agar tidak perlu membuat koneksi baru berulang kali.

- **`CRUDService.java`**: Menyediakan **fungsi dasar CRUD** (*Create, Read, Update, Delete*) yang dapat digunakan oleh berbagai service lain.  
  Dengan adanya class ini, semua proses database dapat dilakukan secara efisien tanpa perlu menulis ulang query yang sama.

- **`adminService.java`**: Berfungsi untuk mengelola data **Admin**, termasuk menambah akun baru, memperbarui data, dan menampilkan daftar admin.

- **`distributorService.java`**: Menangani semua operasi terkait **Distributor**, seperti menyimpan data pendaftaran, memperbarui status, serta mengambil data distributor dari database.

- **`petaniService.java`**: Digunakan untuk mengatur data **Petani**, seperti nama, nomor telepon, lokasi sawah, dan luas lahan.  
  File ini biasanya digunakan oleh `petaniController` untuk menampilkan dan memperbarui data petani di GUI.

- **`hasilPanenService.java`**: Mengelola data **hasil panen** dari petani, meliputi jenis hasil panen, jumlah, satuan (kg/ton), dan status data.  
  File ini membantu `hasilPanenController` dalam memuat daftar hasil panen serta menambahkan data baru.

- **`permintaanService.java`**: Mengatur data **permintaan hasil panen** dari distributor ke petani.
  Termasuk menambah permintaan baru, memperbarui status (misalnya menunggu, diterima, atau selesai), serta menampilkan daftar permintaan yang aktif.


### 🧩 `Model`
Package ini berisi **kelas-kelas representasi data (entity class)** yang mencerminkan tabel di database.  
Setiap model memiliki atribut dan metode *getter/setter* yang digunakan untuk mengatur atau mengambil nilai data.

- **`Admin.java`**: Menyimpan data admin seperti ID, nama, dan nomor telepon.  
- **`Distributor.java`**: Menyimpan informasi distributor seperti nama, status, dan tanggal registrasi.  
- **`Permintaan.java`**: Mewakili data permintaan hasil panen oleh distributor.  
- **`Petani.java`**: Berisi data petani seperti nama sawah, luas lahan, dan lokasi.  
- **`hasilPanen.java`**: Menyimpan data panen yang dimasukkan oleh petani (jenis, jumlah, satuan).

Package ini berperan sebagai wadah data yang dikirim atau diterima antar komponen aplikasi.

### 🔐 `Session`
Package ini berfungsi untuk **menyimpan informasi pengguna yang sedang login** agar bisa digunakan di berbagai tampilan (form).  
Misalnya menyimpan ID user, nama, dan perannya (Admin, Petani, Distributor).

- **`Session.java`**: Berisi variabel global yang bisa diakses oleh semua form untuk melacak siapa yang sedang aktif menggunakan aplikasi.

Dengan Session, user tidak perlu login berulang kali saat berpindah halaman.

### 🚀 `main`
Package ini berisi file utama yang menjalankan program.

- **`Main.java`**: Menjadi *entry point* aplikasi. File ini biasanya memanggil form pertama (seperti LoginForm) dan melakukan inisialisasi awal sebelum program berjalan.

Package ini memastikan aplikasi berjalan dengan urutan dan konfigurasi yang benar saat pertama kali dijalankan.

## 🧰 Library / Framework yang Digunakan
