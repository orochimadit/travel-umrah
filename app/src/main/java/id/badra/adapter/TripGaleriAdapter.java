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

import id.badra.travelumrah.R;
import id.badra.travelumrah.TripGaleriFragmentDetail;


public class TripGaleriAdapter extends RecyclerView.Adapter<TripGaleriAdapter.Viewholder> {
    private ArrayList<TripGaleri> model;
    private FragmentManager fms;

    public TripGaleriAdapter(ArrayList<TripGaleri> model, FragmentManager fms) {
        this.model = model;
        this.fms = fms;
    }

    @NonNull
    @Override
    public TripGaleriAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_galeri_item, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new TripGaleriAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripGaleriAdapter.Viewholder holder, final int position) {
        TripGaleri currentItem = model.get(position);

        String id_trip_galeri = currentItem.getMid_trip_galeri();
        String id_trip      = currentItem.getMid_trip();
        String caption      = currentItem.getMcaption();
        String foto    = currentItem.getMfoto();

        holder.mTextViewIdTripGaleri.setText(id_trip_galeri);
//        holder.mTextViewIdTrip.setText(id_trip);
//        holder.mTextViewTanggal.setText(tanggal);
//        holder.mTextViewDeskripsi.setText(deskripsi);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TripGaleri obj = new TripGaleri(model.get(position).getMid_trip_galeri(),
                        model.get(position).getMid_trip(),
                        model.get(position).getMfoto(),
                        model.get(position).getMcaption()
                );
                TripGaleriFragmentDetail frgment = new TripGaleriFragmentDetail();
                Bundle args = new Bundle();
                args.putParcelable("trip_galeri",obj);
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

        public TextView mTextViewIdTripNote;
        public TextView mTextViewIdTripGaleri;
        public TextView mTextViewTanggal;
        public TextView mTextViewDeskripsi;
        public View mView;
        private ImageView imageViewPoster;

        public Viewholder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextViewIdTripGaleri = itemView.findViewById(R.id.id_trip_galeri);

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
