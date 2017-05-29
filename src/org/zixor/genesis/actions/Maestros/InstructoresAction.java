package org.zixor.genesis.actions.Maestros;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.ClientesInternalFrame_;
import org.zixor.genenesis.jInternalFrames.InstructoresInternalFrame;
import org.zixor.genesis.jFrames.MainWindow;

public class InstructoresAction extends AbstractAction {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	MainWindow parentWindow;

	public InstructoresAction(MainWindow parent) {
		putValue(NAME, "Instructores");
		parentWindow = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		InstructoresInternalFrame clientes = new InstructoresInternalFrame();
		System.out.println(clientes.getName());
		parentWindow.addPageFrame(clientes);	
	}

}
