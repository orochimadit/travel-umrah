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

import id.badra.model.TripAirline;
import id.badra.model.TripBusItem;
import id.badra.travelumrah.BusFragmentDetail;
import id.badra.travelumrah.R;
import id.badra.travelumrah.TripAirlineFragmentDetail;


public class TripAirlineAdapter extends RecyclerView.Adapter<TripAirlineAdapter.Viewholder> {
    private ArrayList<TripAirline> model;
    private FragmentManager fms;

    public TripAirlineAdapter(ArrayList<TripAirline> model, FragmentManager fms) {
        this.model = model;
        this.fms = fms;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_airline_item, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new TripAirlineAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
    TripAirline currentItem = model.get(position);

        String id_trip_airline= currentItem.getMid_trip_airline();
        String id_airline_booking = currentItem.getMid_airline_booking();
        String id_trip = currentItem.getMid_trip();
        String jumlah = currentItem.getMjumlah();
        String harga_jual = currentItem.getMharga_jual();
        String flight_id_dep= currentItem.getMflight_id_dep();
        String flight_id_ret = currentItem.getMflight_id_ret();
        String tanggal_departure= currentItem.getMtanggal_departure();
        String jumlah_seat_quota=currentItem.getMjumlah_seat_quota();
        String booking_status= currentItem.getMbooking_status();
        String harga = currentItem.getMharga();
        holder.mTextViewIdTripAirline.setText(id_trip_airline);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TripAirline obj = new TripAirline(model.get(position).getMid_trip_airline(), model.get(position).getMid_airline_booking(),
                        model.get(position).getMid_trip(),model.get(position).getMjumlah(),model.get(position).getMharga_jual(),
                        model.get(position).getMflight_id_dep(),model.get(position).getMflight_id_ret(),model.get(position).getMtanggal_departure(),
                        model.get(position).getMjumlah_seat_quota(),model.get(position).getMbooking_status(),model.get(position).getMharga()
                );
                TripAirlineFragmentDetail frgment = new TripAirlineFragmentDetail();
                Bundle args = new Bundle();
                args.putParcelable("trip_airline",obj);
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

        public  TextView mTextViewIdTripAirline;
        public View mView;
        private ImageView imageViewPoster;

        public Viewholder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextViewIdTripAirline = itemView.findViewById(R.id.id_trip_airline);
//            mTextViewNamaSupir =itemView.findViewById(R.id.nama_supir);
//            mTextViewSapMobile =itemView.findViewById(R.id.sap_mobile);
//            imageViewPoster = (ImageView) mView.findViewById(R.id.poster_path);

        }

//        public void setPosterPath(String posterPath) {
//            //
//            Picasso.with(mView.getContext()).load(StringsAPI.IMAGE_SOURCE+posterPath).placeholder(R.mipmap.ic_launcher)
//                    .into(imageViewPoster);
//        }
    }
}
