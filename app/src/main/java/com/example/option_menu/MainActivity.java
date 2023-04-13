package com.example.option_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.option_menu.R;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    GridView gv;
    String fruits[] = {"apple","banana","cherry","orange","strawberry","pomegranate"};
    int fruit[] = {R.drawable.apple,R.drawable.banana,R.drawable.cherry,R.drawable.orange,R.drawable.strawberry, R.drawable.pomegranate};
    String electronics[] = {"pendrive","phone","ssd","headset","camera"};
    int elec[] = {R.drawable.pendrive,R.drawable.phone,R.drawable.ssd,R.drawable.headset,R.drawable.camera};
    String clothing[] = {"Dress","Kurtha","Lehanga","Jeans","T-shirts","Tops"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        gv = findViewById(R.id.gv);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.fruits) {
            lv.setAdapter(new MyAdapter(MainActivity.this));
            lv.setVisibility(View.VISIBLE);
            gv.setVisibility(View.INVISIBLE);
        }
        if(item.getItemId()==R.id.electronics) {
            gv.setAdapter(new gridAdapter(MainActivity.this));
            gv.setNumColumns(2);
            gv.setVisibility(View.VISIBLE);
            lv.setVisibility(View.INVISIBLE);
        }
        if(item.getItemId()==R.id.clothing) {
            gv.setVisibility(View.INVISIBLE);
            lv.setVisibility(View.VISIBLE);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,clothing);
            lv.setAdapter(adapter);
            lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private class MyAdapter extends BaseAdapter {
        Context c;
        public MyAdapter(MainActivity mainActivity) {
            c = mainActivity;
        }
        @Override
        public int getCount() {
            return fruit.length;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View View, ViewGroup viewGroup) {
            View view1 = LayoutInflater.from(c).inflate(R.layout.fruits,viewGroup,false);
            ImageView img = view1.findViewById(R.id.ivf);
            TextView t1 = view1.findViewById(R.id.tvf);
            img.setImageResource(fruit[i]);
            t1.setText(fruits[i]);
            return view1;
        }
    }
    private class gridAdapter extends BaseAdapter {
        Context c;
        public gridAdapter(MainActivity mainActivity) {
            c = mainActivity;
        }
        @Override
        public int getCount() {
            return electronics.length;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View View, ViewGroup viewGroup) {
            View view2 = LayoutInflater.from(c).inflate(R.layout.electronics,viewGroup,false);
            ImageView img2 = view2.findViewById(R.id.ive);
            TextView t2 = view2.findViewById(R.id.tve);
            img2.setImageResource(elec[i]);
            t2.setText(electronics[i]);
            return view2;
        }
    }
}