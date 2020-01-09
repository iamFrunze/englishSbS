package com.byfrunze.englishstep_by_step.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byfrunze.englishstep_by_step.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder> {
    private List<String> listSteps;

    public interface OnItemClickListener{
        void onItemClickListener(int pos, MaterialCardView cardView, TextView textViewTitle, TextView textViewDesc);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public StepsAdapter(List<String> steps) {
        this.listSteps = steps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_steps, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewStep.setText(listSteps.get(position));
        holder.textViewStepDesc.setText("SADSADSADSAD");
    }

    @Override
    public int getItemCount() {
        return listSteps.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewStep;
        TextView textViewStepDesc;
        MaterialCardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStep = itemView.findViewById(R.id.textViewStepTitle);
            textViewStepDesc = itemView.findViewById(R.id.textViewStepDesc);
            cardView = itemView.findViewById(R.id.cardViewStepsItem);
            cardView.setOnClickListener(v -> {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClickListener(getAdapterPosition(), cardView, textViewStep, textViewStepDesc);
                }
            });
        }
    }
}
