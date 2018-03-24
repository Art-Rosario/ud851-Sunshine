package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by art on 3/24/18.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.forecast_list_item;
        boolean shouldAttachImmediately = false;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutId,parent, shouldAttachImmediately);

        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weatherData = mWeatherData[position];
        holder.mWeatherTextView.setText(weatherData);

    }

    @Override
    public int getItemCount() {
        if(mWeatherData == null){
            return 0;
        }return mWeatherData.length;
    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{
        public final TextView mWeatherTextView;
        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);

            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}
