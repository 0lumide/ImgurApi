package co.mide.imgurapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * For future implementation
 * Created by Olumide on 4/27/2016.
 */
public class ImgurGalleryImage extends ImgurImage {
    @SerializedName("data")
    @Expose
    private ImgurGalleryImageData data;
    /**
     *
     * @return
     *     The data
     */
    @Override
    public ImgurGalleryImageData getData() {
        return data;
    }

    /**
     *
     * @param data
     *     The data
     */
    public void setData(ImgurGalleryImageData data) {
        super.setData(data);
        this.data = data;
    }
}
