package com.fiona.uidemo.config;


import com.fiona.uidemo.BuildConfig;

/**
 * 配置一些debug和release的信息
 * @version V1.0.0
 * @author Fiona <br/>
 * Create at  2015-12-18 17:22:05
 */
public class VersionConfig {
	
	/** 是否自动填充验证码*/
	public static final boolean AutoFillMCode= true;
	
	/** release 的时候是否打印日志(测试版需要打印，发布版本不打印) **/
	public static final boolean LOG_ENABLE_RELEASE = false;
	
	public static boolean isDebug() {
		return BuildConfig.DEBUG || LOG_ENABLE_RELEASE;
	}
}
