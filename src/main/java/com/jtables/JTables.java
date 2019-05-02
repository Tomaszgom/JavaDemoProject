package com.jtables;
	import java.awt.BorderLayout;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.io.IOException;
	import java.sql.*;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.table.DefaultTableModel;

	/**
	 * 
	 * JTable connecting to database Customer table
	 * allows to display, add, remove and modify customer data
	 *
	 */
	
	public class JTables extends JFrame{
		
		static JLabel lTopHeader, lFirstName, lLastName, lCity, lPoints, lLastLoginDate;		
		static JTextField tfFirstName, tfLastName, tfCity, tfPoints, tfLastLoginDate;
		static java.util.Date dateLastLoginDate, sqlLastLoginDate;
		static ResultSet rows;		
			// column names for table		
		static Object[] columns = {"Client ID", "First Name", "Last Name", "City", "Points", "Last Login Date"};		
			// Holds row values for the table		
		static Object[][] databaseResults;
		static int getLastID = 0;	
			// DefaultTableModel defines the methods JTable will use (overriding the getColumnClass method)		
	    static DefaultTableModel dTableModel = new DefaultTableModel(databaseResults, columns){
	        
	    	public Class getColumnClass(int column) {
	            Class returnValue;
	            
	            	// check if column exists
	            if ((column >= 0) && (column < getColumnCount())) {
	              returnValue = getValueAt(0, column).getClass();
	            } else {
	            	// Returns the class of the item in the column	
	              returnValue = Object.class;
	            }
	            return returnValue;
	          }
	        };
	        
	        		// Create a JTable using the custom DefaultTableModel	        
	        static JTable table = new JTable(dTableModel);
	        
	        public static void main(String[] args){	
	        	OpenJTable("//localhost","1521","javauser","password");
	        }
		
		public static void OpenJTable(String host, String port, String userName, String password){		
			
			JFrame frame = new JFrame();
		   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				    	
	    	Connection conn = null;	    	
	        try {	          	           
	            Class.forName("oracle.jdbc.driver.OracleDriver");// forName dynamically loads the class
	                        
	          //conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","javauser","password");  
	            // Statement objects executes a SQL query createStatement returns a Statement object
	            //ResultSet Reflects Changes in the databas
	            //TYPE_SCROLL_SENSITIVE - domyœlnie prze result set mo¿na przejœæ tylko raz od 1 do ostatniego rzedu, dziêki temu mo¿na przewijaæ
	            //i aktualizwaæ an
	            //CONCUR_UPDATABLE	-	Allows Modification to Data in a Table through the ResultSet
	            //pozwala na aktualizowanie bazy danych zawsze kiedy tylko zmiany robione s¹ w JTable/
	            //make a result set that is scrollable and (in)sensitive to updates by others, and that is updatable. 
	          
	          conn = DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+"/xe",userName,password);
	          
	            Statement sqlState = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
	            		ResultSet.CONCUR_UPDATABLE);
	            
	            //Read Select from SQL file 	            
	            //String sqlSelect = "SELECT CLIENT_ID, FIRST_NAME, LAST_NAME, CITY, POINTS, LAST_LOGIN_DATE FROM HR.CLIENT";
	            String sqlSelect = null;
	            try{
	            	sqlSelect = LoadSQL.ReadSelect();
	            }catch(IOException ex){
		        	ex.printStackTrace();
		        	JOptionPane.showMessageDialog(null, "IOException: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	            }
	            
	            // A ResultSet contains a table of data representing the
	            // results of the query. It can not be changed and can 
	            // only be read in one direction
	            
	            rows = sqlState.executeQuery(sqlSelect);
	            
	             // Temporarily holds the row results         
	            Object[] tempRow;
	            
	            // next is used to iterate through the results of a query            
	            while(rows.next()){
	            	
	            	tempRow = new Object[]{rows.getInt(1), rows.getString(2), rows.getString(3), rows.getString(4), rows.getInt(5), rows.getDate(6)};	            		            	
	            	if (rows.getInt(1) > getLastID) {
	            		getLastID = rows.getInt(1);	            		
	            	}
	            	
	            	// Add the row of data to the JTable	            	
	            	dTableModel.addRow(tempRow);
	            }
	        } 	        
	        catch (SQLException ex) {
	            
	        	// String describing the error	        	
	            System.out.println("SQLException: " + ex.getMessage());	
	            JOptionPane.showMessageDialog(null, "SQLException: " + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
	            // Vendor specific error code	            
	            System.out.println("VendorError: " + ex.getErrorCode());
	            JOptionPane.showMessageDialog(null, "VendorError: " + ex.getErrorCode(),"Error", JOptionPane.ERROR_MESSAGE);
	        } 	        
	        catch (ClassNotFoundException e) {
				// Executes if the driver can't be found
				e.printStackTrace();
			} 
	        
        
	        table.setFont(new Font("Serif", Font.PLAIN, 16));	               
	        table.setRowHeight(table.getRowHeight()+16);	        	    
		    table.setAutoCreateRowSorter(true);		//enabling data sorting    
		    	// Adds the table to a scrollpane	    
		    JScrollPane scrollPane = new JScrollPane(table);
		    
		    
		    	// Adds the scrollpane to the frame		    
		    frame.add(scrollPane, BorderLayout.SOUTH);
		    
		    // Creates a button that when pressed executes the code
		    // in the method actionPerformed		    
		    JButton addPres = new JButton("Add Client");
		    
		    addPres.addActionListener(new ActionListener(){
		   // --- On action Add Client pressed
		    	public void actionPerformed(ActionEvent e){
		    		
		    		String sFirstName = "", sLastName = "", sCity = "", sPoints = "", sLDate = "";	    		
		    		// getText from fields    		
		    		sFirstName = tfFirstName.getText();
		    		sLastName = tfLastName.getText();
		    		sCity = tfCity.getText();
		    		sPoints = tfPoints.getText();
		    		sLDate = tfLastLoginDate.getText();
		    		sqlLastLoginDate = getADate(sLDate);
		    		
		    		try {
		    			
		    			// Moves the database to the row where data will be placed
						rows.moveToInsertRow();
						
						// Update the values in the database
						getLastID+=1;
						rows.updateInt("CLIENT_ID", getLastID);
						rows.updateString("FIRST_NAME", sFirstName);
						rows.updateString("LAST_NAME", sLastName);
						rows.updateString("CITY", sCity);
						rows.updateString("POINTS", sPoints);
						rows.updateDate("LAST_LOGIN_DATE", (Date) sqlLastLoginDate);
						
							// Inserts the changes to the row values in the database
						rows.insertRow();						
							// Directly updates the values in the database
	//					rows.updateRow();
						
					} catch (SQLException e1) {						
						e1.printStackTrace();
					}
		    		
		    		int intClientID = 0;
		    		
		    		try {
		    			
		    			// Go to the last row of ResultSet, in this case the one which we just inserted and get the id
		    			
						rows.last();
						intClientID = rows.getInt(1)+1;
					} catch (SQLException e1) {						
						e1.printStackTrace();
					}
		    		
		    		Object[] client = {intClientID, sFirstName, sLastName, sCity, sPoints, sqlLastLoginDate};
		    		System.out.println("TGintClientID:   "+intClientID);
		    			// Add the row of values to the JTable		    		
		    		dTableModel.addRow(client);		    		
		    	}		    	
		    });
		    
		    JButton removePres = new JButton("Remove Client");
		    
		    removePres.addActionListener(new ActionListener(){
		    	
		    	public void actionPerformed(ActionEvent e){
		    		
		    		// Will remove which ever row that is selected		    		
		    		dTableModel.removeRow(table.getSelectedRow());
		    		
		    		try {
		    			
		    			// Moves the database to the row currently selected
		    			// getSelectedRow returns the row number for the selected row		    			
						rows.absolute(table.getSelectedRow());
						
						// Deletes the selected row from the database						
						rows.deleteRow();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		    		
		    	}
		    });
		    
		 //---------- Define values for my labels		    
		    lFirstName = new JLabel("First Name");
		    lLastName = new JLabel("Last Name");
		    lCity = new JLabel("City");
		    lPoints = new JLabel("Points");
		    lLastLoginDate = new JLabel("Last Login Date");
		    lTopHeader = new JLabel("JTable and some Swing elements. Screen allows to add, remove or modify records.");
		    lTopHeader.setFont(new Font("Serif", Font.PLAIN, 25));
		    // Define the size of text fields
		    
		    tfFirstName = new JTextField(12);
		    tfLastName = new JTextField(12);
		    tfCity = new JTextField(12);
		    tfPoints = new JTextField(12);
		    	// Set default text and size for text field
		    
		    tfLastLoginDate = new JTextField("yyyy-MM-dd", 10);
		    
		    	// Create a panel to hold editing buttons and fields		    
		    JPanel inputPanel = new JPanel();
		    JPanel TopPanel = new JPanel();
		    
		    	// Put components in the panel
		    
		    inputPanel.add(lFirstName);
		    inputPanel.add(tfFirstName);
		    inputPanel.add(lLastName);
		    inputPanel.add(tfLastName);
		    inputPanel.add(lCity);
		    inputPanel.add(tfCity);
		    inputPanel.add(lPoints);
		    inputPanel.add(tfPoints);
		    inputPanel.add(lLastLoginDate);
		    inputPanel.add(tfLastLoginDate);
		    inputPanel.add(addPres);
		    inputPanel.add(removePres);
		    
		    TopPanel.add(lTopHeader);
		    
		    // Add the component panel to the frame
		    frame.add(TopPanel, BorderLayout.NORTH);
		    frame.add(inputPanel, BorderLayout.CENTER);
		    
	// --- Mouse Listener change Value box
		    table.addMouseListener(new MouseAdapter(){  
		    	public void mouseReleased(MouseEvent me){
		            String value = JOptionPane.showInputDialog(null,"Enter Cell Value:"); 
		            
		            	// Makes sure a value is changed only if OK is clicked		            
		            if (value != null) {  
		                table.setValueAt(value, table.getSelectedRow(), table.getSelectedColumn());  
		            }else {
		            	return;
		            }
		            
		            try {
		            	// Move to the selected row		            	
		            	rows.absolute(table.getSelectedRow()+1);
		            	
		            	// Get the name of the selected column
			            
			            String updateCol = dTableModel.getColumnName(table.getSelectedColumn());			   
			            int updateColNb = table.getSelectedColumn();
			           // JOptionPane.showMessageDialog(null, "table.getSelectedColumn()"+updateColNb);
			            
		            	switch (updateCol) {
		            	
		            	// Uses a different update method depending on the data type
		            	//"Client ID", "First Name", "Last Name", "City", "Points", "Last Login Date"
		            		case "Last Login Date":		            			            			
		            			sqlLastLoginDate = getADate(value);
		            			rows.updateDate(updateCol, (Date) sqlLastLoginDate);

		    					rows.updateRow();
		            			break;
		            		
		            		default: 
		            			System.out.println("Start ca");		            	
		            			//rows.updateString(updateCol, value);		            		
		            			rows.updateString(updateColNb, value);		            					            			
		            			System.out.println("Stop ca");
		            			System.out.println("Current Row: " + rows.getRow());		            			
		    					rows.updateRow();		    					
		            			break;		            			
		            	}
		            			            	
					} catch (SQLException e) {						
						JOptionPane.showMessageDialog(null, "DB Error: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
						 e.printStackTrace();
					} 
		    	} 
		    });  
		    
		    frame.setSize(1050, 700);
		    frame.setVisible(true);
			
		}
		
				//  Format String to date		
		public static java.util.Date getADate(String sDate){
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				dateLastLoginDate = dateFormatter.parse(sDate);
				sqlLastLoginDate = new java.sql.Date(dateLastLoginDate.getTime());
			} catch (ParseException e1) {				
				e1.printStackTrace();
			}
			return sqlLastLoginDate;		
		}
		
	}
