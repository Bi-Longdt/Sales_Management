package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LogInController;
import controller.SalesFormController;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;

public class SalesView extends JFrame {
	
	public JFrame frame;
	public JPanel contentPane;
	public JTextField tfMaSP;
	public JTable table;
	public JButton btThanhToan;
	public JButton btClear;
	public JButton btKhac;
	public JButton btDangXuat; 
	public JButton btTreoGD;
	public JButton btGoiGD;
	public JButton btnXoaDong;
	public JButton btnXoaGd;
	public JButton btSoLuong;
	public JButton btTraGia;
	public JButton bt0;
	public JButton bt1;
	public JButton bt2;
	public JButton bt3;
	public JButton bt4;
	public JButton bt5;
	public JButton bt6;
	public JButton bt7;
	public JButton bt8;
	public JButton bt9;
	public JButton btOK;
	public DefaultTableModel model;
	public JLabel tfTenMH;
	public JLabel tfSoluong;
	public JLabel tfThanhtien;
	public JLabel tfSLT;
	public JLabel tfTenNV;
	public JLabel lbThongbao;
	public JLabel tfMaNV;
	public JLabel tfCVNV;
	public JLabel tfSoHD;
	private JLabel lblSHoan;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesView frame = new SalesView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SalesView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 550);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new SalesFormController(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 175, 240));
		panel_1.setBounds(0, 0, 755, 511);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 50, 568, 275);
		panel_2.setLayout(new GridLayout(1, 1));
		panel_1.add(panel_2);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane sp = new JScrollPane(table);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] { "Số", "Mặt hàng", "Số lượng", "Giá", "Số tiền" });
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		panel_2.add(sp);
		kichchuot();
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(569, 0, 186, 478);
		panel_1.add(panel_3);

		btKhac = new JButton("Khác");
		btKhac.setBounds(0, 0, 92, 49);
		panel_3.add(btKhac);
		btKhac.addActionListener(ac);

		btDangXuat = new JButton("Đăng xuất");
		btDangXuat.setBounds(94, 0, 92, 49);
		panel_3.add(btDangXuat);
		btDangXuat.addActionListener(ac);

		btTreoGD = new JButton("Treo GD");
		btTreoGD.setBounds(0, 49, 92, 47);
		panel_3.add(btTreoGD);
		btTreoGD.addActionListener(ac);

		btGoiGD = new JButton("Gọi lại GD");
		btGoiGD.setBounds(94, 49, 92, 47);
		panel_3.add(btGoiGD);
		btGoiGD.addActionListener(ac);

		btnXoaDong = new JButton("Xóa dòng");
		btnXoaDong.setBounds(0, 96, 92, 47);
		panel_3.add(btnXoaDong);
		btnXoaDong.addActionListener(ac);

		btnXoaGd = new JButton("Xóa GD");
		btnXoaGd.setBounds(94, 96, 92, 47);
		panel_3.add(btnXoaGd);
		btnXoaGd.addActionListener(ac);

		btSoLuong = new JButton("Số lượng");
		btSoLuong.setBounds(0, 143, 92, 47);
		panel_3.add(btSoLuong);
		btSoLuong.addActionListener(ac);

		btTraGia = new JButton("Tra giá");
		btTraGia.setBounds(94, 143, 92, 47);
		panel_3.add(btTraGia);
		btTraGia.addActionListener(ac);

		tfMaSP = new JTextField();
		tfMaSP.setFont(new Font("Tahoma", Font.BOLD, 24));
		tfMaSP.setHorizontalAlignment(SwingConstants.RIGHT);
		tfMaSP.setColumns(10);
		tfMaSP.setBounds(0, 190, 188, 44);
		panel_3.add(tfMaSP);

		bt0 = new JButton("0");
		bt0.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt0.setBounds(0, 380, 124, 49);
		panel_3.add(bt0);
		bt0.addActionListener(ac);

		bt1 = new JButton("1");
		bt1.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt1.setBounds(0, 331, 62, 49);
		panel_3.add(bt1);
		bt1.addActionListener(ac);

		bt2 = new JButton("2");
		bt2.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt2.setBounds(62, 331, 62, 49);
		panel_3.add(bt2);
		bt2.addActionListener(ac);

		bt3 = new JButton("3");
		bt3.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt3.setBounds(124, 331, 62, 49);
		panel_3.add(bt3);
		bt3.addActionListener(ac);

		bt4 = new JButton("4");
		bt4.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt4.setBounds(0, 282, 62, 49);
		panel_3.add(bt4);
		bt4.addActionListener(ac);
		
		bt5 = new JButton("5");
		bt5.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt5.setBounds(62, 282, 62, 49);
		panel_3.add(bt5);
		bt5.addActionListener(ac);
		
		bt6 = new JButton("6");
		bt6.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt6.setBounds(124, 282, 62, 49);
		panel_3.add(bt6);
		bt6.addActionListener(ac);

		bt7 = new JButton("7");
		bt7.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt7.setBounds(0, 233, 62, 49);
		panel_3.add(bt7);
		bt7.addActionListener(ac);

		bt8 = new JButton("8");
		bt8.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt8.setBounds(62, 233, 62, 49);
		panel_3.add(bt8);
		bt8.addActionListener(ac);

		bt9 = new JButton("9");
		bt9.setFont(new Font("Tahoma", Font.BOLD, 24));
		bt9.setBounds(124, 233, 62, 49);
		panel_3.add(bt9);
		bt9.addActionListener(ac);

		btOK = new JButton("OK");
		btOK.setBackground(new Color(102, 255, 51));
		btOK.setFont(new Font("Tahoma", Font.BOLD, 19));
		btOK.setBounds(124, 380, 62, 49);
		panel_3.add(btOK);
		btOK.addActionListener(ac);
		
		
		
		
		
		
		
		
		
		
		
		

		btClear = new JButton("C");
		btClear.setBackground(new Color(255, 255, 0));
		btClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btClear.setBounds(0, 429, 62, 49);
		panel_3.add(btClear);
		btClear.addActionListener(ac);

		btThanhToan = new JButton("Thanh toán");
		btThanhToan.setBackground(new Color(102, 255, 51));
		btThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btThanhToan.setBounds(62, 429, 124, 49);
		panel_3.add(btThanhToan);
		btThanhToan.addActionListener(ac);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 326, 568, 54);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lbTenMatHang = new JLabel("Tên mặt hàng:");
		lbTenMatHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTenMatHang.setBounds(10, 11, 105, 32);
		panel_4.add(lbTenMatHang);

		JLabel lbSoLuong = new JLabel("Số lượng:");
		lbSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSoLuong.setBounds(355, 11, 71, 32);
		panel_4.add(lbSoLuong);
		
		tfTenMH = new JLabel("");
		tfTenMH.setHorizontalAlignment(SwingConstants.LEFT);
		tfTenMH.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfTenMH.setBounds(120, 11, 225, 32);
		panel_4.add(tfTenMH);
		
		tfSoluong = new JLabel("");
		tfSoluong.setHorizontalAlignment(SwingConstants.LEFT);
		tfSoluong.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfSoluong.setBounds(430, 11, 105, 32);
		panel_4.add(tfSoluong);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 381, 568, 97);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lbSoLuongTong = new JLabel("Số lượng:");
		lbSoLuongTong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbSoLuongTong.setBounds(10, 11, 72, 29);
		panel_5.add(lbSoLuongTong);

		JLabel lbKhuyenMai = new JLabel("Khuyến mãi:");
		lbKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbKhuyenMai.setBounds(203, 11, 355, 29);
		panel_5.add(lbKhuyenMai);

		JLabel lbThanhTien = new JLabel("Thành tiền:");
		lbThanhTien.setBackground(Color.WHITE);
		lbThanhTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbThanhTien.setBounds(10, 51, 83, 46);
		panel_5.add(lbThanhTien);
		
		tfSLT = new JLabel("");
		tfSLT.setHorizontalAlignment(SwingConstants.LEFT);
		tfSLT.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfSLT.setBounds(82, 11, 111, 29);
		panel_5.add(tfSLT);
		
		tfThanhtien = new JLabel("");
		tfThanhtien.setForeground(Color.RED);
		tfThanhtien.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfThanhtien.setBackground(Color.WHITE);
		tfThanhtien.setBounds(95, 51, 460, 46);
		panel_5.add(tfThanhtien);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(0, 0, 568, 49);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		tfTenNV = new JLabel("");
		tfTenNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfTenNV.setHorizontalAlignment(SwingConstants.LEFT);
		tfTenNV.setBounds(10, 0, 201, 20);
		panel_6.add(tfTenNV);
		
		lbThongbao = new JLabel("Hãy nhập mã sản phẩm");
		lbThongbao.setBackground(Color.WHITE);
		lbThongbao.setOpaque(true);
		lbThongbao.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbThongbao.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongbao.setBounds(221, 0, 347, 49);
		panel_6.add(lbThongbao);
		
		tfMaNV = new JLabel("");
		tfMaNV.setHorizontalAlignment(SwingConstants.LEFT);
		tfMaNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfMaNV.setBounds(10, 25, 51, 20);
		panel_6.add(tfMaNV);
		
		tfCVNV = new JLabel("");
		tfCVNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfCVNV.setBounds(56, 25, 155, 20);
		panel_6.add(tfCVNV);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(0, 477, 755, 34);
		panel_1.add(panel_7);

		JLabel lbThoigian = new JLabel("");
		lbThoigian.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbThoigian.setBounds(685, 9, 60, 18);
		panel_7.add(lbThoigian);
