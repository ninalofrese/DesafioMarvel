package com.example.desafiomarvel.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.Result;
import com.example.desafiomarvel.view.interfaces.ComicOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerMonthAdapter extends RecyclerView.Adapter<RecyclerMonthAdapter.ViewHolder> {
    private List<Result> resultList;
    private ComicOnClick listener;

    public RecyclerMonthAdapter(List<Result> resultList, ComicOnClick listener) {
        this.resultList = resultList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(view -> {
            listener.onClick(result);
        });
    }

    @Override
    public int getItemCount() {
        return resultList == null ? 0 : resultList.size();
//        return resultList.size();
    }

    public void updateList(List<Result> newList) {
        if (this.resultList.isEmpty()) {
            this.resultList = newList;
        } else {
            this.resultList.addAll(newList);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView comicCover;
        private TextView comicTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            comicCover = itemView.findViewById(R.id.image_item_cover);
            comicTitle = itemView.findViewById(R.id.text_item_title);
        }

        public void onBind(Result result) {
            comicTitle.setText(result.getTitle());
            Picasso picasso = Picasso.get();
            picasso.load(result.getThumbnail().getPath() + "/detail." + result.getThumbnail().getExtension()).into(comicCover);
        }
    }
}
