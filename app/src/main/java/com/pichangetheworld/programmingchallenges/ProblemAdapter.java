package com.pichangetheworld.programmingchallenges;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Adapter for problems
 */
public class ProblemAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final Problem[] problems = Problem.values();

    public ProblemAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Problem p = problems[position];
        ViewHolder vh = (ViewHolder) holder;
        vh.textView.setText(p.getTitle());
        vh.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(ProblemActivity.createIntent(context, p));
            }
        });
    }

    @Override
    public int getItemCount() {
        return problems.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(android.R.id.text1)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
