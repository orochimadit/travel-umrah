package id.badra.adapter;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.badra.model.TripBusItem;
import id.badra.travelumrah.BusFragmentDetail;
import id.badra.travelumrah.R;

public class TripBusAdapterNew  extends RecyclerView.Adapter<TripBusAdapterNew.Viewholder>{
    private ArrayList<TripBusItem> model;
    private FragmentManager   fms;

    public TripBusAdapterNew(ArrayList<TripBusItem> model, FragmentManager fms) {
        this.model = model;
        this.fms = fms;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_bus_item, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        //holder.setId(model.get(position).getId());
        //holder.setTitle(model.get(position).getTitle());
//        holder.setPosterPath(model.get(position).getPoster_path());
        TripBusItem currentItem = model.get(position);
        String IdTrip= currentItem.getMid_trip();
        String idBussBooking = currentItem.getMid_bus_booking();
        String namaSupir = currentItem.getMnama_supir_ap();
        String Email = currentItem.getMsap_email();
        String tanggalMadinahMekkah= currentItem.getMtgl_madinah_mekkah();
        String sapMobile = currentItem.getMsap_mobile();
        String namaVendor=currentItem.getMnama_vendor();
//        holder.mTextViewIdTrip.setText(IdTrip);
//        holder.mTextViewNamaSupir.setText(namaSupir);
//        holder.mTextViewSapMobile.setText(sapMobile);
        holder.mTextViewNamaVendor.setText(namaVendor);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripBusItem obj = new TripBusItem(model.get(position).getMid_bus_booking(), model.get(position).getMid_trip(),
                        model.get(position).getMtanggal_booking(),model.get(position).getMnama_supir_ap(),
                        model.get(position).getMsap_mobile(),model.get(position).getMsap_email(),model.get(position).getMtgl_madinah_mekkah(),
                        model.get(position).getMtgl_ziarah_madinah(),model.get(position).getMtgl_ziarah_mekkah(),
                        model.get(position).getMnama_vendor()
                        );
                BusFragmentDetail frgment = new BusFragmentDetail();
                Bundle args = new Bundle();
                args.putParcelable("movie",obj);
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
        public TextView mTextViewIdTrip;
        public TextView mTextViewNamaSupir;
        public  TextView mTextViewSapMobile;
        public  TextView mTextViewNamaVendor;
     public View mView;
        private ImageView imageViewPoster;

        public Viewholder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextViewNamaVendor = itemView.findViewById(R.id.id_trip);
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
