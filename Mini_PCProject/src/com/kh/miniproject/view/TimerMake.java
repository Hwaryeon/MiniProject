package com.kh.miniproject.view;

import javax.swing.*;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.seat.dao.SeatDao;

import java.awt.*;
import java.awt.event.*;

public class TimerMake extends JFrame {
	// ���� ��ü
	private static TimerMake frame = new TimerMake();

	public static int threadNumber;
	
	private JPanel rootPanel; // ���� �г�
	private JLabel xBtn; // �ݱ� ��ư
	private JLabel timeText; // �ð� ǥ�� ��
	private JLabel start, pause, stop; // ���� ��ư��

	private TimeThread timeTh; // �ð� ������
	private long time = 0l, preTime = 0l; // �ð� ����� ���� ������

	private int moveX, moveY; // ������ �̵��� �ʱ� ��ǥ

	private Color commonColor = Color.red; // Ŭ���� �� ���ϴ� ����

	public TimerMake(){
		// ������ ����
		this.setBounds(300, 200, 300, 150);
		setLayout(new BorderLayout());
		setUndecorated(true);
		setResizable(false);
		consistComponent();
	}

	// ����ƽ �Լ��� ������ ����
	public static void visibleFrame(){
		frame.setVisible(true);
	}

	private void consistComponent(){
		// ��Ʈ �г� ����, ��� ����
		rootPanel = new JPanel(new BorderLayout());
		rootPanel.setBackground(Color.black);

		// �ð��� ǥ���ϴ� ���� �ִ� �г� ����
		Panel centerPanel = createCenterPanel();
		rootPanel.add(centerPanel, "Center");

		// �ݱ� ��ư�� �ִ� �г� ����
		Panel northPanel = createNorthPanel();
		rootPanel.add(northPanel, "North");

		// ��Ʈ �г� ����
		setContentPane(rootPanel);
	}

	private Panel createNorthPanel(){
		GridBagConstraints constraints2 = new GridBagConstraints();
		constraints2.anchor = GridBagConstraints.EAST;
		constraints2.gridx = 0; constraints2.gridy = 0;
		constraints2.weightx = 1; constraints2.weighty = 1;

		Panel barPanel= new Panel(new GridBagLayout());
		xBtn = new JLabel(" X ");
		xBtn.setForeground(Color.white);
		xBtn.setOpaque(true);
		xBtn.setBackground(Color.gray);
		xBtn.setFont(new Font("Gothic", Font.BOLD, 30));
		xBtn.addMouseListener(myMouse);

		barPanel.addMouseMotionListener(myMotion);
		barPanel.addMouseListener(myMouse);
		barPanel.add(xBtn, constraints2);

		return barPanel;
	}

	private Panel createCenterPanel(){
		GridBagLayout gridLayout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 1;
		constraints.weighty = 1;
		Panel centerPanel = new Panel(gridLayout);

		timeText = new JLabel(toTime(time));
		timeText.setForeground(Color.white);
		timeText.setFont(new Font("Gothic", Font.BOLD, 40));
		constraints.gridx = 0;
		constraints.gridy = 1;
		centerPanel.add(timeText, constraints);

		JLabel title = new JLabel("�¼� ���ð�");
		title.setForeground(Color.white);
		title.setFont(new Font("Gothic", Font.BOLD, 20));
		constraints.gridx = 0;
		constraints.gridy = 0;
		centerPanel.add(title, constraints);

		centerPanel.addMouseMotionListener(myMotion);
		centerPanel.addMouseListener(myMouse);

		return centerPanel;
	}

	private void start(){
		if(timeTh == null || !timeTh.isAlive()){
			if(time != 0) preTime = System.currentTimeMillis() - time;
			else preTime = System.currentTimeMillis();
			timeTh = new TimeThread();
			timeTh.start();
		}
	}


	private class TimeThread extends Thread{
		public void run() {
			try {
				while (!Thread.currentThread().isInterrupted()) {
					sleep(10);
					time = System.currentTimeMillis() - preTime;
					timeText.setText(toTime(time));
				}
			} catch (Exception e) {
			}
		}
	}



	private MouseMotionListener myMotion = new MouseMotionListener() {
		public void mouseDragged(MouseEvent e) {
			int mx = getX() + e.getX();
			int my = getY() + e.getY();
			setLocation(mx - moveX, my - moveY);
		}

		public void mouseMoved(MouseEvent e) {
		}
	};

	private MyMouse myMouse = new MyMouse();
	private class MyMouse implements MouseListener{
		public void mouseEntered(MouseEvent e) {
			Object o = e.getSource();

			if(o.equals(xBtn)){
				xBtn.setBackground(commonColor);
			}else if(o.equals(start)){
				start.setForeground(commonColor);
			}
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
			Object o = e.getSource();
			if(o.equals(xBtn)){
				xBtn.setBackground(Color.gray);
			}else if(o.equals(start)){
				start.setForeground(Color.white);
			}
		}

		public void mousePressed(MouseEvent e) {
			Object o = e.getSource();
			if(o.equals(xBtn)){
				//System.exit(0);
				dispose();
			}else if(o.equals(start)){
				start();
			}else{
				moveX = e.getX();
				moveY = e.getY();
			}
		}

		public void mouseReleased(MouseEvent e) {

		}
	}

	private String toTime(long time){
		// time ��  �� * 1000
		// ������ �и���������
		
		time = (SeatDao.iList[threadNumber] * 1000);
		start();
		int t = (int)(time / 1000.0 / 60.0 / 60.0);
		int m = (int)(time / 1000.0 / 60.0);
		int s = (int)(time % (1000.0 * 60) / 1000.0);
		
		return String.format("%02d : %02d : %02d",t , m, s/*, ms*/);
	}
	
	public static void main(String args[]){
		visibleFrame();
	}
}