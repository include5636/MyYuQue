package com.fjx.myYuQue.mapper;

import java.util.List;
import com.fjx.myYuQue.dao.Doc;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DocMapper {
    
    List<Doc> queryDocs();

    List<Doc> queryTags();

    int addDoc(Doc doc);

    int updateDoc(Doc doc);

    Doc getDocById(int id);

    List<Doc> getDocByTag(String tag);

    int deleteDocById(int id);
}
