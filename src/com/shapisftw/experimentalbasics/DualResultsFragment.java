package com.shapisftw.experimentalbasics;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DualResultsFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_dual_results,
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
	}
	
	private void writeSingleVariableResults() {
		
	}

}
