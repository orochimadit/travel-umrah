package id.badra.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TripHotel implements Parcelable{
    private String mid_trip_hotel1;
    private String mid_trip_la_paket;
    private String mid_trip;
    private String mid_hotel;
    private String mid_vendor;
    private String mtanggal_booking;
    private String mtanggal_checkin;
    private String mlength_of_stay;
    private String mtanggal_checkout;
    private String mjenis_kamar;
    private String mopsi_kamar;
    private String mharga_sewa;
    private String mjumlah_room;
    private String mview;
    private String mprofit_margin;
    private String mrekening;
    private String mharga_jual;
    private String mbooking_fee;
    private String mbooking_fee_currency;
    private String mcontact_mobile;
    private String mcontact_email;
    private String mreview;
    private String mstatus;
    private String mnama_hotel;
    private String mbintang;
    private String mnama_vendor;

    public TripHotel(){

    }
    public TripHotel(String id_trip_hotel1,String id_trip_la_hotel,String id_trip,String id_hotel,String id_vendor,
                     String tanggal_booking,String tanggal_checkin,String length_of_stay,String tanggal_checkout,String jenis_kamar,
                     String opsi_kamar,String harga_sewa,String jumlah_room,String view,String profit_margin,
                     String rekening,String harga_jual,String booking_fee,String booking_fee_currency,String contact_mobile,
                     String contact_email,String review,String status,String nama_hotel,String bintang,String nama_vendor){

        mid_trip_hotel1     =id_trip_hotel1;
        mid_trip_hotel1     =id_trip_la_hotel;
        mid_trip            =id_trip;
        mid_hotel           =id_hotel;
        mid_vendor          =id_vendor;
        mtanggal_booking    =tanggal_booking;
        mtanggal_checkin    =tanggal_checkin;
        mlength_of_stay     =length_of_stay;
        mtanggal_checkout   =tanggal_checkout;
        mjenis_kamar        =jenis_kamar;
        mopsi_kamar         = opsi_kamar;
        mharga_sewa         = harga_sewa;
        mjumlah_room        = jumlah_room;
        mview               = view;
        mprofit_margin      =profit_margin;
        mrekening           =rekening;
        mharga_jual         = harga_jual;
        mbooking_fee        = booking_fee;
        mbooking_fee_currency=booking_fee_currency;
        mcontact_mobile     =contact_mobile;
        mcontact_email      =contact_email;
        mreview             =review;
        mstatus             =status;
        mnama_hotel         =nama_hotel;
        mbintang            =bintang;
        mnama_vendor        =nama_vendor;
    }

    public String getMid_hotel() {
        return mid_hotel;
    }

    public String getMid_trip_la_paket() {
        return mid_trip_la_paket;
    }

    public String getMid_trip_hotel1() {
        return mid_trip_hotel1;
    }

    public String getMid_trip() {
        return mid_trip;
    }

    public String getMid_vendor() {
        return mid_vendor;
    }

    public String getMtanggal_booking() {
        return mtanggal_booking;
    }

    public String getMtanggal_checkin() {
        return mtanggal_checkin;
    }

    public String getMharga_jual() {
        return mharga_jual;
    }

    public String getMnama_vendor() {
        return mnama_vendor;
    }

    public String getMbintang() {
        return mbintang;
    }

    public String getMlength_of_stay() {
        return mlength_of_stay;
    }

    public String getMbooking_fee() {
        return mbooking_fee;
    }

    public String getMbooking_fee_currency() {
        return mbooking_fee_currency;
    }

    public String getMjenis_kamar() {
        return mjenis_kamar;
    }

    public String getMcontact_email() {
        return mcontact_email;
    }

    public String getMcontact_mobile() {
        return mcontact_mobile;
    }

    public String getMharga_sewa() {
        return mharga_sewa;
    }

    public String getMjumlah_room() {
        return mjumlah_room;
    }

    public String getMtanggal_checkout() {
        return mtanggal_checkout;
    }

    public String getMnama_hotel() {
        return mnama_hotel;
    }

    public String getMopsi_kamar() {
        return mopsi_kamar;
    }

    public String getMprofit_margin() {
        return mprofit_margin;
    }

    public String getMrekening() {
        return mrekening;
    }

    public String getMreview() {
        return mreview;
    }

    public String getMstatus() {
        return mstatus;
    }

    public String getMview() {
        return mview;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mid_trip_hotel1);
        dest.writeString(this.mid_trip_la_paket);
        dest.writeString(this.mid_trip);
        dest.writeString(this.mid_hotel);
        dest.writeString(this.mid_vendor);
        dest.writeString(this.mtanggal_booking);
        dest.writeString(this.mtanggal_checkin);
        dest.writeString(this.mlength_of_stay);
        dest.writeString(this.mtanggal_checkout);
        dest.writeString(this.mjenis_kamar);
        dest.writeString(this.mopsi_kamar);
        dest.writeString(this.mharga_sewa);
        dest.writeString(this.mjumlah_room);
        dest.writeString(this.mview);
        dest.writeString(this.mprofit_margin);
        dest.writeString(this.mrekening);
        dest.writeString(this.mharga_jual);
        dest.writeString(this.mbooking_fee);
        dest.writeString(this.mbooking_fee_currency);
        dest.writeString(this.mcontact_mobile);
        dest.writeString(this.mcontact_email);
        dest.writeString(this.mreview);
        dest.writeString(this.mstatus);
        dest.writeString(this.mnama_hotel);
        dest.writeString(this.mbintang);
        dest.writeString(this.mnama_vendor);
    }

    protected TripHotel(Parcel in) {
        this.mid_trip_hotel1 = in.readString();
        this.mid_trip_la_paket = in.readString();
        this.mid_trip = in.readString();
        this.mid_hotel = in.readString();
        this.mid_vendor=in.readString();
        this.mtanggal_booking=in.readString();
        this.mtanggal_checkin=in.readString();
        this.mtanggal_checkout=in.readString();
        this.mlength_of_stay=in.readString();
        this.mjenis_kamar=in.readString();
        this.mopsi_kamar=in.readString();
        this.mharga_sewa=in.readString();
        this.mjumlah_room=in.readString();
        this.mview      =in.readString();
        this.mprofit_margin=in.readString();
        this.mrekening=in.readString();
        this.mharga_jual=in.readString();
        this.mbooking_fee=in.readString();
        this.mbooking_fee_currency=in.readString();
        this.mcontact_mobile=in.readString();
        this.mcontact_email=in.readString();
        this.mreview=in.readString();
        this.mstatus=in.readString();
        this.mnama_hotel=in.readString();
        this.mbintang=in.readString();
        this.mnama_vendor=in.readString();
    }

    public static final Parcelable.Creator<TripHotel> CREATOR = new Parcelable.Creator<TripHotel>() {
        @Override
        public TripHotel createFromParcel(Parcel source) {
            return new TripHotel(source);
        }

        @Override
        public TripHotel[] newArray(int size) {
            return new TripHotel[size];
        }
    };
}
