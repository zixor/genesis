package org.zixor.genenesis.components;

import javax.swing.JInternalFrame;
import javax.swing.JToolBar;

import org.zixor.genenesis.jInternalFrames.AdmonPersonasInternalFrame;
import org.zixor.genesis.actions.AbrirAction;
import org.zixor.genesis.actions.GuardarAction;

public class ToolBarAmin extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdmonPersonasInternalFrame parent;

	public ToolBarAmin(JInternalFrame windosParent) {
		parent = (AdmonPersonasInternalFrame) windosParent;
		initcomponents();
	}

	private void initcomponents() {
		add(new AbrirAction(parent));
		add(new GuardarAction(parent));
		
	}

}
