package beauty_of_programming.com.chapter2.findone;

import java.net.InterfaceAddress;

public class OneCounts {
	
	
	public static long countInaInteger(long n){
		long num=0;
	    while(n!=0){
	    	num +=(n%10==1)?1:0;
	    	n /=10;
	    }
	    return num;
	}
	
	//算法复杂度为o(n *logn)
	public static long  f(long n){
		long icount=0;
		for(int i =1;i<=n;i++){
			icount +=countInaInteger(i);
		}
		return icount;
	}
	 
	//给定一个十进制正整数N，写下从1开始到N的所有证书，然后数一下其中出现的所有“1”的个数
	public static int countOne(int n){
		int iCount=0;
		int iFactor=1;
		int iLowerNum=0,iCurrNum=0,iHigherNum=0;
		while(n/iFactor!=0){
			iLowerNum=n-(n/iFactor)*iFactor;
			iCurrNum =(n/iFactor)%10;
			iHigherNum=n/(iFactor*10);
			switch(iCurrNum){
			case 0:
				iCount +=iHigherNum*iFactor;
				break;
			case 1:
				iCount +=iHigherNum*iFactor+iLowerNum+1;
				break;
			default:
				iCount +=(iHigherNum+1)*100;
			
			}
			
			iFactor *=10;
			
		}
		
		return iCount;
			
				
	}
	
	public static void main(String[] args) {
		long count =f(12);
		
		System.out.println(count);
	}
	

}
