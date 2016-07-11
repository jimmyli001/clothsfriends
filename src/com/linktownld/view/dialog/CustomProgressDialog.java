package com.linktownld.view.dialog;

import com.linktownld.R;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;

	public class CustomProgressDialog extends Dialog {
		private Context context = null;
		private static CustomProgressDialog customProgressDialog = null;

		public CustomProgressDialog(Context context) {
			super(context);
			this.context = context;
		}

		public CustomProgressDialog(Context context, int theme) {
			super(context, theme);
		}

		public static CustomProgressDialog createDialog(Context context) {
			//20141218报错
			/*if (null != customProgressDialog) {
				return customProgressDialog;
			} else {*/
				customProgressDialog = new CustomProgressDialog(context,
						R.style.CustomProgressDialog);
				customProgressDialog.setContentView(R.layout.dialog_loading);
				customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;

				return customProgressDialog;
			//}
		}

		public void onWindowFocusChanged(boolean hasFocus) {

			if (customProgressDialog == null) {
				return;
			}

			ImageView imageView = (ImageView) customProgressDialog
					.findViewById(R.id.loadingImageView);
			AnimationDrawable animationDrawable = (AnimationDrawable) imageView
					.getBackground();
			animationDrawable.start();
		}


}
