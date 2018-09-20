package id.badra.travelumrah;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import id.badra.app.RequestHandler;
import id.badra.util.Server;

import static android.app.Activity.RESULT_OK;
import static id.badra.travelumrah.MainActivity.ExtraIdTrip;

public class TripGaleriAddFragment extends Fragment {

    private TextView idTripNote;
    private TextView idTrip;
//     private String SidTrip;
    private TextView tanggal;
    private TextView caption;
    private Button btnAdd;
    private String sCaption;
    private String sTanggal,SphotoPath,Ssimpan;
    private String SaveTanggal;
    private ImageView img;
    private final int GALLERY = 1, CAMERA = 2;
    private Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)   {
        View rootView;
        rootView = inflater.inflate(R.layout.trip_galeri_add, container, false);
        Intent intent = getActivity().getIntent();
        final String SidTrip = intent.getStringExtra(ExtraIdTrip);
        btnAdd = (Button) rootView.findViewById(R.id.buttonTripGaleriAdd);
        caption = (TextView) rootView.findViewById(R.id.txt_caption);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tambah_post_blog(SidTrip);
                Fragment newCase=new TripGaleriFragment();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frames,newCase); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        img = (ImageView) rootView.findViewById(R.id.uploadfoto_galeri);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
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

    public void tambah_post_blog(final String idTrip) {
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
        sCaption = caption.getText().toString();
//        sTanggal = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        sTanggal = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        sTanggal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        SaveTanggal = String.valueOf(sTanggal);
        Ssimpan=SaveTanggal+".png";
        //http://umrah.kamusminang.com/api/trip_galeri_image/2018-09-20%2017:31:57.png
        SphotoPath = "http://umrah.kamusminang.com/api/trip_galeri_image/" + SaveTanggal + ".png";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.URL + "trip_galeri_add.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  progressDialos.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);

                            JSONObject objData = new JSONObject(obj.getString("data"));
                            Toast.makeText(getActivity().getApplicationContext(), objData.getString("message"), Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
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
                        Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

//                params.put("access_token",access_token);
                params.put("id_trip", idTrip);
                params.put("caption", sCaption);
//                params.put("tanggal",SaveTanggal);
//                params.put("tanggal", sTanggal);
                params.put("foto",Ssimpan);
                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        RequestHandler.getInstance(getActivity().getApplicationContext()).addToRequestQueue(stringRequest);
//        AppController.getInstance(getActivity().getApplicationContext().a)
        RequestHandler.getInstance(getActivity().getApplicationContext()).addToRequestQueue(stringRequest);
        up();
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getActivity());
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Pilih photo dari galeri",
                "Ambil photo dengan kamera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case GALLERY: {
                    final Uri imageUri = data.getData();
                    try {
                        InputStream imageStream = getActivity().getApplicationContext().getContentResolver().openInputStream(imageUri);
                        bitmap = BitmapFactory.decodeStream(imageStream);
                        img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case CAMERA: {
                    bitmap = (Bitmap) data.getExtras().get("data");
                    img.setImageBitmap(bitmap);
                    break;
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

}

    public void up(){
        String address="umrah.kamusminang.com",u="umrah@kamusminang.com",p="umrah193",directory="api/trip_galeri_image/";
        TripGaleriAddFragment.uploadTask async=new TripGaleriAddFragment.uploadTask();
        async.execute(address,u,p,directory);
    }






    class uploadTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                com.adeel.library.easyFTP ftp = new com.adeel.library.easyFTP();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapdata = bos.toByteArray();
                ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);
                ftp.connect(params[0], params[1], params[2]);
                boolean status = false;
                if (!params[3].isEmpty()) {
                    status = ftp.setWorkingDirectory(params[3]);
                }
                ftp.uploadFile(bs, sTanggal + ".png");
                ftp.disconnect();
                return new String("http://umrah.kamusminang.com/api/trip_galeri_image/" + sTanggal + ".png");
            } catch (Exception e) {
                String t = "Failure : " + e.getLocalizedMessage();
                return t;
            }
        }
    }
}
