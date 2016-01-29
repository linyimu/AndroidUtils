package com.lym.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyBoardUtil {

	private static KeyBoardUtil instance;
	private static InputMethodManager imm;

	private KeyBoardUtil() {
		/* cannot be instantiated */
	}

	public static KeyBoardUtil getInstance(Context context) {
		if (instance == null) {
			instance = new KeyBoardUtil();
			imm = (InputMethodManager) context
					.getSystemService(Context.INPUT_METHOD_SERVICE);
		}

		return instance;
	}

	/**
	 * �������
	 * 
	 * @param mEditText
	 *            �����
	 * @param mContext
	 *            ������
	 */
	public static void openKeybord(EditText mEditText, Context mContext) {
		imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
				InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

	/**
	 * �ر������
	 * 
	 * @param mEditText
	 *            �����
	 * @param mContext
	 *            ������
	 */
	public static void closeKeybord(EditText mEditText, Context mContext) {
		imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
	}
}
