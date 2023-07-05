package PizzaBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CustomerBill extends JFrame implements Serializable{

	private JTextArea textArea;
	private Bill bill;
	private JScrollPane scrollPane;
	private JPanel panel;

	public CustomerBill(){

		this.getContentPane().setLayout(new BorderLayout());
		
		ImageIcon ic = new ImageIcon("Others/pizzaicon.jpg");
		
		this.setTitle("Customer's Bill");
		this.setSize(750,500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setIconImage(ic.getImage());

	}

	public void getbill(){

		this.panel = new JPanel();

		this.textArea = new JTextArea();
		this.textArea.setEditable(false);

		this.scrollPane = new JScrollPane(this.textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		try{
			this.textArea.setText(""+this.bill.generateBill());
		}catch(Exception e){
			System.err.println(e);
		}

		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.scrollPane, BorderLayout.CENTER);

	}

	public void setBill(Bill bill){
		this.bill = bill;
	}

}
