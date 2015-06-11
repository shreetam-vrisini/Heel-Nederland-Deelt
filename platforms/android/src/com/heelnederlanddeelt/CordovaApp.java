/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.heelnederlanddeelt;

import android.os.Bundle;
import org.apache.cordova.*;
import android.util.Log;
import android.view.Display;
import android.webkit.WebSettings;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebSettings.RenderPriority;
import android.view.WindowManager;
import android.content.Context;

public class CordovaApp extends CordovaActivity
{
	// declare the original size of the iPad app
	protected float ORIG_APP_W = 1052;
	protected float ORIG_APP_H = 1004;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {		
        super.onCreate(savedInstanceState);
        super.init();
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
        // set some defaults
		
		this.appView.setBackgroundColor(0x000000);
		this.appView.setHorizontalScrollBarEnabled(false);
		this.appView.setHorizontalScrollbarOverlay(false);
		this.appView.setVerticalScrollBarEnabled(false);
		this.appView.setVerticalScrollbarOverlay(false);
		
		// get actual screen size
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		int width = display.getWidth(); 
		int height = display.getHeight(); 
		
		// calculate target scale (only dealing with portrait orientation)
		double globalScale = Math.ceil( ( width / ORIG_APP_W ) * 100 );
		
		// set some defaults on the web view		
		this.appView.getSettings().setBuiltInZoomControls( false );
		this.appView.getSettings().setSupportZoom( true );
		this.appView.getSettings().setGeolocationEnabled( true );
		this.appView.getSettings().setLightTouchEnabled( true );
		this.appView.getSettings().setRenderPriority( RenderPriority.HIGH );
		this.appView.getSettings().setDefaultZoom( ZoomDensity.FAR );
        
        this.appView.setInitialScale((int) globalScale);
    }
}
