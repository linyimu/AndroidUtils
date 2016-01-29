package com.lym.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * <p>
 * 在调试阶段可将isDebug设置为true,则所有的toast都会显示
 * </p>
 * <p>
 * 若将isDebug设置为false,则只有设置了show=true的才会被显示
 * </p>
 * 
 * @author xuyao
 * 
 */
public class ToastUtil {
	private ToastUtil instance;
	private Context context;

	private ToastUtil() {
	}

	public ToastUtil getInstance(Context context) {
		if (instance == null) {
			synchronized (ToastUtil.class) {
				if (instance == null) {
					this.context = context;
					this.instance = new ToastUtil();
				}
			}
		}
		return instance;
	}

	/** 调试 */
	public final static boolean isDebug = true;

	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param message
	 * @param show
	 *            是否显示(优先级最高）
	 */
	public void showShort(CharSequence message, boolean... show) {
		if (isDebug) {
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		} else {
			if (show.length > 0 && show[0]) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param resId
	 * @param show
	 *            是否显示(优先级最高）
	 */
	public void showShort(int resId, boolean... show) {
		if (isDebug) {
			Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
		} else {
			if (show.length > 0 && show[0]) {
				Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param message
	 * @param show
	 *            是否显示(优先级最高）
	 */
	public void showLong(CharSequence message, boolean... show) {
		if (isDebug) {
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		} else {
			if (show.length > 0 && show[0]) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param resId
	 * @param show
	 *            是否显示(优先级最高）
	 */
	public void showLong(int resId, boolean... show) {
		if (isDebug) {
			Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
		} else {
			if (show.length > 0 && show[0]) {
				Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
			}
		}
	}
}
