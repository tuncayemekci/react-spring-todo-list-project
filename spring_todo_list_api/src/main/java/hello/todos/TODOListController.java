package hello.todos;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;


@RestController
public class TODOListController {


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/get_all_todo_lists")
    public @ResponseBody
    ArrayList<TODOList> get_all_todo_lists(){
        return TODOList.getAll_todo_lists();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/get_todo_list")
    public TODOList get_todo_list(@RequestParam(value="list_name", defaultValue = "None") String list_name){
        return TODOList.getTODOListByItsName(list_name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/create_todo_list")
    public ArrayList<TODOList> create_todo_list(@RequestParam(value="list_name", defaultValue = "None") String list_name){
        new TODOList(list_name);
        return TODOList.getAll_todo_lists();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/add_item_to_todo_list")
    public ArrayList<TODOList> add_item_to_todo_list(@RequestParam(value="list_name", defaultValue = "None") String list_name,
                                          @RequestParam(value="item_text", defaultValue = "None") String item_text){
        TODOList.addItemToTODOList(list_name, item_text);
        return TODOList.getAll_todo_lists();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/change_item_status")
    public ArrayList<TODOList> change_item_status(@RequestParam(value="list_name", defaultValue = "None") String list_name,
                                                     @RequestParam(value="item_text", defaultValue = "None") String item_text){
        TODOList.changeItemStatus(list_name, item_text);
        return TODOList.getAll_todo_lists();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/remove_todo_list")
    public ArrayList<TODOList> remove_todo_list(@RequestParam(value="list_name", defaultValue = "None") String list_name){
        TODOList.removeTODOList(list_name);
        return TODOList.getAll_todo_lists();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/remove_todo_list_item")
    public ArrayList<TODOList> remove_todo_list_item(@RequestParam(value="list_name", defaultValue = "None") String list_name,
                                                  @RequestParam(value="item_text", defaultValue = "None") String item_text){
        TODOList.getTODOListByItsName(list_name).removeItemFromTODOList(item_text);
        return TODOList.getAll_todo_lists();
    }

}
