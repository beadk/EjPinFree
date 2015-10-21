package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class GUI {
	private JFrame bekæftFjernelseFrame;
	private JFrame frame, frameE;
	private JPanel panel, panelSettings;
	private JButton nyKode, gemKode, fSButton, fjernSystemButton,
			ersatPinButton, bekæftFjernelseButton, nejButton, pdfPreviewButton,
			getFileButton, saveSettingsButton, cancelSettingButton,
			defaultSettingButton, defaultLocButton;
	private JTextField kodeFelt, systemNummer, fSTextField, fjernSystemField,
			ersatPinField, fileLocField, writeLocX, writeLocY, defaultLocField;
	JMenuBar menu;
	JFileChooser chooser;
	JMenu mFile, mHelp;
	JMenuItem mExit, mSettings, mPrintPreview, encryptDB, mRestoDB;

	public void mainGUI(String name) {
		frame = new JFrame(name);
		frame.setMinimumSize(new Dimension(585, 310));
		panel = new JPanel();
		panel.setBackground(new Color(250, 250, 250));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		try {
			frame.setIconImage(ImageIO.read(new File("res/key.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		menu = new JMenuBar();
		menu.setBounds(0, 0, panel.getWidth(), 20);
		panel.add(menu);

		mFile = new JMenu("File");
		mFile.setMnemonic(KeyEvent.VK_E);

		mExit = new JMenuItem("Exit");
		mExit.setMnemonic(KeyEvent.VK_E);
		mExit.setToolTipText("Lukker programmet");

		mSettings = new JMenuItem("Indstillinger");
		mSettings.setMnemonic(KeyEvent.VK_S);
		mSettings.setToolTipText("Åbner Indstilleringt");

		mPrintPreview = new JMenuItem("Print Preview");
		mPrintPreview.setMnemonic(KeyEvent.VK_P);
		mPrintPreview.setToolTipText("Viser Print Preview");

		encryptDB = new JMenuItem("Encrypt DB");
		encryptDB.setMnemonic(KeyEvent.VK_K);
		encryptDB.setToolTipText("Krypter DB");

		mRestoDB = new JMenuItem("Genskab DB");
		mRestoDB.setMnemonic(KeyEvent.VK_R);
		mRestoDB.setToolTipText("Genskabber DB fra backup fil");

		mFile.add(mSettings);
		mFile.add(mPrintPreview);
		mFile.add(encryptDB);
		mFile.add(mRestoDB);
		mFile.add(mExit);
		menu.add(mFile);

		JLabel label1 = new JLabel("RS8 Kode gen.");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(15, 30, 130, 20);

		panel.add(label1);
		JLabel label2 = new JLabel("Pin kode.");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(150, 30, 80, 20);

		panel.add(label2);
		JLabel label3 = new JLabel("System nummer.");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(250, 30, 130, 20);
		panel.add(label3);

		nyKode = new JButton("Ny Kode");
		nyKode.setBounds(10, 50, 130, 20);
		panel.add(nyKode);

		gemKode = new JButton("Gem Kode");
		gemKode.setBounds(400, 50, 100, 20);
		panel.add(gemKode);

		fSButton = new JButton("Find system");
		fSButton.setBounds(175, 100, 150, 20);
		panel.add(fSButton);

		fjernSystemButton = new JButton("Fjern system");
		fjernSystemButton.setBounds(175, 140, 150, 20);
		panel.add(fjernSystemButton);

		ersatPinButton = new JButton("Ersat pin");
		ersatPinButton.setBounds(175, 180, 150, 20);
		panel.add(ersatPinButton);

		fSTextField = new JTextField("");
		fSTextField.setBounds(10, 100, 150, 20);
		panel.add(fSTextField);

		fjernSystemField = new JTextField("");
		fjernSystemField.setBounds(10, 140, 150, 20);
		panel.add(fjernSystemField);

		ersatPinField = new JTextField("");
		ersatPinField.setBounds(10, 180, 150, 20);
		panel.add(ersatPinField);

		kodeFelt = new JTextField("00000");
		kodeFelt.setBounds(150, 50, 80, 20);
		panel.add(kodeFelt);

		systemNummer = new JTextField();
		systemNummer.setBounds(250, 50, 130, 20);
		panel.add(systemNummer);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
	}

	public void errorWindow(String errorTitle, String errorMessage) {
		JFrame bSFrame = new JFrame(errorTitle);
		bSFrame.setMinimumSize(new Dimension(385, 110));
		JPanel bSPanel = new JPanel();
		bSPanel.setBackground(new Color(250, 250, 250));
		bSPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		bSPanel.setBounds(10, 10, 350, 50);
		bSFrame.add(bSPanel);
		JLabel bSLabel = new JLabel(errorMessage);
		bSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bSLabel.setBounds(bSFrame.getWidth() / 2, bSFrame.getHeight() / 2, 200,
				20);
		bSPanel.add(bSLabel);
		bSFrame.getContentPane().setLayout(null);
		bSFrame.setLocationRelativeTo(null);
		bSFrame.setVisible(true);
		bSFrame.pack();
	}

	public void noSettings(String errorTitle, String errorMessage) {
		JFrame bSFrame = new JFrame(errorTitle);
		bSFrame.setMinimumSize(new Dimension(385, 110));
		JPanel bSPanel = new JPanel();
		bSPanel.setBackground(new Color(250, 250, 250));
		bSPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		bSPanel.setBounds(10, 10, bSFrame.getWidth() - 40,
				bSFrame.getHeight() - 60);
		bSFrame.add(bSPanel);
		JLabel bSLabel = new JLabel(errorMessage);
		bSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bSLabel.setBounds(bSFrame.getWidth() / 2, bSFrame.getHeight() / 2, 200,
				90);
		bSPanel.add(bSLabel);
		bSFrame.getContentPane().setLayout(null);
		bSFrame.setLocationRelativeTo(null);
		bSFrame.setVisible(true);
		bSFrame.pack();
	}

	public void errorExWindow(String errorEX, String errorLoc) {
		JFrame bSFrame = new JFrame("Error: An exception has occured.");
		bSFrame.setMinimumSize(new Dimension(500, 160));
		JPanel bSPanel = new JPanel();
		bSPanel.setBackground(new Color(250, 250, 250));
		bSPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		bSPanel.setBounds(10, 10, bSFrame.getWidth() - 40,
				bSFrame.getHeight() - 60);
		bSFrame.add(bSPanel);
		JLabel bSLabel = new JLabel(
				"<html>An exception, "
						+ errorEX
						+ ", has occured.<br> Please mail the error file, located at <br>"
						+ errorLoc);
		bSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bSLabel.setBounds(bSFrame.getWidth() / 2, bSFrame.getHeight() / 2, 200,
				90);
		bSPanel.add(bSLabel);
		bSFrame.getContentPane().setLayout(null);
		bSFrame.setLocationRelativeTo(null);
		bSFrame.setVisible(true);
		bSFrame.pack();
	}

	public void addedWindow(String title, String message) {
		JFrame addFrame = new JFrame(title);
		addFrame.setMinimumSize(new Dimension(385, 110));
		JPanel addPanel = new JPanel();
		addPanel.setBackground(new Color(250, 250, 250));
		addPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		addPanel.setBounds(10, 10, 350, 50);
		addFrame.add(addPanel);
		JLabel addLabel = new JLabel(message);
		addLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addLabel.setBounds(addFrame.getWidth() / 2, addFrame.getHeight() / 2,
				200, 20);
		addPanel.add(addLabel);
		addFrame.getContentPane().setLayout(null);
		addFrame.setLocationRelativeTo(null);
		addFrame.setVisible(true);
		addFrame.pack();
	}

	public void comfirmFrame(String comfirmTitle, String comfirmMessage) {
		bekæftFjernelseFrame = new JFrame(comfirmTitle);
		bekæftFjernelseFrame.setMinimumSize(new Dimension(385, 150));
		JPanel bekæftFjernelsePanel = new JPanel();
		bekæftFjernelsePanel.setBackground(new Color(250, 250, 250));
		bekæftFjernelsePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
				null, null, null, null));
		bekæftFjernelsePanel.setBounds(10, 10,
				bekæftFjernelseFrame.getWidth() - 35,
				bekæftFjernelseFrame.getHeight() - 40);
		bekæftFjernelseFrame.add(bekæftFjernelsePanel);
		JLabel bFLabel = new JLabel(comfirmMessage);
		bFLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bFLabel.setBounds(bekæftFjernelseFrame.getWidth() / 2,
				(bekæftFjernelseFrame.getHeight() - 40) / 2, 200, 20);
		bekæftFjernelsePanel.add(bFLabel);

		bekæftFjernelseButton = new JButton("Ja");
		bekæftFjernelseButton.setBounds(
				(bekæftFjernelseFrame.getWidth() - 40) / 2, 200, 60, 20);
		bekæftFjernelsePanel.add(bekæftFjernelseButton);

		nejButton = new JButton("Nej");
		nejButton.setBounds((bekæftFjernelseFrame.getWidth() + 40) / 2, 200,
				60, 20);
		bekæftFjernelsePanel.add(nejButton);

		bekæftFjernelseFrame.getContentPane().setLayout(null);
		bekæftFjernelseFrame.setLocationRelativeTo(null);
		bekæftFjernelseFrame.setVisible(true);
		bekæftFjernelseFrame.pack();
	}

	public void dbError() {
		bekæftFjernelseFrame = new JFrame("Error: Database ikke fundet");
		bekæftFjernelseFrame.setMinimumSize(new Dimension(385, 150));
		JPanel bekæftFjernelsePanel = new JPanel();
		bekæftFjernelsePanel.setBackground(new Color(250, 250, 250));
		bekæftFjernelsePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
				null, null, null, null));
		bekæftFjernelsePanel.setBounds(10, 10,
				bekæftFjernelseFrame.getWidth() - 35,
				bekæftFjernelseFrame.getHeight() - 40);
		bekæftFjernelseFrame.add(bekæftFjernelsePanel);
		JLabel bFLabel = new JLabel(
				"Database blev ikke fundet. Opret ny eller genskab fra backup");
		bFLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bFLabel.setBounds(bekæftFjernelseFrame.getWidth() / 2,
				(bekæftFjernelseFrame.getHeight() - 40) / 2, 200, 20);
		bekæftFjernelsePanel.add(bFLabel);

		bekæftFjernelseButton = new JButton("Opret ny");
		bekæftFjernelseButton.setBounds(
				(bekæftFjernelseFrame.getWidth() - 40) / 2, 200, 60, 20);
		bekæftFjernelsePanel.add(bekæftFjernelseButton);

		nejButton = new JButton("Genskab fra backup");
		nejButton.setBounds((bekæftFjernelseFrame.getWidth() + 40) / 2, 200,
				60, 20);
		bekæftFjernelsePanel.add(nejButton);

		bekæftFjernelseFrame.getContentPane().setLayout(null);
		bekæftFjernelseFrame.setLocationRelativeTo(null);
		bekæftFjernelseFrame.setVisible(true);
		bekæftFjernelseFrame.pack();
	}

	public void exceptionFrame(String comfirmTitle, String comfirmMessage) {
		bekæftFjernelseFrame = new JFrame(comfirmTitle);
		bekæftFjernelseFrame.setMinimumSize(new Dimension(1500, 500));
		JPanel bekæftFjernelsePanel = new JPanel();
		bekæftFjernelsePanel.setBackground(new Color(250, 250, 250));
		bekæftFjernelsePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
				null, null, null, null));
		bekæftFjernelsePanel.setBounds(10, 10,
				bekæftFjernelseFrame.getWidth() - 35,
				bekæftFjernelseFrame.getHeight() - 40);
		bekæftFjernelseFrame.add(bekæftFjernelsePanel);
		JLabel bFLabel = new JLabel(comfirmMessage);
		bFLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bFLabel.setBounds(bekæftFjernelseFrame.getWidth() / 2,
				(bekæftFjernelseFrame.getHeight() - 40) / 2, 200, 20);
		bekæftFjernelsePanel.add(bFLabel);

		bekæftFjernelseButton = new JButton("Ja");
		bekæftFjernelseButton.setBounds(
				(bekæftFjernelseFrame.getWidth() - 40) / 2, 200, 60, 20);
		bekæftFjernelsePanel.add(bekæftFjernelseButton);

		nejButton = new JButton("Nej");
		nejButton.setBounds((bekæftFjernelseFrame.getWidth() + 40) / 2, 200,
				60, 20);
		bekæftFjernelsePanel.add(nejButton);

		bekæftFjernelseFrame.getContentPane().setLayout(null);
		bekæftFjernelseFrame.setLocationRelativeTo(null);
		bekæftFjernelseFrame.setVisible(true);
		bekæftFjernelseFrame.pack();
	}

	public void settingsGUI(String defaultLoc, String fileLoc,
			float fWriteLocX, float fWriteLocY) {
		frameE = new JFrame("Settings");
		frameE.setMinimumSize(new Dimension(585, 360));
		panelSettings = new JPanel();
		panelSettings.setBackground(new Color(250, 250, 250));
		panelSettings.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		panelSettings.setBounds(0, 0, frameE.getWidth(), frameE.getHeight());
		frameE.getContentPane().add(panelSettings);
		panelSettings.setLayout(null);

		JLabel labelDefault = new JLabel("Mappe placering: ");
		labelDefault.setBounds(15, 30, 100, 20);
		panelSettings.add(labelDefault);

		defaultLocField = new JTextField("");
		defaultLocField.setBounds(130, 30, 250, 20);
		panelSettings.add(defaultLocField);

		JLabel label1 = new JLabel("File placering: ");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(15, 70, 100, 20);
		panelSettings.add(label1);

		fileLocField = new JTextField("");
		fileLocField.setBounds(130, 70, 250, 20);
		fileLocField
				.setToolTipText("Hvis man ikke vil skrive til fil, efterlads dette fældt tomt");
		panelSettings.add(fileLocField);

		defaultLocButton = new JButton("Find mappe");
		defaultLocButton.setBounds(400, 30, 100, 20);
		panelSettings.add(defaultLocButton);

		getFileButton = new JButton("Find file");
		getFileButton.setBounds(400, 70, 100, 20);
		panelSettings.add(getFileButton);

		JLabel labelP = new JLabel("Print placering:");
		labelP.setBounds(15, 110, 100, 20);
		panelSettings.add(labelP);

		JLabel labelX = new JLabel("X:");
		labelX.setBounds(130, 110, 20, 20);
		panelSettings.add(labelX);

		writeLocX = new JTextField();
		writeLocX.setBounds(160, 110, 100, 20);
		writeLocX.setToolTipText("0,0 er i bunden af dokumentet");
		panelSettings.add(writeLocX);

		JLabel labelY = new JLabel("Y:");
		labelY.setBounds(130, 150, 20, 20);
		panelSettings.add(labelY);

		writeLocY = new JTextField();
		writeLocY.setBounds(160, 150, 100, 20);
		writeLocY.setToolTipText("0,0 er i bunden af dokumentet");
		panelSettings.add(writeLocY);

		pdfPreviewButton = new JButton("Se udskrift");
		pdfPreviewButton.setBounds(400, 150, 100, 20);
		panelSettings.add(pdfPreviewButton);

		saveSettingsButton = new JButton("Gem Indstillinger");
		saveSettingsButton.setBounds(15, 190, 145, 20);
		panelSettings.add(saveSettingsButton);

		cancelSettingButton = new JButton("Annuller");
		cancelSettingButton.setBounds(180, 190, 145, 20);
		panelSettings.add(cancelSettingButton);

		defaultSettingButton = new JButton("Start Indstillering");
		defaultSettingButton.setBounds(345, 190, 145, 20);
		panelSettings.add(defaultSettingButton);

		if (defaultLoc == null) {
			fileLocField.setText("");
			writeLocX.setText("0.0");
			writeLocY.setText("0.0");
			defaultLocField.setText("");
		} else {
			fileLocField.setText(fileLoc);
			writeLocX.setText(fWriteLocX + "");
			writeLocY.setText(fWriteLocY + "");
			defaultLocField.setText(defaultLoc + "");
		}
		frameE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameE.getContentPane().setLayout(null);
		frameE.setLocationRelativeTo(null);
		frameE.setVisible(true);
		frameE.pack();
	}

	public JFrame getBekæftFjernelseFrame() {
		return bekæftFjernelseFrame;
	}

	public void setBekæftFjernelseFrame(JFrame bekæftFjernelseFrame) {
		this.bekæftFjernelseFrame = bekæftFjernelseFrame;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getFrameE() {
		return frameE;
	}

	public void setFrameE(JFrame frameE) {
		this.frameE = frameE;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanelSettings() {
		return panelSettings;
	}

	public void setPanelSettings(JPanel panelSettings) {
		this.panelSettings = panelSettings;
	}

	public JButton getNyKode() {
		return nyKode;
	}

	public void setNyKode(JButton nyKode) {
		this.nyKode = nyKode;
	}

	public JButton getGemKode() {
		return gemKode;
	}

	public void setGemKode(JButton gemKode) {
		this.gemKode = gemKode;
	}

	public JButton getfSButton() {
		return fSButton;
	}

	public void setfSButton(JButton fSButton) {
		this.fSButton = fSButton;
	}

	public JButton getFjernSystemButton() {
		return fjernSystemButton;
	}

	public void setFjernSystemButton(JButton fjernSystemButton) {
		this.fjernSystemButton = fjernSystemButton;
	}

	public JButton getErsatPinButton() {
		return ersatPinButton;
	}

	public void setErsatPinButton(JButton ersatPinButton) {
		this.ersatPinButton = ersatPinButton;
	}

	public JButton getBekæftFjernelseButton() {
		return bekæftFjernelseButton;
	}

	public void setBekæftFjernelseButton(JButton bekæftFjernelseButton) {
		this.bekæftFjernelseButton = bekæftFjernelseButton;
	}

	public JButton getNejButton() {
		return nejButton;
	}

	public void setNejButton(JButton nejButton) {
		this.nejButton = nejButton;
	}

	public JButton getPdfPreviewButton() {
		return pdfPreviewButton;
	}

	public void setPdfPreviewButton(JButton pdfPreviewButton) {
		this.pdfPreviewButton = pdfPreviewButton;
	}

	public JButton getGetFileButton() {
		return getFileButton;
	}

	public void setGetFileButton(JButton getFileButton) {
		this.getFileButton = getFileButton;
	}

	public JButton getSaveSettingsButton() {
		return saveSettingsButton;
	}

	public void setSaveSettingsButton(JButton saveSettingsButton) {
		this.saveSettingsButton = saveSettingsButton;
	}

	public JButton getCancelSettingButton() {
		return cancelSettingButton;
	}

	public void setCancelSettingButton(JButton cancelSettingButton) {
		this.cancelSettingButton = cancelSettingButton;
	}

	public JButton getDefaultSettingButton() {
		return defaultSettingButton;
	}

	public void setDefaultSettingButton(JButton defaultSettingButton) {
		this.defaultSettingButton = defaultSettingButton;
	}

	public JButton getDefaultLocButton() {
		return defaultLocButton;
	}

	public void setDefaultLocButton(JButton defaultLocButton) {
		this.defaultLocButton = defaultLocButton;
	}

	public JTextField getKodeFelt() {
		return kodeFelt;
	}

	public void setKodeFelt(JTextField kodeFelt) {
		this.kodeFelt = kodeFelt;
	}

	public JTextField getSystemNummer() {
		return systemNummer;
	}

	public void setSystemNummer(JTextField systemNummer) {
		this.systemNummer = systemNummer;
	}

	public JTextField getfSTextField() {
		return fSTextField;
	}

	public void setfSTextField(JTextField fSTextField) {
		this.fSTextField = fSTextField;
	}

	public JTextField getFjernSystemField() {
		return fjernSystemField;
	}

	public void setFjernSystemField(JTextField fjernSystemField) {
		this.fjernSystemField = fjernSystemField;
	}

	public JTextField getErsatPinField() {
		return ersatPinField;
	}

	public void setErsatPinField(JTextField ersatPinField) {
		this.ersatPinField = ersatPinField;
	}

	public JTextField getFileLocField() {
		return fileLocField;
	}

	public void setFileLocField(JTextField fileLocField) {
		this.fileLocField = fileLocField;
	}

	public JTextField getWriteLocX() {
		return writeLocX;
	}

	public void setWriteLocX(JTextField writeLocX) {
		this.writeLocX = writeLocX;
	}

	public JTextField getWriteLocY() {
		return writeLocY;
	}

	public void setWriteLocY(JTextField writeLocY) {
		this.writeLocY = writeLocY;
	}

	public JTextField getDefaultLocField() {
		return defaultLocField;
	}

	public void setDefaultLocField(JTextField defaultLocField) {
		this.defaultLocField = defaultLocField;
	}

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}

	public JMenu getmFile() {
		return mFile;
	}

	public void setmFile(JMenu mFile) {
		this.mFile = mFile;
	}

	public JMenu getmHelp() {
		return mHelp;
	}

	public void setmHelp(JMenu mHelp) {
		this.mHelp = mHelp;
	}

	public JMenuItem getmExit() {
		return mExit;
	}

	public void setmExit(JMenuItem mExit) {
		this.mExit = mExit;
	}

	public JMenuItem getmSettings() {
		return mSettings;
	}

	public void setmSettings(JMenuItem mSettings) {
		this.mSettings = mSettings;
	}

	public JMenuItem getmPrintPreview() {
		return mPrintPreview;
	}

	public void setmPrintPreview(JMenuItem mPrintPreview) {
		this.mPrintPreview = mPrintPreview;
	}

	public JMenuItem getEncryptDB() {
		return encryptDB;
	}

	public void setEncryptDB(JMenuItem encryptDB) {
		this.encryptDB = encryptDB;
	}

	public JMenuItem getmRestoDB() {
		return mRestoDB;
	}

	public void setmRestoDB(JMenuItem mRestoDB) {
		this.mRestoDB = mRestoDB;
	}

}
