package id.badra.travelumrah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static id.badra.travelumrah.MainActivity.ExtraHotel_bintang;
import static id.badra.travelumrah.MainActivity.ExtraIdTrip;
import static id.badra.travelumrah.MainActivity.ExtraRoute;
import static id.badra.travelumrah.MainActivity.ExtraTanggal;
import static id.badra.travelumrah.MainActivity.ExtraTarget_jumlah;

public class DetailActivity extends AppCompatActivity {

    private Button btn_jamaah,btn_katering,btn_bus,btn_hotel,btn_airline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent =getIntent();
        final String idTrip = intent.getStringExtra(ExtraIdTrip);
        String Tanggal= intent.getStringExtra(ExtraTanggal);
        String Route = intent.getStringExtra(ExtraRoute);
        String TargetJumlah = intent.getStringExtra(ExtraTarget_jumlah);
        String HotelBintang = intent.getStringExtra(ExtraHotel_bintang);

        TextView textViewIdTrip = findViewById(R.id.text_view_id_trip);
        TextView textViewTanggal = findViewById(R.id.text_view_tanggal);
        TextView textViewRoute = findViewById(R.id.text_view_route);
        TextView textViewTargetJumlah = findViewById(R.id.text_view_target_jumlah);
        TextView textViewHotelBintang = findViewById(R.id.text_view_hotel_bintang);

        textViewIdTrip.setText("id Trip "+idTrip);
        textViewRoute.setText("Route "+Route);
        textViewTanggal.setText("Tanggal Keberangkatan "+Tanggal);
        textViewTargetJumlah.setText("Target "+TargetJumlah);
        textViewHotelBintang.setText("Hotel Bintang "+HotelBintang);
        btn_bus = (Button)findViewById(R.id.btn_bus);
        btn_airline = (Button)findViewById(R.id.btn_airline);
        btn_hotel = (Button)findViewById(R.id.btn_hotel);
        btn_jamaah = (Button)findViewById(R.id.btn_jamaah);
        btn_katering = (Button)findViewById(R.id.btn_katering);

        btn_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent busIntent = new Intent(DetailActivity.this,Bus.class);
                busIntent.putExtra("id_trip",idTrip);
                startActivity(busIntent);
            }
        });
        btn_jamaah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jamaahIntent= new Intent(DetailActivity.this,JamaahActivity.class);
                jamaahIntent.putExtra("id_trip",idTrip);
                startActivity(jamaahIntent);
            }
        });

        btn_airline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent airlineIntent = new Intent(DetailActivity.this,AirlineActivity.class);
                airlineIntent.putExtra("id_trip",idTrip);
                startActivity(airlineIntent);
            }
        });

        btn_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelIntent = new Intent(DetailActivity.this,HotelActivity.class);
                hotelIntent.putExtra("id_trip",idTrip);
                startActivity(hotelIntent);
            }
        });
        btn_katering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kateringIntent= new Intent(DetailActivity.this,KateringActivity.class);
                 kateringIntent.putExtra("id_trip",idTrip);
                 startActivity(kateringIntent);
            }
        });
    }
}
