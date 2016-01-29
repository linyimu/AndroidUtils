package com.lym.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

/**
 * 
 * TestFinish
 * <p>
 * Activity的工具类
 * <p>
 * --包含了对Activity的进出站管理,实现完全退出应用
 * </p>
 * <p>
 * 如果当前的Activity是新打开的（而不是因为另外的Acitivty finish后显示的），
 * </p>
 * 则这个Activity是不被记录在栈中的.
 * 
 * @author xuyao
 * 
 */
public class ActivityUtils {
	private static ActivityUtils instance;
	private Stack<Activity> mActivityStack = new Stack<Activity>();

	private ActivityUtils() {

	}

	/**
	 * 单列模式
	 * 
	 * @return
	 */
	public static ActivityUtils getInstance() {
		if (instance == null) {
			synchronized (ActivityUtils.class) {
				if (instance == null) {
					instance = new ActivityUtils();
				}
			}
		}
		return instance;
	}

	int enterAnim;
	int exitAnim;
	int backEnterAnim;
	int backExitAnim;

	/**
	 * 添加动画,0表示没有动画
	 * 
	 * @param enterAnim
	 * @param exitAnim
	 * @param backEnterAnim
	 * @param backExitAnim
	 */
	public void addAnimation(int p_enterAnim, int p_exitAnim,
			int p_backEnterAnim, int p_backExitAnim) {
		enterAnim = p_enterAnim;
		exitAnim = p_exitAnim;
		backEnterAnim = p_backEnterAnim;
		backExitAnim = p_backExitAnim;

	}

	/**
	 * 添加Activity
	 * 
	 * @param act
	 */
	public void addActicity(Activity act) {
		mActivityStack.push(act);
	}

	/**
	 * 移除Activity
	 * 
	 * @param act
	 */
	public void removeActivity(Activity act) {
		mActivityStack.remove(act);

	}

	/**
	 * 清空Activity栈（当前的Activity不被清除）
	 */
	public void clearTack(Context context) {
		int nCount = mActivityStack.size();
		for (int i = nCount - 1; i >= 0; i--) {
			Activity activity = mActivityStack.get(i);
			if (activity != context) {// 如果不是当前显示的Activity，则关闭掉
				activity.finish();
				// finish(activity);
				mActivityStack.remove(i);
			}
		}
	}

	/**
	 * 退出应用
	 * 
	 * @param context
	 */
	public void exitApp(Context context) {
		clearTack(context);
		if (context instanceof Activity) {
			((Activity) context).finish();
		}
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	/**
	 * 开启Activity
	 * 
	 * @param context
	 * @param cls
	 */
	public void startActivity(Context context, Class<?> cls) {
		startActivity(context, cls, new HashMap<String, Object>());
	}

	public void startActivity(Context context, Class<?> cls, Bundle bundle) {
		Intent intent = new Intent(context, cls);
		intent.putExtras(bundle);
		startActivity(context, intent);
	}

	/**
	 * 打开Activity
	 * 
	 * @param context
	 * @param cls
	 * @param params
	 */
	public void startActivity(Context context, Class<?> cls,
			Map<String, Object> params) {
		Intent intent = new Intent(context, cls);
		if (params != null) {
			Set<Entry<String, Object>> entrySet = params.entrySet();
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Entry<String, Object> next = iterator.next();
				String key = next.getKey();
				Object value = next.getValue();
				putParam(intent, key, value);
			}
		}
		startActivity(context, intent);
	}

	public void startActivity(Context context, Intent intent) {
		context.startActivity(intent);
		if (context instanceof Activity) {
			Activity act = (Activity) context;
			addActicity(act);
			act.overridePendingTransition(enterAnim, exitAnim);
		}

	}

