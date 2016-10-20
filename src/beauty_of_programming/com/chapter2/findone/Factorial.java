
package beauty_of_programming.com.chapter2.findone;
import java.util.Date;

import beauty_of_programming.com.cfg.config;

public class Factorial {
	//1.给定一个整数N，那么N的阶乘N!末尾有多少个0呢？
	public static int count1(int n){
		int sum=1;
		for(int i=1;i<=n;i++){
			sum *=i;
		}
		System.out.println(sum);
		int ret =0;
		int j=0;
		if(n<5){
			return 0;
		}
		for(int i=5;i<=n;i++){
			j=i;
			while(j%5==0){
				ret++;
				j/=5;
			}
		}
		return ret;
	}
	
	public static int count2(int n){
		int sum=1;
		for(int i=1;i<=n;i++){
			sum *=i;
		}
		System.out.println(sum);
		int ret =0;
		while(0<n){
			ret +=n/5;
			n=n/5;
			
		}
		
		return ret;
	}
	
	//求N！的二进制表示中最低位1的位置
	public static int lowestOne(int n){
		int ret=0;
		while(0<n){
         n=  n>>1;
		 ret +=n;
		}
		
		return ret;
	}
	
	//给定一个整数n，判断它是否为2的方幂
	public static boolean isSquare(int n){
		boolean flag=false;
		
		if(n>0&&((n&(n-1))==0)){
			flag =true;
			
		}
		
		return flag;
	}
	public static void main(String[] args) {
		System.out.println(config.sdf.format(new Date()));
		boolean num=isSquare(16);
		System.out.println(num);
		System.out.println(config.sdf.format(new Date()));
	}

}
