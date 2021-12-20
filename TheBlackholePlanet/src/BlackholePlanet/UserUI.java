package BlackholePlanet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JLabel;
import java.awt.Canvas;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.Clock;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;

public class UserUI extends JFrame {

	private JPanel contentPane,panel,paneMain,panelStart;
	private JTextArea txtIntro, lblAlertDisplay, statusDisplay;
	private JButton buttonLeft,buttonDown, buttonUp, buttonRight,buttonDownLeft, buttonDownRight, buttonUpLeft, buttonUpRight,btnStart;
	private JLabel lblYourCoordinates,lblXCord,lblYCord,lblXforCord, lblYforCord, lblFindYourHome,lblStatus,lblAlert,lblTimer ,lblLiveTimer,labelBackgroundImg, stepCountDisplay;
	private int secondsElapsed=0;
	private JButton btnGG;
	
	/**
	 * User interface class, where all panels, text areas, buttons and labels are represented and edited. Click actions are also implemented here.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI frame = new UserUI();
					frame.setVisible(true); //This is the parent panel, where both other panels are included.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public UserUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				secondsElapsed++;
				LocalTime time = LocalTime.ofSecondOfDay(secondsElapsed); //imported library for measuring time of gameplay until user reaches to homeplanet.
				lblLiveTimer.setText(time.toString());
			}
		};
		
		Timer timer = new Timer(1000,actionListener);
		
		paneMain = new JPanel(); //starting panel, will be visible when application initiates.
		paneMain.setBounds(0, 0, 832, 441);
		contentPane.add(paneMain);
		paneMain.setLayout(null); 
		
		panel = new JPanel(); //game panel, will be visible after user has pressed to start the game.
		panel.setBounds(0, 0, 832, 441);
		paneMain.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		buttonLeft = new JButton("");
		buttonLeft.addActionListener(new ActionListener() { //adding action listener for commanding when left button is clicked.
			public void actionPerformed(ActionEvent e) {
				StepItems newItem = TheGame.MovingLeft(); //moving left method called from main class "TheGame"
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount())); //refreshing the move count in UI.
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1)); //displaying new coordinates to UI 
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary()); //calling method to check if boundary is hit, then it is displayed.
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg()); //calling method for current status, displaying wheather the player is moving closer to target.
				if(newItem.getCurrentStatus().checkHasWon()) { //calling method to check if player has won. If so buttons are disabled to deny further movement in the universe.
					btnGG.setVisible(true); //displaying image button, congradulates player and gives permission to return to main panel.
					timer.stop(); //stops the timer, user can now time his tries.
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}	
			}
		});
		buttonLeft.setBackground(Color.LIGHT_GRAY);
		buttonLeft.setIcon(new ImageIcon(UserUI.class.getResource("/images/leftArrow.png")));
		buttonLeft.setBounds(10, 220, 100, 100);
		panel.add(buttonLeft);
		
		buttonDown = new JButton("");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StepItems newItem = TheGame.MovingDown();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				if(newItem.getCurrentStatus().checkHasWon()) {
					btnGG.setVisible(true);
					timer.stop();
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}
			}
		});
		buttonDown.setBackground(Color.LIGHT_GRAY);
		buttonDown.setIcon(new ImageIcon(UserUI.class.getResource("/images/downArrow.png")));
		buttonDown.setBounds(120, 331, 100, 100);
		panel.add(buttonDown);
		
		buttonRight = new JButton("");
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StepItems newItem = TheGame.MovingRight();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				if(newItem.getCurrentStatus().checkHasWon()) {
					btnGG.setVisible(true);
					timer.stop();
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}
			}
		});
		buttonRight.setBackground(Color.LIGHT_GRAY);
		buttonRight.setIcon(new ImageIcon(UserUI.class.getResource("/images/rightArrow.png")));
		buttonRight.setBounds(228, 220, 100, 100);
		panel.add(buttonRight);
		
		buttonUp = new JButton("");
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StepItems newItem = TheGame.MovingUp();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				if(newItem.getCurrentStatus().checkHasWon()) {
					btnGG.setVisible(true);
					timer.stop();
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}
			}
		});
		buttonUp.setBackground(Color.LIGHT_GRAY);
		buttonUp.setIcon(new ImageIcon(UserUI.class.getResource("/images/upArrow.png")));
		buttonUp.setBounds(120, 109, 100, 100);
		panel.add(buttonUp);
		
		buttonDownLeft = new JButton("");
		buttonDownLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StepItems newItem = TheGame.MovingDownLeft();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				if(newItem.getCurrentStatus().checkHasWon()) {
					btnGG.setVisible(true);
					timer.stop();
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}
			}
		});
		buttonDownLeft.setBackground(Color.LIGHT_GRAY);
		buttonDownLeft.setIcon(new ImageIcon(UserUI.class.getResource("/images/downLeftArrow.png")));
		buttonDownLeft.setBounds(10, 331, 100, 100);
		panel.add(buttonDownLeft);
		
		buttonUpLeft = new JButton("");
		buttonUpLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StepItems newItem = TheGame.MovingUpLeft();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				if(newItem.getCurrentStatus().checkHasWon()) {
					btnGG.setVisible(true);
					timer.stop();
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}
			}
		});
		buttonUpLeft.setBackground(Color.LIGHT_GRAY);
		buttonUpLeft.setIcon(new ImageIcon(UserUI.class.getResource("/images/upLeftArrow.png")));
		buttonUpLeft.setBounds(10, 109, 100, 100);
		panel.add(buttonUpLeft);
		
		buttonUpRight = new JButton("");
		buttonUpRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StepItems newItem = TheGame.MovingUpRight();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				if(newItem.getCurrentStatus().checkHasWon()) {
					btnGG.setVisible(true);
					timer.stop();
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}
			}
		});
		buttonUpRight.setBackground(Color.LIGHT_GRAY);
		buttonUpRight.setIcon(new ImageIcon(UserUI.class.getResource("/images/upRightArrow.png")));
		buttonUpRight.setBounds(228, 109, 100, 100);
		panel.add(buttonUpRight);
		
		buttonDownRight = new JButton("");
		buttonDownRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				StepItems newItem = TheGame.MovingDownRight();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				if(newItem.getCurrentStatus().checkHasWon()) {
					btnGG.setVisible(true);
					timer.stop();
					buttonDownRight.setEnabled(false);
					buttonDownLeft.setEnabled(false);
					buttonDown.setEnabled(false);
					buttonUp.setEnabled(false);
					buttonUpRight.setEnabled(false);
					buttonUpLeft.setEnabled(false);
					buttonRight.setEnabled(false);
					buttonLeft.setEnabled(false);
				}
			}
		});
		buttonDownRight.setBackground(Color.LIGHT_GRAY);
		buttonDownRight.setIcon(new ImageIcon(UserUI.class.getResource("/images/downRightArrow.png")));
		buttonDownRight.setBounds(230, 331, 100, 100);
		panel.add(buttonDownRight);
		
		lblYourCoordinates = new JLabel("Your coordinates:");
		lblYourCoordinates.setFont(new Font("Unispace", Font.BOLD, 15));
		lblYourCoordinates.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourCoordinates.setBounds(67, 11, 200, 20);
		panel.add(lblYourCoordinates);
		
		lblXCord = new JLabel("X");
		lblXCord.setFont(new Font("Unispace", Font.BOLD, 15));
		lblXCord.setHorizontalAlignment(SwingConstants.CENTER);
		lblXCord.setBounds(88, 39, 25, 25);
		panel.add(lblXCord);
		
		lblYCord = new JLabel("Y");
		lblYCord.setHorizontalAlignment(SwingConstants.CENTER);
		lblYCord.setFont(new Font("Unispace", Font.BOLD, 15));
		lblYCord.setBounds(223, 39, 25, 25);
		panel.add(lblYCord);
		
		lblXforCord = new JLabel("");
		lblXforCord.setToolTipText("");
		lblXforCord.setBackground(Color.GREEN);
		lblXforCord.setHorizontalAlignment(SwingConstants.CENTER);
		lblXforCord.setFont(new Font("Unispace", Font.BOLD, 15));
		lblXforCord.setBounds(120, 39, 25, 25);
		panel.add(lblXforCord);
		
		lblYforCord = new JLabel("");
		lblYforCord.setToolTipText("");
		lblYforCord.setHorizontalAlignment(SwingConstants.CENTER);
		lblYforCord.setFont(new Font("Unispace", Font.BOLD, 15));
		lblYforCord.setBackground(Color.GREEN);
		lblYforCord.setBounds(195, 39, 25, 25);
		panel.add(lblYforCord);
		
		lblFindYourHome = new JLabel("FIND YOUR HOME PLANET!");
		lblFindYourHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindYourHome.setFont(new Font("Unispace", Font.BOLD, 20));
		lblFindYourHome.setBounds(426, 16, 344, 25);
		panel.add(lblFindYourHome);
		
		lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Unispace", Font.BOLD, 15));
		lblStatus.setBounds(353, 70, 63, 14);
		panel.add(lblStatus);
		
		statusDisplay = new JTextArea("");
		statusDisplay.setWrapStyleWord(true);
		statusDisplay.setLineWrap(true);
		statusDisplay.setBackground(UIManager.getColor("Button.background"));
		statusDisplay.setEditable(false);
		statusDisplay.setToolTipText("Critical information will be displayed here!");
		statusDisplay.setFont(new Font("Unispace", Font.PLAIN, 14));
		statusDisplay.setBounds(426, 70, 406, 47);
		panel.add(statusDisplay);
		
		lblAlert = new JLabel("ALERT:");
		lblAlert.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlert.setFont(new Font("Unispace", Font.BOLD, 15));
		lblAlert.setBounds(353, 131, 63, 14);
		panel.add(lblAlert);
		
		lblAlertDisplay = new JTextArea("");
		lblAlertDisplay.setBackground(UIManager.getColor("Button.background"));
		lblAlertDisplay.setWrapStyleWord(true);
		lblAlertDisplay.setLineWrap(true);
		lblAlertDisplay.setEditable(false);
		lblAlertDisplay.setToolTipText("Alerts will be displayed here!");
		lblAlertDisplay.setFont(new Font("Unispace", Font.PLAIN, 14));
		lblAlertDisplay.setBounds(426, 128, 406, 39);
		panel.add(lblAlertDisplay);
		
		lblLiveTimer = new JLabel("00:00:00");
		lblLiveTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveTimer.setFont(new Font("Unispace", Font.BOLD, 15));
		lblLiveTimer.setBounds(745, 406, 87, 25);
		panel.add(lblLiveTimer);
		
		lblTimer = new JLabel("TIMER");
		lblTimer.setFont(new Font("Unispace", Font.BOLD, 15));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(760, 381, 55, 25);
		panel.add(lblTimer);
		
		JLabel lblStepCount = new JLabel("STEP COUNT");
		lblStepCount.setFont(new Font("Unispace", Font.BOLD, 13));
		lblStepCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblStepCount.setBounds(120, 220, 100, 14);
		panel.add(lblStepCount);
		
		stepCountDisplay = new JLabel("");
		stepCountDisplay.setFont(new Font("Unispace", Font.BOLD, 20));
		stepCountDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		stepCountDisplay.setBounds(144, 245, 46, 57);
		panel.add(stepCountDisplay);
		
		JButton btnQuit = new JButton(""); //this button lets user return to main panel at any time. The game will reset.
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panelStart.setVisible(true);
				timer.stop();
				secondsElapsed=0;
				LocalTime time = LocalTime.ofSecondOfDay(secondsElapsed);
				lblLiveTimer.setText(time.toString());	
			}
		});
		btnQuit.setIcon(new ImageIcon(UserUI.class.getResource("/images/quit.png")));
		btnQuit.setBounds(785, 11, 30, 30);
		panel.add(btnQuit);
		
		btnGG = new JButton(""); //Victory image button, displayed and available after user has won.
		btnGG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panelStart.setVisible(true);
				timer.stop();
				secondsElapsed=0;
				LocalTime time = LocalTime.ofSecondOfDay(secondsElapsed);
				lblLiveTimer.setText(time.toString());
			}
		});
		btnGG.setIcon(new ImageIcon(UserUI.class.getResource("/images/GGwp.png")));
		btnGG.setBackground(SystemColor.control);
		btnGG.setBounds(369, 178, 360, 250);
		panel.add(btnGG);
		
		panelStart = new JPanel(); //main panel where user can press start to begin.
		panelStart.setBounds(0, 0, 832, 441);
		paneMain.add(panelStart);
		panelStart.setLayout(null);
		
		btnStart = new JButton("START!");
		btnStart.addActionListener(new ActionListener() { //start button action listener, setting game panel visible, enabling buttons and starting the timer.
			public void actionPerformed(ActionEvent arg0) {
				StepItems newItem = TheGame.begin();
				lblYforCord.setText(Integer.toString(newItem.getNewY()+1));
				lblXforCord.setText(Integer.toString(newItem.getNewX()+1));
				lblAlertDisplay.setText(newItem.getHitBoundary());
				statusDisplay.setText(newItem.getCurrentStatus().getWinMsg());
				panel.setVisible(true);
				panelStart.setVisible(false);
				timer.start();
				stepCountDisplay.setText(Integer.toString(newItem.getStepCount()));
				btnGG.setVisible(false);
				
				buttonDownRight.setEnabled(true);
				buttonDownLeft.setEnabled(true);
				buttonDown.setEnabled(true);
				buttonUp.setEnabled(true);
				buttonUpRight.setEnabled(true);
				buttonUpLeft.setEnabled(true);
				buttonRight.setEnabled(true);
				buttonLeft.setEnabled(true);
			}
		});
		btnStart.setBackground(Color.GREEN);
		btnStart.setFont(new Font("Unispace", Font.BOLD, 15));
		btnStart.setBounds(289, 211, 230, 75);
		panelStart.add(btnStart);
		
		labelBackgroundImg = new JLabel("");
		labelBackgroundImg.setIcon(new ImageIcon(UserUI.class.getResource("/images/bgImage.png")));
		labelBackgroundImg.setBounds(0, 0, 832, 200);
		panelStart.add(labelBackgroundImg);
		
		txtIntro = new JTextArea();
		txtIntro.setWrapStyleWord(true);
		txtIntro.setFont(new Font("Unispace", Font.BOLD, 23));
		txtIntro.setEditable(false);
		txtIntro.setBackground(Color.LIGHT_GRAY);
		txtIntro.setLineWrap(true);
		txtIntro.setText("SPACETIME LAWS HAVE BROKEN SINCE THE TWO UNIVERSES COLLIDED. YOU ARE NOW LOOKING FOR YOUR HOMEPLANET IN THE YEAR 2077, WHERE YOUR FINDINGS SHALL OPEN A NEW PATH, BACK TO THE CORRECT FUTURE. SPACETIME DOES NOT WAIT!");
		txtIntro.setBounds(10, 297, 812, 133);
		panelStart.add(txtIntro);
	}
}
