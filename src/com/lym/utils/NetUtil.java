package com.lym.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

/**
 * ���繤����
 * <p>
 * �ж�����������ԣ�wifi�Ƿ���ã���ȡ������IP��ַ���������������ý����
 * </p>
 * 
 * @author xuyao
 * 
 */
public class NetUtil {
	private NetUtil() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * �ж������Ƿ�����
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isConnected(Context context) {

		ConnectivityManager connectivity = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (null != connectivity) {

			NetworkInfo info = connectivity.getActiveNetworkInfo();
			if (null != info && info.isConnected()) {
				if (info.getState() == NetworkInfo.State.CONNECTED) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * �ж��Ƿ���wifi����
	 */
	public static boolean isWifi(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (cm == null)
			return false;
		return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
	}

	/**
	 * ���������ý���
	 */
	public static void openSetting(Activity activity) {
		Intent intent = new Intent("/");
		ComponentName cm = new ComponentName("com.android.settings",
				"com.android.settings.WirelessSettings");
		intent.setComponent(cm);
		intent.setAction("android.intent.action.VIEW");
		activity.startActivityForResult(intent, 0);
	}

	/**
	 * ��ȡ������IP
	 * 
	 * @param myContext
	 * @return
	 */
	public String getIp(Context myContext) {
		InetAddress address = getWifiIp(myContext);
		if (address != null) {
			return address.getHostAddress();
		}
		return null;
	}

	/**
	 * ��ȡwifi��ip��ַ
	 * 
	 * @param myContext
	 * @return
	 */
	private InetAddress getWifiIp(Context myContext) {
		if (myContext == null) {
			throw new NullPointerException("Global context is null");
		}
		WifiManager wifiMgr = (WifiManager) myContext
				.getSystemService(Context.WIFI_SERVICE);
		if (isWifiEnabled(myContext)) {
			int ipAsInt = wifiMgr.getConnectionInfo().getIpAddress();
			if (ipAsInt == 0) {
				return null;
			} else {
				return intToInet(ipAsInt);
			}
		} else {
			return null;
		}
	}

	/**
	 * wifi�Ƿ����
	 * 
	 * @param myContext
	 * @return
	 */
	public boolean isWifiEnabled(Context myContext) {
		if (myContext == null) {
			throw new NullPointerException("Global context is null");
		}
		WifiManager wifiMgr = (WifiManager) myContext
				.getSystemService(Context.WIFI_SERVICE);
		if (wifiMgr.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * intת��ΪInetAddress
	 * 
	 * @param value
	 * @return
	 */
	private InetAddress intToInet(int value) {
		byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++) {
			bytes[i] = byteOfInt(value, i);
		}
		try {
			return InetAddress.getByAddress(bytes);
		} catch (UnknownHostException e) {
			// This only happens if the byte array has a bad length
			return null;
		}
	}

	private byte byteOfInt(int value, int which) {
		int shift = which * 8;
		return (byte) (value >> shift);
	}
}
