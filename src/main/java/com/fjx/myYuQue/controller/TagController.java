package com.fjx.myYuQue.controller;

import java.util.List;

import javax.annotation.Resource;
import com.fjx.myYuQue.dao.Doc;
import com.fjx.myYuQue.service.DocService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("tag")
public class TagController {

    @Resource
    private DocService docService;

    @RequestMapping("/viewList")
    public String viewTagList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(pn, size);
        List<Doc> docs = docService.queryTags();
        PageInfo<Doc> page = new PageInfo<>(docs);
        model.addAttribute("page", page);
        return "viewTags";
    }

    @GetMapping("/{tag}")
    public String viewDocList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size, @PathVariable("tag") String tag) {
        System.out.println("!!@@@@");
        PageHelper.startPage(pn, size);
        List<Doc> docs = docService.getDocByTag(tag);
        PageInfo<Doc> page = new PageInfo<>(docs);
        model.addAttribute("page", page);
        return "viewDocs";
    }

    // @GetMapping("/{tag}")
    // public String show(@PathVariable("tag") String tag, Model model) {
    //     List<Doc> docs = docService.getDocByTag(tag);
    //     model.addAttribute("doc", doc);
    //     return "viewDoc";
    // }
}
