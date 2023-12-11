import java.util.Scanner;

public class Perpustakaan {

    static Scanner input = new Scanner(System.in);
    static int maxTransaksi = 100;
    static String[][] transaksi = new String[maxTransaksi][8];
    static String[][] daftarBuku = {
            { "1.Air", "2000", "10" }, // Adding stock information
            { "2.Hujan", "2000", "8" },
            { "3.Robin", "2500", "5" },
            { "4.Konsep Teknologi", "1000", "15" }
    };
    static int Transaksi = 0;

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int menu = input.nextInt();

            switch (menu) {
                case 1:
                    pinjamBuku();
                    break;
                case 2:
                    pencarian();
                    break;
                case 3:
                    PengembalianBuku();
                    break;
                case 4:
                    TampilanStok(); // Add a new option to display stock
                    break;
                case 5:
                    LaporanTransaksi();
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang valid.");
<<<<<<< HEAD
            }
        }

    }
=======
                    
            if (menu == 1) {
                do {
                    String NamaPeminjam, NIM, kategori;
                    int JumlahHari;
                    double pembayaran, kembalian;

                    System.out.println("**List Buku**");
                    for (int i = 0; i < daftarBuku.length; i++) {
                        System.out.println(daftarBuku[i][0] + " - Harga: " + daftarBuku[i][1]);
                    }
                    System.out.print("Masukkan Kategori : ");
                    kategori = input.next();
                    System.out.print("Masukkan NIM anda: ");
                    NIM = input.next();
                    System.out.print("Masukkan Nama Anda: ");
                    NamaPeminjam = input.next();

                    int totalBuku = 0;
                    double totalBayar = 0.0;
                    String bukuDipinjam="";
                    // Nested loop untuk memasukkan beberapa buku dalam satu transaksi
                    while (true) {
                        System.out.print("Masukkan nomor buku yang dipinjam (0 untuk selesai): ");
                        int nomorBuku = input.nextInt();
                        if (nomorBuku == 0) {
                            break; // Keluar dari nested loop jika 0 dimasukkan
                        }

                        System.out.print("Jumlah Buku: ");
                        int JumlahBuku = input.nextInt();
                        totalBuku += JumlahBuku;

                        double harga_buku = Double.parseDouble(daftarBuku[nomorBuku - 1][1]);
                        double subBuku=JumlahBuku*harga_buku;
                        double diskon = 0.0;
                        if (kategori.equalsIgnoreCase("polinema") && totalBuku > 3) {
                            diskon = 0.10;
                        } else if (totalBuku > 3) {
                            diskon = 0.05;
                        }

                        double subTotal = (subBuku)
                                - (subBuku * diskon);
                        totalBayar += subTotal;
                        System.out.println("Subtotal transaksi buku ini: " + subTotal);
                        bukuDipinjam += daftarBuku[nomorBuku - 1][0] + " (" + JumlahBuku + " buku), ";
                    }

                    System.out.print("Masukkan jumlah hari pinjam: ");
                    JumlahHari = input.nextInt();

                    totalBayar = totalBayar * JumlahHari;

                    System.out.println("Total transaksi anda adalah " + totalBayar);
                    System.out.print("Masukkan nominal pembayaran anda : ");
                    pembayaran = input.nextDouble();
                    kembalian = pembayaran - totalBayar;

                    transaksi[Transaksi][0] = NIM;
                    transaksi[Transaksi][1] = NamaPeminjam;
                    transaksi[Transaksi][2] = bukuDipinjam;
                    transaksi[Transaksi][3] = Integer.toString(totalBuku);
                    transaksi[Transaksi][4] = Integer.toString(JumlahHari);
                    transaksi[Transaksi][5] = Double.toString(totalBayar);
                    transaksi[Transaksi][6] = Double.toString(pembayaran);

                    System.out.println("****Transaksi****");
                    System.out.println("NIM : " + NIM);
                    System.out.println("Nama : " + NamaPeminjam);
                    System.out.println("Buku : "+bukuDipinjam);
                    System.out.println("Jumlah Buku : " + totalBuku);
                    System.out.println("Lama Pinjam : " + JumlahHari + " hari");
                    System.out.println("Bayar : " + totalBayar);
                    System.out.println("Total Pembayaran anda : " + pembayaran);
                    System.out.println("Kembalian anda adalah : " + kembalian);

                    Transaksi++; // Pindah ke transaksi berikutnya

                    System.out.println("Apakah Anda ingin melakukan transaksi lagi? (ya/tidak): ");
                    input.nextLine(); // Membersihkan buffer
                } while (input.nextLine().equalsIgnoreCase("ya"));

                System.out.println("****Daftar Transaksi****");
                for (int i = 0; i < Transaksi; i++) {
                    System.out.println("Transaksi ke-" + (i + 1));
                    System.out.println("NIM : " + transaksi[i][0]);
                    System.out.println("Nama : " + transaksi[i][1]);
                    System.out.println("Buku : " + transaksi[i][2]);
                    System.out.println("Jumlah Buku : " + transaksi[i][3]);
                    System.out.println("Lama Pinjam : " + transaksi[i][4] + " hari");
                    System.out.println("Bayar : " + transaksi[i][5]);
                    System.out.println("Total Pembayaran anda : " + transaksi[i][6]);
                    System.out.println();
                }
                System.out.println("Terima kasih!");
            } else if (menu == 2) {
                // Pencarian berdasarkan nama buku atau nama peminjam
                System.out.println("Ingin mencari transaksi berdasarkan nama buku atau nama peminjam? (ya/tidak): ");
                String cariTransaksi = input.next();
                if (cariTransaksi.equalsIgnoreCase("ya")) {
                    System.out.println("Cari berdasarkan (Nama Buku/Nama Peminjam): ");
                    String jenisPencarian = input.next();
                    System.out.println("Masukkan nilai yang ingin dicari: ");
                    String nilaiCari = input.next();

                    boolean ditemukan = false;
                    for (int i = 0; i < Transaksi; i++) {
                        if ((jenisPencarian.equalsIgnoreCase("Nama Buku")
                                && transaksi[i][2].equalsIgnoreCase(nilaiCari))
                                || (jenisPencarian.equalsIgnoreCase("Nama Peminjam")
                                        && transaksi[i][1].equalsIgnoreCase(nilaiCari))) {
                            System.out.println("Transaksi ke-" + (i + 1));
                            System.out.println("NIM : " + transaksi[i][0]);
                            System.out.println("Nama : " + transaksi[i][1]);
                            System.out.println("Buku : " + transaksi[i][2]);
                            System.out.println("Jumlah Buku : " + transaksi[i][3]);
                            System.out.println("Lama Pinjam : " + transaksi[i][4] + " hari");
                            System.out.println("Bayar : " + transaksi[i][5]);
                            System.out.println("Total Pembayaran anda : " + transaksi[i][6]);
                            System.out.println();
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Transaksi tidak ditemukan.");
                    }
                }
            } else if (menu == 3) {
                System.out.println("Terima kasih!");
                break; // Keluar dari program
            } else {
                System.out.println("Menu tidak valid. Silakan pilih menu yang valid.");
            }
        }
     }
 }
