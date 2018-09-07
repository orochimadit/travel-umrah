package id.badra.travelumrah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements TripAdapter.OnItemClickListener {

    public static final String ExtraIdTrip = "id_trip";
    public static final String ExtraTanggal = "tanggal";
    public static final String ExtraRoute = "route";
    public static final String ExtraTarget_jumlah="target_jumlah";
    public static final String ExtraHotel_bintang = "hotel_bintang";
    private RecyclerView mRecyclerView;
    private TripAdapter mTripAdapter;
    private ArrayList<TripItem> mTripList;
    private RequestQueue mRequestQueue;

    TextView txt_id, txt_username;
    String id, username;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTripList = new ArrayList<>();
        mRequestQueue= Volley.newRequestQueue(this);
        parseJson();
    }
    private void parseJson(){
        String url= "http://192.168.0.17/api/trip.php?id_user=1";
//        String url= "http://192.168.100.104/api/trip.php?id_user=1";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
//                JSONObject jsonObject = new JSONObject();
//                Iterator<String>iter= jsonObject.keys();
                try {
                    JSONArray jsonArray = response.getJSONArray("trip");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject hit = jsonArray.getJSONObject(i);
                        String id_trip = hit.getString("id_trip");
                        String tanggal = hit.getString("tanggal");
                        String route = hit.getString("route");
                        String target_jumlah = hit.getString("target_jumlah");
                        String hotel_bintang = hit.getString("hotel_bintang");
                        mTripList.add(new TripItem(id_trip, tanggal, route,target_jumlah,hotel_bintang));
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
                        mTripAdapter = new TripAdapter(MainActivity.this, mTripList);
                        mRecyclerView.setAdapter(mTripAdapter);
                        mTripAdapter.setOnItemClickListener(MainActivity.this);
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
        Intent detailIntent = new Intent(this,NavActivity.class);
        TripItem clickedTrip= mTripList.get(position);
        detailIntent.putExtra(ExtraIdTrip,clickedTrip.getMid_trip());
        detailIntent.putExtra(ExtraTanggal,clickedTrip.getMtanggal());
        detailIntent.putExtra(ExtraRoute,clickedTrip.getMroute());
        detailIntent.putExtra(ExtraTarget_jumlah,clickedTrip.getMtarget_jumlah());
        detailIntent.putExtra(ExtraHotel_bintang,clickedTrip.getMhotel_bintang());
        startActivity(detailIntent);
    }
}
