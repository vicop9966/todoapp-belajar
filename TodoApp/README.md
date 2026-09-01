# To-Do List App — Proyek Belajar Android Pertama

## Cara Membuka Project

1. Download & extract file `TodoApp.zip`.
2. Install **Android Studio** (gratis): https://developer.android.com/studio
3. Buka Android Studio → **File > Open** → pilih folder `TodoApp` hasil extract.
4. Tunggu proses "Gradle Sync" selesai (ada progress bar di bawah, mungkin
   perlu beberapa menit di percobaan pertama karena download dependency).
5. Sambungkan HP Android via USB (aktifkan "USB Debugging" di Developer
   Options) ATAU buat emulator lewat **Device Manager** di Android Studio.
6. Klik tombol ▶️ (Run) hijau di toolbar atas.

## Struktur Project — Apa Fungsi Tiap File?

```
app/src/main/
├── java/com/belajar/todoapp/
│   ├── Todo.kt          -> "cetakan" data 1 tugas (judul + status selesai)
│   ├── TodoAdapter.kt   -> penghubung antara data List<Todo> dan tampilan list
│   └── MainActivity.kt  -> layar utama: logika tambah/hapus/simpan tugas
└── res/
    ├── layout/
    │   ├── activity_main.xml -> desain layar utama (input + tombol + list)
    │   └── item_todo.xml     -> desain 1 baris tugas dalam list
    └── values/
        ├── strings.xml -> teks-teks yang dipakai app (nama app, dll)
        └── themes.xml   -> warna & gaya tampilan app
```

## Konsep Kunci yang Dipakai (Bagus untuk Dipelajari Lebih Lanjut)

- **Activity** — 1 layar dalam app Android. App ini cuma punya 1 (MainActivity).
- **RecyclerView + Adapter** — cara standar Android menampilkan list data yang
  bisa panjang/berubah-ubah, tanpa boros memori. Ini konsep yang WAJIB kamu
  kuasai karena dipakai di hampir semua app (termasuk WhatsApp, Instagram, dll).
- **View Binding** — cara modern mengakses komponen UI dari kode Kotlin tanpa
  `findViewById()` manual.
- **SharedPreferences** — penyimpanan sederhana key-value di HP, cocok untuk
  data kecil seperti settings atau (di sini) daftar tugas dalam format JSON.

## Ide Latihan Lanjutan (Setelah App Ini Jalan)

1. Tambahkan kategori/label untuk tiap tugas (misal: Kerja, Pribadi).
2. Tambahkan tanggal deadline + notifikasi pengingat.
3. Ganti SharedPreferences dengan **Room Database** (database SQLite yang lebih
   proper) — ini langkah alami berikutnya setelah paham dasar.
4. Tambahkan animasi saat item ditambah/dihapus.
5. Setelah semua di atas terasa nyaman, baru eksplorasi proyek yang lebih
   kompleks seperti app virtualization (VirtualApp dkk) yang kita bahas
   sebelumnya — fondasi dari app ini (Activity, Adapter, permission) akan
   sangat membantu memahami konsep itu.

Selamat belajar! Kalau ada error saat build atau mau nambah fitur, tanya saja.
