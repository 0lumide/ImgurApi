package co.mide.imgurapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Object to represent an imgur image
 * Created by Olumide on 4/27/2016.
 */
public class ImgurImage extends ImgurMeta {
    @SerializedName("data")
    @Expose

    private ImgurImageData data;
    /**
     *
     * @return
     *     The data
     */
    public ImgurImageData getData() {
        return data;
    }

    /**
     *
     * @param data
     *     The data
     */
    public void setData(ImgurImageData data) {
        this.data = data;
    }

}

