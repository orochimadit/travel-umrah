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

import id.badra.adapter.TripBusAdapterNew;
import id.badra.model.TripBusItem;
import id.badra.util.Server;

import static id.badra.travelumrah.MainActivity.ExtraIdTrip;

public class BusFragment extends Fragment {

    private RequestQueue requestQueue;
    private ArrayList<TripBusItem> arrayList;
    private TripBusAdapterNew mTripBusAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Intent intent =getActivity().getIntent();
        final String idTrip = intent.getStringExtra(ExtraIdTrip);
        View view = inflater.inflate(R.layout.bus_fragment,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecycleListView);

        arrayList = new ArrayList<>();
        sendRequest(idTrip);

        FragmentManager fms = getFragmentManager();

        mTripBusAdapter = new TripBusAdapterNew(arrayList,fms);

        recyclerView.setAdapter(mTripBusAdapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2, GridLayoutManager.VERTICAL,false));

        return view;
    }

    public void sendRequest(String idtrip) {
//        String url= "http://192.168.0.17/api/trip_bus.php?id_trip="+idtrip;
        String url= Server.URL+"trip_bus.php?id_trip="+idtrip;
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray obj = response.getJSONArray("trip_bus");
                    for (int i = 0; i < obj.length(); i++) {

                        JSONObject jsonObject = obj.getJSONObject(i);

                      TripBusItem movie = new TripBusItem(
                                jsonObject.getString("id_bus_booking"),
                                jsonObject.getString("id_trip"),
                              jsonObject.getString("tanggal_booking"),
                              jsonObject.getString("nama_sopir_ap"),
                              jsonObject.getString("sap_mobile"),
                              jsonObject.getString("sap_email"),
                              jsonObject.getString("tanggal_madinah_makkah"),
                              jsonObject.getString("tanggal_ziarah_madinah"),
                              jsonObject.getString("tanggal_ziarah_makkah"),
                              jsonObject.getString("nama_vendor"),
                              jsonObject.getString("nama_sopir_mad"),
                              jsonObject.getString("smd_mobile"),
                              jsonObject.getString("smd_email"),
                              jsonObject.getString("nama_sopir_zmk"),
                              jsonObject.getString("zmk_mobile"),
                              jsonObject.getString("zmk_email"),
                              jsonObject.getString("nama_sopir_mdm"),
                              jsonObject.getString("mdm_mobile"),
                              jsonObject.getString("mdm_email"),
                              jsonObject.getString("sap_foto")
                        );
                        arrayList.add(movie);
                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                mTripBusAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}