package ocjp.control;

public class Q52 {
	 
	public enum Dogs {collie, harrier, shepherd};
	 
	 public static void main(String [] args) {
		 Dogs myDog = Dogs.shepherd;   //shepherd�� �ʱ�ȭ ��
		 switch (myDog) {
		 	case collie:
		 		System.out.print("collie ");
		 		break;
		 	case harrier:
		 		System.out.print("harrier ");
		 		break;
		 	default://case default: �� �ƴϰ� default: �̴�
		 		System.out.print("retriever ");
		 		break;
		 }////////end of switch
	 }//////end of main
}///////////////////end of Q52
