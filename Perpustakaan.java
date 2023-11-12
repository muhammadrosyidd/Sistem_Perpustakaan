import java.util.Scanner;

public class Perpustakaan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Maksimum jumlah transaksi yang bisa disimpan
        int maxTransaksi = 100;
        String[][] transaksi = new String[maxTransaksi][7]; // Array untuk menyimpan data transaksi
        String[][] daftarBuku = {
                { "1.Air", "2000" },
                { "2.Hujan", "2000" },
                { "3.Robin", "2500" },
                { "4.Konsep Teknologi", "1000" }
        };

        int Transaksi = 0; // Indeks transaksi saat ini
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Pencarian Transaksi");
            System.out.println("3. Exit");
            System.out.print("Pilih menu (1/2/3): ");
            int menu = input.nextInt();

            if (menu == 1) {
                do {
                    String NamaPeminjam, NIM, kategori;
                    int JumlahHari;
                    double pembayaran, kembalian;

                    System.out.println("*****List Buku*****");
                    for (int i = 0; i < daftarBuku.length; i++) {
                        System.out.println(daftarBuku[i][0] + " - Harga: " + daftarBuku[i][1]);
                    }
                    System.out.print("Masukkan Kategori : ");
                    kategori = input.next();
                    System.out.print("Masukkan NIM anda: ");
                    NIM = input.next();
                    System.out.print("Masukkan Nama Anda ");
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

                        double diskon = 0.0;
                        if (kategori.equalsIgnoreCase("polinema") && totalBuku > 3) {
                            diskon = 0.10;
                        } else if (totalBuku > 3) {
                            diskon = 0.05;
                        }

                        double subTotal = (totalBuku * harga_buku)
                                - (totalBuku * harga_buku * diskon);
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

                    System.out.println("***********Transaksi***********");
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

                System.out.println("***********Daftar Transaksi***********");
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
        input.close();

    }
}
