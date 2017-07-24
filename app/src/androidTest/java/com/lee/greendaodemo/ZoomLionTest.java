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

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ZoomLionTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.lee.greendaodemo", appContext.getPackageName());
    }

    @Test
    public void testGreenDao() throws Exception{
        CheckRecordDao checkRecordDao = MyApplication.getApplication().getDaoSession().getCheckRecordDao();
        CheckItemDataDao checkItemDao = MyApplication.getApplication().getDaoSession().getCheckItemDataDao();

        CheckRecord record = new CheckRecord();
        record.setCheckRecordName("test record");
        record.setCreateTime(new Date());

        checkRecordDao.insert(record);

        CheckItemData checkItemData = new CheckItemData();
        checkItemData.setItemName("回转压力");
        checkItemData.setQcId(45);
        checkItemData.setCheckRecord(record);

        checkItemDao.insert(checkItemData);

        checkItemData = new CheckItemData();
        checkItemData.setItemName("附属压力");
        checkItemData.setQcId(15);
        checkItemData.setCheckRecord(record);

        checkItemDao.insert(checkItemData);

        checkItemData = new CheckItemData();
        checkItemData.setItemName("左回转压力");
        checkItemData.setQcId(22);

        checkItemDao.insert(checkItemData);


        record = checkRecordDao.queryBuilder().build().unique();
        Log.e("zoomlion",record.getCheckRecordName()+""+record.getCreateTime());
        List<CheckItemData> items = record.getCheckItemDatas();
        for (CheckItemData item : items) {
            Log.e("zoomlion",item.getItemName());
        }

    }
}
