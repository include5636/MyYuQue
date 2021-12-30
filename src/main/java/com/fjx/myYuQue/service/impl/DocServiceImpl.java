package com.fjx.myYuQue.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.fjx.myYuQue.dao.Doc;
import com.fjx.myYuQue.mapper.DocMapper;
import com.fjx.myYuQue.service.DocService;
import org.springframework.stereotype.Service;

@Service
public class DocServiceImpl implements DocService {

    @Resource
    private DocMapper docMapper;

    @Override
    public List<Doc> queryDocs() {
        return docMapper.queryDocs();
    }

    @Override
    public List<Doc> queryTags() {
        return docMapper.queryTags();
    }

    @Override
    public int addDoc(Doc doc) {
        return docMapper.addDoc(doc);
    }

    @Override
    public int updateDoc(Doc doc) {
        return docMapper.updateDoc(doc);
    }

    @Override
    public Doc getDocById(int id) {
        return docMapper.getDocById(id);
    }

    @Override
    public List<Doc> getDocByTag(String tag) {
        return docMapper.getDocByTag(tag);
    }

    @Override
    public int deleteDocById(int id) {
        return docMapper.deleteDocById(id);
    }
}
