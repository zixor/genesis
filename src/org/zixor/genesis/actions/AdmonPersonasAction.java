package org.zixor.genesis.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.zixor.genenesis.jInternalFrames.AdmonPersonasInternalFrame;
import org.zixor.genenesis.tables.models.ControlTablaPersona;
import org.zixor.genenesis.tables.models.ModeloTablaPersona;
import org.zixor.genesis.jFrames.MainWindow;

public class AdmonPersonasAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainWindow parentWindow;

	public AdmonPersonasAction(MainWindow parent) {
		putValue(NAME, "Administrar Personas");
		parentWindow = parent;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ModeloTablaPersona modelo = new ModeloTablaPersona();
		ControlTablaPersona control = new ControlTablaPersona(modelo);
		AdmonPersonasInternalFrame clientes = AdmonPersonasInternalFrame.getInstance(modelo,control);
		parentWindow.addPageFrame(clientes);	
		
	}

}
