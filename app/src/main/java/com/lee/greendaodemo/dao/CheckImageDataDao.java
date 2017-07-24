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

import com.lee.greendaodemo.zoomlion.CheckImageData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHECK_IMAGE_DATA".
*/
public class CheckImageDataDao extends AbstractDao<CheckImageData, Long> {

    public static final String TABLENAME = "CHECK_IMAGE_DATA";

    /**
     * Properties of entity CheckImageData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ImgId = new Property(0, Long.class, "imgId", true, "_id");
        public final static Property ItemDetailId = new Property(1, Long.class, "itemDetailId", false, "ITEM_DETAIL_ID");
        public final static Property ParamName = new Property(2, String.class, "paramName", false, "PARAM_NAME");
        public final static Property ImgPath = new Property(3, String.class, "imgPath", false, "IMG_PATH");
    }

    private DaoSession daoSession;

    private Query<CheckImageData> checkItemDetailData_CheckImageDatasQuery;

    public CheckImageDataDao(DaoConfig config) {
        super(config);
    }
    
    public CheckImageDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHECK_IMAGE_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: imgId
                "\"ITEM_DETAIL_ID\" INTEGER," + // 1: itemDetailId
                "\"PARAM_NAME\" TEXT," + // 2: paramName
                "\"IMG_PATH\" TEXT);"); // 3: imgPath
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHECK_IMAGE_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CheckImageData entity) {
        stmt.clearBindings();
 
        Long imgId = entity.getImgId();
        if (imgId != null) {
            stmt.bindLong(1, imgId);
        }
 
        Long itemDetailId = entity.getItemDetailId();
        if (itemDetailId != null) {
            stmt.bindLong(2, itemDetailId);
        }
 
        String paramName = entity.getParamName();
        if (paramName != null) {
            stmt.bindString(3, paramName);
        }
 
        String imgPath = entity.getImgPath();
        if (imgPath != null) {
            stmt.bindString(4, imgPath);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CheckImageData entity) {
        stmt.clearBindings();
 
        Long imgId = entity.getImgId();
        if (imgId != null) {
            stmt.bindLong(1, imgId);
        }
 
        Long itemDetailId = entity.getItemDetailId();
        if (itemDetailId != null) {
            stmt.bindLong(2, itemDetailId);
        }
 
        String paramName = entity.getParamName();
        if (paramName != null) {
            stmt.bindString(3, paramName);
        }
 
        String imgPath = entity.getImgPath();
        if (imgPath != null) {
            stmt.bindString(4, imgPath);
        }
    }

    @Override
    protected final void attachEntity(CheckImageData entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CheckImageData readEntity(Cursor cursor, int offset) {
        CheckImageData entity = new CheckImageData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // imgId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // itemDetailId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // paramName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // imgPath
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CheckImageData entity, int offset) {
        entity.setImgId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setItemDetailId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setParamName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setImgPath(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CheckImageData entity, long rowId) {
        entity.setImgId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CheckImageData entity) {
        if(entity != null) {
            return entity.getImgId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CheckImageData entity) {
        return entity.getImgId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "checkImageDatas" to-many relationship of CheckItemDetailData. */
    public List<CheckImageData> _queryCheckItemDetailData_CheckImageDatas(Long itemDetailId) {
        synchronized (this) {
            if (checkItemDetailData_CheckImageDatasQuery == null) {
                QueryBuilder<CheckImageData> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ItemDetailId.eq(null));
                checkItemDetailData_CheckImageDatasQuery = queryBuilder.build();
            }
        }
        Query<CheckImageData> query = checkItemDetailData_CheckImageDatasQuery.forCurrentThread();
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
            builder.append(" FROM CHECK_IMAGE_DATA T");
            builder.append(" LEFT JOIN CHECK_ITEM_DETAIL_DATA T0 ON T.\"ITEM_DETAIL_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected CheckImageData loadCurrentDeep(Cursor cursor, boolean lock) {
        CheckImageData entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        CheckItemDetailData checkItemDetailData = loadCurrentOther(daoSession.getCheckItemDetailDataDao(), cursor, offset);
        entity.setCheckItemDetailData(checkItemDetailData);

        return entity;    
    }

    public CheckImageData loadDeep(Long key) {
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
    public List<CheckImageData> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<CheckImageData> list = new ArrayList<CheckImageData>(count);
        
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
    
    protected List<CheckImageData> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<CheckImageData> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}