package demooop;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.text.spi.DecimalFormatSymbolsProvider;
import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

abstract public class nhanvien {
	private String MaNV;
	private String HoTen;
	private String DiaChi;
	private String Email;
	private String LoaiNhanVien;
	protected static double Luong;
	
	private int Tuoi;
	static Scanner DT = new Scanner(System.in);
	
	
	public nhanvien() {
		
	}

	

	public static double getLuong() {
		return Luong;
	}

	public static void setLuong(double luong) {
		Luong = luong;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLoaiNhanVien() {
		return LoaiNhanVien;
	}

	public void setLoaiNhanVien(String loaiNhanVien) {
		LoaiNhanVien = loaiNhanVien;
	}

	public int getTuoi() {
		return Tuoi;
	}

	public void setTuoi(int tuoi) {
		Tuoi = tuoi;
	}
	Locale locale = new Locale("vi", "VN");
	NumberFormat format = NumberFormat.getCurrencyInstance(locale);
	
	
	
	
	
	
	
	
	
	
	public void XuatThongTin() {
		System.out.println("Mã nhân viên: "+MaNV);
		System.out.println("Họ tên nhân viên: "+HoTen);
		System.out.println("Địa chỉ: "+DiaChi);
		System.out.println("Email: "+Email);
		System.out.println("Tuổi: "+Tuoi);
		System.out.println("Vai trò nhân viên: "+LoaiNhanVien);
		System.out.println("Lương: "+format.format(TinhLuong()));
	}
	abstract public  double TinhLuong();

	
		
	
	
}

