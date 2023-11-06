package Tests;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class LocalHostTestRunner {


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "localhost");
    }

    @Karate.Test
    Karate HappyOrder(){
        return Karate.run("HappyOrderTest").tags("FindAll").relativeTo(getClass());
    }

//    @Bean
//    public CommandLineRunner demo(UserService userService, RoleService roleService, OrderBoutiqueAdminService orderAdminService, OrderLineAdminService orderLineAdminService, ProductAdminService productAdminService) {
//        return (args) -> {
//            orderLineAdminService.deleteAll();
//            orderAdminService.deleteAll();
//            if (false) {
//
//
//                // Role admin
//
//                User userForAdmin = new User("admin");
//
//                Role roleForAdmin = new Role();
//                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
//                List<Permission> permissionsForAdmin = new ArrayList<>();
//                addPermissionForAdmin(permissionsForAdmin);
//                roleForAdmin.setPermissions(permissionsForAdmin);
//                if (userForAdmin.getRoles() == null)
//                    userForAdmin.setRoles(new ArrayList<>());
//
//                userForAdmin.getRoles().add(roleForAdmin);
//                userService.save(userForAdmin);
//
//                Product product1 = new Product();
//                product1.setCode("p1");
//                product1.setLibelle("p1");
//                productAdminService.create(product1);
//
//                Product product2 = new Product();
//                product2.setCode("p2");
//                product2.setLibelle("p2");
//                productAdminService.create(product2);
//
//
//            }
//        };
//    }
//
//    private static void addPermissionForAdmin(List<Permission> permissions) {
//        permissions.add(new Permission("Product.edit"));
//        permissions.add(new Permission("Product.list"));
//        permissions.add(new Permission("Product.view"));
//        permissions.add(new Permission("Product.add"));
//        permissions.add(new Permission("Product.delete"));
//        permissions.add(new Permission("OrderStatus.edit"));
//        permissions.add(new Permission("OrderStatus.list"));
//        permissions.add(new Permission("OrderStatus.view"));
//        permissions.add(new Permission("OrderStatus.add"));
//        permissions.add(new Permission("OrderStatus.delete"));
//        permissions.add(new Permission("ProductCategory.edit"));
//        permissions.add(new Permission("ProductCategory.list"));
//        permissions.add(new Permission("ProductCategory.view"));
//        permissions.add(new Permission("ProductCategory.add"));
//        permissions.add(new Permission("ProductCategory.delete"));
//        permissions.add(new Permission("OrderBoutique.edit"));
//        permissions.add(new Permission("OrderBoutique.list"));
//        permissions.add(new Permission("OrderBoutique.view"));
//        permissions.add(new Permission("OrderBoutique.add"));
//        permissions.add(new Permission("OrderBoutique.delete"));
//        permissions.add(new Permission("OrderLine.edit"));
//        permissions.add(new Permission("OrderLine.list"));
//        permissions.add(new Permission("OrderLine.view"));
//        permissions.add(new Permission("OrderLine.add"));
//        permissions.add(new Permission("OrderLine.delete"));
//    }

}
