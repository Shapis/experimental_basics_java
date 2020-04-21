package com.shapisftw.experimentalbasics;

import java.util.ArrayList;

public class DoMath {

	// Single Variable Variables

	private double singleAverage;
	private double singleStandardDeviation;
	private ArrayList<TInput> singleInputArray = SingleInputFragment.itemsSingleInput;
	
	
	// Dual Variable Variables

	// Single Variable Math

	public double getSingleAvg() {
		double avg = 0;
		for (TInput i : singleInputArray) {
			avg = avg + i.getValue1();
		}
		avg = avg / singleInputArray.size();

		singleAverage = avg;
		return avg;
	}

	public double getSingleStandardDeviation() {
		double temp = 0;
		double sd = 0;
		for (TInput i : singleInputArray) {
			temp = (i.getValue1() - singleAverage)
					* (i.getValue1() - singleAverage);
			sd = sd + temp;
		}
		sd = sd / (singleInputArray.size() - 1);
		sd = Math.pow(sd, 0.5);

		singleStandardDeviation = sd;
		return sd;
	}

	public double getSingleAvgStandardDeviation() {
		double avgDeviation;
		avgDeviation = (singleStandardDeviation / (Math.pow(
				singleInputArray.size(), 0.5)));

		return avgDeviation;
	}

	// Dual Variable Math

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Return round value
/*
	public double roundSignificantValue(double valuePrimitive,
			double uncertaintyPrimitive) {
		double returnValue, temp, decimalPlaces;
		int i,j;
		temp = uncertaintyPrimitive;
		i = 0;
		decimalPlaces = 1;
		if (uncertaintyPrimitive < 1) {
			do {
				temp = temp * 10;
				i++;
			} while (temp < 1);
			
			for (j = 0 ; j < i; j++) {
				decimalPlaces = decimalPlaces*10;
			}
		}else if (uncertaintyPrimitive >= 10) {
			do {
				temp = temp / 10;
				i++;
			} while (temp > 1);
			for (j = 0 ; j < i; j++) {
				decimalPlaces = (decimalPlaces/10);
			}
		}
		returnValue = (double) Math.round(valuePrimitive * decimalPlaces) / decimalPlaces;
		return returnValue;

	}
	
	public double roundSingleValue(double value) {
		double returnValue;
		returnValue = (double) Math.round(value);
		return returnValue;
	}
	*/

}
