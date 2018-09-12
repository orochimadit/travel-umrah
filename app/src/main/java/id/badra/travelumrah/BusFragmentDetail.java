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

import id.badra.model.TripBusItem;
import id.badra.util.Server;

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
    private TextView namaSupirMak;
    private TextView namaSupirMad;
    private TextView namaSupirMdm;
    private TextView mobileSupirMak;
    private TextView mobileSupirMad;
    private TextView mobileSupirMdm;
    private TextView emailSupirMak;
    private TextView emailSupirMad;
    private TextView emailSupirMdm;
    private ImageView imgSap;
    private ImageView imgSMak;
    private ImageView imgSMad;
    private ImageView imgSMdm;

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
        namaSupirMak=(TextView)rootView.findViewById(R.id.nama_supir_bus_makkah_detail);
        namaSupirMad=(TextView)rootView.findViewById(R.id.nama_supir_bus_madinah_detail);
        namaSupirMdm=(TextView)rootView.findViewById(R.id.nama_supir_bus_mdm_detail);
        mobileSupirMak=(TextView)rootView.findViewById(R.id.telepon_supir_bus_makkah_detail);
        mobileSupirMad=(TextView)rootView.findViewById(R.id.telepon_supir_bus_madinah_detail);
        mobileSupirMdm=(TextView)rootView.findViewById(R.id.telepon_supir_bus_mdm_detail);
        emailSupirMak=(TextView)rootView.findViewById(R.id.email_supir_bus_makkah_detail);
        emailSupirMad=(TextView)rootView.findViewById(R.id.email_supir_bus_mad_detail);
        emailSupirMdm=(TextView)rootView.findViewById(R.id.email_supir_bus_mdm_detail);
        imgSap          = (ImageView)rootView.findViewById(R.id.backdrop_path_bus_detail);
        imgSMak         = (ImageView)rootView.findViewById(R.id.backdrop_path_bus_mak_detail);
        imgSMad         = (ImageView)rootView.findViewById(R.id.backdrop_path_bus_mad_detail);
        imgSMdm         = (ImageView)rootView.findViewById(R.id.backdrop_path_bus_mdm_detail);
       TripBusItem movie = getArguments().getParcelable("movie");
        if (movie!=null){
            namaSupirAp.setText(movie.getMnama_supir_ap());
            idTrip.setText(movie.getMid_trip());
            teleponSupirAp.setText(movie.getMsap_mobile());
            emailSupirAp.setText(movie.getMsap_email());
            tanggalPickupAp.setText(movie.getMtanggal_booking());
            namaSupirMak.setText(movie.getMnama_supir_mak());
            namaSupirMad.setText(movie.getMnama_supir_mad());
            namaSupirMdm.setText(movie.getMnama_supir_mdm());
            mobileSupirMak.setText(movie.getMmobile_mak());
            mobileSupirMad.setText(movie.getMmobile_mad());
            mobileSupirMdm.setText(movie.getMmobile_mdm());
            emailSupirMak.setText(movie.getMemail_mak());
            emailSupirMad.setText(movie.getMemail_mad());
            emailSupirMdm.setText(movie.getMemail_mdm());

            Picasso.with(getActivity().getApplicationContext()).load(Server.ImgSrc+movie.getMbackdrop_path_img_sap())
                    .placeholder(R.mipmap.ic_launcher).into(imgSap);
            Picasso.with(getActivity().getApplicationContext()).load(Server.ImgSrc+movie.getMbackdrop_path_img_mak())
                    .placeholder(R.mipmap.ic_launcher).into(imgSMak);
            Picasso.with(getActivity().getApplicationContext()).load(Server.ImgSrc+movie.getMbackdrop_path_img_mad())
                    .placeholder(R.mipmap.ic_launcher).into(imgSMad);
            Picasso.with(getActivity().getApplicationContext()).load(Server.ImgSrc+movie.getMbackdrop_path_img_mdm())
                    .placeholder(R.mipmap.ic_launcher).into(imgSMdm);
        }
        return rootView;
    }
}
