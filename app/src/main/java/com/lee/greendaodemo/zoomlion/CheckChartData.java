package com.lee.greendaodemo.zoomlion;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.lee.greendaodemo.dao.DaoSession;
import com.lee.greendaodemo.dao.CheckItemDetailDataDao;
import com.lee.greendaodemo.dao.CheckChartDataDao;

/**
 * Created by lijie on 2017/7/11.
 */

@Entity
public class CheckChartData {
    @Id(autoincrement = true)
    private Long chartId;

    private Long itemDetailId;

    @ToOne(joinProperty = "itemDetailId")
    private CheckItemDetailData checkItemDetailData;

    @Property
    private String paramName;

    @Property
    private String chartData;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1959493665)
    private transient CheckChartDataDao myDao;

    @Generated(hash = 1682136279)
    public CheckChartData(Long chartId, Long itemDetailId, String paramName,
            String chartData) {
        this.chartId = chartId;
        this.itemDetailId = itemDetailId;
        this.paramName = paramName;
        this.chartData = chartData;
    }

    @Generated(hash = 1002407687)
    public CheckChartData() {
    }

    public Long getChartId() {
        return this.chartId;
    }

    public void setChartId(Long chartId) {
        this.chartId = chartId;
    }

    public Long getItemDetailId() {
        return this.itemDetailId;
    }

    public void setItemDetailId(Long itemDetailId) {
        this.itemDetailId = itemDetailId;
    }

    public String getChartData() {
        return this.chartData;
    }

    public void setChartData(String chartData) {
        this.chartData = chartData;
    }

    @Generated(hash = 1841648991)
    private transient Long checkItemDetailData__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1085242501)
    public CheckItemDetailData getCheckItemDetailData() {
        Long __key = this.itemDetailId;
        if (checkItemDetailData__resolvedKey == null
                || !checkItemDetailData__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CheckItemDetailDataDao targetDao = daoSession
                    .getCheckItemDetailDataDao();
            CheckItemDetailData checkItemDetailDataNew = targetDao.load(__key);
            synchronized (this) {
                checkItemDetailData = checkItemDetailDataNew;
                checkItemDetailData__resolvedKey = __key;
            }
        }
        return checkItemDetailData;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1234636611)
    public void setCheckItemDetailData(CheckItemDetailData checkItemDetailData) {
        synchronized (this) {
            this.checkItemDetailData = checkItemDetailData;
            itemDetailId = checkItemDetailData == null ? null
                    : checkItemDetailData.getCheckItemDetailId();
            checkItemDetailData__resolvedKey = itemDetailId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 378641548)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCheckChartDataDao() : null;
    }

    public String getParamName() {
        return this.paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
