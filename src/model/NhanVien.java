package model;

import java.sql.Date;

public class NhanVien {
	private String MA_NV;
	private String TenNV;
	private Date NgSinh;
	private String DiaChi;
	private String SDT;
	private String MA_CV;
	private static int maSV = 1;
	
	public static void main(String[] args) {
		int i = 5;
		while (i>0) {
			System.out.println(maSV);
			i--;
		}
	}
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String mA_NV, String tenNV, Date ngSinh, String diaChi, String sDT, String mA_CV) {
		MA_NV = mA_NV;
		TenNV = tenNV;
		NgSinh = ngSinh;
		DiaChi = diaChi;
		SDT = sDT;
		MA_CV = mA_CV;
	}

	public String getMA_NV() {
		return MA_NV;
	}

	public void setMA_NV(String mA_NV) {
		this.MA_NV = mA_NV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		this.TenNV = tenNV;
	}

	public Date getNgSinh() {
		return NgSinh;
	}

	public void setNgSinh(Date ngSinh) {
		this.NgSinh = ngSinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		this.DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		this.SDT = sDT;
	}

	public String getMA_CV() {
		return MA_CV;
	}

	public void setMA_CV(String mA_CV) {
		this.MA_CV = mA_CV;
	}
	
	
	
	
}