	/**
	 * 添加参数到Intent中
	 * 
	 * @param intent
	 * @param key
	 * @param value
	 */
	public void putParam(Intent intent, String key, Object value) {
		// 1
		if (value.getClass() == String.class) {
			intent.putExtra(key, (String) value);
			return;
		}
		if (value.getClass() == String[].class) {
			intent.putExtra(key, (String[]) value);
			return;
		}

		// 2
		if (value instanceof Integer) {
			intent.putExtra(key, (Integer) value);
			return;
		}
		if (value instanceof Integer[]) {
			intent.putExtra(key, (Integer[]) value);
			return;
		}
		if (value instanceof int[]) {
			intent.putExtra(key, (int[]) value);
			return;
		}
		// 3
		if (value instanceof Boolean) {
			intent.putExtra(key, (Boolean) value);
			return;
		}

		if (value instanceof boolean[]) {
			intent.putExtra(key, (boolean[]) value);
			return;
		}
		if (value instanceof int[]) {
			intent.putExtra(key, (Boolean[]) value);
			return;
		}

		if (value instanceof Serializable) {
			intent.putExtra(key, (Serializable) value);
			return;
		}
		if (value instanceof Bundle) {
			intent.putExtra(key, (Bundle) value);
			return;
		}
		if (value instanceof Intent) {
			intent.putExtras((Intent) value);
			return;
		}

		// 4
		if (value instanceof Long) {
			intent.putExtra(key, (Long) value);
			return;
		}
		if (value instanceof long[]) {
			intent.putExtra(key, (long[]) value);
			return;
		}
		if (value instanceof Long[]) {
			intent.putExtra(key, (Long[]) value);
			return;
		}

		// 5
		if (value instanceof Float) {
			intent.putExtra(key, (Float) value);
			return;
		}
		if (value instanceof float[]) {
			intent.putExtra(key, (float[]) value);
			return;
		}
		if (value instanceof Float[]) {
			intent.putExtra(key, (Float[]) value);
			return;
		}

		// 6
		if (value instanceof Double) {
			intent.putExtra(key, (Double) value);
			return;
		}
		if (value instanceof double[]) {
			intent.putExtra(key, (double[]) value);
			return;
		}
		if (value instanceof Double[]) {
			intent.putExtra(key, (Double[]) value);
			return;
		}

		// 7
		if (value instanceof Short) {
			intent.putExtra(key, (Double) value);
			return;
		}
		if (value instanceof Short[]) {
			intent.putExtra(key, (Short[]) value);
			return;
		}
		if (value instanceof short[]) {
			intent.putExtra(key, (short[]) value);
			return;
		}

		// 8
		if (value instanceof Byte) {
			intent.putExtra(key, (Byte) value);
			return;
		}
		if (value instanceof byte[]) {
			intent.putExtra(key, (byte[]) value);
			return;
		}
		if (value instanceof Byte[]) {
			intent.putExtra(key, (Byte[]) value);
			return;
		}

		if (value instanceof Parcelable) {
			intent.putExtra(key, (Parcelable) value);
			return;
		}
		if (value instanceof Parcelable[]) {
			intent.putExtra(key, (Parcelable[]) value);
			return;
		}

		if (value instanceof ArrayList) {
			ArrayList<?> al = (ArrayList<?>) value;
			if (!al.isEmpty()) {
				Object t = al.get(0);
				if (t instanceof String) {
					intent.putStringArrayListExtra(key, (ArrayList<String>) al);
					return;
				}
				if (t instanceof Integer) {
					intent.putIntegerArrayListExtra(key,
							(ArrayList<Integer>) al);
					return;
				}
				if (t instanceof CharSequence) {
					intent.putCharSequenceArrayListExtra(key,
							(ArrayList<CharSequence>) al);
					return;
				}
				if (t instanceof Parcelable) {
					intent.putParcelableArrayListExtra(key,
							(ArrayList<Parcelable>) al);

					return;
				}
			}
		}
		throw new IllegalArgumentException(value.getClass() + "类型不能在Intent中传递");
	}

	public void finish(Activity activity) {
		activity.finish();
		removeActivity(activity);
		activity.overridePendingTransition(backEnterAnim, backExitAnim);
	}
}
