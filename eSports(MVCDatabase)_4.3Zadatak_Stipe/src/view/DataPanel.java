package view;
//Java imports
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
//Swing imports
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
//Package imports
import model.ExperienceEnum;
import model.GameEnum;
import model.Player;
import model.TurnamentEnum;

public class DataPanel extends JPanel {
	//Varijable
	private JTextField nameField;
	private JTextField snameField;
	private JComboBox<GameEnum> playCombo;
	private JComboBox<TurnamentEnum> trnmtCombo;//--
	private JList<ExperienceEnum> expList;
	private JRadioButton fullTmeRadio, partTmeRadio;
	private ButtonGroup wrTimeRadios, sponsors;
	private JButton sbmtBtn;
	private JScrollPane listScroll, noticeScroll;
	private JCheckBox sponsorChck1, sponsorChck2, sponsorChck3;
	private CheckboxGroup grpChck;//-- Nek stoji za svaki slucaj
	private JTextArea txtArea;//--
	private DpListener dpl;
	private Player player;
	//Konstruktor
	public DataPanel() {

		Dimension dim = getPreferredSize();
		dim.height = 280;
		setPreferredSize(dim);
		//setBackground(Color.LIGHT_GRAY);
		setBorders2Panel();
		initAll();
		layoutComps();
		activateDataPanel();
	}	
	//Metoda za listener
	public void setDataPanelListener(DpListener lst) {
		this.dpl = lst;
	}	
	//Inicijalizacija
	private void initAll() {
		Color color = new Color(252, 114, 121);//Set up color
		Color bckgclr = new Color(205, 209, 254);
		nameField = new JTextField(10);
		nameField.setBackground(color);
		nameField.setToolTipText("Your name");
		snameField = new JTextField(10);
		snameField.setBackground(color);
		snameField.setToolTipText("Your surname");
		playCombo = new JComboBox<>();
		playCombo.setBackground(color);
		playCombo.setToolTipText("What is your speciality");
		expList = new JList<>();
		expList.setToolTipText("How experienced are you");
		trnmtCombo = new JComboBox<>();//--
		trnmtCombo.setBackground(color);
		trnmtCombo.setToolTipText("Sign up for a turnament");
		fullTmeRadio = new JRadioButton("8hours a day");
		fullTmeRadio.setToolTipText("How much can you work/practice a day");
		partTmeRadio = new JRadioButton("4hours a day");
		partTmeRadio.setToolTipText("How much can you work/practice a day");
		wrTimeRadios = new ButtonGroup();
		sponsorChck1 = new JCheckBox("Samsung");//-- Checkbox checkBox1 = new Checkbox("C++", cbg, false); <-- Primjer
		sponsorChck2 = new JCheckBox("Redbull");//--
		sponsorChck3 = new JCheckBox("AMD");//--
		sponsors = new ButtonGroup();//-- Grupa checkbox-ova
		txtArea = new JTextArea();//--
		
		/*
		 * <<<<<<<<< Combo box >>>>>>>>>>
		 */
		DefaultComboBoxModel<GameEnum> playModel = new DefaultComboBoxModel<>();
		GameEnum[] rrPlay = GameEnum.values();
		List<GameEnum> collPlay = Arrays.asList(rrPlay);
		playModel.addElement(GameEnum.SuperMario);
		playModel.addElement(GameEnum.ApexLegends);
		playModel.addElement(GameEnum.CallOfDuty);
		playModel.addElement(GameEnum.Fortnite);
		playModel.addElement(GameEnum.WoW);
		playModel.addElement(GameEnum.OverWatch);
		playModel.addElement(GameEnum.RocketLeague);
		playModel.addElement(GameEnum.Fifa20);
		playModel.addElement(GameEnum.SpaceInvaders);
		playCombo.setModel(playModel);
		playCombo.setSelectedIndex(0);
		Dimension dms = playCombo.getPreferredSize();
		dms.width = 110;
		//dms.height = 100;
		playCombo.setPreferredSize(dms);	
		/*
		 * <<<<<<<<<<<<< List >>>>>>>>>>>>>
		 */
		DefaultListModel<ExperienceEnum> exModel = new DefaultListModel<>();
		ExperienceEnum[] arExp = ExperienceEnum.values();
		List<ExperienceEnum> collExp = Arrays.asList(arExp);
		//exModel.addAll(collExp);
		exModel.addElement(ExperienceEnum.Rookie);
		exModel.addElement(ExperienceEnum.Experienced);
		exModel.addElement(ExperienceEnum.Profesional);
		exModel.addElement(ExperienceEnum.Veteran);
		expList.setModel(exModel);
		expList.setVisibleRowCount(3);
		expList.setBorder(BorderFactory.createEtchedBorder());
		Dimension dm = expList.getPreferredSize();
		dm.width = 130;
		//dm.height = 400;
		expList.setPreferredSize(dm);
		expList.setBackground(color);
		listScroll = new JScrollPane(expList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		/*
		 * <<<<<<<<< Turnament Combo box >>>>>>>>>>
		 */
		DefaultComboBoxModel<TurnamentEnum> trnmtModel = new DefaultComboBoxModel<>();
		TurnamentEnum[] rrTrnmt = TurnamentEnum.values();
		List<TurnamentEnum> collTrnmt = Arrays.asList(rrTrnmt);
		trnmtModel.addElement(TurnamentEnum.eSportsWorldConvention);
		trnmtModel.addElement(TurnamentEnum.EvolutionChampionshipSeries);
		trnmtModel.addElement(TurnamentEnum.Dreamhack);
		trnmtModel.addElement(TurnamentEnum.IntelExtremeMasters);
		trnmtCombo.setModel(trnmtModel);
		trnmtCombo.setSelectedIndex(0);
		Dimension dmst = trnmtCombo.getPreferredSize();
		dmst.width = 180;
		trnmtCombo.setPreferredSize(dmst);	
		/*
		 * <<<<<<<< Radio buttons >>>>>>>>
		 */
		fullTmeRadio.setSelected(true);
		wrTimeRadios.add(fullTmeRadio);
		wrTimeRadios.add(partTmeRadio);
		fullTmeRadio.setActionCommand("8hours a day");
		fullTmeRadio.setBackground(color);
		partTmeRadio.setActionCommand("4hours a day");
		partTmeRadio.setBackground(color);
		//Check boxes
		//sponsorChck1.setText("Samsung");//S1
		sponsorChck1.setSelected(false);
		sponsorChck1.setToolTipText("Must choose sponsor");
		sponsorChck1.setActionCommand("Samsung");
		sponsorChck1.setMnemonic('E');
		sponsorChck1.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		sponsorChck1.setBackground(color);
		sponsorChck1.setForeground(Color.DARK_GRAY);
		//sponsorChck2.setText("Redbull");//S2
		sponsorChck2.setSelected(false);
		sponsorChck2.setToolTipText("Must choose sponsor");
		sponsorChck2.setActionCommand("Redbull");
		sponsorChck2.setMnemonic('E');
		sponsorChck2.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		sponsorChck2.setBackground(color);
		sponsorChck2.setForeground(Color.DARK_GRAY);
		//sponsorChck3.setText("Samsung");//S3
		sponsorChck3.setSelected(false);
		sponsorChck3.setToolTipText("Must choose sponsor");
		sponsorChck3.setActionCommand("AMD");
		sponsorChck3.setMnemonic('E');
		sponsorChck3.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		sponsorChck3.setBackground(color);
		sponsorChck3.setForeground(Color.DARK_GRAY);
		sponsors.add(sponsorChck1);
		sponsors.add(sponsorChck2);
		sponsors.add(sponsorChck3);
		/*CBC.addActionListener(this); Probati ovo //--
		grpChck = new CheckboxGroup();
		add(sponsorChck1);
		add(sponsorChck2);
		add(sponsorChck3);*/
		
	    //Text Area
	    //txtArea.setSize(200, 300);
	    txtArea.setAutoscrolls(true);
	    txtArea.setLineWrap(true);
	    txtArea.setWrapStyleWord(true);
	    txtArea.setEditable(true);
	    txtArea.setBackground(color);
	    txtArea.setToolTipText("If you need some additional equipment and/or have accomodation wishes");
	    //txtArea.setText("(Optional)");
	    Dimension dman = txtArea.getPreferredSize();
	    dman.width = 150;
	    dman.height = 45;
		txtArea.setPreferredSize(dman);
	    noticeScroll = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    /*Dimension dm = expList.getPreferredSize();
		dm.width = 130;
		expList.setPreferredSize(dm);
		expList.setBackground(Color.CYAN);
		listScroll = new JScrollPane(expList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				*/
	    
	    //noticeScroll.getViewport().add(txtArea);
	    //noticeScroll.setDoubleBuffered(true);
	    //add(noticeScroll, "Center");

	    //JLabel message = new JLabel("Hey");
	    //add(message, "North");
		
		//Register button
		sbmtBtn = new JButton("Register");
		//sbmtBtn.setSize(30, 20);
		Dimension dmb = sbmtBtn.getPreferredSize();
		dmb.width = 110;
	    dmb.height = 40;
	    sbmtBtn.setPreferredSize(dmb);
		sbmtBtn.setBackground(bckgclr);
		sbmtBtn.setForeground(color);
		sbmtBtn.setToolTipText("(Submit your data)");
		
	}	
	//Setting up the borders
	private void setBorders2Panel() {
		Border inner = BorderFactory.createTitledBorder("<Sign up>");
		Border outter = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border brd = BorderFactory.createCompoundBorder(outter, inner);
		setBorder(brd);
	}	
	//Aktivacija
	private void activateDataPanel() {

		sbmtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				if(dpl != null) { //-- sponsors.getElements().nextElement().getText() == AMD , sponsors.getSelection().getActionCommand() == Samsung == RIJESENO!
					player = new Player(nameField.getText(), snameField.getText(), (GameEnum) playCombo.getSelectedItem(), expList.getSelectedValue(),
							(TurnamentEnum) trnmtCombo.getSelectedItem(), wrTimeRadios.getSelection().getActionCommand(),
							sponsors.getSelection().getActionCommand(), txtArea.getText());//--
					DpEvent dpe = new DpEvent(DataPanel.this, player);
					dpl.dataPanelEventOccured(dpe);
					player.description();
				}
				//Vracamo unos na pocetne postavke
				resetDataPanel();

			}
		});
	}
	
	public Player getPlayer() {
		return player;
	}
	
	private void resetDataPanel() {
		nameField.setText("");
		snameField.setText("");
		nameField.requestFocus();
		playCombo.setSelectedIndex(0); 
		expList.setSelectedIndex(0);
		trnmtCombo.setSelectedIndex(0);
		fullTmeRadio.setSelected(true);
		sponsorChck1.setSelected(false);
		sponsorChck2.setSelected(false);
		sponsorChck3.setSelected(false);
		txtArea.setText("");
	}	
	
	private void layoutComps() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Insets dfltInst = new Insets(0, 0, 0, 0);
		//1
		gbc.weightx = 0;
		gbc.weighty = 0;

		gbc.gridx = 0;
		gbc.gridy = 0;

		add(Box.createVerticalStrut(8), gbc);

		gbc.weightx = 0;
		gbc.weighty = 0.1;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Name:"), gbc);

		gbc.gridx = 1;
		gbc.insets = dfltInst;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(nameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Surname:"), gbc);

		gbc.gridx = 1;
		gbc.insets = dfltInst;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(snameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Available for practice:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		add(fullTmeRadio, gbc);
		gbc.gridy = 4;
		add(partTmeRadio, gbc);

		gbc.gridx = 3;
		Component bx = Box.createHorizontalStrut(25);
		add(bx, gbc);

		gbc.gridx = 4;
		gbc.gridy = 1;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("(Gaming in)"), gbc);

		gbc.gridy = 2;
		gbc.insets = dfltInst;
		add(playCombo, gbc);

		gbc.gridx = 5;
		Component bx2 = Box.createHorizontalStrut(25);
		add(bx2, gbc);

		gbc.gridx = 6;
		gbc.gridy = 1;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("(Gaming experience)"), gbc);

    	gbc.gridy = 2;
		gbc.insets = dfltInst;
		add(listScroll, gbc);

		//gbc.gridx = 7;
		//gbc.gridy = 4;
		//add(Box.createVerticalStrut(10), gbc);

		gbc.weighty = 0.25;
		gbc.gridx = 6;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.CENTER;
		add(sbmtBtn, gbc);
		
		gbc.gridx = 7;
		gbc.gridy = 4;
		add(Box.createHorizontalStrut(10), gbc);		
		
		gbc.gridx = 8;
		gbc.gridy = 1;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("(Choose turnament)"), gbc);
		
		gbc.gridx = 8;
		gbc.gridy = 2;
		gbc.insets = dfltInst;
		add(trnmtCombo, gbc);		
		
		gbc.gridx = 8;
		gbc.gridy = 4;
		add(Box.createHorizontalStrut(10), gbc);	
		//J
		gbc.gridx = 9;
		gbc.gridy = 3;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("(Pick sponsors)"), gbc);

		gbc.gridy = 4;
		gbc.insets = dfltInst;
		add(sponsorChck1, gbc);	
		gbc.gridy = 5;
		gbc.insets = dfltInst;
		add(sponsorChck2, gbc);	
		gbc.gridy = 6;
		gbc.insets = dfltInst;
		add(sponsorChck3, gbc);	
		
		gbc.gridx = 9;
		gbc.gridy = 1;
		add(Box.createHorizontalStrut(10), gbc);
		
		gbc.gridx = 10;
		gbc.gridy = 1;

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Special notice (Optional)"), gbc);

		gbc.gridy = 2;
		gbc.insets = dfltInst;
		add(noticeScroll, gbc);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
	
}
