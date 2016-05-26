package co.mide.imgurapi;

import co.mide.imgurapi.models.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Simple retrofit interface for the imgur api
 * Created by Olumide on 4/26/2016.
 */
interface ImgurApiService {
    @GET("gallery/image/{id}")
    Call<ImgurGalleryImage> getGalleryImage(@Header("Authorization") String clientID, @Path("id") String imageID);
    @GET("album/{id}")
    Call<ImgurAlbum> getAlbum(@Header("Authorization") String clientID, @Path("id") String albumID);
    @GET("image/{id}")
    Call<ImgurImage> getImage(@Header("Authorization") String clientID, @Path("id") String imageID);
    @GET("gallery/album/{id}")
    Call<ImgurGalleryAlbum> getGalleryAlbum(@Header("Authorization") String clientID, @Path("id") String albumID);
    @GET("gallery/hot/viral/{page}?showViral=true")
    Call<ImgurGallery> getRecentHot(@Header("Authorization") String clientID, @Path("page") int page);
}