package support.cse131.gui;

import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class LookAndFeels {
	public static boolean setNimbusLookAndFeel() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				UIManager.setLookAndFeel(info.getClassName());
				return true;
			}
		}
		return false;
	}

	public static Icon getErrorIcon() {
		return UIManager.getIcon("OptionPane.errorIcon");
	}

	public static Icon getQuestionIcon() {
		return UIManager.getIcon("OptionPane.questionIcon");
	}

	public static Icon getInformationIcon() {
		return UIManager.getIcon("OptionPane.informationIcon");
	}
}
