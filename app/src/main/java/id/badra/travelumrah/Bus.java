package id.badra.travelumrah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import id.badra.model.TripBusItem;

public class Bus extends AppCompatActivity implements TripBusAdapter.OnItemClickListener {
    public static final String ExtraIdTrip = "id_trip";
    public static final String ExtraNama = "nama_supir";
    public static final String ExtraSapMobile = "mobile";
//    public static final String ExtraTarget_jumlah="target_jumlah";
//    public static final String ExtraHotel_bintang = "hotel_bintang";
    private RecyclerView mRecyclerView;
    private TripBusAdapter mTripBusAdapter;
    private ArrayList<TripBusItem> mTripBusList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        Bundle bundle = getIntent().getExtras();
        String id_trip = bundle.getString("id_trip");
        //TextView textView = (TextView)findViewById(R.id.tampil);
        //textView.setText(id_trip);
        parseJson(id_trip);
    }

    private void parseJson(String id_trip){
        String url= "http://192.168.0.18/api/trip_bus.php?id_trip="+id_trip;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
//                JSONObject jsonObject = new JSONObject();
//                Iterator<String>iter= jsonObject.keys();

                try {
                    JSONArray jsonArray = response.getJSONArray("trip_bus");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject hit = jsonArray.getJSONObject(i);
                        String id_trip = hit.getString("id_trip");
                        String id_bus_booking = hit.getString("id_bus_booking");
                        String namaSopir = hit.getString("nama_sopir_ap");
                        String tanggalBooking = hit.getString("tanggal_booking");
                        String sap_mobile = hit.getString("sap_mobile");
                        String sap_email = hit.getString("sap_email");
                        String tanggal_ziarah_madinah = hit.getString("tanggal_ziarah_madinah");
                        String tanggal_ziarah_makkah = hit.getString("tanggal_ziarah_makkah");
                        String tanggalMadinahMakkah = hit.getString("tanggal_madinah_makkah");
                        String namaVendor = hit.getString("nama_vendor");
                        mTripBusList.add(new TripBusItem(id_bus_booking,id_trip, tanggalBooking, namaSopir,sap_mobile,
                                sap_email,tanggal_ziarah_makkah,tanggal_ziarah_madinah,tanggalMadinahMakkah,namaVendor));
//                    while(iter.hasNext()){
//                        String key =iter.next();
//                            try {
//                                Object tanggal=jsonObject.get("tanggal");
//                                Object creatorName=jsonObject.get("id_trip");
//                                Object route=jsonObject.get("route");
//                                Object target_jumlah=jsonObject.get("target_jumlah");
//                                Object route=jsonObject.get("hotel_bintang");
//                                mTripList.add(new TripItem(tanggal, creatorName,route,target_jumlah,hotel_bintang));
//                            }catch (JSONException e){
//                                e.printStackTrace();
//                            }
//
//                    }
                        //mTripBusAdapter = new TripBusAdapter(Bus.this, mTripBusList);
                        mRecyclerView.setAdapter(mTripBusAdapter);
                        mTripBusAdapter.setOnItemClickListener(Bus.this);
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );
        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this,BusDetalActivity.class);
        TripBusItem clickedTrip= mTripBusList.get(position);
        detailIntent.putExtra(ExtraIdTrip,clickedTrip.getMid_trip());
        detailIntent.putExtra(ExtraNama,clickedTrip.getMnama_supir_ap());
        detailIntent.putExtra(ExtraSapMobile,clickedTrip.getMsap_mobile());
        startActivity(detailIntent);
    }
}
