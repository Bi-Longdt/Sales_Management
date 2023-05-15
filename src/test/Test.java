package test;

import view.*;

import javax.swing.*;

import model.TaiKhoan;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LogInView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}