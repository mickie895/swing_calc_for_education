package personal.mickie.education.calc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personal.mickie.education.calc.cpu.Formula;
import personal.mickie.education.calc.cpu.exception.FormulaException;
import personal.mickie.education.calc.cpu.exception.IStopCalculationException;
import personal.mickie.education.calc.cpu.key.Key;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CalcMainWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3770164889623567503L;
	private JPanel contentPane;
	private JTextField digitWindow;
	private JButton[] calcButtons;
	private static final int ROW = 4;
	private static final int COL = 5;
	private static final String[] buttonTexts = {
			"7", "8", "9", "/", "CE",
			"4", "5", "6", "*", "C",
			"1", "2", "3", "-", "←",
			"+/-", "0", ".", "+", "=",
			};
	
	private Formula formula;

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
		
		// テキストボックスの作成
		digitWindow = new JTextField();
		digitWindow.setFont(new Font("MS UI Gothic", Font.PLAIN, 24));
		digitWindow.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(digitWindow, BorderLayout.NORTH);
		digitWindow.setColumns(10);
		
		// ボタンをレイアウトするためのパネルを作成
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(ROW, COL, 3, 3));
		
		// 各ボタンの登録
		calcButtons = new JButton[ROW * COL];
		
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c ++) {
				int buttonIndex = (ROW - r - 1) * COL + c;
				String buttonLabel = buttonTexts[buttonIndex];
				calcButtons[buttonIndex] = new JButton(buttonLabel);
				calcButtons[buttonIndex].setActionCommand(buttonLabel);
				// ※イベントリスナの実装方法はいろいろあるが、今回は極力単純な文法しか使わないようにしている。
				calcButtons[buttonIndex].addActionListener(this);
				panel.add(calcButtons[buttonIndex], r, c);
			}
		}
		
		formula = new Formula();
	}
	
	@Override
	/**
	 * ボタンを押したときに下のコードが実行される。
	 */
	public void actionPerformed(ActionEvent e) {
		String inputButtonCommand = e.getActionCommand();
		try {
			formula = formula.addKey(Key.createFromString(inputButtonCommand));
		} catch (FormulaException e1) {
			if (e1 instanceof IStopCalculationException) {
				JOptionPane.showMessageDialog(contentPane, e1.getMessage());
			}
			else {
				System.out.println(e1.getMessage());
			}
		}
		digitWindow.setText(Long.toString(formula.getResult()));
	}

}
