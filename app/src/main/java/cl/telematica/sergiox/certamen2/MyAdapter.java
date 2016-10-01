package cl.telematica.sergiox.certamen2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Sergiox on 30-09-2016.
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RepoViewHolder>{

    private ArrayList<Repo> datos;
    private static Activity act;

    public MyAdapter(Activity act, ArrayList<Repo> datos) { this.datos = datos; MyAdapter.act = act; }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_view, viewGroup, false);

        RepoViewHolder tvh = new RepoViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(RepoViewHolder viewHolder, int pos) {
        Repo item = datos.get(pos);

        viewHolder.bindRepo(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class RepoViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtDescripcion;
        private TextView txtActualizacion;
        private LinearLayout layRepo;

        public RepoViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtDescripcion = (TextView)itemView.findViewById(R.id.txtDescripcion);
            txtActualizacion = (TextView)itemView.findViewById(R.id.txtActualizacion);
            layRepo = (LinearLayout)itemView.findViewById(R.id.LayoutRepo);


        }

        public void bindRepo(final Repo t) {
            txtName.setText(t.getName());
            txtDescripcion.setText(t.getDescripcion());
            txtActualizacion.setText(t.getActualizacion());

            layRepo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(t.getUrl()));
                    act.startActivity(intent);
                }
            });
        }
    }

}
