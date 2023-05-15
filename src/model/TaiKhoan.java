package model;

public class TaiKhoan {
	private String TaiKhoan;
	private String Matkhau;
	private int Quyen;
	private String MA_NV;
	
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan(String taiKhoan, String matkhau) {
		TaiKhoan = taiKhoan;
		Matkhau = matkhau;
	}
	
	public TaiKhoan(String taiKhoan, String matkhau, int quyen, String mA_NV) {
		TaiKhoan = taiKhoan;
		Matkhau = matkhau;
		Quyen = quyen;
		MA_NV = mA_NV;
	}

	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.TaiKhoan = taiKhoan;
	}

	public String getMatkhau() {
		return Matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.Matkhau = matkhau;
	}

	public int getQuyen() {
		return Quyen;
	}

	public void setQuyen(int quyen) {
		this.Quyen = quyen;
	}

	public String getMA_NV() {
		return MA_NV;
	}

	public void setMA_NV(String mA_NV) {
		this.MA_NV = mA_NV;
	}
	
	
}
