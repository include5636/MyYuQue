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
@RequestMapping("doc")
public class DocController {

    @Resource
    private DocService docService;

    @RequestMapping("/editor")
    public String toEditor() {
        return "editormd";
    }

    @RequestMapping("/addDoc")
    public String addNewDoc(Doc doc) {
        docService.addDoc(doc);
        return "editormd";
    }

    @RequestMapping("/viewList")
    public String viewDocList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(pn, size);
        List<Doc> docs = docService.queryDocs();
        PageInfo<Doc> page = new PageInfo<>(docs);
        model.addAttribute("page", page);
        return "viewDocs";
    }

    /** 查看具体某篇文章 */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Doc doc = docService.getDocById(id);
        model.addAttribute("doc", doc);
        return "viewDoc";
    }

    /** 删除文章 */
    @GetMapping("/delete/{id}")
    public String deleteDoc(@PathVariable("id") int id) {
        docService.deleteDocById(id);
        return "redirect:/doc/viewList";
    }

    @RequestMapping("/updateDoc")
    public String updateDoc(Doc doc) {
        System.out.println(doc);
        docService.updateDoc(doc);
        return "redirect:/doc/viewList";
    }
}
