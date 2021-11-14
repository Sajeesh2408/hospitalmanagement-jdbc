import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.proteanit.sql.DbUtils;



public class JavaCrud {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtBloodGroup;
	private JTextField txtAddress;
	private JTable table;
	private JTextField txtSearchID;
	private JTextField txtMobile;

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	java.util.Date datess=Calendar.getInstance().getTime();
	DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String dates=dateFormat.format(datess);
	

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
		} catch (SQLException ex) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void table_load() {
		try {
			pst = con.prepareStatement("select * from patients");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
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
	public JavaCrud() {
		initialize();
		Connect();
		table_load();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(30, 144, 255));
		frame.getContentPane().setForeground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 1338, 882);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("HOSPITAL MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(121, 10, 1193, 52);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("New label");
		label.setBounds(539, 47, -10, 13);
		frame.getContentPane().add(label);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("ScrollBar.foreground"));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(38, 70, 486, 613);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(43, 67, 143, 27);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(43, 123, 143, 27);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Blood Group");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(43, 251, 143, 27);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Locality");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBounds(43, 306, 143, 27);
		panel.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Consulting Doctor");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_2.setBounds(43, 431, 155, 27);
		panel.add(lblNewLabel_1_3_2);

		JLabel lblNewLabel_1_3_2_1 = new JLabel("OP or Emergency");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_2_1.setBounds(43, 492, 143, 27);
		panel.add(lblNewLabel_1_3_2_1);

		txtName = new JTextField();
		txtName.setBounds(208, 73, 251, 19);
		panel.add(txtName);
		txtName.setColumns(10);

		txtBloodGroup = new JTextField();
		txtBloodGroup.setColumns(10);
		txtBloodGroup.setBounds(208, 257, 251, 19);
		panel.add(txtBloodGroup);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(208, 312, 251, 19);
		panel.add(txtAddress);

		JList<?> list = new JList<Object>();
		list.setBounds(436, 306, -219, 27);
		panel.add(list);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(208, 129, 82, 20);
		panel.add(spinner);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Contact No. ");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1_1.setBounds(43, 366, 143, 27);
		panel.add(lblNewLabel_1_3_1_1);

		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(208, 372, 251, 19);
		panel.add(txtMobile);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addItem("General Surgeon");
		comboBox.addItem("Cardiology");
		comboBox.addItem("Nephrology");
		comboBox.addItem("Diabetology");
		comboBox.addItem("ENT Specialist");
		comboBox.setBounds(208, 436, 251, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Gender");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(43, 188, 143, 27);
		panel.add(lblNewLabel_1_2_1);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.addItem("Male");
		comboBox_1.addItem("Female");
		comboBox_1.addItem("Others");
		comboBox_1.setBounds(208, 193, 251, 21);
		panel.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.addItem("OutPatient");
		comboBox_2.addItem("Emergency");
		comboBox_2.setBounds(208, 497, 251, 21);
		panel.add(comboBox_2);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name, blood, address, mobile, disease, type, gender;
				int Age;
				name = txtName.getText().toUpperCase();
				Age = (int) spinner.getValue();
				gender=(String)comboBox_1.getSelectedItem();
				blood = txtBloodGroup.getText().toUpperCase();
				address = txtAddress.getText().toUpperCase();
				mobile = txtMobile.getText();
				disease = (String) comboBox.getSelectedItem();
				type = (String)comboBox_2.getSelectedItem();
				try {
					pst = con.prepareStatement(
							"insert into patients(Full_name,Age,Gender,Blood_Group,Locality,Contact_No,Consulting_Doctor,Admit_Type,Entry_Date)values(?,?,?,?,?,?,?,?,?)");
					pst.setString(1, name);
					pst.setInt(2, Age);
					pst.setString(3, gender);
					pst.setString(4, blood);
					pst.setString(5, address);
					pst.setString(6, mobile);
					pst.setString(7, disease);
					pst.setString(8, type);
					pst.setString(9, dates);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added Successfully !!!!");
					table_load();
					txtName.setText("");
					spinner.setValue(0);
					txtBloodGroup.setText(null);
					;
					txtMobile.setText(null);
					txtAddress.setText(null);
					txtName.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(38, 725, 101, 52);
		frame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(0, 0, 255));
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(230, 725, 101, 52);
		frame.getContentPane().add(btnExit);

		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.setForeground(new Color(0, 0, 255));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("");
				spinner.setValue(0);
				txtBloodGroup.setText(null);
				table_load();
				;
				txtMobile.setText(null);
				txtAddress.setText(null);
				txtName.requestFocus();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(423, 725, 101, 52);
		frame.getContentPane().add(btnClear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(539, 70, 1006, 471);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ScrollBar.foreground"));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(539, 551, 486, 155);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Patient ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 26, 143, 27);
		panel_1.add(lblNewLabel_1_1);

		txtSearchID = new JTextField();
		txtSearchID.setColumns(10);
		txtSearchID.setBounds(208, 32, 251, 19);
		panel_1.add(txtSearchID);

		JLabel lblNewLabel_1_1_1 = new JLabel("Patient Name");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 90, 143, 27);
		panel_1.add(lblNewLabel_1_1_1);
		JTextField txtSearchName;
		txtSearchName = new JTextField();
		txtSearchName.setColumns(10);
		txtSearchName.setBounds(208, 96, 251, 19);
		panel_1.add(txtSearchName);

		JButton btnSearch = new JButton("Search_ID");
		btnSearch.setForeground(new Color(0, 0, 255));
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String searchId = txtSearchID.getText();
					pst = con.prepareStatement("select * from patients where Patient_ID=?;");
					pst.setString(1, searchId);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(1052, 563, 136, 52);
		frame.getContentPane().add(btnSearch);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(0, 0, 255));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchName = txtSearchName.getText();
				String searchId = txtSearchID.getText();
				try {
					pst = con.prepareStatement("delete from patients where Patient_ID=? or Full_Name=?");
					pst.setString(1, searchId);
					pst.setString(2, searchName);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted Successfully !!!!");
					table_load();
					txtName.setText("");
					spinner.setValue("");
					txtBloodGroup.setText("");
					txtMobile.setText("");
					txtAddress.setText("");
					txtName.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(1198, 631, 140, 52);
		frame.getContentPane().add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(0, 0, 255));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name, blood, address, mobile, disease, type, gender;
				int Age;
				name = txtName.getText().toUpperCase();
				Age = (int) spinner.getValue();
				gender=(String)comboBox_1.getSelectedItem();
				blood = txtBloodGroup.getText().toUpperCase();
				address = txtAddress.getText().toUpperCase();
				mobile = txtMobile.getText();
				disease = (String) comboBox.getSelectedItem();
				type = (String) comboBox_2.getSelectedItem();
				String searchName = txtSearchName.getText();
				String searchId = txtSearchID.getText();
				try {
					pst = con.prepareStatement("update patients set Full_name=?,Age=?,Gender=?,Blood_Group=?,Locality=?,Contact_No=?,Consulting_Doctor=?,Admit_Type=?,Entry_Date=? where Patient_ID=?");
					pst.setString(1, name);
					pst.setInt(2, Age);
					pst.setString(3, gender);
					pst.setString(4, blood);
					pst.setString(5, address);
					pst.setString(6, mobile);
					pst.setString(7, disease);
					pst.setString(8, type);
					pst.setString(9, dates);
				    pst.setString(10, searchId);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated Successfully !!!!");
					table_load();
					txtName.setText("");
					spinner.setValue("");
					txtBloodGroup.setText("");
					txtMobile.setText("");
					txtAddress.setText("");
					txtName.requestFocus();
				}
				
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(1198, 563, 140, 52);
		frame.getContentPane().add(btnUpdate);

		JButton btnSearchname = new JButton("SearchName");
		btnSearchname.setBackground(new Color(255, 255, 255));
		btnSearchname.setForeground(new Color(0, 0, 255));
		btnSearchname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String searchName = txtSearchName.getText();
					String names=searchName.toUpperCase();
					pst = con.prepareStatement("select * from patients where Full_Name=?;");
					pst.setString(1, names);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});
		btnSearchname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchname.setBounds(1052, 631, 136, 52);
		frame.getContentPane().add(btnSearchname);
	}
}
