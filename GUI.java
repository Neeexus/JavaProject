import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class GUI extends JFrame implements ActionListener {
	
	private JRadioButton size, size_mid, size_large; // ������ ����� �����ϴ� ��ư
	private JCheckBox garlic, chili, cheese, bacon, none; // ������ ������ �����ϴ� üũ�ڽ�
	private JButton submit,delivery, adresslist, deldata; // �ֹ�, ���, ��� �ּ�, ��� �ּ� �ʱ�ȭ�� ���ִ� ��ư
	
	private FileReader fr; //�ּ��� ������ ������ �ؽ�Ʈ ������ �ҷ����� ���� ����
	private FileWriter fw; //��� �ּҸ� ���� �ʱ�ȭ ���ֱ����� ����
	private BufferedReader br; // fr�� �ؽ�Ʈ ������ �о�� ���� ����
	private Adress dev; // Adress Ŭ���� �ν��Ͻ� ����
	
	private String price; // �� ������ ���ϱ� ���� ���ڿ� ����
	private int tpprice; // ������ ������ ���ϱ� ���� ������ ����
	
	static TextArea text; // �ؽ�Ʈ ���ڷ� static ���� ����
	static ButtonGroup radio = new ButtonGroup(); // ��ư �׷����� static ���� ����
	static JComboBox<Pizza_Cost> pizza_style = new JComboBox<Pizza_Cost>(Cost.pcost()); // ���� �޴��� ��Ÿ���� �޺��ڽ��� static ���� ����
	
	public GUI()
	{	
		super("���� �ֹ�"); // ���α׷� Ÿ��Ʋ
		this.setSize(1250, 500); // ũ�� ����
		this.setLocation(100,200); // ��ġ �ʱ�ȭ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���α׷��� ���������� �����ϱ����� ���
		
		size = new JRadioButton(Cost.scost().get(0) + "��"); // ���� �������� ���� �� �ʱ�ȭ
		size_mid=new JRadioButton(Cost.scost().get(1)+"��"); // �̵�� �������� ���� ��  �ʱ�ȭ
		size_large=new JRadioButton(Cost.scost().get(2)+"��"); // ���� �������� ���� ��  �ʱ�ȭ
		
		garlic=new JCheckBox(Cost.tcost().get(1)+"��"); // ���� ���� �� �ʱ�ȭ
		chili=new JCheckBox(Cost.tcost().get(2)+"��"); // ĥ���ҽ� ���� �� �ʱ�ȭ
		cheese=new JCheckBox(Cost.tcost().get(3)+"��"); // Ʈ���� ġ�� ���� �� �ʱ�ȭ
		bacon=new JCheckBox(Cost.tcost().get(4)+"��"); // ������ ���� �� �ʱ�ȭ
		none=new JCheckBox("���ξ���");// ������ �������� �� �ʱ�ȭ
		submit = new JButton("�ֹ�");  
		delivery=new JButton("���"); 
		adresslist=new JButton("�ּ��� Ȯ��");
		deldata=new JButton("�ֹ���� ����");
		text=new TextArea(16,40); // �ؽ�Ʈ ���� ũ�� ����
		
		size.setSelected(true); // ����������� �ڵ����� �ʱⰪ�� �־��ش�
		
		radio.add(size); 
		radio.add(size_mid);
		radio.add(size_large);
		// ��ư �׷쿡 �� ���� ��ư�� �߰� ��Ų��.
		
		
		text.setEditable(false); // �ؽ�Ʈ�� ���� �� �� ������ ����
		
		JPanel sizee = new JPanel(new FlowLayout());
		JPanel stylee = new JPanel(new FlowLayout());
		JPanel toppingse = new JPanel(new FlowLayout());
		JPanel options = new JPanel(new GridLayout(3, 1));
		JPanel textbox = new JPanel();
		JPanel biggest = new JPanel(new GridLayout(0, 2));
		// �� ��ε��� �������ش�.
		
		dev=new Adress(this);
		// dev��� ��ü�� Adress Ŭ���� �Ҵ�
		sizee.add(size);
		sizee.add(size_mid);
		sizee.add(size_large);
		//�� ����� �гο� �߰���Ų��
		stylee.add(pizza_style);
		// ������ ������ �гο� �߰���Ų��
		toppingse.add(garlic);
		toppingse.add(chili);
		toppingse.add(cheese);
		toppingse.add(bacon);
		toppingse.add(none);
		// ������ �гο� �߰���Ų��.
		textbox.add(text);
		// �ؽ�Ʈ ���ڸ� �гο� �߰���Ų��.
		Container contentPane = this.getContentPane();
		// contentPane �̶�� �����̳� ��ü ����
		contentPane.setLayout(new FlowLayout());
		//���̾ƿ� ����
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
		//��ư �� �� �гε��� �߰���Ų��
		Border optionsBorder = BorderFactory.createTitledBorder("�ɼ�");
		options.setBorder(optionsBorder);
		Border sizeBorder = BorderFactory.createTitledBorder("������ ����");
		sizee.setBorder(sizeBorder);
		Border styleBorder = BorderFactory.createTitledBorder("�޴� ����");
		stylee.setBorder(styleBorder);
		Border toppingsBorder = BorderFactory.createTitledBorder("���� ����");
		toppingse.setBorder(toppingsBorder);
		// �� �޴��� ���� �� �̸��� �������ش�
		submit.addActionListener(this);
		delivery.addActionListener(this);
		adresslist.addActionListener(this);
		deldata.addActionListener(this);
		// ��ư���� �����Ҽ� �ֵ��� �̺�Ʈ ȿ���� �߰������ش�
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent clicked) {
		if (clicked.getSource() == submit) { // �ֹ� ��ư�� �������� �����ϴ� ���۵�
			text.setText("�ֹ��� ����:\n" + "--------------------\n"); // �ؽ�Ʈ�� �������ش�
			text.append("������ : ");
			
			text.append(Libraries.getSelectedButton()+"\n"); // Libraries Ŭ������ ������ ����� �Լ��� �ؽ�Ʈ ���ڿ� ��Ÿ���� �Ѵ�
			
			text.append("�ֹ��� ����: " + pizza_style.getSelectedItem() + "\n"); // ������ �޺����� ���� �ҷ�����.
			
			text.append("����: ");
			if (none.isSelected()) { // ���� ������ �����Ѱ��
			
				garlic.setSelected(false);
				chili.setSelected(false);
				cheese.setSelected(false);
				bacon.setSelected(false);
				// ��� ������ üũ�� �����Ѵ�.
				tpprice=Cost.Tcost.get(0).getTpcost(); // ������ ������ �ҷ��´�
				text.append(none.getText()+" "); //üũ �ڽ��� ���� �ؽ�Ʈ ���ڿ� ��Ÿ����
			}
			
			if (garlic.isSelected()) { // ������ ������ ���
				tpprice+=Cost.Tcost.get(1).getTpcost(); // tpprice�� ������ ������ ���Ѵ�
				text.append(garlic.getText()+" "); // üũ �ڽ��� ���� �ؽ�Ʈ ���ڿ� ��Ÿ����
				
			}
			
			if (chili.isSelected()) { // ĥ���ҽ��� ������ ���
				tpprice+=Cost.Tcost.get(2).getTpcost(); // tpprice�� ĥ���ҽ��� ������ ���Ѵ�
				text.append(chili.getText()+" "); // üũ �ڽ��� ���� �ؽ�Ʈ ���ڿ� ��Ÿ����
			}
			
			if (cheese.isSelected()) { // Ʈ���� ġ� ������ ���
				tpprice+=Cost.Tcost.get(3).getTpcost(); // tpprice�� Ʈ���� ġ���� ������ ���Ѵ�
				text.append(cheese.getText()+" "); // üũ �ڽ��� ���� �ؽ�Ʈ ���ڿ� ��Ÿ����
			}
			
			if (bacon.isSelected()) { // �������� ������ ���
				tpprice+=Cost.Tcost.get(4).getTpcost(); // tpprice�� �������� ������ ���Ѵ�
				text.append(bacon.getText()+" "); // üũ �ڽ��� ���� �ؽ�Ʈ ���ڿ� ��Ÿ����
			}
			
			text.append("\n");
			
			price=Integer.toString((Cost.Pcost.get(pizza_style.getSelectedIndex()).getPcost())+
					Cost.Scost.get(Libraries.getSelectedButtonIndex()).getScost()+tpprice); // �� ������ ������ ���ڿ�ȭ ���Ѽ� ��Ÿ����
			text.append("�� ���� : "+price+" ��\n");
			tpprice=0; // ������ ������ 0���� �ʱ�ȭ �����ش�
			(new Thread(new Producer())).start();
			(new Thread(new Consumer())).start();
			// ���� �ֹ��� �Һ� ��Ÿ�� ������

		}
		
		if(clicked.getSource()==delivery){ // ��� ��ư�� Ŭ��������
			dev.setVisible(true); // Adress Ŭ������ gui�� ����ش�
		}
		
		if(clicked.getSource()==adresslist){ // �ּ��� Ȯ���� Ŭ��������
			text.setText("�ּ��� �� ��ȭ��ȣ : \n -------------\n");
			try {
				fr = new FileReader("data.txt"); //data.txt ������ �ҷ��´�
				 br=new BufferedReader(fr); // data.txt ������ �д´�
				String s;
				while((s=br.readLine())!=null){ // ���پ� �о��
					text.append(s+"\n");
					}
				fr.close(); 
				br.close();
				// �ݾ��ش�
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if(clicked.getSource()==deldata){ // �ֹ� ��� ������ Ŭ��������
			try{
				fw=new FileWriter("data.txt"); // data.txt ��� �ƹ� ���� ���� ������ ���� ������ ������
				JOptionPane.showMessageDialog(null, "����� �����ǰ� �� �����Ͱ� �����Ǿ����ϴ�."); // �޼��� �ڽ��� ��Ÿ����
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
