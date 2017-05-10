package twosum;



public class Solution {

	public static int[] twoSum(int[] numbers, int target) {
		int index[] = { -1, -1 };

		for (int i = 0; i < numbers.length; i++) {
			int tem = target - numbers[i];

			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] == tem) {
					index[0] = i;
					index[1] = j;
				}
			}

		}

		return index;
	}
	
	
	   public static void main(String[] args) {
			int test[]={2,7,11,15};
			int result[]=new int[2];
			result=Solution.twoSum(test, 17);
			System.out.println(result[0]+","+result[1]);
		}
}
