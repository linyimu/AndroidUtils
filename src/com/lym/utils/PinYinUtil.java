package com.lym.utils;

import java.io.UnsupportedEncodingException;

/**
 * 拼音工具类
 * <p>
 * 实现汉字转拼音，获取汉字(字符串）的首字母
 * 
 * @author xuyao
 * 
 */
public class PinYinUtil {

	private static PinYinUtil instance = new PinYinUtil();

	private PinYinUtil() {
	};

	public static PinYinUtil getInstance() {
		return instance;
	}

	private final static int[] li_SecPosValue = { 1601, 1637, 1833, 2078, 2274,
			2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858,
			4027, 4086, 4390, 4558, 4684, 4925, 5249, 5590 };
	private final static String[] lc_FirstLetter = { "A", "B", "C", "D", "E",
			"F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "W", "X", "Y", "Z" };
	private final static int[] pyvalue = new int[] { -20319, -20317, -20304,
			-20295, -20292, -20283, -20265, -20257, -20242, -20230, -20051,
			-20036, -20032, -20026, -20002, -19990, -19986, -19982, -19976,
			-19805, -19784, -19775, -19774, -19763, -19756, -19751, -19746,
			-19741, -19739, -19728, -19725, -19715, -19540, -19531, -19525,
			-19515, -19500, -19484, -19479, -19467, -19289, -19288, -19281,
			-19275, -19270, -19263, -19261, -19249, -19243, -19242, -19238,
			-19235, -19227, -19224, -19218, -19212, -19038, -19023, -19018,
			-19006, -19003, -18996, -18977, -18961, -18952, -18783, -18774,
			-18773, -18763, -18756, -18741, -18735, -18731, -18722, -18710,
			-18697, -18696, -18526, -18518, -18501, -18490, -18478, -18463,
			-18448, -18447, -18446, -18239, -18237, -18231, -18220, -18211,
			-18201, -18184, -18183, -18181, -18012, -17997, -17988, -17970,
			-17964, -17961, -17950, -17947, -17931, -17928, -17922, -17759,
			-17752, -17733, -17730, -17721, -17703, -17701, -17697, -17692,
			-17683, -17676, -17496, -17487, -17482, -17468, -17454, -17433,
			-17427, -17417, -17202, -17185, -16983, -16970, -16942, -16915,
			-16733, -16708, -16706, -16689, -16664, -16657, -16647, -16474,
			-16470, -16465, -16459, -16452, -16448, -16433, -16429, -16427,
			-16423, -16419, -16412, -16407, -16403, -16401, -16393, -16220,
			-16216, -16212, -16205, -16202, -16187, -16180, -16171, -16169,
			-16158, -16155, -15959, -15958, -15944, -15933, -15920, -15915,
			-15903, -15889, -15878, -15707, -15701, -15681, -15667, -15661,
			-15659, -15652, -15640, -15631, -15625, -15454, -15448, -15436,
			-15435, -15419, -15416, -15408, -15394, -15385, -15377, -15375,
			-15369, -15363, -15362, -15183, -15180, -15165, -15158, -15153,
			-15150, -15149, -15144, -15143, -15141, -15140, -15139, -15128,
			-15121, -15119, -15117, -15110, -15109, -14941, -14937, -14933,
			-14930, -14929, -14928, -14926, -14922, -14921, -14914, -14908,
			-14902, -14894, -14889, -14882, -14873, -14871, -14857, -14678,
			-14674, -14670, -14668, -14663, -14654, -14645, -14630, -14594,
			-14429, -14407, -14399, -14384, -14379, -14368, -14355, -14353,
			-14345, -14170, -14159, -14151, -14149, -14145, -14140, -14137,
			-14135, -14125, -14123, -14122, -14112, -14109, -14099, -14097,
			-14094, -14092, -14090, -14087, -14083, -13917, -13914, -13910,
			-13907, -13906, -13905, -13896, -13894, -13878, -13870, -13859,
			-13847, -13831, -13658, -13611, -13601, -13406, -13404, -13400,
			-13398, -13395, -13391, -13387, -13383, -13367, -13359, -13356,
			-13343, -13340, -13329, -13326, -13318, -13147, -13138, -13120,
			-13107, -13096, -13095, -13091, -13076, -13068, -13063, -13060,
			-12888, -12875, -12871, -12860, -12858, -12852, -12849, -12838,
			-12831, -12829, -12812, -12802, -12607, -12597, -12594, -12585,
			-12556, -12359, -12346, -12320, -12300, -12120, -12099, -12089,
			-12074, -12067, -12058, -12039, -11867, -11861, -11847, -11831,
			-11798, -11781, -11604, -11589, -11536, -11358, -11340, -11339,
			-11324, -11303, -11097, -11077, -11067, -11055, -11052, -11045,
			-11041, -11038, -11024, -11020, -11019, -11018, -11014, -10838,
			-10832, -10815, -10800, -10790, -10780, -10764, -10587, -10544,
			-10533, -10519, -10331, -10329, -10328, -10322, -10315, -10309,
			-10307, -10296, -10281, -10274, -10270, -10262, -10260, -10256,
			-10254 };
	private final static String[] pystr = new String[] { "a", "ai", "an",
			"ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben",
			"beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu",
			"ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai",
			"chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong",
			"chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo",
			"ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da",
			"dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao",
			"die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun",
			"duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng",
			"fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", "ge", "gei",
			"gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang",
			"gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he",
			"hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan",
			"huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao",
			"jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun",
			"ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong",
			"kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo",
			"la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li",
			"lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu",
			"long", "lou", "lu", "lv", "luan", "lue", "lun", "luo", "ma",
			"mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi",
			"mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu",
			"na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng",
			"ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong",
			"nu", "nv", "nuan", "nue", "nuo", "o", "ou", "pa", "pai", "pan",
			"pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie",
			"pin", "ping", "po", "pu", "qi", "qia", "qian", "qiang", "qiao",
			"qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun",
			"ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou",
			"ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang",
			"sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao",
			"she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai",
			"shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou",
			"su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang",
			"tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong",
			"tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan",
			"wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian",
			"xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu",
			"xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi",
			"yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun",
			"za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng",
			"zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng",
			"zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang",
			"zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui",
			"zun", "zuo" };

	/**
	 * 取得给定汉字(字符串）的首字母,即声母
	 * 
	 * @param chinese
	 *            给定的汉字
	 * @return 如果是汉字，则返回给定汉字的声母.
	 *         如果是字母，则返回第一个字母的大写，如果是数字，则返回第一个数字，如果是null或者是其他字符，则返回" "(一个空格的字符),
	 */
	public static String getFirstLetter(String chinese) {
		if (chinese == null || chinese.trim().length() == 0) {
			return " ";
		}
		chinese = conversionStrCharset(chinese, "GB2312", "ISO8859-1");
		if (chinese.length() > 1) // 判断是不是汉字
		{
			int li_SectorCode = (int) chinese.charAt(0); // 汉字区码
			int li_PositionCode = (int) chinese.charAt(1); // 汉字位码
			li_SectorCode = li_SectorCode - 160;
			li_PositionCode = li_PositionCode - 160;
			int li_SecPosCode = li_SectorCode * 100 + li_PositionCode; // 汉字区位码
			if (li_SecPosCode > 1600 && li_SecPosCode < 5590) {
				for (int i = 0; i < 23; i++) {
					if (li_SecPosCode >= li_SecPosValue[i]
							&& li_SecPosCode < li_SecPosValue[i + 1]) {
						chinese = lc_FirstLetter[i];
						break;
					}
				}
			} else // 非汉字字符,如图形符号或ASCII码
			{
				chinese = conversionStrCharset(chinese, "ISO8859-1", "GB2312");
				chinese = chinese.substring(0, 1);

				char c = Character.toUpperCase(chinese.charAt(0));
				chinese = String.valueOf(c);

				if (c >= '0' && c <= '9') {// 数字
				} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
					// 字母
				} else {
					// 其他字符
					chinese = " ";
				}
			}
		}

		return chinese;
	}

