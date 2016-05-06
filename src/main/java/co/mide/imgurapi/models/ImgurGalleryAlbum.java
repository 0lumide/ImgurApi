package co.mide.imgurapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImgurGalleryAlbum extends ImgurAlbum {
    @SerializedName("data")
    @Expose

    private ImgurGalleryAlbumData data;
    /**
     *
     * @return
     *     The data
     */
    @Override
    public ImgurGalleryAlbumData getData() {
        return data;
    }

    /**
     *
     * @param data
     *     The data
     */
    public void setData(ImgurGalleryAlbumData data) {
        this.data = data;
    }
}
