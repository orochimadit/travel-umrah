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
import id.badra.adapter.TripJamaahAdapter;
import id.badra.model.TripAirline;
import id.badra.model.TripJamaah;
import id.badra.model.TripNote;
import id.badra.util.Server;

import static id.badra.travelumrah.MainActivity.ExtraIdTrip;

public class TripJamaahFragment extends Fragment {
    private RequestQueue requestQueue;
    private ArrayList<TripJamaah> arrayList;
    private TripJamaahAdapter mTripJamaahAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        final String idTrip = intent.getStringExtra(ExtraIdTrip);
        View view = inflater.inflate(R.layout.trip_airline_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecycleListViewAirline);

        arrayList = new ArrayList<>();
        //sendRequest(idTrip);

        FragmentManager fms = getFragmentManager();

        mTripJamaahAdapter = new TripJamaahAdapter(arrayList, fms);

        recyclerView.setAdapter(mTripJamaahAdapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2, GridLayoutManager.VERTICAL, false));

        return view;
    }

    public void sendRequest(String idtrip) {
//        String url= "http://192.168.0.17/api/trip_airline.php?id_trip="+idtrip;
        String url= Server.URL+"trip_jamaah.php?id_trip="+idtrip;
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray obj = response.getJSONArray("trip_jamaah");
                    for (int i = 0; i < obj.length(); i++) {

                        JSONObject jsonObject = obj.getJSONObject(i);

                        TripJamaah note = new TripJamaah(
                                jsonObject.getString("id_trip_jamaah"),
                                jsonObject.getString("id_trip"),
                                jsonObject.getString("id_jamaah"),
                                jsonObject.getString("id_paket_perjalanan"),
                                jsonObject.getString("id_manasik"),
                                jsonObject.getString("id_trip_visa"),
                                jsonObject.getString("id_kk"),
                                jsonObject.getString("relasi"),
                                jsonObject.getString("harga_jual"),
                                jsonObject.getString("no_paspor"),
                                jsonObject.getString("tgl_paspor"),
                                jsonObject.getString("paspor_issuer"),
                                jsonObject.getString("paspor_exp_date"),
                                jsonObject.getString("paspor"),
                                jsonObject.getString("surat_nikah"),
                                jsonObject.getString("kartu_keluarga"),
                                jsonObject.getString("buku_kuning"),
                                jsonObject.getString("surat_mahrom"),
                                jsonObject.getString("foto"),
                                jsonObject.getString("bukti_tiket"),
                                jsonObject.getString("tanggal_pengajuan"),
                                jsonObject.getString("tanggal_mova"),
                                jsonObject.getString("tanggal_tempel_sticker"),
                                jsonObject.getString("nama_muasasah"),
                                jsonObject.getString("id_vendor_visa"),
                                jsonObject.getString("hotel_bintang_madinah"),
                                jsonObject.getString("id_hotel_madinah"),
                                jsonObject.getString("okupansi_madinah"),
                                jsonObject.getString("katering_madinah"),
                                jsonObject.getString("hotel_bintang_makkah"),
                                jsonObject.getString("id_hotel_makkah"),
                                jsonObject.getString("okupansi_makkah"),
                                jsonObject.getString("katering_makkah"),
                                jsonObject.getString("hotel_bintang_jeddah"),
                                jsonObject.getString("id_hotel_jeddah"),
                                jsonObject.getString("okupansi_jeddah"),
                                jsonObject.getString("katering_jeddah"),
                                jsonObject.getString("route_tambahan"),
                                jsonObject.getString("nama_jamaah"),
                                jsonObject.getString("tanggal_manasik")
                        );
                        arrayList.add(note);
                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                mTripJamaahAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}
