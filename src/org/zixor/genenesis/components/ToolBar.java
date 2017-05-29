package org.zixor.genenesis.components;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import org.zixor.genesis.actions.ReportsAction;
import org.zixor.genesis.actions.ClientAction;
import org.zixor.genesis.actions.HelpAction;
import org.zixor.genesis.jFrames.MainWindow;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow parent;

	public ToolBar(JFrame windosParent) {
		parent = (MainWindow) windosParent;
		initcomponents();
	}

	private void initcomponents() {
		add(new ClientAction(parent));
		add(new ReportsAction(parent));
		add(new HelpAction(parent));
	}

}
