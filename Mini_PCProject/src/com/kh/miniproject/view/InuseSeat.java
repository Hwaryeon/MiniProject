package com.kh.miniproject.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.kh.miniproject.member.vo.Member;

public class InuseSeat extends JPanel 
{
	private MainFrame mf;

	public InuseSeat(MainFrame mf, Member m, int seatNo) 
	{
		this.mf = mf;
		this.setSize(mf.getWidth(), mf.getHeight());
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		//�ڷΰ��� ��ư
		JButton goback = new JButton();
		Image back = new ImageIcon("icon/pointer.png").getImage().getScaledInstance(100, 100, 0);
		goback.setIcon(new ImageIcon(back));
		goback.setBounds(25, 25, 100, 100);
		goback.setBorderPainted(false);
		goback.setBackground(null);
		goback.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
						{
							StartPanel start = new StartPanel(mf);
							changePanel(start);
						}
				});
		this.add(goback);
		
		//��� ���� �г� //�г� �� �󺧷� ����
		JPanel title = new JPanel();
		title.setLayout(null);
		title.setLocation(300, 50);
		title.setBackground(Color.WHITE);
		title.setSize(600,100);
		//�г� �� ���� ��
		JLabel text = new JLabel("������� �¼�");
		text.setSize(600, 50);
		text.setLocation(5, 25);
		text.setBackground(Color.GREEN);
		text.setFont(new Font("���� ���", Font.BOLD, 40));
		text.setHorizontalAlignment(JTextField.CENTER);
		title.add(text);
		this.add(title);

		// �޴��г�
		JPanel menu = new JPanel();
		menu.setBackground(Color.LIGHT_GRAY);
		menu.setLayout(null);
		menu.setBounds(75, 200, 400, 525);
		JLabel menul = new JLabel("�޴�");
		menul.setFont(new Font("�������", Font.BOLD, 40));
		menul.setForeground(Color.BLACK);
		menul.setHorizontalAlignment(JLabel.CENTER);
		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);
		menul.setBorder(eborder);
		menul.setBounds(0, 0, 400, 100);
		menu.add(menul);

		// �������г�
		JPanel iconp = new JPanel();
		iconp.setLayout(null);
		iconp.setBounds(0, 110, 400, 425);
		iconp.setBackground(Color.LIGHT_GRAY);
		Font font = new Font("�������", Font.BOLD, 18);
		// �ð��߰� ��ư
		JButton timePlus = new JButton();
		Image clock = new ImageIcon("icon/addSeat.PNG").getImage().getScaledInstance(150, 150, 0);
		timePlus.setIcon(new ImageIcon(clock));
		timePlus.setBackground(null);
		timePlus.setBounds(120, 110, 150, 150);
		timePlus.setBorderPainted(false);
		timePlus.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						AddTimePanel atp = new AddTimePanel(mf);
						changePanel(atp);
					}
				});
		JLabel timePlusL = new JLabel("�ð��߰�");
		timePlusL.setFont(font);
		timePlusL.setHorizontalAlignment(JLabel.CENTER);
		timePlusL.setBounds(120, 260, 150, 25);
		
		/*JLabel seatPlusL = new JLabel("�¼��߰�");
		seatPlusL.setFont(font);
		seatPlusL.setHorizontalAlignment(JLabel.CENTER);
		seatPlusL.setBounds(120, 260, 150, 25);*/
		

		iconp.add(timePlus);
		iconp.add(timePlusL);
		

		// �¼��г�
		JPanel seatP = new JPanel();
		seatP.setLayout(null);
		seatP.setBounds(500, 200, 650, 525);
		seatP.setBackground(Color.LIGHT_GRAY);
		JLabel seatTitle = new JLabel("�¼�");
		seatTitle.setFont(new Font("�������", Font.BOLD, 40));
		seatTitle.setHorizontalAlignment(JLabel.CENTER);
		seatTitle.setBorder(eborder);
		seatTitle.setBounds(0, 0, 650, 100);
		seatP.add(seatTitle);
		
		JTextField seatNoLabel = new JTextField(seatNo+"");
		seatNoLabel.setHorizontalAlignment(JLabel.CENTER);
		seatNoLabel.setBounds(25,120,100,100);
		seatNoLabel.setBackground(Color.BLACK);
		seatNoLabel.setForeground(Color.WHITE);
		seatNoLabel.setFont(new Font("�������", Font.BOLD, 40));
		seatP.add(seatNoLabel);
		//������� �¼� �����г�
		JPanel seatInUse = new JPanel();
		seatInUse.setLayout(null);
		seatInUse.setBackground(Color.LIGHT_GRAY);
		seatInUse.setBounds(15, 180, 620, 330);
		seatP.add(seatInUse);
		//���̵� ���
		JTextField useIDL = new JTextField("���̵�");
		useIDL.setBounds(10, 50, 150, 50);
		useIDL.setFont(new Font("�������", Font.BOLD, 30));
		useIDL.setBackground(Color.BLACK);
		useIDL.setForeground(Color.WHITE);
		useIDL.setEditable(false);
		seatInUse.add(useIDL);
		JTextField useIDT = new JTextField(m.getId());
		useIDT.setBounds(170, 50, 150, 50);
		useIDT.setFont(new Font("�������", Font.BOLD, 30));
		useIDT.setBackground(Color.BLACK);
		useIDT.setForeground(Color.WHITE);
		useIDT.setEditable(false);
		seatInUse.add(useIDT);
		//�̸� ���
		JTextField useNameL = new JTextField("�̸�");
		useNameL.setBounds(10, 120, 150, 50);
		useNameL.setFont(new Font("�������", Font.BOLD, 30));
		useNameL.setBackground(Color.BLACK);
		useNameL.setForeground(Color.WHITE);
		useNameL.setEditable(false);
		seatInUse.add(useNameL);
		JTextField useNameT = new JTextField(m.getName());
		useNameT.setBounds(170, 120, 150, 50);
		useNameT.setFont(new Font("�������", Font.BOLD, 30));
		useNameT.setBackground(Color.BLACK);
		useNameT.setForeground(Color.WHITE);
		useNameT.setEditable(false);
		seatInUse.add(useNameT);
		//�ܿ��ð� ���
		JTextField useRestTimeL = new JTextField("�ܿ��ð�");
		useRestTimeL.setBounds(10, 190, 150, 50);
		useRestTimeL.setFont(new Font("�������", Font.BOLD, 30));
		useRestTimeL.setBackground(Color.BLACK);
		useRestTimeL.setForeground(Color.WHITE);
		useRestTimeL.setEditable(false);
		seatInUse.add(useRestTimeL);
		JTextField useRestTimeT = new JTextField(m.getRestTime()+"");
		useRestTimeT.setBounds(170, 190, 150, 50);
		useRestTimeT.setFont(new Font("�������", Font.BOLD, 30));
		useRestTimeT.setBackground(Color.BLACK);
		useRestTimeT.setForeground(Color.WHITE);
		useRestTimeT.setEditable(false);
		seatInUse.add(useRestTimeT);
		//���ð� ���
		JTextField useAccTimeL = new JTextField("���ð�");
		useAccTimeL.setBounds(10, 260, 150, 50);
		useAccTimeL.setFont(new Font("�������", Font.BOLD, 30));
		useAccTimeL.setBackground(Color.BLACK);
		useAccTimeL.setForeground(Color.WHITE);
		useAccTimeL.setEditable(false);
		seatInUse.add(useAccTimeL);
		JTextField useAccTimeT = new JTextField(m.getAccTime()+"");
		useAccTimeT.setBounds(170, 260, 150, 50);
		useAccTimeT.setFont(new Font("�������", Font.BOLD, 30));
		useAccTimeT.setBackground(Color.BLACK);
		useAccTimeT.setForeground(Color.WHITE);
		useAccTimeT.setEditable(false);
		seatInUse.add(useAccTimeT);
		
		JLabel guksuImage = new JLabel();
		Image guksu = new ImageIcon("icon/guksu.PNG").getImage().getScaledInstance(270, 350, 0);
		guksuImage.setIcon(new ImageIcon(guksu));
		guksuImage.setBounds(340, 0, 270, 350);
			
		seatInUse.add(guksuImage);
		/*JLabel seatUse = new JLabel("Empty");
		seatUse.setHorizontalAlignment(JLabel.CENTER);
		seatUse.setBounds(225, 200, 200, 200);
		seatUse.setFont(new Font("�������", Font.BOLD, 44));
		seatP.add(seatUse);*/
		
		
		menu.add(iconp);

		this.add(menu);
		this.add(seatP);

		mf.add(this);

	}
	
	
	


	public void changePanel(JPanel panel)
	{
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