	/**
	 * 字符串编码转换
	 * 
	 * @param str
	 *            要转换编码的字符串
	 * @param charsetName
	 *            原来的编码
	 * @param toCharsetName
	 *            转换后的编码
	 * @return 经过编码转换后的字符串
	 */
	private static String conversionStrCharset(String str, String charsetName,
			String toCharsetName) {
		try {
			str = new String(str.getBytes(charsetName), toCharsetName);
		} catch (UnsupportedEncodingException ex) {
			System.out.println("字符串编码转换异常：" + ex.getMessage());
		}
		return str;
	}

	/**
	 * 将字符串转化为拼音
	 * 
	 * @param str
	 * @param space
	 *            每个字符间是否保留有空格分隔
	 * @return
	 */
	public static String str2PinYin(String str, boolean space) {
		// 标点符号
		StringBuffer result = new StringBuffer();
		String strTemp = null;

		int preType = 1;
		for (int j = 0; j < str.length(); j++) {
			strTemp = str.substring(j, j + 1);
			int ascii = getChsAscii(strTemp);
			if (ascii > 0 && ascii < 160) {
				String valueOf = String.valueOf((char) ascii);
				result.append(valueOf);
				preType = 0;
			} else {
				for (int i = (pyvalue.length - 1); i >= 0; i--) {
					if (pyvalue[i] <= ascii) {
						if (preType == 0 && space) {
							result.append(" ");
							preType = 1;
						}
						result.append(pystr[i]);
						if (space) {
							result.append(" ");
						}
						break;
					}
				}
			}
		}
		return result.toString().trim();
	}

	/**
	 * 获取中文的Ascii码
	 * 
	 * @param chs
	 * @return
	 */
	private static int getChsAscii(String chs) {
		int asc = 0;
		try {
			byte[] bytes = chs.getBytes("gb2312");
			if (bytes == null || bytes.length > 2 || bytes.length <= 0) { // 错误
				// log
				throw new RuntimeException("illegal resource string");
				// System.out.println("error");
			}
			if (bytes.length == 1) { // 英文字符
				asc = bytes[0];
			}
			if (bytes.length == 2) { // 中文字符
				int hightByte = 256 + bytes[0];
				int lowByte = 256 + bytes[1];
				asc = (256 * hightByte + lowByte) - 256 * 256;
			}
		} catch (Exception e) {
			System.out
					.println("ERROR:ChineseSpelling.class-getChsAscii(String chs)"
							+ e);
		}
		return asc;
	}
}
