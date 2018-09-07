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
import id.badra.model.TripNote;
import id.badra.travelumrah.R;
import id.badra.travelumrah.TripAirlineFragmentDetail;
import id.badra.travelumrah.TripNoteFragmentDetail;

public class TripNoteAdapter extends RecyclerView.Adapter<TripNoteAdapter.Viewholder> {
    private ArrayList<TripNote> model;
    private FragmentManager fms;

    public TripNoteAdapter(ArrayList<TripNote> model, FragmentManager fms) {
        this.model = model;
        this.fms = fms;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_note_item, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new TripNoteAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        TripNote currentItem = model.get(position);

        String id_trip_note = currentItem.getMid_trip_note();
        String id_trip      = currentItem.getMid_trip();
        String tanggal      = currentItem.getMtanggal();
        String deskripsi    = currentItem.getMdeskripsi();

        holder.mTextViewIdTripNote.setText(id_trip_note);
//        holder.mTextViewIdTrip.setText(id_trip);
//        holder.mTextViewTanggal.setText(tanggal);
//        holder.mTextViewDeskripsi.setText(deskripsi);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TripNote obj = new TripNote(model.get(position).getMid_trip_note(),
                        model.get(position).getMid_trip(),
                        model.get(position).getMtanggal(),
                        model.get(position).getMdeskripsi()
                );
                TripNoteFragmentDetail frgment = new TripNoteFragmentDetail();
                Bundle args = new Bundle();
                args.putParcelable("trip_note",obj);
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
        public TextView mTextViewIdTrip;
        public TextView mTextViewTanggal;
        public TextView mTextViewDeskripsi;
        public View mView;
        private ImageView imageViewPoster;

        public Viewholder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextViewIdTripNote = itemView.findViewById(R.id.id_trip_note);
            mTextViewIdTrip = itemView.findViewById(R.id.id_trip_note_trip);
            mTextViewTanggal = itemView.findViewById(R.id.tanggal_note);
            mTextViewDeskripsi = itemView.findViewById(R.id.deskripsi_note);
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
