//package com.blog.service.impl;
//
//import com.blog.dao.TopicDao;
//import com.blog.entity.Topic;
//import com.blog.factory.DaoFactory;
//import com.blog.service.TopicService;
//import com.blog.utils.Result;
//import com.blog.utils.ResultCode;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * @author zhao
// * @className TopicServiceImpl
// * @Description TODO
// * @Date 2019/11/17
// * @Version 1.0
// **/
//public class TopicServiceImpl implements TopicService {
//    private TopicDao topicDao = DaoFactory.getTopicDaoInstance();
//    private static Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);
//
//    @Override
//    public Result getHotTopics() {
//        List<Topic> topicList = null;
//        try {
//            topicList = topicDao.selectHotTopics();
//        } catch (SQLException e) {
//            logger.error("获取热门专题出现异常");
//        }
//        if (topicList != null) {
//            return Result.success(topicList);
//        }
//        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
//    }
//}
