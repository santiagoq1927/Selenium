package pages;

import java.util.List;

public class PaginaRegistroPlan extends BasePage{

    private String planDropDown ="//select[@id='cart_cart_item_attributes_plan_with_interval']";

    public PaginaRegistroPlan(){
        super(driver);
    }

    public List<String> returnPlanDropDown(){
        return getDropDownValues(planDropDown);
    }
    
}
