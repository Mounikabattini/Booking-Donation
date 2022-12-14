package com.mounika.bookingdonation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mounika.bookingdonation.model.Charity;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Charity> {

        List<Charity> items_list = new ArrayList<>();
        int custom_layout_id;
        private  Context mContext;
        HomeActivity mActivity;

public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Charity> objects, HomeActivity homeActivity) {
        super(context, resource, objects);
        items_list = objects;
        custom_layout_id = resource;
        mContext= context;
        mActivity = homeActivity;
        }

@Override
public int getCount() {
        return items_list.size();
        }

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
        // getting reference to the main layout and
        // initializing
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(custom_layout_id, null);
        }

        // initializing the imageview and textview and
        // setting data
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView = v.findViewById(R.id.textView);
        LinearLayout itemId = v.findViewById(R.id.itemId);

        // get the item using the  position param
        Charity item = items_list.get(position);

        imageView.setImageResource(item.getImage_id());
        textView.setText(item.getText());
        itemId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        Intent intent = new Intent(mContext, SaveDonationFragment.class);
                        intent.putExtra("ITEMID",item.getText());
                        mContext.startActivity(intent);
                       // mContext.finish();
                        //mActivity.finish();

                }
        });

        return v;
        }
        }