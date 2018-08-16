package hello;

import hello.todos.TODOList;
import hello.todos.TODOListController;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(Arquillian.class)
public class TODOListControllerTest {
    @org.junit.Test
    public void get_all_todo_lists() throws Exception {
        ArrayList<TODOList> todoLists = TODOList.getAll_todo_lists();
        Assert.assertEquals(todoLists, new ArrayList<TODOList>());
    }

    @org.junit.Test
    public void create_todo_list() throws Exception {
        Assert.assertEquals(TODOList.getAll_todo_lists(), new TODOList("deneme"));

    }

    @org.junit.Test
    public void remove_todo_list() throws Exception {
        new TODOList("deneme_list");
        TODOList.removeTODOList("deneme_list");
        Assert.assertEquals(TODOList.getAll_todo_lists().size(), 0);

    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(TODOListController.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
