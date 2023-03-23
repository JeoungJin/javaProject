package com.shinhan.day11;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.shinhan.day05.Account;

public class StreamTest3 {

	public static void main(String[] args) throws IOException, URISyntaxException  {
		 
		 
		f5();
		
 	
	}
	private static void f15() {// TODO Auto-generated method stub
		 double a = calc2((x,y)->x/y);
		 System.out.println(a);
		 
	}
	private static double calc2(Function f) {
		// TODO Auto-generated method stub
		return f.apply(10, 4);
	}
	//람다식:익명구현class를 함수형태로 작성하는 것 
	 
	private static void f14() {
		List<Student2> data = new ArrayList<>();
		data.add(new Student2("김길동", 95, "남"));
		data.add(new Student2("이길동", 85, "남"));
		data.add(new Student2("김길순", 100, "여"));
		data.add(new Student2("김아라", 90, "여"));
		data.add(new Student2("박길동", 100, "남"));
		long count = data.stream().distinct().count();
		 
		
		
	}
	private static void f13() {
		List<Student2> data = new ArrayList<>();
		data.add(new Student2("김길동", 95, "남"));
		data.add(new Student2("이길동", 85, "남"));
		data.add(new Student2("김길순", 100, "여"));
		data.add(new Student2("김아라", 90, "여"));
		data.add(new Student2("박길동", 100, "남"));
		//성별 group으로 점수평균집계를 하고 다시group이 Collection으로 만든다. 
		Map<String,Double> map =  data.stream().collect(
	        Collectors.groupingBy(st->st.getGender(), 
					              Collectors.averagingDouble(st->st.getScore())
					              )
					);	
		System.out.println(map);
		
	}



	private static void f12() {
		Integer[] arr = {2,4,6,8,3,5,7,9,1,10};	 
		Arrays.stream(arr).mapToInt(a->a.intValue()).average();		
		Arrays.stream(arr).filter(a->a.intValue()%2==0).mapToInt(a->a.intValue()).average();
		
		byte[] arr2 = {100,111,112};
		
		
		boolean result1 = Arrays.stream(arr).allMatch(su->su%2==0);
		System.out.println(result1);
		
		result1 = Arrays.stream(arr).anyMatch(su->su%2==0);
		System.out.println(result1);
		
		//모든요소가 만족하지않는가?
		result1 = Arrays.stream(arr).noneMatch(su->su%2==0);
		System.out.println(result1);
		
		double d = Arrays.stream(arr)
				.filter(su->su%2==0)
				.mapToInt(a->a.intValue())
				.average()
				.orElse(0);
				 
		System.out.println(d);
	}



	private static void f11() {
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("양4", 100));
		data.add(new Student("김3", 70));
		data.add(new Student("정5", 60));
		data.add(new Student("김2", 80));
		data.sort((a,b)->a.getScore() - b.getScore());
		for(Student st:data) {
			System.out.println(st);
		}
  

