package aproject.controller;

public class AController implements CommonController{
    
	public void f1() {
		System.out.println("AController f1");
	}

	@Override
	public void execute() {
		System.out.println("AController execute");
		
	}
}
