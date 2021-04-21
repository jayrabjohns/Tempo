package main.gui.timer;

import main.gui.Stylesheet;
import main.gui.AbstractMainForm;

import javax.swing.*;
import java.awt.*;

public class TimerListForm extends AbstractMainForm
{
	private final TimerListFormController controller;
	
	public TimerListForm(TimerListFormController controller)
	{
		super(controller);
		
		this.controller = controller;
		
		getContentPane().add(this.genMain());
	}
	
	@Override
	public void setVisible(boolean b)
	{
		super.setVisible(b);
		
		controller.focusPlayButton();
	}
	
	@Override
	public JComponent genBody()
	{
		JPanel bodyPanel = new JPanel();
		bodyPanel.setAutoscrolls(true);
		
		LayoutManager bodyLayout = new BoxLayout(bodyPanel, BoxLayout.Y_AXIS);
		bodyPanel.setLayout(bodyLayout);
		bodyPanel.setBackground(Color.white);
		

		bodyPanel.add(this.IJustFlippedTheSwitch());
		bodyPanel.add(this.genTimersList());
		bodyPanel.add(Box.createVerticalStrut(40));
		bodyPanel.add(this.genButtons());
		
		return bodyPanel;
	}

	private JPanel IJustFlippedTheSwitch(){
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1000));

		LayoutManager layout = new GridLayout();
		panel.setLayout(layout);

		panel.add(Box.createHorizontalStrut(40));

		JButton switchBetweenStudyExercise = new JButton();
		switchBetweenStudyExercise.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(switchBetweenStudyExercise);

		panel.add(Box.createHorizontalStrut(40));

		return panel;
	}
	
	private JScrollPane genTimersList()
	{
		DefaultListModel<PITimer> listModel = new DefaultListModel<>();
		ListCellRenderer<PITimer> listCellRenderer = new TimerListCellRenderer();
		
		JList<PITimer> timersList = new JList<>(listModel);
		timersList.setCellRenderer(listCellRenderer);
		this.controller.bindTimersList(timersList, listModel);
		
		return new JScrollPane(timersList);
	}
	
	public JPanel genButtons()
	{
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		
		LayoutManager layout = new GridLayout();
		panel.setLayout(layout);
		
		JButton addTimerButton = new JButton("Add new");
		addTimerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(addTimerButton, "primary");
		panel.add(addTimerButton);
		this.controller.bindAddTimerButton(addTimerButton);
		
		JButton playButton = new JButton("Start");
		playButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(playButton, "primary");
		panel.add(playButton);
		this.controller.bindPlayButton(playButton);
		
		JButton editTimerButton = new JButton("Edit timer");
		editTimerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(editTimerButton, "primary");
		panel.add(editTimerButton);
		this.controller.bindEditTimerButton(editTimerButton);
		
		return panel;
	}
}
