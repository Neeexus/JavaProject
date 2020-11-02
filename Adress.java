import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Adress extends JFrame implements ActionListener {
	private	JTextField hp,ad; // 핸드폰 번호와 주소지 입력 텍스트 필드 선언
	private JLabel label,label2; // 라벨 선언
	private JButton submit; // 주문 버튼 선언
	private BufferedWriter bw; // 텍스트 작성을 위해 선언
	private String date; // 날짜를 저장할 변수 선언
	public Adress(GUI gui){
		super("배달 프로그램"); // 타이틀 선언
		setSize(400,350); // 크기 설정
		setLocation(900,200); // 위치 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 안정적으로 종료하기위해 사용
		setLayout(null); // 레이아웃 초기화
		label=new JLabel("주소 등록"); 
		label2=new JLabel("전화번호");
		// 각 라벨 값 지정
		label.setBounds(50, 50, 200, 30);
		ad=new JTextField();
		ad.setBounds(140, 50, 200, 30);
		label2.setBounds(50, 100, 200, 30);
		hp=new JTextField();
		hp.setBounds(140, 100, 200, 30);
		submit=new JButton("배달 주문");
		submit.setBounds(150, 175, 100, 40);
		// 버튼 및 라벨들의 위치를 지정
		add(label);
		add(ad);
		add(label2);
		add(hp);
		add(submit);
		// 버튼 및 라벨 등을 추가시킨다
		submit.addActionListener(this); // 버튼을 눌렀을시 이벤트 동작을 활성화한다
	}
	public void actionPerformed(ActionEvent clicked) {
		if(clicked.getSource()==submit){ // 주문 버튼이 클릭 되었을시
			try {
				Calendar cal=Calendar.getInstance(); // 현재 시간을 불러온다
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 시간의 형식을 지정해준다
				date=sdf.format(cal.getTime()); // date 변수를 현재 시간으로 초기화 시켜준다
				String s="주문 시간 : "+date+"\n주소지 : "+ad.getText()+
						"\n전화번호 : "+hp.getText()+"\n"+"------------------------------"; //텍스트를 초기화 시켜준다
				bw=new BufferedWriter(new FileWriter("data.txt",true));
				bw.write(s);
				bw.newLine();
				bw.close();
				//data.txt에 정보를 저장시켜준다
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"주문 시간 : "+date + "\n배달 주소 : "+ad.getText()
			+"\n전화 번호 : "+hp.getText()); // 메세지 상자를 출력한다.		
			setVisible(false); // Adress gui를 안보이게 설정한다
		}
	}
}
