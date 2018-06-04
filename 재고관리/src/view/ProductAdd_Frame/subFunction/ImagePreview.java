package view.ProductAdd_Frame.subFunction;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class ImagePreview extends JComponent 
implements PropertyChangeListener {
	ImageIcon thumbnail = null;
	File f = null;

	public ImagePreview(JFileChooser fc) {
		setPreferredSize(new Dimension(200, 100));
		fc.addPropertyChangeListener(this);
	}

	//이미지를 출력과 동시에 이미지를 아이콘으로 변경한다.
	public void loadImage() {
		if (f == null)
			return;
		
		ImageIcon tmpIcon = new ImageIcon(f.getPath());
		if (tmpIcon.getIconWidth() > 90) {	//아이콘의 가로 길이가 90pix 넘어가면 조정
			thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(180, -1,Image.SCALE_DEFAULT));
		} else {
			thumbnail = tmpIcon;
		}
	}

	//선택한 파일을 인식후 loadImage() 호출
	public void propertyChange(PropertyChangeEvent e) {
		String prop = e.getPropertyName();
		if (prop == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
			f = (File) e.getNewValue();
			if(isShowing()) {
				loadImage();
				repaint();
			}
		}
	}

	//파일추저의 프리뷰 사진 크기조절메소드
	public void paint(Graphics g) {
		if (thumbnail == null) {
			loadImage();
		}
		if (thumbnail != null) {
			int x = getWidth()/2 - thumbnail.getIconWidth()/2;
			int y = getHeight()/2 - thumbnail.getIconHeight()/2;

			if (y < 0) {
				y = 0;
			}

			if (x < 5) {
				x = 5;
			}
			thumbnail.paintIcon(this, g, x, y);
		}
	}
}