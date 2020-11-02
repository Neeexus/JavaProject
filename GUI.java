import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class GUI extends JFrame implements ActionListener {
	
	private JRadioButton size, size_mid, size_large; // 피자의 사이즈를 선택하는 버튼
	private JCheckBox garlic, chili, cheese, bacon, none; // 피자의 토핑을 선택하는 체크박스
	private JButton submit,delivery, adresslist, deldata; // 주문, 배달, 배달 주소, 배달 주소 초기화를 해주는 버튼
	
	private FileReader fr; //주소지 정보의 데이터 텍스트 파일을 불러오기 위해 선언
	private FileWriter fw; //배달 주소를 새로 초기화 해주기위해 선언
	private BufferedReader br; // fr의 텍스트 정보를 읽어내기 위해 선언
	private Adress dev; // Adress 클래스 인스턴스 변수
	
	private String price; // 총 가격을 구하기 위한 문자열 변수
	private int tpprice; // 토핑의 가격을 구하기 위한 정수형 변수
	
	static TextArea text; // 텍스트 상자로 static 으로 선언
	static ButtonGroup radio = new ButtonGroup(); // 버튼 그룹으로 static 으로 선언
	static JComboBox<Pizza_Cost> pizza_style = new JComboBox<Pizza_Cost>(Cost.pcost()); // 피자 메뉴를 나타내는 콤보박스로 static 으로 선언
	
	public GUI()
	{	
		super("피자 주문"); // 프로그램 타이틀
		this.setSize(1250, 500); // 크기 설정
		this.setLocation(100,200); // 위치 초기화
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 안정적으로 종료하기위해 사용
		
		size = new JRadioButton(Cost.scost().get(0) + "원"); // 스몰 사이즈의 피자 값 초기화
		size_mid=new JRadioButton(Cost.scost().get(1)+"원"); // 미디움 사이즈의 피자 값  초기화
		size_large=new JRadioButton(Cost.scost().get(2)+"원"); // 라지 사이즈의 피자 값  초기화
		
		garlic=new JCheckBox(Cost.tcost().get(1)+"원"); // 갈릭 토핑 값 초기화
		chili=new JCheckBox(Cost.tcost().get(2)+"원"); // 칠리소스 토핑 값 초기화
		cheese=new JCheckBox(Cost.tcost().get(3)+"원"); // 트리플 치즈 토핑 값 초기화
		bacon=new JCheckBox(Cost.tcost().get(4)+"원"); // 베이컨 토핑 값 초기화
		none=new JCheckBox("토핑없음");// 토핑이 없을시의 값 초기화
		submit = new JButton("주문");  
		delivery=new JButton("배달"); 
		adresslist=new JButton("주소지 확인");
		deldata=new JButton("주문기록 삭제");
		text=new TextArea(16,40); // 텍스트 상자 크기 조정
		
		size.setSelected(true); // 스몰사이즈로 자동으로 초기값을 주어준다
		
		radio.add(size); 
		radio.add(size_mid);
		radio.add(size_large);
		// 버튼 그룹에 각 라디오 버튼을 추가 시킨다.
		
		
		text.setEditable(false); // 텍스트를 편집 할 수 없도록 설정
		
		JPanel sizee = new JPanel(new FlowLayout());
		JPanel stylee = new JPanel(new FlowLayout());
		JPanel toppingse = new JPanel(new FlowLayout());
		JPanel options = new JPanel(new GridLayout(3, 1));
		JPanel textbox = new JPanel();
		JPanel biggest = new JPanel(new GridLayout(0, 2));
		// 각 페널들을 선언해준다.
		
		dev=new Adress(this);
		// dev라는 객체에 Adress 클래스 할당
		sizee.add(size);
		sizee.add(size_mid);
		sizee.add(size_large);
		//각 사이즈를 패널에 추가시킨다
		stylee.add(pizza_style);
		// 피자의 종류를 패널에 추가시킨다
		toppingse.add(garlic);
		toppingse.add(chili);
		toppingse.add(cheese);
		toppingse.add(bacon);
		toppingse.add(none);
		// 토핑을 패널에 추가시킨다.
		textbox.add(text);
		// 텍스트 상자를 패널에 추가시킨다.
		Container contentPane = this.getContentPane();
		// contentPane 이라는 컨테이너 객체 생성
		contentPane.setLayout(new FlowLayout());
		//레이아웃 지정
		options.add(sizee);
		options.add(stylee);
		options.add(toppingse);
		biggest.add(options);
		biggest.add(textbox);
		contentPane.add(biggest);
		contentPane.add(submit);
		contentPane.add(delivery);
		contentPane.add(adresslist);
		contentPane.add(deldata);
		//버튼 및 각 패널들을 추가시킨다
		Border optionsBorder = BorderFactory.createTitledBorder("옵션");
		options.setBorder(optionsBorder);
		Border sizeBorder = BorderFactory.createTitledBorder("사이즈 선택");
		sizee.setBorder(sizeBorder);
		Border styleBorder = BorderFactory.createTitledBorder("메뉴 선택");
		stylee.setBorder(styleBorder);
		Border toppingsBorder = BorderFactory.createTitledBorder("토핑 선택");
		toppingse.setBorder(toppingsBorder);
		// 각 메뉴의 경계와 그 이름을 지정해준다
		submit.addActionListener(this);
		delivery.addActionListener(this);
		adresslist.addActionListener(this);
		deldata.addActionListener(this);
		// 버튼들이 동작할수 있도록 이벤트 효과를 추가시켜준다
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent clicked) {
		if (clicked.getSource() == submit) { // 주문 버튼을 눌렀을시 실행하는 동작들
			text.setText("주문된 피자:\n" + "--------------------\n"); // 텍스트를 설정해준다
			text.append("사이즈 : ");
			
			text.append(Libraries.getSelectedButton()+"\n"); // Libraries 클래스에 선언한 사용자 함수를 텍스트 상자에 나타나게 한다
			
			text.append("주문된 피자: " + pizza_style.getSelectedItem() + "\n"); // 선택한 콤보상자 값을 불러낸다.
			
			text.append("토핑: ");
			if (none.isSelected()) { // 토핑 없음을 선택한경우
			
				garlic.setSelected(false);
				chili.setSelected(false);
				cheese.setSelected(false);
				bacon.setSelected(false);
				// 모든 토핑의 체크를 해제한다.
				tpprice=Cost.Tcost.get(0).getTpcost(); // 토핑의 가격을 불러온다
				text.append(none.getText()+" "); //체크 박스의 값을 텍스트 상자에 나타낸다
			}
			
			if (garlic.isSelected()) { // 갈릭을 선택한 경우
				tpprice+=Cost.Tcost.get(1).getTpcost(); // tpprice에 갈릭의 가격을 더한다
				text.append(garlic.getText()+" "); // 체크 박스의 값을 텍스트 상자에 나타낸다
				
			}
			
			if (chili.isSelected()) { // 칠리소스를 선택한 경우
				tpprice+=Cost.Tcost.get(2).getTpcost(); // tpprice에 칠리소스의 가격을 더한다
				text.append(chili.getText()+" "); // 체크 박스의 값을 텍스트 상자에 나타낸다
			}
			
			if (cheese.isSelected()) { // 트리플 치즈를 선택한 경우
				tpprice+=Cost.Tcost.get(3).getTpcost(); // tpprice에 트리플 치즈의 가격을 더한다
				text.append(cheese.getText()+" "); // 체크 박스의 값을 텍스트 상자에 나타낸다
			}
			
			if (bacon.isSelected()) { // 베이컨을 선택한 경우
				tpprice+=Cost.Tcost.get(4).getTpcost(); // tpprice에 베이컨의 가격을 더한다
				text.append(bacon.getText()+" "); // 체크 박스의 값을 텍스트 상자에 나타낸다
			}
			
			text.append("\n");
			
			price=Integer.toString((Cost.Pcost.get(pizza_style.getSelectedIndex()).getPcost())+
					Cost.Scost.get(Libraries.getSelectedButtonIndex()).getScost()+tpprice); // 총 피자의 가격을 문자열화 시켜서 나타낸다
			text.append("총 가격 : "+price+" 원\n");
			tpprice=0; // 토핑의 가격을 0으로 초기화 시켜준다
			(new Thread(new Producer())).start();
			(new Thread(new Consumer())).start();
			// 피자 주문과 소비를 나타낸 스레드

		}
		
		if(clicked.getSource()==delivery){ // 배달 버튼을 클릭했을시
			dev.setVisible(true); // Adress 클래스의 gui를 띄워준다
		}
		
		if(clicked.getSource()==adresslist){ // 주소지 확인을 클릭했을시
			text.setText("주소지 및 전화번호 : \n -------------\n");
			try {
				fr = new FileReader("data.txt"); //data.txt 파일을 불러온다
				 br=new BufferedReader(fr); // data.txt 파일을 읽는다
				String s;
				while((s=br.readLine())!=null){ // 한줄씩 읽어낸다
					text.append(s+"\n");
					}
				fr.close(); 
				br.close();
				// 닫아준다
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if(clicked.getSource()==deldata){ // 주문 기록 삭제를 클릭했을시
			try{
				fw=new FileWriter("data.txt"); // data.txt 라는 아무 값이 없는 파일을 새로 생성해 덮어씌운다
				JOptionPane.showMessageDialog(null, "기록이 삭제되고 새 데이터가 생성되었습니다."); // 메세지 박스를 나타낸다
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new GUI();

	}
}
