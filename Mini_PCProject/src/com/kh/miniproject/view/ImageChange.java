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

			if(pageNum == 4){		// �¼� ���ȭ��
				try {
					Thread.sleep(1500);		//	1.5��
					if(sw == 0){
						//gif ����
						capImage = new ImageIcon("icon/hos.gif").getImage().getScaledInstance(350, 400, 0);
						sw = 1;
					}else if(sw == 1){
						//png ����
						capImage = new ImageIcon("icon/iPhone.png").getImage().getScaledInstance(350, 400, 0);
						sw = 2;
					}else{
						//png ����
						capImage = new ImageIcon("icon/capture.PNG").getImage().getScaledInstance(350, 400, 0);
						sw = 0;
					}
					
					label.setIcon(new ImageIcon(capImage));

					if(sw == 1){
						Thread.sleep(1500);
					}
				} catch (InterruptedException e){
					System.out.println("�������� ������ ����...");
					return;

				}
			}else if(pageNum == 3){		// ȸ�� �����϶�
				try {
					Thread.sleep(2000);		//	2��
					if(sw == 0){
						//gif ����
						capImage = new ImageIcon("icon/tropicana.gif").getImage().getScaledInstance(450, 400, 0);
						sw = 1;
					}else{
						//png ����
						capImage = new ImageIcon("icon/project-1.PNG").getImage().getScaledInstance(450, 400, 0);
						sw = 0;
					}
					label.setIcon(new ImageIcon(capImage));
					if(sw == 1){
						Thread.sleep(5000);	
					}
				} catch (InterruptedException e){
					System.out.println("�������� ������ ����...");

					return;
				}
			}else if(pageNum == 1){		// ����ȭ��
				try {
					Thread.sleep(2000);		//	3��
					if(sw == 0){
						//gif ����
						capImage = new ImageIcon("icon/movie2.gif").getImage().getScaledInstance(380, 420, 0);
						sw = 1;
					}else if(sw == 1){
						//gif ����
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
					System.out.println("�������� ������ ����...");

					return;
				}
				
			}
		}
	}
}
