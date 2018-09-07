package id.badra.travelumrah;

import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.badra.model.TripBusItem;

public class TripBusAdapter extends RecyclerView.Adapter<TripBusAdapter.TripBusViewHolder> {

    private Context mContext;
    private ArrayList<TripBusItem> mTripBusList;
    private TripBusAdapter.OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(TripBusAdapter.OnItemClickListener listener){
        mListener = listener;
    }
    public TripBusAdapter(ArrayList<TripBusItem> context, FragmentManager TripBusList){
//        mContext= context;
//        mTripBusList= TripBusList;
    }

    @NonNull
    @Override
    public TripBusAdapter.TripBusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.trip_bus_item,parent,false);

        return new TripBusAdapter.TripBusViewHolder( v);
    }


    @Override
    public void onBindViewHolder(@NonNull TripBusAdapter.TripBusViewHolder holder, int position) {
        TripBusItem currentItem = mTripBusList.get(position);
        String IdTrip= currentItem.getMid_trip();
        String idBussBooking = currentItem.getMid_bus_booking();
        String namaSupir = currentItem.getMnama_supir_ap();
        String Email = currentItem.getMsap_email();
        String tanggalMadinahMekkah= currentItem.getMtgl_madinah_mekkah();
        String sapMobile = currentItem.getMsap_mobile();
        holder.mTextViewIdTrip.setText(IdTrip);
        holder.mTextViewNamaSupir.setText(namaSupir);
        holder.mTextViewSapMobile.setText(sapMobile);
    }

    @Override
    public int getItemCount() {
        return mTripBusList.size();
    }

    public class TripBusViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextViewIdTrip;
        public TextView mTextViewNamaSupir;
        public  TextView mTextViewSapMobile;
        public TripBusViewHolder(View itemView) {
            super(itemView);
            mTextViewIdTrip = itemView.findViewById(R.id.id_trip);
//            mTextViewNamaSupir = itemView.findViewById(R.id.nama_supir);
//            mTextViewSapMobile= itemView.findViewById(R.id.sap_mobile);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
            //mTextViewIdTrip= itemView.findViewById(R.id.);
            //mTextViewLikes= itemView.findViewById(R.id.text_view_likes);
        }
    }
}
