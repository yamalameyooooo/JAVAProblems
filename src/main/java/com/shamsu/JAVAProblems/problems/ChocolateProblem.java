package com.shamsu.JAVAProblems.problems;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chocolate")
public class ChocolateProblem {

	/*
	 * PROBLEM STATEMENT: Sanjay loves chocolates. He goes to a shop to buy his
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

	@GetMapping("/partial/{m}/{c}/{f}")
	public String eatChocolates(@PathVariable(value = "m") int m, @PathVariable(value = "c") int c,
			@PathVariable(value = "f") int f) {
		int totalChocolate;
		int money = m;
		int pricePerChocolate = c;
		int offer = f;
		String answer = null;
		Boolean flag = false;

		if (money > pricePerChocolate) {
			int initialChocolate = money / pricePerChocolate;
			int initialWrapper = money / pricePerChocolate;
			while (flag != true) {
				initialChocolate += initialWrapper / offer;
				initialWrapper = initialWrapper / offer + initialWrapper % offer;
				if (initialWrapper >= 0 && initialWrapper < offer) {
					flag = true;
				}
			}
			totalChocolate = initialChocolate;
			answer = "Sanjay got a total of " + totalChocolate + " choclates.";
		} else if (m == c) {
			answer = "Sanjay got a total of 1 chocolate.";
		} else {
			answer = "Sanjay has less money to buy even a single chocolate of rs." + c + ". Please give him " + (c - m)
					+ " rs to feed him YUMMY YUMMY chocolate.";
		}
		return answer;

	}

	/*
	 * PROBLEM STATEMENT:
	 * Earlier you solved the chocolate problem where Sanjay had m
	 * rupees and cost of each chocolate was c rupees. Shopkeeper gave away one
	 * chocolate for three wrappers. In this problem lets generalise the question
	 * saying, Sanjay has m rupees, each chocolate costs c rupees, shopkeeper will
	 * give away k chocolates for w wrappers. Can you find now how many chocolates
	 * Sanjay will be able to eat?
	 * -------------------------------------------------------------------------
	 * 
	 * INPUT: 
	 * 4 integers separated by space in order m c w k integers c and w will
	 * be >0 integers m and k will be >=0 integer k will be <w
	 * 
	 * OUTPUT: 
	 * An integer denoting number of chocolates Sanjay will be able to get.
	 * 
	 * -------------------------------------------------------------------------
	 * Sample input: 15, 2, 3, 1
	 * Sample output: 10
	 * -------------------------------------------------------------------------
	 * 
	 * EXPLAINATION: 
	 * Sanjay has 15 rupees, buys 7 chocolates for 2 rupees each.
	 * Sanjay now has 7 wrappers, exchanges 6 of them for 2 more chocolates. Sanjay
	 * now has 3 wrappers and exchanges them for 1 more chocolate making a total of
	 * 10 chocolates
	 */
	
	@GetMapping("/generalised/{m}/{c}/{w}/{k}")
	public String eatChocolates(@PathVariable(value = "m") int m, @PathVariable(value = "c") int c,
			@PathVariable(value = "w") int w,@PathVariable(value = "k") int k) {
		int totalChocolate;
		int money = m;
		int pricePerChocolate = c;
		int offerAt = w;
		int chocPerW = k;
		String answer = null;
		Boolean flag = false;

		if(chocPerW<offerAt) {
			if (money > pricePerChocolate) {
				int initialChocolate = money / pricePerChocolate;
				int initialWrapper = money / pricePerChocolate;
				while (flag != true) {
					initialChocolate+=chocPerW;
					initialWrapper=(initialWrapper-offerAt)+chocPerW;
					if (initialWrapper >= 0 && initialWrapper < offerAt) {
						flag = true;
					}
				}
				totalChocolate = initialChocolate;
				answer = "Sanjay got a total of " + totalChocolate + " choclates.";
			} else if (m == c) {
				answer = "Sanjay got a total of 1 chocolate.";
			} else {
				answer = "Sanjay has less money to buy even a single chocolate of rs." + c + ". Please give him " + (c - m)
						+ " rs to feed him YUMMY YUMMY chocolate.";
			}
		}
		else {
			answer = "The shopkeeper ain't mad to give you more chocolates than wrapper which you give back, Have some sense!!!";
		}
		return answer;

	}

}
