package com.oneapm.research.correlation;

import com.oneapm.research.correlation.web.model.IndependentNum;
import java.util.ArrayList;
import java.lang.Math;



/** 
 * @author alan-king 
 * 
 */  
public class PearsonCoefficientCalculate {  
      
	public static double calculatePearson(ArrayList<Double> xList, ArrayList<Double> yList){
        double denominator = calculateDenominator(xList, yList);
        if(denominator < 1e-4) {
            return Double.NaN;
        }
        else
		    return  calculateNumerator(xList, yList)/denominator;
	}
	
    public static double calculateDenominator(ArrayList<Double> xList, ArrayList<Double> yList){  
        int size = xList.size();
        double xAverage = 0.0;  
        double yAverage = 0.0;  
        double xException = 0.0;  
        double yException = 0.0;  
        double temp = 0.0;  
        for(int i=0;i<size;i++){  
            temp += xList.get(i);  
        }  
        xAverage = temp/size;  
          
        for(int i=0;i<size;i++){  
            temp += yList.get(i);  
        }  
        yAverage = temp/size;  
          
        for(int i=0;i<size;i++){  
            xException += Math.pow(xList.get(i)-xAverage, 2);  
            yException += Math.pow(yList.get(i)-yAverage, 2);  
        }  
        //calculate denominator of   
        return Math.sqrt(xException*yException);
    }
    
    public static double calculateNumerator(ArrayList<Double> xList, ArrayList<Double> yList){  
        double result =0.0;  
        double xAverage = 0.0;  
        double temp = 0.0;  
          
        int xSize = xList.size();  
        for(int x=0;x<xSize;x++){  
            temp += xList.get(x);  
        }  
        xAverage = temp/xSize;  
          
        double yAverage = 0.0;  
        temp = 0.0;  
        int ySize = yList.size();  
        for(int x=0;x<ySize;x++){  
            temp += yList.get(x);  
        }  
        yAverage = temp/ySize;  
          
        //double sum = 0.0;  
        for(int x=0;x<xSize;x++){  
            result+=(xList.get(x)-xAverage)*(yList.get(x)-yAverage);  
        }  
        return Math.abs(result);
    }
}  