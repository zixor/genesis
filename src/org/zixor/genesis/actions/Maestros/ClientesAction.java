package org.zixor.genesis.actions.Maestros;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.ClientesInternalFrame_;
import org.zixor.genenesis.jInternalFrames.ClientsInternalFrame;
import org.zixor.genesis.jFrames.MainWindow;

public class ClientesAction extends AbstractAction {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	MainWindow parentWindow;

	public ClientesAction(MainWindow parent) {
		putValue(NAME, "Clientes");
		parentWindow = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		ClientesInternalFrame_ clientes = new ClientesInternalFrame_();
		ClientsInternalFrame clientes = new ClientsInternalFrame();
		System.out.println(clientes.getName());
		parentWindow.addPageFrame(clientes);	
	}

}
