package com.nbs.footballapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nbs.footballapp.model.Team;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewholder>{
    private ArrayList<Team> teams;

    private OnTeamClickCallback onTeamClickCallback;

    public OnTeamClickCallback getOnTeamClickCallback() {
        return onTeamClickCallback;
    }

    public void setOnTeamClickCallback(OnTeamClickCallback onTeamClickCallback) {
        this.onTeamClickCallback = onTeamClickCallback;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_team, parent, false);
        return new TeamViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewholder holder, int position) {
        holder.bind(getTeams().get(position));
    }

    @Override
    public int getItemCount() {
        return getTeams().size();
    }

    class TeamViewholder extends RecyclerView.ViewHolder{

        ImageView imgLogo;

        TextView tvName;

        public TeamViewholder(View itemView) {
            super(itemView);

            imgLogo = itemView.findViewById(R.id.img_logo);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bind(Team team){
            Picasso.get().load(team.getLogo())
                    .into(imgLogo);

            tvName.setText(team.getName());
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getOnTeamClickCallback()
                            .onTeamClicked(getTeams()
                                    .get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnTeamClickCallback{
        void onTeamClicked(Team team);
    }
}
