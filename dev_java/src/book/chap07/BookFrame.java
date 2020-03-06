package book.chap07;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookFrame extends JFrame {
	//컬럼
	String cols[] = {"책제목","책저자"}; // 컬럼
	//들어갈 데이터
	String data[][] = new String[0][2]; 
	//리모콘 역할이며 JTable 객체를 생성할때 세팅해준다
	DefaultTableModel	 dtm_book = new DefaultTableModel(data, cols); 
	//getSelectRow()메소드에 대해서 연구해볼것
	JTable jtb_book = new JTable(dtm_book);
	//제한되어 있는 화면에 화면보다 더 큰 컴포넌트를 표시하기위해 스코롤 기능을 추가한 패널 주로 JTree, JTable, JList, JTexArea와 함께 사용
	JScrollPane jsp_book = new JScrollPane(jtb_book);
	
	//생성자
	public BookFrame() {
		//어레이리스트형인 라이브러리에 인스턴스화한다 <> 이 연산자는 제네릭이라 부르며 입력된 클래스를 시각화한다. 주소번지를 반환한다.
		ArrayList<Book1> library = new ArrayList<>();
		//북1형인 b1에 북1을 새로 생성한다.
		Book1 b1 = new Book1();
		//b1의 주소번지에 있는  b_title에 string 타입인 "태백산맥"을 대입한다.
		b1.b_title = "태백산맥";
		//b1의 주소번지에 있는  b_author에 string 타입인 "조정래"을 대입한다.
		b1.b_author = "조정래";
		//라이브러리에 b1인자를 추가한다.
		library.add(b1);
		b1 = new Book1();
		b1.b_title = "데미안";
		b1.b_author = "헤르만 헤세";
		library.add(b1);
		//라이브러리의 사이즈를 출력한다 INDEX
		System.out.println("size : "+library.size()); // 2
		//벡터형인 v에 인스턴스화한다  <> 이 연산자는 제네릭이라 부르며 입력된 클래스를 시각화한다. 다만 String은 값이 반환된다
		Vector<String> v = new Vector<>(); // 1 층  2개씩
		//라이브러리 인덱스 0의 b_title값을 get메소드를 통해 불러내고 v에 추가한다. 
		v.add(library.get(0).b_title); 
		//라이브러리 인덱스 0의 b_author값을 get메소드를 통해 불러내고 v에 추가한다. 
		v.add(library.get(0).b_author);
		//dtm_book주소번지에 v인자를 addRow메소드를 통해 추가한다.
		dtm_book.addRow(v); // addRow메소드에 올 파라미터  1. object 2. vector
		v = new Vector<>(); // 왜 또 인스턴스 했을까 ? : 다른 층에 넣어야 하니까  2 층에 2개씩
		//라이브러리 인덱스1의 b_title값을 get메소드를 통해 불러내고 v에 추가한다
		v.add(library.get(1).b_title);
		//라이브러리 인덱스1의 b_title값을 get메소드를 통해 불러내고 v에 추가한다
		v.add(library.get(1).b_author);
		//dtm_book주소번지에 v인자를 addRow메소드를 통해 추가한다.
		dtm_book.addRow(v);
		//jsp_book값을 화면  센터위치에 추가
		this.add("Center", jsp_book);
		//화면사이즈
		this.setSize(600, 300);
		//실행시 화면 띄우기
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		//이페이지에서 바로 실행하므로 선언없이 바로 인스턴스화
		new BookFrame();
	}

}
