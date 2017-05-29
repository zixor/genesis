package org.zixor.genesis.actions;

// CopyAction.java
// A simple Action that copies text from a PageFrame object
//
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.ProductsInternalFrame;
import org.zixor.genesis.jFrames.MainWindow;
import org.zixor.utilities.Images;

public class ReportsAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainWindow manager;

	public ReportsAction(MainWindow sm) {
		super("", Images.Reports.getIcon(32, 32));
		manager = sm;
	}

	public void actionPerformed(ActionEvent ae) {
		ProductsInternalFrame productos = new ProductsInternalFrame();
		manager.addPageFrame(productos);
	}
}