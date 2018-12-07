package com.uday.dst.concepts;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ConsistentHashing<T> {
	
	static class HashingMethod{
		
		public Long getHash(String s){
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
			    md.update(s.getBytes(),0,s.length());
			   return new BigInteger(1,md.digest()).longValue();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0l;
		}
	}
	
	int numberOfReplicas; 
	
	SortedMap<Long,T> circle; 
	
	HashingMethod hashingMethod; 
	
	public ConsistentHashing(){
		
	}
	
	public void add(T node){
		for(int i = 0; i<numberOfReplicas; i++){
			circle.put(hashingMethod.getHash(node.toString()+i), node);
		}
	}
	
	public T getNode(String req){
		if(circle.isEmpty()){
			return null;
		}
		else{
			Long searchHash = hashingMethod.getHash(req);
			Long nodeHash = null;
			if(null==circle.get(searchHash)){
				if(null!=circle.tailMap(searchHash)){
					nodeHash = circle.tailMap(searchHash).firstKey();
				}
				else{
					nodeHash = circle.firstKey();
				}		 
			}
			else{
				nodeHash = searchHash;
			}
			return circle.get(nodeHash);
		}
	}

}
