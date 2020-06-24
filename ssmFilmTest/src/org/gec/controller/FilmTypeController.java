package org.gec.controller;

import org.gec.pojo.Filmtype;
import org.gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description 电影类型Controller层
 * @Author 余永浩
 * @Date 21:50 2020/6/20
 **/
@Controller
public class FilmTypeController {

    //  引入Service层资源
    @Autowired
    FilmTypeService filmTypeService;


    //  1.查询电影类型列表
    @RequestMapping("/findFilmTypeList")
    public ModelAndView findFilmTypeList() {

        System.out.println("什么回事");
        //  1.查询电影类型 列表
        List<Filmtype> filmTypeList = filmTypeService.findFilmTypeList();
        //  2.创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //  3.设置返回的数据及跳转的页面
        mv.addObject("filmTypeList", filmTypeList);

        System.out.println("电影类型:");
        filmTypeList.forEach(filmtype -> System.out.println(filmtype));
        mv.setViewName("page/findFilm");
        //   4.返回ModelAndView 对象
        return mv;
    }


}
