package co.mide.imgurapi;

import co.mide.imgurapi.models.ImgurAlbum;
import co.mide.imgurapi.models.ImgurGallery;
import co.mide.imgurapi.models.ImgurImage;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.istack.internal.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * This is the class that provides all the entry points to the imgur api
 * Created by Olumide on 4/27/2016.
 */
public class ImgurApi {
    private ImgurApiService apiService;
    private String AUTHORIZATION_HEADER;
    private final String CLIENT_ID;

    /**
     * This constructs a new ImgurApi object which can be used to retrieve info from imgur
     * The IMGUR_CLIENT_ID environment variable has to be set, or else this throws an exception
     * @throws MissingEnvironmentVariableException when the environment variable is not set
     */
    public ImgurApi(){
        String clientID = getEnvironmentVariable("IMGUR_CLIENT_ID");
        if(clientID == null){
            throw new MissingEnvironmentVariableException("IMGUR_CLIENT_ID");
        }
        this.CLIENT_ID = clientID;
        setup();
    }

    private static String getEnvironmentVariable(String name){
        String value = System.getenv(name);
        if (value == null || value.length() == 0) {
            return null;
        }
        return value;
    }

    /**
     * This constructs a new ImgurApi object which can be used to retrieve info from imgur
     * @param clientID this is the CLIENT ID created for you when you create an imgur application
     */
    public ImgurApi(@NotNull String clientID){
        if(clientID == null){
            throw new IllegalArgumentException("clientID cannot be null");
        }
        this.CLIENT_ID = clientID;
        setup();
    }

    void setRetrofit(Retrofit retrofit){
        apiService = retrofit.create(ImgurApiService.class);
    }

    private void setup(){
        this.AUTHORIZATION_HEADER = "Client-ID "+this.CLIENT_ID;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgur.com/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        setRetrofit(retrofit);
    }

    /**
     * Asynchronously retrieves an album from imgur. It also works for albums that are not submitted to the gallery.
     * @param albumId the unique id of the album to retrieve.
     * @param callback the callback that's called when successful or not
     */
    public void getAlbum(@NotNull String albumId, @NotNull ImgurCallback<ImgurAlbum> callback){
        Call<ImgurAlbum> call = apiService.getAlbum(AUTHORIZATION_HEADER, albumId);
        call.enqueue(new Callback<ImgurAlbum>() {
            @Override
            public void onResponse(Call<ImgurAlbum> call, Response<ImgurAlbum> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(response.body());
                } else {
                    handleUnsuccessfulResponse(response, callback);
                }
            }

            @Override
            public void onFailure(Call<ImgurAlbum> call, Throwable t) {
                // something went completely south (like no internet connection)
                callback.onError(t.getMessage());
            }
        });
    }


    /**
     * Synchronously retrieves an album from imgur. It also works for albums that are not submitted to the gallery.
     * It returns null if the album doesn't exist or can't be accessed.
     * @throws IOException It throws IOException when communication did not occur between the server
     */
    public ImgurAlbum getAlbumSync(@NotNull String albumId) throws IOException{
        Call<ImgurAlbum> call = apiService.getAlbum(AUTHORIZATION_HEADER, albumId);
        return call.execute().body();
    }


    /**
     * Asynchronously retrieves an image from imgur. It also works for images that are not submitted to the gallery.
     * @param imageId the unique id of the image to retrieve.
     * @param callback the callback that's called when successful or not
     */
    public void getImage(String imageId, ImgurCallback<ImgurImage> callback){
        Call<ImgurImage> call = apiService.getImage(AUTHORIZATION_HEADER, imageId);
        call.enqueue(new Callback<ImgurImage>() {
            @Override
            public void onResponse(Call<ImgurImage> call, Response<ImgurImage> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(response.body());
                } else {
                    handleUnsuccessfulResponse(response, callback);
                }
            }

            @Override
            public void onFailure(Call<ImgurImage> call, Throwable t) {
                // something went completely south (like no internet connection)
                callback.onError(t.getMessage());
            }
        });
    }

    private void handleUnsuccessfulResponse(Response response, ImgurCallback callback){
        try {
            //try to retrieve the error message from imgur and send that in the callback
            JsonElement jsonElement = new JsonParser().parse(response.errorBody().string());
            String errorMessage = jsonElement.getAsJsonObject().getAsJsonObject("data").get("error").getAsString();
            callback.onError(errorMessage);
        }catch (Exception e) {
            e.printStackTrace();
            //Use the status message if retrofit knows what it is, otherwise just a generic response
            if(response.message() != null)
                callback.onError(response.message());
            else
                callback.onError("Unknown error");
        }
    }

    /**
     * Synchronously retrieves an image from imgur. It also works for images that are not submitted to the gallery.
     * It returns null if the image doesn't exist or can't be accessed.
     * @throws IOException It throws IOException when communication did not occur between the server
     */
    public ImgurImage getImageSync(@NotNull String imageId) throws IOException{
        Call<ImgurImage> call = apiService.getImage(AUTHORIZATION_HEADER, imageId);
        return call.execute().body();
    }

    /**
     * This asynchronously retrieves the the first page of the imgur front page.
     * It retrieves the hot page.
     * @param callback this is the callback that is called when the results are ready
     */
    public void getHot(@NotNull ImgurCallback<ImgurGallery> callback){
        Call<ImgurGallery> call = apiService.getRecentHot(AUTHORIZATION_HEADER);
        call.enqueue(new Callback<ImgurGallery>() {
            @Override
            public void onResponse(Call<ImgurGallery> call, Response<ImgurGallery> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(response.body());
                } else {
                    handleUnsuccessfulResponse(response, callback);
                }
            }

            @Override
            public void onFailure(Call<ImgurGallery> call, Throwable t) {
                // something went completely south (like no internet connection)
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * This synchronously retrieves the the first page of the imgur front page.
     * It retrieves the hot page.
     * @return The first page of the imgur hot gallery, i.e the front page
     * @throws IOException
     */
    public ImgurGallery getHotSync() throws IOException{
        Call<ImgurGallery> call = apiService.getRecentHot(AUTHORIZATION_HEADER);
        return call.execute().body();
    }
}

class MissingEnvironmentVariableException extends RuntimeException{
    MissingEnvironmentVariableException(String variableName){
        super(String.format("The %s environment variable is not set", variableName));
    }
}