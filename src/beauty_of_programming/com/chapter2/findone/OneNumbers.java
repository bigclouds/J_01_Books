package beauty_of_programming.com.chapter2.findone;
//求二进制数中1的个数

public class OneNumbers {
	
	//利用除法,算法复杂度位log2v,即为二进制数的位数
	public static int count1(int v){
		int num=0;
		int i=0;
		while(0<v){
			i++;
			if(1==v%2){
				num++;
				System.out.println(i);
				
			}
			
			v= v/2;
			
		}
		return num;
	}
	
	//利用位操作，算法复杂度位log2v,即为二进制数的位数
	
	public static int count2(int v){
		int num=0;
		while(0<v){
			num+=v&0x01;
			v =v>>1;
		}
		
		return num;
	}
	
	//复杂度降低到O(m),m即为1的个数
	public static int count3(int v){
		int num=0;
		while(0<v){
			v &=(v-1);
			num++;
		}
		return num;
		
	}
	
	
	//使用分支操作，一个8bit的byte，只有255个数
	//用case既可以统计，255个分支，最多八个返回，因为最大num=8；
	//查表发
	//counttable[256]={0,1,1,2,1,2,2,3,1,......,7,7,8}
	//return counttable[v]
	
	//给定两个整数（二进制形式表示）A和B，问把A变成B需要改变多少位（bit）
	//	!-逻辑非
	//	&-逻辑与
	//	|-逻辑或
	//	^-逻辑异或
	//	&&-短路与
	//	||-短路或
	public static int count4(int A,int B){
		
		int num=0;
		int temp=Math.abs(A^B);
		System.out.println(temp);
		while(0<temp){
			temp =temp&(temp-1);
			num++;
			
		}
		return num;
	}
	
	public static void main(String[] args) {
		int num=count4(8,11);
		System.out.println(num);
	}

}
