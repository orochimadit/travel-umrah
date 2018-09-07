package id.badra.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TripAirline implements Parcelable{
    private String mid_trip_airline;
    private String mid_airline_booking;
    private String mid_trip;
    private String mjumlah;
    private String mharga_jual;
    private String mflight_id_dep;
    private String mflight_id_ret;
    private String mtanggal_departure;
    private String mjumlah_seat_quota;
    private String mbooking_status;
    private String mharga;


    public TripAirline(){}

    public TripAirline(String id_trip_airline,String id_airline_booking,String id_trip,String jumlah,
                       String harga_jual,String flight_id_dep,String flight_id_ret,String tanggal_departure,String jumlah_seat_quota,
                        String booking_status, String harga){

        mid_trip_airline=id_trip_airline;
        mid_airline_booking=id_airline_booking;
        mid_trip=id_trip;
        mjumlah=jumlah;
        mharga_jual=harga_jual;
        mflight_id_dep=flight_id_dep;
        mflight_id_ret=flight_id_ret;
        mtanggal_departure=tanggal_departure;
        mjumlah_seat_quota=jumlah_seat_quota;
        mbooking_status=booking_status;
        mharga=harga;
    }

    public String getMid_trip_airline() {
        return mid_trip_airline;
    }

    public String getMid_airline_booking() {
        return mid_airline_booking;
    }

    public String getMid_trip() {
        return mid_trip;
    }

    public String getMjumlah() {
        return mjumlah;
    }

    public String getMflight_id_dep() {
        return mflight_id_dep;
    }

    public String getMflight_id_ret() {
        return mflight_id_ret;
    }

    public String getMharga_jual() {
        return mharga_jual;
    }

    public String getMbooking_status() {
        return mbooking_status;
    }

    public String getMtanggal_departure() {
        return mtanggal_departure;
    }

    public String getMjumlah_seat_quota() {
        return mjumlah_seat_quota;
    }

    public String getMharga() {
        return mharga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mid_airline_booking);
        dest.writeString(this.mid_trip_airline);
        dest.writeString(this.mid_trip);
        dest.writeString(this.mjumlah);
        dest.writeString(this.mharga_jual);
        dest.writeString(this.mflight_id_dep);
        dest.writeString(this.mflight_id_ret);
        dest.writeString(this.mtanggal_departure);
        dest.writeString(this.mbooking_status);
        dest.writeString(this.mharga);
    }
    protected  TripAirline(Parcel in){
        this.mid_airline_booking=in.readString();
        this.mid_trip_airline=in.readString();
        this.mid_trip= in.readString();
        this.mjumlah=in.readString();
        this.mharga_jual=in.readString();
        this.mflight_id_dep=in.readString();
        this.mflight_id_ret=in.readString();
        this.mtanggal_departure=in.readString();
        this.mbooking_status=in.readString();
        this.mharga=in.readString();
    }
    public static final Parcelable.Creator<TripAirline> CREATOR = new Parcelable.Creator<TripAirline>() {
        @Override
        public TripAirline createFromParcel(Parcel source) {
            return new TripAirline(source);
        }

        @Override
        public TripAirline[] newArray(int size) {
            return new TripAirline[size];
        }
    };
}
