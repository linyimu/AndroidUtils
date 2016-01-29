package com.lym.utils;

import java.io.File;
import java.text.DecimalFormat;

import android.os.Environment;
import android.os.StatFs;

/**
 * SD����ز���
 * 
 * @author xuyao
 * 
 */
public class SDCardUtil {
	private SDCardUtil() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * �ж�SDCard�Ƿ����
	 * 
	 * @return
	 */
	public static boolean isSDCardEnable() {
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);

	}

	/**
	 * ��ȡSD��·����
	 * 
	 * @return
	 */
	public static String getSDCardPath() {
		return Environment.getExternalStorageDirectory().getAbsolutePath()
				+ File.separator;
	}

	/**
	 * ��ȡSD����ʣ������ ��λbyte
	 * 
	 * @return
	 */
	public static long getSDCardAllSize() {
		if (isSDCardEnable()) {
			StatFs stat = new StatFs(getSDCardPath());
			// ��ȡ���е����ݿ������
			long availableBlocks = (long) stat.getAvailableBlocks() - 4;
			// ��ȡ�������ݿ�Ĵ�С��byte��
			long freeBlocks = stat.getAvailableBlocks();
			return freeBlocks * availableBlocks;
		}
		return 0;
	}

	/**
	 * ��ȡָ��·�����ڿռ��ʣ����������ֽ�������λbyte
	 * 
	 * @param filePath
	 * @return �����ֽ� SDCard���ÿռ䣬�ڲ��洢���ÿռ�
	 */
	public static long getFreeBytes(String filePath) {
		// �����sd�����µ�·�������ȡsd����������
		if (filePath.startsWith(getSDCardPath())) {
			filePath = getSDCardPath();
		} else {// ������ڲ��洢��·�������ȡ�ڴ�洢�Ŀ�������
			filePath = Environment.getDataDirectory().getAbsolutePath();
		}
		StatFs stat = new StatFs(filePath);
		long availableBlocks = (long) stat.getAvailableBlocks() - 4;
		return stat.getBlockSize() * availableBlocks;
	}

	/**
	 * ��ȡϵͳ�洢·��
	 * 
	 * @return
	 */
	public static String getRootDirectoryPath() {
		return Environment.getRootDirectory().getAbsolutePath();
	}

	/**
	 * ��ʽ���ռ��С
	 * 
	 * @param size
	 * @return
	 */
	static public String formatSize(long size) {
		String suffix = "kb";
		String[] suffixs = new String[] { "kb", "M", "G", "T" };
		double remainder = size;
		int n = 0;
		while (remainder >= 1024) {
			remainder /= 1024.0;
			suffix = suffixs[++n];
		}
		String format = new DecimalFormat("######0.##").format(remainder);
		return format + suffix;
	}
}
