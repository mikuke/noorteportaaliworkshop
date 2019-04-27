package ee.mickeyapps.infopage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyFirstAdapter extends RecyclerView.Adapter {

    private List<Event> events;

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = inflater.inflate(R.layout.row, viewGroup, false);
        return new MyFirstViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof MyFirstViewHolder && events.size() > position) {
            Event event = events.get(position);

            MyFirstViewHolder myFirstViewHolder = (MyFirstViewHolder) viewHolder;
            myFirstViewHolder.bind(event);
        }
    }

    @Override
    public int getItemCount() {
        return events.size();
    }





    public class MyFirstViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;
        private TextView location;

        public MyFirstViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.row_name);
            date = itemView.findViewById(R.id.row_date);
            location = itemView.findViewById(R.id.row_location);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View clickedView) {
                    Event clickedEvent = events.get(getAdapterPosition());
                    Intent intent = new Intent(clickedView.getContext(), DetailsActivity.class);
                    intent.putExtra("KEY", clickedEvent.getName());
                    clickedView.getContext().startActivity(intent);
                }
            });
        }

        public void bind(Event event) {
            name.setText(event.getName());
            date.setText(event.getDate());
            location.setText(event.getLocation());
        }
    }
}
