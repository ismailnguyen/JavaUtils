package algo.helloworld;

import algo.helloworld.interfaces.IHelloWorld;


public class Application {
	public static void main(String[] args) {
		IHelloWorld hw = new HelloWorld();
		System.out.println(hw.helloWorld());
	}
}