>>>>>>> 48acd711d1bf3c6edf4c74c671f5419fc83922af

    static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Pinjam Buku");
        System.out.println("2. Pencarian Transaksi");
        System.out.println("3. Pengembalian Buku");
        System.out.println("4. Lihat Stok Buku");
        System.out.println("5. Laporan");
        System.out.println("6. Exit");
        System.out.print("Pilih menu (1/2/3/4/5/6): ");
    }

    static void pinjamBuku() {
        do {
            String NamaPeminjam, NIM, kategori;
            int JumlahHari;
            double pembayaran, kembalian;

            System.out.println("*****List Buku*****");
            for (int i = 0; i < daftarBuku.length; i++) {
                System.out.println(daftarBuku[i][0] + " - Harga: " + daftarBuku[i][1] + " - Stok: " + daftarBuku[i][2]);
            }
            System.out.print("Masukkan Kategori : ");
            kategori = input.next();
            System.out.print("Masukkan NIM/NIK anda: ");
            NIM = input.next();
            System.out.print("Masukkan Nama Anda: ");
            NamaPeminjam = input.next();

            int totalBuku = 0;
            double totalBayar = 0.0;
            String bukuDipinjam = "";
            // Nested loop untuk memasukkan beberapa buku dalam satu transaksi
            while (true) {
                System.out.print("Masukkan nomor buku yang dipinjam (0 untuk selesai): ");
                int nomorBuku = input.nextInt();
                if (nomorBuku == 0) {
                    break; // Keluar dari nested loop jika 0 dimasukkan
                }

                System.out.print("Jumlah Buku: ");
                int JumlahBuku = input.nextInt();

                // Cek persediaan buku
                if (JumlahBuku > Integer.parseInt(daftarBuku[nomorBuku - 1][2])) {
                    System.out.println("Stok tidak mencukupi!");
                    continue;
                }

                totalBuku += JumlahBuku;

                // Update stock
                int currentStock = Integer.parseInt(daftarBuku[nomorBuku - 1][2]);
                daftarBuku[nomorBuku - 1][2] = String.valueOf(currentStock - JumlahBuku);

                double harga_buku = Double.parseDouble(daftarBuku[nomorBuku - 1][1]);
                double subBuku = JumlahBuku * harga_buku;
                ;
                totalBayar += subBuku;
                System.out.println("Subtotal transaksi buku ini: " + subBuku);
                bukuDipinjam += daftarBuku[nomorBuku - 1][0] + " (" + JumlahBuku + " buku), ";
            }

            System.out.print("Masukkan jumlah hari pinjam: ");
            JumlahHari = input.nextInt();

            double diskon = 0.0;
            if (kategori.equalsIgnoreCase("polinema") && totalBuku > 3) {
                diskon = 0.10;
            } else if (totalBuku > 3) {
                diskon = 0.05;
            }

            totalBayar = totalBayar - (totalBayar * diskon);
            totalBayar = totalBayar * JumlahHari;

            System.out.println("Total transaksi anda adalah " + totalBayar);
            System.out.print("Masukkan nominal pembayaran anda : ");
            pembayaran = input.nextDouble();
            kembalian = pembayaran - totalBayar;

            transaksi[Transaksi][0] = NIM;
            transaksi[Transaksi][1] = NamaPeminjam;
            transaksi[Transaksi][2] = bukuDipinjam;
            transaksi[Transaksi][3] = Integer.toString(totalBuku);
            transaksi[Transaksi][4] = Integer.toString(JumlahHari);
            transaksi[Transaksi][5] = Double.toString(totalBayar);
            transaksi[Transaksi][6] = Double.toString(pembayaran);
            transaksi[Transaksi][7] = "Belum Dikembalikan";


            System.out.println("***********Transaksi***********");
            System.out.println("NIM : " + NIM);
            System.out.println("Nama : " + NamaPeminjam);
            System.out.println("Buku : " + bukuDipinjam);
            System.out.println("Jumlah Buku : " + totalBuku);
            System.out.println("Lama Pinjam : " + JumlahHari + " hari");
            System.out.println("Bayar : " + totalBayar);
            System.out.println("Total Pembayaran anda : " + pembayaran);
            System.out.println("Kembalian anda adalah : " + kembalian);

            Transaksi++; // Pindah ke transaksi berikutnya

            displayHistoriTransaksi();
            System.out.println("Apakah Anda ingin melakukan transaksi lagi? (ya/tidak): ");
            input.nextLine(); // Membersihkan buffer
        } while (input.nextLine().equalsIgnoreCase("ya"));
    }

    static void PengembalianBuku() {
        System.out.print("Masukkan NIM anda: ");
        String NIM = input.next();
    
        boolean found = false;
        for (int i = 0; i < Transaksi; i++) {
            if (transaksi[i][0].equals(NIM)) {
                // Display detail transaksi
                DetailTransaksi(i);
    
                // Perbarui ketersediaan buku ketika buku dikembalikan
                updateKetersediaanBuku(i);
    
                System.out.println("Buku berhasil dikembalikan.");
    
                // Ubah status pengembalian di dalam transaksi
                transaksi[i][7] = "Sudah dikembalikan";
    
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }

    static void updateKetersediaanBuku(int transactionIndex) {
        // Update the availability status and stock of books based on the transaction
        String[] borrowedBooks = transaksi[transactionIndex][2].split(", ");
        for (String borrowedBook : borrowedBooks) {
            int bookIndex = Integer.parseInt(borrowedBook.split("\\.")[0]) - 1;
            int currentStock = Integer.parseInt(daftarBuku[bookIndex][2]);
            int returnedQuantity = Integer.parseInt(borrowedBook.split("\\(")[1].split(" ")[0]);
            daftarBuku[bookIndex][2] = String.valueOf(currentStock + returnedQuantity);
        }
    }

    static void TampilanStok() {
        System.out.println("***********Stok Buku***********");
        for (int i = 0; i < daftarBuku.length; i++) {
            System.out.println(daftarBuku[i][0] + " - Stok: " + daftarBuku[i][2]);
        }
    }
    static void LaporanTransaksi() {
        System.out.println("***********Laporan Transaksi***********");
        for (int i = 0; i < Transaksi; i++) {
            DetailTransaksi(i);
        }
        System.out.println("Terima kasih!");
    }
    static void pencarian() {
        System.out.println("Ingin mencari transaksi berdasarkan nama buku atau nama peminjam? (ya/tidak): ");
        String cariTransaksi = input.next();
        if (cariTransaksi.equalsIgnoreCase("ya")) {
            System.out.println("Cari berdasarkan (Nama_Buku/Nama_Peminjam): ");
            String jenisPencarian = input.next();
            System.out.println("Masukkan nilai yang ingin dicari: ");
            String nilaiCari = input.next();

            boolean ditemukan = false;
            for (int i = 0; i < Transaksi; i++) {
                if ((jenisPencarian.equalsIgnoreCase("Nama_Buku")
                        && transaksi[i][2].equalsIgnoreCase(nilaiCari))
                        || (jenisPencarian.equalsIgnoreCase("Nama_Peminjam")
                                && transaksi[i][1].equalsIgnoreCase(nilaiCari))) {
                    DetailTransaksi(i);
                    ditemukan = true;
                }
            }

            if (!ditemukan) {
                System.out.println("Transaksi tidak ditemukan.");
            }
        }
    }

    static void displayHistoriTransaksi() {
        System.out.println("***********Daftar Transaksi***********");
        for (int i = 0; i < Transaksi; i++) {
            DetailTransaksi(i);
        }
        System.out.println("Terima kasih!");
    }
    static void DetailTransaksi(int index) {
        System.out.println("Transaksi ke-" + (index + 1));
        System.out.println("NIM : " + transaksi[index][0]);
        System.out.println("Nama : " + transaksi[index][1]);
        System.out.println("Buku : " + transaksi[index][2]);
        System.out.println("Jumlah Buku : " + transaksi[index][3]);
        System.out.println("Lama Pinjam : " + transaksi[index][4] + " hari");
        System.out.println("Bayar : " + transaksi[index][5]);
        System.out.println("Total Pembayaran anda : " + transaksi[index][6]);
        System.out.println("Status Pengembalian : " + transaksi[index][7]);
    }
    
    
 
}