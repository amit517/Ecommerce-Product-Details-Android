package com.team.myapplication.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.team.myapplication.R;

public class ProductDialogFragment extends BottomSheetDialogFragment {

  public static final String TAG = "ActionBottomDialog";
  private Context context;
  private ItemClickListene mListener;
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

  }

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    Dialog dialog = super.onCreateDialog(savedInstanceState);
    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
      @Override public void onShow(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
        setupFullHeight(bottomSheetDialog);
      }
    });
    return  dialog;
  }
  private void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
    FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
    BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
    ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();

    int windowHeight = getWindowHeight();
    if (layoutParams != null) {
      layoutParams.height = windowHeight-(windowHeight/10);
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

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context =  context;
    mListener = (ItemClickListene) context;
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }


  public interface ItemClickListene {
    void onItemClick(int position);
  }
}
