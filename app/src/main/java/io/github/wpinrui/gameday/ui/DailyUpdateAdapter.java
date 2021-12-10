package io.github.wpinrui.gameday.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.slider.Slider;

import java.util.List;

import io.github.wpinrui.gameday.R;
import io.github.wpinrui.gameday.model.Statistic;

public class DailyUpdateAdapter extends RecyclerView.Adapter<DailyUpdateAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textUpdateStatLabel;
        public Slider slider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textUpdateStatLabel = itemView.findViewById(R.id.textUpdateStatLabel);
            slider = itemView.findViewById(R.id.slider);
        }
    }

    private List<Statistic> statistics;

    public DailyUpdateAdapter(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View statisticView = inflater.inflate(
                R.layout.view_daily_update_row, parent, false);
        return new ViewHolder(statisticView);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyUpdateAdapter.ViewHolder holder, int position) {
        Statistic statistic = statistics.get(position);
        TextView textUpdateStatLabel = holder.textUpdateStatLabel;
        Slider slider = holder.slider;
        textUpdateStatLabel.setText(statistic.getName());
        slider.setValueTo((float) statistic.getMax());
        slider.setValueFrom((float) statistic.getMin());
        slider.setValue((float) statistic.getMin());
        slider.setStepSize(0.5f);
    }

    @Override
    public int getItemCount() {
        return statistics.size();
    }
}
