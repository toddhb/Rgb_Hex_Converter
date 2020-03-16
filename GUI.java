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
	public static JTextField textFieldHex;
	public static JTextField textFieldRgb;
	private JButton btnConvert;
	private JLabel lblResultOfConversion;
	private JTextField colorBox;

	public GUI() {
		initializeGUI();
	}
	
	private void initializeGUI() {
		JLabel lblHex = new JLabel("Hexadecimal: ");		
		JLabel lblRgb = new JLabel("RGB: ");
		lblResultOfConversion = new JLabel("xxxx");

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
		
		//color box
		colorBox = new JTextField();
		colorBox.setEditable(false);
		colorBox.setOpaque(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			//set horizontal gaps between elements
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHex)
						.addComponent(lblRgb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldRgb, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addComponent(textFieldHex, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(colorBox)
						.addComponent(lblResultOfConversion))
					.addGap(19)
					.addComponent(btnConvert)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			//set vertical gaps between elements and set height of each element
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
								.addComponent(textFieldHex, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblResultOfConversion))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(colorBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(btnConvert, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void processConversion(String inputHexValue, String inputRgbValue) {
		String outputRgb, outputHex;
		Rgb inputRgb = new Rgb(inputRgbValue);
		outputHex = inputRgb.convert();

		Hex inputHex = new Hex(inputHexValue);
		outputRgb = inputHex.convert();

		//if the user input a hex value
		if(!outputRgb.equals("")) {
			textFieldRgb.setText("");
			//retain the original hex input
			textFieldHex.setText("");
			lblResultOfConversion.setText(inputHexValue + " is " + outputRgb);
			colorBox.setBackground(new Color(inputHex.getRed(), inputHex.getGreen(), inputHex.getBlue()));
		}

		//if the user input an RGB value
		if(!outputHex.equals("")) {
			textFieldHex.setText("");
			//retain the original RGB input
			textFieldRgb.setText("");
			lblResultOfConversion.setText(inputRgbValue + " is " + outputHex);
			colorBox.setBackground(new Color(inputRgb.getRed(), inputRgb.getGreen(), inputRgb.getBlue()));
		}

		//paint the color box with the converted output color
		colorBox.setOpaque(true);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
	}

	public static void setText(JTextField field, String string) {
		field.setText(string);
	}
}
