package org.zixor.genesis.jFrames;

// SiteFrame.java
// A simple extension of the JInternalFrame class that contains a list object.
// Elements of the list represent HTML pages for a web site.
//
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SiteFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList nameList;
	MainWindow parent;
	// Hardcode the pages of our "site" to keep things simple.
	String[] pages = { "index.html", "page1.html", "page2.html" };

	public SiteFrame(String name, MainWindow sm) {
		super("Site: " + name, true, true, true);
		parent = sm;
		setBounds(50, 50, 250, 100);
		nameList = new JList(pages);
		nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				// We know this is the list, so pop up the page.
				if (!lse.getValueIsAdjusting()) {
					parent.addPageFrame((String) nameList.getSelectedValue());
				}
			}
		});
		Container contentPane = getContentPane();
		contentPane.add(nameList, BorderLayout.CENTER);
	}
}