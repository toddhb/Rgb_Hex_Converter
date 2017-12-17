package hexRGBConverter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	
	String hexValue;
	String rgbValue;
	
	private JPanel contentPane;
	private JTextField textFieldHex, textFieldRgb;
	private JButton btnConvert;

	public GUI() {
		initializeGUI();
	}
	
	private void initializeGUI() {
		JLabel lblHex = new JLabel("Hexadecimal: ");		
		JLabel lblRgb = new JLabel("RGB: ");

		setResizable(false);
		setTitle("Hex | RGB Converter");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
		);
		setBounds(50, 50, 425, 350);
		getContentPane().setBackground(new Color(0, 153, 102));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//hexadecimal input field
		textFieldHex = new JTextField();
		textFieldHex.setToolTipText("Enter a hexadecimal value");
		textFieldHex.addActionListener(this);
		textFieldHex.setEditable(true);
		textFieldHex.addMouseListener(new MouseAdapter(){
	        @Override
	        public void mouseClicked(MouseEvent e){
	            textFieldRgb.setText("");
	        }
	    });
		
		//convert button; when action performed,
		//between color types
		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hexValue = textFieldHex.getText();
				rgbValue = textFieldRgb.getText();

				try {
					processConversion(hexValue, rgbValue);
				} catch (Exception e1) {
					System.out.println("Exception: " + e1);
					e1.printStackTrace();
				}
			}
		});
        
		/*btnConvert.registerKeyboardAction(btnConvert.getActionForKeyStroke(
				KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                JComponent.WHEN_FOCUSED);

		btnConvert.registerKeyboardAction(btnConvert.getActionForKeyStroke(
                KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                JComponent.WHEN_FOCUSED);*/
		
		//RGB input field
		textFieldRgb = new JTextField();
		textFieldRgb.setToolTipText("Enter an RGB value");
		textFieldRgb.addActionListener(this);
		textFieldRgb.setEditable(true);
		textFieldRgb.addMouseListener(new MouseAdapter(){
	        @Override
	        public void mouseClicked(MouseEvent e){
	            textFieldHex.setText("");
	        }
	    });
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHex)
						.addComponent(lblRgb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldRgb, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addComponent(textFieldHex, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnConvert)
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRgb)
								.addComponent(textFieldRgb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHex)
								.addComponent(textFieldHex, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(btnConvert, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void processConversion(String inputHexValue, String inputRgbValue) {
		System.out.println("inputHexValue: " + inputHexValue);
		System.out.println("inputRgbValue: " + inputRgbValue);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
