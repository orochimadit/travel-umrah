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

import id.badra.model.TripHotel;
import id.badra.model.TripJamaah;
import id.badra.travelumrah.R;
import id.badra.travelumrah.TripHotelFragmentDetail;

public class TripJamaahAdapter extends RecyclerView.Adapter<TripJamaahAdapter.Viewholder>{
    private ArrayList<TripJamaah> model;
    private FragmentManager fms;

    public TripJamaahAdapter(ArrayList<TripJamaah> model, FragmentManager fms) {
        this.model = model;
        this.fms = fms;
    }

    @NonNull
    @Override
    public TripJamaahAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_jamaah_item, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new TripJamaahAdapter.Viewholder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull TripJamaahAdapter.Viewholder holder, final int position) {
        TripJamaah currentItem = model.get(position);

        String id_trip_jamaah              = currentItem.getMid_trip_jamaah();
        String id_trip        = currentItem.getMid_trip();
        String id_trip_paket_perjalanan     = currentItem.getMid_paket_perjalanan();
        String id_manasik                   = currentItem.getMid_manasik();
        String id_trip_visa                 = currentItem.getMid_trip_visa();
        String id_kk                        = currentItem.getMid_kk();
        String relasi                       = currentItem.getMrelasi();
        String harga_jual                   = currentItem.getMharga_jual();
        String no_paspor                    = currentItem.getMno_paspor();
        String tgl_paspor                   = currentItem.getMtgl_paspor();
        String paspor_isue                  = currentItem.getMpaspor_isue();
        String paspor_expire_date           = currentItem.getMpaspor_expire_date();
        String paspor                       = currentItem.getMpaspor();
        String surat_nikah                  = currentItem.getMsurat_nikah();
        String kartu_keluarga               = currentItem.getMkartu_keluarga();
        String buku_kuning                  = currentItem.getMbuku_kuning();
        String surat_mahrom                 = currentItem.getMsurat_mahrom();
        String foto                         = currentItem.getMfoto();
        String bukti_tiket                  = currentItem.getMbukti_tiket();
        String tanggal_pengajuan            = currentItem.getMtanggal_pengajuan();
        String tanggal_mova                 = currentItem.getMtanggal_mova();
        String tanggal_tempel_sticker       = currentItem.getMtanggal_tempel_sticker();
        String nama_muasasah                = currentItem.getMnama_muasasah();
        String id_vendor_visa               = currentItem.getMid_vendor_visa();
        String hotel_bintang_madinah        =currentItem.getMhotel_bintang_madinah();
        String id_hotel_madinah             =currentItem.getMid_hotel_madinah();
        String okupansi_madinah             =currentItem.getMokupansi_madinah();
        String katering_madinah             =currentItem.getMkatering_madinah();
        String hotel_bintang_makkah         =currentItem.getMhotel_bintang_makkah();
        String id_hotel_makkah              =currentItem.getMid_hotel_makkah();
        String okupansi_makkah              =currentItem.getMokupansi_makkah();
        String katering_makkah              =currentItem.getMkatering_makkah();
        String hotel_bintang_jeddah         =currentItem.getMhotel_bintang_jeddah();
        String id_hotel_jeddah              =currentItem.getMid_hotel_jeddah();
        String okupansi_jeddah              =currentItem.getMokupansi_jeddah();
        String katering_jeddah              =currentItem.getMkatering_jeddah();
        String route_tambahan                  =currentItem.getMroute_tambahan();
        String nama_jamaah                  =currentItem.getMnama_jamaah();
        String tanggal_manasik              =currentItem.getMtanggal_manasik();

        holder.mTextViewNamaJamaah.setText(nama_jamaah);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TripJamaah obj = new TripJamaah(model.get(position).getMid_trip_jamaah(),
                        model.get(position).getMid_trip(),
                        model.get(position).getMid_paket_perjalanan(),
                        model.get(position).getMid_jamaah(),
                        model.get(position).getMid_manasik(),
                        model.get(position).getMid_trip_visa(),
                        model.get(position).getMid_kk(),
                        model.get(position).getMrelasi(),
                        model.get(position).getMharga_jual(),
                        model.get(position).getMno_paspor(),
                        model.get(position).getMtgl_paspor(),
                        model.get(position).getMpaspor_isue(),
                        model.get(position).getMpaspor_expire_date(),
                        model.get(position).getMpaspor(),
                        model.get(position).getMsurat_nikah(),
                        model.get(position).getMkartu_keluarga(),
                        //id bank?
                        model.get(position).getMbuku_kuning(),
                        model.get(position).getMsurat_mahrom(),
                        model.get(position).getMfoto(),
                        model.get(position).getMbukti_tiket(),
                        model.get(position).getMtanggal_pengajuan(),
                        model.get(position).getMtanggal_mova(),
                        model.get(position).getMtanggal_tempel_sticker(),
                        model.get(position).getMnama_muasasah(),
                        model.get(position).getMid_vendor_visa(),
                        model.get(position).getMhotel_bintang_madinah(),
                        model.get(position).getMid_hotel_madinah(),
                        model.get(position).getMokupansi_madinah(),
                        model.get(position).getMkatering_madinah(),
                        model.get(position).getMhotel_bintang_makkah(),
                        model.get(position).getMid_hotel_makkah(),
                        model.get(position).getMokupansi_makkah(),
                        model.get(position).getMkatering_makkah(),
                        model.get(position).getMhotel_bintang_jeddah(),
                        model.get(position).getMid_hotel_jeddah(),
                        model.get(position).getMokupansi_jeddah(),
                        model.get(position).getMkatering_jeddah(),
                        model.get(position).getMroute_tambahan(),
                        model.get(position).getMnama_jamaah(),
                        model.get(position).getMtanggal_manasik()
                );
                TripHotelFragmentDetail frgment =   new TripHotelFragmentDetail();
                Bundle args = new Bundle();
                args.putParcelable("trip_jamaah",obj);
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

        public TextView mTextViewNamaJamaah;
        public View mView;
        private ImageView imageViewPoster;

        public Viewholder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextViewNamaJamaah = itemView.findViewById(R.id.nama_jamaah);
        }

//        public void setPosterPath(String posterPath) {
//            //
//            Picasso.with(mView.getContext()).load(StringsAPI.IMAGE_SOURCE+posterPath).placeholder(R.mipmap.ic_launcher)
//                    .into(imageViewPoster);
//        }
    }
}
