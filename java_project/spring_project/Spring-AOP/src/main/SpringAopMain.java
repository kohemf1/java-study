package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import aop.Calculator;
import aop.CalculatorImpl;
import aop.RecCalculator;

public class SpringAopMain {
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config/aopConfig.xml");

		Calculator recCalcurator = ctx.getBean("recCal", Calculator.class);

		long calResult1 = recCalcurator.factorial(10);
		System.out.println("factorial(10) 의 결과 : " + calResult1);

		System.out.println("====================");

		Calculator calcuratorImp = ctx.getBean("calImpl", Calculator.class);

		long calResult2 = calcuratorImp.factorial(10);
		System.out.println("factorial(10) 의 결과 : " + calResult2);

	}
}
