package hello;

import java.util.Date;


public class HelloWorld {
	public static void main(String[] args) {
		Date currentTime = new Date();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
	}
}
