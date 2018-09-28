package id.badra.travelumrah;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import id.badra.adapter.TripAirlineAdapter;
import id.badra.adapter.TripBusAdapterNew;
import id.badra.model.TripAirline;
import id.badra.model.TripBusItem;
import id.badra.util.Server;

import static id.badra.travelumrah.MainActivity.ExtraIdTrip;

public class TripAirlineFragment extends Fragment {
    private RequestQueue requestQueue;
    private ArrayList<TripAirline> arrayList;
    private TripAirlineAdapter mTripAirlineAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Intent intent =getActivity().getIntent();
        final String idTrip = intent.getStringExtra(ExtraIdTrip);
        View view = inflater.inflate(R.layout.trip_airline_fragment,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecycleListViewAirline);

        arrayList = new ArrayList<>();
        sendRequest(idTrip);

        FragmentManager fms = getFragmentManager();

        mTripAirlineAdapter = new TripAirlineAdapter(arrayList,fms);

        recyclerView.setAdapter(mTripAirlineAdapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1, GridLayoutManager.VERTICAL,false));

        return view;
    }

    public void sendRequest(String idtrip) {
//        String url= "http://192.168.0.17/api/trip_airline.php?id_trip="+idtrip;
               String url= Server.URL+"trip_airline.php?id_trip="+idtrip;
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray obj = response.getJSONArray("trip_airline");
                    for (int i = 0; i < obj.length(); i++) {

                        JSONObject jsonObject = obj.getJSONObject(i);

                        TripAirline airline = new TripAirline(
                                jsonObject.getString("id_trip_airline"),
                                jsonObject.getString("id_airline_booking"),
                                jsonObject.getString("id_trip"),
                                jsonObject.getString("jumlah"),
                                jsonObject.getString("harga_jual"),
                                jsonObject.getString("flight_id_dep"),
                                jsonObject.getString("flight_id_ret"),
                                jsonObject.getString("tanggal_departure"),
                                jsonObject.getString("jumlah_seat_quota"),
                                jsonObject.getString("booking_status"),
                                jsonObject.getString("harga")
                        );
                        arrayList.add(airline);
                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                mTripAirlineAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}
