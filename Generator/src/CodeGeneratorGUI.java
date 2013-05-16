
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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

public class CodeGeneratorGUI implements ActionListener {

	private CodeGeneratorControl generate;
	private JTextArea xpath;
	private JTextArea log;
	private JButton openButton;
	
	private JTree tree;
	private VSX parser;
	
	private String currentChooseFilePath;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CodeGeneratorGUI();
	}

	public CodeGeneratorGUI() {
		parser = new VSX();
		init();
	}

	private void init() {
		generate = new CodeGeneratorControl();

		// create frame
		JFrame frame = new JFrame("XSLT Code Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);

		// create grid panel
		JPanel flowPanel = new JPanel(new FlowLayout());

		// create flow layout panel
		JPanel gridPanel2 = new JPanel(new GridLayout(1, 1));

		JPanel gridPanel3 = new JPanel(new GridLayout(3, 1));
		log = new JTextArea(1, 50);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);

		// create pathTextField for display XPath (old name = path)
		xpath = new JTextArea(10,30);
		xpath.setMargin(new Insets(5, 5, 5, 5));
		xpath.setEditable(false);
		JScrollPane xpathScrollPane = new JScrollPane(xpath);
		gridPanel3.add(xpathScrollPane);

		// Create the open button. We use the image from the JLF
		// Graphics Repository (but we extracted it from the jar).
		openButton = new JButton("Browse XML File: ",
				CodeGeneratorControl.createImageIcon("images/Open16.gif"));
		openButton.addActionListener(this);
		openButton.setActionCommand("Browse");

		// openButton.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// JFileChooser fileChooser = new JFileChooser();
		//
		// fileChooser.setAcceptAllFileFilterUsed(false);
		//
		// int rVal = fileChooser.showOpenDialog(null);
		// if (rVal == JFileChooser.APPROVE_OPTION) {
		// log.setText(fileChooser.getSelectedFile().toString());
		// path.setText(generate.pathfinder(fileChooser.getSelectedFile().toString(),"man:referenceNumber"));
		// }

		// }

		// });

		// Create the save button. We use the image from the JLF
		// Graphics Repository (but we extracted it from the jar).

		// For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(openButton);

		// Add the buttons and the log to this panel.
		flowPanel.add(buttonPanel, BorderLayout.PAGE_START);
		flowPanel.add(logScrollPane, BorderLayout.CENTER);

		// create copy button
		JButton btnCopy = new JButton("Copy");
		gridPanel3.add(btnCopy);
		btnCopy.setActionCommand("CopyText");
		btnCopy.addActionListener(this);

		// create export button
		JButton btnBrowse = new JButton("Export");
		gridPanel3.add(btnBrowse);
		btnBrowse.setActionCommand("Export");
		btnBrowse.addActionListener(this);

		JPanel treePanel = new JPanel(new BorderLayout());
		tree = new JTree();
		tree.setEnabled(false);
		treePanel.add(new JScrollPane(tree));
//		treePanel.setSize(300, 400);
		treePanel.setVisible(true);
		
		
		// create main panel
//		JPanel subPanel = new JPanel(new GridLayout(1, 2));
//		subPanel.add(gridPanel2);
//		subPanel.add(gridPanel3);
		
//		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
//		mainPanel.add(flowPanel);
//		mainPanel.add(subPanel);
		
		
		JPanel subPanel = new JPanel(new BorderLayout());
//		subPanel.add(gridPanel2, BorderLayout.CENTER);
		subPanel.add(treePanel, BorderLayout.CENTER);
		subPanel.add(gridPanel3, BorderLayout.EAST);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(flowPanel, BorderLayout.NORTH);
		mainPanel.add(subPanel, BorderLayout.CENTER);
		
		frame.add(mainPanel);
		frame.setMinimumSize(new Dimension(800, 300));
		frame.setSize(800, 350);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Browse")) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("XML File", "xml"));

			fileChooser.setAcceptAllFileFilterUsed(false);

			int rVal = fileChooser.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				log.setText(fileChooser.getSelectedFile().toString());
				currentChooseFilePath = fileChooser.getSelectedFile().toString();
//				xpath.setText(generate.pathfinder(fileChooser.getSelectedFile().toString(), "PreviousDate"));
				
				//Update UI
				tree.setModel(parser.parse(log.getText()));
				for(int i = 0 ; i < tree.getRowCount() ; i++){
					tree.expandRow(i);
				}
				
				tree.updateUI();
				
				//Enable JTree and Add Listener
				tree.setEnabled(true);
				tree.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						  int selRow = tree.getRowForLocation(arg0.getX(), arg0.getY());
					         TreePath selPath = tree.getPathForLocation(arg0.getX(), arg0.getY());
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
					         
					         String selectionPath =  tree.getSelectionPath().toString()
	 								 					 .replaceAll("\\:  \\(\\)(, )?", "/")
	 								 					 .replaceAll("\\[", "/")
	 								 					 .replaceAll("\\]", "")
	 								 					 .replaceAll("\\:  \\(.*\\)(, )?", "");
					         System.out.println("SelectionPath = " + selectionPath);
					         
//					         xpath.setText(generate.pathfinder(currentChooseFilePath, "PreviousDate"));
					         xpath.setText(selectionPath);
					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
//						  int selRow = tree.getRowForLocation(arg0.getX(), arg0.getY());
//					         TreePath selPath = tree.getPathForLocation(arg0.getX(), arg0.getY());
//					         if(selRow != -1) {
//					             if(arg0.getClickCount() == 1) { //Single click
////					                 mySingleClick(selRow, selPath);
//					            	 System.out.println("Test1");
//					             }
//					             else if(arg0.getClickCount() == 2) { //Double click
////					                 myDoubleClick(selRow, selPath);
//					            	 System.out.println("Test2");
//					             }
//					         }
//					         System.out.println("SelectionPath = " + tree.getSelectionPath());
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

//			JFrame frame = new JFrame("JTree");
//			JTree tree = new JTree(parser.parse(log.getText()));
//			frame.getContentPane().add(new JScrollPane(tree));
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setSize(300, 400);
//			frame.setVisible(true);

		}
		if (e.getActionCommand().equals("CopyText")) {
			generate.copyToClipboard(xpath.getText());
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
