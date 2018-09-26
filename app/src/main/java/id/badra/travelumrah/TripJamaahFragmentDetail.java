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

import id.badra.model.TripJamaah;
import id.badra.model.TripNote;
import id.badra.util.Server;

public class TripJamaahFragmentDetail extends Fragment {
    private TextView idTripJamaah;
    private TextView idTrip;
    private TextView idJamaah;
    private TextView idPaketPerjalanan;
    private TextView idManasik;
    private TextView idTripVisa;
    private  TextView idKk;
    private  TextView relasi;
    private TextView hargaJual;
    private TextView noPaspor;
    private TextView tglPaspor;
    private TextView pasporIssuer;
    private TextView pasporExpDate;
    private TextView paspor;
    private TextView suratNikah;
    private TextView kartuKeluarga;
    private TextView bukuKuning;
    private TextView suratMahrom;
    private TextView foto;
    private TextView buktiTiket;
    private TextView tanggalPengajuan;
    private TextView tanggalMova;
    private TextView tanggalTempelSticker;
    private TextView namaMuasasah;
    private TextView idVendorVisa;
    private TextView hotelBintangMadinah;
    private TextView idHotelMadinah;
    private TextView okupansiMadinah;
    private TextView kateringMadinah;
    private TextView hotelBintangMakkah;
    private TextView idHotelMakkah;
    private TextView okupansiMakkah;
    private TextView kateringMakkah;
    private TextView hotelBintangJeddah;
    private TextView idHotelJeddah;
    private TextView okupansiJeddah;
    private TextView kateringJeddah;
    private TextView routeTambahan;
    private TextView namaJamaah;
    private TextView tanggalManasik;

    private ImageView imgSNote;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.trip_jamaah_fragment_detail, container, false);
//        idTripJamaah = (TextView) rootView.findViewById(R.id.id_trip_note_trip);
//        idTrip =(TextView)rootView.findViewById(R.id.id_trip_note_detail);
//        idJamaah = (TextView)rootView.findViewById(R.id.tanggal_note);
//        idPaketPerjalanan = (TextView)rootView.findViewById(R.id.deskripsi_note);
//        idManasik = (TextView)rootView.findViewById(R.id.deskripsi_note);
//        idTripVisa = (TextView)rootView.findViewById(R.id.deskripsi_note);
        //idKk = (TextView)rootView.findViewById(R.id.deskripsi_note);
        relasi = (TextView)rootView.findViewById(R.id.relasi_jamaah_detail);
//        hargaJual = (TextView)rootView.findViewById(R.id.);
        noPaspor = (TextView)rootView.findViewById(R.id.no_paspor_jamaah_detail);
        tglPaspor = (TextView)rootView.findViewById(R.id.tgl_paspor_detail);
        pasporIssuer = (TextView)rootView.findViewById(R.id.paspor_issuer_detail);
//        pasporExpDate = (TextView)rootView.findViewById(R.id.);
//        paspor = (TextView)rootView.findViewById(R.id.ps);
        suratNikah = (TextView)rootView.findViewById(R.id.surat_nikah_jamaah_detail);
        kartuKeluarga = (TextView)rootView.findViewById(R.id.kartu_keluarga_jamaah_detail);
        bukuKuning = (TextView)rootView.findViewById(R.id.buku_kuning_jamaah_detail);
        suratMahrom = (TextView)rootView.findViewById(R.id.surat_mahrom_jamaah_detail);
//        foto = (TextView)rootView.findViewById(R.id.f);
        buktiTiket = (TextView)rootView.findViewById(R.id.bukti_tiket_jamaah_detail);
        tanggalPengajuan = (TextView)rootView.findViewById(R.id.tanggal_pengajuan_jamaah_detail);
        tanggalMova = (TextView)rootView.findViewById(R.id.tanggal_mova_jamaah_detail);
        tanggalTempelSticker = (TextView)rootView.findViewById(R.id.tgl_tempel_sticker_detail);
        namaMuasasah = (TextView)rootView.findViewById(R.id.nama_muasasah_jamaah_detail);
//        idVendorVisa = (TextView)rootView.findViewById(R.id.deskripsi_note);
        hotelBintangMadinah = (TextView)rootView.findViewById(R.id.hotel_bintang_madinah_jamaah_detail);
        idHotelMadinah = (TextView)rootView.findViewById(R.id.id_hotel_madinah_detail);
        okupansiMadinah = (TextView)rootView.findViewById(R.id.okupansi_madinah_detail);
        kateringMadinah = (TextView)rootView.findViewById(R.id.katering_madinah_detail);
        hotelBintangMakkah = (TextView)rootView.findViewById(R.id.hotel_bintang_makkah_detail);
