package izzy.materialdesign403;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout refresh;
    ListView miLista;
    Adapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarBotonzuelo();

        refresh = (SwipeRefreshLayout)findViewById(R.id.refresh);
        miLista = (ListView)findViewById(R.id.miLista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        miLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        miLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        refresh.setRefreshing(false);
    }

    public void agregarBotonzuelo(){
        FloatingActionButton boton = (FloatingActionButton)findViewById(R.id.gatomarica);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), "Hola ratas", Toast.LENGTH_SHORT).show();
                Snackbar.make(v, "Ratas OwO", Snackbar.LENGTH_LONG)
                        .setAction("Opción extra", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("OwO", "G_G uwu");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}
