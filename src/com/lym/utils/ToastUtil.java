package com.lym.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast������
 * <p>
 * �ڵ��Խ׶οɽ�isDebug����Ϊtrue,�����е�toast������ʾ
 * </p>
 * <p>
 * ����isDebug����Ϊfalse,��ֻ��������show=true�ĲŻᱻ��ʾ
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

	/** ���� */
	public final static boolean isDebug = true;

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param message
	 * @param show
	 *            �Ƿ���ʾ(���ȼ���ߣ�
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
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param resId
	 * @param show
	 *            �Ƿ���ʾ(���ȼ���ߣ�
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
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param message
	 * @param show
	 *            �Ƿ���ʾ(���ȼ���ߣ�
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
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param resId
	 * @param show
	 *            �Ƿ���ʾ(���ȼ���ߣ�
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
