package com.umg.cpineda.activityyfragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DatosFragment extends Fragment {
    private EditText editTextData;
    private Button buttonSend;
    private dataListener callback;
    public DatosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
        callback= (dataListener) context;
        }catch (Exception e){

            System.out.println("error en el onAttach del dataFragment dataListener");
            e.printStackTrace();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_datos, container,false);
        //lógica de captura de los elementos.
        editTextData = view.findViewById(R.id.editTextData);
        buttonSend = view.findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSend = editTextData.getText().toString();
                callback.sendData(textToSend);
                //sendText(editTextData.getText().toString());
            }
        });

        return view;
    }

    private void sendText(String text){
    callback.sendData(text);
    }

    public interface dataListener{
        void sendData(String text);
    }

}
