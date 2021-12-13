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
import io.github.wpinrui.gameday.model.Model;
import io.github.wpinrui.gameday.model.Statistic;

public class DailyUpdateAdapter extends RecyclerView.Adapter<DailyUpdateAdapter.ViewHolder> {
    private final Model model = Model.getInstance();
    private Slider slider;
    private TextView textUpdateStatLabel;
    private List<Statistic> statistics;
    private Statistic statistic;

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
        statistic = statistics.get(position);
        holder.bind(statistic);
    }

    @Override
    public int getItemCount() {
        return statistics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textUpdateStatLabel;
        public Slider slider;
        private Statistic statistic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textUpdateStatLabel = itemView.findViewById(R.id.textUpdateStatLabel);
            slider = itemView.findViewById(R.id.slider);
        }

        void bind (Statistic statistic) {  //<--bind method allows the ViewHolder to bind to the data it is displaying
            this.statistic = statistic;
            textUpdateStatLabel.setText(statistic.getName());
            initSlider();
        }

        private void initSlider() {
            slider.setValueTo((float) statistic.getMax());
            slider.setValueFrom((float) statistic.getMin());
            slider.setStepSize(0.5f);
            slider.setValue((float) statistic.dailyProgress());
            slider.addOnChangeListener(
                    (slider, value, fromUser) -> statistic.updateDailyProgress(value));
        }
    }
}
