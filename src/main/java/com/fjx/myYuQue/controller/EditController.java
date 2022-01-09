package com.fjx.myYuQue.controller;


import javax.annotation.Resource;
import com.fjx.myYuQue.dao.Doc;
import com.fjx.myYuQue.service.DocService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("edit")
public class EditController {

    @Resource
    private DocService docService;

    /** 修改文章 */
    @GetMapping("/{id}")
    public String editDoc(@PathVariable("id") int id, Model model) {
        Doc doc = docService.getDocById(id);
        model.addAttribute("doc", doc);
        return "changeDoc";
    }

}
