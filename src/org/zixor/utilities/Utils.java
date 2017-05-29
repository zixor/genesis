package org.zixor.utilities;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JInternalFrame;

import org.zixor.genesis.jFrames.MainWindow;

public class Utils {

	public static boolean alreadyExistJinternalInMainWindow(MainWindow manager,JInternalFrame jInternalToFind){
		boolean exists = false;
		List<Component> lstComponents = Arrays.asList(manager.getComponents());
		exists = lstComponents.contains(jInternalToFind);
		return exists;
	}
}
