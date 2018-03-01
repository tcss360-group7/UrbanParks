package ui_park_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Observable;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import model.Job;
import ui.ButtonSignal;
import ui.GUI;

public class ParkManagerUnsubmitConfirmationPanel extends Observable {
	
	private JPanel myPanel;
	private Job myJob;
	private List<Job> myJobs;
	
	public ParkManagerUnsubmitConfirmationPanel(final Job theJob, 
			final List<Job> theParkManagerJobList) {
		myPanel = new JPanel(new BorderLayout());
		myJobs = theParkManagerJobList;
		myJob = theJob;
		setUp();
	}
	
	private void setUp() {
		myPanel.setPreferredSize(GUI.PANEL_SIZE);
		myPanel.setBackground(Color.WHITE);
		createButtons();
		createUnubmitConfirmation();
	}
	
	private void createButtons() {
		JPanel buttonPanel = new JPanel(
				new FlowLayout(FlowLayout.CENTER, GUI.BUTTON_GAP_WIDTH, GUI.BUTTON_GAP_HEIGHT));
		JButton homeButton = new JButton(new AbstractAction("Home") {

			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged();
				notifyObservers(new ButtonSignal("home", 0));
			}
		});
		homeButton.setPreferredSize(GUI.BUTTON_SIZE);
		buttonPanel.add(homeButton);
		buttonPanel.setBackground(GUI.VOLUNTEER_PANELS_BGCOLOR);
		myPanel.add(buttonPanel, BorderLayout.SOUTH);
	}

	private void createUnubmitConfirmation() {
		
		JPanel jobConfirmationDetails = new JPanel(new GridLayout(0, 1));
		jobConfirmationDetails.setBackground(Color.WHITE);
		
				JLabel confirmationLabel = new JLabel(
				" You have successfully removed the following job:");
		confirmationLabel.setFont(new Font(null, Font.BOLD, 30));
		jobConfirmationDetails.add(confirmationLabel);
		
		String detail = "      " + myJob.getJobSummary();
		JLabel jobDetailSummary = new JLabel(detail, JLabel.LEFT);
		jobDetailSummary.setFont(new Font(null, Font.PLAIN, 15));
		jobDetailSummary.setPreferredSize(GUI.JLABEL_LONG_TEXT);
		jobConfirmationDetails.add(jobDetailSummary);

		JPanel jobScrollPanel = new JPanel(new GridLayout(0, 1));
		jobScrollPanel.setBackground(Color.WHITE);
		
		for (Job job: myJobs) {
			detail = "  " + job.getJobSummary();
			
			JLabel jobLabel = new JLabel(detail, JLabel.LEFT);
			jobLabel.setFont(new Font(null, Font.PLAIN, 15));
			jobLabel.setPreferredSize(GUI.JLABEL_LONG_TEXT);
			jobScrollPanel.add(jobLabel);
		}

		Border lower = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		
		JScrollPane jobScrollPane = new JScrollPane(jobScrollPanel);
		jobScrollPane.setBackground(Color.WHITE);
		jobScrollPane.setBorder(BorderFactory.createTitledBorder(
				lower, "Here are your upcoming jobs: "));

		JPanel eastPanel = new JPanel(new BorderLayout());
		eastPanel.add(jobConfirmationDetails, BorderLayout.CENTER);
		eastPanel.add(jobScrollPane, BorderLayout.SOUTH);
		eastPanel.setBackground(Color.WHITE);

		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.add(eastPanel, BorderLayout.NORTH);
		northPanel.setBackground(Color.WHITE);

		myPanel.add(northPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public JPanel getPanel() {
		return myPanel;
	}
}