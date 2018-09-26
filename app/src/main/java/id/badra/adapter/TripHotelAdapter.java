package id.badra.adapter;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.badra.model.TripGaleri;
import id.badra.model.TripHotel;

import id.badra.travelumrah.R;
import id.badra.travelumrah.TripGaleriFragmentDetail;
import id.badra.travelumrah.TripHotelFragmentDetail;


public class TripHotelAdapter extends RecyclerView.Adapter<TripHotelAdapter.Viewholder>  {

    private ArrayList<TripHotel> model;
    private FragmentManager fms;

    public TripHotelAdapter(ArrayList<TripHotel> model, FragmentManager fms) {
        this.model = model;
        this.fms = fms;
    }

    @NonNull
    @Override
    public TripHotelAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_hotel_item, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new TripHotelAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripHotelAdapter.Viewholder holder, final int position) {
        TripHotel currentItem = model.get(position);

        String id_trip_hotel = currentItem.getMid_trip_hotel1();
        String id_trip_la_paket = currentItem.getMid_trip_la_paket();
        String id_trip      = currentItem.getMid_trip();
        String id_vendor      = currentItem.getMid_vendor();
        String tanggal_booking    = currentItem.getMtanggal_booking();
        String tanggal_checkin      = currentItem.getMtanggal_checkin();
        String length_of_stay       = currentItem.getMlength_of_stay();
        String tanggal_checkout     = currentItem.getMtanggal_checkout();
        String jenis_kamar          = currentItem.getMjenis_kamar();
        String opsi_kamar           = currentItem.getMopsi_kamar();
        String harga_sewa           = currentItem.getMharga_sewa();
        String jumlah_room          = currentItem.getMjumlah_room();
        String view                 = currentItem.getMview();
        String profit_margin        = currentItem.getMprofit_margin();
        String rekening             = currentItem.getMrekening();
        String harga_jual           = currentItem.getMharga_jual();
        String booking_fee          = currentItem.getMbooking_fee();
        String booking_fee_currency = currentItem.getMbooking_fee_currency();
        String contact_mobile       = currentItem.getMcontact_mobile();
        String review               = currentItem.getMreview();
        String status               = currentItem.getMstatus();
        String nama_hotel           = currentItem.getMnama_hotel();
        String bintang              = currentItem.getMbintang();
        String nama_vendor          = currentItem.getMnama_vendor();

        holder.mTextViewNamaHotel.setText("Hotel - "+nama_hotel);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TripHotel obj = new TripHotel(model.get(position).getMid_trip_hotel1(),
                        model.get(position).getMid_trip(),
                        model.get(position).getMid_trip_la_paket(),
                        model.get(position).getMid_hotel(),
                        model.get(position).getMid_vendor(),
                        model.get(position).getMtanggal_booking(),
                        model.get(position).getMtanggal_checkin(),
                        model.get(position).getMlength_of_stay(),
                        model.get(position).getMtanggal_checkout(),
                        model.get(position).getMjenis_kamar(),
                        model.get(position).getMopsi_kamar(),
                        model.get(position).getMharga_sewa(),
                        model.get(position).getMjumlah_room(),
                        model.get(position).getMview(),
                        model.get(position).getMprofit_margin(),
                        //id bank?
                        model.get(position).getMrekening(),
                        model.get(position).getMharga_jual(),
                        model.get(position).getMbooking_fee(),
                        model.get(position).getMbooking_fee_currency(),
                        model.get(position).getMcontact_mobile(),
                        model.get(position).getMreview(),
                        model.get(position).getMstatus(),
                        model.get(position).getMnama_hotel(),
                        model.get(position).getMbintang(),
                        model.get(position).getMnama_vendor(),
                        model.get(position).getMcontact_email()
                );
                TripHotelFragmentDetail frgment = new TripHotelFragmentDetail();
                Bundle args = new Bundle();
                args.putParcelable("trip_hotel",obj);
                frgment.setArguments(args);

                fms.beginTransaction().replace(R.id.content_frames, frgment).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        public TextView mTextViewNamaHotel;
        public View mView;
        private ImageView imageViewPoster;

        public Viewholder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextViewNamaHotel = itemView.findViewById(R.id.nama_hotel_item);

        }

//        public void setPosterPath(String posterPath) {
//            //
//            Picasso.with(mView.getContext()).load(StringsAPI.IMAGE_SOURCE+posterPath).placeholder(R.mipmap.ic_launcher)
//                    .into(imageViewPoster);
//        }
    }
}
