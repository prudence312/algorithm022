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
  //1��     2������3������n��������ȫ�����������ö��л�����滻
  //2��     ��������set���Խ��и�Ч�ʵ�����
  //3��     Ҳ�����ֶ����أ���Ϊ������Ѿ�sort���ˣ������ظ������ֱ�Ȼ�������ġ�
  //�ܽ᣺�Ժ󲻷��໨��ʱ���ڳ��ڵ�base����̽���ϣ�������һЩû�뵽��point��
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
