package com.lee.greendaodemo.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.lee.greendaodemo.zoomlion.CheckItemDetailData;

import com.lee.greendaodemo.zoomlion.CheckChartData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHECK_CHART_DATA".
*/
public class CheckChartDataDao extends AbstractDao<CheckChartData, Long> {

    public static final String TABLENAME = "CHECK_CHART_DATA";

    /**
     * Properties of entity CheckChartData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ChartId = new Property(0, Long.class, "chartId", true, "_id");
        public final static Property ItemDetailId = new Property(1, Long.class, "itemDetailId", false, "ITEM_DETAIL_ID");
        public final static Property ParamName = new Property(2, String.class, "paramName", false, "PARAM_NAME");
        public final static Property ChartData = new Property(3, String.class, "chartData", false, "CHART_DATA");
    }

    private DaoSession daoSession;

    private Query<CheckChartData> checkItemDetailData_CheckChartDatasQuery;

    public CheckChartDataDao(DaoConfig config) {
        super(config);
    }
    
    public CheckChartDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHECK_CHART_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: chartId
                "\"ITEM_DETAIL_ID\" INTEGER," + // 1: itemDetailId
                "\"PARAM_NAME\" TEXT," + // 2: paramName
                "\"CHART_DATA\" TEXT);"); // 3: chartData
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHECK_CHART_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CheckChartData entity) {
        stmt.clearBindings();
 
        Long chartId = entity.getChartId();
        if (chartId != null) {
            stmt.bindLong(1, chartId);
        }
 
        Long itemDetailId = entity.getItemDetailId();
        if (itemDetailId != null) {
            stmt.bindLong(2, itemDetailId);
        }
 
        String paramName = entity.getParamName();
        if (paramName != null) {
            stmt.bindString(3, paramName);
        }
 
        String chartData = entity.getChartData();
        if (chartData != null) {
            stmt.bindString(4, chartData);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CheckChartData entity) {
        stmt.clearBindings();
 
        Long chartId = entity.getChartId();
        if (chartId != null) {
            stmt.bindLong(1, chartId);
        }
 
        Long itemDetailId = entity.getItemDetailId();
        if (itemDetailId != null) {
            stmt.bindLong(2, itemDetailId);
        }
 
        String paramName = entity.getParamName();
        if (paramName != null) {
            stmt.bindString(3, paramName);
        }
 
        String chartData = entity.getChartData();
        if (chartData != null) {
            stmt.bindString(4, chartData);
        }
    }

    @Override
    protected final void attachEntity(CheckChartData entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CheckChartData readEntity(Cursor cursor, int offset) {
        CheckChartData entity = new CheckChartData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // chartId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // itemDetailId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // paramName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // chartData
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CheckChartData entity, int offset) {
        entity.setChartId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setItemDetailId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setParamName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setChartData(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CheckChartData entity, long rowId) {
        entity.setChartId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CheckChartData entity) {
        if(entity != null) {
            return entity.getChartId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CheckChartData entity) {
        return entity.getChartId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "checkChartDatas" to-many relationship of CheckItemDetailData. */
    public List<CheckChartData> _queryCheckItemDetailData_CheckChartDatas(Long itemDetailId) {
        synchronized (this) {
            if (checkItemDetailData_CheckChartDatasQuery == null) {
                QueryBuilder<CheckChartData> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ItemDetailId.eq(null));
                checkItemDetailData_CheckChartDatasQuery = queryBuilder.build();
            }
        }
        Query<CheckChartData> query = checkItemDetailData_CheckChartDatasQuery.forCurrentThread();
        query.setParameter(0, itemDetailId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getCheckItemDetailDataDao().getAllColumns());
            builder.append(" FROM CHECK_CHART_DATA T");
            builder.append(" LEFT JOIN CHECK_ITEM_DETAIL_DATA T0 ON T.\"ITEM_DETAIL_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected CheckChartData loadCurrentDeep(Cursor cursor, boolean lock) {
        CheckChartData entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        CheckItemDetailData checkItemDetailData = loadCurrentOther(daoSession.getCheckItemDetailDataDao(), cursor, offset);
        entity.setCheckItemDetailData(checkItemDetailData);

        return entity;    
    }

    public CheckChartData loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<CheckChartData> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<CheckChartData> list = new ArrayList<CheckChartData>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<CheckChartData> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<CheckChartData> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
