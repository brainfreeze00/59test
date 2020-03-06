package oracle.jdbc2;

public class DeptDaoTest {
	DeptDao dDao = new DeptDao();
	int result = 0;//�Է°��|�������|������� 
	//��ȸ�ϱ� �׽�Ʈ
	public void selectTest(DeptVO dVO) { //�÷����� �����ϱ� VOó�� �ѹ��� �迭
		System.out.println("selectTest ȣ�⼺��");	
		DeptVO dVOS[] = dDao.deptList(dVO.getDeptno());
	
		for(DeptVO rdVO:dVOS) {
			System.out.println(rdVO.getDeptno()+", "
								+rdVO.getDname()+", "
								+rdVO.getLoc());
		}
	}
	//����ϱ� �׽�Ʈ
	public void insertTest(DeptVO dVO) { //�÷����� �����ϱ� VOó�� �ѹ��� �迭
		System.out.println("insertTest ȣ�⼺��");
		result = dDao.deptInsert(dVO.getDeptno(), dVO.getDname(), dVO.getLoc());
		System.out.println("�Է� ��������:"+result);
	}
	//�����ϱ� �׽�Ʈ
	public void updateTest(DeptVO dVO) { //�÷����� �����ϱ� VOó�� �ѹ��� �迭
		System.out.println("updateTest ȣ�⼺��");
		result = dDao.deptUpdate(dVO.getDname(), dVO.getLoc(), dVO.getDeptno());
		System.out.println("���� ��������:"+result);
	}
	//�����ϱ� �׽�Ʈ
	public void deleteTest(DeptVO dVO) { //�÷����� �����ϱ� VOó�� �ѹ��� �迭
		System.out.println("deleteTest ȣ�⼺��");
		result = dDao.deptDelete(dVO.getDeptno());
		System.out.println("���� ��������:"+result);
	}
	public static void main(String[] args) {
		DeptDaoTest ddt = new DeptDaoTest();
		//ȭ���� ���� �ϼ������ʾ����Ƿ� �����׽�Ʈ�� �Ұ��ϴ�.
		//������ �����׽�Ʈ�� ������ ���� 
		DeptVO dVO = new DeptVO();
		//dVO�� setDeptno�޼ҵ带 �̿��Ͽ� int 61�� ���ڷ� �ѱ��
		dVO.setDeptno(61);
		//dVO�� setDname�޼ҵ带 �̿��Ͽ� String  "ǰ��������"�� ���ڷ� �ѱ��.
		dVO.setDname("ǰ��������");
		//dVO�� setLoc�޼ҵ带 �̿��Ͽ� String "��õ"�� ���ڷ� �ѱ��.
		dVO.setLoc("��õ");
		//dVO �Ķ���͸� ������ ddt�� insertTest�޼ҵ忡  dVO�� ���ڷ� �ѱ�� 
		ddt.insertTest(dVO);
		//dVO�� null�� �ʱ�ȭ�Ͽ� ������ ������� ���´� 
		dVO = null;//������ ������� ���´�
		//dVO�� ���ο� DeptVO��ü �����Ѵ�
		dVO = new DeptVO(); //�ٽ� �ν��Ͻ��ؾ��� �ֳĸ� ���ο� ��ü�� ���������ؾ��ϴϱ�
		//dVO�� setDeptno�޼ҵ带 �̿��Ͽ� int 61�� ���ڷ� �ѱ��
		dVO.setDeptno(61);
		//dVO�� selectTest�޼ҵ带 �̿��Ͽ� ��
		ddt.selectTest(dVO);
		dVO = null;//������ ������� ���´�
		dVO = new DeptVO(); //�ٽ� �ν��Ͻ��ؾ��� �ֳĸ� ���ο� ��ü�� ���������ؾ��ϴϱ�
		dVO.setDeptno(61);
		dVO.setDname("ǰ��������2");
		dVO.setLoc("��õ2");
		ddt.updateTest(dVO);
		dVO = null;//������ ������� ���´�
		dVO = new DeptVO(); //�ٽ� �ν��Ͻ��ؾ��� �ֳĸ� ���ο� ��ü�� ���������ؾ��ϴϱ�
		dVO.setDeptno(61);
		ddt.deleteTest(dVO);
	}

}
