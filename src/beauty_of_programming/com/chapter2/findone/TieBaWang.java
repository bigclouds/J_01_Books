package beauty_of_programming.com.chapter2.findone;

//贴吧水王，发帖的数目超过了帖子总数的一般，如果你有一个当前论坛所有帖子的列表，其中帖子的坐着id也在列表中，你能快速找出这个传说中的水王吗？
//每次删除两个不同的ID，那么剩下的id列表中，“水王”id出现的次数仍然超过总数的一般，可以通过不断重复这个过程，把id列表中的id数降低，从而得到答案，新思路避免了排序这个耗时的不走。总的时间复杂度只有O(N),且值需要常数的额外内存，

//这个题目体现了一个重要思想及时如何把问题转化为规模较小的若干个问题，分治，递归，贪心等都是基于这样的思路，在转化过程中，小的问题跟原问题本质一样。同样我们可以将小问题转化为更小的问题。因此，转化的过程是很重要的，像这个问题，我们保证了问题的解在小问题中仍然具有与与原问题相同的性质：水王id在id列表中的数量超过一半。
//转换的效率越高，转化之后问题规模缩小越快，则整体的时间复杂度越低。

public class TieBaWang {
	
	
	public static String Find(String[] idString,int n){
		String candidate=null;
		int ntimes,i;
		for(i=ntimes=0;i<n;i++){
			if(ntimes==0){
				candidate=idString[i];ntimes=1;				
				}
			else{
				if(candidate.equals(idString[i])){
					ntimes++;
				}
				else {
					ntimes--;
				}
			}
		}
		System.out.println(ntimes);
		return candidate;
	}
	
	
	//如果有三个id发的帖子数目都超过了总数的1/4.怎么找到这三个id
	
	public static String [] Find2(String [] idStrings,int n){
		String candidates[]={null,null,null};
		int ntimes[]={0,0,0};
		for(int i=0;i<n;i++){
			if(ntimes[0]==0){
				if(idStrings[i]==candidates[1]){
					ntimes[1]++;
				}
				else if(idStrings[i]==candidates[2]){
					ntimes[2]++;
				}
				else {
					candidates[0]=idStrings[i];
					ntimes[0]++;
				}
			}else if(ntimes[1]==0){
				if(idStrings[i]==candidates[0]){
					ntimes[0]++;
				}
				else if(idStrings[i]==candidates[2]){
					ntimes[2]++;
				}
				else {
					candidates[1]=idStrings[i];
					ntimes[1]++;
				}
			}else if(ntimes[2]==0){
				if(idStrings[i]==candidates[0]){
					ntimes[0]++;
				}
				else if(idStrings[i]==candidates[1]){
					ntimes[1]++;
				}
				else {
					candidates[2]=idStrings[i];
					ntimes[2]++;
				}
			}else{
				if(candidates[0]==idStrings[i])
					ntimes[0]++;
				else if(candidates[1]==idStrings[i])
					ntimes[1]++;
				else if(candidates[2]==idStrings[i])
					ntimes[2]++;
				else {
					ntimes[0]--;ntimes[1]--;ntimes[2]--;
				}
			}
		}
		for(int i=0;i<ntimes.length;i++){
			System.out.println(ntimes[i]+1);
		}
		return candidates;
	}
	
	public static void main(String[] args) {
		String [] idStrings ={"id001","id002","id003","id001","id001","id002","id002","id002","id004","id004","id004","id004"};
		String candidate=Find(idStrings,idStrings.length);
		//String [] candidates =Find2(idStrings, idStrings.length);
		
		System.out.println(candidate);
//		for(int i=0;i<candidates.length;i++){
//			System.out.println(candidates[i]);
//		}
		
	}

}
