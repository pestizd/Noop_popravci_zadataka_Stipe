package view;
//Package imports
import model.Player;
//Java imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//Klasa za viewframe
public class TxtPanel extends JFrame{
	//Varijable
    private JTextPane readPanel;
    private JScrollPane scPanel;
    //Varijable botuna
    private JButton p;
    private JButton f;
    private JButton l;
    private JButton n;
    //Lista
    private List<Player> players;
    private static Integer location;
    private static int stop;

    //Konstruktor
    public TxtPanel() {
        super("Read panel");
        setSize(1000, 620);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        initAll();
        layoutAll();
        startup();
    }
    //Metoda kad se pokrene
    private void startup() {
    	//Prvi
        f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetView();
                //Sada if statement
                if(players != null && !players.isEmpty()){
                    location = 0;
                    readPanel.setText(players.get(0).toString());
                }
            }
        });
        //Zadnji
        l.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetView();
                //-----
                if(players != null && !players.isEmpty()){
                    int last = players.size() - 1;
                    location = last;
                    readPanel.setText(players.get(last).toString());
                }
            }
        });
        //Prosli
        p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	//-----
                if(players != null && !players.isEmpty()){
                    if(location != null){
                        if(location -1 >= 0) {
                            resetView();
                            readPanel.setText(players.get(location - 1).toString());
                            location -= 1;
                        }
                    } else {
                        resetView();
                        readPanel.setText(players.get(0).toString());
                    }
                }
            }
        });
        //Sljedeci
        n.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	//-----
                if(players != null && !players.isEmpty()){
                    if(location != null){
                        if(location + 1 <= stop) {
                            resetView();
                            readPanel.setText(players.get(location + 1).toString());
                            location += 1;
                        }
                    } else {
                        resetView();
                        readPanel.setText(players.get(0).toString());
                    }
                }
            }
        });


    }
    //Inicijalizacija komponenata
    private void initAll() {
		readPanel = new JTextPane();
		//readPanel.setWrapStyleWord(true);
		readPanel.setAutoscrolls(true);
		//readPanel.setLineWrap(true);
		readPanel.setEditable(true);
		readPanel.setToolTipText("(Data from the server)");
		Color bckgrnd = new Color(205, 209, 254);
		readPanel.setBackground(bckgrnd);
        scPanel = new JScrollPane(readPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Color letters = new Color(252, 114, 121);
        //p
        p = new JButton("PREVIOUS");
        p.setBackground(Color.DARK_GRAY);
    	p.setForeground(Color.WHITE);
    	p.setToolTipText("Previous participant");
    	//f
        f = new JButton("FIRST");
        f.setBackground(Color.GRAY);
        f.setForeground(Color.WHITE);
    	f.setToolTipText("First participant");
    	//l
        l = new JButton("LAST");
        l.setBackground(Color.GRAY);
    	l.setForeground(Color.WHITE);
    	l.setToolTipText("Last participant");
    	//n
        n = new JButton("NEXT");
        n.setBackground(Color.DARK_GRAY);
    	n.setForeground(Color.WHITE);
    	n.setToolTipText("Next participant");
    }
    //Namjestanje layouta
    private void layoutAll() {
        getRootPane().setBorder(BorderFactory.createEmptyBorder(40, 20, 5, 20));
        setLayout(new BorderLayout());
        add(scPanel, BorderLayout.CENTER);

        JPanel panelWithButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelWithButtons.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        add(panelWithButtons, BorderLayout.PAGE_END);
        //Dodajemo botune na panel
        panelWithButtons.add(p);
        panelWithButtons.add(f);
        panelWithButtons.add(l);
        panelWithButtons.add(n);
    }

    //Da izlista sve igrace
    public void showAllPlayers(List<Player> players) {
        this.players = players;
        stop = players.size() -1;
        players.forEach( (plr) -> readPanel.setText( readPanel.getText() + plr.toString() + "\n\n"));
    }
    //Ocisti view
    public void resetView() {
    	//Pri ciscenju ce nam trebati fokus na taj frame da se vidi instantno da je ociscen
        readPanel.setText("");
    }

}