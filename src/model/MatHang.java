package model;

import java.math.BigDecimal;

public class MatHang {
	private int MA_MH;
	private String TenMH;
	private int SLDGD;
	private BigDecimal Dongia;
	private int SoLuongTon;
	
	public MatHang(int mA_MH, String tenMH, int sLDGD, BigDecimal dongia, int soLuongTon) {
		MA_MH = mA_MH;
		TenMH = tenMH;
		SLDGD = sLDGD;
		Dongia = dongia;
		SoLuongTon = soLuongTon;
	}
	public int getMA_MH() {
		return MA_MH;
	}
	public void setMA_MH(int mA_MH) {
		MA_MH = mA_MH;
	}
	public String getTenMH() {
		return TenMH;
	}
	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}
	public int getSLDGD() {
		return SLDGD;
	}
	public void setSLDGD(int sLDGD) {
		SLDGD = sLDGD;
	}
	public BigDecimal getDongia() {
		return Dongia;
	}
	public void setDongia(BigDecimal dongia) {
		Dongia = dongia;
	}
	public int getSoLuongTon() {
		return SoLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		SoLuongTon = soLuongTon;
	}
	
	
	
}
