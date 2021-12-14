package io.github.wpinrui.gameday.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.model.Statistic;

public class StartAdapter extends RecyclerView.Adapter<StartAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textLabel;
        public TextView textValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textLabel = itemView.findViewById(R.id.textStatLabel);
            textValue = itemView.findViewById(R.id.textStatValue);
        }
    }

    private List<Statistic> statistics;

    public StartAdapter(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    @NonNull
    @Override
    public StartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View statisticView = inflater.inflate(R.layout.view_start_row, parent, false);
        return new ViewHolder(statisticView);
    }

    @Override
    public void onBindViewHolder(@NonNull StartAdapter.ViewHolder holder, int position) {
        Statistic statistic = statistics.get(position);
        TextView textLabel = holder.textLabel;
        TextView textValue = holder.textValue;
        textLabel.setText(statistic.getName());
        textValue.setText(String.valueOf(statistic.retrieveCurrentSeasonAverage()));
    }

    @Override
    public int getItemCount() {
        return statistics.size();
    }
}
