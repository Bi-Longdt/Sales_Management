package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import model.NhanVien;
import model.TaiKhoan;
import view.LogInView;
import view.SalesView;

public class LogInController implements ActionListener {

	private LogInView loginview;
	private String username;
	private String password;
	public TaiKhoan acc;
	private PreparedStatement ps;
	private ResultSet rs;
	private ConnectDB conn;

	public LogInController() {
		// TODO Auto-generated constructor stub
	}

	public LogInController(LogInView loginview) {
		this.loginview = loginview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if (src.equals("Login")) {
			ThucHienDangNhap();
		} else if (src.equals("Clear")) {
			ThucHienXoa();
		}
	}

	public void ThucHienDangNhap() {
		conn = new ConnectDB();

		username = loginview.getTfUID().getText();
		password = loginview.getTfPass().getText();

		acc = new TaiKhoan(username, password);
		System.out.println(acc.getTaiKhoan() + " " + acc.getMatkhau());

		String sql = "SELECT * FROM TAIKHOAN WHERE TaiKhoan=? AND MatKhau=?";
		try {
			ps = conn.connectSQL().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (!username.equals("") && !password.equals("")) {
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "–„ng nh‚Úp thaÃnh cÙng");
					String thongtinnv = "SELECT NHANVIEN.MA_NV, NHANVIEN.TenNV, CHUCVU.TenCVU FROM NHANVIEN \r\n"
							+ "INNER JOIN TAIKHOAN ON NHANVIEN.MA_NV = TAIKHOAN.MA_NV\r\n"
							+ "INNER JOIN CHUCVU ON NHANVIEN.MA_CVU = CHUCVU.MA_CVU\r\n" + "WHERE TaiKhoan = ?";
					
						ps = conn.connectSQL().prepareStatement(thongtinnv);
						ps.setString(1, username);
						rs = ps.executeQuery();
						SalesView thongtin = new SalesView();
						if (rs.next()) {
							Object ob[] = { rs.getString("MA_NV"), rs.getString("TenNV"), rs.getString("TenCVU") };
							thongtin.tfTenNV.setText(ob[1].toString());
							thongtin.tfMaNV.setText(ob[0].toString());
							thongtin.tfCVNV.setText(ob[2].toString());
							}
					loginview.getFrame().setVisible(false);
					SalesView salesView = new SalesView();
					salesView.setVisible(true);
					salesView.setVisible(false);
					salesView.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(null, "TaÃi khoa“n ho„Úc m‚Út kh‚“u biÚ sai!", "LÙﬁi",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "TaÃi khoa“n ho„Úc m‚Út kh‚“u ch˝a nh‚Úp!", "LÙﬁi",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void ThucHienXoa() {
		loginview.getTfUID().setText("");
		loginview.getTfPass().setText("");
	}

	public TaiKhoan getAcc() {
		return acc;
	}

	public void setAcc(TaiKhoan acc) {
		this.acc = acc;
	}

	public LogInView getLoginview() {
		return loginview;
	}

	public void setLoginview(LogInView loginview) {
		this.loginview = loginview;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
