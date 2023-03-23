package aproject.controller;

public class FrontController {

	public static void main(String[] args) {
		CommonController controller = null;
		
		controller = new AController();
		controller.execute();
		
		controller = new BController();
		controller.execute();
		
	}

}
