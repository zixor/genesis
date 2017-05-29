package org.zixor.genesis.actions.Maestros;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.ClientesInternalFrame_;
import org.zixor.genesis.jFrames.MainWindow;

public class RegistrarPagoClienteAction extends AbstractAction {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	MainWindow parentWindow;

	public RegistrarPagoClienteAction(MainWindow parent) {
		putValue(NAME, "Pagos Matrículas");
		parentWindow = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ClientesInternalFrame_ clientes = new ClientesInternalFrame_();
		System.out.println(clientes.getName());
		parentWindow.addPageFrame(clientes);	
	}

}
