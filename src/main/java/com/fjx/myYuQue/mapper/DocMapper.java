package com.fjx.myYuQue.mapper;

import java.util.List;
import com.fjx.myYuQue.dao.Doc;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DocMapper {
    //查询所有的文章
    List<Doc> queryDocs();
    //新增一个文章
    int addDoc(Doc doc);
    //根据文章id查询文章
    Doc getDocById(int id);
    //根据文章id删除文章
    int deleteDocById(int id);
}