//        idHotelMakkah = (TextView)rootView.findViewById(R.id.hotel);
        okupansiMakkah = (TextView)rootView.findViewById(R.id.okupansi_makkah_detail);
        kateringMakkah = (TextView)rootView.findViewById(R.id.katering_makkah_detail);
        hotelBintangJeddah = (TextView)rootView.findViewById(R.id.hotel_bintang_jeddah_detail);
//        idHotelJeddah = (TextView)rootView.findViewById(R.id.);
        okupansiJeddah = (TextView)rootView.findViewById(R.id.okupansi_jeddah_detail);
        kateringJeddah = (TextView)rootView.findViewById(R.id.katering_jeddah_detail);
//          = (TextView) rootView.findViewById(R.id.nama_supir_bus_detail);
//        telepon = (TextView) rootView.findViewById(R.id.telepon_supir_bus_detail);
//        imgSNote=(ImageView)rootView.findViewById(R.id.backdrop_path_note_detail);
        TripJamaah panggil = getArguments().getParcelable("trip_jamaah");
        if (panggil!=null){
//            nama.setText(movie.getMnama_supir_ap());
//            idTrip.setText(movie.getMid_trip());
//            telepon.setText(movie.getMsap_mobile());
//            idTripJamaah.setText(panggil.getMid_trip_jamaah());
//            idTrip.setText(panggil.getMid_trip());
//            idJamaah.setText(panggil.getMid_jamaah());
//            idPaketPerjalanan.setText(panggil.getMid_paket_perjalanan());
//            idManasik.setText(panggil.getMid_manasik());
//            idTripVisa.setText(panggil.getMid_trip_visa());
//            idKk.setText(panggil.getMid_kk());
            relasi.setText(panggil.getMrelasi());
//            hargaJual.setText(panggil.getMharga_jual());
            noPaspor.setText(panggil.getMno_paspor());
            tglPaspor.setText(panggil.getMtgl_paspor());
            pasporIssuer.setText(panggil.getMpaspor_isue());
//            pasporExpDate.setText(panggil.getMpaspor_expire_date());
//            paspor.setText(panggil.getMpaspor());
            suratNikah.setText(panggil.getMsurat_nikah());
            kartuKeluarga.setText(panggil.getMkartu_keluarga());
            bukuKuning.setText(panggil.getMbuku_kuning());
            suratMahrom.setText(panggil.getMsurat_mahrom());
//            foto.setText(panggil.getMfoto());
            buktiTiket.setText(panggil.getMbukti_tiket());
            tanggalPengajuan.setText(panggil.getMtanggal_pengajuan());
            tanggalMova.setText(panggil.getMtanggal_mova());
            tanggalTempelSticker.setText(panggil.getMtanggal_tempel_sticker());
            namaMuasasah.setText(panggil.getMnama_muasasah());
//            idVendorVisa.setText(panggil.getMid_vendor_visa());
            hotelBintangMadinah.setText(panggil.getMhotel_bintang_madinah());
            idHotelMadinah.setText(panggil.getMid_hotel_madinah());
            okupansiMadinah.setText(panggil.getMokupansi_madinah());
            kateringMadinah.setText(panggil.getMkatering_madinah());
            hotelBintangMakkah.setText(panggil.getMhotel_bintang_makkah());
//            idHotelMakkah.setText(panggil.getMid_hotel_makkah());
            okupansiMakkah.setText(panggil.getMokupansi_makkah());
            kateringMakkah.setText(panggil.getMkatering_makkah());
            hotelBintangMakkah.setText(panggil.getMhotel_bintang_jeddah());
//            idHotelJeddah.setText(panggil.getMid_hotel_jeddah());
            okupansiJeddah.setText(panggil.getMokupansi_jeddah());
            kateringJeddah.setText(panggil.getMkatering_jeddah());
//            routeTambahan.setText(panggil.getMroute_tambahan());
//            namaJamaah.setText(panggil.getMnama_jamaah());
//            Picasso.with(getActivity().getApplicationContext()).load(Server.ImgSrcApiNote+panggil.getMtanggal()+".png")
//                    .placeholder(R.mipmap.ic_launcher).into(imgSNote);
        }
        return rootView;
    }
}

