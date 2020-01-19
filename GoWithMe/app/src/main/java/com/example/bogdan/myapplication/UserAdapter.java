package com.example.bogdan.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    public List<User> users = new ArrayList<>();

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item,viewGroup,false);

        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {

        User currentUser = users.get(i);


        userHolder.textViewid.setText(String.valueOf(currentUser.getId()));
        userHolder.textViewName.setText(currentUser.getName());
        userHolder.textViewUsername.setText(currentUser.getUsername());
        userHolder.textViewPassword.setText(currentUser.getPassword());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users){
        this.users=users;
    }

    class UserHolder extends RecyclerView.ViewHolder{

        private TextView textViewid;
        private TextView textViewName;
        private TextView textViewUsername;
        private TextView textViewPassword;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            //item file
            //We need to define recycler view as a layout and to define also the item inside
            // the recycler view.

            textViewid = itemView.findViewById(R.id.recy_id);
            textViewName= itemView.findViewById(R.id.recy_name);
            textViewUsername = itemView.findViewById(R.id.recy_username);;
            textViewPassword = itemView.findViewById(R.id.recy_password);;

        }
    }
}
