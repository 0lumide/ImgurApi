
package co.mide.imgurapi.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ImgurGallery extends ImgurMeta{

    @SerializedName("data")
    @Expose
    private List<ImgurGalleryData> data = new ArrayList<ImgurGalleryData>();

    /**
     * 
     * @return
     *     The data
     */
    public List<ImgurGalleryData> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<ImgurGalleryData> data) {
        this.data = data;
    }
}
