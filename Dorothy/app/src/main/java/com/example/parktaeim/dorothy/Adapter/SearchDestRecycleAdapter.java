package com.example.parktaeim.dorothy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parktaeim.dorothy.Activity.NavigationActivity;
import com.example.parktaeim.dorothy.Activity.SearchDestActivity;
import com.example.parktaeim.dorothy.Model.SearchDestItem;
import com.example.parktaeim.dorothy.R;

import java.util.ArrayList;

import retrofit2.http.POST;

/**
 * Created by parktaeim on 2017. 10. 1..
 */

public class SearchDestRecycleAdapter extends RecyclerView.Adapter<SearchDestRecycleAdapter.ViewHolder> {
    Context context;
    private ArrayList<SearchDestItem> destItems;
    final static SearchDestActivity searchDestActivity = new SearchDestActivity();
    private static double lat = searchDestActivity.lat;
    private static double lon = searchDestActivity.lon;

    public SearchDestRecycleAdapter(Context context, ArrayList<SearchDestItem> destItems) {
        this.context = context;
        this.destItems = destItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_searchdest,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        SearchDestItem searchDestItem = destItems.get(position);
        holder.destination.setText(searchDestItem.getDestination());
        holder.address.setText(searchDestItem.getAddress());
        holder.distance.setText(searchDestItem.getDistance().toString());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,destItems.get(position).getDestination(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,NavigationActivity.class);
                intent.putExtra("destination",destItems.get(position).getDestination());
                intent.putExtra("address",destItems.get(position).getAddress());
                intent.putExtra("currentLatitude", destItems.get(position).getCurrentLat());
                intent.putExtra("currentLongitude",destItems.get(position).getCurrentLon());
                Log.d("adapterCurrentLat",String.valueOf(lat));
                intent.putExtra("noorLat",destItems.get(position).getNoorLat());
                intent.putExtra("noorLon",destItems.get(position).getNoorLon());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return destItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView destination;
        public TextView address;
        public TextView distance;
        public RelativeLayout itemLayout;

        public ViewHolder(View view){
            super(view);
            itemLayout = (RelativeLayout) view.findViewById(R.id.itemLayout);
            destination = (TextView) view.findViewById(R.id.destinationTextView);
            address = (TextView) view.findViewById(R.id.addressTextView);
            distance = (TextView) view.findViewById(R.id.distanceTextView);

        }
    }
}
