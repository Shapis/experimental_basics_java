package com.shapisftw.experimentalbasics;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class DualInputFragment extends Fragment {
	
	protected static ArrayList<TInput> itemsDualInput  = new ArrayList<TInput>();
	private ArrayList<String> displayItemsDualInput = new ArrayList<String>();
	private ArrayAdapter<String> displayItemsAdapterDualInput;
	private ListView listViewDualInput;
	private String unitType1;
	private String unitType2;
	private double uncertainty1;
	private double uncertainty2;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_dual_input,
				container, false);
		assignBtnListeners(rootView);
		return rootView;
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//showUnitUncertaintyFragmentPopUp();
		buildArrayLists();
		assignViews();
		requestFocus();
		assignListViewListener();
		
	}
	
	private void assignListViewListener() {
		listViewDualInput.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long rowId) {
				itemsDualInput.remove(position);
				displayItemsAdapterDualInput.notifyDataSetChanged();
				buildArrayLists();
				return true;
			}
		});
	}
	
	private void requestFocus() {
		EditText editTextAddNewDualInput1 = (EditText) getView().findViewById(R.id.editTextDualInput1);
		EditText editTextAddNewDualInput2 = (EditText) getView().findViewById(R.id.editTextDualInput2);
		String test1 = editTextAddNewDualInput1.getText().toString();
		String test2 = editTextAddNewDualInput2.getText().toString();
		if (test1.equals("")) {
		editTextAddNewDualInput1.requestFocus();
		}else if(test2.equals("")) {
			editTextAddNewDualInput2.requestFocus();
		}
	}
	
	private void assignViews() {
		listViewDualInput = (ListView) getView().findViewById(
				R.id.listViewDualInput);
		displayItemsAdapterDualInput = new ArrayAdapter<String>(this.getActivity(),
				android.R.layout.simple_list_item_1, displayItemsDualInput);
		listViewDualInput.setAdapter(displayItemsAdapterDualInput);
	}
	
	
	private void assignBtnListeners(View rootView) {
		 Button btnAddSingleInput = (Button) rootView.findViewById(R.id.btnAddDualInput);
		 btnAddSingleInput.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		    	  addSingleInput();
		      }
		    });
		 Button btnResetSingleInput = (Button) rootView.findViewById(R.id.btnResetDualInput);
		 btnResetSingleInput.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View v) {
		    	  resetSingleInput();
		      }
		    });
		 
	}
	
	private void addSingleInput(){
		EditText editTextAddNewDualInput1 = (EditText) getView().findViewById(R.id.editTextDualInput1);
		EditText editTextAddNewDualInput2 = (EditText) getView().findViewById(R.id.editTextDualInput2);
		try{
		double value1 = Double.parseDouble(editTextAddNewDualInput1.getText().toString());
		double value2 = Double.parseDouble(editTextAddNewDualInput2.getText().toString());
		unitType1 = "Unidade1";
		unitType2 = "Unidade2";
		uncertainty1 = 0;
		uncertainty2 = 0;
		TInput i = new TInput("default", unitType1, unitType2, 0, value1, value2, uncertainty1, uncertainty2);
		itemsDualInput.add(i);
		buildArrayLists();
		displayItemsAdapterDualInput.notifyDataSetChanged();
		editTextAddNewDualInput1.setText("");
		editTextAddNewDualInput2.setText("");
		requestFocus();
		//Toast.makeText(getActivity(), getString(R.string.single_input_added) ,Toast.LENGTH_SHORT).show();
		}catch(Exception e) {
			//Toast.makeText(getActivity(), getString(R.string.single_input_added) ,Toast.LENGTH_SHORT).show();
			requestFocus();
			//editTextAddNewDualInput1.setText("");
			//editTextAddNewDualInput2.setText("");
		}
		listViewDualInput.setSelection(itemsDualInput.size());
	}
	
	private void resetSingleInput() {
		itemsDualInput.clear();
		buildArrayLists();
		displayItemsAdapterDualInput.notifyDataSetChanged();
		requestFocus();
	}
	
	private void buildArrayLists() {
		displayItemsDualInput.clear();
		int k = 1;
		//buildRoundedArrayList();
		for (TInput i: itemsDualInput) {
			i.setId(k);
			displayItemsDualInput.add(i.getId() +".\t\t" +"( " + i.getValue1() + " \u00B1 " + i.getUncertainty1() + " )" + "\t\t" + "( " + i.getValue2() + " \u00B1 " + i.getUncertainty2() + " )");
			k++;
	}
	
	}

}

