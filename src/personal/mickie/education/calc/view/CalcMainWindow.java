package personal.mickie.education.calc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalcMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3770164889623567503L;
	private JPanel contentPane;
	private JTextField digitWindow;
	private JButton[] calcButtons;
	private static final String[] buttonTexts = {
			"7", "8", "9", "/",
			"4", "5", "6", "*",
			"1", "2", "3", "-",
			"0", ".", "C", "+",
			};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcMainWindow frame = new CalcMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalcMainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		digitWindow = new JTextField();
		contentPane.add(digitWindow, BorderLayout.NORTH);
		digitWindow.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		final int ROW = 4;
		final int COL = 4;
		panel.setLayout(new GridLayout(ROW, COL, 3, 3));
		
		JButton equalButton = new JButton("=");
		equalButton.addActionListener(calcButtonListener);
		contentPane.add(equalButton, BorderLayout.SOUTH);
		
		calcButtons = new JButton[ROW * COL];
		
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c ++) {
				int buttonIndex = (ROW - r - 1) * COL + c;
				calcButtons[buttonIndex] = new JButton(buttonTexts[buttonIndex]);
				calcButtons[buttonIndex].addActionListener(mainButtonListener);
				panel.add(calcButtons[buttonIndex], r, c);
			}
		}
	}
	
	private ActionListener mainButtonListener = new ActionListener() {
		
		@Override
		/**
		 * メインのボタンが押されたときのイベント
		 * @param 押されたときのステータス。e.Source()でイベントトリガを確認できる。
		 */
		public void actionPerformed(ActionEvent e) {
			Object eventSource = e.getSource();
			
			if (eventSource instanceof JButton) {
				JButton source = (JButton) eventSource;
				digitWindow.setText(source.getText());
			}
			
		}
	};
	
	private ActionListener calcButtonListener = new ActionListener() {
		
		@Override
		/**
		 * 計算ボタンが押されたときのイベント
		 */
		public void actionPerformed(ActionEvent e) {
			
		}
	};

}
