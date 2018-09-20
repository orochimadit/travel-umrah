package id.badra.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TripGaleri implements Parcelable {
private String mid_trip_galeri;
private String mid_trip;
private String mfoto;
private String mcaption;

public TripGaleri(){}

public TripGaleri(String id_trip_galeri,String id_trip,String foto,String caption){
    mid_trip_galeri=id_trip_galeri;
    mid_trip        =id_trip;
    mfoto           =foto;
    mcaption        =caption;
}

    public String getMid_trip() {
        return mid_trip;
    }

    public String getMid_trip_galeri() {
        return mid_trip_galeri;
    }

    public String getMfoto() {
        return mfoto;
    }

    public String getMcaption() {
        return mcaption;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mid_trip_galeri);
        dest.writeString(this.mid_trip);
        dest.writeString(this.mcaption);
        dest.writeString(this.mfoto);
    }

    protected TripGaleri(Parcel in) {
        this.mid_trip_galeri = in.readString();
        this.mid_trip        =in.readString();
        this.mcaption           =in.readString();
        this.mfoto              =in.readString();

    }

    public static final Parcelable.Creator<TripGaleri> CREATOR = new Parcelable.Creator<TripGaleri>() {
        @Override
        public TripGaleri createFromParcel(Parcel source) {
            return new TripGaleri(source);
        }

        @Override
        public TripGaleri[] newArray(int size) {
            return new TripGaleri[size];
        }
    };
}
