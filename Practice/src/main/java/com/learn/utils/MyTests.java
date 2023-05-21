package com.learn.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyTests {
	
	
	private static final String test_code = null;
	private static final String MY_CODE = "MY_CODE";
	
	public static void main(String[] args) {
		
//		if(MY_CODE.equals(test_code))
//			System.out.println("Success");
//		else System.out.println("Not Success");
		
		
		String str[] = null;
		List<String> list = Arrays.asList(str);
		if(Objects.isNull(list))
			list=new ArrayList<String>();
		
		System.out.println(list);
		
	}

}

//With a(n) ______ , you can mask the failure of an instance by rapidly remapping the address to another instance in your VPC.
//What features of VPC security groups are correct? (Choose 2 answers)
	//You can change the security group that an instance is associated with after launch and the changes will take effect immediately.
	//Instances associated with the same security group can not talk to each other unless rules are added specifically allowing communication.
	//Instances associated with the same security group can always communicate.
	//You can specify only deny rules, not allow rules.

//Your company is going to a hybrid cloud environment. You have been tasked to lead the design and implementation of this effort. You recommend Route 53 as a DNS solution for the cloud environment. What features of Route 53 will enable seamless integration into your overall DNS solution? (Choose 3 answers)

//You are in charge of the VPC for your company. You are developing an overall architectural document for the VPC including specifics about the VPC, Internet Gateway, Network Access Control Lists, Security Groups, and EC2 instances. You want to provide details on public IP addresses and elastic IP addresses and when you might use one over the other. What can you detail about the benefits of Elastic IP addresses? (Choose 3 Answers)




