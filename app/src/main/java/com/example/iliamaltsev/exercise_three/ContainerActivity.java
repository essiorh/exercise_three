package com.example.iliamaltsev.exercise_three;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Type;
import java.net.Proxy;


public class ContainerActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnNull;
    private Button btnClear;
    public static final int CHOOSE_THIEF = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        btnNull = (Button) findViewById(R.id.set_null);
        btnClear = (Button) findViewById(R.id.set_clear);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        btnNull.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        /*FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setCustomAnimations(R.animator.animator, R.animator.animator_end);
        fragmentTransaction.add(R.id.one, ImageFragment.newInstance("1", "FIT_XY"), "1");
        fragmentTransaction.commit();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_container, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ContainerActivity.this, ChangeActivity.class);

        switch (v.getId()) {
            case R.id.set_null:
                for (int i = 1; i <= 6; i++) {

                    Fragment fragment = getFragmentManager().findFragmentByTag(String.valueOf(i));
                    if(fragment != null)
                        getFragmentManager().beginTransaction().setCustomAnimations(R.animator.animator, R.animator.animator_end).remove(fragment).commit();
                }
                break;
            case R.id.set_clear:
                for (int i = 1; i <= 6; i++) {
                    Fragment fragment = getFragmentManager().findFragmentByTag(String.valueOf(i));
                    String s = fragment.getClass().getSimpleName();
                    fragment.getView().findViewById(R.id.change_text).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
                break;
            case R.id.one:
                intent.putExtra("id_container", 1);
                break;
            case R.id.two:
                intent.putExtra("id_container", 2);
                break;
            case R.id.three:
                intent.putExtra("id_container", 3);
                break;
            case R.id.four:
                intent.putExtra("id_container", 4);
                break;
            case R.id.five:
                intent.putExtra("id_container", 5);
                break;
            case R.id.six:
                intent.putExtra("id_container", 6);
                break;
        }
        if ((v.getId()!=R.id.set_null)&&(v.getId()!=R.id.set_clear)){
            startActivityForResult(intent, CHOOSE_THIEF);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode!=RESULT_OK) {
            return;
        } else{
            int idCont = data.getIntExtra(getString(R.string.id_container),0);
            int idFrag =data.getIntExtra(getString(R.string.id_fragment),0);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setCustomAnimations(R.animator.animator, R.animator.animator_end);
            fragmentTransaction.commit();
            switch (idFrag){
                case 1:
                    fragmentTransaction.add(intToResoursId(idCont), ImageFragment.newInstance(Integer.toString(idCont), "FIT_XY"), Integer.toString(idCont));
                    break;
                case 2:
                    fragmentTransaction.add(intToResoursId(idCont), TwoFragment.newInstance(Integer.toString(idCont), "FIT_XY"), Integer.toString(idCont));
                    break;
                case 3:
                    fragmentTransaction.add(intToResoursId(idCont), ThreeFragment.newInstance(Integer.toString(idCont), "FIT_XY"), Integer.toString(idCont));
                    break;
                case 4:
                    fragmentTransaction.add(intToResoursId(idCont), ImageFragment.newInstance(Integer.toString(idCont), "FIT_XY"), Integer.toString(idCont));
                    break;
                case 5:
                    fragmentTransaction.add(intToResoursId(idCont), ImageFragment.newInstance(Integer.toString(idCont), "FIT_XY"), Integer.toString(idCont));
                    break;

            }
        }

    }
    private int intToResoursId(int i){
        switch (i){
            case 1:
                return R.id.one;
            case 2:
                return R.id.two;
            case 3:
                return R.id.three;
            case 4:
                return R.id.four;
            case 5:
                return R.id.five;
            case 6:
                return R.id.six;
            default:
                return 0;
        }
    }
}
