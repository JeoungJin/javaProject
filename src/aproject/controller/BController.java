package aproject.controller;

public class BController implements CommonController{
    
	public void f1() {
		System.out.println("BController f1");
	}

	@Override
	public void execute() {
		System.out.println("BController execute");
		
	}
}