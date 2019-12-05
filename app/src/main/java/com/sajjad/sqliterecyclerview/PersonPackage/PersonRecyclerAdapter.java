package com.sajjad.sqliterecyclerview.PersonPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sajjad.sqliterecyclerview.R;

import java.util.List;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private List<PersonModel> personModels;

    public PersonRecyclerAdapter( List<PersonModel> personModels) {
        this.personModels = personModels;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View personItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(personItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        PersonModel personModel = personModels.get(position);

        holder.personId.setText(String.valueOf(personModel.getPersonId()));
        holder.personAge.setText(String.valueOf(personModel.getPersonAge()));
        holder.personName.setText(personModel.getPersonName());
        new LoadImageAsync(holder).execute(personModel.getImageBytes());
    }

    @Override
    public int getItemCount() {
        return personModels.size();
    }
}
