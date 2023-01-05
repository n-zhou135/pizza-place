import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.List;

public class PizzaPlace implements ActionListener
{
	JTextField cussText;
	JRadioButton smallRadio;
	JRadioButton mediumRadio;
	JRadioButton largeRadio;
	JComboBox crustBox;
	JList toppingList;
	JCheckBox breadstickBox;
	JCheckBox saladBox;
	JCheckBox sodaBox;
	JTextArea textPlace;
	JButton orderButton;
	JButton resetButton;
	
	public static void main(String[] args) 
	{
		new PizzaPlace();
	}
	
	public PizzaPlace()
	{
		JFrame myFrame = new JFrame();
		
		myFrame.setTitle("Pizza Place");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel myPanel = (JPanel)myFrame.getContentPane();
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		Border myBorder = BorderFactory.createEmptyBorder(10,10,10,10);
		myPanel.setBorder(myBorder);
		
		JPanel cussPanel = new JPanel();
		JLabel cussLabel = new JLabel("Customer Name: ");
		cussPanel.add(cussLabel);
		cussText = new JTextField(20);
		cussPanel.add(cussText);
		myPanel.add(cussPanel);
		
		JPanel radioPanel = new JPanel();
		JLabel pizzaLabel = new JLabel("Pizza Size: ");
		radioPanel.add(pizzaLabel);
		smallRadio = new JRadioButton("Small");
		mediumRadio = new JRadioButton("Medium");
		largeRadio = new JRadioButton("Large");
		ButtonGroup myGroup = new ButtonGroup();
		myGroup.add(smallRadio);
		myGroup.add(mediumRadio);
		myGroup.add(largeRadio);
		radioPanel.add(smallRadio);
		radioPanel.add(mediumRadio);
		radioPanel.add(largeRadio);
		myPanel.add(radioPanel);
		
		JPanel crustPanel = new JPanel();
		JLabel crustLabel = new JLabel("Crust Type: ");
		crustPanel.add(crustLabel);
		String [] crusttypes = {"Thin", "Thick", "Deep Dish"};
		crustBox = new JComboBox(crusttypes);
		crustPanel.add(crustBox);
		myPanel.add(crustPanel);
		
		JPanel toppingPanel = new JPanel();
		JLabel toppingLabel = new JLabel("Toppings: ");
		toppingPanel.add(toppingLabel);
		String [] topping = {"Pepperoni", "Sausage", "Green Peppers", "Onions", "Tomatoes", "Anchovies", "Bacon", "Chicken", "Beef", "Olives", "Mushrooms"};
		toppingList = new JList(topping);
		toppingList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane myScroll = new JScrollPane(toppingList, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		toppingPanel.add(myScroll);
		myPanel.add(toppingPanel);
		
		JPanel extraPanel = new JPanel();
		JLabel extraLabel = new JLabel("Extras: ");
		extraPanel.add(extraLabel);
		breadstickBox = new JCheckBox ("BreadSticks");
		saladBox = new JCheckBox ("Salad");
		sodaBox = new JCheckBox ("Soda");
		extraPanel.add(breadstickBox);
		extraPanel.add(saladBox);
		extraPanel.add(sodaBox);
		myPanel.add(extraPanel);
		
		JPanel commentPanel = new JPanel();
		JLabel commentLabel = new JLabel("Order Comments");
		commentPanel.add(commentLabel);
		textPlace = new JTextArea(5, 20);
		JScrollPane theScroll = new JScrollPane(textPlace, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		commentPanel.add(theScroll);
		myPanel.add(commentPanel);
		
		JPanel buttonPanel = new JPanel();
		orderButton = new JButton("Place Order");
		orderButton.addActionListener(this);
		resetButton = new JButton ("Reset Values");
		resetButton.addActionListener(this);
		buttonPanel.add(orderButton);
		buttonPanel.add(resetButton);
		myPanel.add(buttonPanel);
		
		myFrame.pack();
		myFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object control = event.getSource();
		String summary;
		String sizes = "";
		if (smallRadio.isSelected() == true)
			sizes = "Small";
		if (mediumRadio.isSelected() == true)
			sizes = "Medium";
		if (largeRadio.isSelected() == true)
			sizes = "Large";
		
		if (control == orderButton)
		{
			List tops = toppingList.getSelectedValuesList(); 
		      
			String topsChosen =  "";

			for (int i = 0; i< tops.size();  i++)  
			{
			   topsChosen = topsChosen + (String) tops.get(i) + "\n";
			}
			
		String extra = "";	
		if (breadstickBox.isSelected() == true)
		{
			extra = "BreadStick";
			
			if (saladBox.isSelected() == true)
				extra = "Breadstick \n" + "Salad ";
			if (sodaBox.isSelected() == true)
				extra = "Breadstick " + "Soda " + "Salad";
		}

			summary = "PIZZA ORDER FOR: " + cussText.getText() + "\n" + "SIZE: " + "\n" + sizes + "\n" + 
							"CRUST TYPE:" + "\n" + (String)crustBox.getSelectedItem() + "\n" +
							"TOPPINGS:" + "\n" + topsChosen + "\n" +
							"EXTRAS:" + "\n" + extra + "\n" + 
							"COMMENTS:" + "\n" + textPlace.getText();
			
			JOptionPane.showMessageDialog(null, summary);
		}
		
		if (control == resetButton)
		{
			cussText.setText(" ");
			smallRadio.setSelected(true);
			mediumRadio.setSelected(false);
			largeRadio.setSelected(false);
			crustBox.setSelectedIndex(0);
			toppingList.clearSelection();
			breadstickBox.setSelected(false);
			saladBox.setSelected(false);
			sodaBox.setSelected(false);
			textPlace.setText("");
		}
	}
}
