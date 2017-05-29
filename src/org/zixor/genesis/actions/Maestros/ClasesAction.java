package org.zixor.genesis.actions.Maestros;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.ClientesInternalFrame_;
import org.zixor.genesis.jFrames.MainWindow;

public class ClasesAction extends AbstractAction {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	MainWindow parentWindow;

	public ClasesAction(MainWindow parent) {
		putValue(NAME, "Clases");
		parentWindow = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ClientesInternalFrame_ clientes = new ClientesInternalFrame_();
		System.out.println(clientes.getName());
		parentWindow.addPageFrame(clientes);	
	}

}
