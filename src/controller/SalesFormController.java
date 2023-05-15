package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.TaiKhoan;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.LogInView;
import view.SalesView;

public class SalesFormController implements ActionListener {

	private SalesView salesView;
	private ResultSet rs;
	private String maMH;

	ConnectDB conn = new ConnectDB();
	PreparedStatement ps;

	public SalesFormController() {

	}

	public SalesFormController(SalesView salesView) {
		this.salesView = salesView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		switch (src) {
		case "0":
			NhanSo(salesView.bt0, salesView.tfMaSP);
			break;
		case "1":
			NhanSo(salesView.bt1, salesView.tfMaSP);
			break;
		case "2":
			NhanSo(salesView.bt2, salesView.tfMaSP);
			break;
		case "3":
			NhanSo(salesView.bt3, salesView.tfMaSP);
			break;
		case "4":
			NhanSo(salesView.bt4, salesView.tfMaSP);
			break;
		case "5":
			NhanSo(salesView.bt5, salesView.tfMaSP);
			break;
		case "6":
			NhanSo(salesView.bt6, salesView.tfMaSP);
			break;
		case "7":
			NhanSo(salesView.bt7, salesView.tfMaSP);
			break;
		case "8":
			NhanSo(salesView.bt8, salesView.tfMaSP);
			break;
		case "9":
			NhanSo(salesView.bt9, salesView.tfMaSP);
			break;
		case "C":
			salesView.tfMaSP.setText("");
			break;
		case "Đăng xuất":
			salesView.setVisible(false);
			LogInView loginview = new LogInView();
			loginview.setVisible(true);
			loginview.setVisible(false);
			break;
		case "OK":
			sukienOK(salesView.model);
			break;
		case "Xóa dòng":
			thuchienxoadong(salesView.model);
			break;
		case "Xóa GD":
			thuchienxoaGD(salesView.model);
			break;
		case "Số lượng":
			CapNhapSoLuong(salesView.model);
			LogInController taikhoan = new LogInController();
			System.out.println(taikhoan.getAcc());
			break;
		case "Thanh toán":
			ThanhToan(salesView.model);
			break;
		}

	}

