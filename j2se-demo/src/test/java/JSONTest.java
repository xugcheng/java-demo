import com.alibaba.fastjson.JSON;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuguocheng on 2017/3/31.
 */
public class JSONTest {

    public static void main(String[] args) {

        A a = new A();
        a.setId(1);
        a.setName("A");

        Response<A> resA = new Response<A>();
        resA.setCode(1);
        resA.setMsg("resA");
        resA.setData(a);

        String jsonA = JSON.toJSONString(resA);
        Type typeA = new ParameterizedTypeImpl(Response.class, new Class[]{A.class});
        Response<A> responseA = JSON.parseObject(jsonA, typeA);

        System.out.println(jsonA);
        System.out.println(JSON.toJSONString(responseA));
        System.out.println(responseA.getData().getName());

        /***************************/

        System.out.println("***************************");

        A a1 = new A();
        a1.setId(11);
        a1.setName("A1");

        List<A> alist = new ArrayList<A>();
        alist.add(a);
        alist.add(a1);

        Response<List<A>> resListA = new Response<List<A>>();
        resListA.setCode(3);
        resListA.setMsg("resListA");
        resListA.setData(alist);

        String jsonListA = JSON.toJSONString(resListA);

        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{A.class});
        Type typeListA = new ParameterizedTypeImpl(Response.class, new Type[]{listType});

        Response<List<A>> responseListA = JSON.parseObject(jsonListA, typeListA);

        System.out.println(jsonListA);
        System.out.println(JSON.toJSONString(responseListA));
        System.out.println(responseListA.getData().get(0).getName());
        System.out.println(responseListA.getData().get(1).getName());

    }
}


