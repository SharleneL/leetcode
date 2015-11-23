import java.util.Arrays;

/* 08-08-2015
 * 题意：两个排序好的arr，merge之。（暗示：将arr2插入到arr1中）
 * 思路：从后往前？
 * 经典算法：
 * 1. merge: line22-41
 * 2. java中如何将数组整个赋值给另一个数组
 * */
public class easy88 {
	public static void main(String args[]){
		int[] arr1 = {0, 0, 0};
		int[] arr2 = {1};
		merge(arr1, 1, arr2, 1);
		System.out.println(Arrays.toString(arr1));
	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(nums1==null || nums2==null) // special case
    		return;
    	
        int p = m+n-1; // tail pointer for the merged array
        int i=m-1, j=n-1;
        while(i>=0 || j>=0){
        	if(j<0)
        		return;
        	if(i<0){
        		System.arraycopy(nums2, 0, nums1, 0, j+1); // *copy the whole array
        		return;
        	}
        	
        	if(nums1[i]>=nums2[j]){
        		nums1[p] = nums1[i];
        		i--;
        		p--;
        	}else {
        		nums1[p] = nums2[j];
        		j--;
        		p--;
        	}
        }
    }
}


/*
 * java整个数组的赋值：System.arraycopy
 * 
 * public static void arraycopy(Object src,
                             	int srcPos,
                             	Object dest,
                             	int destPos,
                             	int length)
 * */
