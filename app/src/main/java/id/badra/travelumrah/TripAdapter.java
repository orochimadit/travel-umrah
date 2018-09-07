package id.badra.travelumrah;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private Context mContext;
    private ArrayList<TripItem> mTripList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    public TripAdapter(Context context,ArrayList<TripItem> TripList){
        mContext= context;
        mTripList= TripList;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.trip_item,parent,false);

        return new TripViewHolder( v);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        TripItem currentItem = mTripList.get(position);
        String IdTrip= currentItem.getMid_trip();
        String Tanggal = currentItem.getMtanggal();
        String Route = currentItem.getMroute();
        String TargetJumlah = currentItem.getMtarget_jumlah();
        String HotelBintang = currentItem.getMhotel_bintang();
        holder.mTextViewIdTrip.setText(IdTrip);
        holder.mTextViewTanggal.setText(Tanggal);
        holder.mTextViewRoute.setText(Route);
    }

    @Override
    public int getItemCount() {
        return mTripList.size();
    }

    public class TripViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextViewIdTrip;
        public TextView mTextViewTanggal;
        public  TextView mTextViewRoute;
        public TripViewHolder(View itemView) {
            super(itemView);
            mTextViewRoute = itemView.findViewById(R.id.route);
            mTextViewIdTrip = itemView.findViewById(R.id.id_trip);
            mTextViewTanggal= itemView.findViewById(R.id.tanggal);

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
