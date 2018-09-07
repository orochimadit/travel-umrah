package id.badra.travelumrah;

public class TripItem {
    private String mid_trip;
    private String mtanggal;
    private String mroute;
    private String mtarget_jumlah;
    private String mhotel_bintang;

    public TripItem(String id_trip,String tanggal,String route,String target_jumlah,String hotel_bintang){
        mid_trip=id_trip;
        mtanggal=tanggal;
        mroute=route;
        mtarget_jumlah=target_jumlah;
        mhotel_bintang=hotel_bintang;
    }

    public String getMhotel_bintang() {
        return mhotel_bintang;
    }

    public String getMid_trip() {
        return mid_trip;
    }

    public String getMroute() {
        return mroute;
    }

    public String getMtanggal() {
        return mtanggal;
    }

    public String getMtarget_jumlah() {
        return mtarget_jumlah;
    }
}
