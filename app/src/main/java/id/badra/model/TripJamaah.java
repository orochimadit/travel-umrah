package id.badra.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TripJamaah implements Parcelable{
    private String mid_trip_jamaah;
    private String mid_trip;
    private String mid_jamaah;
    private String mid_paket_perjalanan;
    private String mid_manasik;
    private String mid_trip_visa;
    private String mid_kk;
    private String mrelasi;
    private String mharga_jual;
    private String mno_paspor;
    private String mtgl_paspor;
    private String mpaspor_isue;
    private String mpaspor_expire_date;
    private String mpaspor;
    private String msurat_nikah;
    private String mkartu_keluarga;
    private String mbuku_kuning;
    private String msurat_mahrom;
    private String mfoto;
    private String mbukti_tiket;
    private String mtanggal_pengajuan;
    private String mtanggal_mova;
    private String mtanggal_tempel_sticker;
    private String mnama_muasasah;
    private String mid_vendor_visa;
    private String mhotel_bintang_madinah;
    private String mid_hotel_madinah;
    private String mokupansi_madinah;
    private String mkatering_madinah;
    private String mhotel_bintang_makkah;
    private String mid_hotel_makkah;
    private String mokupansi_makkah;
    private String mkatering_makkah;
    private String mhotel_bintang_jeddah;
    private String mid_hotel_jeddah;
    private String mokupansi_jeddah;
    private String mkatering_jeddah;
    private String mroute_tambahan;
    private String mnama_jamaah;
    private String mtanggal_manasik;

public TripJamaah(){
}


public TripJamaah(String id_trip_jamaah,String id_trip,String id_jamaah,String id_paket_perjalanan,String id_manasik,
                  String id_trip_visa,String id_kk,String relasi,String harga_jual, String no_paspor,String tgl_paspor,
                  String paspor_issuer,String paspor_expire_date,String paspor,String surat_nikah,String kartu_keluarga,
                  String buku_kuning,String surat_mahrom,String foto,String bukti_tiket,String tanggal_pengajuan,String tanggal_mova,
                  String tanggal_tempel_sticker,String nama_muasasah,
                  String id_vendor_visa,String hotel_bintang_madinah,String id_hotel_madinah,
                  String okupansi_madinah,String katering_madinah,
                  String hotel_bintang_makkah,String id_hotel_makkah,String okupansi_makkah,String katering_makkah,
                  String hotel_bintang_jeddah,String id_hotel_jeddah,String okupansi_jeddah,String katering_jeddah,
                  String route_tambahan, String nama_jamaah,String tgl_manasik
                  ){

    mid_trip_jamaah         = id_trip_jamaah;
    mid_trip                = id_trip;
    mid_jamaah              = id_jamaah;
    mid_paket_perjalanan    = id_paket_perjalanan;
    mid_manasik             =id_manasik;
    mid_trip_visa           =id_trip_visa;
    mid_kk                  =id_kk;
    mrelasi                 =relasi;
    mharga_jual             =harga_jual;
    mno_paspor              =no_paspor;
    mtgl_paspor             =tgl_paspor;
    mpaspor_isue            =paspor_issuer;
    mpaspor_expire_date     =paspor_expire_date;
    mpaspor                 =paspor;
    msurat_nikah            =surat_nikah;
    mkartu_keluarga         =kartu_keluarga;
    mbuku_kuning            =buku_kuning;
    msurat_mahrom           =surat_mahrom;
    mfoto                   =foto;
    mbukti_tiket            =bukti_tiket;
    mtanggal_pengajuan      =tanggal_pengajuan;
    mtanggal_mova           =tanggal_mova;
    mtanggal_tempel_sticker =tanggal_tempel_sticker;
    mnama_muasasah          =nama_muasasah;
    mid_vendor_visa         =id_vendor_visa;
    mhotel_bintang_madinah  =hotel_bintang_madinah;
    mid_hotel_madinah       =hotel_bintang_madinah;
    mokupansi_madinah       =okupansi_madinah;
    mkatering_madinah       =katering_madinah;
    mhotel_bintang_makkah   =hotel_bintang_makkah;
    mid_hotel_makkah        =id_hotel_makkah;
    mokupansi_makkah        =okupansi_makkah;
    mkatering_makkah        =katering_makkah;
    mid_hotel_jeddah        =id_hotel_jeddah;
    mokupansi_jeddah        =okupansi_jeddah;
    mkatering_jeddah        =katering_jeddah;
    mnama_jamaah            =nama_jamaah;
    mtanggal_manasik        =tgl_manasik;
}


    public String getMid_trip() {
        return mid_trip;
    }

    public String getMid_jamaah() {
        return mid_jamaah;
    }

    public String getMid_manasik() {
        return mid_manasik;
    }

    public String getMid_paket_perjalanan() {
        return mid_paket_perjalanan;
    }

    public String getMid_kk() {
        return mid_kk;
    }

    public String getMid_trip_jamaah() {
        return mid_trip_jamaah;
    }

    public String getMharga_jual() {
        return mharga_jual;
    }

    public String getMid_trip_visa() {
        return mid_trip_visa;
    }

    public String getMrelasi() {
        return mrelasi;
    }

    public String getMfoto() {
        return mfoto;
    }

    public String getMbukti_tiket() {
        return mbukti_tiket;
    }

    public String getMbuku_kuning() {
        return mbuku_kuning;
    }

    public String getMhotel_bintang_jeddah() {
        return mhotel_bintang_jeddah;
    }

    public String getMhotel_bintang_madinah() {
        return mhotel_bintang_madinah;
    }

    public String getMhotel_bintang_makkah() {
        return mhotel_bintang_makkah;
    }

    public String getMid_hotel_jeddah() {
        return mid_hotel_jeddah;
    }

    public String getMid_hotel_madinah() {
        return mid_hotel_madinah;
    }

    public String getMid_hotel_makkah() {
        return mid_hotel_makkah;
    }

    public String getMid_vendor_visa() {
        return mid_vendor_visa;
    }

    public String getMkartu_keluarga() {
        return mkartu_keluarga;
    }

    public String getMkatering_madinah() {
        return mkatering_madinah;
    }

    public String getMkatering_jeddah() {
        return mkatering_jeddah;
    }

    public String getMkatering_makkah() {
        return mkatering_makkah;
    }

    public String getMnama_muasasah() {
        return mnama_muasasah;
    }

    public String getMno_paspor() {
        return mno_paspor;
    }

    public String getMnama_jamaah() {
        return mnama_jamaah;
    }

    public String getMokupansi_jeddah() {
        return mokupansi_jeddah;
    }

    public String getMokupansi_madinah() {
        return mokupansi_madinah;
    }

    public String getMokupansi_makkah() {
        return mokupansi_makkah;
    }

    public String getMpaspor() {
        return mpaspor;
    }

    public String getMpaspor_expire_date() {
        return mpaspor_expire_date;
    }

    public String getMpaspor_isue() {
        return mpaspor_isue;
    }

    public String getMsurat_mahrom() {
        return msurat_mahrom;
    }

    public String getMsurat_nikah() {
        return msurat_nikah;
    }

    public String getMtgl_paspor() {
        return mtgl_paspor;
    }

    public String getMroute_tambahan() {
        return mroute_tambahan;
    }

    public String getMtanggal_manasik() {
        return mtanggal_manasik;
    }

    public String getMtanggal_mova() {
        return mtanggal_mova;
    }

    public String getMtanggal_pengajuan() {
        return mtanggal_pengajuan;
    }

    public String getMtanggal_tempel_sticker() {
        return mtanggal_tempel_sticker;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mid_trip_jamaah);
        dest.writeString(this.mid_trip);
        dest.writeString(this.mid_jamaah);
        dest.writeString(this.mid_paket_perjalanan);
        dest.writeString(this.mid_manasik);
        dest.writeString(this.mid_trip_visa);
        dest.writeString(this.mid_kk);
        dest.writeString(this.mrelasi);
        dest.writeString(this.mharga_jual);
        dest.writeString(this.mno_paspor);
        dest.writeString(this.mtgl_paspor);
        dest.writeString(this.mpaspor_isue);
        dest.writeString(this.mpaspor_expire_date);
        dest.writeString(this.mpaspor);
        dest.writeString(this.msurat_nikah);
        dest.writeString(this.mkartu_keluarga);
        dest.writeString(this.mbuku_kuning);
        dest.writeString(this.msurat_mahrom);
        dest.writeString(this.mfoto);
        dest.writeString(this.mbukti_tiket);
        dest.writeString(this.mtanggal_pengajuan);
        dest.writeString(this.mtanggal_mova);
        dest.writeString(this.mtanggal_tempel_sticker);
        dest.writeString(this.mnama_muasasah);
        dest.writeString(this.mid_vendor_visa);
        dest.writeString(this.mhotel_bintang_madinah);
        dest.writeString(this.mid_hotel_madinah);
        dest.writeString(this.mokupansi_madinah);
        dest.writeString(this.mkatering_madinah);
        dest.writeString(this.mhotel_bintang_makkah);
        dest.writeString(this.mid_hotel_makkah);
        dest.writeString(this.mokupansi_makkah);
        dest.writeString(this.mkatering_makkah);
        dest.writeString(this.mhotel_bintang_jeddah);
        dest.writeString(this.mid_hotel_jeddah);
        dest.writeString(this.mokupansi_jeddah);
        dest.writeString(this.mkatering_jeddah);
        dest.writeString(this.mroute_tambahan);
        dest.writeString(this.mnama_jamaah);
        dest.writeString(this.mtanggal_manasik);
    }

    protected TripJamaah(Parcel in) {
        this.mid_trip_jamaah = in.readString();
        this.mid_trip = in.readString();
        this.mid_jamaah = in.readString();
        this.mid_paket_perjalanan = in.readString();
        this.mid_manasik=in.readString();
        this.mid_trip_visa=in.readString();
        this.mid_kk=in.readString();
        this.mrelasi=in.readString();
        this.mharga_jual=in.readString();
        this.mno_paspor=in.readString();
        this.mtgl_paspor=in.readString();
        this.mpaspor_isue=in.readString();
        this.mpaspor_expire_date=in.readString();
        this.mpaspor      =in.readString();
        this.msurat_nikah=in.readString();
        this.mkartu_keluarga=in.readString();
        this.mbuku_kuning=in.readString();
        this.msurat_mahrom=in.readString();
        this.mfoto=in.readString();
        this.mbukti_tiket=in.readString();
        this.mtanggal_pengajuan=in.readString();
        this.mtanggal_mova=in.readString();
        this.mtanggal_tempel_sticker=in.readString();
        this.mnama_muasasah=in.readString();
        this.mid_vendor_visa=in.readString();
        this.mhotel_bintang_madinah=in.readString();
        this.mid_hotel_madinah=in.readString();
        this.mokupansi_madinah=in.readString();
        this.mkatering_madinah=in.readString();
        this.mhotel_bintang_makkah=in.readString();
        this.mid_hotel_makkah=in.readString();
        this.mokupansi_makkah=in.readString();
        this.mkatering_makkah=in.readString();
        this.mhotel_bintang_jeddah=in.readString();
        this.mid_hotel_jeddah=in.readString();
        this.mokupansi_jeddah=in.readString();
        this.mkatering_jeddah=in.readString();
        this.mroute_tambahan=in.readString();
        this.mnama_jamaah=in.readString();
        this.mtanggal_manasik=in.readString();

    }

    public static final Parcelable.Creator<TripJamaah> CREATOR = new Parcelable.Creator<TripJamaah>() {

        @Override
        public TripJamaah createFromParcel(Parcel source) {
            return new TripJamaah(source);
        }

        @Override
        public TripJamaah[] newArray(int size) {
            return new TripJamaah[size];
        }
    };
}
