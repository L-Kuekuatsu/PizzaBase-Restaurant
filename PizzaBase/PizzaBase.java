package PizzaBase;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaBase extends JFrame implements ActionListener, Serializable{

	private JPanel[] panel;
	private JButton[] button;
	private JLabel[] label;
	private JTextField[] textfield;
	private JRadioButton[] radioButton;
	private JCheckBox[] checkBox;
	private JScrollPane[] scrollPane;
	private JList jList;
	private DefaultListModel listModel;

	private ButtonGroup prefabSize;
	private ButtonGroup prefabBase;
	private ButtonGroup diySize;
	private ButtonGroup diyBase;
	private ButtonGroup beverageSize;

	private Order order;
	private Customer customer;
	private Prefab[] prefab;
	private DoItYourself doItYourself;
	private Beverage[] beverage;
	private Topping[] topping;
	private Size size;
	private Base base;
	private BeverageSize beveragesize;

	public PizzaBase(){

		this.getContentPane().setLayout(new BorderLayout());

		this.topping = new Topping[20];
		this.prefab = new Prefab[10];
		this.doItYourself = new DoItYourself();
		this.beverage = new Beverage[10];
		this.listModel = new DefaultListModel();
		this.jList = new JList(listModel);
		this.panel = new JPanel[27];
		this.button = new JButton[7];
		this.label = new JLabel[49];
		this.textfield = new JTextField[45];
		this.radioButton = new JRadioButton[13];
		this.checkBox = new JCheckBox[40];	
		this.scrollPane = new JScrollPane[3];

		for(int i = 0; i < this.panel.length; i++){
			this.panel[i] = new JPanel();
		}
		for(int i = 0; i < this.checkBox.length; i++){
			this.checkBox[i] = new JCheckBox();
		}

		this.button[0] = new JButton("ORDER");
		this.button[0].setFocusable(false);
		this.button[1] = new JButton("ADD TO ORDER");
		this.button[1].setFocusable(false);
		this.button[2] = new JButton("ADD TO ORDER");
		this.button[2].setFocusable(false);
		this.button[3] = new JButton("ADD TO ORDER");
		this.button[3].setFocusable(false);
		this.button[4] = new JButton("SAVE ORDER");
		this.button[4].setFocusable(false);
		this.button[5] = new JButton("OPEN ORDER");
		this.button[5].setFocusable(false);
		this.button[6] = new JButton("CLEAR ORDER");
		this.button[6].setFocusable(false);

		this.radioButton[0] = new JRadioButton("Six Inch");
		this.radioButton[1] = new JRadioButton("Nine Inch");
		this.radioButton[2] = new JRadioButton("Twelve Inch");
		this.radioButton[3] = new JRadioButton("Deep Crust");
		this.radioButton[4] = new JRadioButton("Crispy Base");
		this.radioButton[5] = new JRadioButton("Six Inch (x1)");
		this.radioButton[6] = new JRadioButton("Nine Inch (x1.5)");
		this.radioButton[7] = new JRadioButton("Twelve Inch (x2)");
		this.radioButton[8] = new JRadioButton("Deep Crust ($150)");
		this.radioButton[9] = new JRadioButton("Crispy Base ($100)");
		this.radioButton[10] = new JRadioButton("Small");
		this.radioButton[11] = new JRadioButton("Medium");
		this.radioButton[12] = new JRadioButton("Large");

		this.radioButton[0].addActionListener(this);
		this.radioButton[1].addActionListener(this);
		this.radioButton[2].addActionListener(this);
		this.radioButton[3].addActionListener(this);
		this.radioButton[4].addActionListener(this);
		this.radioButton[5].addActionListener(this);
		this.radioButton[6].addActionListener(this);
		this.radioButton[7].addActionListener(this);
		this.radioButton[8].addActionListener(this);
		this.radioButton[9].addActionListener(this);
		this.radioButton[10].addActionListener(this);
		this.radioButton[11].addActionListener(this);
		this.radioButton[12].addActionListener(this);

		for(int i = 0; i < this.radioButton.length; i++){
			this.radioButton[i].setFocusable(false);
		}

		this.checkBox[0].setText("Cheese ($150)");
		this.checkBox[1].setText("Veggie ($140)");
		this.checkBox[2].setText("Pepperoni ($155)");
		this.checkBox[3].setText("Hawaiian ($160)");
		this.checkBox[4].setText("Buffalo ($165)");
		this.checkBox[5].setText("Meat ($160)");
		this.checkBox[6].setText("Margherita ($150)");
		this.checkBox[7].setText("BBQ ($155)");
		this.checkBox[8].setText("Supreme ($170)");
		this.checkBox[9].setText("Hot & Spicy ($145)");
		this.checkBox[10].setText("Pepperoni ($15)");
		this.checkBox[11].setText("Mushroom ($7)");
		this.checkBox[12].setText("Onions ($6)");
		this.checkBox[13].setText("Sausages ($13)");
		this.checkBox[14].setText("Bacon ($14)");
		this.checkBox[15].setText("Mozarella Cheese ($10)");
		this.checkBox[16].setText("Cheddar Cheese ($10)");
		this.checkBox[17].setText("Olives ($8)");
		this.checkBox[18].setText("Green Peppers ($10");
		this.checkBox[19].setText("Pineapple ($10)");
		this.checkBox[20].setText("Spinach ($6)");
		this.checkBox[21].setText("Ham ($11)");
		this.checkBox[22].setText("Broccoli ($7)");
		this.checkBox[23].setText("Garlic ($5)");
		this.checkBox[24].setText("Gorgonzola ($10)");
		this.checkBox[25].setText("Anchovies ($6)");
		this.checkBox[26].setText("Capsicum ($6)");
		this.checkBox[27].setText("Meat ($15)");
		this.checkBox[28].setText("Tomato ($9)");
		this.checkBox[29].setText("Basil ($7)");
		this.checkBox[30].setText("Coke ($20)");
		this.checkBox[31].setText("Lemonade ($15)");
		this.checkBox[32].setText("Iced Tea ($15)");
		this.checkBox[33].setText("Orange Juice ($15)");
		this.checkBox[34].setText("Beer ($25)");
		this.checkBox[35].setText("Milk Tea ($20)");
		this.checkBox[36].setText("Fruit Shake ($25)");
		this.checkBox[37].setText("Pepsi ($20)");
		this.checkBox[38].setText("Sprite ($20)");
		this.checkBox[39].setText("Iced Coffee ($15)");

		for(int i = 0; i < this.checkBox.length; i++){
			this.checkBox[i].setFocusable(false);
		}
		this.prefabSize = new ButtonGroup();
		this.prefabBase = new ButtonGroup();
		this.diySize = new ButtonGroup();
		this.diyBase = new ButtonGroup();
		this.beverageSize = new ButtonGroup();

		this.prefabSize.add(this.radioButton[0]);
		this.prefabSize.add(this.radioButton[1]);
		this.prefabSize.add(this.radioButton[2]);
		this.prefabBase.add(this.radioButton[3]);
		this.prefabBase.add(this.radioButton[4]);
		this.diySize.add(this.radioButton[5]);
		this.diySize.add(this.radioButton[6]);
		this.diySize.add(this.radioButton[7]);
		this.diyBase.add(this.radioButton[8]);
		this.diyBase.add(this.radioButton[9]);
		this.beverageSize.add(this.radioButton[10]);
		this.beverageSize.add(this.radioButton[11]);
		this.beverageSize.add(this.radioButton[12]);

		this.label[0] = new JLabel("Name : ");
		this.label[1] = new JLabel("Balance : ");
		this.label[2] = new JLabel("Size : ");
		this.label[3] = new JLabel("Base : ");
		this.label[4] = new JLabel("Size : ");
		this.label[5] = new JLabel("Base : ");
		this.label[6] = new JLabel("Size : ");
		this.label[7] = new JLabel("Pizza Name : ");
		this.label[48] = new JLabel("Amount : ");


		for(int i = 8; i < 48; i++){
			this.label[i] = new JLabel("          |          Amount:");
		}

		this.textfield[0] = new JTextField("",20);
		this.textfield[1] = new JTextField("",20);
		this.textfield[2] = new JTextField("",20);
		this.textfield[44] = new JTextField("",20);

		for(int i = 3; i < this.textfield.length; i++){
			this.textfield[i] = new JTextField("",5);
		}
		this.textfield[43].setEditable(false);

		panel[0].setLayout(new BorderLayout());
		panel[1].setLayout(new BorderLayout());
		panel[2].setLayout(new FlowLayout());

		this.getContentPane().add(panel[0], BorderLayout.PAGE_START);
		this.getContentPane().add(panel[1], BorderLayout.CENTER);
		this.getContentPane().add(panel[2], BorderLayout.PAGE_END);

		this.panel[0].add(this.panel[3], BorderLayout.CENTER);
		this.panel[1].add(this.panel[4]);
		this.panel[1].add(this.panel[5], BorderLayout.LINE_END);
		this.panel[2].add(this.button[0]);

		this.panel[5].setPreferredSize(new Dimension(500,500));

		this.panel[3].setBorder(BorderFactory.createTitledBorder("Customer :"));
		this.panel[4].setBorder(BorderFactory.createTitledBorder("Menu : "));
		this.panel[5].setBorder(BorderFactory.createTitledBorder("Orders :"));

		for(int i = 0; i < 2; i++){
			this.panel[3].add(this.label[i]);
			this.panel[3].add(this.textfield[i]);
			if(i != 1){
				this.panel[3].add(Box.createHorizontalStrut(100));
			}
		}

		for(int i = 3; i < this.textfield.length; i++){
			this.textfield[i].setPreferredSize(new Dimension(20,20));
		}

		this.panel[6].setBorder(BorderFactory.createTitledBorder("Prefab :"));
		this.panel[7].setBorder(BorderFactory.createTitledBorder("Design your Pizza : "));
		this.panel[8].setBorder(BorderFactory.createTitledBorder("Beverages :"));

		for(int i = 6; i < 9; i++){
			this.panel[4].add(this.panel[i]);
			this.panel[i].setLayout(new BorderLayout());
		}

		this.panel[4].setLayout(null);
		this.panel[6].setBounds(10,20,420,285);
		this.panel[7].setBounds(440,20,420,580);
		this.panel[8].setBounds(10,315,420,285);

		this.scrollPane[0] = new JScrollPane(this.panel[10], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollPane[1] = new JScrollPane(this.panel[13], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollPane[2] = new JScrollPane(this.panel[16], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		//menu layout
		this.panel[6].add(this.panel[9], BorderLayout.PAGE_START);
		this.panel[6].add(this.scrollPane[0], BorderLayout.CENTER);
		this.panel[6].add(this.panel[11], BorderLayout.PAGE_END);
		this.panel[7].add(this.panel[12], BorderLayout.PAGE_START);
		this.panel[7].add(this.scrollPane[1], BorderLayout.CENTER);
		this.panel[7].add(this.panel[14], BorderLayout.PAGE_END);
		this.panel[8].add(this.panel[15], BorderLayout.PAGE_START);
		this.panel[8].add(this.scrollPane[2], BorderLayout.CENTER);
		this.panel[8].add(this.panel[17], BorderLayout.PAGE_END);

		this.panel[10].setLayout(new GridLayout(10,3));
		this.panel[13].setLayout(new GridLayout(20,2));
		this.panel[16].setLayout(new GridLayout(10,2));

		this.panel[9].setLayout(new GridLayout(2,1));
		this.panel[11].setLayout(new FlowLayout());
		this.panel[11].add(this.button[1]);
		this.button[1].setPreferredSize(new Dimension(120,20));
		this.panel[12].setLayout(new GridLayout(3,1));
		this.panel[14].setLayout(new FlowLayout());
		this.panel[14].add(this.button[2]);
		this.button[2].setPreferredSize(new Dimension(120,20));
		this.panel[15].setLayout(new FlowLayout());
		this.panel[17].setLayout(new FlowLayout());
		this.panel[17].add(this.button[3]);
		this.button[3].setPreferredSize(new Dimension(120,20));

		this.panel[9].add(this.panel[18]);
		this.panel[18].setLayout(new FlowLayout());
		this.panel[9].add(this.panel[19]);
		this.panel[19].setLayout(new FlowLayout());
		this.panel[12].add(this.panel[20]);
		this.panel[20].setLayout(new FlowLayout());
		this.panel[12].add(this.panel[21]);
		this.panel[21].setLayout(new FlowLayout());
		this.panel[12].add(this.panel[22]);
		this.panel[21].setLayout(new FlowLayout());

		this.panel[18].add(this.label[2]);
		this.panel[18].add(this.radioButton[0]);
		this.panel[18].add(this.radioButton[1]);
		this.panel[18].add(this.radioButton[2]);
		this.panel[19].add(this.label[3]);
		this.panel[19].add(this.radioButton[3]);
		this.panel[19].add(this.radioButton[4]);
		
		this.panel[20].add(this.label[4]);
		this.panel[20].add(this.radioButton[5]);
		this.panel[20].add(this.radioButton[6]);
		this.panel[20].add(this.radioButton[7]);

		this.panel[21].add(this.label[5]);
		this.panel[21].add(this.radioButton[8]);
		this.panel[21].add(this.radioButton[9]);

		this.panel[22].setLayout(new GridLayout(1,4));
		this.panel[22].add(this.label[7]);
		this.panel[22].add(this.textfield[2]);
		this.panel[22].add(this.label[48]);
		this.panel[22].add(this.textfield[44]);

		this.panel[15].add(this.label[6]);
		this.panel[15].add(this.radioButton[10]);
		this.panel[15].add(this.radioButton[11]);
		this.panel[15].add(this.radioButton[12]);

		//prefab scroll panel
		for(int i = 0; i < 10; i++){
			this.panel[10].add(this.checkBox[i]);
			this.panel[10].add(this.label[i+8]);
			this.panel[10].add(this.textfield[i+3]);
		}
		//DIY scroll panel
		for(int i = 10; i < 30; i++){
			this.panel[13].add(this.checkBox[i]);
			this.panel[13].add(this.label[i+8]);
			this.panel[13].add(this.textfield[i+3]);
		}
		//Beverage scroll panel
		for(int i = 30; i < 40; i++){
			this.panel[16].add(this.checkBox[i]);
			this.panel[16].add(this.label[i+8]);
			this.panel[16].add(this.textfield[i+3]);
		}
		//Order layout
		this.jList.setPreferredSize(new Dimension(500,500));
		this.panel[5].setLayout(new BorderLayout());
		this.panel[5].add(this.jList, BorderLayout.CENTER);
		this.panel[5].add(this.panel[23], BorderLayout.PAGE_END);
		this.panel[5].add(this.panel[24], BorderLayout.PAGE_START);
		this.panel[5].add(this.panel[25], BorderLayout.LINE_END);
		this.panel[5].add(this.panel[26], BorderLayout.LINE_START);
		this.panel[23].setLayout(new FlowLayout());
		this.panel[23].add(this.button[4]);
		this.panel[23].add(this.button[5]);
		this.panel[23].add(this.button[6]);
		this.panel[23].add(this.textfield[43]);

		///////////////////////////////////////////////////////////////////////////////
		this.order = new Order();

		try{

			this.topping[0] = new Topping("Pepperoni", 15.0, 1);
			this.topping[1] = new Topping("Mushroom", 7.0, 1);
			this.topping[2] = new Topping("Onions", 6.0, 1);
			this.topping[3] = new Topping("Sausages", 13.0, 1);
			this.topping[4] = new Topping("Bacon", 14.0, 1);
			this.topping[5] = new Topping("Mozarella Cheese",10.0, 1);
			this.topping[6] = new Topping("Cheddar Cheese", 10.0, 1);
			this.topping[7] = new Topping("Olives", 8.0, 1);
			this.topping[8] = new Topping("Green Peppers", 10.0, 1);
			this.topping[9] = new Topping("Pineapple", 10.0, 1);
			this.topping[10] = new Topping("Spinach", 6.0, 1);
			this.topping[11] = new Topping("Ham", 11.0, 1);
			this.topping[12] = new Topping("Broccoli", 7.0, 1);
			this.topping[13] = new Topping("Garlic", 5.0, 1);
			this.topping[14] = new Topping("Gorgonzola", 10.0, 1);
			this.topping[15] = new Topping("Anchovies", 6.0, 1);
			this.topping[16] = new Topping("Capsicum", 6.0, 1);
			this.topping[17] = new Topping("Meat", 15.0, 1);
			this.topping[18] = new Topping("Tomato", 9.0, 1);
			this.topping[19] = new Topping("Basil", 7.0, 1);

		} catch(InvalidPriceException e){
			System.err.println(e);
		}
		
		//////////////////////////////////////////////////////////////////////////
		this.button[1].addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try{
						if(checkBox[0].isSelected()){
							int a = Integer.parseInt(textfield[3].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Cheese", 150.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Cheese", 150.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Cheese", 150.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Cheese", 150.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Cheese", 150.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Cheese", 150.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Cheese", 150.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Cheese", 150.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Cheese", 150.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Cheese", 150.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Cheese", 150.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Cheese", 150.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[1].isSelected()){
							int a = Integer.parseInt(textfield[4].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Veggie", 140.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Veggie", 140.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Veggie", 140.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Veggie", 140.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Veggie", 140.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Veggie", 140.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Veggie", 140.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Veggie", 140.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Veggie", 140.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Veggie", 140.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Veggie", 140.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Veggie", 140.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[2].isSelected()){
							int a = Integer.parseInt(textfield[5].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Pepperoni", 155.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Pepperoni", 155.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Pepperoni", 155.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Pepperoni", 155.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Pepperoni", 155.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Pepperoni", 155.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Pepperoni", 155.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Pepperoni", 155.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Pepperoni", 155.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Pepperoni", 155.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Pepperoni", 155.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Pepperoni", 155.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[3].isSelected()){
							int a = Integer.parseInt(textfield[6].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Hawaiian", 160.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Hawaiian", 160.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Hawaiian", 160.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Hawaiian", 160.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Hawaiian", 160.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Hawaiian", 160.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Hawaiian", 160.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Hawaiian", 160.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Hawaiian", 160.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Hawaiian", 160.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Hawaiian", 160.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Hawaiian", 160.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[4].isSelected()){
							int a = Integer.parseInt(textfield[7].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Buffalo", 165.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Buffalo", 165.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Buffalo", 165.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Buffalo", 165.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Buffalo", 165.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Buffalo", 165.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Buffalo", 165.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Buffalo", 165.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Buffalo", 165.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Buffalo", 165.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Buffalo", 165.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Buffalo", 165.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[5].isSelected()){
							int a = Integer.parseInt(textfield[8].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Meat", 160.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Meat", 160.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Meat", 160.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Meat", 160.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Meat", 160.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Meat", 160.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Meat", 160.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Meat", 160.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Meat", 160.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Meat", 160.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Meat", 160.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Meat", 160.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[6].isSelected()){
							int a = Integer.parseInt(textfield[9].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Margherita", 150.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Margherita", 150.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Margherita", 150.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Margherita", 150.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Margherita", 150.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Margherita", 150.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Margherita", 150.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Margherita", 150.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Margherita", 150.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Margherita", 150.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Margherita", 150.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Margherita", 150.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[7].isSelected()){
							int a = Integer.parseInt(textfield[10].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("BBQ", 155.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("BBQ", 155.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("BBQ", 155.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("BBQ", 155.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("BBQ", 155.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("BBQ", 155.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("BBQ", 155.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("BBQ", 155.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("BBQ", 155.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("BBQ", 155.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("BBQ", 155.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("BBQ", 155.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[8].isSelected()){
							int a = Integer.parseInt(textfield[11].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Supreme", 170.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Supreme", 170.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Supreme", 170.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Supreme", 170.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Supreme", 170.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Supreme", 170.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Supreme", 170.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Supreme", 170.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Supreme", 170.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Supreme", 170.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Supreme", 170.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Supreme", 170.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						if(checkBox[9].isSelected()){
							int a = Integer.parseInt(textfield[12].getText());
							if(radioButton[0].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Hot & Spicy", 145.0, a, Size.SIXINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Hot & Spicy", 145.0, a, Size.SIXINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Hot & Spicy", 145.0, a, Size.SIXINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Hot & Spicy", 145.0, a, Size.SIXINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[1].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Hot & Spicy", 145.0, a, Size.NINEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Hot & Spicy", 145.0, a, Size.NINEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Hot & Spicy", 145.0, a, Size.NINEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Hot & Spicy", 145.0, a, Size.NINEINCH, Base.CRISPYBASE));
								}
							}else if(radioButton[2].isSelected()){
								if(radioButton[3].isSelected()){
									order.addPizza(new Prefab("Hot & Spicy", 145.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
									listModel.addElement(new Prefab("Hot & Spicy", 145.0, a, Size.TWELVEINCH, Base.DEEPCRUST));
								}else if(radioButton[4].isSelected()){
									order.addPizza(new Prefab("Hot & Spicy", 145.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
									listModel.addElement(new Prefab("Hot & Spicy", 145.0, a, Size.TWELVEINCH, Base.CRISPYBASE));
								}
							}
						}
						textfield[43].setText("$"+order.computeTotalPrice());
						clearPrefab();
					}catch(Exception evt){
						JOptionPane.showMessageDialog(null,"Please select and enter an order properly.");
					}
				}
			});

		this.button[2].addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try{
						DoItYourself diy = new DoItYourself();
						String name = textfield[2].getText();
						diy.setName(name);
						int num = Integer.parseInt(textfield[44].getText());
						diy.setNumberOfPizzas(num);

						if(radioButton[5].isSelected()){
							 diy.setSize(Size.SIXINCH);
						}else if(radioButton[6].isSelected()){
							diy.setSize(Size.NINEINCH);
						}else if(radioButton[7].isSelected()){
							diy.setSize(Size.TWELVEINCH);
						}
						if(radioButton[8].isSelected()){
							diy.setBase(Base.DEEPCRUST);
						}else if(radioButton[9].isSelected()){
							diy.setBase(Base.CRISPYBASE);
						}

						if(checkBox[10].isSelected()){
							int a = Integer.parseInt(textfield[13].getText());
							topping[0].setNumberOfToppings(a);
							diy.addTopping(topping[0]);
						}
						if(checkBox[11].isSelected()){
							int a = Integer.parseInt(textfield[14].getText());
							topping[1].setNumberOfToppings(a);
							diy.addTopping(topping[1]);
						}
						if(checkBox[12].isSelected()){
							int a = Integer.parseInt(textfield[15].getText());
							topping[2].setNumberOfToppings(a);
							diy.addTopping(topping[2]);
						}
						if(checkBox[13].isSelected()){
							int a = Integer.parseInt(textfield[16].getText());
							topping[3].setNumberOfToppings(a);
							diy.addTopping(topping[3]);
						}
						if(checkBox[14].isSelected()){
							int a = Integer.parseInt(textfield[17].getText());
							topping[4].setNumberOfToppings(a);
							diy.addTopping(topping[4]);
						}
						if(checkBox[15].isSelected()){
							int a = Integer.parseInt(textfield[18].getText());
							topping[5].setNumberOfToppings(a);
							diy.addTopping(topping[5]);
						}
						if(checkBox[16].isSelected()){
							int a = Integer.parseInt(textfield[19].getText());
							topping[6].setNumberOfToppings(a);
							diy.addTopping(topping[6]);
						}
						if(checkBox[17].isSelected()){
							int a = Integer.parseInt(textfield[20].getText());
							topping[7].setNumberOfToppings(a);
							diy.addTopping(topping[7]);
						}
						if(checkBox[18].isSelected()){
							int a = Integer.parseInt(textfield[21].getText());
							topping[8].setNumberOfToppings(a);
							diy.addTopping(topping[8]);
						}
						if(checkBox[19].isSelected()){
							int a = Integer.parseInt(textfield[22].getText());
							topping[9].setNumberOfToppings(a);
							diy.addTopping(topping[9]);
						}
						if(checkBox[20].isSelected()){
							int a = Integer.parseInt(textfield[23].getText());
							topping[10].setNumberOfToppings(a);
							diy.addTopping(topping[10]);
						}
						if(checkBox[21].isSelected()){
							int a = Integer.parseInt(textfield[24].getText());
							topping[11].setNumberOfToppings(a);
							diy.addTopping(topping[11]);
						}
						if(checkBox[22].isSelected()){
							int a = Integer.parseInt(textfield[25].getText());
							topping[12].setNumberOfToppings(a);
							diy.addTopping(topping[12]);
						}
						if(checkBox[23].isSelected()){
							int a = Integer.parseInt(textfield[26].getText());
							topping[13].setNumberOfToppings(a);
							diy.addTopping(topping[13]);
						}
						if(checkBox[24].isSelected()){
							int a = Integer.parseInt(textfield[27].getText());
							topping[14].setNumberOfToppings(a);
							diy.addTopping(topping[14]);
						}
						if(checkBox[25].isSelected()){
							int a = Integer.parseInt(textfield[28].getText());
							topping[15].setNumberOfToppings(a);
							diy.addTopping(topping[15]);
						}
						if(checkBox[26].isSelected()){
							int a = Integer.parseInt(textfield[29].getText());
							topping[16].setNumberOfToppings(a);
							diy.addTopping(topping[16]);
						}
						if(checkBox[27].isSelected()){
							int a = Integer.parseInt(textfield[30].getText());
							topping[17].setNumberOfToppings(a);
							diy.addTopping(topping[17]);
						}
						if(checkBox[28].isSelected()){
							int a = Integer.parseInt(textfield[31].getText());
							topping[18].setNumberOfToppings(a);
							diy.addTopping(topping[18]);
						}
						if(checkBox[29].isSelected()){
							int a = Integer.parseInt(textfield[32].getText());
							topping[19].setNumberOfToppings(a);
							diy.addTopping(topping[19]);
						}

						order.addPizza(diy);
						listModel.addElement(diy);
						textfield[43].setText("$"+order.computeTotalPrice());
						clearDIY();
					}catch(Exception tev){
						JOptionPane.showMessageDialog(null,"Please select and enter an order properly.");
					}

				}
			});

		this.button[3].addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try{
						if(checkBox[30].isSelected()){
							int a = Integer.parseInt(textfield[33].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Coke", 20.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Coke", 20.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Coke", 20.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Coke", 20.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Coke", 20.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Coke", 20.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[31].isSelected()){
							int a = Integer.parseInt(textfield[34].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Lemonade", 15.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Lemonade", 15.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Lemonade", 15.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Lemonade", 15.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Lemonade", 15.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Lemonade", 15.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[32].isSelected()){
							int a = Integer.parseInt(textfield[35].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Iced Tea", 15.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Iced Tea", 15.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Iced Tea", 15.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Iced Tea", 15.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Iced Tea", 15.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Iced Tea", 15.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[33].isSelected()){
							int a = Integer.parseInt(textfield[36].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Orange Juice", 15.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Orange Juice", 15.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Orange Juice", 15.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Orange Juice", 15.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Orange Juice", 15.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Orange Juice", 15.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[34].isSelected()){
							int a = Integer.parseInt(textfield[37].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Beer", 25.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Beer", 25.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Beer", 25.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Beer", 25.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Beer", 25.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Beer", 25.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[35].isSelected()){
							int a = Integer.parseInt(textfield[38].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Milk Tea", 20.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Milk Tea", 20.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Milk Tea", 20.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Milk Tea", 20.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Milk Tea", 20.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Milk Tea", 20.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[36].isSelected()){
							int a = Integer.parseInt(textfield[39].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Fruit Shake", 25.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Fruit Shake", 25.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Fruit Shake", 25.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Fruit Shake", 25.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Fruit Shake", 25.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Fruit Shake", 25.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[37].isSelected()){
							int a = Integer.parseInt(textfield[40].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Pepsi", 20.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Pepsi", 20.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Pepsi", 20.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Pepsi", 20.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Pepsi", 20.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Pepsi", 20.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[38].isSelected()){
							int a = Integer.parseInt(textfield[41].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Sprite", 20.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Sprite", 20.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Sprite", 20.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Sprite", 20.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Sprite", 20.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Sprite", 20.00, a, BeverageSize.LARGE));
							}
						}
						if(checkBox[39].isSelected()){
							int a = Integer.parseInt(textfield[42].getText());
							if(radioButton[10].isSelected()){
								order.addBeverage(new Beverage("Iced Coffee", 15.00, a, BeverageSize.SMALL));
								listModel.addElement(new Beverage("Iced Coffee", 15.00, a, BeverageSize.SMALL));
							}else if(radioButton[11].isSelected()){
								order.addBeverage(new Beverage("Iced Coffee", 15.00, a, BeverageSize.MEDIUM));
								listModel.addElement(new Beverage("Iced Coffee", 15.00, a, BeverageSize.MEDIUM));
							}else if(radioButton[12].isSelected()){
								order.addBeverage(new Beverage("Iced Coffee", 15.00, a, BeverageSize.LARGE));
								listModel.addElement(new Beverage("Iced Coffee", 15.00, a, BeverageSize.LARGE));
							}
						}
						textfield[43].setText("$"+order.computeTotalPrice());
						clearBeverage();
					}catch(Exception etv){
						JOptionPane.showMessageDialog(null,"Please select and enter an order properly.");
					}
				}
			});

		this.button[0].addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					try{
						String name = textfield[0].getText();
						double money = Double.valueOf(textfield[1].getText());	
						try{
							customer = new Customer(name, money);
						}catch(NoMoneyException nme){
							JOptionPane.showMessageDialog(null,nme);
						}
						order.setCustomer(customer);
						if(jList.getModel().getSize()==0){
							JOptionPane.showMessageDialog(null,"Please order at least one pizza or beverage.");
						}else{
							if(customer.getMoney() < order.computeTotalPrice()){
								JOptionPane.showMessageDialog(null,"Insufficient Balance.");
							}else{
								ProgressBar progBar = new ProgressBar(order);
						        javax.swing.SwingUtilities.invokeLater(new Runnable(){
						            public void run() {
						                progBar.startProgress();
						            }
						        });
							}
						}
					}catch(Exception oex){
						JOptionPane.showMessageDialog(null,"Please Enter Information Properly!");
					}
				}
			});


		//////////////////////////////////////////////////////////////////////////////
		this.button[4].addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					//save
					JFileChooser fileChooser = new JFileChooser("./Others/Orders");
					 
					int response = fileChooser.showSaveDialog(null);
					 
					if (response == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();

					    try{
					    	FileOutputStream fos = new FileOutputStream(fileToSave);
						    ObjectOutputStream oos = new ObjectOutputStream(fos);
						    oos.writeObject(order);
						    oos.close();
					    }catch(Exception fse){
					    	JOptionPane.showMessageDialog(null,fse);
					    }
					}
				}
			});


		this.button[5].addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					//open
					JFileChooser fileChooser = new JFileChooser("./Others/Orders");
					
					fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					int response = fileChooser.showOpenDialog(null);
					 
					if (response == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();

					    listModel.clear();
						textfield[43].setText("");
						order.backToOne();
					

					    try{
					    	FileInputStream fis = new FileInputStream(fileToSave);
						    ObjectInputStream ois = new ObjectInputStream(fis);

						    order = (Order)ois.readObject();
						    ois.close();

						    if(order.getPizza().size() > 0){
						    	for(Pizza p : order.getPizza()){
						    		listModel.addElement(p);
						    	}
						    }
						    if(order.getBeverage().size() > 0){
						    	for(Beverage b : order.getBeverage()){
						    		listModel.addElement(b);
						    	}
						    }

					    }catch(Exception fse){
					    	JOptionPane.showMessageDialog(null,fse);
					    }

					    textfield[43].setText("$"+order.computeTotalPrice());
					}
					

				}

			});

		this.textfield[43].setText("$"+order.computeTotalPrice());

		this.button[6].addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					listModel.clear();
					textfield[43].setText("");
					order.backToOne();
				}

			});

		ImageIcon ic = new ImageIcon("Others/pizzaicon.jpg");

		this.setTitle("Pizza Base Restaurant");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1630,735);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(ic.getImage());

	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==this.radioButton[0] && this.radioButton[3].isSelected()){
			setText1();
		}else if(e.getSource()==this.radioButton[1] && this.radioButton[3].isSelected()){
			setText2();
		}else if(e.getSource()==this.radioButton[2] && this.radioButton[3].isSelected()){
			setText3();
		}else if(e.getSource()==this.radioButton[3] && this.radioButton[0].isSelected()){
			setText1();
		}else if(e.getSource()==this.radioButton[3] && this.radioButton[1].isSelected()){
			setText2();
		}else if(e.getSource()==this.radioButton[3] && this.radioButton[2].isSelected()){
			setText3();
		}else if(e.getSource()==this.radioButton[0] && this.radioButton[4].isSelected()){
			setText4();
		}else if(e.getSource()==this.radioButton[1] && this.radioButton[4].isSelected()){
			setText5();
		}else if(e.getSource()==this.radioButton[2] && this.radioButton[4].isSelected()){
			setText6();
		}else if(e.getSource()==this.radioButton[4] && this.radioButton[0].isSelected()){
			setText4();
		}else if(e.getSource()==this.radioButton[4] && this.radioButton[1].isSelected()){
			setText5();
		}else if(e.getSource()==this.radioButton[4] && this.radioButton[2].isSelected()){
			setText6();
		}else if(e.getSource()==this.radioButton[3]){
			setText1();
		}else if(e.getSource()==this.radioButton[0]){
			setText4();
		}else if(e.getSource()==this.radioButton[1]){
			setText5();
		}else if(e.getSource()==this.radioButton[2]){
			setText6();
		}else if(e.getSource()==this.radioButton[4]){
			setText4();
		}else if(e.getSource()==this.radioButton[10]){
			setText7();
		}else if(e.getSource()==this.radioButton[11]){
			setText8();
		}else if(e.getSource()==this.radioButton[12]){
			setText9();
		}
	}

	public void clearPrefab(){
		this.prefabSize.clearSelection();
		this.prefabBase.clearSelection();
		for(int i = 0; i < 10; i++){
			this.checkBox[i].setSelected(false);
			this.textfield[i+3].setText("");
		}
	}
	public void clearDIY(){
		this.textfield[2].setText("");
		this.diySize.clearSelection();
		this.diyBase.clearSelection();
		for(int i = 10; i < 30; i++){
			this.checkBox[i].setSelected(false);
			this.textfield[i+3].setText("");
		}
		this.textfield[44].setText("");
	}
	public void clearBeverage(){
		this.beverageSize.clearSelection();
		for(int i = 30; i < 40; i++){
			this.checkBox[i].setSelected(false);
			this.textfield[i+3].setText("");
		}
	}

	public void setText1(){
		this.checkBox[0].setText("Cheese ($200)");
		this.checkBox[1].setText("Veggie ($190)");
		this.checkBox[2].setText("Pepperoni ($205)");
		this.checkBox[3].setText("Hawaiian ($210)");
		this.checkBox[4].setText("Buffalo ($215)");
		this.checkBox[5].setText("Meat ($210)");
		this.checkBox[6].setText("Margherita ($200)");
		this.checkBox[7].setText("BBQ ($205)");
		this.checkBox[8].setText("Supreme ($220)");
		this.checkBox[9].setText("Hot & Spicy ($195)");
	}

	public void setText2(){
		this.checkBox[0].setText("Cheese ($300)");
		this.checkBox[1].setText("Veggie ($285)");
		this.checkBox[2].setText("Pepperoni ($307.5)");
		this.checkBox[3].setText("Hawaiian ($315)");
		this.checkBox[4].setText("Buffalo ($322.5)");
		this.checkBox[5].setText("Meat ($315)");
		this.checkBox[6].setText("Margherita ($300)");
		this.checkBox[7].setText("BBQ ($307.5)");
		this.checkBox[8].setText("Supreme ($330)");
		this.checkBox[9].setText("Hot & Spicy ($292.5)");
	}

	public void setText3(){
		this.checkBox[0].setText("Cheese ($400)");
		this.checkBox[1].setText("Veggie ($380)");
		this.checkBox[2].setText("Pepperoni ($410)");
		this.checkBox[3].setText("Hawaiian ($420)");
		this.checkBox[4].setText("Buffalo ($430)");
		this.checkBox[5].setText("Meat ($420)");
		this.checkBox[6].setText("Margherita ($400)");
		this.checkBox[7].setText("BBQ ($410)");
		this.checkBox[8].setText("Supreme ($440)");
		this.checkBox[9].setText("Hot & Spicy ($390)");
	}
	
	public void setText4(){
		this.checkBox[0].setText("Cheese ($150)");
		this.checkBox[1].setText("Veggie ($140)");
		this.checkBox[2].setText("Pepperoni ($155)");
		this.checkBox[3].setText("Hawaiian ($160)");
		this.checkBox[4].setText("Buffalo ($165)");
		this.checkBox[5].setText("Meat ($160)");
		this.checkBox[6].setText("Margherita ($150)");
		this.checkBox[7].setText("BBQ ($155)");
		this.checkBox[8].setText("Supreme ($170)");
		this.checkBox[9].setText("Hot & Spicy ($145)");
	}
	
	public void setText5(){
		this.checkBox[0].setText("Cheese ($225)");
		this.checkBox[1].setText("Veggie ($210)");
		this.checkBox[2].setText("Pepperoni ($232.5)");
		this.checkBox[3].setText("Hawaiian ($240)");
		this.checkBox[4].setText("Buffalo ($247.5)");
		this.checkBox[5].setText("Meat ($240)");
		this.checkBox[6].setText("Margherita ($225)");
		this.checkBox[7].setText("BBQ ($232.5)");
		this.checkBox[8].setText("Supreme ($255)");
		this.checkBox[9].setText("Hot & Spicy ($217.5)");
	}
	
	public void setText6(){
		this.checkBox[0].setText("Cheese ($300)");
		this.checkBox[1].setText("Veggie ($280)");
		this.checkBox[2].setText("Pepperoni ($310)");
		this.checkBox[3].setText("Hawaiian ($320)");
		this.checkBox[4].setText("Buffalo ($330)");
		this.checkBox[5].setText("Meat ($320)");
		this.checkBox[6].setText("Margherita ($300)");
		this.checkBox[7].setText("BBQ ($310)");
		this.checkBox[8].setText("Supreme ($340)");
		this.checkBox[9].setText("Hot & Spicy ($290)");
	}
	
	public void setText7(){
		this.checkBox[30].setText("Coke ($20)");
		this.checkBox[31].setText("Lemonade ($15)");
		this.checkBox[32].setText("Iced Tea ($15)");
		this.checkBox[33].setText("Orange Juice ($15)");
		this.checkBox[34].setText("Beer ($25)");
		this.checkBox[35].setText("Milk Tea ($20)");
		this.checkBox[36].setText("Fruit Shake ($25)");
		this.checkBox[37].setText("Pepsi ($20)");
		this.checkBox[38].setText("Sprite ($20)");
		this.checkBox[39].setText("Iced Coffe ($15)");
	}
	
	public void setText8(){
		this.checkBox[30].setText("Coke ($30)");
		this.checkBox[31].setText("Lemonade ($22.5)");
		this.checkBox[32].setText("Iced Tea ($22.)");
		this.checkBox[33].setText("Orange Juice ($22.5)");
		this.checkBox[34].setText("Beer ($37.5)");
		this.checkBox[35].setText("Milk Tea ($30)");
		this.checkBox[36].setText("Fruit Shake ($37.5)");
		this.checkBox[37].setText("Pepsi ($30)");
		this.checkBox[38].setText("Sprite ($30)");
		this.checkBox[39].setText("Iced Coffe ($22.5)");
	}

	public void setText9(){
		this.checkBox[30].setText("Coke ($40)");
		this.checkBox[31].setText("Lemonade ($30)");
		this.checkBox[32].setText("Iced Tea ($30)");
		this.checkBox[33].setText("Orange Juice ($30)");
		this.checkBox[34].setText("Beer ($50)");
		this.checkBox[35].setText("Milk Tea ($40)");
		this.checkBox[36].setText("Fruit Shake ($50)");
		this.checkBox[37].setText("Pepsi ($40)");
		this.checkBox[38].setText("Sprite ($40)");
		this.checkBox[39].setText("Iced Coffe ($30)");
	}

}
