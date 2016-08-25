package com.medapp.calculations;

import java.util.Arrays;
import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public class Maximum {

    public String countMaxOfDiabetic(List<DiabeticResults> listDiabetic) {
        int[] result = new int[listDiabetic.size()];

        for(int i=0; i<listDiabetic.size(); i++){
            result[i] = Integer.valueOf(listDiabetic.get(i).getResult());
        }
        Arrays.sort(result);
        String res = String.valueOf(result[listDiabetic.size()-1]);
        return res;
    }
    public String countMaxOfPressure(List<PressureResults> listPressure) {
        int[] result1 = new int[listPressure.size()];
        int[] result2 = new int[listPressure.size()];

        for(int i=0; i<listPressure.size(); i++){
            result1[i] = Integer.valueOf(listPressure.get(i).getSystolic());
            result2[i] = Integer.valueOf(listPressure.get(i).getDiastolic());
        }
        Arrays.sort(result1);
        Arrays.sort(result2);
        String res = result1[listPressure.size()-1]+"/"+result2[listPressure.size()-1];
        return res;
    }
}
