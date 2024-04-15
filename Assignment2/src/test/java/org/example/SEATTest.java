package org.example;
import org.example.fa.training.entity.SEAT;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SEATTest {
    private Validator validator;
    @Before
    public void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDescriptionNotEmptyConstraint(){
        // tao doi tuong cho SEAT rong
        SEAT seat = new SEAT();
        seat.setSeat_status("'Available");
        seat.setSeat_type("VIP");
        // Kiểm tra các ràng buộc trên đối tượng
        Set<ConstraintViolation<SEAT>> violations = validator.validate(seat);
        // Kiểm tra xem danh sách các thông báo lỗi có ít nhất một phần tử hay không
        Assert.assertFalse(violations.isEmpty());
        // Kiểm tra xem thông báo lỗi có chứa thông báo mong đợi hay không
        boolean containsExpectedMessage = false;
        for (ConstraintViolation<SEAT> violation : violations) {
            if ("SEAT must not be empty".equals(violation.getMessage())){
                containsExpectedMessage = true;
                break;
            }
        }
    }
}
