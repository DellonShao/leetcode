package _215_KthLargestElementInAnArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    //快排思想、最小堆
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; ++i){
            if(i >= k && nums[i] > q.peek()){
                q.poll();
            }
            q.offer(nums[i]);
        }
        return q.peek();
    }

    public int findKthLargest1(int[] nums, int k) {
        topK(nums,0, nums.length - 1, k);
        return nums[k - 1];
    }
    public void topK(int[] nums, int left, int right, int k){
        if(left < right){
            int pos = partition(nums, left, right);
            if(pos == k - 1) return;
            else if(pos > k - 1){
                topK(nums, left, pos - 1, k);
            }else {
                topK(nums, pos + 1, right, k);
            }
        }
    }
    public int partition(int[] nums, int left, int right){
        int tmp = nums[left];
        while(left < right){
            while(left < right && tmp > nums[right]) --right;
            nums[left] = nums[right];
            while(left < right && tmp <= nums[left]) ++left;
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }

    int[] heap;
    int size = 1;
    public int findKthLargest2(int[] nums, int k) {
        heap = new int[k + 1];
        for(int e : nums){
            this.addE(e);
        }
        return heap[1];
    }
    public void addE(int e){
        if(this.size < heap.length){
            heap[size++] = e;
            this.siftUp(size - 1);
        }else if(e > heap[1]){
            heap[1] = e;
            this.siftDown(1);
        }
    }
    public void siftUp(int pos){
        int parent = pos / 2;
        while(parent >= 1 && heap[parent] > heap[pos]){
            heap[pos] ^= heap[parent];
            heap[parent] ^= heap[pos];
            heap[pos] ^= heap[parent];
            pos = parent;
            parent = pos  / 2;
        }
    }
    public void siftDown(int pos){
        int child = pos * 2;
        while(child <= heap.length - 1){
            if(child + 1 <= heap.length - 1 && heap[child + 1] < heap[child]){
                child = child + 1;
            }
            if(heap[pos] > heap[child]){
                heap[pos] ^= heap[child];
                heap[child] ^= heap[pos];
                heap[pos] ^= heap[child];
                pos = child;
                child = pos * 2;
            }else{
                break;
            }
        }
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().findKthLargest2(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}