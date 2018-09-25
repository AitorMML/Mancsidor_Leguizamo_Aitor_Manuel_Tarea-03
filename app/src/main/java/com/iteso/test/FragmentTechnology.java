package com.iteso.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.test.Beans.ItemProduct;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTechnology extends Fragment {

    public RecyclerView.Adapter adapter;
    public RecyclerView.LayoutManager layoutManager;

    public FragmentTechnology() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView)
                view.findViewById(R.id.fragment_technology_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        ArrayList<ItemProduct> myDataSet = new ArrayList<ItemProduct>();
        ItemProduct itemProduct = new ItemProduct();
        itemProduct.setTitle("MacBook Pro 17"); //R.string.Title_1);
        itemProduct.setStore("BestBuy"); //R.string.Store_1);
        itemProduct.setLocation("Zapopan, Jalisco"); //R.string.Location_1);
        itemProduct.setPhone("33 12345678"); //R.string.Phone_1);
        itemProduct.setImage(0);
        itemProduct.setDescription("Llevate esta Mac con un 30% de descuento para que\n" +
                " puedas programar para XCode y Android sin tener que batallar tanto como en tu\n" +
                " Windows"); //R.string.Description_1);

        myDataSet.add(itemProduct);
        adapter = new AdapterProduct(getActivity(), myDataSet);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
