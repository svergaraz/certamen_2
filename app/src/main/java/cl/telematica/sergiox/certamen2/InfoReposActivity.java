package cl.telematica.sergiox.certamen2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InfoReposActivity extends AppCompatActivity {

    private String user;
    private RecyclerView recView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Repo> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_repos);

        user = this.getIntent().getExtras().getString("USER");

        //Adquisicion de los datos por el servicio de GIT



        recView = (RecyclerView) findViewById(R.id.RecView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recView.setLayoutManager(layoutManager);

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(Void... params) {
                //String url = "https://api.github.com/users/" + user + "/repos";
                String url = "http://www.mocky.io/v2/57eee3822600009324111202";
                return new HttpServerConnection().connectToServer(url, 15000);

            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    System.out.println(result);

                    // specify an adapter (see also next example)

                    adapter = new MyAdapter(InfoReposActivity.this, getLista(result));
                    recView.setAdapter(adapter);
                }
            }
        };

        task.execute();
    }

    private ArrayList<Repo> getLista(String result){
        ArrayList<Repo> listaRepos = new ArrayList<Repo>();
        try {
            JSONArray lista = new JSONArray(result);


            int size = lista.length();
            for(int i = 0; i < size; i++){

                JSONObject objeto = lista.getJSONObject(i);
                Repo repo = new Repo(objeto.getString("name"), objeto.getString("description"), objeto.getString("update_at"), objeto.getString("html_url"));



                listaRepos.add(repo);
            }
            return listaRepos;
        } catch (JSONException e) {
            e.printStackTrace();
            return listaRepos;
        }
    }
}
