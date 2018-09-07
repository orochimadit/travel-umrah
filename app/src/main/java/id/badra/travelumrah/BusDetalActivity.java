package id.badra.travelumrah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import static id.badra.travelumrah.Bus.ExtraNama;
import static id.badra.travelumrah.Bus.ExtraSapMobile;
import static id.badra.travelumrah.Bus.ExtraIdTrip;
import static id.badra.travelumrah.MainActivity.ExtraTanggal;


public class BusDetalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_detal);
        Intent intent =getIntent();
        final String idTrip = intent.getStringExtra(ExtraIdTrip);
        final String Nama= intent.getStringExtra(ExtraNama);
        final String SapMobile = intent.getStringExtra(ExtraSapMobile);
//        String TargetJumlah = intent.getStringExtra(ExtraTarget_jumlah);
//        String HotelBintang = intent.getStringExtra(ExtraHotel_bintang);

        TextView textViewIdTrip = findViewById(R.id.text_view_id_trip);
        TextView textViewNama = findViewById(R.id.text_view_nama);
        TextView textViewSapMobile = findViewById(R.id.text_view_mobile);
        textViewIdTrip.setText("Id trip" +idTrip);
        textViewNama.setText("Nama "+Nama);
        textViewSapMobile.setText("No HP "+SapMobile);
    }
}
