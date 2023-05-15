package view;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class LoadingView extends JFrame {
	private JLabel lbSSM;
	private JLabel lbimage;
	private JLabel lbSS;
	private JLabel lbloading;
	
	public static void main(String[] args) {
		new LoadingView();
	}
	
	public LoadingView() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new FormPane(), BorderLayout.CENTER);
                frame.add(new FormPane());
                frame.pack();
                frame.setSize(600,350);
                frame.setLocationRelativeTo(null);
//                frame.setUndecorated(true);
                frame.setVisible(true);
            }

        });
    }
	
	public class FormPane extends JPanel {

        public FormPane() {
        	setLayout(null);
        	setBounds(0, 0, 584, 311);
        	setBackground(Color.WHITE);
            
            lbSSM = new JLabel("Sales System Management");
            lbSSM.setBounds(10, 11, 564, 66);
    		lbSSM.setForeground(new Color(0,175,240));
    		lbSSM.setBackground(Color.WHITE);
    		lbSSM.setHorizontalAlignment(SwingConstants.CENTER);
    		lbSSM.setFont(new Font("Tahoma",Font.BOLD,24));
    		add(lbSSM);
    		
            lbimage = new JLabel();
            
            lbimage.setSize(300, 200);
            lbimage.setBounds(111, 66, 264, 181);
            ImageIcon image = new ImageIcon("image/database.png");
            Image img = image.getImage();
            Image imgSQL = img.getScaledInstance(lbimage.getWidth(), lbimage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon SQLIcon = new ImageIcon(imgSQL); 
            lbimage.setIcon(SQLIcon);
            add(lbimage);
            
            lbSS = new JLabel("SalSys");
            lbSS.setBounds(385, 189, 84, 47);
            lbSS.setForeground(new Color(0,175,240));
            lbSS.setBackground(Color.WHITE);
            lbSS.setHorizontalAlignment(SwingConstants.CENTER);
            lbSS.setFont(new Font("Tahoma",Font.BOLD,24));
            add(lbSS);
            
            lbloading = new JLabel("%");
            lbloading.setBounds(10, 260, 564, 38);
            lbloading.setForeground(new Color(0,175,240));
            lbloading.setBackground(Color.WHITE);
            lbloading.setHorizontalAlignment(SwingConstants.CENTER);
            lbloading.setFont(new Font("Tahoma",Font.BOLD,24));
            add(lbloading);
            
            JProgressBar progressBar = new JProgressBar();
    		progressBar.setBounds(0, 303, 584, 8);
    		progressBar.setForeground(new Color(0,175,240));
    		add(progressBar);
            
        }
    }

	

}
