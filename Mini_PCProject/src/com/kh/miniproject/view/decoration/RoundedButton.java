package com.kh.miniproject.view.decoration;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton
{
	public RoundedButton()
	{
		super();
		decorate();
	}
	
	public RoundedButton(String text)
	{
		super(text);
		decorate();
	}
	
	public RoundedButton(Action action)
	{
		super(action);
		decorate();
	}
	
	public RoundedButton(Icon icon)
	{
		super(icon);
		decorate();
	}
	
	public RoundedButton(String text, Icon icon)
	{
		super(text, icon);
		decorate();
	}
	
	protected void decorate()
	{
		setBorderPainted(false);
	}
}
