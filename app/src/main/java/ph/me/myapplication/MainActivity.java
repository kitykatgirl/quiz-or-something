package ph.me.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ArrayList<Pytanie> pytania = new ArrayList<>();
private Button buttonTak;
private Button buttonNie;
private TextView textViewPytanie;
private ImageView imageViewPytanie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pytania.add(new Pytanie("czy ten kot ma swag",R.drawable.swag_incarnate,true,"no pomysl, to oczywiste"));
        pytania.add(new Pytanie("czy ten kot ma niebieskie okulary",R.drawable.sideyeorsomething,false,"no cmon, jestem zawiedziony"));
        pytania.add(new Pytanie("czy ten kot jest inwestorem Wall St.",R.drawable.check_this,true,"to jest miliarder"));
        pytania.add(new Pytanie("czy ten dziadek trzyma airpodsy",R.drawable.airpod,false,"to aparaty sluchowe"));
    }
}

