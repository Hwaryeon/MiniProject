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

	//�̹����� ��°� ���ÿ� �̹����� ���������� �����Ѵ�.
	public void loadImage() {
		if (f == null)
			return;
		
		ImageIcon tmpIcon = new ImageIcon(f.getPath());
		if (tmpIcon.getIconWidth() > 90) {	//�������� ���� ���̰� 90pix �Ѿ�� ����
			thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(180, -1,Image.SCALE_DEFAULT));
		} else {
			thumbnail = tmpIcon;
		}
	}

	//������ ������ �ν��� loadImage() ȣ��
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

	//���������� ������ ���� ũ�������޼ҵ�
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