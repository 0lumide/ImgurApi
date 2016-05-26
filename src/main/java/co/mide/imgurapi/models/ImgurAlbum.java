package co.mide.imgurapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Object to represent an Imgur Album
 * Created by Olumide on 4/27/2016.
 */
public class ImgurAlbum extends ImgurMeta {
    @SerializedName("data")
    @Expose

    private ImgurAlbumData data;
    /**
     *
     * @return
     *     The data
     */
    public ImgurAlbumData getData() {
        return data;
    }

    /**
     *
     * @param data
     *     The data
     */
    public void setData(ImgurAlbumData data) {
        this.data = data;
    }
}
