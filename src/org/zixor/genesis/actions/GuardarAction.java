package org.zixor.genesis.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;

import org.zixor.utilities.Images;

public class GuardarAction extends AbstractAction implements Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GuardarAction(JInternalFrame parent){
		super("", Images.Save.getIcon(24, 24));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
