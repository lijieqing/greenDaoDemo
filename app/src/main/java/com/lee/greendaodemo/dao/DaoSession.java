package com.lee.greendaodemo.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.lee.greendaodemo.zoomlion.AuthorizeRecord;
import com.lee.greendaodemo.zoomlion.CheckChartData;
import com.lee.greendaodemo.zoomlion.CheckImageData;
import com.lee.greendaodemo.zoomlion.CheckItemData;
import com.lee.greendaodemo.zoomlion.CheckItemDetailData;
import com.lee.greendaodemo.zoomlion.CheckRecord;

import com.lee.greendaodemo.dao.AuthorizeRecordDao;
import com.lee.greendaodemo.dao.CheckChartDataDao;
import com.lee.greendaodemo.dao.CheckImageDataDao;
import com.lee.greendaodemo.dao.CheckItemDataDao;
import com.lee.greendaodemo.dao.CheckItemDetailDataDao;
import com.lee.greendaodemo.dao.CheckRecordDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig authorizeRecordDaoConfig;
    private final DaoConfig checkChartDataDaoConfig;
    private final DaoConfig checkImageDataDaoConfig;
    private final DaoConfig checkItemDataDaoConfig;
    private final DaoConfig checkItemDetailDataDaoConfig;
    private final DaoConfig checkRecordDaoConfig;

    private final AuthorizeRecordDao authorizeRecordDao;
    private final CheckChartDataDao checkChartDataDao;
    private final CheckImageDataDao checkImageDataDao;
    private final CheckItemDataDao checkItemDataDao;
    private final CheckItemDetailDataDao checkItemDetailDataDao;
    private final CheckRecordDao checkRecordDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        authorizeRecordDaoConfig = daoConfigMap.get(AuthorizeRecordDao.class).clone();
        authorizeRecordDaoConfig.initIdentityScope(type);

        checkChartDataDaoConfig = daoConfigMap.get(CheckChartDataDao.class).clone();
        checkChartDataDaoConfig.initIdentityScope(type);

        checkImageDataDaoConfig = daoConfigMap.get(CheckImageDataDao.class).clone();
        checkImageDataDaoConfig.initIdentityScope(type);

        checkItemDataDaoConfig = daoConfigMap.get(CheckItemDataDao.class).clone();
        checkItemDataDaoConfig.initIdentityScope(type);

        checkItemDetailDataDaoConfig = daoConfigMap.get(CheckItemDetailDataDao.class).clone();
        checkItemDetailDataDaoConfig.initIdentityScope(type);

        checkRecordDaoConfig = daoConfigMap.get(CheckRecordDao.class).clone();
        checkRecordDaoConfig.initIdentityScope(type);

        authorizeRecordDao = new AuthorizeRecordDao(authorizeRecordDaoConfig, this);
        checkChartDataDao = new CheckChartDataDao(checkChartDataDaoConfig, this);
        checkImageDataDao = new CheckImageDataDao(checkImageDataDaoConfig, this);
        checkItemDataDao = new CheckItemDataDao(checkItemDataDaoConfig, this);
        checkItemDetailDataDao = new CheckItemDetailDataDao(checkItemDetailDataDaoConfig, this);
        checkRecordDao = new CheckRecordDao(checkRecordDaoConfig, this);

        registerDao(AuthorizeRecord.class, authorizeRecordDao);
        registerDao(CheckChartData.class, checkChartDataDao);
        registerDao(CheckImageData.class, checkImageDataDao);
        registerDao(CheckItemData.class, checkItemDataDao);
        registerDao(CheckItemDetailData.class, checkItemDetailDataDao);
        registerDao(CheckRecord.class, checkRecordDao);
    }
    
    public void clear() {
        authorizeRecordDaoConfig.clearIdentityScope();
        checkChartDataDaoConfig.clearIdentityScope();
        checkImageDataDaoConfig.clearIdentityScope();
        checkItemDataDaoConfig.clearIdentityScope();
        checkItemDetailDataDaoConfig.clearIdentityScope();
        checkRecordDaoConfig.clearIdentityScope();
    }

    public AuthorizeRecordDao getAuthorizeRecordDao() {
        return authorizeRecordDao;
    }

    public CheckChartDataDao getCheckChartDataDao() {
        return checkChartDataDao;
    }

    public CheckImageDataDao getCheckImageDataDao() {
        return checkImageDataDao;
    }

    public CheckItemDataDao getCheckItemDataDao() {
        return checkItemDataDao;
    }

    public CheckItemDetailDataDao getCheckItemDetailDataDao() {
        return checkItemDetailDataDao;
    }

    public CheckRecordDao getCheckRecordDao() {
        return checkRecordDao;
    }

}