//		setTime(lbThoigian);
		
		
		
		
		

		JLabel lbNgay = new JLabel("14/02/2022");
		lbNgay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNgay.setBounds(600, 9, 85, 18);
		lbNgay.setText(java.time.LocalDate.now() + "");
		panel_7.add(lbNgay);
		
		tfSoHD = new JLabel("");
		tfSoHD.setHorizontalAlignment(SwingConstants.LEFT);
		tfSoHD.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfSoHD.setBounds(89, 9, 213, 18);
		panel_7.add(tfSoHD);
		
		lblSHoan = new JLabel("Số hóa đơn:");
		lblSHoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblSHoan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSHoan.setBounds(10, 9, 80, 18);
		panel_7.add(lblSHoan);
	}
	
	
	  public void setTime(JLabel labelClock) {
	    	try {
	            while (true) {
	                Calendar calendar = Calendar.getInstance();
	                String hour = (calendar.getTime().getHours() > 9) ? 
	                        "" + calendar.getTime().getHours() + ""
	                        : "0" + calendar.getTime().getHours();
	                String minute = (calendar.getTime().getMinutes() > 9) ? 
	                        "" + calendar.getTime().getMinutes() + ""
	                        : "0" + calendar.getTime().getMinutes();
	                String second = (calendar.getTime().getSeconds() > 9) ? 
	                        "" + calendar.getTime().getSeconds() + ""
	                        : "0" + calendar.getTime().getSeconds();
	                labelClock.setText(hour + ":" + minute + ":" + second);
	                Thread.sleep(1000);
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	
	
	
	public void kichchuot() {
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if(row>=0){
                	tfTenMH.setText(table.getValueAt(row, 1).toString());
                	tfSoluong.setText(table.getValueAt(row,2).toString());
                }
            }
        });
	}

}
