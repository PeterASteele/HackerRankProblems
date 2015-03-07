import java.util.Scanner;

/**
 * 
 * @author Peter
 *
 */
/**
 * 
 * Problem Statement:
 * 
 * The famous Arora-Mitchell approximation algorithm for the Euclidean Travelling Salesman Problem (Euclidean TSP) was discovered independently by Sanjeev Arora and Joseph S. B. Mitchell in 1998. It can approximate the value of an optimal TSP tour in d dimensions within a factor of 1+1/c in running time
n(logn)O((cd√)d−1),
where n is the number of nodes in the tour.

Miroslava works for a computer security company and it is time to renew a shared cryptographic key in many data centres across Europe. To do this, Miroslava is going to rent a private jet and deliver the key to employees waiting at all major European airports. She wants to be back as soon as possible.

Miroslava’s company has a computer that is able to execute p billions of operations per second. Since we can approximate Europe by a two-dimensional plane, we assume that the Arora-Mitchell algorithm runs for exactly

seconds on this computer to produce the exact (1+1/c)-approximation of the optimal tour.

Miroslava noticed that c is a parameter of the algorithm that can be used to her advantage, but one also needs to be very careful when choosing the right value. If she sets c too low, the algorithm will finish very fast but the time she spends flying around Europe will be too long. On the other hand, setting it too high will force her to wait for an answer from the computer, while she could be flying instead.

Miroslava used to work in a different company and from there she knows that the optimal tour of all major European airports is s meters long, but she wasn’t ranked high enough in the company to know the actual tour. Given the speed v of the private jet in meters per second, Miroslava needs s(1+1/c)/v seconds to complete the tour produced by the algorithm run with parameter c. For the sake of simplicity, we assume that Miroslava can land, leave a copy of the private key and take off from each airport in an instant.

How long does it take Miroslava to first run the algorithm and then distribute all the keys, assuming that she chooses the optimal parameter c?

Input
The input consists of one line with four numbers:

an integer n (4≤n≤1000000), the number of airports;
a real number p (0.001≤p≤5000), the number of billions of operations the computer can execute per second;
a real number s (106≤s≤109), the length of the optimal tour of all European airports in meters;
a real number v (50≤v≤900), the speed of the private jet in meters per second.
All real numbers will have at most 10 digits after the decimal point.

Output
Output one line with the shortest possible time t in seconds to distribute the keys and the value of the parameter c Miroslava should use to achieve time t. Your answer should have an absolute or relative error of at most 10−6.

Sample Input 1	Sample Output 1
10 8.9 40075000 272.1
157079.04857106 15.598261092309
Sample Input 2	Sample Output 2
47 4.2 1337102.4 256
5836.2936298227 8.9113418228146
 *
 */
public class traveling {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		double input[] = new double[4];
		for(int a = 0; a < 4; a++){
				input[a] = stdin.nextDouble();
		}
		double n = input[0];
		double p = input[1];
		double s = input[2];
		double v = input[3];
		double c = 0.0;
		double minTime = 2147000000;
		double minC = 0;
		double tempTime = 0;
		while(c < 100){ //Rough check
			c=c+.0001;
			tempTime = (n * Math.pow((Math.log(n)/Math.log(2)), c * Math.sqrt(2)))/((p) * ((long) 1000000000)) + (1 + (1/c))*s/v;
			if(tempTime < minTime){
				minTime = tempTime;
				minC = c;
			}
		}
		c = minC-.001;
		double maxC = minC + .001;
		while(c < maxC){
			c=c+.00000001; //Fine tune
			tempTime = (n * Math.pow((Math.log(n)/Math.log(2)), c * Math.sqrt(2)))/((p) * ((long) 1000000000)) + (1 + (1/c))*s/v;
			if(tempTime < minTime){
				minTime = tempTime;
				minC = c;
			}
		}
		System.out.println(minTime + "   " + minC);
	}
}
