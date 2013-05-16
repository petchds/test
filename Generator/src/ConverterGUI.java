import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConverterGUI implements ActionListener {

	private ConverterControl convert;
	private JTextField txtInput;
	private JTextField txtInputTIS;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConverterGUI();		
	}
	
	ConverterGUI(){
		init();
	}
	
	private void init()
	{
		convert = new ConverterControl();
		
		//create frame
		JFrame frame = new JFrame("Convert to TIS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create grid panel
		JPanel gridPanel = new JPanel(new GridLayout(2,3));
		
		//create flow layout panel
		JPanel flowPanel = new JPanel(new FlowLayout());
		
		//create label1
		JLabel lblInput = new JLabel("Input : ");
		gridPanel.add(lblInput);
		
		//create textbox1
		txtInput = new JTextField();
		gridPanel.add(txtInput);
		
		//create button1
		JButton btn1 = new JButton("Convert to TIS");
		gridPanel.add(btn1);
		btn1.setActionCommand("ConvertToTIS");
		btn1.addActionListener(this);
		
		//create label2
		JLabel lblInputTIS = new JLabel("Input TIS : ");
		gridPanel.add(lblInputTIS);
		
		//create textbox2
		txtInputTIS = new JTextField();
		gridPanel.add(txtInputTIS);
		
		//create button 2
		JButton btn2 = new JButton("Convert to text");
		gridPanel.add(btn2);
		btn2.setActionCommand("ConvertToText");
		btn2.addActionListener(this);
		
		//create copy button
		JButton btnCopy = new JButton("Copy");
		flowPanel.add(btnCopy);
		btnCopy.setActionCommand("CopyText");
		btnCopy.addActionListener(this);
		
		//create copyTIS button
		JButton btnCopyTIS = new JButton("CopyTIS");
		flowPanel.add(btnCopyTIS);
		btnCopyTIS.setActionCommand("CopyTIS");
		btnCopyTIS.addActionListener(this);
		
		//create main panel
		JPanel mainPanel = new JPanel(new GridLayout(2,1));
		mainPanel.add(gridPanel);
		mainPanel.add(flowPanel);
		
		frame.add(mainPanel);
		frame.setSize(400,200);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ConvertToTIS"))
		{
			txtInputTIS.setText(convert.convertToTIS(txtInput.getText()));
		}
		if(e.getActionCommand().equals("ConvertToText"))
		{
			txtInput.setText(convert.convertToText(txtInputTIS.getText()));
		}
		if(e.getActionCommand().equals("CopyText")){
			convert.copyToClipboard(txtInput.getText());
		}
		if(e.getActionCommand().equals("CopyTIS")){
			convert.copyToClipboard(txtInputTIS.getText());
		}
	}

}

	