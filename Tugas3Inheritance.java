import java.util.Scanner;
import java.util.ArrayList;

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
            System.out.println("Input nilai anda salah"); [cite: 378]
        }
    }
}

public class Tugas3Inheritance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); [cite: 372]
        ArrayList<DataNilai> listMhs = new ArrayList<>();
        
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        int jumlah = input.nextInt();
        double totalNilai = 0;

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nMahasiswa ke-" + (i + 1));
            System.out.print("NIM   : "); String nim = input.next();
            System.out.print("Nama  : "); String nama = input.next();
            System.out.print("Nilai : "); double nilai = input.nextDouble();
            
            DataNilai mhs = new DataNilai(nim, nama, nilai);
            listMhs.add(mhs);
            totalNilai += mhs.nilai;
        }

        StringBuilder lulus = new StringBuilder();
        StringBuilder tdkLulus = new StringBuilder();
        StringBuilder gradeA = new StringBuilder();
        StringBuilder gradeB = new StringBuilder();
        StringBuilder gradeD = new StringBuilder();
        
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

            if (m.grade.equals("A")) { nA++; gradeA.append(m.nama).append(", "); }
            if (m.grade.equals("B")) { nB++; gradeB.append(m.nama).append(", "); }
            if (m.grade.equals("D")) { nD++; gradeD.append(m.nama).append(", "); }
        }

        System.out.println("Jumlah Mahasiswa: " + jumlah);
        System.out.println("Jumlah Mahasiswa yg Lulus: " + nLulus + " yaitu " + lulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus: " + nTdkLulus + " yaitu " + tdkLulus);
        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + nA + " yaitu " + gradeA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B = " + nB + " yaitu " + gradeB);
        System.out.println("Jumlah Mahasiswa dengan Nilai D = " + nD + " yaitu " + gradeD);
        System.out.println("Rata-rata nilai mahasiswa adalah: " + (totalNilai / jumlah));
    }
}
