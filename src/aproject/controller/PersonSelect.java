package aproject.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PersonSelect {

	public static void main(String[] args) {
		List<String> plist = Arrays.asList("강태영","김경윤","김범기",
				"김용희","김창겸","노성은","노우현","박성진","박영선","배동열","서준호","손준범","양유진","양진우","오은빈",
				"유지만","윤성훈","이솔","이진경","이찬혁","이택주","임채희","전은정","주용준","한진");
		System.out.println("우리반:" + plist.size() + "명");
		IntStream.rangeClosed(1, 1000).forEach((i)->{
			Collections.shuffle(plist);
		}); 
		//plist.stream().forEach((s)->System.out.println(s));
		for(int i=0; i<plist.size(); i++) {
			System.out.println((i+1)+"번째-----" + plist.get(i));
		}

	}

}
