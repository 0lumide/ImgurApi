package co.mide.imgurapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImgurImageData{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("datetime")
    @Expose
    private Long datetime;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("animated")
    @Expose
    private Boolean animated;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("bandwidth")
    @Expose
    private Long bandwidth;
    @SerializedName("vote")
    @Expose
    private Object vote;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("account_url")
    @Expose
    private String accountUrl;
    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("in_gallery")
    @Expose
    private Boolean inGallery;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     *     The datetime
     */
    public Long getDatetime() {
        return datetime;
    }

    /**
     *
     * @param datetime
     *     The datetime
     */
    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *     The animated
     */
    public Boolean getAnimated() {
        return animated;
    }

    /**
     *
     * @param animated
     *     The animated
     */
    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     *     The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     *     The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size
     *     The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @return
     *     The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     *
     * @param views
     *     The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     *
     * @return
     *     The bandwidth
     */
    public Long getBandwidth() {
        return bandwidth;
    }

    /**
     *
     * @param bandwidth
     *     The bandwidth
     */
    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     *
     * @return
     *     The vote
     */
    public Object getVote() {
        return vote;
    }

    /**
     *
     * @param vote
     *     The vote
     */
    public void setVote(Object vote) {
        this.vote = vote;
    }

    /**
     *
     * @return
     *     The section
     */
    public String getSection() {
        return section;
    }

    /**
     *
     * @param section
     *     The section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     *
     * @return
     *     The accountUrl
     */
    public String getAccountUrl() {
        return accountUrl;
    }

    /**
     *
     * @param accountUrl
     *     The account_url
     */
    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    /**
     *
     * @return
     *     The accountId
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     *
     * @param accountId
     *     The account_id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     *
     * @return
     *     The isInGallery
     */
    public Boolean getInGallery() {
        return inGallery;
    }

    /**
     *
     * @param inGallery
     *     The is_album
     */
    public void setInGallery(Boolean inGallery) {
        this.inGallery = inGallery;
    }
    /**
     *
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }
}