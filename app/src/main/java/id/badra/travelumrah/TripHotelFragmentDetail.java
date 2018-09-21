package id.badra.travelumrah;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.badra.model.TripHotel;
import id.badra.model.TripNote;

public class TripHotelFragmentDetail extends Fragment {

    private TextView namaHotel;
    private TextView los;
    private TextView tanggalBooking;
    private TextView tglCheckin;
    private TextView tglCheckout,contactMobile,contactEmail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.trip_hotel_fragment_detail, container, false);
        namaHotel = (TextView) rootView.findViewById(R.id.nama_hotel_detail);
        los =(TextView)rootView.findViewById(R.id.los_hotel_detail);
        tanggalBooking =(TextView)rootView.findViewById(R.id.tanggal_booking_hotel_detail);
        tglCheckin =(TextView)rootView.findViewById(R.id.tgl_checkin_hotel_detail);
        tglCheckout =(TextView)rootView.findViewById(R.id.tgl_checkout_hotel_detail);
        contactMobile=(TextView)rootView.findViewById(R.id.contact_mobile_hotel_detail);
        contactEmail =(TextView)rootView.findViewById(R.id.contact_email_hotel_detail);

//          = (TextView) rootView.findViewById(R.id.nama_supir_bus_detail);
//        telepon = (TextView) rootView.findViewById(R.id.telepon_supir_bus_detail);

        TripHotel panggil = getArguments().getParcelable("trip_hotel");
        if (panggil!=null){
//            nama.setText(movie.getMnama_supir_ap());
//            idTrip.setText(movie.getMid_trip());
//            telepon.setText(movie.getMsap_mobile());
            namaHotel.setText(panggil.getMnama_hotel());
            los.setText(panggil.getMlength_of_stay());
            tanggalBooking.setText(panggil.getMtanggal_booking());
            tglCheckin.setText(panggil.getMtanggal_checkin());
            tglCheckout.setText(panggil.getMtanggal_checkout());
            contactMobile.setText(panggil.getMcontact_mobile());
            contactEmail.setText(panggil.getMcontact_email());

        }
        return rootView;
    }
}
