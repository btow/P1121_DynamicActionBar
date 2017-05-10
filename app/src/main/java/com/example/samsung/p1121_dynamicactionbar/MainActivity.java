package com.example.samsung.p1121_dynamicactionbar;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private final int MENU_ID = 1;
    private int curFragment;

    private CheckBox chbAddDel, chbVisible;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
//    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbAddDel = (CheckBox) findViewById(R.id.chbAddDel);
        chbVisible = (CheckBox) findViewById(R.id.chbVisible);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

//        fragmentTransaction = getFragmentManager().beginTransaction();
        curFragment = 0;
//        fragmentTransaction.add(R.id.flCont, fragment1);
//        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.setGroupVisible(R.id.groupVsbl, chbVisible.isChecked());

        if (chbAddDel.isChecked()) {

            menu.add(0, MENU_ID, 0, R.string.item_1)
                    .setIcon(android.R.drawable.ic_delete)
                    .setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS
                            | MenuItem.SHOW_AS_ACTION_WITH_TEXT
                    );
        } else {
            menu.removeItem(MENU_ID);
        }
        return true;
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.chbAddDel :
            case R.id.chbVisible :
                invalidateOptionsMenu();
                break;
            case R.id.btnFrag :
                if (curFragment == 1) {
                    getFragmentManager().beginTransaction().replace(R.id.flCont, fragment2).commit();
                    curFragment = 2;
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.flCont, fragment1).commit();
                    curFragment = 1;
                }
                break;
            default :
                break;
        }
    }
}
