import java.util.Enumeration;

import javax.swing.AbstractButton;

public class Libraries { // 사용자 함수를 정의해 놓은 클래스 (적당한 라이브러리가 없어 작성했다)
	
	static String getSelectedButton() // 선택된 버튼의 값을 반환해주는 함수
	{  
	    for (Enumeration<AbstractButton> buttons = GUI.radio.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();  //버튼 그룹에서 원소 값 수 만큼 돌린다
	            if (button.isSelected()) { 
	                return button.getText(); //버튼이 클릭되면 그 값을 반환한다
	            }
	        }
	return null;
	}
	static int getSelectedButtonIndex() { // 선택된 버튼의 인덱스 값을 반환해주는 함수 (get() 함수를 유연하게 이용하기위해 작성하였다)
		int i=0;
        for (Enumeration<AbstractButton> buttons = GUI.radio.getElements(); buttons.hasMoreElements();) {
        	
        	AbstractButton button = buttons.nextElement(); // 버튼 그룹에서 원소 값 수만큼 돌린다
           
            if (button.isSelected()) {
                return i; // 버튼이 클릭되면 해당 위치의 인덱스 값 i를 반환한다
            }	
            i++;
        }
        return -1;
    }
}

