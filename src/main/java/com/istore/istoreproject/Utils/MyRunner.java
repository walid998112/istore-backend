package com.istore.istoreproject.Utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.istore.istoreproject.Requests.RegisterRequest;
import com.istore.istoreproject.Services.CategoryService;
import com.istore.istoreproject.Services.ConnectivityService;
import com.istore.istoreproject.Services.UserService;
import com.istore.istoreproject.models.Category;
import com.istore.istoreproject.models.Connectivity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {

    private final UserService userService;
    private final CategoryService categoryService;
    private final ConnectivityService connectivityService;

    @Override
    public void run(String... args) throws Exception {

        RegisterRequest user = new RegisterRequest();
        user.setUsername("admin");
        user.setEmail("walidouahrani69@gmail.com");
        user.setPassword("123456789");

        userService.createAdmin(user);


/*        Category category1 = new Category();
        category1.setName("IPHONE 15");
        categoryService.addCategory(category1);

                Category category2 = new Category();
        category2.setName("IPHONE 15 PRO");
        categoryService.addCategory(category2);

                Category category3 = new Category();
        category3.setName("IPHONE 15 PRO MAX");
        categoryService.addCategory(category3);


                Category category4 = new Category();
        category4.setName("IPHONE 14");
        categoryService.addCategory(category4);


                Category category5 = new Category();
        category5.setName("IPHONE 14 PRO");
        categoryService.addCategory(category5);


                Category category6 = new Category();
        category6.setName("IPHONE 14 PRO MAX");
        categoryService.addCategory(category6);


                Category category7 = new Category();
        category7.setName("IPHONE 13");
        categoryService.addCategory(category7);

                        Category category8 = new Category();
        category8.setName("IPHONE 11");
        categoryService.addCategory(category8);

                        Category category9 = new Category();
        category9.setName("IPHONE SE");
        categoryService.addCategory(category9);

        Category category10 = new Category();
        category10.setName("IPAD MINI");
        categoryService.addCategory(category10);

        Category category11 = new Category();
        category11.setName("IPAD 9th");
        categoryService.addCategory(category11);
        
        Category category12 = new Category();
        category12.setName("IPAD AIR 5");
        categoryService.addCategory(category12);
        
        Category category13 = new Category();
        category13.setName("IPAD PRO 11\"");
        categoryService.addCategory(category13);

        Category category14 = new Category();
        category14.setName("IPAD PRO 12.9\"");
        categoryService.addCategory(category14);


        Category category15 = new Category();
        category15.setName("MacBook Air 13\"");
        categoryService.addCategory(category15);


        Category category16 = new Category();
        category16.setName("MacBook Air 15\"");
        categoryService.addCategory(category16);


        Category category17 = new Category();
        category17.setName("MacBook Pro 13\"");
        categoryService.addCategory(category17);


        Category category18 = new Category();
        category18.setName("MacBook Pro 14\"");
        categoryService.addCategory(category18);

        Category category19 = new Category();
        category19.setName("MacBook Pro 16\"");
        categoryService.addCategory(category19);



        Connectivity connectivity = new Connectivity();
        connectivity.setOption("WIFI");

        connectivityService.add(connectivity);

        Connectivity connectivity1 = new Connectivity();
        connectivity1.setOption("bluetooth");

        connectivityService.add(connectivity1);

        Connectivity connectivity2 = new Connectivity();
        connectivity2.setOption("Cellular");

        connectivityService.add(connectivity2); */
 /*   Category category20 = new Category();
        category20.setName("Mac studio");
        categoryService.addCategory(category20);

        Category category21 = new Category();
        category21.setName("Mac Mini");
        categoryService.addCategory(category21);

        Category category22 = new Category();
        category22.setName("Imac 24");
        categoryService.addCategory(category22);  */



    }

}
