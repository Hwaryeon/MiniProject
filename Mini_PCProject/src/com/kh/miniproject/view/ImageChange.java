package com.kh.miniproject.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageChange extends Thread{

	private JLabel label;
	private int pageNum;


	public ImageChange(JLabel label, int pageNum) {

		this.label = label;
		this.pageNum = pageNum;

	}

	@Override
	public void run() {

		int sw = 0;

		Image capImage;

		while(true){

			if(pageNum == 4){		// 좌석 사용화면
				try {
					Thread.sleep(1500);		//	1.5초
					if(sw == 0){
						//gif 파일
						capImage = new ImageIcon("icon/hos.gif").getImage().getScaledInstance(350, 400, 0);
						sw = 1;
					}else if(sw == 1){
						//png 파일
						capImage = new ImageIcon("icon/iPhone.png").getImage().getScaledInstance(350, 400, 0);
						sw = 2;
					}else{
						//png 파일
						capImage = new ImageIcon("icon/capture.PNG").getImage().getScaledInstance(350, 400, 0);
						sw = 0;
					}
					
					label.setIcon(new ImageIcon(capImage));

					if(sw == 1){
						Thread.sleep(1500);
					}
				} catch (InterruptedException e){
					System.out.println("사진변경 스레드 종료...");
					return;

				}
			}else if(pageNum == 3){		// 회원 가입일때
				try {
					Thread.sleep(2000);		//	2초
					if(sw == 0){
						//gif 파일
						capImage = new ImageIcon("icon/tropicana.gif").getImage().getScaledInstance(450, 400, 0);
						sw = 1;
					}else{
						//png 파일
						capImage = new ImageIcon("icon/project-1.PNG").getImage().getScaledInstance(450, 400, 0);
						sw = 0;
					}
					label.setIcon(new ImageIcon(capImage));
					if(sw == 1){
						Thread.sleep(5000);	
					}
				} catch (InterruptedException e){
					System.out.println("사진변경 스레드 종료...");

					return;
				}
			}else if(pageNum == 1){		// 결제화면
				try {
					Thread.sleep(2000);		//	3초
					if(sw == 0){
						//gif 파일
						capImage = new ImageIcon("icon/movie2.gif").getImage().getScaledInstance(380, 420, 0);
						sw = 1;
					}else if(sw == 1){
						//gif 파일
						capImage = new ImageIcon("icon/movie3.gif").getImage().getScaledInstance(380, 420, 0);
						sw = 2;
					}else{
						capImage = new ImageIcon("icon/movie1.gif").getImage().getScaledInstance(380, 420, 0);
						sw = 0;
					}
					
					label.setIcon(new ImageIcon(capImage));
					
					if(sw == 1){
						Thread.sleep(8000);	
					}
				} catch (InterruptedException e){
					System.out.println("사진변경 스레드 종료...");

					return;
				}
				
			}
		}
	}
}
