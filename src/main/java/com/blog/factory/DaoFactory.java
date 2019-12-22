package com.blog.factory;

import com.blog.dao.*;
import com.blog.dao.impl.*;
import com.blog.entity.Leave;
import com.blog.entity.Record;
import com.blog.entity.Space;

public class DaoFactory {
    public static UserDao getUserDaoInstance(){
        return (UserDao) new UserDaoImpl();
    }

    public static ArticleDao getArcticleDaoInstance(){
        return (ArticleDao) new ArticleDaoImpl();
    }

    public static GalleryDao getGalleryDaoInstance(){
        return (GalleryDao) new GalleryDaoImpl();
    }

    public static MusicDao getMusicDaoInstance(){
        return (MusicDao) new MusicDaoImpl();
    }

    public static ToolDao getToolDaoInstance(){
        return (ToolDao) new ToolDaoImpl();
    }

    public static LeaveDao getLeaveDaoInstance() {
        return (LeaveDao) new LeaveDaoImpl();
    }

    public static SpaceDao getSpaceDaoInstance() {
        return (SpaceDao) new SpaceDaoImpl();
    }

    public static RecordDao getRecordDaoInstance() {
        return (RecordDao) new RecordDaoImpl();
    }

    public static CommDao getCommDaoInstance() {
        return (CommDao) new CommDaoImpl();
    }

    public static ColmDao getColmDaoInstance() {
        return (ColmDao) new ColmDaoImpl();
    }

//    public static TopicDao getTopicDaoInstance() {
//        return new TopicDaoImpl();
//    }
}
