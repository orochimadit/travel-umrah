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
import id.badra.model.TripNote;
import id.badra.util.Server;

public class TripNoteFragmentDetail extends Fragment {
    private TextView idTripNote;
    private TextView idTrip;
    private TextView tanggal;
    private TextView deskripsi;

    private ImageView imgSNote;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.trip_note_fragment_detail, container, false);
        idTrip = (TextView) rootView.findViewById(R.id.id_trip_note_trip);
        idTripNote =(TextView)rootView.findViewById(R.id.id_trip_note_detail);
        tanggal = (TextView)rootView.findViewById(R.id.tanggal_note);
        deskripsi = (TextView)rootView.findViewById(R.id.deskripsi_note);
//          = (TextView) rootView.findViewById(R.id.nama_supir_bus_detail);
//        telepon = (TextView) rootView.findViewById(R.id.telepon_supir_bus_detail);
        imgSNote=(ImageView)rootView.findViewById(R.id.backdrop_path_note_detail);
        TripNote panggil = getArguments().getParcelable("trip_note");
        if (panggil!=null){
//            nama.setText(movie.getMnama_supir_ap());
//            idTrip.setText(movie.getMid_trip());
//            telepon.setText(movie.getMsap_mobile());
            idTrip.setText(panggil.getMid_trip());
            idTripNote.setText(panggil.getMid_trip_note());
            tanggal.setText(panggil.getMtanggal());
            deskripsi.setText(panggil.getMdeskripsi());

            Picasso.with(getActivity().getApplicationContext()).load(Server.ImgSrc+panggil.getMtanggal())
                    .placeholder(R.mipmap.ic_launcher).into(imgSNote);
        }
        return rootView;
    }
}
