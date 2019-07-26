package com.winter.test;

import com.winter.mapper.TUserMapper;
import com.winter.model.TUser;
import com.winter.model.TUserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        String resource = "conf.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
            if (false){
                TUser tUser = new TUser();
                for (int i=1; i<11; ++i){
                    tUser.setUserName(i+"");
                    tUser.setPassword(i+"");
                    tUser.setPhone(i+"");
                    tUser.setUserId(i);
                    mapper.insert(tUser);
                }
            }

            if (false){
                TUserExample tUserExample = new TUserExample();
                tUserExample.createCriteria().andPasswordEqualTo("1");
                int i = mapper.deleteByExample(tUserExample);
                System.out.println(i);
            }

            if (false){
                int userId = 3;
                int i = mapper.deleteByPrimaryKey(userId);
                System.out.println(i);
            }

            if (false){
                TUser tUser = new TUser();
                tUser.setUserId(11);
                tUser.setUserName("11");
                int i = mapper.insertSelective(tUser);
            }
            if (false){
                TUserExample tUserExample = new TUserExample();
                tUserExample.setDistinct(true);
                tUserExample.setOrderByClause("user_id desc");
                tUserExample.createCriteria().andPasswordEqualTo("2");
                List<TUser> tUsers = mapper.selectByExample(tUserExample);
                System.out.println(tUsers.size());
            }
            if (true){

            }

            sqlSession.commit();
            if (sqlSessionFactory != null) {
                sqlSessionFactory = null;
            }
            if (sqlSession != null) {
                sqlSession = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
