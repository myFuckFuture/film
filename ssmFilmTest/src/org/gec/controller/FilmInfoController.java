package org.gec.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.gec.pojo.Filminfo;
import org.gec.pojo.FilminfoExample;
import org.gec.pojo.Filmtype;
import org.gec.query.FilmInfoQuery;
import org.gec.service.FilmInfoService;
import org.gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 电影类型详细类的Controller类
 * @Author 余永浩
 * @Date 11:00 2020/6/21
**/
@Controller
public class FilmInfoController {



    //  1.引入Service层服务
    @Autowired
    FilmInfoService filmInfoService;
    @Autowired
    FilmTypeService filmTypeService;
    @RequestMapping("/findFilmInfoList")
    public ModelAndView findFilmInfoList(FilminfoExample example, FilmInfoQuery query){
        //  1.设置分页
        if(query.getPageNum()==null){
            query.setPageNum(1);
        }
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        //  2.添加查询条件
        FilminfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(query.getFilmName())){
            criteria.andFilmnameLike("%"+query.getFilmName()+"%");
        }
        if(query.getTypeId()!=null && query.getTypeId() !=0){
            criteria.andTypeidEqualTo(query.getTypeId());
        }
        if(StringUtils.isNotEmpty(query.getActor())){
            criteria.andActorLike("%"+query.getActor()+"%");
        }
        if(StringUtils.isNotEmpty(query.getDirector())){
            criteria.andDirectorLike("%"+query.getDirector()+"%");
        }
        if(query.getSmallPrice()!=null&& query.getSmallPrice()!=new BigDecimal(0)){
            criteria.andTicketpriceGreaterThanOrEqualTo(query.getSmallPrice());
        }
        if(query.getBigPrice()!=null&&query.getBigPrice()!=new BigDecimal(0)){
            criteria.andTicketpriceLessThanOrEqualTo(query.getBigPrice());
        }
        //  3.查询电影列表
        List<Filminfo> filmInfoList= filmInfoService.findFilmInfoListByPage(example);

       //   4.获取分页组件参数
        PageInfo pageInfo = new PageInfo(filmInfoList);

        //  5.创建ModelAndView对象
        ModelAndView mv=new ModelAndView();

        //  6.设置返回的数据和页面
        mv.addObject("filmInfoList",filmInfoList);
        mv.addObject("query",query);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("page/filmList");

        //  7.返回ModelAndView对象
        return mv;
    }

    //  2.发布电影
    @RequestMapping("/addFilmInfo")
    public ModelAndView addFilmInfo(){
        System.out.println("添加电影啊");
        //  1.获取电影类型列表
        List<Filmtype> filmTypeList = filmTypeService.findFilmTypeList();
        //  2.创建ModelAndView对象
        ModelAndView mv=new ModelAndView();
        //  3.设置返回的数据和跳转的页面
        mv.addObject("filmTypeList",filmTypeList);
        mv.setViewName("page/addFilmInfo");
        //  4.返回ModelAndView对象
        return mv;
    }

    //  3.查询点电影名是否存在
    @RequestMapping("/checkFilmName")
    @ResponseBody
    public String checkFilmName(String filmName){
        System.out.println("电影名："+filmName);
        boolean isExist=filmInfoService.checkFilmName(filmName);
        System.out.println("返回值："+isExist);
        return isExist+"";
    }

    //  4.保存电影信息
    @RequestMapping("/saveFilmInfo")
    public String saveFilmInfo(Filminfo filmInfo, MultipartFile picName){
        //  1.获取图片名称
        String filename = picName.getOriginalFilename();
        //  2.存储图片
        if(StringUtils.isNotEmpty(filename)){
            File file=new File("C:\\Users\\lenovo\\Desktop\\upload",filename);
        }


        //  1.保存数据
        filmInfoService.addFilmInfo(filmInfo);
        //  设置跳转的页面
        return "forward:findFilmTypeList";
    }
}
