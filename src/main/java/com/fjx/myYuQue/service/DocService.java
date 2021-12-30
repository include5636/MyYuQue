package com.fjx.myYuQue.service;

import java.util.List;
import com.fjx.myYuQue.dao.Doc;

public interface DocService {

    List<Doc> queryDocs();

    List<Doc> queryTags();

    int addDoc(Doc doc);

    int updateDoc(Doc doc);

    Doc getDocById(int id);

    List<Doc> getDocByTag(String tag);

    int deleteDocById(int id);
}
