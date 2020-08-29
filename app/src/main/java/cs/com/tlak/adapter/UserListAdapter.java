package cs.com.tlak.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cs.com.tlak.R;
import cs.com.tlak.classes.User;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private OnItemClickListener listener;
    List<User> list;
    Context context;

    public UserListAdapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final User user = list.get(position);
        if (user.getGender().equals("male")) {
            Glide.with(context).load(R.drawable.man).into(holder.gender);
            holder.gender.setBackgroundResource(R.drawable.katawan_border_blue);
        } else {
            Glide.with(context).load(R.drawable.woman).into(holder.gender);
            holder.gender.setBackgroundResource(R.drawable.katawan_border_pink);
        }
        holder.username.setText(user.getName());

        holder.r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onItemClick(user.getId(), position);
                }
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onUpdateClick(user.getId(), position);
                }
            }
        });

        holder.trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onDeleteClick(user.getId(), position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gender, trash, edit;
        TextView username;
        RelativeLayout r1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            r1 = itemView.findViewById(R.id.r1);
            gender = itemView.findViewById(R.id.gender);
            trash = itemView.findViewById(R.id.trash);
            edit = itemView.findViewById(R.id.edit);
            username = itemView.findViewById(R.id.username);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id, int position);

        void onDeleteClick(int id, int position);

        void onUpdateClick(int id, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
