package id.badra.travelumrah;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.badra.model.TripAirline;
import id.badra.model.TripGaleri;
import id.badra.util.Server;

public class TripGaleriFragmentDetail extends Fragment {
    private TextView idTripGaleri;

    private TextView idTrip;
    private TextView foto;
    private TextView caption;
    private ImageView imgFoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.trip_galeri_fragment_detail, container, false);

        idTrip = (TextView) rootView.findViewById(R.id.deskripsi_galeri_detail);
        imgFoto=(ImageView)rootView.findViewById(R.id.backdrop_path_photo_galeri_detail);
//          = (TextView) rootView.findViewById(R.id.nama_supir_bus_detail);
//        telepon = (TextView) rootView.findViewById(R.id.telepon_supir_bus_detail);

        TripGaleri panggil = getArguments().getParcelable("trip_galeri");
        if (panggil!=null){
//            nama.setText(movie.getMnama_supir_ap());
//            idTrip.setText(movie.getMid_trip());
//            telepon.setText(movie.getMsap_mobile());

            idTrip.setText(panggil.getMcaption());
            Picasso.with(getActivity().getApplicationContext()).load(Server.ImgSrcApi+"trip_galeri_image/"+panggil.getMfoto())
                    .placeholder(R.mipmap.ic_launcher).into(imgFoto);
        }
        return rootView;
    }
}
