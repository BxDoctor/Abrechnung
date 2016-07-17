package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI {

	private JFrame frame;
	private JTable table_1;
	private MyTextfield inputField;
	private MyTableModel myModel;
	private JPanel rightPanel;
	private double Gehalt = 2600;
	private double LaufendeKosten = 800;
	private double Essen = 300;
	private double Income = Gehalt -LaufendeKosten - Essen; 
	public boolean debug = true;

	/**
	 * @return the income
	 */
	public double getIncome() {
		if (debug){
			return 0.0;
		}
		return Income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		Income = income;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the table_1
	 */
	public JTable getTable_1() {
		return table_1;
	}

	/**
	 * @return the inputField
	 */
	public MyTextfield getInputField() {
		return inputField;
	}

	/**
	 * @return the myModel
	 */
	public MyTableModel getMyModel() {
		return myModel;
	}

	/**
	 * @return the rightPanel
	 */
	public JPanel getRightPanel() {
		return rightPanel;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initFrame();
		//initBong();		

		
	}

	private void initFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 718, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane,BorderLayout.CENTER);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		table_1 = new JTable();
		myModel = new MyTableModel();
		table_1.setModel(myModel);
		table_1.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table_1);
		
		inputField = new MyTextfield(this, 20);
		inputField.setBounds(0,0,10,30);
		panel.add(inputField,BorderLayout.SOUTH);
		
		rightPanel = new RightPanel(this);
		panel.add(rightPanel, BorderLayout.EAST);
		
		
		
	
	}


	public void intoTable() {
		myModel.insertRow(inputField);	
		
	}

}
