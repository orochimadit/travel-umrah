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

import id.badra.adapter.TripHotelAdapter;
import id.badra.model.TripBusItem;
import id.badra.model.TripHotel;
import id.badra.util.Server;


import static id.badra.travelumrah.MainActivity.ExtraIdTrip;


public class TripHotelFragment extends Fragment {

    private RequestQueue requestQueue;
    private ArrayList<TripHotel> arrayList;
    private TripHotelAdapter mTripHotelAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        final String idTrip = intent.getStringExtra(ExtraIdTrip);
        View view = inflater.inflate(R.layout.trip_hotel_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecycleListViewHotel);

        arrayList = new ArrayList<>();
        sendRequest(idTrip);

        FragmentManager fms = getFragmentManager();

        mTripHotelAdapter = new TripHotelAdapter(arrayList, fms);

        recyclerView.setAdapter(mTripHotelAdapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1, GridLayoutManager.VERTICAL, false));

        return view;
    }

    public void sendRequest(String idtrip) {
//        String url= "http://192.168.0.17/api/trip_bus.php?id_trip="+idtrip;
        String url= Server.URL+"trip_hotel.php?id_trip="+idtrip;
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray obj = response.getJSONArray("trip_hotel");
                    for (int i = 0; i < obj.length(); i++) {

                        JSONObject jsonObject = obj.getJSONObject(i);

                        TripHotel movie = new TripHotel(
                                jsonObject.getString("id_trip_hotel1"),
                                jsonObject.getString("id_trip_la_paket"),
                                jsonObject.getString("id_trip"),
                                jsonObject.getString("id_hotel"),
                                jsonObject.getString("id_vendor"),
                                jsonObject.getString("tanggal_booking"),
                                jsonObject.getString("tanggal_checkin"),
                                jsonObject.getString("length_of_stay"),
                                jsonObject.getString("tanggal_checkout"),
                                jsonObject.getString("jenis_kamar"),
                                jsonObject.getString("opsi_kamar"),
                                jsonObject.getString("harga_sewa"),
                                jsonObject.getString("jumlah_room"),
                                jsonObject.getString("view"),
                                jsonObject.getString("profit_margin"),
                                jsonObject.getString("rekening"),
                                jsonObject.getString("harga_jual"),
                                jsonObject.getString("booking_fee"),
                                jsonObject.getString("booking_fee_currency"),
                                jsonObject.getString("contact_mobile"),
                                jsonObject.getString("contact_email"),
                                jsonObject.getString("review"),
                                jsonObject.getString("status"),
                                jsonObject.getString("nama_hotel"),
                                jsonObject.getString("bintang"),
                                jsonObject.getString("nama_vendor")
                        );
                        arrayList.add(movie);
                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                mTripHotelAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}
