package com.medapp.calculations;

import java.util.Arrays;
import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public class Mean {
	
    public String countMeanOfDiabetic(List<DiabeticResults> list) {
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = Integer.valueOf(list.get(i).getResult());
        }
        Arrays.sort(result);
        String meanResult = String.valueOf(mean(result));

        return meanResult;
    }

    public String countMeanOfPressure(List<PressureResults> list) {
        int[] result1 = new int[list.size()];
        int[] result2 = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result1[i] = Integer.valueOf(list.get(i).getSystolic());
            result2[i] = Integer.valueOf(list.get(i).getDiastolic());
        }
        Arrays.sort(result1);
        Arrays.sort(result2);
        String meanResult1 = String.valueOf(mean(result1));
        String meanResult2 = String.valueOf(mean(result2));

        return meanResult1+"/"+meanResult2;
    }

    public int mean(int[] m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i];
        }
        return sum / m.length;
    }
}
