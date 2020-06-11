package com.shamsu.JAVAProblems.problems;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/chocolate")
public class ChocolateProblem {

	/*
	 * PROBLEM STATEMENT: 
	 * Sanjay loves chocolates. He goes to a shop to buy his
	 * favourite chocolate. There he notices there is an offer going on, upon
	 * bringing 3 wrappers of the same chocolate, you will get new chocolate for
	 * free. If Sanjay has m Rupees. How many chocolates will he be able to eat if
	 * each chocolate costs c Rupees?
	 * 
	 * ---------------------------------------------------------------------- 
	 * INPUT:
	 * Two positive integers m and c separated by a comma. The first integer is m
	 * and the second integer is c
	 * 
	 * OUTPUT: 
	 * A single integer denoting the number of chocolates Sanjay was able to
	 * eat in total.
	 */

	@GetMapping("/{m}/{c}")
	public String eatChocolates(@PathVariable(value = "m") int m,@PathVariable(value = "c") int c) {
		int totalChocolate;
		int extra=0;
		int money = m;
		int pricePerChocolate = c;
		int offer = 3;
		String answer = null;
		
		if(m>c) {
			int initialChocolate=m/c;
//			if initialChocolate = 3 get total 4 wrapper 
//			if initialChocolate = 4 get total 5 wrapper 
//			if initialChocolate = 5 get total 7 wrapper 
//			if initialChocolate = 6 get total 8 wrapper 
//			if initialChocolate = 7 get total 10 wrapper 
//			if initialChocolate = 8 get total 11 wrapper 
//			if initialChocolate = 9 get total 13 wrapper
//			if initialChocolate = 10 get total 10 wrapper 
//			if initialChocolate = 11 get total 16 wrapper 

//			extra+=1
			answer = "Sanjay can buy. OKAY! i am coding how many choclates now";
		}
		else if	(m==c) {
			answer = "Sanjay got a total of 1 chocolate.";
		}
		else {
			answer = "Sanjay has less money to buy even a single chocolate of rs."+c+". Please give him "+(c-m)+" rs to feed him YUMMY YUMMY chocolate.";
		}
		return answer;
		
	}

}
