package ocjp.control;

public class Q52 {
	 
	public enum Dogs {collie, harrier, shepherd};
	 
	 public static void main(String [] args) {
		 Dogs myDog = Dogs.shepherd;   //shepherd로 초기화 됨
		 switch (myDog) {
		 	case collie:
		 		System.out.print("collie ");
		 		break;
		 	case harrier:
		 		System.out.print("harrier ");
		 		break;
		 	default://case default: 가 아니고 default: 이다
		 		System.out.print("retriever ");
		 		break;
		 }////////end of switch
	 }//////end of main
}///////////////////end of Q52
