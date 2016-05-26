package co.mide.imgurapi;

import co.mide.imgurapi.models.ImgurAlbum;
import co.mide.imgurapi.models.ImgurGallery;
import co.mide.imgurapi.models.ImgurImage;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Test cases for the api
 * Created by olumide on 5/5/16.
 */
public class ImgurApiTest {
    private CountDownLatch lock = new CountDownLatch(1);
    private MockWebServer mockWebServer;
    private String invalidKeyResponseBody;
    private String albumNotFoundResponseBody;
    private String albumResponseBody;
    private String hotResponseBody;
    private String imageResponseBody;
    private Retrofit retrofit;
    private ImgurApi imgurApi;
    private File resourceDir = new File("src/test/resources/");

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        imgurApi = new ImgurApi("");
        retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(mockWebServer.url("/3/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Populate the moc response strings
        invalidKeyResponseBody = readFile(new File(resourceDir, "invalid_key_response_body.json"), StandardCharsets.UTF_8);
        albumNotFoundResponseBody = readFile(new File(resourceDir, "album_not_found_response_body.json"), StandardCharsets.UTF_8);
        albumResponseBody = readFile(new File(resourceDir, "album_response_body.json"), StandardCharsets.UTF_8);
        hotResponseBody = readFile(new File(resourceDir, "hot_response_body.json"), StandardCharsets.UTF_8);
        imageResponseBody = readFile(new File(resourceDir, "image_response_body.json"), StandardCharsets.UTF_8);
    }

    private static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(file.getPath()));
        return new String(encoded, encoding);
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    public void testGetAlbumWithInvalidKeyResponse() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(invalidKeyResponseBody);
        mockResponse.setResponseCode(403);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        imgurApi.getAlbum("albumId", new ImgurCallback<ImgurAlbum>() {
            @Override
            public void onResponse(ImgurAlbum response) {
                Assert.fail("It should fail. On error should have been called");
                lock.countDown();
            }

            @Override
            public void onError(String reason) {
                Assert.assertTrue(reason.equalsIgnoreCase("Invalid client_id"));
                lock.countDown();
            }
        });
        assertTrue(lock.await(2000, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testGetNonExistingAlbumResponse() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(albumNotFoundResponseBody);
        mockResponse.setResponseCode(404);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        imgurApi.getAlbum("invalid albumId", new ImgurCallback<ImgurAlbum>() {
            @Override
            public void onResponse(ImgurAlbum response) {
                Assert.fail("It should fail");
                lock.countDown();
            }

            @Override
            public void onError(String reason) {
                Assert.assertTrue(reason.equalsIgnoreCase("Unable to find an album with the id, fRJhYf."));
                lock.countDown();
            }
        });
        assertTrue(lock.await(2000, TimeUnit.MILLISECONDS));
    }


    @Test
    public void testGetAlbumAsync() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(albumResponseBody);
        mockResponse.setResponseCode(200);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        imgurApi.getAlbum("Valid albumId", new ImgurCallback<ImgurAlbum>() {
            @Override
            public void onResponse(ImgurAlbum response) {
                Assert.assertTrue(response.getData().getTitle().equalsIgnoreCase("These are made of solid marble."));
                lock.countDown();
            }

            @Override
            public void onError(String reason) {
                Assert.fail("It should be successful, and onResponse should have been called instead");
                lock.countDown();
            }
        });
        assertTrue(lock.await(2000, TimeUnit.MILLISECONDS));
    }

    @Test
    public void testGetAlbumSync() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(albumResponseBody);
        mockResponse.setResponseCode(200);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        ImgurAlbum album = imgurApi.getAlbumSync("valid albumID");
        Assert.assertTrue(album.getData().getTitle().equalsIgnoreCase("These are made of solid marble."));
    }

    @Test
    public void testGetNonExistingAlbumSync() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(albumNotFoundResponseBody);
        mockResponse.setResponseCode(404);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        ImgurAlbum album = imgurApi.getAlbumSync("valid albumID");
        Assert.assertTrue(album == null);
    }

    @Test
    public void getImage() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(imageResponseBody);
        mockResponse.setResponseCode(200);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        imgurApi.getImage("Valid imageId", new ImgurCallback<ImgurImage>() {
            @Override
            public void onResponse(ImgurImage response) {
                Assert.assertTrue(response.getData().getDescription().equalsIgnoreCase("Undine Rising from the Waters’ -  Chauncey Bradley Ives (ca. 1880-1892)"));
                lock.countDown();
            }

            @Override
            public void onError(String reason) {
                Assert.fail("It should be successful, and onResponse should have been called instead");
                lock.countDown();
            }
        });
        assertTrue(lock.await(2000, TimeUnit.MILLISECONDS));
    }

    @Test
    public void getImageSync() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(imageResponseBody);
        mockResponse.setResponseCode(200);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        ImgurImage image = imgurApi.getImageSync("valid imageID");
        Assert.assertTrue(image.getData().getDescription().equalsIgnoreCase("Undine Rising from the Waters’ -  Chauncey Bradley Ives (ca. 1880-1892)"));
    }

    @Test
    public void getHot() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(hotResponseBody);
        mockResponse.setResponseCode(200);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        imgurApi.getHot(new ImgurCallback<ImgurGallery>() {
            @Override
            public void onResponse(ImgurGallery response) {
                Assert.assertTrue(response.getData().get(0).getTitle().equalsIgnoreCase("Attention College Grads: Here's some BudgetingTips"));
                lock.countDown();
            }

            @Override
            public void onError(String reason) {
                Assert.fail("It should be successful, and onResponse should have been called instead");
                lock.countDown();
            }
        });
        assertTrue(lock.await(2000, TimeUnit.MILLISECONDS));
    }

    @Test
    public void getHotSync() throws Exception {
        MockResponse mockResponse = new MockResponse().setBody(hotResponseBody);
        mockResponse.setResponseCode(200);
        mockWebServer.enqueue(mockResponse);
        imgurApi.setRetrofit(retrofit);

        ImgurGallery gallery = imgurApi.getHotSync();
        Assert.assertTrue(gallery.getData().get(0).getTitle().equalsIgnoreCase("Attention College Grads: Here's some BudgetingTips"));
    }

}