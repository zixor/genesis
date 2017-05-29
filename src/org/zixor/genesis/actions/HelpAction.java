package org.zixor.genesis.actions;

// CopyAction.java
// A simple Action that copies text from a PageFrame object
//
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.ClientsInternalFrame;
import org.zixor.genesis.jFrames.MainWindow;
import org.zixor.utilities.Images;

public class HelpAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainWindow manager;

	public HelpAction(MainWindow sm) {
		super("", Images.Help.getIcon(32, 32));
		manager = sm;
	}

	public void actionPerformed(ActionEvent ae) {
		ClientsInternalFrame clientes = new ClientsInternalFrame();
		manager.addPageFrame(clientes);
	}
}