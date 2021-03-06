/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package jp.isisredirect.appirater;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import com.sbstrm.appirater.Appirater;


@Kroll.module(name="Appirater", id="jp.isisredirect.appirater")
public class AppiraterModule extends KrollModule
{

	// Standard Debugging variables
	private static final String LCAT = "AppiraterModule";
	private static final boolean DBG = TiConfig.LOGD;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	String appid = "";
	int daysUntilPrompt = 30;
	int usesUntilPrompt = 15;
	int timeBeforeReminding = 3;
	boolean debug = false;
	
	public AppiraterModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(LCAT, "inside onAppCreate");
	}

	// Methods
	@Kroll.method
	public void load(KrollDict options)
	{
		Log.d(LCAT, "load");
		if (options.containsKey("appid")) {
			appid = (String)options.get("appid");
		}else{
			appid = "";
		}
		if (options.containsKey("daysUntilPrompt")) {
			daysUntilPrompt = (Integer)options.get("daysUntilPrompt");
		}else{
			daysUntilPrompt = 30;
		}
		if (options.containsKey("usesUntilPrompt")) {
			usesUntilPrompt = (Integer)options.get("usesUntilPrompt");
		}else{
			usesUntilPrompt = 15;
		}
		if (options.containsKey("timeBeforeReminding")) {
			timeBeforeReminding = (Integer)options.get("timeBeforeReminding");
		}else{
			timeBeforeReminding = 3;
		}
		if (options.containsKey("debug")) {
			debug = (Boolean)options.get("debug");
		}else{
			debug = false;
		}
	}
	
	@Kroll.method
	public void opened()
	{
		Log.d(LCAT, "opened");
		Appirater.appLaunched(TiApplication.getInstance().getRootActivity(), 
				appid, daysUntilPrompt, usesUntilPrompt, timeBeforeReminding, debug);
	}
}

