package com.test.appframework.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.appframework.R;
import com.test.appframework.data.model.Item;

import java.util.List;

/**
 * Created 07/07/2017.
 */

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {
    private List<Item> mItems;

    public AnswersAdapter(List<Item> items) {
        this.mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mItems.get(position);
        holder.textViewAnswer.setText(item.getOwner().getDisplay_name());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<Item> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewAnswer;

        ViewHolder(View itemView) {
            super(itemView);
            textViewAnswer = (TextView) itemView.findViewById(R.id.text_view_answer);
        }
    }
}
