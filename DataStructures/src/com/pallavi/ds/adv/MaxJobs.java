package com.pallavi.ds.adv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Job{
    Integer startTime;
    Integer endTime;
    Job(Integer startTime, Integer endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class MaxJobs {

	public static void main(String[] args) {
		
		System.out.println(solve(List.of(4,4,8,15,6), List.of(9,5,15,16,7)));
	}
	
	

    public static int solve(List<Integer> A, List<Integer> B) {
        List<Job> jobs = new ArrayList<Job>(A.size());
        int noOfJobs = 1;
        for(int i=0; i<A.size(); i++){
            jobs.add(new Job(A.get(i), B.get(i)));
        }
        
        for(int i=0; i<A.size(); i++){
            System.out.print(jobs.get(i).startTime+ "  ");
            System.out.println(jobs.get(i).endTime+ " , ");
        }
        
        Collections.sort(jobs, new Comparator<Job>() {
        	public int compare(Job j1, Job j2) {
        		return j1.endTime - j2.endTime;
        	}
		});
        
        System.out.println("\n\nAfter :  ");
        
        for(int i=0; i<A.size(); i++){
            System.out.print(jobs.get(i).startTime+ "  ");
            System.out.println(jobs.get(i).endTime+ " , ");
        }
        
        Job currnSelectedJob = jobs.get(0);
        
        for(int i=1; i<jobs.size();i++) {
        	
        	if(currnSelectedJob.endTime <= jobs.get(i).startTime) {
        		noOfJobs++;
        		currnSelectedJob = jobs.get(i);
        	}
        }
        
        
        
        return noOfJobs;
    }

}
