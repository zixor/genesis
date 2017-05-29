package org.zixor.genesis.jFrames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import org.zixor.genenesis.components.MenuPPal;
import org.zixor.genenesis.components.ToolBar;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	JLayeredPane desktop;
	ArrayList<JInternalFrame> popups = new ArrayList<JInternalFrame>();
	private static MainWindow instance;
	private MainWindow() {
		super("Genesis");
		initComponents();		
	}
	
	public static MainWindow getInstance(){
		if(instance == null){
			instance = new MainWindow();
		}
		return instance;
	}

	private void initComponents() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		JToolBar toolBar = new ToolBar(this);		
		contentPane.add(toolBar, BorderLayout.NORTH);
		desktop = new JDesktopPane();
		contentPane.add(desktop, BorderLayout.CENTER);
		JMenuBar menuBar = new MenuPPal(this);
		setJMenuBar(menuBar);
	}
	
	// Methods to create our internal frames
	public void addSiteFrame(String name) {
		SiteFrame sf = new SiteFrame(name, this);
		popups.add(sf);
		desktop.add(sf, new Integer(2)); // Keep sites on top for now.
		sf.setVisible(true);
	}

	public void addPageFrame(String name) {
		PageFrame pf = new PageFrame(name, this);
		desktop.add(pf, new Integer(1));
		pf.setVisible(true);
		pf.setIconifiable(true);
		popups.add(pf);
	}
	
	public void addPageFrame(JInternalFrame internalFrame) {
		if(!popups.contains(internalFrame)){
			desktop.add(internalFrame, new Integer(1));
			internalFrame.setVisible(true);	
			popups.add(internalFrame);
		}
	}

	public JInternalFrame getCurrentFrame() {
		for (JInternalFrame currentFrame : popups) {
			if (currentFrame.isSelected()) {
				return currentFrame;
			}
		}
		return null;
	}
}