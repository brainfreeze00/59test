package book.chap07;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMaster {
	
	//�����
	
	
	
	//����Ʈ ������
	public	ArrayListMaster() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(10); // index 0 - 10 // ������Ʈ�� �߰��Ҷ��� add �޼ҵ带 ����մϴ�. add�� �ܼ��� �迭�ڿ� �����͸� ���ϱ� ������ �����ϴ�.
		numbers.add(20); // index 1 - 20
		numbers.add(30); // index 2 - 30
		numbers.add(40); // index 3 - 40
		System.out.println("add(��)");
		System.out.println(numbers);
		
		
		/* index 0 - 10
		 * index 1 - 50 numbers.add(1, 50);�� ���� ����
		 * index 2 - 20 numbers.add(1, 50);�� ���� �ε����� �и�
		 * index 3 - 30
		 * index 4 - 40
		 */
		numbers.add(1, 50); 
		System.out.println("\nadd(�ε���, ��)");
		System.out.println(numbers);
		
		numbers.remove(2);   // index 2 �� ����  �� index2�� ���� ���� ����
		System.out.println("\nremove(�ε���)");
		System.out.println(numbers);
		
		System.out.println("\nget(�ε���)");
		System.out.println(numbers.get(2)); //�װ� ������

		System.out.println("\nsize()");
		System.out.println(numbers.size());//�ε��� ���
		
		System.out.println("\nindexOf()");
		System.out.println(numbers.indexOf(30)); // 30�� �ε��� ����
		
		Iterator it = numbers.iterator(); // ��� �迭 ���� ���� Ŭ���� 
        System.out.println("\niterator");
        while (it.hasNext()) {  
            int value = (int) it.next();
            if (value == 30) { // ���� 30 �϶� 30 ������ ���� 
                it.remove();
            }
            System.out.println(value);
        }
        System.out.println(numbers);

        System.out.println("\nfor each");
        for (int value : numbers) {
            System.out.println(value);
        }
        System.out.println("\nfor");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
		
	}
	//�޼ҵ�
	
	//���� �޼ҵ�
	public static void main(String[] args) {
		new ArrayListMaster();
	}
}
