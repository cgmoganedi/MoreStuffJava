public class Main {
	public static void main(String[] args) {

		GeometricShape eight = new GeometricShape("0");
		eight.print();
		eight.translate(3, -2);
		eight.print();
		eight.horizontalShear(3);
		eight.print();
	}

}