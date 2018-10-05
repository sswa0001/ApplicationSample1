package com.example.swatisurisetti.applicationsample.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.StateListDrawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class StaticUtils {
	public static boolean isFromProfile = false;
	public static boolean isFromPresentHistory = false;
	public static boolean isInvitation = false;
	public static boolean isSearchMap_Location = false;
	public static boolean isMMP_PDF = false;
	public static boolean isMyDoctors = false;
	public static boolean isConnectMe = false;
	public static boolean isSearchResult = false;
	public static boolean iSParameter = false;
	public static boolean iSTestReports = false;
	public static boolean iShomeworkslider = false;
	public static boolean isTestRpt = false;
	public static boolean isMedicine = false;
	public static String DEVELOPER_KEY = "AIzaSyA4IN4_XHrtLHBn6NjL0NoDJPdZ9m9lJ10";

	public static <T extends ImageView> void setTabButtonState(T imageView, int selected, int normal) {
		Context ctx = imageView.getContext();
		StateListDrawable states = new StateListDrawable();
		states.addState(new int[] { android.R.attr.state_selected }, ctx.getResources().getDrawable(selected));
		states.addState(new int[] { android.R.attr.state_focused }, ctx.getResources().getDrawable(selected));
		states.addState(new int[] {}, ctx.getResources().getDrawable(normal));
		imageView.setImageDrawable(states);
	}

	@SuppressLint("NewApi")
	public static <T extends View> void setViewButtonState(T imageView, int selected, int normal) {
		Context ctx = imageView.getContext();
		StateListDrawable states = new StateListDrawable();
		states.addState(new int[] { android.R.attr.state_selected }, ctx.getResources().getDrawable(selected));
		states.addState(new int[] { android.R.attr.state_focused }, ctx.getResources().getDrawable(selected));
		states.addState(new int[] {}, ctx.getResources().getDrawable(normal));
		imageView.setBackground(states);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T get(View view, int resId) {
		SparseArray viewHolder = (SparseArray) view.getTag();
		if (viewHolder == null) {
			viewHolder = new SparseArray();
			view.setTag(viewHolder);
		}
		View childView = (View) viewHolder.get(resId);
		if (childView == null) {
			childView = view.findViewById(resId);
			viewHolder.put(resId, childView);
		}
		return (T) childView;
	}

	@SuppressLint("NewApi")
	public static boolean isValidEmail(String emailString) {

		if (Build.VERSION.SDK_INT < 8) {
			if (emailString.toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && emailString.length() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			CharSequence inputStr = emailString;
			Pattern pattern = Patterns.EMAIL_ADDRESS;
			Matcher matcher = pattern.matcher(inputStr);
			return matcher.matches();
		}

	}

	public static String getFullDayName() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.get(Calendar.DAY_OF_WEEK);
		return String.format("%tA", c);
	}

	public static String getShortDayName(int day) {
		Calendar c = Calendar.getInstance();
		c.set(2011, 7, 1, 0, 0, 0);
		c.add(Calendar.DAY_OF_MONTH, day);
		return String.format("%ta", c);
	}





	public static void setEditTextHintFont(EditText mEditText, Context mContext, int index) {
		Typeface typeFace = null;
		String str = "";
		switch (index) {
		case 0:
			str = "fonts/HelveticaNeueLTStd_35_Thin.otf";
			break;
		case 1:
			str = "fonts/HelveticaNeueLTStd_45lite.otf";
			break;
		case 2:
			str = "fonts/HelveticaNeueLTStd_75_Bold.otf";
			break;
		case 3:
			str = "fonts/HelveticaNeueLTStd_45_Light.otf";
			break;
		case 4:
			str = "fonts/HelveticaNeueLTStd_65_Medium.otf";
			break;
		case 5:
			str = "fonts/HelveticaNeueLTStd_Roman_55.otf";
			break;
		default:
			break;
		}
		typeFace = Typeface.createFromAsset(mContext.getAssets(), str);
		mEditText.setTypeface(typeFace);
	}

	public static void setRadioButtonHintFont(RadioButton mEditText, Context mContext) {
		Typeface typeFace = Typeface.createFromAsset(mContext.getAssets(), "fonts/HelveticaNeueLTStd_Roman_55.otf");
		mEditText.setTypeface(typeFace);
	}

	public static void setCheckBoxFont(CheckBox mEditText, Context mContext) {
		Typeface typeFace = Typeface.createFromAsset(mContext.getAssets(), "fonts/HelveticaNeueLTStd_Roman_55.otf");
		mEditText.setTypeface(typeFace);
	}

	public static void setTypeFace(TextView view, Context mContext) {
		Typeface t = Typeface.createFromAsset(mContext.getAssets(), "fonts/HelveticaNeueLTStd_Roman_55.otf");
		view.setTypeface(t);
	}

	static String newFolder;
	static String extStorageDirectory;

	public static File bitmapToFile(Bitmap bitmap) {
		try {
			long current = System.currentTimeMillis();
			newFolder = "/MMP";
			extStorageDirectory = Environment.getExternalStorageDirectory().toString();
			File file = new File(Environment.getExternalStorageDirectory() + newFolder + "");
			if (!file.isDirectory())
				file.mkdir();

			File sfile = new File(Environment.getExternalStorageDirectory() + newFolder + "/" + current + ".jpg");
			FileOutputStream fOut;
			fOut = new FileOutputStream(sfile);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 86, fOut);
			fOut.flush();
			fOut.close();
			return sfile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int getCameraPhotoOrientation(Context context, Uri imageUri, String imagePath) {
		int rotate = 0;
		try {
			context.getContentResolver().notifyChange(imageUri, null);
			File imageFile = new File(imagePath);
			ExifInterface exif = new ExifInterface(imageFile.getAbsolutePath());
			int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_270:
				rotate = 270;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				rotate = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_90:
				rotate = 90;
				break;
			case ExifInterface.ORIENTATION_NORMAL:
				rotate = 0;
				break;
			}

			// Log.v("", "Exif orientation: " + orientation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rotate;
	}

	public static boolean isNetworkAvailable(Context mContext) {
		boolean connection = false;
		try {
			ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (cm != null) {
				NetworkInfo net_info = cm.getActiveNetworkInfo();
				if (net_info != null && net_info.isConnected()) {
					connection = true;
					int type = net_info.getType();
					switch (type) {
					case ConnectivityManager.TYPE_MOBILE:
						break;
					case ConnectivityManager.TYPE_WIFI:
						break;
					default:
						break;
					}
				}
			}
		} catch (Exception e) {
		}
		return connection;
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	public static void loadHtmlContent(WebView view, String appendText, float textSize) {
		view.setBackgroundColor(Color.TRANSPARENT);

		String color;
		color = "#000000";

		appendText = appendText.replace("\n", "<br>");// #363636
		String s = "<html><head><style type='text/css'>@font-face {font-family: MyFont;src: url('file:///android_asset/fonts/HelveticaNeueLTStd_35_Thin.otf')}body {margin:0px;color:"
				+ color
				+ ";font-family: MyFont;font-size: "
				+ textSize
				+ "px;text-align: justify;}</style></head><body>"
				+ appendText
				+ "</body></html>";
		view.loadDataWithBaseURL("", s, "text/html", "utf-8", null);
		view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		view.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		view.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
		view.setFocusable(false);
		view.setFocusableInTouchMode(false);
	}

	@SuppressWarnings("deprecation")
	public static String encodeGETUrl(Bundle parameters) {
		StringBuilder sb = new StringBuilder();

		if (parameters != null && parameters.size() > 0) {
			boolean first = true;
			for (String key : parameters.keySet()) {
				if (key != null) {

					if (first) {
						first = false;
					} else {
						sb.append("&");
					}
					String value = "";
					Object object = parameters.get(key);
					if (object != null) {
						value = String.valueOf(object);
					}

					try {
						sb.append(URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8"));
					} catch (Exception e) {
						sb.append(URLEncoder.encode(key) + "=" + URLEncoder.encode(value));
					}
				}
			}
		}
		return sb.toString();
	}

	public static String encodeUrl(String url, Bundle mParams) {
		Log.e("WSUrl", url + encodeGETUrl(mParams));
		return url + encodeGETUrl(mParams);
	}

	public static String formatDate(String messageTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
		@SuppressWarnings("unused")
		String dayVal = new String();
		try {
			Date messageDateandTime = formatter.parse(messageTime);
			String messageDate = df.format(messageDateandTime);
			return messageDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@SuppressLint("SimpleDateFormat")
	public static String formatDateWithoutYear(String messageTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("MMM dd HH:mm:ss");
		@SuppressWarnings("unused")
		String dayVal = new String();
		try {
			Date messageDateandTime = formatter.parse(messageTime);
			String messageDate = df.format(messageDateandTime);
			return messageDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String formatyearmonthdate(String messageTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
		@SuppressWarnings("unused")
		String dayVal = new String();
		try {
			Date messageDateandTime = formatter.parse(messageTime);
			String messageDate = df.format(messageDateandTime);
			return messageDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String formatDateWithYearTime(String messageTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		@SuppressWarnings("unused")
		String dayVal = new String();
		try {
			Date messageDateandTime = formatter.parse(messageTime);
			String messageDate = df.format(messageDateandTime);
			return messageDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String SendServerDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
			return datetime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String SendDateOnly(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
			return datetime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String SendServerDateF(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(dateNew);
			datetime = dateFormat.format(c.getTime());
			return datetime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static Animation expandCollapse(final View v, final boolean expand) {
		return expandCollapse(v, expand, 1000);
	}

	public static Animation expandCollapse(final View v, final boolean expand, final int duration) {
		int currentHeight = v.getLayoutParams().height;
		v.measure(MeasureSpec.makeMeasureSpec(((View) v.getParent()).getMeasuredWidth(), MeasureSpec.AT_MOST),
				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		final int initialHeight = v.getMeasuredHeight();
		if ((expand && currentHeight == initialHeight) || (!expand && currentHeight == 0))
			return null;
		if (expand)
			v.getLayoutParams().height = 0;
		else
			v.getLayoutParams().height = initialHeight;
		v.setVisibility(View.VISIBLE);

		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				int newHeight = 0;
				if (expand)
					newHeight = (int) (initialHeight * interpolatedTime);
				else
					newHeight = (int) (initialHeight * (1 - interpolatedTime));
				v.getLayoutParams().height = newHeight;
				if (interpolatedTime == 1) {
					v.getLayoutParams().height = v.getLayoutParams().WRAP_CONTENT;
				}
				v.requestLayout();

				if (interpolatedTime == 1 && !expand)
					v.setVisibility(View.GONE);
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};
		a.setDuration(duration);
		v.startAnimation(a);
		return a;
	}







	public static void showKeyboard(Activity activity) {
		InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputMethodManager.toggleSoftInputFromWindow(((Activity) activity).getCurrentFocus().getApplicationWindowToken(),
				InputMethodManager.SHOW_FORCED, 0);
	}

	public static void hideKeyboard(FragmentActivity mcontext) {
		try {
			if (mcontext.getCurrentFocus() != null) {
				InputMethodManager imm = (InputMethodManager) mcontext.getSystemService(Activity.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(mcontext.getCurrentFocus().getWindowToken(), 0);
			}
			// imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
		} catch (Exception e) {
			Log.e("KeyBoardUtil", e.toString(), e);
		}

	}

	public static Bitmap RotateBitmap(Bitmap source, float angle) {
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
		return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
	}

	public static List<String> getListWithoutDuplicates(List<String> mListWithDuplicates) {
		List<String> mListWithoutDuplicates = new ArrayList<String>();
		for (int s = 0; s < mListWithDuplicates.size(); s++) {
			for (int m = s + 1; m < mListWithDuplicates.size(); m++) {
				if (mListWithDuplicates.get(s) != null && mListWithDuplicates.get(s).equals(mListWithDuplicates.get(m))) {
					mListWithDuplicates.set(m, null);
				}
			}
		}
		for (int i = 0; i < mListWithDuplicates.size(); i++) {
			if (mListWithDuplicates.get(i) != null)
				mListWithoutDuplicates.add(mListWithDuplicates.get(i));
		}
		mListWithDuplicates.clear();
		return mListWithoutDuplicates;
	}

	public static float pixelsToSp(Context context, float px) {
		float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
		return px / scaledDensity;
	}

	public static boolean isEmptyText(String txt) {
		if (TextUtils.isEmpty(txt))
			return true;
		else
			return false;
	}

	/**
	 * DROP DOWN (TEXTVIEW)
	 * 
	 * */


	public final static void RequestFocus(EditText edt) {
		edt.requestFocus();
		edt.setCursorVisible(true);
	}

	public static long getDayDifference(Date startDate, Date endDate) {
		long different = endDate.getTime() - startDate.getTime();
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);
		System.out.println("different : " + different);
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long elapsedDays = different / daysInMilli;

		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		long elapsedSeconds = different / secondsInMilli;
		System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
		return elapsedDays;
	}

	public static long getHoursDifference(Date startDate, Date endDate) {
		long different = endDate.getTime() - startDate.getTime();
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);
		System.out.println("different : " + different);
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;
		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		long elapsedSeconds = different / secondsInMilli;
		System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
		return elapsedHours;
	}

	public static long getMinutesDifference(Date startDate, Date endDate) {
		long different = endDate.getTime() - startDate.getTime();
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);
		System.out.println("different : " + different);
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;
		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		long elapsedSeconds = different / secondsInMilli;
		System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);

		if (elapsedHours != 0)
			elapsedMinutes = elapsedMinutes + (elapsedHours * 60);
		if (elapsedDays != 0)
			elapsedMinutes = elapsedMinutes + (elapsedDays * 1440);

		return elapsedMinutes;
	}

	public static String getTimeDifference(Date startDate, Date endDate) {
		long different = endDate.getTime() - startDate.getTime();
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);
		System.out.println("different : " + different);
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;
		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		long elapsedSeconds = different / secondsInMilli;

		String time = "";
		if (elapsedDays != 0) {
			if (time.length() != 0) {
				time = String.valueOf(elapsedDays) + "Days ";
			} else {
				time = time + String.valueOf(elapsedDays) + "Days ";
			}
		}
		if (elapsedHours != 0) {
			if (time.length() != 0) {
				time = String.valueOf(elapsedHours) + "Hours ";
			} else {
				time = time + String.valueOf(elapsedHours) + "Hours ";
			}
		}

		if (elapsedMinutes != 0) {
			if (time.length() != 0) {
				time = String.valueOf(elapsedMinutes) + "Mins ";
			} else {
				time = time + String.valueOf(elapsedMinutes) + "Mins ";
			}
		}
		System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
		return time;
	}

	public static long getSecondsDifference(Date startDate, Date endDate) {
		long different = endDate.getTime() - startDate.getTime();
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);
		System.out.println("different : " + different);
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;
		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		long elapsedSeconds = different / secondsInMilli;
		System.out.printf("%d days, %d hours, %d minutes, %d seconds%n", elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
		return elapsedSeconds;
	}

	public static String SendDataFormatwithTime(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a ");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String SendDateStartWithYear(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
			return datetime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String SendDataFormat(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String SendDataFormat_Time(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String SendDataFormat_New(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String SendDataFormat_time_Alerts(String date) {
		SimpleDateFormat format = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		String datetime = new String();
		try {
			Date dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String SendDataFormat_New_Alerts(String date) {
		// Fri Nov 27 21:15:00 GMT+05:30 2015

		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss");
		// SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
		String datetime = new String();
		try {
			Date dateNew = formatter.parse(date);
			datetime = df.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String getTimeForDelete(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		Date dateNew = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String datetime = new String();
		try {
			dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static long getTimeFromDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		Date dateNew = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		String datetime = new String();
		try {
			dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateNew.getTime() - 10 * 60 * 1000;
	}

	public static long getTimeFromDateParameters(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		Date dateNew = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		String datetime = new String();
		try {
			dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateNew.getTime() - 5 * 60 * 1000;
	}

	public static long getTimeNextHour(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		Date dateNew = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		String datetime = new String();
		try {
			dateNew = format.parse(date);
			datetime = dateFormat.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateNew.getTime() + 1440 * 60 * 1000;
	}

	public static String FormatDateYY(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = new String();
		try {
			Date dateNew = dateFormat.parse(date);
			datetime = format.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String FormatDateYYWithNoTime(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datetime = new String();
		try {
			Date dateNew = dateFormat.parse(date);
			datetime = format.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static String FormatMedDateYY(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = new String();
		try {
			Date dateNew = dateFormat.parse(date);
			datetime = format.format(dateNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datetime;
	}

	public static void hideKeyboard(EditText mEditText, Context mContext) {

		try {
			InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
		} catch (Exception e) {
			Log.e("KeyBoardUtil", e.toString(), e);
		}

	}
}
