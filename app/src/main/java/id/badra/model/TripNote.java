package id.badra.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TripNote implements Parcelable {
    private String mid_trip_note;
    private String mid_trip;
    private String mtanggal;
    private String mdeskripsi;

    public TripNote(){
    }
    public TripNote(String id_trip_note,String id_trip, String tanggal, String deskripsi
    ){
    mid_trip_note=id_trip_note;
    mid_trip=id_trip;
    mtanggal=tanggal;
    mdeskripsi=deskripsi;

    }

    public String getMid_trip() {
        return mid_trip;
    }

    public String getMid_trip_note() {
        return mid_trip_note;
    }

    public String getMtanggal() {
        return mtanggal;
    }

    public String getMdeskripsi() {
        return mdeskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mid_trip);
        dest.writeString(this.mid_trip_note);
        dest.writeString(this.mdeskripsi);
        dest.writeString(this.mtanggal);
    }
    protected  TripNote(Parcel in){
        this.mid_trip_note=in.readString();
        this.mid_trip=in.readString();
        this.mdeskripsi=in.readString();
        this.mtanggal=in.readString();
    }


    public static final Parcelable.Creator<TripNote> CREATOR = new Parcelable.Creator<TripNote>() {
        @Override
        public TripNote createFromParcel(Parcel source) {
            return new TripNote(source);
        }

        @Override
        public TripNote[] newArray(int size) {
            return new TripNote[size];
        }
    };

}

