/*
 * TITLE							:	Looking for Fermat’s Last Theorem Near Misses
 * FILE NAME						:	MissFinder.java
 * EXTERNAL FILES NECESSARY			:	None
 * EXTERNAL FILES THIS CREATES		:	MissFinder.class - This is the byte code of this program, containing instructions for the jvm to execute.
 * PROGRAMMERS						:	Sailusha & Harilok
 * EMAIL ADDRESSES					:	Sailusha - sailushaIjjada@lewisu.edu
 * 										Harilok  - harilokReddyKolan@lewisu.edu
 * COURSE & SECTION NUMBER			:	SU22-CPSC-60500-001 & 002
 * DATE								:	30th july, 2022
 * 
 * EXPLANATION
 * 		this program checks for the Fermat's last theorem near misses i.e., there cannot be any 3 natural numbers such that 
 * x^n + y^n = z^n where n is a natural number greater than 2. This program checks for the difference between x^n + y^n and z^n.
 * 
 * RESOURCES						: None
 */



import java.util.*;
public class MissFinder	
{
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			long n = 0, k = 0;		//for storing the power value and x,y limit values.
			
			while((n<=2) || (n>=12)) {		//reading n until it falls in the range [2,12]
			    System.out.println("Enter the power value 'n' in range [2,12]!");
			    n = sc.nextLong();
			}
			while(k<=10) {					//reading k until it is greater than 10
			    System.out.println("Enter the x, y limit value 'k' where k>10");
			    k = sc.nextLong();
			}
			
			long mis = Long.MAX_VALUE;		//this variable stores the difference between x^n+y^n and z^n.
			double rel_mis = Long.MAX_VALUE;	//this variable stores the relative miss.

			for(long x = 10;x<=k;x++) {		//taking each x
			    for(long y = 10;y<=k;y++) {		//taking each y
					
			        long pow_sum = (long)(Math.pow(x,n) + Math.pow(y,n));	//calculating the x^n+y^n.
			        
					if(pow_sum<0) {						//checking whether overflow is occurring.
			            System.out.println("OverFlow occurred!!\nEnter the lower valurs of n and k.");
			            return;
			        }
			        long z = (long)(Math.pow(pow_sum, 1.0/n)), zn = (long)(Math.pow(z, n)), t_mis;	//variable for storing z, z^n values.
			        long z1n = (long)(Math.pow(zn>pow_sum?z-1:z+1,n));		//variable for storing either (z+1)^n or (z-1)^n values.
			        
					if(Math.abs(pow_sum-zn) < Math.abs(pow_sum-z1n)) {		//calculating the miss value.
			            t_mis = Math.abs(pow_sum-zn);
			        } else {
			            t_mis = Math.abs(pow_sum-zn);
			            z += 1;
			        }

			        double t_rel = (100.0*t_mis)/pow_sum;		////calculating the relative miss value.
					if(t_rel<rel_mis) {
			            mis = t_mis;
			            rel_mis = t_rel;
			        }
					System.out.printf("for [ %d^%d + %d^%d <> %d^%d ], the miss is %d and %.6f\n",x,n,y,n,z,n,mis,rel_mis);		//printing the miss and relative miss values.
			    }
			}
			sc.close();
		}
	}
}
