package com.medapp.calculations;

import java.util.Arrays;
import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public class Median {
	
    public String countMedianOfPressure(List<PressureResults> list){
        int[] result1 = new int[list.size()];
        int[] result2 = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            result1[i] = Integer.valueOf(list.get(i).getSystolic());
            result2[i] = Integer.valueOf(list.get(i).getDiastolic());
        }
        Arrays.sort(result1);
        Arrays.sort(result2);

        String medianResult1 = String.valueOf(median(result1));
        String medianResult2 = String.valueOf(median(result2));

        return medianResult1+"/"+medianResult2;
    }

    public String countMedianOfDiabebetic(List<DiabeticResults> list){
        int[] result = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            result[i] = Integer.valueOf(list.get(i).getResult());
        }
        Arrays.sort(result);
        String medianResult = String.valueOf(median(result));

        return medianResult;
    }

    public int median(int[] table){
        int middle1 = table.length/2;
        if (table.length%2 == 1) {
            return table[middle1];
        } else {
            return (table[middle1-1] + table[middle1]) / 2;
        }
    }
}