	// TODO Auto-generated catch block
	public void sukienOK(DefaultTableModel model) {
		int Soluong = 1;
		this.setMaMH(salesView.tfMaSP.getText());
		if (salesView.tfMaSP.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã sản phẩm");
		} else {
			try {
				String chinhsuaSLDGD = "UPDATE MATHANG SET SLDGD = ? WHERE MA_MH = ?";
				ps = conn.connectSQL().prepareStatement(chinhsuaSLDGD);
				ps.setString(1, Soluong + "");
				ps.setString(2, salesView.tfMaSP.getText());
				int records = ps.executeUpdate();
				if (records == 0) {
					JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại");
					salesView.tfMaSP.setText("");
				} else if (records > 0) {
					String sql = "SELECT MA_MH, TenMH, Dongia, SLDGD, Dongia*SLDGD AS SoTien FROM MATHANG\r\n"
							+ "WHERE MA_MH = ?";
					ps = conn.connectSQL().prepareStatement(sql);
					ps.setString(1, salesView.tfMaSP.getText());
					rs = ps.executeQuery();
					if (rs.next()) {
						Object ob[] = { rs.getString("MA_MH"), rs.getString("TenMH"), rs.getString("SLDGD"),
								rs.getString("Dongia"), rs.getString("SoTien") };
						model.addRow(ob);

						String chinhsuaSLTon = "UPDATE MATHANG SET SoLuongTon = SoLuongTon-SLDGD WHERE MA_MH = ?";
						ps = conn.connectSQL().prepareStatement(chinhsuaSLTon);
						ps.setString(1, getMaMH());
						ps.executeUpdate();
						salesView.tfMaSP.setText("");

						String soluongtong = "SELECT SUM(SLDGD) AS SLT FROM MATHANG";
						ps = conn.connectSQL().prepareStatement(soluongtong);
						rs = ps.executeQuery();
						if (rs.next()) {
							Object ob1[] = { rs.getString("SLT") };
							int SLT = Integer.parseInt(ob1[0] + "");
							if (SLT == 0) {
								salesView.tfSLT.setText("");
							} else {
								salesView.tfSLT.setText(SLT + "");
							}
						}

						String mahoadon = "SELECT MAX(MA_HDON)+1 AS MAHD FROM HOADON";
						ps = conn.connectSQL().prepareStatement(mahoadon);
						rs = ps.executeQuery();
						if (rs.next()) {
							Object ob1[] = { rs.getString("MAHD") };
							salesView.tfSoHD.setText(ob1[0].toString());
						}

						String tientong = "SELECT SUM(SLDGD*Dongia) AS ThanhTien FROM MATHANG";
						ps = conn.connectSQL().prepareStatement(tientong);
						rs = ps.executeQuery();
						if (rs.next()) {
							Object ob1[] = { rs.getString("ThanhTien") };
							int ThanhTien = Integer.parseInt(ob1[0] + "");
							if (ThanhTien == 0) {
								salesView.tfThanhtien.setText("");
							} else {
								salesView.tfThanhtien.setText(ThanhTien + "");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại");
						salesView.tfMaSP.setText("");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// TODO Auto-generated catch block
	public void thuchienxoadong(DefaultTableModel model) {
		int soluong = 0;
		int i_row = salesView.table.getSelectedRow();
		if (i_row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
		} else {
			String xoadong = "UPDATE MATHANG SET SLDGD = ?, SoLuongTon = SoLuongTon + ? WHERE MA_MH = ?";
			try {

				int row = salesView.table.getSelectedRow();
				System.out.println(row);
				String col1 = (String) salesView.model.getValueAt(row, 0);
				ps = conn.connectSQL().prepareStatement(xoadong);
				ps.setString(1, soluong + "");
				ps.setString(2, salesView.tfSoluong.getText());
				ps.setString(3, col1);
				ps.executeUpdate();
				model.removeRow(i_row);

				String soluongtong = "SELECT SUM(SLDGD) AS SLT FROM MATHANG";
				ps = conn.connectSQL().prepareStatement(soluongtong);
				rs = ps.executeQuery();
				if (rs.next()) {
					Object ob1[] = { rs.getString("SLT") };
					int SLT = Integer.parseInt(ob1[0] + "");
					if (SLT == 0) {
						salesView.tfSLT.setText("");
					} else {
						salesView.tfSLT.setText(SLT + "");
					}
				}

				String tientong = "SELECT SUM(SLDGD*Dongia) AS ThanhTien FROM MATHANG";
				ps = conn.connectSQL().prepareStatement(tientong);
				rs = ps.executeQuery();
				if (rs.next()) {
					Object ob1[] = { rs.getString("ThanhTien") };
					int ThanhTien = Integer.parseInt(ob1[0] + "");
					if (ThanhTien == 0) {
						salesView.tfThanhtien.setText("");
					} else {
						salesView.tfThanhtien.setText(ThanhTien + "");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		salesView.tfSoluong.setText("");
		salesView.tfTenMH.setText("");
	}

	// TODO Auto-generated catch block
	public void thuchienxoaGD(DefaultTableModel model) {
		int soluong = 0;
		int i_count = salesView.table.getRowCount();
		System.out.println(i_count);

		if (i_count == 0) {
			try {
				String col1 = (String) salesView.model.getValueAt(i_count, 0);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Chưa có giao dịch");
			}
		} else if (i_count > 0) {
			String xoadong = "UPDATE MATHANG SET SLDGD = ?, SoLuongTon = SoLuongTon + ? WHERE MA_MH = ?";
			while (i_count > 0) {
				String col1 = (String) salesView.model.getValueAt(i_count - 1, 0);
				try {
					ps = conn.connectSQL().prepareStatement(xoadong);
					ps.setString(1, soluong + "");
					ps.setString(2, salesView.tfSoluong.getText());
					ps.setString(3, col1);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				i_count--;
			}
		}
		salesView.model.setRowCount(0);
		salesView.tfSoluong.setText("");
		salesView.tfTenMH.setText("");
		salesView.tfSLT.setText("");
		salesView.tfThanhtien.setText("");
		salesView.tfSoHD.setText("");
	}

	// TODO Auto-generated catch block
	public void CapNhapSoLuong(DefaultTableModel model) {
		int i_row = salesView.table.getSelectedRow();
		if (i_row == -1 && salesView.tfMaSP.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
		} else if (salesView.tfMaSP.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng");
		} else if (i_row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
		} else {
			String chinhsuaSLDGD = "UPDATE MATHANG SET SLDGD = ? WHERE MA_MH = ?";
			try {
				try {
					ps = conn.connectSQL().prepareStatement(chinhsuaSLDGD);
					ps.setString(1, salesView.tfMaSP.getText());
					ps.setString(2, getMaMH());
					int records = ps.executeUpdate();
					System.out.println(records + "hi");
					if (records > 0) {
						String sql = "SELECT MA_MH, TenMH, Dongia, SLDGD, Dongia*SLDGD AS SoTien FROM MATHANG\r\n"
								+ "WHERE MA_MH = ?";
						ps = conn.connectSQL().prepareStatement(sql);
						ps.setString(1, getMaMH());
						rs = ps.executeQuery();
						if (rs.next()) {
							Object ob[] = { rs.getString("MA_MH"), rs.getString("TenMH"), rs.getString("SLDGD"),
									rs.getString("Dongia"), rs.getString("SoTien") };
							model.removeRow(i_row);
							model.addRow(ob);

							String soluongtong = "SELECT SUM(SLDGD) AS SLT FROM MATHANG";
							ps = conn.connectSQL().prepareStatement(soluongtong);
							rs = ps.executeQuery();
							if (rs.next()) {
								Object ob1[] = { rs.getString("SLT") };
								int SLT = Integer.parseInt(ob1[0] + "");
								if (SLT == 0) {
									salesView.tfSLT.setText("");
								} else {
									salesView.tfSLT.setText(SLT + "");
								}
							}

							String tientong = "SELECT SUM(SLDGD*Dongia) AS ThanhTien FROM MATHANG";
							ps = conn.connectSQL().prepareStatement(tientong);
							rs = ps.executeQuery();
							if (rs.next()) {
								Object ob1[] = { rs.getString("ThanhTien") };
								int ThanhTien = Integer.parseInt(ob1[0] + "");
								if (ThanhTien == 0) {
									salesView.tfThanhtien.setText("");
								} else {
									salesView.tfThanhtien.setText(ThanhTien + "");
								}
							}

							String chinhsuaSLTon = "UPDATE MATHANG SET SoLuongTon = SoLuongTon-SLDGD WHERE MA_MH = ?";
							ps = conn.connectSQL().prepareStatement(chinhsuaSLTon);
							ps.setString(1, getMaMH());
							ps.executeUpdate();
							salesView.tfTenMH.setText("");
							salesView.tfSoluong.setText("");
							salesView.tfMaSP.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không đủ");
							salesView.tfMaSP.setText("");
						}

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không đủ");
					salesView.tfMaSP.setText("");
				}

			} catch (Exception e) {

			}
		}
	}

	// TODO Auto-generated method stub
	public void ThanhToan(DefaultTableModel model) {
		if (salesView.table.getRowCount() > 0) {

			int luaChon = JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán và in hóa đơn");
			if (luaChon == JOptionPane.YES_OPTION) {
				System.out.println(java.time.LocalDate.now());
				String hoadon = "INSERT INTO HOADON VALUES (?, ?, ?, ?)";
				try {
					ps = conn.connectSQL().prepareStatement(hoadon);
					ps.setString(1, (salesView.tfSoHD.getText()));
					ps.setString(2, (java.time.LocalDate.now() + ""));
					ps.setString(3, salesView.tfThanhtien.getText());
					ps.setString(4, salesView.tfMaNV.getText());
					int record1 = ps.executeUpdate();

					if (record1 > 0) {
						int i_count = salesView.table.getRowCount();
						if (i_count == 0) {
							try {
								String col1 = (String) salesView.model.getValueAt(i_count, 0);
							} catch (Exception e) {

							}
						} else if (i_count > 0) {
							String cthoadon = "INSERT INTO CTHOADON VALUES (?, ?, ?, ?)";
							while (i_count > 0) {
								String mamh = (String) salesView.model.getValueAt(i_count - 1, 0);
								String soluong = (String) salesView.model.getValueAt(i_count - 1, 2);
								String Dongia = (String) salesView.model.getValueAt(i_count - 1, 3);
								try {
									ps = conn.connectSQL().prepareStatement(cthoadon);
									ps.setString(1, (salesView.tfSoHD.getText()));
									ps.setString(2, mamh);
									ps.setString(3, soluong);
									ps.setString(4, Dongia);
									ps.executeUpdate();
								} catch (SQLException e) {
									e.printStackTrace();
								}
								i_count--;
							}
							String reSLDGD = "UPDATE MATHANG SET SLDGD = 0  WHERE SLDGD > 0";
							ps = conn.connectSQL().prepareStatement(reSLDGD);
							ps.executeUpdate();
						}

						salesView.tfThanhtien.setText("");
						salesView.tfSLT.setText("");
						salesView.tfSoHD.setText("");
						salesView.model.setRowCount(0);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng thực hiện giao dịch mới");
		}

	}

	public void NhanSo(JButton button, JTextField textfield) {
		String maSP = textfield.getText();
		String number = button.getText();
		salesView.tfMaSP.setText(maSP + number);
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

}
