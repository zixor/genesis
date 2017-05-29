package org.zixor.genesis.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JInternalFrame;

import org.zixor.utilities.Images;

public class AbrirAction extends AbstractAction {

	/**
	 * 
	 */
	public AbrirAction(JInternalFrame parent) {
		super("", Images.Abrir.getIcon(24, 24));
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
