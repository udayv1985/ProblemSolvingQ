package com.uday.design.patterns;

import java.io.File;

public class StrategyPattern {
	
	interface Compression<T>{
		
		public void compress(T t);
		
	}
	
	class ZipCompression implements Compression<File>{

		@Override
		public void compress(File t) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class RarCompression implements Compression<File>{

		@Override
		public void compress(File t) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class Application{
		
		Compression<File> c; 
		
		public void setCompressionType(Compression<File> c){
			this.c=c;
		}
		
		public void createArchive(File f){
			c.compress(f);
		}
	}
	

}
