package com.xugc.demo.serialize;

import com.google.gson.Gson;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuguocheng on 2017/3/31.
 */
public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();

        A a = new A();
        a.setId(1);
        a.setName("com.xugc.demo.serialize.A");

        Response<A> resA = new Response<A>();
        resA.setCode(1);
        resA.setMsg("resA");
        resA.setData(a);

        String jsonA = gson.toJson(resA);
        Type typeA = new ParameterizedTypeImpl(Response.class, new Class[]{A.class});
        Response<A> responseA = gson.fromJson(jsonA, typeA);

        System.out.println(jsonA);
        System.out.println(gson.toJson(responseA));
        System.out.println(responseA.getData().getId());

        /***************************/

        System.out.println("***************************");

        B b = new B();
        b.setId(2);
        b.setAddress("深圳");

        Response<B> resB = new Response<B>();
        resB.setCode(2);
        resB.setMsg("resB");
        resB.setData(b);

        String jsonB = gson.toJson(resB);
        Type typeB = new ParameterizedTypeImpl(Response.class, new Class[]{B.class});
        Response<B> responseB = gson.fromJson(jsonB, typeB);
        System.out.println(jsonB);
        System.out.println(gson.toJson(responseB));
        System.out.println(responseB.getData().getId());

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

        String jsonListA = gson.toJson(resListA);

        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{A.class});
        Type typeListA = new ParameterizedTypeImpl(Response.class, new Type[]{listType});
        Response<List<A>> responseListA = gson.fromJson(jsonListA, typeListA);

        System.out.println(jsonListA);
        System.out.println(gson.toJson(responseListA));
        System.out.println(responseListA.getData().get(0).getName());
        System.out.println(responseListA.getData().get(1).getName());

    }


}