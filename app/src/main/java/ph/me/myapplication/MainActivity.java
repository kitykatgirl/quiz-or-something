package ph.me.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
private Button buttonNastepne;
private Button buttonPodpowiedz;
private TextView textViewPytanie;
private ImageView imageViewPytanie;
private int punkty = 0, pytanieLicznik = 0;

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

        buttonNie = findViewById(R.id.buttonNie);
        buttonTak = findViewById(R.id.buttonTak);
        buttonNastepne = findViewById(R.id.buttonNastepne);
        buttonPodpowiedz = findViewById(R.id.buttonPodpowiedz);
        textViewPytanie = findViewById(R.id.textView2);
        imageViewPytanie = findViewById(R.id.imageView3);

        WyswietlPytanie(pytanieLicznik);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pytanieLicznik++;
                        if (pytanieLicznik < pytania.size()){
                            WyswietlPytanie(pytanieLicznik);
                        }
                        else {
                            Koniec();
                        }
                    }
                }
        );

        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SprawdzPytanie(pytanieLicznik,true);
                    }
                }
        );

        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SprawdzPytanie(pytanieLicznik,false);
                    }
                }
        );

        buttonPodpowiedz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        WyswietlPodpowiedz(pytanieLicznik);
                    }
                }
        );
    }
    private void WyswietlPytanie(int ktorePytanie){
        textViewPytanie.setText(pytania.get(ktorePytanie).getTrescPytania());
        imageViewPytanie.setImageResource(pytania.get(ktorePytanie).getIdObrazek());
        buttonTak.setVisibility(View.VISIBLE);
        buttonNie.setVisibility(View.VISIBLE);
    }
    private void SprawdzPytanie(int licznikPytania, boolean bool){
        if (bool == pytania.get(licznikPytania).getOdpowiedz()){
            pytania.get(licznikPytania).setCzyOdpOK(true);
            Toast.makeText(this, "Udzielono poprawnej odpowiedz", Toast.LENGTH_SHORT).show();
            punkty++;
        }
        else {
            pytania.get(licznikPytania).setCzyOdpOK(false);
            Toast.makeText(this, "Nie udzielono poprawnej odpowiedz", Toast.LENGTH_SHORT).show();
        }
        buttonTak.setVisibility(View.INVISIBLE);
        buttonNie.setVisibility(View.INVISIBLE);
    }
    private void WyswietlPodpowiedz(int licznikPytania){
        Toast.makeText(this, pytania.get(licznikPytania).getPodpowiedzi(), Toast.LENGTH_SHORT).show();
    }
    private void Koniec(){
        textViewPytanie.setText("Koniec... Uzyskales " + punkty + "pkt");
        imageViewPytanie.setImageResource(R.drawable.swagger);
        buttonTak.setVisibility(View.INVISIBLE);
        buttonNie.setVisibility(View.INVISIBLE);
        buttonPodpowiedz.setVisibility(View.INVISIBLE);
        buttonNastepne.setVisibility(View.INVISIBLE);
    }
}

