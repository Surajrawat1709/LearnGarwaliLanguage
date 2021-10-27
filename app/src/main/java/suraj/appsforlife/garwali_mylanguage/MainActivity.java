package suraj.appsforlife.garwali_mylanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);

        ArrayList<RecipeModal> list=new ArrayList<>();

        list.add(new RecipeModal(R.drawable.ler,"About Garwali"));
        list.add(new RecipeModal(R.drawable.ple,"Why to save Garhwali"));
        list.add(new RecipeModal(R.drawable.fami,"Family"));
        list.add(new RecipeModal(R.drawable.col,"Colours"));
        list.add(new RecipeModal(R.drawable.phr,"Phrases"));
        list.add(new RecipeModal(R.drawable.num,"Numbers"));
        list.add(new RecipeModal(R.drawable.ani,"Animals"));


        RecipeAdapter adapter=new RecipeAdapter(list,this);
        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new Recycleritem(this,recyclerView, new Recycleritem.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch(position){
                    case 0:
                    startActivity(new Intent(MainActivity.this,intro.class));
                    break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,save.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,FamilyActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,ColorsActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,PhrasesActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this,NumbersActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this,Animals.class));
                        break;
                    default:
            }}

            @Override
            public void onLongItemClick(View view, int position) {


            }
        }

        ));
    }
}