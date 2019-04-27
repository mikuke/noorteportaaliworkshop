package ee.mickeyapps.infopage.http;

import java.util.List;

import ee.mickeyapps.infopage.Event;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    // https://tinyurl.com/yyg5btf4

    @GET("http://www.mocky.io/v2/5cc2e09f33000073007e550e")
    Call<List<Event>> getEvents();

}
