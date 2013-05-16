import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//import CodeGeneratoGUIV2.Tag;
//import CodeGeneratoGUIV2.XMLTreeHandler;
public class CodeGeneratoGUIV2 implements ActionListener {
	private CodeGeneratorControlV2 generate;
	private JTextArea xpath;
	private JTextArea logIN;
	private JTextArea logOUT;
	private JButton openButtonIN;
	private JButton openButtonOUT;
	
	private JTree treeIN;
	private JTree treeOUT;
	private VSX parser;
	public String nodeIN="";
	public String nodeOUT="";

	private String currentChooseFilePath;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CodeGeneratoGUIV2();
	}

	public CodeGeneratoGUIV2() {
		parser = new VSX();
		init();
	}
	
	private void init() {
		
		JFrame frame = new JFrame("XSLT Code Generator V2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JPanel treePanelOUT = new JPanel(new BorderLayout());
		treeOUT = new JTree();
		treeOUT.setEnabled(false);
		treePanelOUT.add(new JScrollPane(treeOUT));
		treePanelOUT.setVisible(true);
		
		xpath = new JTextArea(10,30);
		xpath.setMargin(new Insets(5, 5, 5, 5));
		xpath.setEditable(false);
		JScrollPane xpathScrollPane = new JScrollPane(xpath);
		
		JPanel treePanelIN = new JPanel(new BorderLayout());
		treeIN = new JTree();
		treeIN.setEnabled(false);
		treePanelIN.add(new JScrollPane(treeIN));
		treePanelIN.setVisible(true);
		
		openButtonOUT = new JButton("Browse OUTPUT: ",
				CodeGeneratorControl.createImageIcon("images/Open16.gif"));
		openButtonOUT.addActionListener(this);
		openButtonOUT.setActionCommand("BrowseOUT");
		logOUT = new JTextArea(1, 50);
		logOUT.setMargin(new Insets(5, 5, 5, 5));
		logOUT.setEditable(false);
		JScrollPane logScrollPaneOUT = new JScrollPane(logOUT);
		
		
		openButtonIN = new JButton("Browse INPUT: ",
				CodeGeneratorControl.createImageIcon("images/Open16.gif"));
		openButtonIN.addActionListener(this);
		openButtonIN.setActionCommand("BrowseIN");
		logIN = new JTextArea(1, 50);
		logIN.setMargin(new Insets(5, 5, 5, 5));
		logIN.setEditable(false);
		JScrollPane logScrollPaneIN = new JScrollPane(logIN);
		

		
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		
		JPanel Panel1 = new JPanel(new GridLayout());
		Panel1.add(treePanelOUT, BorderLayout.EAST);
		Panel1.add(xpathScrollPane, BorderLayout.CENTER);
		Panel1.add(treePanelIN, BorderLayout.WEST);
		
		
		JPanel Panel2 = new JPanel(new GridLayout());
		
		JPanel subPanel1 = new JPanel(new GridLayout());
		subPanel1.add(openButtonOUT, BorderLayout.CENTER);
		subPanel1.add(logScrollPaneOUT, BorderLayout.EAST);
		Panel2.add(subPanel1, BorderLayout.WEST);
		
		JPanel subPane2 = new JPanel(new GridLayout());
		subPane2.add(openButtonIN, BorderLayout.CENTER);
		subPane2.add(logScrollPaneIN, BorderLayout.EAST);
		Panel2.add(subPane2, BorderLayout.EAST);
		

		
		// create Export button
		JButton btnExport = new JButton("Export file");
		btnExport.setActionCommand("Export");
		btnExport.addActionListener(this);
		
		
	
		
		mainPanel.add(Panel1, BorderLayout.NORTH);
		mainPanel.add(Panel2, BorderLayout.CENTER);
		mainPanel.add(btnExport, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		frame.setMinimumSize(new Dimension(900, 400));
		frame.setSize(1000, 480);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String outputPath = "ExportXSLTCode" + ".txt";
		//Check File Existing, then change name to unique file
		File outputFile = new File(outputPath);
		int uniqueID = 1;
		while(outputFile.exists()){
			outputPath = "ExportXSLTCode_" + uniqueID++ + ".txt";
			outputFile = new File(outputPath);
		}
		
		//export
		if (e.getActionCommand().equals("Export")) {
			
			try {
//			  	BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/I-Nase_01/Dropbox/P'au/file.txt"));
				BufferedWriter out = new BufferedWriter(new FileWriter(outputPath));
	            //print text to file
			  	out.write("Node OUT :"+nodeOUT);
			  	out.newLine();
			  	out.write("Node IN :"+nodeIN);
			  	out.newLine();
			  	out.write("Path :"+xpath.getText());
			  	out.newLine();
			  	out.close();
	            }catch (Exception e1) {
	            JOptionPane.showMessageDialog (
	            null,
	            "Error in writing data!!\n\r" + e1,
	            "File Save Error",
	            JOptionPane.ERROR_MESSAGE);
	            
	        }
			
		}
		
		
		
		//Browse OUT
		if (e.getActionCommand().equals("BrowseOUT")) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("XML File", "xml"));

			fileChooser.setAcceptAllFileFilterUsed(false);

			int rVal = fileChooser.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				logOUT.setText(fileChooser.getSelectedFile().toString());
				currentChooseFilePath = fileChooser.getSelectedFile().toString();
//				xpath.setText(generate.pathfinder(fileChooser.getSelectedFile().toString(), "PreviousDate"));
				
				//Update UI
				treeOUT.setModel(parser.parse(logOUT.getText()));
				for(int i = 0 ; i < treeOUT.getRowCount() ; i++){
					treeOUT.expandRow(i);
				}
				
				treeOUT.updateUI();
				
				//Enable JTree and Add Listener
				treeOUT.setEnabled(true);
				treeOUT.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						  int selRow = treeOUT.getRowForLocation(arg0.getX(), arg0.getY());
					         TreePath selPath = treeOUT.getPathForLocation(arg0.getX(), arg0.getY());
					         if(selRow != -1) {
					             if(arg0.getClickCount() == 1) { //Single click
//					                 mySingleClick(selRow, selPath);
					            	 System.out.println("Test1");
					             }
					             else if(arg0.getClickCount() == 2) { //Double click
//					                 myDoubleClick(selRow, selPath);
					            	 System.out.println("Test2");
					             }
					         }
					       
					         nodeOUT=treeOUT.getLastSelectedPathComponent().toString();
					         System.out.println("Node OUT :"+nodeOUT);
//					         String selectionPath =  treeOUT.getSelectionPath().toString()
//	 								 					 .replaceAll("\\:  \\(\\)(, )?", "/")
//	 								 					 .replaceAll("\\[", "/")
//	 								 					 .replaceAll("\\]", "")
//	 								 					 .replaceAll("\\:  \\(.*\\)(, )?", "");
//					         System.out.println("SelectionPath = " + selectionPath);
//					         
//					         xpath.setText(generate.pathfinder(currentChooseFilePath, "PreviousDate"));
//					         xpath.setText(selectionPath);
					         

					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			}

		}
		
		// BrowseIN
				if (e.getActionCommand().equals("BrowseIN")) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileFilter(new FileNameExtensionFilter("XML File", "xml"));

					fileChooser.setAcceptAllFileFilterUsed(false);

					int rVal = fileChooser.showOpenDialog(null);
					if (rVal == JFileChooser.APPROVE_OPTION) {
						logIN.setText(fileChooser.getSelectedFile().toString());
						currentChooseFilePath = fileChooser.getSelectedFile().toString();
//						xpath.setText(generate.pathfinder(fileChooser.getSelectedFile().toString(), "PreviousDate"));
						
						//Update UI
						treeIN.setModel(parser.parse(logIN.getText()));
						for(int i = 0 ; i < treeIN.getRowCount() ; i++){
							treeIN.expandRow(i);
						}
						
						treeIN.updateUI();
						
						//Enable JTree and Add Listener
						treeIN.setEnabled(true);
						treeIN.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent arg0) {
								// TODO Auto-generated method stub
								  int selRow = treeIN.getRowForLocation(arg0.getX(), arg0.getY());
							         TreePath selPath = treeIN.getPathForLocation(arg0.getX(), arg0.getY());
							         if(selRow != -1) {
							             if(arg0.getClickCount() == 1) { //Single click
//							                 mySingleClick(selRow, selPath);
							            	 System.out.println("Test1");
							             }
							             else if(arg0.getClickCount() == 2) { //Double click
//							                 myDoubleClick(selRow, selPath);
							            	 System.out.println("Test2");
							             }
							         }
							         nodeIN=treeIN.getLastSelectedPathComponent().toString();
							         System.out.println("Node IN :"+nodeIN);
							         String selectionPath =  treeIN.getSelectionPath().toString()
			 								 					 .replaceAll("\\:  \\(\\)(, )?", "/")
			 								 					 .replaceAll("\\[", "/")
			 								 					 .replaceAll("\\]", "")
			 								 					 .replaceAll("\\:  \\(.*\\)(, )?", "");
							         System.out.println("SelectionPath = " + selectionPath);
							         
//							         xpath.setText(generate.pathfinder(currentChooseFilePath, "PreviousDate"));
							         xpath.setText(selectionPath);
							}
							
							@Override
							public void mousePressed(MouseEvent arg0) {
								// TODO Auto-generated method stub

							}
							
							@Override
							public void mouseExited(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseEntered(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void mouseClicked(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
						});
					}

				}
		

	}

	public TreeModel parse(String filename) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		XMLTreeHandler handler = new XMLTreeHandler();
		try {
			// Parse the input.
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new File(filename), handler);
		} catch (Exception e) {
			System.err.println("File Read Error: " + e);
			e.printStackTrace();
			return new DefaultTreeModel(new DefaultMutableTreeNode("error"));
		}
		return new DefaultTreeModel(handler.getRoot());
	}

	public static class XMLTreeHandler extends DefaultHandler {
		private DefaultMutableTreeNode root, currentNode;

		public DefaultMutableTreeNode getRoot() {
			return root;
		}

		// SAX Parser Handler methods...
		public void startElement(String namespaceURI, String lName,
				String qName, Attributes attrs) throws SAXException {
			String eName = lName; // Element name
			if ("".equals(eName))
				eName = qName;
			Tag t = new Tag(eName, attrs);
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(t);
			if (currentNode == null) {
				root = newNode;
			} else {
				// Must not be the root node...
				currentNode.add(newNode);
			}
			currentNode = newNode;
		}

		public void endElement(String namespaceURI, String sName, String qName)
				throws SAXException {
			currentNode = (DefaultMutableTreeNode) currentNode.getParent();
		}

		public void characters(char buf[], int offset, int len)
				throws SAXException {
			String s = new String(buf, offset, len).trim();
			((Tag) currentNode.getUserObject()).addData(s);
		}
	}

	public static class Tag {
		private String name;

		private String data;

		private Attributes attr;

		public Tag(String n, Attributes a) {
			name = n;
			attr = a;
		}

		public String getName() {
			return name;
		}

		public Attributes getAttributes() {
			return attr;
		}

		public void setData(String d) {
			data = d;
		}

		public String getData() {
			return data;
		}

		public void addData(String d) {
			if (data == null) {
				setData(d);
			} else {
				data += d;
			}
		}

		public String getAttributesAsString() {
			StringBuffer buf = new StringBuffer(256);
			for (int i = 0; i < attr.getLength(); i++) {
				buf.append(attr.getQName(i));
				buf.append("=\"");
				buf.append(attr.getValue(i));
				buf.append("\"");
			}
			return buf.toString();
		}

		public String toString() {
			String a = getAttributesAsString();
			return name + ": " + a + (data == null ? "" : " (" + data + ")");
		}
	}

}
