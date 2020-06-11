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

	@GetMapping("/{m}/{c}/{f}")
	public String eatChocolates(@PathVariable(value = "m") int m,@PathVariable(value = "c") int c,@PathVariable(value = "f") int f) {
		int totalChocolate;
		int money = m;
		int pricePerChocolate = c;
		int offer = f;
		String answer = null;
		Boolean flag = false;
		
		if(m>c) {
			int initialChocolate=money/pricePerChocolate;
			int initialWrapper = money/pricePerChocolate;
			while (flag != true) {
				initialChocolate+=initialWrapper/offer;
				initialWrapper=initialWrapper/offer+initialWrapper%offer;
				if(initialWrapper>=0 && initialWrapper<offer) {
					flag = true;
				}
			}
			totalChocolate=initialChocolate;
			answer = "Sanjay got a total of "+totalChocolate+" choclates.";
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
