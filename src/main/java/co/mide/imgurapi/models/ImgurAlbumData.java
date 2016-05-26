package co.mide.imgurapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ImgurAlbumData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("datetime")
    @Expose
    private Long datetime;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("cover_width")
    @Expose
    private Integer coverWidth;
    @SerializedName("cover_height")
    @Expose
    private Integer coverHeight;
    @SerializedName("account_url")
    @Expose
    private String accountUrl;
    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("favorite")
    @Expose
    private Object favorite;
    @SerializedName("nsfw")
    @Expose
    private Boolean nsfw;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("images_count")
    @Expose
    private Integer imagesCount;
    @SerializedName("in_gallery")
    @Expose
    private Boolean inGallery;
    @SerializedName("images")
    @Expose
    private List<? extends ImgurImageData> images = new ArrayList<>();

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
    public Object getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *     The description
     */
    public void setDescription(Object description) {
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
     *     The cover
     */
    public String getCover() {
        return cover;
    }

    /**
     *
     * @param cover
     *     The cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getCoverWidth() {
        return coverWidth;
    }

    public void setCoverWidth(Integer coverWidth) {
        this.coverWidth = coverWidth;
    }

    public Integer getCoverHeight() {
        return coverHeight;
    }

    public void setCoverHeight(Integer coverHeight) {
        this.coverHeight = coverHeight;
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
     *     The privacy
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     *
     * @param privacy
     *     The privacy
     */
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    /**
     *
     * @return
     *     The layout
     */
    public String getLayout() {
        return layout;
    }

    /**
     *
     * @param layout
     *     The layout
     */
    public void setLayout(String layout) {
        this.layout = layout;
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

    /**
     *
     * @return
     *     The imagesCount
     */
    public Integer getImagesCount() {
        return imagesCount;
    }

    /**
     *
     * @param imagesCount
     *     The images_count
     */
    public void setImagesCount(Integer imagesCount) {
        this.imagesCount = imagesCount;
    }

    public Boolean getInGallery() {
        return inGallery;
    }

    public void setInGallery(Boolean inGallery) {
        this.inGallery = inGallery;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public Object getFavorite() {
        return favorite;
    }

    public void setFavorite(Object favorite) {
        this.favorite = favorite;
    }


    /**
     *
     * @return
     *     The images
     */
    public List<? extends ImgurImageData> getImages() {
        return images;
    }

    /**
     *
     * @param images
     *     The images
     */
    public void setImages(List<? extends ImgurImageData> images) {
        this.images = images;
    }

}
