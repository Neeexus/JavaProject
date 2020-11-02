import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Adress extends JFrame implements ActionListener {
	private	JTextField hp,ad; // �ڵ��� ��ȣ�� �ּ��� �Է� �ؽ�Ʈ �ʵ� ����
	private JLabel label,label2; // �� ����
	private JButton submit; // �ֹ� ��ư ����
	private BufferedWriter bw; // �ؽ�Ʈ �ۼ��� ���� ����
	private String date; // ��¥�� ������ ���� ����
	public Adress(GUI gui){
		super("��� ���α׷�"); // Ÿ��Ʋ ����
		setSize(400,350); // ũ�� ����
		setLocation(900,200); // ��ġ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���α׷��� ���������� �����ϱ����� ���
		setLayout(null); // ���̾ƿ� �ʱ�ȭ
		label=new JLabel("�ּ� ���"); 
		label2=new JLabel("��ȭ��ȣ");
		// �� �� �� ����
		label.setBounds(50, 50, 200, 30);
		ad=new JTextField();
		ad.setBounds(140, 50, 200, 30);
		label2.setBounds(50, 100, 200, 30);
		hp=new JTextField();
		hp.setBounds(140, 100, 200, 30);
		submit=new JButton("��� �ֹ�");
		submit.setBounds(150, 175, 100, 40);
		// ��ư �� �󺧵��� ��ġ�� ����
		add(label);
		add(ad);
		add(label2);
		add(hp);
		add(submit);
		// ��ư �� �� ���� �߰���Ų��
		submit.addActionListener(this); // ��ư�� �������� �̺�Ʈ ������ Ȱ��ȭ�Ѵ�
	}
	public void actionPerformed(ActionEvent clicked) {
		if(clicked.getSource()==submit){ // �ֹ� ��ư�� Ŭ�� �Ǿ�����
			try {
				Calendar cal=Calendar.getInstance(); // ���� �ð��� �ҷ��´�
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // �ð��� ������ �������ش�
				date=sdf.format(cal.getTime()); // date ������ ���� �ð����� �ʱ�ȭ �����ش�
				String s="�ֹ� �ð� : "+date+"\n�ּ��� : "+ad.getText()+
						"\n��ȭ��ȣ : "+hp.getText()+"\n"+"------------------------------"; //�ؽ�Ʈ�� �ʱ�ȭ �����ش�
				bw=new BufferedWriter(new FileWriter("data.txt",true));
				bw.write(s);
				bw.newLine();
				bw.close();
				//data.txt�� ������ ��������ش�
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"�ֹ� �ð� : "+date + "\n��� �ּ� : "+ad.getText()
			+"\n��ȭ ��ȣ : "+hp.getText()); // �޼��� ���ڸ� ����Ѵ�.		
			setVisible(false); // Adress gui�� �Ⱥ��̰� �����Ѵ�
		}
	}
}
