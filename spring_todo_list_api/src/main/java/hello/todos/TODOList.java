package hello.todos;

import java.util.ArrayList;


public class TODOList {
    private int id;
    private String name;
    private ArrayList<TODOListItem> items;
    private static ArrayList<TODOList> all_todo_lists = new ArrayList<TODOList>();

    public TODOList(String name) {
        this.name = name;
        items = new ArrayList<TODOListItem>();
        all_todo_lists.add(this);
    }

    public static void addItemToTODOList(String list_name, String item_text) {
        TODOList todoList = getTODOListByItsName(list_name);
        if (todoList != null)
            todoList.getItems().add(new TODOListItem(item_text));
    }

    public void removeItemFromTODOList(String item_text) {
        try {
            int itemIxToBeRemoved = -1;
            for (int i = 0; i < getItems().size(); i++) {
                if (getItems().get(i).getText().equals(item_text))
                    itemIxToBeRemoved = i;
            }
            getItems().remove(itemIxToBeRemoved);
        } catch(Exception e){

        }
    }

    public static void removeTODOList(String list_name){
        try {
            int listIxToBeRemoved = -1;
            for (int i = 0; i < all_todo_lists.size(); i++) {
                if (all_todo_lists.get(i).getName().equals(list_name)) {
                    listIxToBeRemoved = i;
                }
            }
            all_todo_lists.remove(listIxToBeRemoved);
        }catch(Exception e){

        }
    }

    public static void changeItemStatus(String list_name, String item_text) {
        TODOList todoList = getTODOListByItsName(list_name);
        TODOListItem todoListItem = todoList.getTODOListItemByItsName(item_text);
        if (todoListItem.isCompleted())
            todoListItem.setCompleted(false);
        else
            todoListItem.setCompleted(true);
    }

    public static TODOList getTODOListByItsName(String list_name) {
        for (TODOList todoList :
                all_todo_lists) {
            if (todoList.getName().equals(list_name))
                return todoList;
        }
        return null;
    }

    public TODOListItem getTODOListItemByItsName(String item_name) {
        ArrayList<TODOListItem> todoListItems = getItems();
        for (TODOListItem todoListItem :
                todoListItems) {
            if (todoListItem.getText().equals(item_name))
                return todoListItem;
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TODOListItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<TODOListItem> items) {
        this.items = items;
    }

    public static ArrayList<TODOList> getAll_todo_lists() {
        return all_todo_lists;
    }
}