		System.out.println("------------------");
		data.stream().sorted().forEach(st->{System.out.println(st);});
		System.out.println("--------------------sort변경");
		data.stream()
		.sorted((a,b)->a.getScore()-b.getScore())
		.forEach(st->{System.out.println(st);});
		
	}



	private static void f10() {
		Integer[] arr = {100, 88, 99, 50, 60};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for(int a:arr) {
			System.out.println(a);
		}
		Arrays.sort(arr, (a,b)->b-a);
		System.out.println(Arrays.toString(arr));
		
		Student[] arr2 = {
				new Student("김", 90),new Student("양", 77),new Student("김", 70),
				new Student("박", 90),new Student("정", 88),new Student("이", 100)
		};
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		Arrays.sort(arr2, (a,b)->a.getName().compareTo(b.getName()));
		System.out.println(Arrays.toString(arr2));
		
	}



	private static void f9() {
		List<String> data = new ArrayList<>();
		data.add("This is java");
		data.add("I am a best developer");
		
		//String[] arr = data.get(0).split(" ");
		//Arrays.stream(arr);
		
		data.stream()
		 .flatMap(row-> Arrays.stream(row.split(" ")))
		 .forEach(word->{System.out.println(word);});
		System.out.println("------------------------------------");
		
		for(String row:data) {
			String[] arr = row.split(" ");
			for(String s:arr) {
				System.out.println(s);
			}
		}
		
		
		
	}

	private static void f8() {
		int[] arr = {10,20,70,90};
		Arrays.stream(arr).asDoubleStream().forEach(d->{System.out.println(d);});
		
		Arrays.stream(arr).boxed().forEach(d->{System.out.println(d.floatValue());});
		
	}

	private static void f7() {
		// distinct:중복제거
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("양4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("정5", 60));
		data.add(new Student("김2", 80));
		// 점수가 70초과인 학생만 추출
		Stream<Student> stream2 = data.stream()
			.distinct()
			.filter(s -> s.getScore() > 70);
			
			
		stream2.forEach(s -> {
				System.out.println(s);
		});
		data.stream().forEach(s -> {
			System.out.println(s);
	    });
		
		
		System.out.println("=====이름이 김씨인 사람만 추출 ====================");
		data.stream()
			.filter(st-> st.getName().startsWith("김"))
			.forEach(s -> {
				System.out.println(s);
		});
		
		System.out.println("=====이름이 김씨인 사람만 추출...점수...평균 ====================");
		data.stream()
			.filter(st-> st.getName().startsWith("김"))
			.mapToInt(aa->aa.getScore())
			.average()
			.ifPresent(d->{System.out.println("평균:" + d);});
		

	}

	private static void f6() {
		// distinct:중복제거
		List<String> data = new ArrayList<>();
		data.add("홍길동1");
		data.add("홍길동3");
		data.add("홍길동5");
		data.add("홍길동6");
		data.add("홍길동23");
		data.add("홍길동43");
		data.add("홍길동5");
		data.add("홍길동6");
		data.stream().distinct().filter(s -> s.endsWith("3")).forEach(s -> {
			System.out.println(s);
		});

	}

	private static void f5() throws URISyntaxException, IOException {
		//1.class기준
		//Path path = Paths.get(StreamTest3.class.getResource("data.txt").toURI());
		//2.절대경로 /로 시작한다. 
		//Path path = Paths.get(StreamTest3.class.getResource("/com/shinhan/day11/data.txt").toURI());
		//3.상대경로는 현재위치를 기준으로한다.
		//다음은 현재의 절대경로를 얻는다.
		Path path = Paths.get(""); //1)
		//String absolute = System.getProperty("user.dir")+"/data.txt";//2)
		//Path path = Paths.get(absolute);
	    String s = path.toAbsolutePath().toString();
	    path =Paths.get(s+"/data.txt");
	    System.out.println("현재 작업 경로: " + s);
		System.out.println(Charset.defaultCharset());
		Stream<String> streamData = Files.lines(path, Charset.defaultCharset());
		streamData.forEach(line -> {
			System.out.println(line);
		});

	}

	private static void f4() throws IOException {
		FileReader fi = new FileReader("src/com/shinhan/day11/data.txt");
		int i;
		while ((i = fi.read()) != -1) {
			System.out.print((char) i);
		}
	}

	private static void f3() {
		// 1~9까지 range
		// 1~10까지 rangeClosed
		IntStream.rangeClosed(1, 10).forEach(su -> {
			System.out.println(su + "****");
		});
		// 외부반복자
		for (int i = 1; i <= 10; i++) {
			System.out.println("일반for문:" + i);
		}

	}

	private static void f2() {
		List<Account> data = new LinkedList<>();
		data.add(new Account("123", "홍1", 1000));
		data.add(new Account("124", "홍2", 2000));
		data.add(new Account("127", "홍6", 3000));
		data.add(new Account("128", "홍5", 4000));
		data.add(new Account("126", "홍4", 5000));
		data.add(new Account("125", "홍3", 6000));
		// 모든계좌의 잔고의 합을 출력하기 ...외부반복자를 이용
		int total = 0;
		for (Account acc : data) {
			total += acc.getBalance();
		}
		System.out.println("잔고의 합계1:" + total);
		// stream을 이용하면 내부반복자를 사용한다.
		long total2 = data.stream().mapToLong(acc -> acc.getBalance()).sum();
		System.out.println("Account balance 합계:" + total2);

		total2 = data.stream().map(acc -> acc.getOwner()).count();
		System.out.println("건수는 " + total2);
		// forEachOrdered : 순서를 보장한다.
		// forEach:순서보장안함
		data.parallelStream().map(acc -> acc.getOwner()).forEachOrdered(owner -> System.out.println(owner + "예금주님"));
	}

	private static void f1() {
		// 여러건 저장하기 : 배열, Collection(List, Set, Map)
		List<Student> data = new ArrayList<>();
		data.add(new Student("김1", 100));
		data.add(new Student("김4", 90));
		data.add(new Student("김3", 70));
		data.add(new Student("김5", 60));
		data.add(new Student("김2", 80));
		// data를 stream으로 만들어서 중간처리, 최종처리
		data.stream().forEach((st) -> {
			System.out.println(st);
			System.out.println(st.getName() + "==>" + st.getScore());
		});
		System.out.println("===========중간처리 test==========");
		data.stream().mapToInt(st -> st.getScore()).forEach(score -> {
			System.out.println(score);
			System.out.println("----------------");
		});

		System.out.println("===========최종처리 test==========");
		/*
		 * double d = data.stream() .mapToInt(st->st.getScore()) .average()
		 * .getAsDouble(); System.out.println("average=" + d);
		 */

		System.out.println("===========Optional test1==========");

		OptionalDouble option = data.stream().mapToInt(st -> st.getScore()).average();
		option.ifPresent(result -> System.out.println(result));

		System.out.println("===========Optional test2==========");
		data.stream().mapToInt(st -> st.getScore()).average().ifPresent(result -> System.out.println(result));

		System.out.println("===========Optional test3==========");
		data.stream().mapToInt(st -> st.getScore()).average().ifPresentOrElse(d -> {
			System.out.print(d);
		}, () -> {
			System.out.println("평균계산실패");
		});

	}

}
