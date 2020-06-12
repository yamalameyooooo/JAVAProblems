package com.shamsu.JAVAProblems.problems;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secondlargestnumber")
public class SecondLargestNumberInArray {

	/*
	 * PROBLEM STATEMENT: Print the 2nd largest number from the array list of type
	 * int without using java libraries like sort function or maxof
	 * 
	 * ---------------------------------------------------------------------- 
	 * INPUT:
	 * http://localhost:8080/secondlargestnumber/1,700,59,11,800,900,1500,901,908
	 * 
	 * OUTPUT: 908
	 */
	
	@GetMapping("/{listInputString}")
	public String eatChocolates(@PathVariable(value = "listInputString") String listInputString) {
		String answer = null;
		int temp;
		String liststring = listInputString;
		
		//making the input string with comma separated as a Array list of type string and then int
		String[] slist = liststring.split(",");
		ArrayList<Integer> nlist= new ArrayList<Integer>();
		for (int i = 0; i < slist.length; i++) {
			Integer y = Integer.parseInt(slist[i]);
			nlist.add(i, y);
			
		}
		/*nlist is the array list with int numbers as input from user
		
		*we make a copy of this nlist and iterate it to find the biggest number from the copy list along
		*
		*while iterating we are jumping the currently biggest element till it reaches at end
		*So at the end, the biggest number is being moved to the last place in the list by swapping technique
		*/
		ArrayList<Integer> copynlist = nlist;
		for(int i = 0; i<copynlist.size(); i++ ){
	         for(int j = i+1; j<copynlist.size(); j++){
	            if(copynlist.get(i)>copynlist.get(j)){
	               temp = copynlist.get(i);
	               copynlist.set(i,copynlist.get(j));
	               copynlist.set(j,temp);
	            }
	            else if(copynlist.get(i)==copynlist.get(j)) {
	            	//remove dublicate without removing element to avoid concurrent exception
	            	copynlist.set(i,0);
	            }
	         }
	      }
//		answer = "Biggest Number is: "+copynlist.get(copynlist.size()-1);
		
		
		/*now since we have got the biggest number's index i.e the last place in the list.
		 * We now remove that last element from the list as we know its the biggest element
		*/
		copynlist.remove(copynlist.size()-1);
		
		/*now we iterate the modified copy list for its biggest number as we already deleted the biggest number
		*in the above step, so this biggest number will be actually the 2nd Biggest number from the user input perspective
		*/
		for(int i = 0; i<copynlist.size(); i++ ){
	         for(int j = i+1; j<copynlist.size(); j++){
	            if(copynlist.get(i)>copynlist.get(j)){
	               temp = copynlist.get(i);
	               copynlist.set(i,copynlist.get(j));
	               copynlist.set(j,temp);
	            }
	         }
	      }
		answer = "2nd Biggest Number is: "+copynlist.get(copynlist.size()-1);
		return answer;
	}

}
