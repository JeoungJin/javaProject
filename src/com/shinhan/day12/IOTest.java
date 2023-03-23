package com.shinhan.day12;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

import com.shinhan.day05.Account;

public class IOTest {

	public static void main(String[] args) throws IOException, URISyntaxException, ClassNotFoundException {
		f11();
	}
	
	private static void f11() {
		String fileName = "src/com/shinhan/day12/scoredata.txt";
		File f = new File(fileName);
		
		System.out.println(f.exists());
		System.out.println(f.lastModified());
		Date d = new Date(f.lastModified());
		System.out.println(d);
		System.out.println("파일사이즈:" + f.length());
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
		
	}

	private static void f10() throws IOException, ClassNotFoundException {
		FileOutputStream fw = new FileOutputStream("serialize.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fw);	
		oos.writeObject(new Account("123","김1"));
		oos.writeObject(new Account("333","김2"));
		oos.writeObject(new Account("444","김3"));	 
		oos.close();fw.close();	
		FileInputStream fi = new FileInputStream("serialize.dat");
		ObjectInputStream ois = new ObjectInputStream(fi);
		Account s1 = (Account)ois.readObject();
		Account s2 = (Account)ois.readObject();
		Account s3 = (Account)ois.readObject();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		fi.close();
		
	}
	

	private static void f9() throws IOException, ClassNotFoundException {
		FileOutputStream fw = new FileOutputStream("serialize.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fw);
		
		oos.writeObject(new Student("김1",100,99));
		oos.writeObject(new Student("김2",100,99));
		oos.writeObject(new Student("김3",100,99));
		oos.close();
		fw.close();
		
		
		FileInputStream fi = new FileInputStream("serialize.dat");
		ObjectInputStream ois = new ObjectInputStream(fi);
		Student s1 = (Student)ois.readObject();
		Student s2 = (Student)ois.readObject();
		Student s3 = (Student)ois.readObject();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		fi.close();
		
	}

	private static void f8() throws IOException {
		FileWriter fw = new FileWriter("print.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(false);
		pw.print("false");
		pw.write(12345);
		pw.write(10);
		pw.write("true");
		
		pw.close();
		fw.close();
		
	}

	private static void f7() throws IOException {
		OutputStream fw = new FileOutputStream("primitiveData.txt");
		//자바의 기본타입을 저장하고 그대로 읽고자한다.
		DataOutputStream dos = new DataOutputStream(fw);
		dos.writeInt(123);
		dos.writeInt(456);
		dos.writeBoolean(false);
		dos.writeDouble(3.14);
		dos.writeChar('A');
		dos.close();
		fw.close();
		
		FileInputStream fr = new FileInputStream("primitiveData.txt");
		DataInputStream dis = new DataInputStream(fr);
		int a = dis.readInt();
		int b = dis.readInt();
		boolean c = dis.readBoolean();
		double d = dis.readDouble();
		char e = dis.readChar();
		System.out.println(a + 1);
		System.out.println(b - 1);
		System.out.println(c?"true":"false");
		System.out.println(d + 1);
		System.out.println( Character.toLowerCase(e));
		dis.close();
		fr.close();
		
		
	}

	private static void f6() throws IOException {
		String fileName = "src/com/shinhan/day12/scoredata.txt";
		Path path = Paths.get(fileName);
		Files.lines(path).forEach(row->{
			System.out.print(row.replaceAll("/", "\t"));
			String[] arr = row.split("/");
			int total = 0;
			for(int i=1; i<arr.length; i++) {
				try {
				   total += Integer.parseInt(arr[i]);
				}catch(NumberFormatException ex) {
					
				}
			}
			System.out.println("\t" + total + "\t" + total/(arr.length-1));
			
		});
		
	}

	private static void f5() throws IOException {
		String path = "src/com/shinhan/day12/scoredata.txt";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String row;
		String title = br.readLine();
		System.out.println(title.replaceAll("/", "\t") + "\t총점\t평균");
		while((row = br.readLine())!=null) {
			System.out.print(row.replaceAll("/", "\t"));
			String[] arr = row.split("/");
			int total = 0;
			for(int i=1; i<arr.length; i++) {
				total += Integer.parseInt(arr[i]);
			}
			System.out.println("\t" + total + "\t" + total/(arr.length-1));
		}
		br.close();
		fr.close();
		
	}

	private static void f4() throws URISyntaxException {
		//Path path = Paths.get(IOTest.class.getResource("Example.class").toURI());
		//System.out.println(path);
		
		//Path path = Paths.get("");
		//System.out.println(path.toAbsolutePath());
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		
		// 1.class기준
		// Path path = Paths.get(StreamTest3.class.getResource("data.txt").toURI());
		// 2.절대경로 /로 시작한다.
		// Path path =
		// Paths.get(StreamTest3.class.getResource("/com/shinhan/day11/data.txt").toURI());
		// 3.상대경로는 현재위치를 기준으로한다.
		// 다음은 현재의 절대경로를 얻는다.
		/*
		Path path = Paths.get(""); // 1)
		// String absolute = System.getProperty("user.dir")+"/data.txt";//2)
		// Path path = Paths.get(absolute);
		String s = path.toAbsolutePath().toString();
		path = Paths.get(s + "/data.txt");
		System.out.println("현재 작업 경로: " + s);
		System.out.println(Charset.defaultCharset());*/

	}

	private static void f3() throws IOException {

		String path = "src/com/shinhan/day12/Student.java";
		FileReader fr = new FileReader(path);
		FileWriter fw = new FileWriter("Student.java");
		int i;

		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
			fw.write(i);
		}
		fw.close();
		fr.close();
	}

	private static void f2() throws IOException {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		path += "/src/com/shinhan\\day11\\data.txt";// \t:tab \n:newline
		FileInputStream fi = new FileInputStream(path);
		InputStreamReader ir = new InputStreamReader(fi); // 보조스트림 : 1)Stream=>Reader
		int i; // -1은 EOF(End Of File)

		while ((i = ir.read()) != -1) {
			System.out.print((char) i);
		}
		ir.close();
		fi.close();
		System.out.println("f2 end");
	}

	private static void f1() throws IOException {
		// InputStream, OutputStream, Reader, Writer
		// FileInputStream, FileOutputStream, FileReader, FileWriter
		InputStream is = System.in; // 표준입력:키보드이다. 변경가능
		byte[] arr = new byte[100];
		int i = is.read(arr); // i는 read한 number of bytes
		System.out.println(i + "byte수");
		System.out.println(Arrays.toString(arr));
		for (int a = 0; a < i - 2; a++) {
			System.out.print((char) arr[a]);
		}
	}
}
