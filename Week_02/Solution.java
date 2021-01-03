package w2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(i==0) {
        		m.put(nums[i], 1);
        	}else {
        		if(!m.containsKey(nums[i])) {
        			m.put(nums[i], 1);
        		}else {
        			int curCount=m.get(nums[i]);
        			m.put(nums[i], curCount+1);
        		}
        	}
        }
        

        
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<Map.Entry<Integer,Integer>>((o1,o2)->{
        	return o2.getValue()-o1.getValue();
        });
   
        
       for(Map.Entry<Integer,Integer>en:m.entrySet()) {
    	   queue.offer(en);
       }
       int[] res=new int[k];
        for(int i=0;i<k;i++) {
           res[i]=queue.remove().getKey(); 	
        }
		return res;
    }

    public static int nthUglyNumber(int n) { 
		PriorityQueue<Long> queue=new PriorityQueue<Long>();
        queue.offer((long) 1);
    	int count=0;
    	long res=0;
    	HashSet<Long> rec=new HashSet<Long>();
    	while (count<n) {
    		res=queue.remove();
    		if(!rec.contains(res*2)) {
    			rec.add(res*2);
    			queue.offer(res*2);
    		}
    		if(!rec.contains(res*3)) {
    			rec.add(res*3);
    			queue.offer(res*3);
    		}
    		if(!rec.contains(res*5)) {
    			rec.add(res*5);
    			queue.offer(res*5);
    		}
        	count++;
    		
    	}
    	return (int) res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		System.out.println(nthUglyNumber(10)); 
	}

}
