package BrandTest;
import Shop.Brand;
import org.junit.Test;
import user.*;

import java.util.List;

public class BrandTest {
    @Test
    public void selectAllTest() throws Exception {
        List<Brand> ls = user.UserFunc.SelectAll();
        for (Brand brand : ls){
            System.out.println(brand);
        }
    }
    @Test
    public void modifyTest() throws Exception{
        String sql = "update tb_brand set ordered = 57 where brand_name = '小米'";
        int num = user.UserFunc.modify(sql);
        System.out.println(num);
    }
}
