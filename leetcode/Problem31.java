package leetcode;

public class Problem31 {

    public static void main(String[] args) {
        int[] numbers = {3,4,1,4,3,3};
        Problem31 problem31 =  new Problem31();
        problem31.nextPermutation(numbers);
        for(int number: numbers) System.out.println(number);
    }
    public void nextPermutation(int[] nums) {
        boolean isPossible = false;
        if(nums == null || nums.length < 2 ) return;
        int swapIndex = 0;
        int swappableIndex = 0;
        for(int i = 1 ; i < nums.length; i++){
            if(isPossible && nums[swappableIndex] < nums[i] && nums[swapIndex] > nums[i]) {
                swapIndex = i;
            }
            if(nums[i] > nums[i-1]) {
                swapIndex = i;
                swappableIndex = i-1;
                isPossible = true;
            }
        }
        if(isPossible) {
            int tmp = nums[swappableIndex];
            nums[swappableIndex] = nums[swapIndex];
            nums[swapIndex] = tmp;
            mergeSort(nums, swappableIndex + 1, nums.length-1);
        } else {
            //sort an array
            reverseSort(nums);
        }
    }

    public void reverseSort(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            i++;
            j--;
        }
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left < right)
        {
            int m = left+(right-left)/2;
            mergeSort(nums, left, m);
            mergeSort(nums, m+1, right);

            merge(nums, left, m, right);
        }
    }

    public void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
