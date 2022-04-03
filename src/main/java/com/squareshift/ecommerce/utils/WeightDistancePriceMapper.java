package com.squareshift.ecommerce.utils;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.stereotype.Component;

@Component
public class WeightDistancePriceMapper {

    static Table<Double, Integer, Double> treeBasedTable = HashBasedTable.create();

    static {

        treeBasedTable.put(2.0, 5, 12.00);
        treeBasedTable.put(2.0, 20, 15.00);
        treeBasedTable.put(2.0, 50, 20.00);
        treeBasedTable.put(2.0, 500, 50.00);
        treeBasedTable.put(2.0, 800, 100.00);
        treeBasedTable.put(2.0, 801, 220.00);

        treeBasedTable.put(5.0, 5, 14.00);
        treeBasedTable.put(5.0, 20, 18.00);
        treeBasedTable.put(5.0, 50, 24.00);
        treeBasedTable.put(5.0, 500, 55.00);
        treeBasedTable.put(5.0, 800, 110.00);
        treeBasedTable.put(5.0, 801, 250.00);

        treeBasedTable.put(20.00, 5, 16.00);
        treeBasedTable.put(20.00, 20, 25.00);
        treeBasedTable.put(20.00, 50, 30.00);
        treeBasedTable.put(20.00, 500, 80.00);
        treeBasedTable.put(20.00, 800, 130.00);
        treeBasedTable.put(20.00, 801, 270.00);

        treeBasedTable.put(20.01, 5, 21.00);
        treeBasedTable.put(20.01, 20, 35.00);
        treeBasedTable.put(20.01, 50, 50.00);
        treeBasedTable.put(20.01, 500, 90.00);
        treeBasedTable.put(20.01, 800, 150.00);
        treeBasedTable.put(20.01, 801, 300.00);


    }

    public double getPrice(Double weight, Integer distance) {

            double wght =  findWeight(weight);
            int dist =  findDistance(distance);
            double value =treeBasedTable.get(wght,dist);
            return  value;
    }
    
    private double findWeight(double weight){
        if(weight <=2){
            return 2.0;
        } 
        if(weight >=2.01 && weight <=5){
            return 5.0;
        }
        if(weight >=5.01 && weight <=20.00){
            return 20.00;
        }
        if(weight >=20.01){
            return 20.01;
        }
        return 0.0;
    }

    private int findDistance(int distance){
        if(distance < 5) {
            return 5;
        }
        if(distance >= 5 && distance < 20) {
            return 20;
        }
        if(distance >= 20 && distance < 50) {
            return 50;
        }
        if(distance >= 50 && distance < 500) {
            return 500;
        }
        if(distance >= 500 && distance < 800) {
            return 800;
        }
        if(distance > 800) {
            return 801;
        }
        return 0;
    }
}


