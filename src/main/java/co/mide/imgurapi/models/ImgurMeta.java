package co.mide.imgurapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Olumide on 4/27/2016.
 */
public abstract class ImgurMeta{
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status")
    @Expose
    private Integer status;

    /**
     *
     * @return
     *     The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     *     The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     *     The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
