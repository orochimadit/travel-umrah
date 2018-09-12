package id.badra.travelumrah;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.adeel.library.easyFTP;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class CameraFragment extends Fragment {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    Button button;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.camera_fragment,
                container, false);

        button = (Button) rootView.findViewById(R.id.btn_camera);
        imageView = (ImageView) rootView.findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent,
//                        CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

 uploadTask asyncUploadTask = new uploadTask();
            asyncUploadTask.execute();

            }
        });

        return rootView;

    }

   // @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//
//                Bitmap bmp = (Bitmap) data.getExtras().get("data");
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//
//                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byte[] byteArray = stream.toByteArray();
//
//                // convert byte array to Bitmap
//
//                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
//                        byteArray.length);
//
//                imageView.setImageBitmap(bitmap);
//
//            }
//        }
//    }
    class uploadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                easyFTP ftp = new easyFTP();
                ftp.connect("umrah.kamusminang.com","umrah@kamusminang.com","umrah193");
                boolean status=false;
                status=ftp.setWorkingDirectory("/api/galeri"); // if User say provided any Destination then Set it , otherwise
                // Upload will be stored on Default /root level on server
                InputStream is=getResources().openRawResource(+R.drawable.aw);
                ftp.uploadFile(is,"test.png");
                return new String("Upload Successful");
            }catch (Exception e){
                String t="Failure : " + e.getLocalizedMessage();
                return t;
            }
        }

    }
}
