package demooop;

public class congnhanvien extends nhanvien {

	private int sosanpham;
	private int sogiolam;
	
	@Override
	public double TinhLuong() {
		if(sogiolam<=40) {
			Luong=sogiolam*20000 + sosanpham*10000 ;
		}else {
			Luong=(sogiolam*20000 + (sogiolam-40)*1.5*20000 + sosanpham*10000);
		}
		return super.getLuong();
	}

	public int getSosanpham() {
		return sosanpham;
	}

	public void setSosanpham(int sosanpham) {
		this.sosanpham = sosanpham;
	}

	public int getSogiolam() {
		return sogiolam;
	}

	public void setSogiolam(int sogiolam) {
		this.sogiolam = sogiolam;
	}
	

}
