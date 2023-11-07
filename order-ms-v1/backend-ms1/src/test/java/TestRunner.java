import com.intuit.karate.junit4.Karate;
import ma.peps.sqli.bean.core.catalog.Product;
import ma.peps.sqli.service.core.facade.admin.catalog.ProductAdminService;
import ma.peps.sqli.service.core.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.service.core.facade.admin.order.OrderLineAdminService;
import ma.peps.sqli.zynerator.security.bean.Permission;
import ma.peps.sqli.zynerator.security.bean.Role;
import ma.peps.sqli.zynerator.security.bean.User;
import ma.peps.sqli.zynerator.security.common.AuthoritiesConstants;
import ma.peps.sqli.zynerator.security.service.facade.RoleService;
import ma.peps.sqli.zynerator.security.service.facade.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@RunWith(Karate.class)
public class TestRunner {



    private static void addPermissionForAdmin(List<Permission> permissions) {
        permissions.add(new Permission("Product.edit"));
        permissions.add(new Permission("Product.list"));
        permissions.add(new Permission("Product.view"));
        permissions.add(new Permission("Product.add"));
        permissions.add(new Permission("Product.delete"));
        permissions.add(new Permission("OrderStatus.edit"));
        permissions.add(new Permission("OrderStatus.list"));
        permissions.add(new Permission("OrderStatus.view"));
        permissions.add(new Permission("OrderStatus.add"));
        permissions.add(new Permission("OrderStatus.delete"));
        permissions.add(new Permission("ProductCategory.edit"));
        permissions.add(new Permission("ProductCategory.list"));
        permissions.add(new Permission("ProductCategory.view"));
        permissions.add(new Permission("ProductCategory.add"));
        permissions.add(new Permission("ProductCategory.delete"));
        permissions.add(new Permission("OrderBoutique.edit"));
        permissions.add(new Permission("OrderBoutique.list"));
        permissions.add(new Permission("OrderBoutique.view"));
        permissions.add(new Permission("OrderBoutique.add"));
        permissions.add(new Permission("OrderBoutique.delete"));
        permissions.add(new Permission("OrderLine.edit"));
        permissions.add(new Permission("OrderLine.list"));
        permissions.add(new Permission("OrderLine.view"));
        permissions.add(new Permission("OrderLine.add"));
        permissions.add(new Permission("OrderLine.delete"));
    }

}
