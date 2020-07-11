package demooop;

import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {

//	    private static String LoaiNhanVien;

	static Scanner DT = new Scanner(System.in);
	static ArrayList<nhanvien> listNV= new ArrayList<nhanvien>();

	public static void main(String[] args) {

		Menu();
	}

	static void Menu() {

		do {
			System.out.println("          CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN                    ");
			System.out.println("≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈");
			System.out.println("1-Nhập thông tin nhân viên");
			System.out.println("2-Xuất danh sách nhân viên");
			System.out.println("3-Sửa thông tin nhân viên");
			System.out.println("4-Xóa nhân viên");
			System.out.println("5-Tìm nhân viên theo mã");
			System.out.println("6-Sắp xếp nhân viên theo mức lương tăng dần");
			System.out.println("7-Sắp xếp nhân viên theo mức lương giảm dần");
			System.out.println("0 Kết thúc");
			System.out.println("≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈");
			System.out.println("CHỌN CHỨC NĂNG:");
			int So = check_Chon();

			switch (So) {

			case 1:
				System.out.println("1-Nhập thông tin nhân viên");
				NhapDSNV(listNV);
				break;
			case 2:
				System.out.println("2-Xuất danh sách nhân viên viên");
				XuatDSNV(listNV);
				break;
			case 3:
				System.out.println("3-Sửa thông tin nhân viên");
				CapNhatNV(listNV);
				break;
			case 4:
				System.out.println("4-Xóa nhân viên");
				XoaNV(listNV);
				break;
			case 5:
				System.out.println("5-Tìm nhân viên theo mã");
				TimNhanVien(listNV);
				break;
			case 6:
				System.out.println("6-Sắp xếp nhân viên theo mức lương tăng dần");
				LuongTangDan(listNV);
				break;
			case 7:
				System.out.println("7-Sắp xếp nhân viên theo mức lương giảm dần");
				LuongGiamDan(listNV);
				break;

			case 0:
				System.out.println("Thoát chương trình");
				System.exit(0);
				break;
			default:
				System.out.println("Chức năng nhập không hợp lệ. Vui lòng nhập đúng chức năng");
			}
		} while (true);

	}

	;

	public static void NhapDSNV(ArrayList<nhanvien> listNV) {
		System.out.println("Nhập số nhân viên: ");
		int soNV = check_Chonsonv();

		for (int i = 0; i < soNV; i++) {

			System.out.println("Chọn loại nhân viên: ");
			System.out.println("1- Nhân viên quản lý");
			System.out.println("2- Công nhân viên");
			int LoaiNV = check_Chonloainhanvien();

			switch (LoaiNV) {
			case 1:
				nhanvienquanly nvql = new nhanvienquanly();

//				System.out.println("Nhập mã nhân viên: ");
				nvql.setMaNV(check_MaNV(listNV));
//				System.out.println("Nhập họ tên nhân viên: ");
				nvql.setHoTen(check_HoTen());
//				System.out.println("Nhập địa chỉ: ");
				nvql.setDiaChi(check_DiaChi());
//				System.out.println("Nhập Email: ");
				nvql.setEmail(check_Email());
//				System.out.println("Nhập tuổi");
				nvql.setTuoi(check_Tuoi());
//				DT.nextLine();
//				System.out.println("Nhập loại nhân viên");
				nvql.setLoaiNhanVien(check_LoaiNhanVien());

//				nvql.setLoaiNhanVien("Nhân viên quản lý");
				listNV.add(nvql);
				break;
			case 2:
				congnhanvien cnv = new congnhanvien();

//				System.out.println("Nhập mã nhân viên: ");
				cnv.setMaNV(check_MaNV(listNV));
//				System.out.println("Nhập họ tên nhân viên: ");
				cnv.setHoTen(check_HoTen());
//				System.out.println("Nhập địa chỉ: ");
				cnv.setDiaChi(check_DiaChi());
//				System.out.println("Nhập Email: ");
				cnv.setEmail(check_Email());
//				System.out.println("Nhập tuổi");
				cnv.setTuoi(check_Tuoi());
//				System.out.println("Nhập loại nhân viên:");
//				DT.nextLine();
				cnv.setLoaiNhanVien(check_LoaiNhanVien());
//				cnv.setLoaiNhanVien("Công nhân viên");
				System.out.println("Nhập số giờ làm: ");
				cnv.setSogiolam(check_chonsogiovasanpham());
				System.out.println("Nhập số sản phẩm làm: ");
				cnv.setSosanpham(check_chonsogiovasanpham());
				listNV.add(cnv);
				break;
			default:
				System.out.println("Chức năng nhập không hợp lệ. Vui lòng nhập đúng chức năng");
			}

		}

	}

	public static void XuatDSNV(ArrayList<nhanvien> listNV) {
		for (nhanvien nv : listNV) {
			System.out.println("NV " + (listNV.indexOf(nv) + 1));
			nv.XuatThongTin();
		}
	}

	public static void XoaNV(ArrayList<nhanvien> listNV) {
		System.out.println("Nhập mã nhân viên cần xóa");

		String NhapMNV = DT.nextLine();
		int check = 0;
		for (nhanvien nv : listNV) {
			if (nv.getMaNV().equals(NhapMNV)) {
				listNV.remove(nv);
				System.out.println("Đã xóa thành công nhân viên: " + NhapMNV);
				XuatDSNV(listNV);
				check++;
				break;
			}

		}
		if (check == 0) {
			System.out.println("Mã nhân viên không tồn tại");
		}
	}

	public static void TimNhanVien(ArrayList<nhanvien> listNV) {
		System.out.println("Nhập mã nhân viên cần tìm: ");

		String NhapMNV = DT.nextLine();
		int check = 0;
		System.out.println("Thông tin nhân viên: ");
		for (nhanvien nv : listNV) {
			if (nv.getMaNV().equals(NhapMNV)) {
				nv.XuatThongTin();
				check++;
				break;
			}
		}
		if (check == 0) {
			System.out.println("Mã nhân viên không tồn tại");
		}

	}

	public static void CapNhatNV(ArrayList<nhanvien> listNV) {
		System.out.println("Nhập mã nhân viên cần cập nhật: ");
		String NhapMNV = DT.nextLine();
		DT.nextLine();
		int check = 0;
		for (nhanvien nv : listNV) {
			if (nv.getMaNV().equals(NhapMNV)) {
//				System.out.println("Nhập mã nhân viên: ");
//				nv.setMaNV(DT.nextLine());
//				System.out.println("Nhập họ tên nhân viên: ");
				nv.setHoTen(check_HoTen());
//				System.out.println("Nhập địa chỉ: ");
				nv.setDiaChi(check_DiaChi());
//				System.out.println("Nhập Email: ");
				nv.setEmail(check_Email());
//				System.out.println("Nhập tuổi");
				nv.setTuoi(check_Tuoi());
				listNV.set(listNV.indexOf(nv), nv);
				System.out.println("Cập nhật thành công");
			} else if (check == 0) {
				System.out.println("Mã nhân viên không tồn tại");
			}
		}
	}

	public static void LuongTangDan(ArrayList<nhanvien> listNV) {

		Collections.sort(listNV, new Comparator<nhanvien>() {

			@Override
			public int compare(nhanvien nv1, nhanvien nv2) {
				if (nv1.TinhLuong() > nv2.TinhLuong()) {
					return 1;
				} else {
					if (nv1.TinhLuong() == nv2.TinhLuong()) {
						return 0;
					} else {
						return -1;
					}
				}

			}

		});
		System.out.println("Danh sách tăng dần");
		for (int i = 0; i < listNV.size(); i++) {

			System.out.println("Tên nhân viên: " + listNV.get(i).getHoTen() + " - " + "Lương: "
					+ listNV.get(i).TinhLuong() + " VND");

		}
	}

	public static void LuongGiamDan(ArrayList<nhanvien> listNV) {
		Collections.sort(listNV, new Comparator<nhanvien>() {

			@Override
			public int compare(nhanvien nv1, nhanvien nv2) {
				if (nv1.TinhLuong() < nv2.TinhLuong()) {
					return 1;
				} else {
					if (nv1.TinhLuong() == nv2.TinhLuong()) {
						return 0;
					} else {
						return -1;
					}
				}

			}

		});
		System.out.println("Danh sách giảm dần");
		for (int i = 0; i < listNV.size(); i++) {

			System.out.println("Tên nhân viên: " + listNV.get(i).getHoTen() + " - " + "Lương: "
					+ listNV.get(i).TinhLuong() + " VND");
		}
		;

	}

	

	public static String check_MaNV(ArrayList<nhanvien> listNV) {
		String MaNV;
		
		while (true) {
			System.out.println("Nhập mã nhân viên :");

			String str = DT.nextLine();
			MaNV = str;
			
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;
			}
				
				if(!(ischeckMa(str))) {
				System.out.println("Trung ma nhan vien");
				
				continue;
			}else {
				return MaNV;
			}
		}
			
				
//////	       
//			
//			try {
//				MaNV = str;
//				for (int i = 0; i < listNV.size(); i++) {
//					if (!(MaNV.equals(listNV.get(i).getMaNV()))) {
//						System.out.println("Trùng mã nhân viên");
//						System.out.println("Vui lòng nhập lại");
//						
//					}
//					
//				}
//			} catch (Exception e) {
//				
//				
//			}
		
		

//			for (nhanvien nv : listNV) {
//				if ((str.equals(nv.getMaNV()))) {
//					System.out.println("Trùng mã nhân viên");
//
//					System.out.println("Vui lòng nhập lại");
////					check_MaNV(listNV);
//
//				}
//
//			}
			
				
				
		}
		
	
	
	public static boolean ischeckMa(String input) {
		for(nhanvien nv : listNV) {
			if((nv.getMaNV().equals(input))) {
				return false;
			}else {
				return true;
			}
		}
		return true;
		
		
	}

	public static String check_HoTen() {
		String HoTen;

		while (true) {
			System.out.println("Nhập họ tên nhân viên :");
			String str = DT.nextLine();

			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}

			HoTen = str;
			int i = 0;
			// int sz = HoTen.length();
//
//			for (int i = 0; i < sz; i++) {
//				if (Character.isLetter(HoTen.charAt(i))) {
//					return HoTen;
//					
//
//				} else {
//					System.out.println("Vui lòng nhập chữ");
//				}
//
//			}
//		
			if (Character.isLetter(HoTen.charAt(i))) {
				return HoTen;

			} else {
				System.out.println("Vui lòng nhập chữ");
			}

		}

	}

	public static String check_Email() {

		String Email;
		while (true) {
			System.out.println("Nhập Email :");
			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}

//	        try {
//	            Email = str;
//	        } catch (NumberFormatException ex) {
//	           
//	            continue;
//	        }
			Email = str;
			if (!Email.matches("\\w+@\\w+(\\.\\w+){1,2}")) {
				System.out.println("Nhập đúng định dạng Email");
				continue;
			}
			return Email;
		}

	}

	public static String check_DiaChi() {
		String DiaChi;
		while (true) {
			System.out.println("Nhập địa chỉ :");
			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}
			DiaChi = str;

			return DiaChi;
		}

	}

	public static String check_LoaiNhanVien() {
		String LoaiNhanVien;
		while (true) {
			System.out.println("Vai trò nhân viên :");
			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}
			LoaiNhanVien = str;

			return LoaiNhanVien;
		}

	}

	public static int check_Tuoi() {
		int Tuoi;
		while (true) {
			System.out.println("Nhập tuổi :");
			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}

			try {
				Tuoi = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				System.out.println("Vui lòng chỉ nhập số");
				continue;
			}
			if (Tuoi < 18 || Tuoi > 65) {
				System.out.println("Tuổi phải nằm trong khoảng 18 đến 65");
				continue;
			}
			return Tuoi;
		}

	}

	public static int check_Chon() {
		int Chon;
		while (true) {

			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}

			try {
				Chon = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				System.out.println("Vui lòng chỉ nhập số");
				continue;
			}
			if (Chon < 0) {
				System.out.println("Không được nhập số âm");
				System.out.println("Vui lòng nhập lại");
				continue;
			}
			return Chon;
		}

	}

	public static int check_Chonsonv() {
		int Chonsnv;
		while (true) {

			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}

			try {
				Chonsnv = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				System.out.println("Vui lòng chỉ nhập số");
				continue;
			}
			if (Chonsnv < 0) {
				System.out.println("Không được nhập số âm");
				System.out.println("Vui lòng nhập lại");
				continue;
			}
			return Chonsnv;
		}

	}

	public static int check_Chonloainhanvien() {
		int Chonloainv;
		while (true) {

			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}

			try {
				Chonloainv = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				System.out.println("Vui lòng chỉ nhập số");
				continue;
			}
			if (Chonloainv != 1 && Chonloainv != 2) {
				System.out.println("Chỉ được chọn 1 và 2");
				System.out.println("Vui lòng nhập lại");
				continue;
			}
			return Chonloainv;
		}

	}

	public static int check_chonsogiovasanpham() {
		int Chongiovasp;
		while (true) {

			String str = DT.nextLine();
			if (str.trim().equals("")) {
				System.out.println("Không được để trống.");
				continue;

			}

			try {
				Chongiovasp = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				System.out.println("Vui lòng chỉ nhập số");
				continue;
			}
			if (Chongiovasp < 0) {
				System.out.println("Không được nhập số âm");
				System.out.println("Vui lòng nhập lại");
				continue;
			}
			return Chongiovasp;
		}
	}
}