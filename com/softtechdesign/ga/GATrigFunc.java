package com.softtechdesign.ga;

import com.softtechdesign.ga.*;

public class GATrigFunc extends GAString
{
	static int[][] map;
    public GATrigFunc(int n,String poss) throws GAException
    {
        super(  n, //number of genes in chromosome
                50, //population of N chromosomes
                0.7, //crossover probability
                10, //random selection chance % (regardless of fitness)
                300, //stop after N generations
                0, //num prelim runs
                20, //max prelim generations
                0.003, //chromosome mutation prob.
                0, //number of decimal places in chrom (0 means treat chrom as integer)
                //if chrom has 7 genes and 6 decimal place, numbers look like "0.123456"
                poss, //gene space (possible gene values)
                Crossover.ctTwoPoint, //crossover type
                true); //compute statistics?
    }

    protected double getFitness(int iChromIndex)
    {
    	char[] gen=this.getChromosome(iChromIndex).getGenes();
    	double wartosc=0.0;
    	for(int i=0;i<map.length;i++){
    		if((gen[(map[i][1]-1)])==(gen[(map[i][2]-1)])){
    			
    			wartosc-=25;}
    	}
    	for(int i=0;i<gen.length;i++){
    		for(int ii=0;ii<map.length;ii++){
    			if(gen[i]==gen[ii])
    				wartosc+=1;
    		}
    	}
        
        
        return (wartosc);
    }

    
    public static int numberofgens(){
    	int max=map[0][1];
    	int i= map.length;
    	for(int n=0;n<i;n++){
    		if(max<(map[n][1])){
    
    			max=map[n][1];}
    		for( n=0;n<i;n++)
    			if(max<map[n][2]){max=map[n][2];}
    	}
    	return max;
    }
    public static String koloruj(int max)
    {
    	String s="";
    	char a='A';
    	for(int d=0;d<max;d++)
    	{	s+=a;
    		a++;
    	}
        
    	return s;
    }
    
    public static void main(String[] args)
    {

    	int [][] mape={{1,1,2},{2,2,3},{3,3,4},{4,4,5},{5,5,6},{6,6,7},{7,7,8},{8,8,1}};
    	
    	
    	
    	map=mape;
    	
    	int n=numberofgens();
    	String poscol=koloruj(n);
    	//System.out.println(n);
    	System.out.println(poscol);
    	
        System.out.println("GATrigFunc GA...");
        try
        {
            GATrigFunc trigFunc = new GATrigFunc(n,poscol);
            Thread threadTrigFunc = new Thread(trigFunc);
            threadTrigFunc.start();
        }
        catch (GAException gae)
        {
            System.out.println(gae.getMessage());
        }
    }

}