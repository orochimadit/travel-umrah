package id.badra.travelumrah;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import id.badra.app.AppController;
import id.badra.app.RequestHandler;
import id.badra.util.Server;


public class TripNoteAddFragment extends Fragment {
    private TextView idTripNote;
    private TextView idTrip;
    private TextView tanggal;
    private TextView deskripsi;
    private Button btnAdd;
    private String sDeskripsi;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.trip_note_add, container, false);

            btnAdd=(Button)rootView.findViewById(R.id.buttonTripNoteAdd);
          deskripsi= (TextView) rootView.findViewById(R.id.txt_deskripsi);
          btnAdd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

            tambah_post_blog();
              }
          });
//        telepon = (TextView) rootView.findViewById(R.id.telepon_supir_bus_detail);
//
//        TripNote panggil = getArguments().getParcelable("trip_note");
//        if (panggil!=null){
////            nama.setText(movie.getMnama_supir_ap());
////            idTrip.setText(movie.getMid_trip());
////            telepon.setText(movie.getMsap_mobile());
//            idTrip.setText(panggil.getMid_trip());
//            idTripNote.setText(panggil.getMid_trip_note());
//            tanggal.setText(panggil.getMtanggal());
//            deskripsi.setText(panggil.getMdeskripsi());
//
//        }
        return rootView;
    }

    public void tambah_post_blog() {
       // if (!validasi()) return;

//        if (spmapel.getSelectedItemPosition() == 0) {
//            Toast.makeText(getApplicationContext(), "Silahkan pilih mata pelajaran", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (spmateri.getSelectedItemPosition() == 0) {
//            Toast.makeText(getApplicationContext(), "Silahkan pilih materi", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (sptag.getSelectedItemPosition() == 0) {
//            Toast.makeText(getApplicationContext(), "Silahkan pilih tag", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        posting_blog.setText("Memproses");
//        posting_blog.setEnabled(false);
//
//        pDialog.show();

//        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        photoPath = "http://filehosting.vidyanusa.id/mobile/blog/" + timeStamp + ".png";

//        sMapel = spmapel.getSelectedItem().toString();
//        idMapel = listMapel.get(spmapel.getSelectedItemPosition() - 1);
//        sMateri = spmateri.getSelectedItem().toString();
//        idMateri = listMateri.get(spmateri.getSelectedItemPosition() - 1);
//        sTag = sptag.getSelectedItem().toString();
//        idTags = listTags.get(sptag.getSelectedItemPosition() - 1);
//        sJudul = judul.getText().toString();
        sDeskripsi = deskripsi.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.URL+"trip_note_insert.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  progressDialos.dismiss();
                        try{
                            JSONObject obj = new JSONObject(response);
                            JSONObject objData = new JSONObject(obj.getString("data"));
                            Toast.makeText(getActivity().getApplicationContext(), objData.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
//                        pDialog.hide();
//                        posting_blog.setText("Kirim");
//                        posting_blog.setEnabled(true);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // progressDialog.hide();
                        Toast.makeText(getActivity().getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG);
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();

//                params.put("access_token",access_token);

                params.put("deskripsi",sDeskripsi);

                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy( 50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        RequestHandler.getInstance(getActivity().getApplicationContext()).addToRequestQueue(stringRequest);
//        AppController.getInstance(getActivity().getApplicationContext().a)
        RequestHandler.getInstance(getActivity().getApplicationContext()).addToRequestQueue(stringRequest);
     //   up();
    }
}
