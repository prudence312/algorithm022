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
  //1、     2叉树，3叉树，n叉树（完全树）都可以用队列或堆以替换
  //2、     可以利用set特性进行高效率的排重
  //3、     也可以手动排重，因为二叉堆已经sort过了，所以重复的数字必然是连续的。
  //总结：以后不妨多花点时间在初期的base规律探索上，以免错过一些没想到的point。
    public static int nthUglyNumber(int n) { 
     if(n==1) {                              
    	 return 1;
     }

    	PriorityQueue<Long> queue=new PriorityQueue<Long>();
    	queue.offer((long) 2);
    	queue.offer((long) 3);
    	queue.offer((long) 5);
    	int count=1;
    	long res=0;
//    	HashSet<Integer> rec=new HashSet<Integer>();
    	while (count<n) {
    		res=queue.remove();
    		while(!queue.isEmpty()&&res==queue.peek()) {
    			queue.remove();
    		}
    		queue.offer(res*2);
        	queue.offer(res*3);
        	queue.offer(res*5);
//        	
//            if(rec.add(res)) {
//    		count++;
//    		}
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
