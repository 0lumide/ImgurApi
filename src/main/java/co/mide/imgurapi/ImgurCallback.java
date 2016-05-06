package co.mide.imgurapi;

public interface ImgurCallback<T>{
    void onResponse(T response);

    /**
     * This is a very generic error and also includes internet connection errors
     * @param reason a brief description of the error
     */
    void onError(String reason);
}
