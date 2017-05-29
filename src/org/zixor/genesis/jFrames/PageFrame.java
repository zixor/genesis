package org.zixor.genesis.jFrames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PageFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainWindow parent;
	String filename;
	JTextArea ta;

	public PageFrame(String name, MainWindow sm) {
		super("Page: " + name, true, true, true, true);
		parent = sm;
		setBounds(50, 50, 300, 150);
		// Use the JFrame's content pane to store our desktop.
		Container contentPane = getContentPane();
		// Create a text area to display the contents of our file and put it in
		// a
		// scrollable pane so we can get to all of it.
		ta = new JTextArea();
		JScrollPane jsp = new JScrollPane(ta);
		contentPane.add(jsp, BorderLayout.CENTER);
		// Add a "File->Save" option to the menu bar for this frame.

		JMenuBar jmb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				saveContent();
			}
		});
		fileMenu.add(saveItem);
		jmb.add(fileMenu);
		setJMenuBar(jmb);
		// Now get the content, based on the filename that was passed in.
		filename = name;
		loadContent();
	}

	public void loadContent() {
		try {
			FileReader fr = new FileReader(filename);
			ta.read(fr, null);
			fr.close();
		} catch (Exception e) {
			System.err.println("Could not load page: " + filename);
		}
	}

	public void saveContent() {
		try {
			FileWriter fw = new FileWriter(filename);
			ta.write(fw);
			fw.close();
		} catch (Exception e) {
			System.err.println("Could not save page: " + filename);
		}
	}

	public void cutText() {
		ta.cut();
	}

	public void copyText() {
		ta.copy();
	}

	public void pasteText() {
		ta.paste();
	}
}