package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojoClasses.AddResponse;
import pojoClasses.DivideResponse;
import pojoClasses.MultiplyResponse;
import pojoClasses.SubtractResponse;

@SpringBootApplication
public class CalciConsumerApplication {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalciConfig.class);
		CalciClient client = context.getBean(CalciClient.class);
		AddResponse addResult = client.getAddResponse(12,5);
		DivideResponse divideResult = client.getDivideResult(12,3);
		MultiplyResponse mulResult = client.getMulResult(4,3);
		SubtractResponse subResult = client.getSubResult(12,3);
		System.err.println("Got add response as below : ");
		Thread.sleep(2000);
		System.out.println(addResult.getAddResult());
		Thread.sleep(500);
		System.err.println("Got divide response as below : ");
		Thread.sleep(2000);
		System.out.println(divideResult.getDivideResult());
		Thread.sleep(500);
		System.err.println("Got multiply response as below : ");
		Thread.sleep(2000);
		System.out.println(mulResult.getMultiplyResult());
		Thread.sleep(500);
		System.err.println("Got subtract response as below : ");
		Thread.sleep(2000);
		System.out.println(subResult.getSubtractResult());


	}

}
