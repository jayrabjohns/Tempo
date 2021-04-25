package main.gui.timer;

import main.gui.AbstractMainForm;
import main.gui.Stylesheet;
import main.gui.timer.ToggleSwitch;

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

		JLabel study = new JLabel("STUDY");
		panel.add(study);

		panel.add(Box.createHorizontalStrut(20));

		ToggleSwitch toggleSwitch = new ToggleSwitch();
		panel.add(toggleSwitch);
		this.controller.bindToggleSwitch(toggleSwitch);

		panel.add(Box.createHorizontalStrut(20));

		JLabel exercise = new JLabel("EXERCISE");
		panel.add(exercise);

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
		
		JButton editTimerButton = new JButton("Edit");
		editTimerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(editTimerButton, "primary");
		panel.add(editTimerButton);
		this.controller.bindEditTimerButton(editTimerButton);
		
		JButton removeTimerButton = new JButton("Remove");
		removeTimerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		Stylesheet.formatButton(removeTimerButton, "primary");
		panel.add(removeTimerButton);
		this.controller.bindRemoveTimerButton(removeTimerButton);
		
		return panel;
	}
}
