package com.ymkz;

import com.ymkz.beanDefinition.MyBeandefinition;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class WuchenlinApplication {

	public static void main(String[] args) {
		List<String> paramsList = new ArrayList<>();
		paramsList.add("MyApplicationRunner");
		paramsList.add("MyCommandLineRunner");
		ConfigurableApplicationContext applicationContext = SpringApplication.run(WuchenlinApplication.class, paramsList.toArray(new String[0]));

//		DefaultApplicationArguments applicationArguments = (DefaultApplicationArguments)applicationContext.getBean("springApplicationArguments");
//		Set<String> optionNames = applicationArguments.getOptionNames();
//		List<String> nonOptionArgs = applicationArguments.getNonOptionArgs();
//		optionNames.stream().forEach(System.out::println);
//		System.out.println("-----------------------------------");
//		nonOptionArgs.stream().forEach(System.out::println);

//		MyBeandefinition bean = applicationContext.getBean(MyBeandefinition.class);
//		System.out.println("bean name = " + bean.getName());
		
		// git rebase 3
	}





}
