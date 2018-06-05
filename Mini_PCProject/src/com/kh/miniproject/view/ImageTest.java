package com.kh.miniproject.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageTest extends Thread{

	private JLabel label;
	private int pageNum;


	public ImageTest(JLabel label, int pageNum) {

		this.label = label;
		this.pageNum = pageNum;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {

		int sw = 0;
		
		Image capImage;

		while(true){

			try {
				Thread.sleep(3000);		//	3초

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

			} catch (InterruptedException e){
				System.out.println("사진변경 스레드 종료...");
				this.stop();

			}


		}


	}

}
