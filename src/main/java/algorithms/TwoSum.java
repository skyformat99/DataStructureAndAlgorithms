package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	private static final int RANDOM_ARRLEN = 100000000;
	private static final int RANDOM_MAX_VALUE = 90000000;
	private static final int BITMAP_MAXLEN = 0x20000000;			//2^29

	public static void main(String args[]){

//		int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 12, 11};
		int[] arr = new int[RANDOM_ARRLEN];
		for(int i = 0; i < RANDOM_ARRLEN; i++){
			arr[i] = (int)(Math.random() * RANDOM_MAX_VALUE);
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(Integer.BYTES * arr.length + "byte");

		//哈希表
//		int[] result = findTwoIntSumEqualsN(arr, 1005);
//		System.out.println("Hashmap result: " + Arrays.toString(result));

		//位图法
		int[] result2 = findTwoSumByBitmap(arr, 1005);
		System.out.println("Bitmap result: " + Arrays.toString(result2));
	}

	/**
	 * 数组A由1000万个随机正整数(int)组成，设计算法，给定整数n，在数组A中找出 a 和 b，使其符合：n = a + b
	 */
	public static int[] findTwoIntSumEqualsN(int[] arr, int n){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < arr.length; i++){
			int value = arr[i];
			if(value > n) continue;

			int complement = n - value;
			if(map.containsKey(complement)){
				System.out.println("Two indexes are: " + i + "," + map.get(complement));
				return new int[]{complement, value};
			}
			map.put(value, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 位图法
	 */
	public static int[] findTwoSumByBitmap(int[] arr, int n){
		byte bitmap[] = new byte[n / Byte.SIZE];

		for(int i = 0; i < arr.length; i++){
			int value = arr[i];
			if(value > n) continue;

			int complement = n - value;
			int exist = getBit(bitmap, complement);
			if(exist != 0){		//is exist
				return new int[]{complement, value};
			}
			setBit(bitmap, arr[i]);
		}
		throw new IllegalArgumentException("No two sum solution by bitmap.");
	}

	public static void setBit(byte bitmap[], int k){
		bitmap[k / Byte.SIZE] |= (1 << (k % Byte.SIZE));
	}

	public static int getBit(byte bitmap[], int k){
		return (bitmap[k / Byte.SIZE] & (1 << (k % Byte.SIZE)));
	}
}
