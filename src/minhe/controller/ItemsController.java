package minhe.controller;

import minhe.pojo.Items;
import minhe.service.ItemsService;
import minhe.vo.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ItemsController {
    @Resource(name = "itemsService")
    private ItemsService itemsService; //注入

    @RequestMapping("/list")
    public ModelAndView itemsList(){
        List<Items> list = itemsService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList",list);
        modelAndView.setViewName("itemList");

        return modelAndView;
    }
    @RequestMapping("/itemEdit")
    public String itemEdit(HttpServletRequest request, Model model){
        String idStr = request.getParameter("id");

        Items item = itemsService.findItemById(Integer.parseInt(idStr));
        // Model模型：放入了返回给页面的数据
        model.addAttribute("item",item);
        // 如果SpringMVC方法返回一个简单的字符串，那么springMVC会认为这个字符串就是页面名称
        return "editItem";
    }
    /*springMVC可以直接接受pojo类型：要求页面上input框的name属性名称必须等于pojo的属性名称*/
    @RequestMapping("/updateItem")
    public String updateItem(Items items){
        //items.setCreatetime(new Date());
        itemsService.updateItem(items);
        return "updateSuccess";
    }
    @RequestMapping("/search")
    public String search(QueryVo queryVo){
        System.out.println(queryVo);
        return "";
    }

}
