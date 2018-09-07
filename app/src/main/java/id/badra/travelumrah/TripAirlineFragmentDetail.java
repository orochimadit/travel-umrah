package id.badra.travelumrah;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.badra.model.TripAirline;
import id.badra.model.TripBusItem;

public class TripAirlineFragmentDetail extends Fragment {
    private TextView idTripAirline;
    private TextView idAirlineBooking;
    private TextView idTrip;
    private TextView jumlah;
    private TextView hargaJual;
    private TextView flightIdDep;
    private TextView flightIdRet;
    private TextView tanggalDeparture;
    private TextView jumlahSeatQuota;
    private TextView bookingStatus;
    private TextView harga;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.trip_airline_fragment_detail, container, false);
        idTripAirline = (TextView) rootView.findViewById(R.id.id_trip_airline_detail);
        idAirlineBooking = (TextView) rootView.findViewById(R.id.id_airline_booking_detail);
        idTrip = (TextView) rootView.findViewById(R.id.id_trip_detail_airline);
        jumlah = (TextView) rootView.findViewById(R.id.jumlah_trip_airline_detail);
        hargaJual = (TextView) rootView.findViewById(R.id.jumlah_trip_airline_detail);
        flightIdDep = (TextView) rootView.findViewById(R.id.flight_id_dep_trip_airline_detail);
        flightIdRet = (TextView) rootView.findViewById(R.id.flight_id_ret_trip_airline_detail);
        tanggalDeparture = (TextView) rootView.findViewById(R.id.tanggal_departure_trip_airline_detail);
        jumlahSeatQuota = (TextView) rootView.findViewById(R.id.jumlah_seat_quota_trip_airline_detail);
        bookingStatus = (TextView) rootView.findViewById(R.id.booking_status_trip_airline_detail);
        harga = (TextView) rootView.findViewById(R.id.harga_trip_airline_detail);
//          = (TextView) rootView.findViewById(R.id.nama_supir_bus_detail);
//        telepon = (TextView) rootView.findViewById(R.id.telepon_supir_bus_detail);

        TripAirline panggil = getArguments().getParcelable("trip_airline");
        if (panggil!=null){
//            nama.setText(movie.getMnama_supir_ap());
//            idTrip.setText(movie.getMid_trip());
//            telepon.setText(movie.getMsap_mobile());
            idTripAirline.setText(panggil.getMid_trip_airline());
            idTrip.setText(panggil.getMid_trip());
            idAirlineBooking.setText(panggil.getMid_airline_booking());
            jumlah.setText(panggil.getMjumlah());
            hargaJual.setText(panggil.getMharga_jual());
            flightIdDep.setText(panggil.getMflight_id_dep());
            flightIdRet.setText(panggil.getMflight_id_ret());
            tanggalDeparture.setText(panggil.getMtanggal_departure());
            jumlahSeatQuota.setText(panggil.getMjumlah_seat_quota());
            bookingStatus.setText(panggil.getMbooking_status());
            harga.setText(panggil.getMharga());
        }
        return rootView;
    }
}
