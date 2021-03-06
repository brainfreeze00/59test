package division.UI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TestEvent implements ActionListener{
	TestView tv = null;

	public TestEvent(TestView tv) {// new TestEvent(this);에 의해 생성자에 tv를 넘김
		this.tv = tv;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(tv.jbtn_change == obj) { // 너 변경버튼 클릭한거야?
			Container cont = tv.getContentPane();  //
			cont.remove(tv.ts);                    //
			cont.remove(tv.ts.jtf_msg);            //
			JPanel jp = new JPanel();              //
			JButton jbtn = new JButton("테스트");    //
			jp.add(jbtn);                          //
			tv.add("South",jp);                    //
			cont.revalidate();
		}
		else if(tv.ts.jtf_msg == obj) {
			tv.ts.jtf_msg.setText("오늘 스터디할까? \n"); // tv에 있는 ts에 있는 jtf_msg의 setText메소드에 ("오늘 스터디할까?")를 대입
		}
				
	}

}
