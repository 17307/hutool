package cn.hutool.extra.qrcode;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * 二维码设置
 *
 * @author looly
 * @since 4.1.2
 */
public class QrConfig {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;


	/**
	 * 宽度（单位：像素或▄）
	 * <div>当二维码类型为一般图片或者SVG时，单位是像素<div/>
	 * <div>当二维码类型Ascii Art字符画时，单位是字符▄或▀的大小<div/>
	 */
	protected int width;

	/**
	 * 高度（单位：像素或▄）
	 * <div>当二维码类型为一般图片或者SVG时，单位是像素<div/>
	 * <div>当二维码类型Ascii Art字符画时，单位是字符▄或▀的大小<div/>
	 */
	protected int height;
	/** 前景色（二维码颜色） */
	protected Integer foreColor = BLACK;
	/** 背景色，默认白色，null表示透明 */
	protected Integer backColor = WHITE;
	/** 边距1~4 */
	protected Integer margin = 2;
	/** 设置二维码中的信息量，可设置0-40的整数 */
	protected Integer qrVersion;
	/** 纠错级别 */
	protected ErrorCorrectionLevel errorCorrection = ErrorCorrectionLevel.M;
	/** 编码 */
	protected Charset charset = CharsetUtil.CHARSET_UTF_8;
	/** 二维码中的Logo */
	protected Image img;
	/** 二维码中的Logo缩放的比例系数，如5表示长宽最小值的1/5 */
	protected int ratio = 6;
	/**
	 * DATA_MATRIX的符号形状
	 */
	protected SymbolShapeHint shapeHint = SymbolShapeHint.FORCE_NONE;

	/**
	 * 创建QrConfig
	 * @return QrConfig
	 * @since 4.1.14
	 */
	public static QrConfig create() {
		return new QrConfig();
	}

	/**
	 * 构造，默认长宽为300
	 */
	public QrConfig() {
		this(300, 300);
	}

