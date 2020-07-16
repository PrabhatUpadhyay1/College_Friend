package com.prabhat.collegefriend.Adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prabhat.collegefriend.Model.Book_Class_Model;
import com.prabhat.collegefriend.R;

import java.util.List;

public class Home_Class_Adapter extends RecyclerView.Adapter<Home_Class_Adapter.MyViewHolder> {

    Context context;
    List<Book_Class_Model> list;

    public Home_Class_Adapter(Context context, List<Book_Class_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_book_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.bookname.setText(list.get(position).getBookname());
        holder.bookname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = list.get(position).getBooklink();
                Download(url);
                Toast.makeText(holder.bookname.getContext(), "Download Started", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView bookname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookname = itemView.findViewById(R.id.bookname);
        }
    }

    public void Download(String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadManager.enqueue(request);
    }
}
