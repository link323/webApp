package com.medapp.calculations;

import java.util.Arrays;
import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public class Minimum {
	
    public String countMinOfDiabetic(List<DiabeticResults> listDiabetic) {
        int[] result = new int[listDiabetic.size()];

        for(int i=0; i<listDiabetic.size(); i++){
            result[i] = Integer.valueOf(listDiabetic.get(i).getResult());
        }
        Arrays.sort(result);
        String res = String.valueOf(result[0]);
        return res;
    }

    public String countMinOfPressure(List<PressureResults> listPressure) {
        int[] result1 = new int[listPressure.size()];
        int[] result2 = new int[listPressure.size()];

        for(int i=0; i<listPressure.size(); i++){
            result1[i] = Integer.valueOf(listPressure.get(i).getSystolic());
            result2[i] = Integer.valueOf(listPressure.get(i).getDiastolic());
        }
        Arrays.sort(result1);
        Arrays.sort(result2);
        String res = String.valueOf(result1[0]+"/"+result2[0]);
        return res;
    }
}
