package com.shapisftw.experimentalbasics;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SingleResultsFragment extends Fragment {
	
	private TextView textViewSingleVariableResults;
	private double singleVariableAverage;
	private double singleVariableStandardDeviation;
	private double singleVariableAvgStandardDeviation;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_single_results,
				container, false);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		executeMath();
		writeSingleVariableResults();
	}
	
	
	private void executeMath() {
		DoMath doMath1 = new DoMath();
		singleVariableAverage = doMath1.getSingleAvg();
		singleVariableStandardDeviation = doMath1.getSingleStandardDeviation();
		singleVariableAvgStandardDeviation = doMath1.getSingleAvgStandardDeviation();
	}
	
	private void writeSingleVariableResults() {
		textViewSingleVariableResults = (TextView) getView().findViewById(R.id.textViewSingleVariable);
		textViewSingleVariableResults.setText(getString(R.string.single_results_text1) + " = " 
		+ SingleInputFragment.itemsSingleInput.size() +
				getString(R.string.single_results_text2) + " = " + singleVariableAverage + 
				getString(R.string.single_results_text3) + " = " + singleVariableStandardDeviation + 
				getString(R.string.single_results_text4) + " = " + singleVariableAvgStandardDeviation);
	}
	

}
