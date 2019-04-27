package ee.mickeyapps.infopage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import ee.mickeyapps.infopage.http.ApiClient;
import ee.mickeyapps.infopage.http.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpEventsList();
        setEvents(EventGenerator.generateEvents());

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEventsFromInternet();
            }
        });
    }

    private void setUpEventsList() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false);
        MyFirstAdapter adapter = new MyFirstAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setEvents(List<Event> events) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof MyFirstAdapter) {
            MyFirstAdapter myFirstAdapter = (MyFirstAdapter) adapter;
            myFirstAdapter.setEvents(events);
            myFirstAdapter.notifyDataSetChanged();
        }
    }

    public void getEventsFromInternet() {
        ApiClient apiClient = new ApiClient();
        ApiService apiService = apiClient.getApiService();

        apiService.getEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                setEvents(response.body());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Log.e("ERROR", "request failed: " + t.fillInStackTrace());
            }
        });
    }
}
