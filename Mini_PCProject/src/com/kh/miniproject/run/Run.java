package com.kh.miniproject.run;

import com.kh.miniproject.view.MainFrame;
import com.kh.miniproject.view.MainMenu;

import java.awt.Font;
import java.awt.GraphicsEnvironment;


public class Run {

	public static void main(String[] args) {

		
		//MainMenu mm = new MainMenu();
		//mm.mainMenu();
		
		new MainFrame();
		
		
		//폰트 종류 확인
		/*GraphicsEnvironment ge = null;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();
		for(int i=0;i<fonts.length;i++)
		{
			System.out.println(fonts[i].getFontName());
		}*/
		
		
	}

}
