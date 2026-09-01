# Cara Dapat APK Siap Pakai (Tanpa Install Android Studio)

Project ini sudah dilengkapi workflow otomatis (`.github/workflows/build-apk.yml`)
yang akan build APK di server GitHub setiap kali kamu push kode.

## Langkah-Langkah

### 1. Buat akun GitHub (kalau belum punya)
Daftar gratis di https://github.com

### 2. Buat repository baru
- Klik tombol "+" di kanan atas GitHub -> "New repository"
- Kasih nama misalnya `todoapp-belajar`
- Set ke **Public** (biar GitHub Actions gratis tanpa batas)
- Klik "Create repository"

### 3. Upload project TodoApp ke repository itu
Paling gampang lewat browser (tanpa command line):
- Extract file `TodoApp.zip` di komputer kamu
- Di halaman repository GitHub yang baru dibuat, klik
  "uploading an existing file"
- Drag & drop SEMUA isi folder `TodoApp` (bukan folder-nya, tapi isinya)
- Scroll ke bawah, klik "Commit changes"

### 4. Tunggu APK dibuild otomatis
- Klik tab **"Actions"** di repository kamu
- Akan muncul proses "Build APK" yang sedang berjalan (lingkaran kuning berputar)
- Tunggu sampai jadi tanda centang hijau ✅ (biasanya 3-5 menit)

### 5. Download APK-nya
- Klik proses build yang sudah selesai (centang hijau)
- Scroll ke bawah, ada bagian **"Artifacts"**
- Klik `todoapp-debug-apk` untuk download (bentuknya .zip berisi file .apk)
- Extract, dapat file `app-debug.apk`

### 6. Install ke HP Android
- Kirim file `app-debug.apk` ke HP (via kabel USB, Google Drive, WhatsApp ke diri
  sendiri, dll)
- Di HP, buka file itu -> akan diminta izin "Install dari sumber tidak dikenal"
  -> izinkan
- Install seperti biasa

Selesai — app TodoApp buatanmu sudah berjalan di HP asli, tanpa install
Android Studio sama sekali di komputer.

## Catatan
- APK yang dihasilkan adalah **debug build** (untuk belajar/testing), belum
  ditandatangani untuk rilis ke Play Store — itu langkah terpisah nanti kalau
  sudah siap publish.
- Setiap kali kamu edit kode dan push ulang ke GitHub, APK baru akan otomatis
  ter-build lagi mengikuti perubahan itu.
