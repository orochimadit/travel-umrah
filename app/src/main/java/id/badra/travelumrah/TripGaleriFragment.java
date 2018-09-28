package id.badra.travelumrah;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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

import id.badra.adapter.TripGaleriAdapter;
import id.badra.adapter.TripHotelAdapter;
import id.badra.model.TripGaleri;
import id.badra.model.TripHotel;
import id.badra.util.Server;

import static id.badra.travelumrah.MainActivity.ExtraIdTrip;

public class TripGaleriFragment extends Fragment {
    private RequestQueue requestQueue;
    private ArrayList<TripGaleri> arrayList;
    private TripGaleriAdapter mTripGaleriAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        final String idTrip = intent.getStringExtra(ExtraIdTrip);
        View view = inflater.inflate(R.layout.trip_galeri_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecycleListViewGaleri);


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_galeri);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Fragment newCase=new TripGaleriAddFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frames,newCase); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });
        arrayList = new ArrayList<>();
        sendRequest(idTrip);

        FragmentManager fms = getFragmentManager();

        mTripGaleriAdapter = new TripGaleriAdapter(arrayList, fms);

        recyclerView.setAdapter(mTripGaleriAdapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1, GridLayoutManager.VERTICAL, false));

        return view;
    }

    public void sendRequest(String idtrip) {
//        String url= "http://192.168.0.17/api/trip_bus.php?id_trip="+idtrip;
        String url= Server.URL+"trip_galeri.php?id_trip="+idtrip;
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray obj = response.getJSONArray("trip_galeri");
                    for (int i = 0; i < obj.length(); i++) {

                        JSONObject jsonObject = obj.getJSONObject(i);

                        TripGaleri movie = new TripGaleri(
                                jsonObject.getString("id_trip_galery"),
                                jsonObject.getString("id_trip"),
                                jsonObject.getString("foto"),
                                jsonObject.getString("caption")

                        );
                        arrayList.add(movie);
                    }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                mTripGaleriAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}
