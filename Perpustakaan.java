import java.util.Scanner;

public class Perpustakaan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            String NamaPeminjam, NamaBuku, NIM, kategori;
            int JumlahBuku, JumlahHari;
            double harga_buku, bayar, pembayaran, kembalian;

            System.out.println("Masukkan Kategori : ");
            kategori = input.nextLine();
            System.out.println("Masukkan NIM anda: ");
            NIM = input.nextLine();
            System.out.println("Masukkan Nama Anda ");
            NamaPeminjam = input.nextLine();
            System.out.println("Masukkan nama Buku ");
            NamaBuku = input.nextLine();
            System.out.println("Jumlah Buku ");
            JumlahBuku = input.nextInt();
            System.out.println("Masukkan harga Buku ");
            harga_buku = input.nextDouble();

            System.out.println("Jumlah Hari ");
            JumlahHari = input.nextInt();

            if (kategori.equals("warga polinema")) {
                if (JumlahBuku > 4) {
                    bayar = (JumlahBuku * harga_buku + harga_buku * JumlahHari)
                            - ((JumlahBuku * harga_buku + harga_buku * JumlahHari) * 0.10);
                    System.out.println("total transaksi anda adalah " + bayar);
                    System.out.println("Masukkan nominal pembayaran anda : ");
                    pembayaran = input.nextDouble();
                    kembalian = pembayaran - bayar;
                    if (pembayaran > bayar) {
                        System.out.println("***********Transaksi***********");
                        System.out.println("NIM : " + NIM);
                        System.out.println("Nama : " + NamaPeminjam);
                        System.out.println("Buku : " + NamaBuku);
                        System.out.println("Jumlah Buku : " + JumlahBuku);
                        System.out.println("Lama Pinjam : " + JumlahHari);
                        System.out.println("Bayar : " + bayar);
                        System.out.println("Total Pembayaran anda : " + pembayaran);
                        System.out.println("Kembalian anda adalah : " + kembalian);
                    } else {
                        System.out.println("***********Transaksi***********");
                        System.out.println("NIM : " + NIM);
                        System.out.println("Nama : " + NamaPeminjam);
                        System.out.println("Buku : " + NamaBuku);
                        System.out.println("Jumlah Buku : " + JumlahBuku);
                        System.out.println("Lama Pinjam : " + JumlahHari);
                        System.out.println("Bayar : " + bayar);
                        System.out.println("Total Pembayaran anda : " + pembayaran);
                        System.out.println("uang anda pas");
                    }
                } else {
                    bayar = (JumlahBuku * harga_buku + harga_buku * JumlahHari)
                            - ((JumlahBuku * harga_buku + harga_buku * JumlahHari) * 0.05);
                    System.out.println("total transaksi anda adalah " + bayar);
                    System.out.println("Masukkan nominal pembayaran anda : ");
                    pembayaran = input.nextDouble();
                    kembalian = pembayaran - bayar;
                    if (pembayaran > bayar) {
                        System.out.println("***********Transaksi***********");
                        System.out.println("NIM : " + NIM);
                        System.out.println("Nama : " + NamaPeminjam);
                        System.out.println("Buku : " + NamaBuku);
                        System.out.println("Jumlah Buku : " + JumlahBuku);
                        System.out.println("Lama Pinjam : " + JumlahHari);
                        System.out.println("Bayar : " + bayar);
                        System.out.println("Total Pembayaran anda : " + pembayaran);
                        System.out.println("Kembalian anda adalah : " + kembalian);
                    } else {
                        System.out.println("***********Transaksi***********");
                        
                        System.out.println("NIM : " + NIM);
                        System.out.println("Nama : " + NamaPeminjam);
                        System.out.println("Buku : " + NamaBuku);
                        System.out.println("Jumlah Buku : " + JumlahBuku);
                        System.out.println("Lama Pinjam : " + JumlahHari);
                        System.out.println("Bayar : " + bayar);
                        System.out.println("Total Pembayaran anda : " + pembayaran);
                        System.out.println("uang anda pas");
                    }

                }
            } else if (JumlahBuku > 5) {
                bayar = (JumlahBuku * harga_buku + harga_buku * JumlahHari)
                        - ((JumlahBuku * harga_buku + harga_buku * JumlahHari) * 0.02);
                System.out.println("Total transaksi anda adalah " + bayar);
                System.out.println("Masukkan nominal pembayaran anda :");
                pembayaran = input.nextDouble();
                if (pembayaran > bayar) {
                    kembalian = pembayaran - bayar;
                    System.out.println("***********Transaksi***********");
                    System.out.println("NIM : " + NIM);
                    System.out.println("Nama : " + NamaPeminjam);
                    System.out.println("Buku : " + NamaBuku);
                    System.out.println("Jumlah Buku : " + JumlahBuku);
                    System.out.println("Lama Pinjam : " + JumlahHari);
                    System.out.println("Bayar : " + bayar);
                    System.out.println("Total Pembayaran anda : " + pembayaran);
                    System.out.println("Kembalian anda adalah " + kembalian);
                } else {
                    System.out.println("***********Transaksi***********");
                    System.out.println("NIM : " + NIM);
                    System.out.println("Nama : " + NamaPeminjam);
                    System.out.println("Buku : " + NamaBuku);
                    System.out.println("Jumlah Buku : " + JumlahBuku);
                    System.out.println("Lama Pinjam : " + JumlahHari);
                    System.out.println("Bayar : " + bayar);
                    System.out.println("Total Pembayaran anda : " + pembayaran);
                    System.out.println("uang anda pas");
                }
            } else
                bayar = JumlahBuku * harga_buku + harga_buku * JumlahHari;
            System.out.println("Total transaksi anda adalah " + bayar);
            System.out.println("Masukkan nominal pembayaran anda :");
            pembayaran = input.nextDouble();
            if (pembayaran > bayar) {
                kembalian = pembayaran - bayar;
                System.out.println("***********Transaksi***********");
                System.out.println("NIM : " + NIM);
                System.out.println("Nama : " + NamaPeminjam);
                System.out.println("Buku : " + NamaBuku);
                System.out.println("Jumlah Buku : " + JumlahBuku);
                System.out.println("Lama Pinjam : " + JumlahHari);
                System.out.println("Bayar : " + bayar);
                System.out.println("Total Pembayaran anda : " + pembayaran);
                System.out.println("Kembalian anda adalah " + kembalian);
            } else {
                System.out.println("***********Transaksi***********");
                System.out.println("NIM : " + NIM);
                System.out.println("Nama : " + NamaPeminjam);
                System.out.println("Buku : " + NamaBuku);
                System.out.println("Jumlah Buku : " + JumlahBuku);
                System.out.println("Lama Pinjam : " + JumlahHari);
                System.out.println("Bayar : " + bayar);
                System.out.println("Total Pembayaran anda : " + pembayaran);
                System.out.println("uang anda pas");
            }

            System.out.println("Apakah Anda ingin melakukan transaksi lagi? (ya/tidak): ");
            input.nextLine(); // Membersihkan buffer
        } while (input.nextLine().equalsIgnoreCase("ya"));

        System.out.println("Terima kasih!");
        input.close();
    }
}