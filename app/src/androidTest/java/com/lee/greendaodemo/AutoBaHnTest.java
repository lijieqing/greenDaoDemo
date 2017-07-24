package com.lee.greendaodemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.lee.greendaodemo.dao.CheckItemDataDao;
import com.lee.greendaodemo.dao.CheckRecordDao;
import com.lee.greendaodemo.zoomlion.CheckItemData;
import com.lee.greendaodemo.zoomlion.CheckRecord;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketHandler;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AutoBaHnTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.lee.greendaodemo", appContext.getPackageName());
    }

    @Test
    public void testGreenDao() throws Exception{
        WebSocketConnection wc = new WebSocketConnection();

        wc.connect("ws:",new WebSocketHandler(){
            @Override
            public void onOpen() {
                super.onOpen();
            }

            @Override
            public void onTextMessage(String payload) {
                super.onTextMessage(payload);
            }

            @Override
            public void onClose(int code, String reason) {
                super.onClose(code, reason);
            }
        });
    }
}
