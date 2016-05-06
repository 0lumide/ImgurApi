# Imgur API
This is a really basic Java api. Yes it'll also work with Android. It doesn't include oauth or anything of that sorts. So as a result it can really only access data that anybody in the world would normally be able to.

It's built using Retrofit.

## Usage
Include the jitpack repository to your project. See [jitpack.io](https://jitpack.io/) for help.

Include the library in your project via Maven:
```
<dependency>
    <groupId>com.github.0lumide</groupId>
    <artifactId>ImgurApi</artifactId>
    <version>v0.0.4-alpha</version>
</dependency>
```

or Gradle
```
dependencies {
    compile 'com.github.0lumide:ImgurApi:v0.0.4-alpha'
}
```

### Sample
This sample code prints the Title and description of all the albums of the front page.
```java
ImgurApi imgurApi = new ImgurApi("CLIENT_ID");
imgurApi.getHot(new ImgurCallback<ImgurGallery>() {
    @Override
    public void onResponse(ImgurGallery response) {
        List<ImgurGalleryData> data = response.getData();
        for(ImgurGalleryData galleryData: data){
            System.out.print("Title: ");
            if(galleryData.getTitle() != null)
                System.out.println(galleryData.getTitle());
            System.out.print("Description: ");
            if(galleryData.getDescription() == null)
                System.out.printf("%s\n\n", galleryData.getDescription());
        }
    }

    @Override
    public void onError(String errorMessage) {
        System.err.println(errorMessage);
    }
});
```

Note that a parameter-less constructor is also available for `ImgurApi`, but this requires that the client-id envoronment variable is set. Otherwise it throws an exception.

### Development
Feel free to submit a PR, and open new issues if you find a bug.
