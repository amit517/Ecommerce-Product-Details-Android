package com.team.myapplication.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.team.myapplication.utils.Constant;
import com.team.myapplication.R;
import com.team.myapplication.adapter.DetailsAdapter;
import com.team.myapplication.adapter.MyAdapter;

public class ProductDialogFragment extends BottomSheetDialogFragment implements DetailsAdapter.DescriptionClickListener, View.OnClickListener {

    public static final String TAG = "ProductDialogFragment";
    private Context context;
    private ItemClickListene mListener;
    private ImageView mainImage;
    private RecyclerView productRV;
    private Spinner spinner;
    private TextView textView17, textView18, textView19, textView20;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        configureRV();
        mainImage.setClipToOutline(true);
        MyAdapter myAdapter = new MyAdapter(context, R.layout.item_spinner,
                Constant.getShippingName());
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
                setupFullHeight(bottomSheetDialog);
            }
        });
        return dialog;
    }

    private void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();

        int windowHeight = getWindowHeight();
        if (layoutParams != null) {
            layoutParams.height = windowHeight - (windowHeight / 13);
        }
        bottomSheet.setLayoutParams(layoutParams);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private int getWindowHeight() {
        // Calculate window height for fullscreen use
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private void init(View view) {
        mainImage = view.findViewById(R.id.imageView8);
        productRV = view.findViewById(R.id.productRV);
        spinner = view.findViewById(R.id.shippingSpinner);
        textView17 = view.findViewById(R.id.textView17);
        textView18 = view.findViewById(R.id.textView18);
        textView19 = view.findViewById(R.id.textView19);
        textView20 = view.findViewById(R.id.textView20);

        textView17.setOnClickListener(this);
        textView18.setOnClickListener(this);
        textView19.setOnClickListener(this);
        textView20.setOnClickListener(this);
    }

    private void configureRV() {
        productRV.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        DetailsAdapter adapter = new DetailsAdapter(context, this);
        productRV.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        mListener = (ItemClickListene) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void position(int position) {
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView17:
                textView17.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_green_2));
                textView18.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView19.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView20.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));

                break;
            case R.id.textView18:
                textView17.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView18.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_green_2));
                textView19.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView20.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                break;
            case R.id.textView19:
                textView17.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView18.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView19.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_green_2));
                textView20.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                break;
            case R.id.textView20:
                textView17.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView18.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView19.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_gray_2));
                textView20.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_green_2));
                break;
        }
    }

    public interface ItemClickListene {
        void onItemClick(int position);
    }
}
