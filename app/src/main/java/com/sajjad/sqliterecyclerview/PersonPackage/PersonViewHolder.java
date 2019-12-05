package com.sajjad.sqliterecyclerview.PersonPackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sajjad.sqliterecyclerview.R;


class PersonViewHolder extends RecyclerView.ViewHolder {

    TextView personId,personAge, personName;
    ImageView personImage;

    PersonViewHolder(@NonNull View itemView) {
        super(itemView);

        personId=itemView.findViewById(R.id.personId);
        personAge=itemView.findViewById(R.id.personAge);
        personName=itemView.findViewById(R.id.personName);
        personImage=itemView.findViewById(R.id.personImage);
    }
}
