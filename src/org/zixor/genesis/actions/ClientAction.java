package org.zixor.genesis.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.AdmonPersonasInternalFrame;
import org.zixor.genenesis.tables.models.ControlTablaPersona;
import org.zixor.genenesis.tables.models.ModeloTablaPersona;
import org.zixor.genesis.jFrames.MainWindow;
import org.zixor.utilities.Images;

public class ClientAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainWindow manager;

	public ClientAction(MainWindow mainWindow) {
		super("Clientes", Images.New.getIcon(32, 32));
		manager = mainWindow;
	}

	public void actionPerformed(ActionEvent ae) {
		ModeloTablaPersona modelo = new ModeloTablaPersona();
		ControlTablaPersona control = new ControlTablaPersona(modelo);
		AdmonPersonasInternalFrame clientes = AdmonPersonasInternalFrame
				.getInstance(modelo, control);
		manager.addPageFrame(clientes);

	}
}