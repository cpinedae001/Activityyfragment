package com.umg.cpineda.activityyfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements DatosFragment.dataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String text) {
        /**
         * llamar al metodo renderizar texto del DeteilFragment
         * pasadole eltext por parametro
         * en este mismo metodo.
         * */
        //si osi hay que decirle que fracment casteando
        DetailsFragment detailsFragment = (DetailsFragment)
                getSupportFragmentManager().findFragmentById(R.id.detailFragment);
    detailsFragment.renderText(text);
    }
}
