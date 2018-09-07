package id.badra.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TripBusItem  implements Parcelable{
    private String mid_bus_booking;
    private String mid_trip;
    private String mtanggal_booking;
    private String mnama_supir_ap;
    private String msap_mobile;
    private String msap_email;
    private String mtgl_ziarah_madinah;
    private String mtgl_ziarah_mekkah;
    private String mtgl_madinah_mekkah;
    private String mnama_vendor;
    public TripBusItem(){

    }
    public TripBusItem(String id_bus_booking,String id_trip, String tanggal_booking, String nama_supir_ap,
                       String sap_mobile,String sap_email,String tgl_madinah_mekkah,String tgl_ziarah_madinah,String tgl_ziarah_mekkah,
                       String nama_vendor
                       ){

        mid_bus_booking=id_bus_booking;
        mid_trip=id_trip;
        mtanggal_booking=tanggal_booking;
        mnama_supir_ap=nama_supir_ap;
        msap_mobile=sap_mobile;
        msap_email=sap_email;
        mtgl_ziarah_mekkah=tgl_ziarah_mekkah;
        mtgl_ziarah_madinah=tgl_ziarah_madinah;
        mtgl_madinah_mekkah=tgl_madinah_mekkah;
        mnama_vendor=nama_vendor;
    }

    public String getMid_trip() {
        return mid_trip;
    }

    public String getMid_bus_booking() {
        return mid_bus_booking;
    }

    public String getMnama_supir_ap() {
        return mnama_supir_ap;
    }

    public String getMsap_email() {
        return msap_email;
    }

    public String getMsap_mobile() {
        return msap_mobile;
    }

    public String getMtanggal_booking() {
        return mtanggal_booking;
    }

    public String getMtgl_ziarah_madinah() {
        return mtgl_ziarah_madinah;
    }

    public String getMtgl_madinah_mekkah() {
        return mtgl_madinah_mekkah;
    }

    public String getMtgl_ziarah_mekkah() {
        return mtgl_ziarah_mekkah;
    }

    public String getMnama_vendor() {
        return mnama_vendor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mid_bus_booking);
        dest.writeString(this.mid_trip);
        dest.writeString(this.mnama_supir_ap);
        dest.writeString(this.mtanggal_booking);
        dest.writeString(this.msap_mobile);
        dest.writeString(this.msap_email);
        dest.writeString(this.mtgl_ziarah_mekkah);
        dest.writeString(this.mtgl_ziarah_madinah);
        dest.writeString(this.mtgl_madinah_mekkah);
        dest.writeString(this.mnama_vendor);
    }

    protected TripBusItem(Parcel in) {
        this.mid_bus_booking = in.readString();
        this.mid_trip = in.readString();
        this.mnama_supir_ap = in.readString();
        this.mtanggal_booking = in.readString();
        this.msap_mobile = in.readString();
        this.msap_email= in.readString();
        this.mtgl_ziarah_mekkah = in.readString();
        this.mtgl_ziarah_madinah= in.readString();
        this.mtgl_madinah_mekkah= in.readString();
        this.mnama_vendor=in.readString();
    }

    public static final Parcelable.Creator<TripBusItem> CREATOR = new Parcelable.Creator<TripBusItem>() {
        @Override
        public TripBusItem createFromParcel(Parcel source) {
            return new TripBusItem(source);
        }

        @Override
        public TripBusItem[] newArray(int size) {
            return new TripBusItem[size];
        }
    };
}
