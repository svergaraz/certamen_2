package cl.telematica.sergiox.certamen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private EditText edit;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.title_inicio);
        edit = (EditText)findViewById(R.id.edit_inicio);
        btn = (Button)findViewById(R.id.btn_inicio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoReposActivity.class);

                Bundle b = new Bundle();
                b.putString("USER", edit.getText().toString());

                intent.putExtras(b);

                startActivity(intent);
            }
        });
    }
}
