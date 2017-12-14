package org.spring.springboot.codewar;
/**
 *  You are going to be given an array of integers. 
 *  Your job is to take that array and find an index N where the sum of the integers to 
 *  the left of N is equal to the sum of the integers to the right of N. 
 *  If there is no index that would make this happen, return -1.
 *  @author yigang.wu
 *	@date 2017年11月17日 下午3:36:22
 *
 */
public class AllocatArray {
	
	public static int returnArray(int[] arr) {
		int length = arr.length;
		if(length == 1 || length == 2) {
			return -1;
		}
		for(int i = 0; i < length;i++) {
			if(i == 0 || i == length-1) {
				continue;
			}
			int leftTotal = 0;
			int rightTotal = 0;
			for(int j = 0;j < i; j++) {
				leftTotal = leftTotal + arr[j];
			}
			for(int k = i+1;k < length;k++) {
				rightTotal = rightTotal + arr[k];
			}
			if(leftTotal == rightTotal) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(returnArray(new int[] {1,1,1,1,1,1}));
	}
}
