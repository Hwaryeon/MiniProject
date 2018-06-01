package com.kh.miniproject.view;

import javax.swing.*;

import com.kh.miniproject.iTime.ConversionTime;
import com.kh.miniproject.seat.dao.SeatDao;

import java.awt.*;
import java.awt.event.*;

public class TimerMake extends JFrame {
	// 정적 객체
	private static TimerMake frame = new TimerMake();

	public static int threadNumber;
	
	private JPanel rootPanel; // 메인 패널
	private JLabel xBtn; // 닫기 버튼
	private JLabel timeText; // 시간 표시 라벨
	private JLabel start, pause, stop; // 동작 버튼들

	private TimeThread timeTh; // 시간 쓰레드
	private long time = 0l, preTime = 0l; // 시간 계산을 위한 변수들

	private int moveX, moveY; // 윈도우 이동시 초기 좌표

	private Color commonColor = Color.red; // 클릭할 때 변하는 색상

	public TimerMake(){
		// 프레임 설정
		this.setBounds(300, 200, 300, 150);
		setLayout(new BorderLayout());
		setUndecorated(true);
		setResizable(false);
		consistComponent();
	}

	// 스태틱 함수로 프레임 실행
	public static void visibleFrame(){
		frame.setVisible(true);
	}

	private void consistComponent(){
		// 루트 패널 생성, 배경 설정
		rootPanel = new JPanel(new BorderLayout());
		rootPanel.setBackground(Color.black);

		// 시간을 표시하는 라벨이 있는 패널 생성
		Panel centerPanel = createCenterPanel();
		rootPanel.add(centerPanel, "Center");

		// 닫기 버튼이 있는 패널 생성
		Panel northPanel = createNorthPanel();
		rootPanel.add(northPanel, "North");

		// 루트 패널 부착
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

		JLabel title = new JLabel("좌석 사용시간");
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
		// time 은  초 * 1000
		// 단위가 밀리세컨드임
		
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