package id.badra.travelumrah;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.badra.model.TripBusItem;

public class BusFragmentDetail extends Fragment {
//dest.writeString(this.mid_bus_booking);
//        dest.writeString(this.mid_trip);
//        dest.writeString(this.mnama_supir_ap);
//        dest.writeString(this.mtanggal_booking);
//        dest.writeString(this.msap_mobile);
//        dest.writeString(this.msap_email);
//        dest.writeString(this.mtgl_ziarah_mekkah);
//        dest.writeString(this.mtgl_ziarah_madinah);
//        dest.writeString(this.mtgl_madinah_mekkah);
//        dest.writeString(this.mnama_vendor);

    private TextView idTrip;
    private TextView tanggalBooking;
    private TextView namaSupirAp;
    private TextView teleponSupirAp;
    private TextView emailSupirAp;
    private TextView nomorBodyAp;
    private TextView tanggalPickupAp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.bus_fragment_detail, container, false);
        idTrip = (TextView) rootView.findViewById(R.id.id_trip_bus_detail);
        namaSupirAp= (TextView) rootView.findViewById(R.id.nama_supir_bus_detail);
       teleponSupirAp = (TextView) rootView.findViewById(R.id.telepon_supir_bus_detail);
       tanggalPickupAp= (TextView)rootView.findViewById(R.id.tgl_supir_bus_pickup_ap_detail);
        emailSupirAp= (TextView)rootView.findViewById(R.id.email_supir_bus_ap_detail);


       TripBusItem movie = getArguments().getParcelable("movie");
        if (movie!=null){
            namaSupirAp.setText(movie.getMnama_supir_ap());
            idTrip.setText(movie.getMid_trip());
            teleponSupirAp.setText(movie.getMsap_mobile());
            emailSupirAp.setText(movie.getMsap_email());
            tanggalPickupAp.setText(movie.getMtanggal_booking());
        }
        return rootView;
    }
}
