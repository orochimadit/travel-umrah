package id.badra.util;

import android.net.Uri;

import java.net.URI;
import java.net.URISyntaxException;

public class Server
{
    public static final String URL = "http://umrah.kamusminang.com/api/";
    public static final String ImgSrc="http://umrah.kamusminang.com/gambar/foto/";
//    public static final String ImgSrcApi="http://umrah.kamusminang.com/api/trip_galeri_image/";

 public static String ImgSrcApi="http://umrah.kamusminang.com/api/trip_galeri_image/";
//    URI uri = new URI(ImgSrcApi.replace(" ","%20"));

    public static final String ImgSrcApiNote="http://umrah.kamusminang.com/api/note_image/";

    public Server() throws URISyntaxException {
    }
}
