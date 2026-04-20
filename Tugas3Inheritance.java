import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class Mahasiswa {
    String nim, nama;
    double nilai;
    String grade, status;

    public Mahasiswa(String nim, String nama, double nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }
}

class DataNilai extends Mahasiswa {
    public DataNilai(String nim, String nama, double nilai) {
        super(nim, nama, nilai);
        hitungGrade();
    }

    private void hitungGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            status = "lulus";
        } else if (nilai >= 70 && nilai < 80) {
            grade = "B";
            status = "lulus";
        } else if (nilai >= 60 && nilai < 70) {
            grade = "C";
            status = "lulus";
        } else if (nilai >= 50 && nilai < 60) {
            grade = "D";
            status = "tidak lulus";
        } else if (nilai >= 0 && nilai < 50) {
            grade = "E";
            status = "tidak lulus";
        } else {
            grade = "Salah";
        }
    }
}

public class Tugas3Inheritance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        ArrayList<DataNilai> listMhs = new ArrayList<>();
        
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine();

        double totalNilai = 0;

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nInput Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : "); 
            String nim = input.nextLine(); 
            
            System.out.print("Nama  : "); 
            String nama = input.nextLine(); 
            
            System.out.print("Nilai : "); 
            double nilai = input.nextDouble();
            input.nextLine(); 

            if (nilai < 0 || nilai > 100) {
                System.out.println("Input nilai anda salah!");
            }

            DataNilai mhs = new DataNilai(nim, nama, nilai);
            listMhs.add(mhs);
            totalNilai += mhs.nilai;
        }

        StringBuilder lulus = new StringBuilder();
        StringBuilder tdkLulus = new StringBuilder();
        int nLulus = 0, nTdkLulus = 0, nA = 0, nB = 0, nD = 0;

        System.out.println("\n--- HASIL OUTPUT ---");
        for (DataNilai m : listMhs) {
            System.out.println("NIM: " + m.nim + "\nNama: " + m.nama + "\nNilai: " + m.nilai + "\nGrade: " + m.grade + "\n===");
            
            if (m.status.equals("lulus")) {
                nLulus++;
                lulus.append(m.nama).append(", ");
            } else {
                nTdkLulus++;
                tdkLulus.append(m.nama).append(", ");
            }
            if (m.grade.equals("A")) nA++;
            if (m.grade.equals("B")) nB++;
            if (m.grade.equals("D")) nD++;
        }

        System.out.println("Jumlah Mahasiswa: " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus: " + nLulus + " yaitu " + lulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus: " + nTdkLulus + " yaitu " + tdkLulus);
        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + nA);
        System.out.println("Rata-rata nilai: " + (totalNilai / jumlah));
        
        input.close();
    }
}
