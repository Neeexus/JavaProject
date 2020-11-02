import java.util.Enumeration;

import javax.swing.AbstractButton;

public class Libraries { // ����� �Լ��� ������ ���� Ŭ���� (������ ���̺귯���� ���� �ۼ��ߴ�)
	
	static String getSelectedButton() // ���õ� ��ư�� ���� ��ȯ���ִ� �Լ�
	{  
	    for (Enumeration<AbstractButton> buttons = GUI.radio.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();  //��ư �׷쿡�� ���� �� �� ��ŭ ������
	            if (button.isSelected()) { 
	                return button.getText(); //��ư�� Ŭ���Ǹ� �� ���� ��ȯ�Ѵ�
	            }
	        }
	return null;
	}
	static int getSelectedButtonIndex() { // ���õ� ��ư�� �ε��� ���� ��ȯ���ִ� �Լ� (get() �Լ��� �����ϰ� �̿��ϱ����� �ۼ��Ͽ���)
		int i=0;
        for (Enumeration<AbstractButton> buttons = GUI.radio.getElements(); buttons.hasMoreElements();) {
        	
        	AbstractButton button = buttons.nextElement(); // ��ư �׷쿡�� ���� �� ����ŭ ������
           
            if (button.isSelected()) {
                return i; // ��ư�� Ŭ���Ǹ� �ش� ��ġ�� �ε��� �� i�� ��ȯ�Ѵ�
            }	
            i++;
        }
        return -1;
    }
}