	/**
	 * 构造
	 *
	 * @param width 宽
	 * @param height 长
	 */
	public QrConfig(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * 获取宽度
	 *
	 * @return 宽度
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 设置宽度
	 *
	 * @param width 宽度
	 * @return this
	 */
	public QrConfig setWidth(int width) {
		this.width = width;
		return this;
	}

	/**
	 * 获取高度
	 *
	 * @return 高度
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 设置高度
	 *
	 * @param height 高度
	 * @return this;
	 */
	public QrConfig setHeight(int height) {
		this.height = height;
		return this;
	}

	/**
	 * 获取前景色
	 *
	 * @return 前景色
	 */
	public int getForeColor() {
		return foreColor;
	}

	/**
	 * 设置前景色，例如：Color.BLUE.getRGB()
	 *
	 * @param foreColor 前景色
	 * @return this
	 * @deprecated 请使用 {@link #setForeColor(Color)}
	 */
	@Deprecated
	public QrConfig setForeColor(int foreColor) {
		this.foreColor = foreColor;
		return this;
	}

	/**
	 * 设置前景色，例如：Color.BLUE.getRGB()
	 *
	 * @param foreColor 前景色
	 * @return this
	 * @since 5.1.1
	 */
	public QrConfig setForeColor(Color foreColor) {
		if(null == foreColor){
			this.foreColor = null;
		} else {
			this.foreColor = foreColor.getRGB();
		}
		return this;
	}

	/**
	 * 获取背景色
	 *
	 * @return 背景色
	 */
	public int getBackColor() {
		return backColor;
	}

	/**
	 * 设置背景色，例如：Color.BLUE.getRGB()
	 *
	 * @param backColor 背景色
	 * @return this
	 * @deprecated 请使用 {@link #setBackColor(Color)}
	 */
	@Deprecated
	public QrConfig setBackColor(int backColor) {
		this.backColor = backColor;
		return this;
	}

	/**
	 * 设置背景色，例如：Color.BLUE
	 *
	 * @param backColor 背景色,null表示透明背景
	 * @return this
	 * @since 5.1.1
	 */
	public QrConfig setBackColor(Color backColor) {
		if(null == backColor){
			this.backColor = null;
		} else {
			this.backColor = backColor.getRGB();
		}
		return this;
	}

	/**
	 * 获取边距
	 *
	 * @return 边距
	 */
	public Integer getMargin() {
		return margin;
	}

	/**
	 * 设置边距
	 *
	 * @param margin 边距
	 * @return this
	 */
	public QrConfig setMargin(Integer margin) {
		this.margin = margin;
		return this;
	}

	/**
	 * 设置二维码中的信息量，可设置0-40的整数，二维码图片也会根据qrVersion而变化，0表示根据传入信息自动变化
	 *
	 * @return 二维码中的信息量
	 */
	public Integer getQrVersion() {
		return qrVersion;
	}

	/**
	 * 设置二维码中的信息量，可设置0-40的整数，二维码图片也会根据qrVersion而变化，0表示根据传入信息自动变化
	 *
	 * @param qrVersion 二维码中的信息量
	 * @return this
	 */
	public QrConfig setQrVersion(Integer qrVersion) {
		this.qrVersion = qrVersion;
		return this;
	}

	/**
	 * 获取纠错级别
	 *
	 * @return 纠错级别
	 */
	public ErrorCorrectionLevel getErrorCorrection() {
		return errorCorrection;
	}

	/**
	 * 设置纠错级别
	 *
	 * @param errorCorrection 纠错级别
	 * @return this
	 */
	public QrConfig setErrorCorrection(ErrorCorrectionLevel errorCorrection) {
		this.errorCorrection = errorCorrection;
		return this;
	}

	/**
	 * 获取编码
	 *
	 * @return 编码
	 */
	public Charset getCharset() {
		return charset;
	}

	/**
	 * 设置编码
	 *
	 * @param charset 编码
	 * @return this
	 */
	public QrConfig setCharset(Charset charset) {
		this.charset = charset;
		return this;
	}

	/**
	 * 获取二维码中的Logo
	 *
	 * @return Logo图片
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * 设置二维码中的Logo文件
	 *
	 * @param imgPath 二维码中的Logo路径
	 * @return this;
	 */
	public QrConfig setImg(String imgPath) {
		return setImg(FileUtil.file(imgPath));
	}

	/**
	 * 设置二维码中的Logo文件
	 *
	 * @param imgFile 二维码中的Logo
	 * @return this;
	 */
	public QrConfig setImg(File imgFile) {
		return setImg(ImgUtil.read(imgFile));
	}

	/**
	 * 设置二维码中的Logo
	 *
	 * @param img 二维码中的Logo
	 * @return this;
	 */
	public QrConfig setImg(Image img) {
		this.img = img;
		return this;
	}

	/**
	 * 获取二维码中的Logo缩放的比例系数，如5表示长宽最小值的1/5
	 *
	 * @return 二维码中的Logo缩放的比例系数，如5表示长宽最小值的1/5
	 */
	public int getRatio() {
		return this.ratio;
	}

	/**
	 * 设置二维码中的Logo缩放的比例系数，如5表示长宽最小值的1/5
	 *
	 * @param ratio 二维码中的Logo缩放的比例系数，如5表示长宽最小值的1/5
	 * @return this;
	 */
	public QrConfig setRatio(int ratio) {
		this.ratio = ratio;
		return this;
	}

	/**
	 * 设置DATA_MATRIX的符号形状
	 *
	 * @param shapeHint DATA_MATRIX的符号形状
	 * @return this;
	 */
	public QrConfig setShapeHint(SymbolShapeHint shapeHint) {
		this.shapeHint = shapeHint;
		return this;
	}

	/**
	 * 转换为Zxing的二维码配置
	 *
	 * @return 配置
	 */
	public HashMap<EncodeHintType, Object> toHints() {
		return toHints(BarcodeFormat.QR_CODE);
	}

	/**
	 * 转换为Zxing的二维码配置
	 *
	 * @param format 格式，根据格式不同，{@link #errorCorrection}的值类型有所不同
	 * @return 配置
	 */
	public HashMap<EncodeHintType, Object> toHints(BarcodeFormat format) {
		// 配置
		final HashMap<EncodeHintType, Object> hints = new HashMap<>();
		if (null != this.charset) {
			hints.put(EncodeHintType.CHARACTER_SET, charset.toString().toLowerCase());
		}
		if (null != this.errorCorrection) {
			Object value;
			if(BarcodeFormat.AZTEC == format || BarcodeFormat.PDF_417 == format){
				// issue#I4FE3U@Gitee
				value = this.errorCorrection.getBits();
			} else {
				value = this.errorCorrection;
			}

			hints.put(EncodeHintType.ERROR_CORRECTION, value);
			hints.put(EncodeHintType.DATA_MATRIX_SHAPE, shapeHint);
		}
		if (null != this.margin) {
			hints.put(EncodeHintType.MARGIN, this.margin);
		}
		if (null != this.qrVersion){
			hints.put(EncodeHintType.QR_VERSION, this.qrVersion);
		}
		return hints;
	}
}
